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
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, Filename=22, TagName=23, 
		AttName=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'"
	};
	public static final String[] ruleNames = {
		"T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", 
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "Filename", "TagName", "AttName"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u0085\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\6\27s\n\27\r\27\16\27t\3\27\3\27\3\27\3\27\3\27\3\30\6\30}\n\30"+
		"\r\30\16\30~\3\31\6\31\u0082\n\31\r\31\16\31\u0083\2\2\32\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\3\2\4\7\2))\60;C\\aac|\5\2\62;C\\c|\u0087"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\3\63\3\2\2\2\5\65\3\2\2\2\7;\3\2\2\2\tB\3\2\2\2\13D\3"+
		"\2\2\2\rG\3\2\2\2\17J\3\2\2\2\21M\3\2\2\2\23O\3\2\2\2\25Q\3\2\2\2\27T"+
		"\3\2\2\2\31V\3\2\2\2\33Y\3\2\2\2\35\\\3\2\2\2\37^\3\2\2\2!a\3\2\2\2#c"+
		"\3\2\2\2%g\3\2\2\2\'i\3\2\2\2)m\3\2\2\2+o\3\2\2\2-r\3\2\2\2/|\3\2\2\2"+
		"\61\u0081\3\2\2\2\63\64\7\61\2\2\64\4\3\2\2\2\65\66\7f\2\2\66\67\7q\2"+
		"\2\678\7e\2\289\7*\2\29:\7$\2\2:\6\3\2\2\2;<\7v\2\2<=\7g\2\2=>\7z\2\2"+
		">?\7v\2\2?@\7*\2\2@A\7+\2\2A\b\3\2\2\2BC\7]\2\2C\n\3\2\2\2DE\7?\2\2EF"+
		"\7?\2\2F\f\3\2\2\2GH\7\60\2\2HI\7\60\2\2I\16\3\2\2\2JK\7\61\2\2KL\7\61"+
		"\2\2L\20\3\2\2\2MN\7?\2\2N\22\3\2\2\2OP\7_\2\2P\24\3\2\2\2QR\7q\2\2RS"+
		"\7t\2\2S\26\3\2\2\2TU\7B\2\2U\30\3\2\2\2VW\7$\2\2WX\7+\2\2X\32\3\2\2\2"+
		"YZ\7g\2\2Z[\7s\2\2[\34\3\2\2\2\\]\7*\2\2]\36\3\2\2\2^_\7k\2\2_`\7u\2\2"+
		"` \3\2\2\2ab\7+\2\2b\"\3\2\2\2cd\7c\2\2de\7p\2\2ef\7f\2\2f$\3\2\2\2gh"+
		"\7,\2\2h&\3\2\2\2ij\7p\2\2jk\7q\2\2kl\7v\2\2l(\3\2\2\2mn\7.\2\2n*\3\2"+
		"\2\2op\7\60\2\2p,\3\2\2\2qs\t\2\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3"+
		"\2\2\2uv\3\2\2\2vw\7\60\2\2wx\7z\2\2xy\7o\2\2yz\7n\2\2z.\3\2\2\2{}\t\3"+
		"\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\60\3\2\2\2\u0080\u0082"+
		"\t\3\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\62\3\2\2\2\6\2t~\u0083\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}