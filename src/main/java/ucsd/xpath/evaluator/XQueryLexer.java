// Generated from ucsd/xpath/evaluator/XQuery.g4 by ANTLR 4.3
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
public class XQueryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, NOT=14, AND=15, OR=16, TEXTFUNCTION=17, 
		FNAME=18, SLASH=19, DSLASH=20, CONCAT=21, ValueEq=22, IDEq=23, ASTERISK=24, 
		DOT=25, UPPER=26, RETURN=27, FOR=28, IN=29, LET=30, ASSIGN=31, WHERE=32, 
		SOME=33, EMPTY=34, SATISFIES=35, FILENAME=36, STR=37, NAME=38, WHITESPACES=39;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "NOT", "AND", "OR", "TEXTFUNCTION", "FNAME", 
		"SLASH", "DSLASH", "CONCAT", "ValueEq", "IDEq", "ASTERISK", "DOT", "UPPER", 
		"RETURN", "FOR", "IN", "LET", "ASSIGN", "WHERE", "SOME", "EMPTY", "SATISFIES", 
		"FILENAME", "STR", "NAME", "WHITESPACES"
	};


	public XQueryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2)\u00fd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\6\23\u008b\n\23\r\23\16\23\u008c\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\5\27\u009e"+
		"\n\27\3\30\3\30\3\30\3\30\5\30\u00a4\n\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\6%\u00df\n%\r"+
		"%\16%\u00e0\3%\3%\3%\3%\3%\3%\3&\3&\7&\u00eb\n&\f&\16&\u00ee\13&\3&\3"+
		"&\3\'\6\'\u00f3\n\'\r\'\16\'\u00f4\3(\6(\u00f8\n(\r(\16(\u00f9\3(\3(\2"+
		"\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)\3\2\6\7\2))\60;C\\aac|\6\2\62;C\\aac|\3\2$"+
		"$\5\2\13\f\17\17\"\"\u0103\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\3Q\3\2\2\2\5T\3\2\2\2\7V\3\2\2\2\tX\3\2\2\2\13]\3\2\2\2\r_\3\2\2\2\17"+
		"a\3\2\2\2\21c\3\2\2\2\23e\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2\31k\3\2\2\2"+
		"\33u\3\2\2\2\35w\3\2\2\2\37{\3\2\2\2!\177\3\2\2\2#\u0082\3\2\2\2%\u008a"+
		"\3\2\2\2\'\u0093\3\2\2\2)\u0095\3\2\2\2+\u0098\3\2\2\2-\u009d\3\2\2\2"+
		"/\u00a3\3\2\2\2\61\u00a5\3\2\2\2\63\u00a7\3\2\2\2\65\u00a9\3\2\2\2\67"+
		"\u00ac\3\2\2\29\u00b3\3\2\2\2;\u00b7\3\2\2\2=\u00ba\3\2\2\2?\u00be\3\2"+
		"\2\2A\u00c1\3\2\2\2C\u00c7\3\2\2\2E\u00cc\3\2\2\2G\u00d2\3\2\2\2I\u00dc"+
		"\3\2\2\2K\u00e8\3\2\2\2M\u00f2\3\2\2\2O\u00f7\3\2\2\2QR\7>\2\2RS\7\61"+
		"\2\2S\4\3\2\2\2TU\7]\2\2U\6\3\2\2\2VW\7}\2\2W\b\3\2\2\2XY\7f\2\2YZ\7q"+
		"\2\2Z[\7e\2\2[\\\7*\2\2\\\n\3\2\2\2]^\7>\2\2^\f\3\2\2\2_`\7_\2\2`\16\3"+
		"\2\2\2ab\7\177\2\2b\20\3\2\2\2cd\7@\2\2d\22\3\2\2\2ef\7B\2\2f\24\3\2\2"+
		"\2gh\7&\2\2h\26\3\2\2\2ij\7*\2\2j\30\3\2\2\2kl\7f\2\2lm\7q\2\2mn\7e\2"+
		"\2no\7w\2\2op\7o\2\2pq\7g\2\2qr\7p\2\2rs\7v\2\2st\7*\2\2t\32\3\2\2\2u"+
		"v\7+\2\2v\34\3\2\2\2wx\7p\2\2xy\7q\2\2yz\7v\2\2z\36\3\2\2\2{|\7c\2\2|"+
		"}\7p\2\2}~\7f\2\2~ \3\2\2\2\177\u0080\7q\2\2\u0080\u0081\7t\2\2\u0081"+
		"\"\3\2\2\2\u0082\u0083\7v\2\2\u0083\u0084\7g\2\2\u0084\u0085\7z\2\2\u0085"+
		"\u0086\7v\2\2\u0086\u0087\7*\2\2\u0087\u0088\7+\2\2\u0088$\3\2\2\2\u0089"+
		"\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\7\60\2\2\u008f"+
		"\u0090\7z\2\2\u0090\u0091\7o\2\2\u0091\u0092\7n\2\2\u0092&\3\2\2\2\u0093"+
		"\u0094\7\61\2\2\u0094(\3\2\2\2\u0095\u0096\7\61\2\2\u0096\u0097\7\61\2"+
		"\2\u0097*\3\2\2\2\u0098\u0099\7.\2\2\u0099,\3\2\2\2\u009a\u009e\7?\2\2"+
		"\u009b\u009c\7g\2\2\u009c\u009e\7s\2\2\u009d\u009a\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e.\3\2\2\2\u009f\u00a0\7?\2\2\u00a0\u00a4\7?\2\2\u00a1\u00a2"+
		"\7k\2\2\u00a2\u00a4\7u\2\2\u00a3\u009f\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\60\3\2\2\2\u00a5\u00a6\7,\2\2\u00a6\62\3\2\2\2\u00a7\u00a8\7\60\2\2\u00a8"+
		"\64\3\2\2\2\u00a9\u00aa\7\60\2\2\u00aa\u00ab\7\60\2\2\u00ab\66\3\2\2\2"+
		"\u00ac\u00ad\7t\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af\7v\2\2\u00af\u00b0"+
		"\7w\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7p\2\2\u00b28\3\2\2\2\u00b3\u00b4"+
		"\7h\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7t\2\2\u00b6:\3\2\2\2\u00b7\u00b8"+
		"\7k\2\2\u00b8\u00b9\7p\2\2\u00b9<\3\2\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc"+
		"\7g\2\2\u00bc\u00bd\7v\2\2\u00bd>\3\2\2\2\u00be\u00bf\7<\2\2\u00bf\u00c0"+
		"\7?\2\2\u00c0@\3\2\2\2\u00c1\u00c2\7y\2\2\u00c2\u00c3\7j\2\2\u00c3\u00c4"+
		"\7g\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7g\2\2\u00c6B\3\2\2\2\u00c7\u00c8"+
		"\7u\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7o\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"D\3\2\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7o\2\2\u00ce\u00cf\7r\2\2\u00cf"+
		"\u00d0\7v\2\2\u00d0\u00d1\7{\2\2\u00d1F\3\2\2\2\u00d2\u00d3\7u\2\2\u00d3"+
		"\u00d4\7c\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7u\2\2"+
		"\u00d7\u00d8\7h\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da\7g\2\2\u00da\u00db"+
		"\7u\2\2\u00dbH\3\2\2\2\u00dc\u00de\7$\2\2\u00dd\u00df\t\3\2\2\u00de\u00dd"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\7\60\2\2\u00e3\u00e4\7z\2\2\u00e4\u00e5\7o"+
		"\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7$\2\2\u00e7J\3\2\2\2\u00e8\u00ec"+
		"\7$\2\2\u00e9\u00eb\n\4\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2"+
		"\2\2\u00ef\u00f0\7$\2\2\u00f0L\3\2\2\2\u00f1\u00f3\t\3\2\2\u00f2\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"N\3\2\2\2\u00f6\u00f8\t\5\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2"+
		"\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc"+
		"\b(\2\2\u00fcP\3\2\2\2\n\2\u008c\u009d\u00a3\u00e0\u00ec\u00f4\u00f9\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}