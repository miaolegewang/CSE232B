// Generated from edu/ucsd/antlrxpath/antlrxpath/XPath.g4 by ANTLR 4.3
package edu.ucsd.antlrxpath.antlrxpath;
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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, FNAME=8, SLASH=9, 
		DSLASH=10, CONCAT=11, ValueEq=12, IDEq=13, AND=14, OR=15, ASTERISK=16, 
		DOT=17, UPPER=18, NAME=19, TEXTFUNCTION=20, NOT=21;
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
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "FNAME", "SLASH", 
		"DSLASH", "CONCAT", "ValueEq", "IDEq", "AND", "OR", "ASTERISK", "DOT", 
		"UPPER", "NAME", "TEXTFUNCTION", "NOT"
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
		"\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\6\tB\n\t\r\t\16\tC"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\5\rU\n"+
		"\r\3\16\3\16\3\16\3\16\5\16[\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\6\24l\n\24\r\24\16\24m\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27\3\2\4\7\2))\60;C\\aac|\5\2\62;C\\c|}\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\65\3\2\2\2\t8\3\2"+
		"\2\2\13:\3\2\2\2\r<\3\2\2\2\17>\3\2\2\2\21A\3\2\2\2\23J\3\2\2\2\25L\3"+
		"\2\2\2\27O\3\2\2\2\31T\3\2\2\2\33Z\3\2\2\2\35\\\3\2\2\2\37`\3\2\2\2!c"+
		"\3\2\2\2#e\3\2\2\2%g\3\2\2\2\'k\3\2\2\2)o\3\2\2\2+v\3\2\2\2-.\7B\2\2."+
		"\4\3\2\2\2/\60\7f\2\2\60\61\7q\2\2\61\62\7e\2\2\62\63\7*\2\2\63\64\7$"+
		"\2\2\64\6\3\2\2\2\65\66\7$\2\2\66\67\7+\2\2\67\b\3\2\2\289\7*\2\29\n\3"+
		"\2\2\2:;\7+\2\2;\f\3\2\2\2<=\7]\2\2=\16\3\2\2\2>?\7_\2\2?\20\3\2\2\2@"+
		"B\t\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\60\2\2"+
		"FG\7z\2\2GH\7o\2\2HI\7n\2\2I\22\3\2\2\2JK\7\61\2\2K\24\3\2\2\2LM\7\61"+
		"\2\2MN\7\61\2\2N\26\3\2\2\2OP\7.\2\2P\30\3\2\2\2QU\7?\2\2RS\7g\2\2SU\7"+
		"s\2\2TQ\3\2\2\2TR\3\2\2\2U\32\3\2\2\2VW\7?\2\2W[\7?\2\2XY\7k\2\2Y[\7u"+
		"\2\2ZV\3\2\2\2ZX\3\2\2\2[\34\3\2\2\2\\]\7c\2\2]^\7p\2\2^_\7f\2\2_\36\3"+
		"\2\2\2`a\7q\2\2ab\7t\2\2b \3\2\2\2cd\7,\2\2d\"\3\2\2\2ef\7\60\2\2f$\3"+
		"\2\2\2gh\7\60\2\2hi\7\60\2\2i&\3\2\2\2jl\t\3\2\2kj\3\2\2\2lm\3\2\2\2m"+
		"k\3\2\2\2mn\3\2\2\2n(\3\2\2\2op\7v\2\2pq\7g\2\2qr\7z\2\2rs\7v\2\2st\7"+
		"*\2\2tu\7+\2\2u*\3\2\2\2vw\7p\2\2wx\7q\2\2xy\7v\2\2y,\3\2\2\2\7\2CTZm"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}