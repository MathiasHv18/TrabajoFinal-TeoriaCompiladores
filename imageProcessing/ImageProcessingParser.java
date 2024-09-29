// Generated from ImageProcessing.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ImageProcessingParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, STRING=17, 
		ID=18, NUMBER=19, WS=20;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_loadImage = 2, RULE_saveImage = 3, 
		RULE_applyFilter = 4, RULE_filterType = 5, RULE_transform = 6, RULE_transformation = 7, 
		RULE_transformationValue = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "loadImage", "saveImage", "applyFilter", "filterType", 
			"transform", "transformation", "transformationValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'load'", "'as'", "';'", "'save'", "'to'", "'.'", "'filter'", "'('", 
			"')'", "'blur'", "'sharpen'", "'grayscale'", "'edgeDetection'", "'rotate'", 
			"'resize'", "'crop'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "STRING", "ID", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ImageProcessing.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImageProcessingParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				statement();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 262162L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public LoadImageContext loadImage() {
			return getRuleContext(LoadImageContext.class,0);
		}
		public SaveImageContext saveImage() {
			return getRuleContext(SaveImageContext.class,0);
		}
		public ApplyFilterContext applyFilter() {
			return getRuleContext(ApplyFilterContext.class,0);
		}
		public TransformContext transform() {
			return getRuleContext(TransformContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				loadImage();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				saveImage();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				applyFilter();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(26);
				transform();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class LoadImageContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ImageProcessingParser.STRING, 0); }
		public TerminalNode ID() { return getToken(ImageProcessingParser.ID, 0); }
		public LoadImageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadImage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterLoadImage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitLoadImage(this);
		}
	}

	public final LoadImageContext loadImage() throws RecognitionException {
		LoadImageContext _localctx = new LoadImageContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_loadImage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(T__0);
			setState(30);
			match(STRING);
			setState(31);
			match(T__1);
			setState(32);
			match(ID);
			setState(33);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SaveImageContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ImageProcessingParser.ID, 0); }
		public TerminalNode STRING() { return getToken(ImageProcessingParser.STRING, 0); }
		public SaveImageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saveImage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterSaveImage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitSaveImage(this);
		}
	}

	public final SaveImageContext saveImage() throws RecognitionException {
		SaveImageContext _localctx = new SaveImageContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_saveImage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(T__3);
			setState(36);
			match(ID);
			setState(37);
			match(T__4);
			setState(38);
			match(STRING);
			setState(39);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ApplyFilterContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ImageProcessingParser.ID, 0); }
		public FilterTypeContext filterType() {
			return getRuleContext(FilterTypeContext.class,0);
		}
		public ApplyFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_applyFilter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterApplyFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitApplyFilter(this);
		}
	}

	public final ApplyFilterContext applyFilter() throws RecognitionException {
		ApplyFilterContext _localctx = new ApplyFilterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_applyFilter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(ID);
			setState(42);
			match(T__5);
			setState(43);
			match(T__6);
			setState(44);
			match(T__7);
			setState(45);
			filterType();
			setState(46);
			match(T__8);
			setState(47);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FilterTypeContext extends ParserRuleContext {
		public FilterTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterFilterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitFilterType(this);
		}
	}

	public final FilterTypeContext filterType() throws RecognitionException {
		FilterTypeContext _localctx = new FilterTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_filterType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15360L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TransformContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ImageProcessingParser.ID, 0); }
		public TransformationContext transformation() {
			return getRuleContext(TransformationContext.class,0);
		}
		public TransformationValueContext transformationValue() {
			return getRuleContext(TransformationValueContext.class,0);
		}
		public TransformContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transform; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterTransform(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitTransform(this);
		}
	}

	public final TransformContext transform() throws RecognitionException {
		TransformContext _localctx = new TransformContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_transform);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(ID);
			setState(52);
			match(T__5);
			setState(53);
			transformation();
			setState(54);
			match(T__7);
			setState(55);
			transformationValue();
			setState(56);
			match(T__8);
			setState(57);
			match(T__2);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TransformationContext extends ParserRuleContext {
		public TransformationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transformation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterTransformation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitTransformation(this);
		}
	}

	public final TransformationContext transformation() throws RecognitionException {
		TransformationContext _localctx = new TransformationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_transformation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class TransformationValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ImageProcessingParser.NUMBER, 0); }
		public TransformationValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transformationValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).enterTransformationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImageProcessingListener ) ((ImageProcessingListener)listener).exitTransformationValue(this);
		}
	}

	public final TransformationValueContext transformationValue() throws RecognitionException {
		TransformationValueContext _localctx = new TransformationValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_transformationValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(NUMBER);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0014@\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f\u0000\u0015"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001c\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0000\u0000\t\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0000\u0002\u0001\u0000\n\r\u0001\u0000"+
		"\u000e\u0010:\u0000\u0013\u0001\u0000\u0000\u0000\u0002\u001b\u0001\u0000"+
		"\u0000\u0000\u0004\u001d\u0001\u0000\u0000\u0000\u0006#\u0001\u0000\u0000"+
		"\u0000\b)\u0001\u0000\u0000\u0000\n1\u0001\u0000\u0000\u0000\f3\u0001"+
		"\u0000\u0000\u0000\u000e;\u0001\u0000\u0000\u0000\u0010=\u0001\u0000\u0000"+
		"\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013\u0012\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0001\u0001\u0000\u0000"+
		"\u0000\u0017\u001c\u0003\u0004\u0002\u0000\u0018\u001c\u0003\u0006\u0003"+
		"\u0000\u0019\u001c\u0003\b\u0004\u0000\u001a\u001c\u0003\f\u0006\u0000"+
		"\u001b\u0017\u0001\u0000\u0000\u0000\u001b\u0018\u0001\u0000\u0000\u0000"+
		"\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001a\u0001\u0000\u0000\u0000"+
		"\u001c\u0003\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0001\u0000\u0000"+
		"\u001e\u001f\u0005\u0011\u0000\u0000\u001f \u0005\u0002\u0000\u0000 !"+
		"\u0005\u0012\u0000\u0000!\"\u0005\u0003\u0000\u0000\"\u0005\u0001\u0000"+
		"\u0000\u0000#$\u0005\u0004\u0000\u0000$%\u0005\u0012\u0000\u0000%&\u0005"+
		"\u0005\u0000\u0000&\'\u0005\u0011\u0000\u0000\'(\u0005\u0003\u0000\u0000"+
		"(\u0007\u0001\u0000\u0000\u0000)*\u0005\u0012\u0000\u0000*+\u0005\u0006"+
		"\u0000\u0000+,\u0005\u0007\u0000\u0000,-\u0005\b\u0000\u0000-.\u0003\n"+
		"\u0005\u0000./\u0005\t\u0000\u0000/0\u0005\u0003\u0000\u00000\t\u0001"+
		"\u0000\u0000\u000012\u0007\u0000\u0000\u00002\u000b\u0001\u0000\u0000"+
		"\u000034\u0005\u0012\u0000\u000045\u0005\u0006\u0000\u000056\u0003\u000e"+
		"\u0007\u000067\u0005\b\u0000\u000078\u0003\u0010\b\u000089\u0005\t\u0000"+
		"\u00009:\u0005\u0003\u0000\u0000:\r\u0001\u0000\u0000\u0000;<\u0007\u0001"+
		"\u0000\u0000<\u000f\u0001\u0000\u0000\u0000=>\u0005\u0013\u0000\u0000"+
		">\u0011\u0001\u0000\u0000\u0000\u0002\u0015\u001b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}