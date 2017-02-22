package ucsd.xpath.evaluator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EvalVisitor extends XQueryBaseVisitor<List<Node>>{
	HashMap<String, String> binding;
	HashMap<String, List<Node>> store;
	
	/*
	 * tempStore is used for temporary store for variables
	 */
	List<Node> tempStore;
	
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public List<Node> visitSl(@NotNull XQueryParser.SlContext ctx) {
		List<Node> tmp = new ArrayList<Node>(tempStore);
		tempStore.clear();
		for(int i = 0; i < tmp.size(); i++){
			NodeList children = tmp.get(i).getChildNodes();
			for(int j = 0; j < children.getLength(); j++){
				tempStore.add(children.item(j));
			}
		}
		return null;
	}
}
