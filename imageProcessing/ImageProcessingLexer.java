// Generated from ImageProcessing.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ImageProcessingLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, STRING=17, 
		ID=18, NUMBER=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "STRING", 
			"ID", "NUMBER", "WS"
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


	public ImageProcessingLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ImageProcessing.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0014\u009a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u0083\b\u0010\n\u0010"+
		"\f\u0010\u0086\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011"+
		"\u008b\b\u0011\u000b\u0011\f\u0011\u008c\u0001\u0012\u0004\u0012\u0090"+
		"\b\u0012\u000b\u0012\f\u0012\u0091\u0001\u0013\u0004\u0013\u0095\b\u0013"+
		"\u000b\u0013\f\u0013\u0096\u0001\u0013\u0001\u0013\u0001\u0084\u0000\u0014"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0003"+
		"\u0002\u0000AZaz\u0001\u000009\u0003\u0000\t\n\r\r  \u009d\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003.\u0001"+
		"\u0000\u0000\u0000\u00051\u0001\u0000\u0000\u0000\u00073\u0001\u0000\u0000"+
		"\u0000\t8\u0001\u0000\u0000\u0000\u000b;\u0001\u0000\u0000\u0000\r=\u0001"+
		"\u0000\u0000\u0000\u000fD\u0001\u0000\u0000\u0000\u0011F\u0001\u0000\u0000"+
		"\u0000\u0013H\u0001\u0000\u0000\u0000\u0015M\u0001\u0000\u0000\u0000\u0017"+
		"U\u0001\u0000\u0000\u0000\u0019_\u0001\u0000\u0000\u0000\u001bm\u0001"+
		"\u0000\u0000\u0000\u001dt\u0001\u0000\u0000\u0000\u001f{\u0001\u0000\u0000"+
		"\u0000!\u0080\u0001\u0000\u0000\u0000#\u008a\u0001\u0000\u0000\u0000%"+
		"\u008f\u0001\u0000\u0000\u0000\'\u0094\u0001\u0000\u0000\u0000)*\u0005"+
		"l\u0000\u0000*+\u0005o\u0000\u0000+,\u0005a\u0000\u0000,-\u0005d\u0000"+
		"\u0000-\u0002\u0001\u0000\u0000\u0000./\u0005a\u0000\u0000/0\u0005s\u0000"+
		"\u00000\u0004\u0001\u0000\u0000\u000012\u0005;\u0000\u00002\u0006\u0001"+
		"\u0000\u0000\u000034\u0005s\u0000\u000045\u0005a\u0000\u000056\u0005v"+
		"\u0000\u000067\u0005e\u0000\u00007\b\u0001\u0000\u0000\u000089\u0005t"+
		"\u0000\u00009:\u0005o\u0000\u0000:\n\u0001\u0000\u0000\u0000;<\u0005."+
		"\u0000\u0000<\f\u0001\u0000\u0000\u0000=>\u0005f\u0000\u0000>?\u0005i"+
		"\u0000\u0000?@\u0005l\u0000\u0000@A\u0005t\u0000\u0000AB\u0005e\u0000"+
		"\u0000BC\u0005r\u0000\u0000C\u000e\u0001\u0000\u0000\u0000DE\u0005(\u0000"+
		"\u0000E\u0010\u0001\u0000\u0000\u0000FG\u0005)\u0000\u0000G\u0012\u0001"+
		"\u0000\u0000\u0000HI\u0005b\u0000\u0000IJ\u0005l\u0000\u0000JK\u0005u"+
		"\u0000\u0000KL\u0005r\u0000\u0000L\u0014\u0001\u0000\u0000\u0000MN\u0005"+
		"s\u0000\u0000NO\u0005h\u0000\u0000OP\u0005a\u0000\u0000PQ\u0005r\u0000"+
		"\u0000QR\u0005p\u0000\u0000RS\u0005e\u0000\u0000ST\u0005n\u0000\u0000"+
		"T\u0016\u0001\u0000\u0000\u0000UV\u0005g\u0000\u0000VW\u0005r\u0000\u0000"+
		"WX\u0005a\u0000\u0000XY\u0005y\u0000\u0000YZ\u0005s\u0000\u0000Z[\u0005"+
		"c\u0000\u0000[\\\u0005a\u0000\u0000\\]\u0005l\u0000\u0000]^\u0005e\u0000"+
		"\u0000^\u0018\u0001\u0000\u0000\u0000_`\u0005e\u0000\u0000`a\u0005d\u0000"+
		"\u0000ab\u0005g\u0000\u0000bc\u0005e\u0000\u0000cd\u0005D\u0000\u0000"+
		"de\u0005e\u0000\u0000ef\u0005t\u0000\u0000fg\u0005e\u0000\u0000gh\u0005"+
		"c\u0000\u0000hi\u0005t\u0000\u0000ij\u0005i\u0000\u0000jk\u0005o\u0000"+
		"\u0000kl\u0005n\u0000\u0000l\u001a\u0001\u0000\u0000\u0000mn\u0005r\u0000"+
		"\u0000no\u0005o\u0000\u0000op\u0005t\u0000\u0000pq\u0005a\u0000\u0000"+
		"qr\u0005t\u0000\u0000rs\u0005e\u0000\u0000s\u001c\u0001\u0000\u0000\u0000"+
		"tu\u0005r\u0000\u0000uv\u0005e\u0000\u0000vw\u0005s\u0000\u0000wx\u0005"+
		"i\u0000\u0000xy\u0005z\u0000\u0000yz\u0005e\u0000\u0000z\u001e\u0001\u0000"+
		"\u0000\u0000{|\u0005c\u0000\u0000|}\u0005r\u0000\u0000}~\u0005o\u0000"+
		"\u0000~\u007f\u0005p\u0000\u0000\u007f \u0001\u0000\u0000\u0000\u0080"+
		"\u0084\u0005\"\u0000\u0000\u0081\u0083\t\u0000\u0000\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005\"\u0000\u0000\u0088\"\u0001\u0000\u0000\u0000\u0089\u008b\u0007"+
		"\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d$\u0001\u0000\u0000\u0000\u008e\u0090\u0007\u0001"+
		"\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000"+
		"\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092&\u0001\u0000\u0000\u0000\u0093\u0095\u0007\u0002\u0000"+
		"\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0006\u0013\u0000"+
		"\u0000\u0099(\u0001\u0000\u0000\u0000\u0005\u0000\u0084\u008c\u0091\u0096"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}