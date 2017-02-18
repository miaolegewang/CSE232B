// Generated from ucsd/xpath/evaluator/XPath.g4 by ANTLR 4.3
package ucsd.xpath.evaluator;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, NOT=8, AND=9, 
		OR=10, TEXTFUNCTION=11, FNAME=12, SLASH=13, DSLASH=14, CONCAT=15, ValueEq=16, 
		IDEq=17, ASTERISK=18, DOT=19, UPPER=20, NAME=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "NOT", "AND", 
		"OR", "TEXTFUNCTION", "FNAME", "SLASH", "DSLASH", "CONCAT", "ValueEq", 
		"IDEq", "ASTERISK", "DOT", "UPPER", "NAME"
	};


	public XPathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\6\rT\n\r\r\r\16"+
		"\rU\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\5\21g\n\21\3\22\3\22\3\22\3\22\5\22m\n\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\6\26w\n\26\r\26\16\26x\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27\3\2\4\7\2))\60;C\\aac|\5\2\62;C\\c|}\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\65\3\2\2\2\t8\3\2\2\2\13"+
		":\3\2\2\2\r<\3\2\2\2\17>\3\2\2\2\21@\3\2\2\2\23D\3\2\2\2\25H\3\2\2\2\27"+
		"K\3\2\2\2\31S\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37a\3\2\2\2!f\3\2\2\2#"+
		"l\3\2\2\2%n\3\2\2\2\'p\3\2\2\2)r\3\2\2\2+v\3\2\2\2-.\7B\2\2.\4\3\2\2\2"+
		"/\60\7f\2\2\60\61\7q\2\2\61\62\7e\2\2\62\63\7*\2\2\63\64\7$\2\2\64\6\3"+
		"\2\2\2\65\66\7$\2\2\66\67\7+\2\2\67\b\3\2\2\289\7*\2\29\n\3\2\2\2:;\7"+
		"+\2\2;\f\3\2\2\2<=\7]\2\2=\16\3\2\2\2>?\7_\2\2?\20\3\2\2\2@A\7p\2\2AB"+
		"\7q\2\2BC\7v\2\2C\22\3\2\2\2DE\7c\2\2EF\7p\2\2FG\7f\2\2G\24\3\2\2\2HI"+
		"\7q\2\2IJ\7t\2\2J\26\3\2\2\2KL\7v\2\2LM\7g\2\2MN\7z\2\2NO\7v\2\2OP\7*"+
		"\2\2PQ\7+\2\2Q\30\3\2\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3"+
		"\2\2\2VW\3\2\2\2WX\7\60\2\2XY\7z\2\2YZ\7o\2\2Z[\7n\2\2[\32\3\2\2\2\\]"+
		"\7\61\2\2]\34\3\2\2\2^_\7\61\2\2_`\7\61\2\2`\36\3\2\2\2ab\7.\2\2b \3\2"+
		"\2\2cg\7?\2\2de\7g\2\2eg\7s\2\2fc\3\2\2\2fd\3\2\2\2g\"\3\2\2\2hi\7?\2"+
		"\2im\7?\2\2jk\7k\2\2km\7u\2\2lh\3\2\2\2lj\3\2\2\2m$\3\2\2\2no\7,\2\2o"+
		"&\3\2\2\2pq\7\60\2\2q(\3\2\2\2rs\7\60\2\2st\7\60\2\2t*\3\2\2\2uw\t\3\2"+
		"\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y,\3\2\2\2\7\2Uflx\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}