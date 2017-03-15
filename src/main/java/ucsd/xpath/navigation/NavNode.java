package ucsd.xpath.navigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavNode {
	
	// 3 types of node
	static public int ROOT_NODE = 0;
	static public int VARIABLE_NODE = 1;
	static public int CONSTANT_NODE = 2;
	
	
	private int _type;
	private HashMap<String, NavNode> _children;
	private List<NavNode> _cond;
	private NavNode _root;
	private String _edge;
	private String _value;
	
	
	/*
	 * =========================
	 * Constructor
	 * =========================
	 */
	public NavNode(int type, String value){	
		this._type = type;
		this._value = value;
		this._children = new HashMap<>();
		this._cond = new ArrayList<>();
	}
	
	public NavNode(int type, String value, String edge){
		this._type = type;
		this._value = value;
		this._edge = edge;
		this._children = new HashMap<>();
		this._cond = new ArrayList<>();
	}
	
	/*
	 * =========================
	 * Accessor
	 * =========================
	 */
	
	public String getName(){
		return this._value;
	}
	
	public int type(){
		return this._type;
	}
	
	public NavNode root(){
		return this._root;
	}
	
	public NavNode getChild(String name){
		return _children.getOrDefault(name, null);
	}
	
	public String edge(){
		return this._edge;
	}
	
	public List<NavNode> condition(){
		return this._cond;
	}
	
	/*
	 * =========================
	 * Modifier
	 * =========================
	 */
	public void addChild(String name, NavNode node){
		node.setRoot(this._root);
		this._children.put(name, node);
	}
	
	public void setEdge(String edge){
		this._edge = edge;
	}
	
	public void addCond(NavNode node){
		this._cond.add(node);
	}
	
	public void setRoot(NavNode node){
		this._root = node;
	}
}
