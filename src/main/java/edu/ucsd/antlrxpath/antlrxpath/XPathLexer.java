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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, Filename=16, NAME=17, 
		ValueEq=18, IDEq=19, AND=20, OR=21;
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
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Filename", "NAME", "ValueEq", 
		"IDEq", "AND", "OR"
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
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\6\21[\n\21\r\21\16\21\\\3\21\3\21\3\21\3\21\3\21"+
		"\3\22\6\22e\n\22\r\22\16\22f\3\23\3\23\3\23\5\23l\n\23\3\24\3\24\3\24"+
		"\3\24\5\24r\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\2\2\27\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27\3\2\4\7\2))\60;C\\aac|\5\2\62;C\\c|}\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\65\3\2\2\2\t"+
		"<\3\2\2\2\13>\3\2\2\2\rA\3\2\2\2\17D\3\2\2\2\21F\3\2\2\2\23H\3\2\2\2\25"+
		"K\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2\33Q\3\2\2\2\35U\3\2\2\2\37W\3\2\2\2"+
		"!Z\3\2\2\2#d\3\2\2\2%k\3\2\2\2\'q\3\2\2\2)s\3\2\2\2+w\3\2\2\2-.\7\61\2"+
		"\2.\4\3\2\2\2/\60\7f\2\2\60\61\7q\2\2\61\62\7e\2\2\62\63\7*\2\2\63\64"+
		"\7$\2\2\64\6\3\2\2\2\65\66\7v\2\2\66\67\7g\2\2\678\7z\2\289\7v\2\29:\7"+
		"*\2\2:;\7+\2\2;\b\3\2\2\2<=\7]\2\2=\n\3\2\2\2>?\7\60\2\2?@\7\60\2\2@\f"+
		"\3\2\2\2AB\7\61\2\2BC\7\61\2\2C\16\3\2\2\2DE\7_\2\2E\20\3\2\2\2FG\7B\2"+
		"\2G\22\3\2\2\2HI\7$\2\2IJ\7+\2\2J\24\3\2\2\2KL\7*\2\2L\26\3\2\2\2MN\7"+
		"+\2\2N\30\3\2\2\2OP\7,\2\2P\32\3\2\2\2QR\7p\2\2RS\7q\2\2ST\7v\2\2T\34"+
		"\3\2\2\2UV\7.\2\2V\36\3\2\2\2WX\7\60\2\2X \3\2\2\2Y[\t\2\2\2ZY\3\2\2\2"+
		"[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^_\7\60\2\2_`\7z\2\2`a\7o\2"+
		"\2ab\7n\2\2b\"\3\2\2\2ce\t\3\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2"+
		"\2g$\3\2\2\2hl\7?\2\2ij\7g\2\2jl\7s\2\2kh\3\2\2\2ki\3\2\2\2l&\3\2\2\2"+
		"mn\7?\2\2nr\7?\2\2op\7k\2\2pr\7u\2\2qm\3\2\2\2qo\3\2\2\2r(\3\2\2\2st\7"+
		"c\2\2tu\7p\2\2uv\7f\2\2v*\3\2\2\2wx\7q\2\2xy\7t\2\2y,\3\2\2\2\7\2\\fk"+
		"q\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}