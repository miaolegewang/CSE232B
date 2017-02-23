package ucsd.xpath.evaluator;

import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Node;

public class XQueryEval {
	public List<Node> parse(String queryAsString){
		ANTLRInputStream input = new ANTLRInputStream(queryAsString);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        parser.removeErrorListeners();
                
        ParseTree tree = parser.xquery();
        EvalVisitor evalVisitor = new EvalVisitor();
                
        return null;
	}
}
