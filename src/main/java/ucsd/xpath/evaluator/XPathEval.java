package ucsd.xpath.evaluator;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Node;

public class XPathEval {
	public List<Node> parse(String queryAsString){
		ANTLRInputStream input = new ANTLRInputStream(queryAsString);
        XPathLexer lexer = new XPathLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        parser.removeErrorListeners();
        
        ParseTree tree = parser.xquery();
        EvalVisitor evalVisitor = new EvalVisitor();
        return null;
	}
}
