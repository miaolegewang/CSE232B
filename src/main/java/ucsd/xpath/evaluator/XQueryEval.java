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
        return evalVisitor.visit(tree);
	}

	public String rewrite(String queryAsString){
		ANTLRInputStream input = new ANTLRInputStream(queryAsString);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        parser.removeErrorListeners();
        
        ParseTree tree = parser.xquery();
        RewriteVisitor rewrite = new RewriteVisitor();
        return rewrite.visit(tree);
	}
	
	public List<Node> optimize(String queryAsString){
		ANTLRInputStream input = new ANTLRInputStream(queryAsString);
        XQueryLexer lexer = new XQueryLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        parser.removeErrorListeners();
        
        ParseTree tree = parser.xquery();
        RewriteVisitor reVisitor = new RewriteVisitor();
        String rewritten = reVisitor.visit(tree);
        if(!rewritten.isEmpty()){
        	input = new ANTLRInputStream(rewritten);
            lexer = new XQueryLexer(input);
            tokens = new CommonTokenStream(lexer);
            parser = new XQueryParser(tokens);
            parser.removeErrorListeners();
            tree = parser.xquery();
        }
        EvalVisitor evalVisitor = new EvalVisitor();
        return evalVisitor.visit(tree);
	}
}
