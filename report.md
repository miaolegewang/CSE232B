## Milestone 3 Report
This report will mainly talk about the implementation of join operator and algorithm to detect a join from the FLWR expression.
#### 1. Join Implementation
The Join function signature is `join([XQuery1, XQuery2, [attr1], [attr2])`. We use hash join algorithm to implement join operator. We define a function `printXMLNode` which prints out a xml node and all of its descendants along with the attributes as a string. The way we use the HashMap is that for each node we retrieve the corresponding attributes and create a new xml node for each attribute, then create a extra xml node to contain all these nodes. After that we use `printXMLNode` to produce a String as our hash key. In the HashMap, we store the XML nodes from the result into a list as the value of HashMap. The algorithm is as following:
1. Evaluate both xqueries, choose the list of results with less total number to hash.
2. Then we loop through the other list of results. When the key of one node exists in the HashMap, we pair up this node with each of the node in the list.
3. For each of the pair in the resulting list, we retrieve all the children nodes(attribute node is not a child node) from both nodes and create a new XML node with the tag name `tuple` to be the parent of those children nodes. Since the order of two xquery does not matter, we just retrieve the nodes from one by another.
4. return all the XML nodes from last step.

Since each attributes are actually the text nodes which are the leaves of the XML tree, the time complexity of printing out the parent node is O(2c) where c is the number of attributes joined on. Since it takes constant time in average to search a key in HashMap, the time complexity is O((m + n)c) where m is the size of the results evaluating Xquery1 and n is the size of results evaluating Xquery2.

#### 2. Join detection
To detect a join operation from FWR clause, we implement a different parse tree visitor to detect a join operation and rewrite the original query.
We start with the for clause by creating a new structure called Navigation Tree Node(NavNode) to store a variable, its child variables and all the conditions associated with this variable. In such way, the variable binded to an xpath will be the root of a navigation tree. After iterating all the variable bindings in a for clause, we will create several (or just one) navigation trees. If there's only one navigation tree, then there's no join and the visitor will just return `null`. For each navigation tree, we want to rewrite it into a for loop that returns a tuple containing all the variables.

Then it comes to the where clause. It will loop through all the conditions. If one side of the equality is a constant string, this equality should happen inside the for loop. We store this equality inside the navigation tree node. If both sides are variables, we will check whether their roots are the same. If roots are the same, then it's a self-join which won't be implemented in this milestone so we will just store this equality inside the navigation tree as a filter. Otherwise, it's a join equality and we will stores these two attributes into a list.


Finally when the visitor visits the return clause. The visitor mainly follows the five steps when visiting the return clause:

1. Rewrite the navigation tree into a FWR clause which returns a tuple containing all the variables node in the tree.
2. For each join equality, we retrieve the roots of both variables in the navigation tree. In this way, for each pair of root, we will obtain a list of attributes to join on.
3. We regard each navigation tree as a connected component. Now we apply the union-find algorithm with respect to the pair of roots we obtained above to join the connected components by putting the XQueries of both into one join clause.
4. We also need to handle the cartesian product case. A cartesian product occurs when there's still more than 1 connected components in the graph. Then we join these connected components one by one by producing a join clause with empty attribute list. Using this algorithm, we are able to handle multiple joins.
5. For the return clause, it replace each of the variables with certain pattern, for example`$a`, with `$tuple/a/*`.
