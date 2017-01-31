// Generated from edu/ucsd/antlrxpath/antlrxpath/XPath.g4 by ANTLR 4.3
package edu.ucsd.antlrxpath.antlrxpath;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, FNAME=8, SLASH=9, 
		DSLASH=10, CONCAT=11, ValueEq=12, IDEq=13, AND=14, OR=15, ASTERISK=16, 
		DOT=17, UPPER=18, NAME=19, TEXTFUNCTION=20, NOT=21;
	public static final String[] tokenNames = {
		"<INVALID>", "'@'", "'doc(\"'", "'\")'", "'('", "')'", "'['", "']'", "FNAME", 
		"'/'", "'//'", "','", "ValueEq", "IDEq", "'and'", "'or'", "'*'", "'.'", 
		"'..'", "NAME", "'text()'", "'not'"
	};
	public static final int
		RULE_xquery = 0, RULE_xpath = 1, RULE_descendant = 2, RULE_descendantOrSelf = 3, 
		RULE_absolutePath = 4, RULE_filename = 5, RULE_relativePath = 6, RULE_attTest = 7, 
		RULE_tagName = 8, RULE_all = 9, RULE_self = 10, RULE_attName = 11, RULE_parent = 12, 
		RULE_text = 13, RULE_concatPath = 14, RULE_pathFilter = 15, RULE_nagatePathFilter = 16;
	public static final String[] ruleNames = {
		"xquery", "xpath", "descendant", "descendantOrSelf", "absolutePath", "filename", 
		"relativePath", "attTest", "tagName", "all", "self", "attName", "parent", 
		"text", "concatPath", "pathFilter", "nagatePathFilter"
	};

	@Override
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class XqueryContext extends ParserRuleContext {
		public XpathContext xpath() {
			return getRuleContext(XpathContext.class,0);
		}
		public TerminalNode EOF() { return getToken(XPathParser.EOF, 0); }
		public XqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitXquery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqueryContext xquery() throws RecognitionException {
		XqueryContext _localctx = new XqueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); xpath();
			setState(35); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XpathContext extends ParserRuleContext {
		public AbsolutePathContext absolutePath() {
			return getRuleContext(AbsolutePathContext.class,0);
		}
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public DescendantOrSelfContext descendantOrSelf() {
			return getRuleContext(DescendantOrSelfContext.class,0);
		}
		public DescendantContext descendant() {
			return getRuleContext(DescendantContext.class,0);
		}
		public XpathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xpath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXpath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXpath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitXpath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XpathContext xpath() throws RecognitionException {
		XpathContext _localctx = new XpathContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_xpath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); absolutePath();
			setState(40);
			switch (_input.LA(1)) {
			case SLASH:
				{
				setState(38); descendant();
				}
				break;
			case DSLASH:
				{
				setState(39); descendantOrSelf();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(42); relativePath(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescendantContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(XPathParser.SLASH, 0); }
		public DescendantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descendant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDescendant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDescendant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitDescendant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescendantContext descendant() throws RecognitionException {
		DescendantContext _localctx = new DescendantContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_descendant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44); match(SLASH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescendantOrSelfContext extends ParserRuleContext {
		public TerminalNode DSLASH() { return getToken(XPathParser.DSLASH, 0); }
		public DescendantOrSelfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descendantOrSelf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDescendantOrSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDescendantOrSelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitDescendantOrSelf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescendantOrSelfContext descendantOrSelf() throws RecognitionException {
		DescendantOrSelfContext _localctx = new DescendantOrSelfContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_descendantOrSelf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); match(DSLASH);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbsolutePathContext extends ParserRuleContext {
		public FilenameContext filename() {
			return getRuleContext(FilenameContext.class,0);
		}
		public AbsolutePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolutePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAbsolutePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAbsolutePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAbsolutePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsolutePathContext absolutePath() throws RecognitionException {
		AbsolutePathContext _localctx = new AbsolutePathContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_absolutePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); match(T__5);
			setState(49); filename();
			setState(50); match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilenameContext extends ParserRuleContext {
		public TerminalNode FNAME() { return getToken(XPathParser.FNAME, 0); }
		public FilenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterFilename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitFilename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitFilename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilenameContext filename() throws RecognitionException {
		FilenameContext _localctx = new FilenameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_filename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); match(FNAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelativePathContext extends ParserRuleContext {
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public ParentContext parent() {
			return getRuleContext(ParentContext.class,0);
		}
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public ConcatPathContext concatPath() {
			return getRuleContext(ConcatPathContext.class,0);
		}
		public TextContext text() {
			return getRuleContext(TextContext.class,0);
		}
		public DescendantOrSelfContext descendantOrSelf() {
			return getRuleContext(DescendantOrSelfContext.class,0);
		}
		public PathFilterContext pathFilter() {
			return getRuleContext(PathFilterContext.class,0);
		}
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public AttTestContext attTest() {
			return getRuleContext(AttTestContext.class,0);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public DescendantContext descendant() {
			return getRuleContext(DescendantContext.class,0);
		}
		public SelfContext self() {
			return getRuleContext(SelfContext.class,0);
		}
		public RelativePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRelativePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRelativePath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitRelativePath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelativePathContext relativePath() throws RecognitionException {
		return relativePath(0);
	}

	private RelativePathContext relativePath(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelativePathContext _localctx = new RelativePathContext(_ctx, _parentState);
		RelativePathContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_relativePath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(55); tagName();
				}
				break;
			case ASTERISK:
				{
				setState(56); all();
				}
				break;
			case DOT:
				{
				setState(57); self();
				}
				break;
			case UPPER:
				{
				setState(58); parent();
				}
				break;
			case TEXTFUNCTION:
				{
				setState(59); text();
				}
				break;
			case T__6:
				{
				setState(60); attTest();
				}
				break;
			case T__3:
				{
				setState(61); match(T__3);
				setState(62); relativePath(0);
				setState(63); match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(83);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(81);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(67);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(70);
						switch (_input.LA(1)) {
						case SLASH:
							{
							setState(68); descendant();
							}
							break;
						case DSLASH:
							{
							setState(69); descendantOrSelf();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(72); relativePath(4);
						}
						break;

					case 2:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(74);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(75); match(T__1);
						setState(76); pathFilter(0);
						setState(77); match(T__0);
						}
						break;

					case 3:
						{
						_localctx = new RelativePathContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(79);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(80); concatPath();
						}
						break;
					}
					} 
				}
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AttTestContext extends ParserRuleContext {
		public AttNameContext attName() {
			return getRuleContext(AttNameContext.class,0);
		}
		public AttTestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attTest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttTest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttTest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAttTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttTestContext attTest() throws RecognitionException {
		AttTestContext _localctx = new AttTestContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attTest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(T__6);
			setState(87); attName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XPathParser.NAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllContext extends ParserRuleContext {
		public TerminalNode ASTERISK() { return getToken(XPathParser.ASTERISK, 0); }
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91); match(ASTERISK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelfContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(XPathParser.DOT, 0); }
		public SelfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_self; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterSelf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitSelf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitSelf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelfContext self() throws RecognitionException {
		SelfContext _localctx = new SelfContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_self);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(DOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XPathParser.NAME, 0); }
		public AttNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAttName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttNameContext attName() throws RecognitionException {
		AttNameContext _localctx = new AttNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParentContext extends ParserRuleContext {
		public TerminalNode UPPER() { return getToken(XPathParser.UPPER, 0); }
		public ParentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitParent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentContext parent() throws RecognitionException {
		ParentContext _localctx = new ParentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); match(UPPER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextContext extends ParserRuleContext {
		public TerminalNode TEXTFUNCTION() { return getToken(XPathParser.TEXTFUNCTION, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(TEXTFUNCTION);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConcatPathContext extends ParserRuleContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public ConcatPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterConcatPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitConcatPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitConcatPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatPathContext concatPath() throws RecognitionException {
		ConcatPathContext _localctx = new ConcatPathContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_concatPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(CONCAT);
			setState(102); relativePath(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathFilterContext extends ParserRuleContext {
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public List<PathFilterContext> pathFilter() {
			return getRuleContexts(PathFilterContext.class);
		}
		public TerminalNode ValueEq() { return getToken(XPathParser.ValueEq, 0); }
		public TerminalNode AND() { return getToken(XPathParser.AND, 0); }
		public TerminalNode IDEq() { return getToken(XPathParser.IDEq, 0); }
		public PathFilterContext pathFilter(int i) {
			return getRuleContext(PathFilterContext.class,i);
		}
		public TerminalNode OR() { return getToken(XPathParser.OR, 0); }
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public NagatePathFilterContext nagatePathFilter() {
			return getRuleContext(NagatePathFilterContext.class,0);
		}
		public PathFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterPathFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitPathFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitPathFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathFilterContext pathFilter() throws RecognitionException {
		return pathFilter(0);
	}

	private PathFilterContext pathFilter(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PathFilterContext _localctx = new PathFilterContext(_ctx, _parentState);
		PathFilterContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_pathFilter, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(105); relativePath(0);
				}
				break;

			case 2:
				{
				setState(106); relativePath(0);
				setState(107);
				_la = _input.LA(1);
				if ( !(_la==ValueEq || _la==IDEq) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(108); relativePath(0);
				}
				break;

			case 3:
				{
				setState(110); match(T__3);
				setState(111); pathFilter(0);
				setState(112); match(T__2);
				}
				break;

			case 4:
				{
				setState(114); nagatePathFilter();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PathFilterContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pathFilter);
					setState(117);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(118);
					_la = _input.LA(1);
					if ( !(_la==AND || _la==OR) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(119); pathFilter(2);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NagatePathFilterContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(XPathParser.NOT, 0); }
		public PathFilterContext pathFilter() {
			return getRuleContext(PathFilterContext.class,0);
		}
		public NagatePathFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nagatePathFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterNagatePathFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitNagatePathFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitNagatePathFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NagatePathFilterContext nagatePathFilter() throws RecognitionException {
		NagatePathFilterContext _localctx = new NagatePathFilterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nagatePathFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(NOT);
			setState(126); pathFilter(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6: return relativePath_sempred((RelativePathContext)_localctx, predIndex);

		case 15: return pathFilter_sempred((PathFilterContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean pathFilter_sempred(PathFilterContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relativePath_sempred(RelativePathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);

		case 1: return precpred(_ctx, 2);

		case 2: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\27\u0083\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\5\3+\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bD\n\b\3\b"+
		"\3\b\3\b\5\bI\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bT\n\b\f\b\16"+
		"\bW\13\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\5\21v\n\21\3\21\3\21\3\21\7\21{\n\21\f\21\16\21~\13\21\3\22\3\22"+
		"\3\22\3\22\2\4\16 \23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\4\3"+
		"\2\16\17\3\2\20\21\u0080\2$\3\2\2\2\4\'\3\2\2\2\6.\3\2\2\2\b\60\3\2\2"+
		"\2\n\62\3\2\2\2\f\66\3\2\2\2\16C\3\2\2\2\20X\3\2\2\2\22[\3\2\2\2\24]\3"+
		"\2\2\2\26_\3\2\2\2\30a\3\2\2\2\32c\3\2\2\2\34e\3\2\2\2\36g\3\2\2\2 u\3"+
		"\2\2\2\"\177\3\2\2\2$%\5\4\3\2%&\7\2\2\3&\3\3\2\2\2\'*\5\n\6\2(+\5\6\4"+
		"\2)+\5\b\5\2*(\3\2\2\2*)\3\2\2\2+,\3\2\2\2,-\5\16\b\2-\5\3\2\2\2./\7\13"+
		"\2\2/\7\3\2\2\2\60\61\7\f\2\2\61\t\3\2\2\2\62\63\7\4\2\2\63\64\5\f\7\2"+
		"\64\65\7\5\2\2\65\13\3\2\2\2\66\67\7\n\2\2\67\r\3\2\2\289\b\b\1\29D\5"+
		"\22\n\2:D\5\24\13\2;D\5\26\f\2<D\5\32\16\2=D\5\34\17\2>D\5\20\t\2?@\7"+
		"\6\2\2@A\5\16\b\2AB\7\7\2\2BD\3\2\2\2C8\3\2\2\2C:\3\2\2\2C;\3\2\2\2C<"+
		"\3\2\2\2C=\3\2\2\2C>\3\2\2\2C?\3\2\2\2DU\3\2\2\2EH\f\5\2\2FI\5\6\4\2G"+
		"I\5\b\5\2HF\3\2\2\2HG\3\2\2\2IJ\3\2\2\2JK\5\16\b\6KT\3\2\2\2LM\f\4\2\2"+
		"MN\7\b\2\2NO\5 \21\2OP\7\t\2\2PT\3\2\2\2QR\f\3\2\2RT\5\36\20\2SE\3\2\2"+
		"\2SL\3\2\2\2SQ\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V\17\3\2\2\2WU\3\2"+
		"\2\2XY\7\3\2\2YZ\5\30\r\2Z\21\3\2\2\2[\\\7\25\2\2\\\23\3\2\2\2]^\7\22"+
		"\2\2^\25\3\2\2\2_`\7\23\2\2`\27\3\2\2\2ab\7\25\2\2b\31\3\2\2\2cd\7\24"+
		"\2\2d\33\3\2\2\2ef\7\26\2\2f\35\3\2\2\2gh\7\r\2\2hi\5\16\b\2i\37\3\2\2"+
		"\2jk\b\21\1\2kv\5\16\b\2lm\5\16\b\2mn\t\2\2\2no\5\16\b\2ov\3\2\2\2pq\7"+
		"\6\2\2qr\5 \21\2rs\7\7\2\2sv\3\2\2\2tv\5\"\22\2uj\3\2\2\2ul\3\2\2\2up"+
		"\3\2\2\2ut\3\2\2\2v|\3\2\2\2wx\f\3\2\2xy\t\3\2\2y{\5 \21\4zw\3\2\2\2{"+
		"~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}!\3\2\2\2~|\3\2\2\2\177\u0080\7\27\2\2\u0080"+
		"\u0081\5 \21\2\u0081#\3\2\2\2\t*CHSUu|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}