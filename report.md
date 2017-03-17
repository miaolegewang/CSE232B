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
Since we are told not to detect self-join, it's obvious that if there's only one absolute path existing, then there's no join. That is to say, the number of joins is equal to the number of absolute paths minus 1. In addition, a cartesian product can be regarded as a join without any attributes. Since each of the variables in the for loop is either binded to a ndoe in the xpath or a node in a relative path leading by other variable, if we consider the binding as an edge between two variables, then it's clear that for each absolute path there's a variable tree where the children of a node are binded through `Var Seq Path` pattern to the parent and the root of the variable tree is the variable directly binded to the Xpath. Also in the `where` clause, each of the condition can be thought as a different kind of edge between two nodes, either variable node or constant node. In that sense, any two connected components in this graph will be considered as a cartesian product and in any connected components, any two trees that are connected can be thought as a join on those condition edge. So we write a new visitor class to detect whether there's a join in the query. If there's a join, then we rewrite the query into join query to start evaluating. Otherwise, we stick with the original query. First of all, we define our tree structure called Navigation Tree Node:
```
NavNode{
   NavNode root;
   String name;
   HashMap<key, NavNode> children;
   int type;
   List<NavNode> equality;
}
```
where the key of HashMap is the name of the variables binded to this variable and `equality` stores the conditions where the variable node is on left hand side.

The algorithm rewriting the query is as the following:
1. Parse the original query
2. For each variable binding in the for loop, if it's binded directly to a Xpath, we create a navigation node of it and store it into a HashMap where the key is the name of the variable and the value is an integer representing the id of the connected component it is in.
