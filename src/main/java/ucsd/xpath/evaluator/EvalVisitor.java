package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ucsd.xpath.evaluator.XQueryParser.BindContext;

public class EvalVisitor extends XQueryBaseVisitor<List<Node>>{
	
	List<Node> temp = new ArrayList<Node>();
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitFlwr(@NotNull XQueryParser.FlwrContext ctx) {
		HashMap<String, Integer> level = new HashMap<String, Integer>();
		List<Node> result = new ArrayList<Node>();
		Integer counter = 0;
		for(BindContext bind: ctx.forClause().bindings().bind()){
			level.put(bind.var().varName().getText(), counter);
			counter++;
		}
		List<Integer> pointers = new ArrayList<Integer>(0);
		List<List<Node>> nodes = new ArrayList<List<Node>>();
		
		// Initialize each of the lists
		nodes.add(visit(ctx.forClause().bindings().bind(0).query()));
		for(int i = 1; i < counter; i++){
			List<Node> old = new ArrayList<Node>(temp);
			temp.clear();
			temp.add(nodes[i - 1][0]);
			nodes.add(visit())
		}
	}
}
