// Generated from QuoteBot.g4 by ANTLR 4.8

package dk.njit.cs684.quote.grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuoteBotLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, W_TODAY=2, HOWMUCHISWAS=3, WHATISWAS=4, THEPRICEOF=5, RIGHTNOW=6, 
		W_BETWEEN=7, BETWEEN_SYMBOL=8, W_ON=9, STATS=10, SEARCH=11, SPREADSHEET=12, 
		NUMBER=13, YEAR=14, DIGIT=15, ISO_DATE=16, AMERICAN_DATE=17, AMERICAN_SHORT_DATE=18, 
		ANYMONTH=19, MONTH3=20, MONTH=21, W_MAY=22, W_LAST=23, DAY_OF_WEEK=24, 
		W_AGO=25, W_DAY=26, W_YESTERDAY=27, W_MONTH=28, W_WEEK=29, W_YEAR=30, 
		ORDINAL_SUFFIX=31, TEXTUAL_NUMBER=32, TEXTUAL_ONES_NUMBER=33, TEXTUAL_TENS_NUMBER=34, 
		W_ONE=35, W_TWO=36, W_THREE=37, W_FOUR=38, W_FIVE=39, W_SIX=40, W_SEVEN=41, 
		W_EIGHT=42, W_NINE=43, W_TEN=44, W_ELEVEN=45, W_TWELVE=46, W_THIRTEEN=47, 
		W_FOURTEEN=48, W_FIFTEEN=49, W_SIXTEEN=50, W_SEVENTEEN=51, W_EIGHTTEEN=52, 
		W_NINETEEN=53, W_TWENTY=54, W_THIRTY=55, W_FOURTY=56, W_FIFTY=57, W_SIXTY=58, 
		W_SEVENTY=59, W_EIGHTY=60, W_NINETY=61, W_TEEN=62, W_TY=63, SPACE=64, 
		QUESTION=65, IDENTIFIER=66;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "W_TODAY", "HOWMUCHISWAS", "WHATISWAS", "THEPRICEOF", "RIGHTNOW", 
			"W_BETWEEN", "BETWEEN_SYMBOL", "W_ON", "STATS", "SEARCH", "SPREADSHEET", 
			"NUMBER", "YEAR", "DIGIT", "ISO_DATE", "AMERICAN_DATE", "AMERICAN_SHORT_DATE", 
			"ANYMONTH", "MONTH3", "MONTH", "W_MAY", "W_LAST", "DAY_OF_WEEK", "W_AGO", 
			"W_DAY", "W_YESTERDAY", "W_MONTH", "W_WEEK", "W_YEAR", "ORDINAL_SUFFIX", 
			"TEXTUAL_NUMBER", "TEXTUAL_ONES_NUMBER", "TEXTUAL_TENS_NUMBER", "W_ONE", 
			"W_TWO", "W_THREE", "W_FOUR", "W_FIVE", "W_SIX", "W_SEVEN", "W_EIGHT", 
			"W_NINE", "W_TEN", "W_ELEVEN", "W_TWELVE", "W_THIRTEEN", "W_FOURTEEN", 
			"W_FIFTEEN", "W_SIXTEEN", "W_SEVENTEEN", "W_EIGHTTEEN", "W_NINETEEN", 
			"W_TWENTY", "W_THIRTY", "W_FOURTY", "W_FIFTY", "W_SIXTY", "W_SEVENTY", 
			"W_EIGHTY", "W_NINETY", "W_TEEN", "W_TY", "SPACE", "QUESTION", "IDENTIFIER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'of'", null, null, null, null, null, null, null, "'on'", null, 
			null, null, null, null, null, null, null, null, null, null, null, "'may'", 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"'one'", "'two'", null, null, null, null, null, null, "'nine'", "'ten'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "W_TODAY", "HOWMUCHISWAS", "WHATISWAS", "THEPRICEOF", "RIGHTNOW", 
			"W_BETWEEN", "BETWEEN_SYMBOL", "W_ON", "STATS", "SEARCH", "SPREADSHEET", 
			"NUMBER", "YEAR", "DIGIT", "ISO_DATE", "AMERICAN_DATE", "AMERICAN_SHORT_DATE", 
			"ANYMONTH", "MONTH3", "MONTH", "W_MAY", "W_LAST", "DAY_OF_WEEK", "W_AGO", 
			"W_DAY", "W_YESTERDAY", "W_MONTH", "W_WEEK", "W_YEAR", "ORDINAL_SUFFIX", 
			"TEXTUAL_NUMBER", "TEXTUAL_ONES_NUMBER", "TEXTUAL_TENS_NUMBER", "W_ONE", 
			"W_TWO", "W_THREE", "W_FOUR", "W_FIVE", "W_SIX", "W_SEVEN", "W_EIGHT", 
			"W_NINE", "W_TEN", "W_ELEVEN", "W_TWELVE", "W_THIRTEEN", "W_FOURTEEN", 
			"W_FIFTEEN", "W_SIXTEEN", "W_SEVENTEEN", "W_EIGHTTEEN", "W_NINETEEN", 
			"W_TWENTY", "W_THIRTY", "W_FOURTY", "W_FIFTY", "W_SIXTY", "W_SEVENTY", 
			"W_EIGHTY", "W_NINETY", "W_TEEN", "W_TY", "SPACE", "QUESTION", "IDENTIFIER"
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


	public QuoteBotLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QuoteBot.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u03fd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\3\3\3\3\3\5\3\u008e"+
		"\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\u00a2\n\4\5\4\u00a4\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00e2"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00f3"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\5\6\u00fa\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6\u0106\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u010f\n\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0122"+
		"\n\b\3\t\5\t\u0125\n\t\3\t\3\t\3\t\3\t\5\t\u012b\n\t\3\t\5\t\u012e\n\t"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\5\13\u0142\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0158\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u018c\n\r\3\16\6"+
		"\16\u018f\n\16\r\16\16\16\u0190\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u01a4\n\22\3\22\3\22"+
		"\3\22\5\22\u01a9\n\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01b1\n\22\3"+
		"\23\3\23\5\23\u01b5\n\23\3\23\3\23\3\23\5\23\u01ba\n\23\3\24\3\24\5\24"+
		"\u01be\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01e2\n\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u022c\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0239\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u028c\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0294\n\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\5\33\u029d\n\33\3\34\3\34\5\34\u02a1\n\34\3\34"+
		"\3\34\3\34\3\34\5\34\u02a7\n\34\3\34\3\34\3\34\3\34\5\34\u02ad\n\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u02b7\n\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u02bf\n\35\3\35\5\35\u02c2\n\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\5\36\u02cd\n\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\5\37\u02d5\n\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u02df\n \3!\3!\5!\u02e3"+
		"\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u02ee\n\"\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0301\n#\3$\3$\3$\3$\3%\3%\3%\3"+
		"%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\5&\u031c\n&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0329\n\'\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\5(\u0336\n(\3)\3)\3)\3)\3)\3)\5)\u033e\n)\3*\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\5*\u0352\n*\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\5+\u0363\n+\3,\3,\3,\3,\3,\3-\3-\3-\3"+
		"-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u037a\n.\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\5/\u0387\n/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67\u03ac"+
		"\n\67\3\67\5\67\u03af\n\67\38\38\38\38\38\38\38\58\u03b8\n8\38\58\u03bb"+
		"\n8\39\39\59\u03bf\n9\3:\3:\3:\3:\5:\u03c5\n:\3;\3;\5;\u03c9\n;\3<\3<"+
		"\5<\u03cd\n<\3=\3=\5=\u03d1\n=\3>\3>\5>\u03d5\n>\3?\3?\3?\3?\3?\5?\u03dc"+
		"\n?\3@\3@\3@\5@\u03e1\n@\3A\6A\u03e4\nA\rA\16A\u03e5\3B\5B\u03e9\nB\3"+
		"B\3B\3C\3C\7C\u03ef\nC\fC\16C\u03f2\13C\3C\3C\7C\u03f6\nC\fC\16C\u03f9"+
		"\13C\3C\5C\u03fc\nC\3\u03f7\2D\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\3"+
		"\2\6\3\2\62;\4\2ww{{\3\2c|\7\2//\62;??aac|\2\u048c\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
		"\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\3\u0087\3"+
		"\2\2\2\5\u008d\3\2\2\2\7\u0091\3\2\2\2\t\u00e1\3\2\2\2\13\u0105\3\2\2"+
		"\2\r\u010e\3\2\2\2\17\u0121\3\2\2\2\21\u0124\3\2\2\2\23\u012f\3\2\2\2"+
		"\25\u0141\3\2\2\2\27\u0157\3\2\2\2\31\u018b\3\2\2\2\33\u018e\3\2\2\2\35"+
		"\u0192\3\2\2\2\37\u0197\3\2\2\2!\u0199\3\2\2\2#\u01a1\3\2\2\2%\u01b2\3"+
		"\2\2\2\'\u01bd\3\2\2\2)\u01e1\3\2\2\2+\u022b\3\2\2\2-\u022d\3\2\2\2/\u0238"+
		"\3\2\2\2\61\u028b\3\2\2\2\63\u0293\3\2\2\2\65\u029c\3\2\2\2\67\u029e\3"+
		"\2\2\29\u02c1\3\2\2\2;\u02cc\3\2\2\2=\u02ce\3\2\2\2?\u02de\3\2\2\2A\u02e2"+
		"\3\2\2\2C\u02ed\3\2\2\2E\u0300\3\2\2\2G\u0302\3\2\2\2I\u0306\3\2\2\2K"+
		"\u031b\3\2\2\2M\u0328\3\2\2\2O\u0335\3\2\2\2Q\u033d\3\2\2\2S\u0351\3\2"+
		"\2\2U\u0362\3\2\2\2W\u0364\3\2\2\2Y\u0369\3\2\2\2[\u0379\3\2\2\2]\u0386"+
		"\3\2\2\2_\u0388\3\2\2\2a\u038f\3\2\2\2c\u0392\3\2\2\2e\u0398\3\2\2\2g"+
		"\u039b\3\2\2\2i\u039e\3\2\2\2k\u03a1\3\2\2\2m\u03ae\3\2\2\2o\u03ba\3\2"+
		"\2\2q\u03be\3\2\2\2s\u03c4\3\2\2\2u\u03c8\3\2\2\2w\u03cc\3\2\2\2y\u03d0"+
		"\3\2\2\2{\u03d4\3\2\2\2}\u03db\3\2\2\2\177\u03e0\3\2\2\2\u0081\u03e3\3"+
		"\2\2\2\u0083\u03e8\3\2\2\2\u0085\u03fb\3\2\2\2\u0087\u0088\7q\2\2\u0088"+
		"\u0089\7h\2\2\u0089\4\3\2\2\2\u008a\u008e\7v\2\2\u008b\u008c\7v\2\2\u008c"+
		"\u008e\7q\2\2\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\5\65\33\2\u0090\6\3\2\2\2\u0091\u0092\7j\2\2\u0092\u0093"+
		"\7q\2\2\u0093\u0094\7y\2\2\u0094\u0095\3\2\2\2\u0095\u0096\5\u0081A\2"+
		"\u0096\u0097\7o\2\2\u0097\u0098\7w\2\2\u0098\u0099\7e\2\2\u0099\u009a"+
		"\7j\2\2\u009a\u00a3\3\2\2\2\u009b\u00a1\5\u0081A\2\u009c\u009d\7k\2\2"+
		"\u009d\u00a2\7u\2\2\u009e\u009f\7y\2\2\u009f\u00a0\7c\2\2\u00a0\u00a2"+
		"\7u\2\2\u00a1\u009c\3\2\2\2\u00a1\u009e\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3"+
		"\u009b\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\b\3\2\2\2\u00a5\u00a6\7y\2\2"+
		"\u00a6\u00a7\7j\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ab\5\u0081A\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7u\2\2"+
		"\u00ad\u00e2\3\2\2\2\u00ae\u00af\7y\2\2\u00af\u00b0\7j\2\2\u00b0\u00b1"+
		"\7c\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\5\u0081A\2"+
		"\u00b4\u00b5\7y\2\2\u00b5\u00b6\7c\2\2\u00b6\u00b7\7u\2\2\u00b7\u00e2"+
		"\3\2\2\2\u00b8\u00b9\7y\2\2\u00b9\u00ba\7j\2\2\u00ba\u00bb\7c\2\2\u00bb"+
		"\u00bc\7v\2\2\u00bc\u00bd\7)\2\2\u00bd\u00e2\7u\2\2\u00be\u00bf\7y\2\2"+
		"\u00bf\u00c0\7j\2\2\u00c0\u00c1\7c\2\2\u00c1\u00c2\7v\2\2\u00c2\u00e2"+
		"\7u\2\2\u00c3\u00c4\7y\2\2\u00c4\u00c5\7c\2\2\u00c5\u00c6\7j\2\2\u00c6"+
		"\u00c7\7v\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\5\u0081A\2\u00c9\u00ca\7"+
		"k\2\2\u00ca\u00cb\7u\2\2\u00cb\u00e2\3\2\2\2\u00cc\u00cd\7y\2\2\u00cd"+
		"\u00ce\7c\2\2\u00ce\u00cf\7j\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\3\2\2"+
		"\2\u00d1\u00d2\5\u0081A\2\u00d2\u00d3\7y\2\2\u00d3\u00d4\7c\2\2\u00d4"+
		"\u00d5\7u\2\2\u00d5\u00e2\3\2\2\2\u00d6\u00d7\7y\2\2\u00d7\u00d8\7c\2"+
		"\2\u00d8\u00d9\7j\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7)\2\2\u00db\u00e2"+
		"\7u\2\2\u00dc\u00dd\7y\2\2\u00dd\u00de\7c\2\2\u00de\u00df\7j\2\2\u00df"+
		"\u00e0\7v\2\2\u00e0\u00e2\7u\2\2\u00e1\u00a5\3\2\2\2\u00e1\u00ae\3\2\2"+
		"\2\u00e1\u00b8\3\2\2\2\u00e1\u00be\3\2\2\2\u00e1\u00c3\3\2\2\2\u00e1\u00cc"+
		"\3\2\2\2\u00e1\u00d6\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e2\n\3\2\2\2\u00e3"+
		"\u00e4\7v\2\2\u00e4\u00e5\7j\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\3\2\2"+
		"\2\u00e7\u00e8\5\u0081A\2\u00e8\u00e9\7r\2\2\u00e9\u00ea\7t\2\2\u00ea"+
		"\u00eb\7k\2\2\u00eb\u00ec\7e\2\2\u00ec\u00ed\7g\2\2\u00ed\u00f2\3\2\2"+
		"\2\u00ee\u00ef\5\u0081A\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7h\2\2\u00f1"+
		"\u00f3\3\2\2\2\u00f2\u00ee\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u0106\3\2"+
		"\2\2\u00f4\u00f5\7v\2\2\u00f5\u00f6\7j\2\2\u00f6\u00f7\7g\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\u00fa\5\u0081A\2\u00f9\u00f4\3\2\2\2\u00f9\u00fa\3\2\2"+
		"\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\7r\2\2\u00fc\u00fd\7t\2\2\u00fd\u00fe"+
		"\7k\2\2\u00fe\u00ff\7e\2\2\u00ff\u0100\7g\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0102\5\u0081A\2\u0102\u0103\7q\2\2\u0103\u0104\7h\2\2\u0104\u0106\3"+
		"\2\2\2\u0105\u00e3\3\2\2\2\u0105\u00f9\3\2\2\2\u0106\f\3\2\2\2\u0107\u0108"+
		"\7t\2\2\u0108\u0109\7k\2\2\u0109\u010a\7i\2\2\u010a\u010b\7j\2\2\u010b"+
		"\u010c\7v\2\2\u010c\u010d\3\2\2\2\u010d\u010f\5\u0081A\2\u010e\u0107\3"+
		"\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7p\2\2\u0111"+
		"\u0112\7q\2\2\u0112\u0113\7y\2\2\u0113\16\3\2\2\2\u0114\u0115\7d\2\2\u0115"+
		"\u0116\7g\2\2\u0116\u0117\7v\2\2\u0117\u0118\7y\2\2\u0118\u0119\7g\2\2"+
		"\u0119\u011a\7g\2\2\u011a\u0122\7p\2\2\u011b\u011c\7d\2\2\u011c\u011d"+
		"\7g\2\2\u011d\u011e\7v\2\2\u011e\u011f\7y\2\2\u011f\u0120\7g\2\2\u0120"+
		"\u0122\7p\2\2\u0121\u0114\3\2\2\2\u0121\u011b\3\2\2\2\u0122\20\3\2\2\2"+
		"\u0123\u0125\5\u0081A\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u012a\3\2\2\2\u0126\u0127\7c\2\2\u0127\u0128\7p\2\2\u0128\u012b\7f\2"+
		"\2\u0129\u012b\7/\2\2\u012a\u0126\3\2\2\2\u012a\u0129\3\2\2\2\u012b\u012d"+
		"\3\2\2\2\u012c\u012e\5\u0081A\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2"+
		"\2\u012e\22\3\2\2\2\u012f\u0130\7q\2\2\u0130\u0131\7p\2\2\u0131\24\3\2"+
		"\2\2\u0132\u0133\7u\2\2\u0133\u0134\7v\2\2\u0134\u0135\7c\2\2\u0135\u0136"+
		"\7v\2\2\u0136\u0137\7k\2\2\u0137\u0138\7u\2\2\u0138\u0139\7v\2\2\u0139"+
		"\u013a\7k\2\2\u013a\u013b\7e\2\2\u013b\u0142\7u\2\2\u013c\u013d\7u\2\2"+
		"\u013d\u013e\7v\2\2\u013e\u013f\7c\2\2\u013f\u0140\7v\2\2\u0140\u0142"+
		"\7u\2\2\u0141\u0132\3\2\2\2\u0141\u013c\3\2\2\2\u0142\26\3\2\2\2\u0143"+
		"\u0144\7u\2\2\u0144\u0145\7g\2\2\u0145\u0146\7c\2\2\u0146\u0147\7t\2\2"+
		"\u0147\u0148\7e\2\2\u0148\u0158\7j\2\2\u0149\u014a\7u\2\2\u014a\u014b"+
		"\7g\2\2\u014b\u014c\7c\2\2\u014c\u014d\7e\2\2\u014d\u0158\7j\2\2\u014e"+
		"\u014f\7n\2\2\u014f\u0158\7u\2\2\u0150\u0151\7n\2\2\u0151\u0152\7k\2\2"+
		"\u0152\u0153\7u\2\2\u0153\u0158\7v\2\2\u0154\u0155\7f\2\2\u0155\u0156"+
		"\7k\2\2\u0156\u0158\7t\2\2\u0157\u0143\3\2\2\2\u0157\u0149\3\2\2\2\u0157"+
		"\u014e\3\2\2\2\u0157\u0150\3\2\2\2\u0157\u0154\3\2\2\2\u0158\30\3\2\2"+
		"\2\u0159\u015a\7g\2\2\u015a\u015b\7z\2\2\u015b\u015c\7r\2\2\u015c\u015d"+
		"\7q\2\2\u015d\u015e\7t\2\2\u015e\u018c\7v\2\2\u015f\u0160\7u\2\2\u0160"+
		"\u0161\7r\2\2\u0161\u0162\7t\2\2\u0162\u0163\7g\2\2\u0163\u0164\7c\2\2"+
		"\u0164\u0165\7f\2\2\u0165\u0166\7u\2\2\u0166\u0167\7j\2\2\u0167\u0168"+
		"\7g\2\2\u0168\u0169\7g\2\2\u0169\u018c\7v\2\2\u016a\u016b\7g\2\2\u016b"+
		"\u016c\7z\2\2\u016c\u016d\7e\2\2\u016d\u016e\7g\2\2\u016e\u018c\7n\2\2"+
		"\u016f\u0170\7e\2\2\u0170\u0171\7u\2\2\u0171\u018c\7x\2\2\u0172\u0173"+
		"\7j\2\2\u0173\u0174\7k\2\2\u0174\u0175\7u\2\2\u0175\u0176\7v\2\2\u0176"+
		"\u0177\7q\2\2\u0177\u0178\7t\2\2\u0178\u018c\7{\2\2\u0179\u017a\7j\2\2"+
		"\u017a\u017b\7k\2\2\u017b\u017c\7u\2\2\u017c\u017d\7v\2\2\u017d\u017e"+
		"\7q\2\2\u017e\u017f\7t\2\2\u017f\u0180\7k\2\2\u0180\u0181\7e\2\2\u0181"+
		"\u0182\7c\2\2\u0182\u018c\7n\2\2\u0183\u0184\7f\2\2\u0184\u0185\7q\2\2"+
		"\u0185\u0186\7y\2\2\u0186\u0187\7p\2\2\u0187\u0188\7n\2\2\u0188\u0189"+
		"\7q\2\2\u0189\u018a\7c\2\2\u018a\u018c\7f\2\2\u018b\u0159\3\2\2\2\u018b"+
		"\u015f\3\2\2\2\u018b\u016a\3\2\2\2\u018b\u016f\3\2\2\2\u018b\u0172\3\2"+
		"\2\2\u018b\u0179\3\2\2\2\u018b\u0183\3\2\2\2\u018c\32\3\2\2\2\u018d\u018f"+
		"\5\37\20\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2"+
		"\u0190\u0191\3\2\2\2\u0191\34\3\2\2\2\u0192\u0193\5\37\20\2\u0193\u0194"+
		"\5\37\20\2\u0194\u0195\5\37\20\2\u0195\u0196\5\37\20\2\u0196\36\3\2\2"+
		"\2\u0197\u0198\t\2\2\2\u0198 \3\2\2\2\u0199\u019a\5\35\17\2\u019a\u019b"+
		"\7/\2\2\u019b\u019c\5\37\20\2\u019c\u019d\5\37\20\2\u019d\u019e\7/\2\2"+
		"\u019e\u019f\5\37\20\2\u019f\u01a0\5\37\20\2\u01a0\"\3\2\2\2\u01a1\u01a3"+
		"\5\37\20\2\u01a2\u01a4\5\37\20\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2\2"+
		"\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\7\61\2\2\u01a6\u01a8\5\37\20\2\u01a7"+
		"\u01a9\5\37\20\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\3"+
		"\2\2\2\u01aa\u01ab\7\61\2\2\u01ab\u01ac\5\37\20\2\u01ac\u01b0\5\37\20"+
		"\2\u01ad\u01ae\5\37\20\2\u01ae\u01af\5\37\20\2\u01af\u01b1\3\2\2\2\u01b0"+
		"\u01ad\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1$\3\2\2\2\u01b2\u01b4\5\37\20"+
		"\2\u01b3\u01b5\5\37\20\2\u01b4\u01b3\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u01b6\3\2\2\2\u01b6\u01b7\7\61\2\2\u01b7\u01b9\5\37\20\2\u01b8\u01ba"+
		"\5\37\20\2\u01b9\u01b8\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba&\3\2\2\2\u01bb"+
		"\u01be\5)\25\2\u01bc\u01be\5+\26\2\u01bd\u01bb\3\2\2\2\u01bd\u01bc\3\2"+
		"\2\2\u01be(\3\2\2\2\u01bf\u01c0\7l\2\2\u01c0\u01c1\7c\2\2\u01c1\u01e2"+
		"\7p\2\2\u01c2\u01c3\7h\2\2\u01c3\u01c4\7g\2\2\u01c4\u01e2\7d\2\2\u01c5"+
		"\u01c6\7o\2\2\u01c6\u01c7\7c\2\2\u01c7\u01e2\7t\2\2\u01c8\u01c9\7c\2\2"+
		"\u01c9\u01ca\7r\2\2\u01ca\u01e2\7t\2\2\u01cb\u01e2\5-\27\2\u01cc\u01cd"+
		"\7l\2\2\u01cd\u01ce\7w\2\2\u01ce\u01e2\7p\2\2\u01cf\u01d0\7l\2\2\u01d0"+
		"\u01d1\7w\2\2\u01d1\u01e2\7n\2\2\u01d2\u01d3\7c\2\2\u01d3\u01d4\7w\2\2"+
		"\u01d4\u01e2\7i\2\2\u01d5\u01d6\7u\2\2\u01d6\u01d7\7g\2\2\u01d7\u01e2"+
		"\7r\2\2\u01d8\u01d9\7q\2\2\u01d9\u01da\7e\2\2\u01da\u01e2\7v\2\2\u01db"+
		"\u01dc\7p\2\2\u01dc\u01dd\7q\2\2\u01dd\u01e2\7x\2\2\u01de\u01df\7f\2\2"+
		"\u01df\u01e0\7g\2\2\u01e0\u01e2\7e\2\2\u01e1\u01bf\3\2\2\2\u01e1\u01c2"+
		"\3\2\2\2\u01e1\u01c5\3\2\2\2\u01e1\u01c8\3\2\2\2\u01e1\u01cb\3\2\2\2\u01e1"+
		"\u01cc\3\2\2\2\u01e1\u01cf\3\2\2\2\u01e1\u01d2\3\2\2\2\u01e1\u01d5\3\2"+
		"\2\2\u01e1\u01d8\3\2\2\2\u01e1\u01db\3\2\2\2\u01e1\u01de\3\2\2\2\u01e2"+
		"*\3\2\2\2\u01e3\u01e4\7l\2\2\u01e4\u01e5\7c\2\2\u01e5\u01e6\7p\2\2\u01e6"+
		"\u01e7\7w\2\2\u01e7\u01e8\7c\2\2\u01e8\u01e9\7t\2\2\u01e9\u022c\7{\2\2"+
		"\u01ea\u01eb\7h\2\2\u01eb\u01ec\7g\2\2\u01ec\u01ed\7d\2\2\u01ed\u01ee"+
		"\7t\2\2\u01ee\u01ef\7w\2\2\u01ef\u01f0\7c\2\2\u01f0\u01f1\7t\2\2\u01f1"+
		"\u022c\7{\2\2\u01f2\u01f3\7o\2\2\u01f3\u01f4\7c\2\2\u01f4\u01f5\7t\2\2"+
		"\u01f5\u01f6\7e\2\2\u01f6\u022c\7j\2\2\u01f7\u01f8\7c\2\2\u01f8\u01f9"+
		"\7r\2\2\u01f9\u01fa\7t\2\2\u01fa\u01fb\7k\2\2\u01fb\u022c\7n\2\2\u01fc"+
		"\u022c\5-\27\2\u01fd\u01fe\7l\2\2\u01fe\u01ff\7w\2\2\u01ff\u0200\7p\2"+
		"\2\u0200\u022c\7g\2\2\u0201\u0202\7l\2\2\u0202\u0203\7w\2\2\u0203\u0204"+
		"\7n\2\2\u0204\u022c\7{\2\2\u0205\u0206\7c\2\2\u0206\u0207\7w\2\2\u0207"+
		"\u0208\7i\2\2\u0208\u0209\7w\2\2\u0209\u020a\7u\2\2\u020a\u022c\7v\2\2"+
		"\u020b\u020c\7u\2\2\u020c\u020d\7g\2\2\u020d\u020e\7r\2\2\u020e\u020f"+
		"\7v\2\2\u020f\u0210\7g\2\2\u0210\u0211\7o\2\2\u0211\u0212\7d\2\2\u0212"+
		"\u0213\7g\2\2\u0213\u022c\7t\2\2\u0214\u0215\7q\2\2\u0215\u0216\7e\2\2"+
		"\u0216\u0217\7v\2\2\u0217\u0218\7q\2\2\u0218\u0219\7d\2\2\u0219\u021a"+
		"\7g\2\2\u021a\u022c\7t\2\2\u021b\u021c\7p\2\2\u021c\u021d\7q\2\2\u021d"+
		"\u021e\7x\2\2\u021e\u021f\7g\2\2\u021f\u0220\7o\2\2\u0220\u0221\7d\2\2"+
		"\u0221\u0222\7g\2\2\u0222\u022c\7t\2\2\u0223\u0224\7f\2\2\u0224\u0225"+
		"\7g\2\2\u0225\u0226\7e\2\2\u0226\u0227\7g\2\2\u0227\u0228\7o\2\2\u0228"+
		"\u0229\7d\2\2\u0229\u022a\7g\2\2\u022a\u022c\7t\2\2\u022b\u01e3\3\2\2"+
		"\2\u022b\u01ea\3\2\2\2\u022b\u01f2\3\2\2\2\u022b\u01f7\3\2\2\2\u022b\u01fc"+
		"\3\2\2\2\u022b\u01fd\3\2\2\2\u022b\u0201\3\2\2\2\u022b\u0205\3\2\2\2\u022b"+
		"\u020b\3\2\2\2\u022b\u0214\3\2\2\2\u022b\u021b\3\2\2\2\u022b\u0223\3\2"+
		"\2\2\u022c,\3\2\2\2\u022d\u022e\7o\2\2\u022e\u022f\7c\2\2\u022f\u0230"+
		"\7{\2\2\u0230.\3\2\2\2\u0231\u0232\7n\2\2\u0232\u0233\7c\2\2\u0233\u0234"+
		"\7u\2\2\u0234\u0239\7v\2\2\u0235\u0236\7n\2\2\u0236\u0237\7u\2\2\u0237"+
		"\u0239\7v\2\2\u0238\u0231\3\2\2\2\u0238\u0235\3\2\2\2\u0239\60\3\2\2\2"+
		"\u023a\u023b\7o\2\2\u023b\u023c\7q\2\2\u023c\u028c\7p\2\2\u023d\u023e"+
		"\7o\2\2\u023e\u023f\7q\2\2\u023f\u0240\7p\2\2\u0240\u0241\7f\2\2\u0241"+
		"\u0242\7c\2\2\u0242\u028c\7{\2\2\u0243\u0244\7v\2\2\u0244\u0245\7w\2\2"+
		"\u0245\u028c\7g\2\2\u0246\u0247\7v\2\2\u0247\u0248\7w\2\2\u0248\u0249"+
		"\7g\2\2\u0249\u024a\7u\2\2\u024a\u024b\7f\2\2\u024b\u024c\7c\2\2\u024c"+
		"\u028c\7{\2\2\u024d\u024e\7y\2\2\u024e\u024f\7g\2\2\u024f\u028c\7f\2\2"+
		"\u0250\u0251\7y\2\2\u0251\u0252\7g\2\2\u0252\u0253\7f\2\2\u0253\u0254"+
		"\7p\2\2\u0254\u0255\7g\2\2\u0255\u0256\7u\2\2\u0256\u0257\7f\2\2\u0257"+
		"\u0258\7c\2\2\u0258\u028c\7{\2\2\u0259\u025a\7v\2\2\u025a\u025b\7j\2\2"+
		"\u025b\u028c\7w\2\2\u025c\u025d\7v\2\2\u025d\u025e\7j\2\2\u025e\u025f"+
		"\7w\2\2\u025f\u0260\7t\2\2\u0260\u028c\7u\2\2\u0261\u0262\7v\2\2\u0262"+
		"\u0263\7j\2\2\u0263\u0264\7w\2\2\u0264\u0265\7t\2\2\u0265\u0266\7u\2\2"+
		"\u0266\u0267\7f\2\2\u0267\u0268\7c\2\2\u0268\u028c\7{\2\2\u0269\u026a"+
		"\7h\2\2\u026a\u026b\7t\2\2\u026b\u028c\7k\2\2\u026c\u026d\7h\2\2\u026d"+
		"\u026e\7t\2\2\u026e\u026f\7k\2\2\u026f\u0270\7f\2\2\u0270\u0271\7c\2\2"+
		"\u0271\u028c\7{\2\2\u0272\u0273\7u\2\2\u0273\u0274\7c\2\2\u0274\u028c"+
		"\7v\2\2\u0275\u0276\7u\2\2\u0276\u0277\7c\2\2\u0277\u0278\7v\2\2\u0278"+
		"\u0279\7w\2\2\u0279\u028c\7t\2\2\u027a\u027b\7u\2\2\u027b\u027c\7c\2\2"+
		"\u027c\u027d\7v\2\2\u027d\u027e\7w\2\2\u027e\u027f\7t\2\2\u027f\u0280"+
		"\7f\2\2\u0280\u0281\7c\2\2\u0281\u028c\7{\2\2\u0282\u0283\7u\2\2\u0283"+
		"\u0284\7w\2\2\u0284\u028c\7p\2\2\u0285\u0286\7u\2\2\u0286\u0287\7w\2\2"+
		"\u0287\u0288\7p\2\2\u0288\u0289\7f\2\2\u0289\u028a\7c\2\2\u028a\u028c"+
		"\7{\2\2\u028b\u023a\3\2\2\2\u028b\u023d\3\2\2\2\u028b\u0243\3\2\2\2\u028b"+
		"\u0246\3\2\2\2\u028b\u024d\3\2\2\2\u028b\u0250\3\2\2\2\u028b\u0259\3\2"+
		"\2\2\u028b\u025c\3\2\2\2\u028b\u0261\3\2\2\2\u028b\u0269\3\2\2\2\u028b"+
		"\u026c\3\2\2\2\u028b\u0272\3\2\2\2\u028b\u0275\3\2\2\2\u028b\u027a\3\2"+
		"\2\2\u028b\u0282\3\2\2\2\u028b\u0285\3\2\2\2\u028c\62\3\2\2\2\u028d\u028e"+
		"\7c\2\2\u028e\u028f\7i\2\2\u028f\u0294\7q\2\2\u0290\u0291\7c\2\2\u0291"+
		"\u0292\7i\2\2\u0292\u0294\7r\2\2\u0293\u028d\3\2\2\2\u0293\u0290\3\2\2"+
		"\2\u0294\64\3\2\2\2\u0295\u0296\7f\2\2\u0296\u0297\7c\2\2\u0297\u029d"+
		"\7{\2\2\u0298\u0299\7f\2\2\u0299\u029a\7c\2\2\u029a\u029b\7{\2\2\u029b"+
		"\u029d\7u\2\2\u029c\u0295\3\2\2\2\u029c\u0298\3\2\2\2\u029d\66\3\2\2\2"+
		"\u029e\u02a0\7{\2\2\u029f\u02a1\7g\2\2\u02a0\u029f\3\2\2\2\u02a0\u02a1"+
		"\3\2\2\2\u02a1\u02a2\3\2\2\2\u02a2\u02a3\7u\2\2\u02a3\u02a4\7v\2\2\u02a4"+
		"\u02a6\3\2\2\2\u02a5\u02a7\7g\2\2\u02a6\u02a5\3\2\2\2\u02a6\u02a7\3\2"+
		"\2\2\u02a7\u02a8\3\2\2\2\u02a8\u02a9\7t\2\2\u02a9\u02aa\7f\2\2\u02aa\u02ac"+
		"\3\2\2\2\u02ab\u02ad\7c\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2\2\2\u02ad"+
		"\u02ae\3\2\2\2\u02ae\u02af\7{\2\2\u02af8\3\2\2\2\u02b0\u02b1\7o\2\2\u02b1"+
		"\u02b2\7q\2\2\u02b2\u02b3\7p\2\2\u02b3\u02b4\7v\2\2\u02b4\u02b6\3\2\2"+
		"\2\u02b5\u02b7\7j\2\2\u02b6\u02b5\3\2\2\2\u02b6\u02b7\3\2\2\2\u02b7\u02c2"+
		"\3\2\2\2\u02b8\u02b9\7o\2\2\u02b9\u02ba\7q\2\2\u02ba\u02bb\7p\2\2\u02bb"+
		"\u02bc\7v\2\2\u02bc\u02be\3\2\2\2\u02bd\u02bf\7j\2\2\u02be\u02bd\3\2\2"+
		"\2\u02be\u02bf\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0\u02c2\7u\2\2\u02c1\u02b0"+
		"\3\2\2\2\u02c1\u02b8\3\2\2\2\u02c2:\3\2\2\2\u02c3\u02c4\7y\2\2\u02c4\u02c5"+
		"\7g\2\2\u02c5\u02c6\7g\2\2\u02c6\u02cd\7m\2\2\u02c7\u02c8\7y\2\2\u02c8"+
		"\u02c9\7g\2\2\u02c9\u02ca\7g\2\2\u02ca\u02cb\7m\2\2\u02cb\u02cd\7u\2\2"+
		"\u02cc\u02c3\3\2\2\2\u02cc\u02c7\3\2\2\2\u02cd<\3\2\2\2\u02ce\u02cf\t"+
		"\3\2\2\u02cf\u02d0\7g\2\2\u02d0\u02d1\7c\2\2\u02d1\u02d2\7t\2\2\u02d2"+
		"\u02d4\3\2\2\2\u02d3\u02d5\7u\2\2\u02d4\u02d3\3\2\2\2\u02d4\u02d5\3\2"+
		"\2\2\u02d5>\3\2\2\2\u02d6\u02d7\7u\2\2\u02d7\u02df\7v\2\2\u02d8\u02d9"+
		"\7p\2\2\u02d9\u02df\7f\2\2\u02da\u02db\7t\2\2\u02db\u02df\7f\2\2\u02dc"+
		"\u02dd\7v\2\2\u02dd\u02df\7j\2\2\u02de\u02d6\3\2\2\2\u02de\u02d8\3\2\2"+
		"\2\u02de\u02da\3\2\2\2\u02de\u02dc\3\2\2\2\u02df@\3\2\2\2\u02e0\u02e3"+
		"\5C\"\2\u02e1\u02e3\5E#\2\u02e2\u02e0\3\2\2\2\u02e2\u02e1\3\2\2\2\u02e3"+
		"B\3\2\2\2\u02e4\u02ee\5G$\2\u02e5\u02ee\5I%\2\u02e6\u02ee\5K&\2\u02e7"+
		"\u02ee\5M\'\2\u02e8\u02ee\5O(\2\u02e9\u02ee\5Q)\2\u02ea\u02ee\5S*\2\u02eb"+
		"\u02ee\5U+\2\u02ec\u02ee\5W,\2\u02ed\u02e4\3\2\2\2\u02ed\u02e5\3\2\2\2"+
		"\u02ed\u02e6\3\2\2\2\u02ed\u02e7\3\2\2\2\u02ed\u02e8\3\2\2\2\u02ed\u02e9"+
		"\3\2\2\2\u02ed\u02ea\3\2\2\2\u02ed\u02eb\3\2\2\2\u02ed\u02ec\3\2\2\2\u02ee"+
		"D\3\2\2\2\u02ef\u0301\5[.\2\u02f0\u0301\5]/\2\u02f1\u0301\5_\60\2\u02f2"+
		"\u0301\5a\61\2\u02f3\u0301\5c\62\2\u02f4\u0301\5e\63\2\u02f5\u0301\5g"+
		"\64\2\u02f6\u0301\5i\65\2\u02f7\u0301\5k\66\2\u02f8\u0301\5m\67\2\u02f9"+
		"\u0301\5o8\2\u02fa\u0301\5q9\2\u02fb\u0301\5s:\2\u02fc\u0301\5u;\2\u02fd"+
		"\u0301\5w<\2\u02fe\u0301\5y=\2\u02ff\u0301\5{>\2\u0300\u02ef\3\2\2\2\u0300"+
		"\u02f0\3\2\2\2\u0300\u02f1\3\2\2\2\u0300\u02f2\3\2\2\2\u0300\u02f3\3\2"+
		"\2\2\u0300\u02f4\3\2\2\2\u0300\u02f5\3\2\2\2\u0300\u02f6\3\2\2\2\u0300"+
		"\u02f7\3\2\2\2\u0300\u02f8\3\2\2\2\u0300\u02f9\3\2\2\2\u0300\u02fa\3\2"+
		"\2\2\u0300\u02fb\3\2\2\2\u0300\u02fc\3\2\2\2\u0300\u02fd\3\2\2\2\u0300"+
		"\u02fe\3\2\2\2\u0300\u02ff\3\2\2\2\u0301F\3\2\2\2\u0302\u0303\7q\2\2\u0303"+
		"\u0304\7p\2\2\u0304\u0305\7g\2\2\u0305H\3\2\2\2\u0306\u0307\7v\2\2\u0307"+
		"\u0308\7y\2\2\u0308\u0309\7q\2\2\u0309J\3\2\2\2\u030a\u030b\7v\2\2\u030b"+
		"\u030c\7j\2\2\u030c\u030d\7t\2\2\u030d\u030e\7g\2\2\u030e\u031c\7g\2\2"+
		"\u030f\u0310\7v\2\2\u0310\u0311\7j\2\2\u0311\u0312\7g\2\2\u0312\u031c"+
		"\7g\2\2\u0313\u0314\7v\2\2\u0314\u0315\7t\2\2\u0315\u0316\7g\2\2\u0316"+
		"\u031c\7g\2\2\u0317\u0318\7v\2\2\u0318\u0319\7j\2\2\u0319\u031a\7t\2\2"+
		"\u031a\u031c\7g\2\2\u031b\u030a\3\2\2\2\u031b\u030f\3\2\2\2\u031b\u0313"+
		"\3\2\2\2\u031b\u0317\3\2\2\2\u031cL\3\2\2\2\u031d\u031e\7h\2\2\u031e\u031f"+
		"\7q\2\2\u031f\u0320\7w\2\2\u0320\u0329\7t\2\2\u0321\u0322\7h\2\2\u0322"+
		"\u0323\7q\2\2\u0323\u0329\7t\2\2\u0324\u0325\7h\2\2\u0325\u0326\7q\2\2"+
		"\u0326\u0327\7c\2\2\u0327\u0329\7t\2\2\u0328\u031d\3\2\2\2\u0328\u0321"+
		"\3\2\2\2\u0328\u0324\3\2\2\2\u0329N\3\2\2\2\u032a\u032b\7h\2\2\u032b\u032c"+
		"\7k\2\2\u032c\u032d\7x\2\2\u032d\u0336\7g\2\2\u032e\u032f\7h\2\2\u032f"+
		"\u0330\7k\2\2\u0330\u0336\7x\2\2\u0331\u0332\7h\2\2\u0332\u0333\7k\2\2"+
		"\u0333\u0334\7x\2\2\u0334\u0336\7t\2\2\u0335\u032a\3\2\2\2\u0335\u032e"+
		"\3\2\2\2\u0335\u0331\3\2\2\2\u0336P\3\2\2\2\u0337\u0338\7u\2\2\u0338\u0339"+
		"\7k\2\2\u0339\u033e\7z\2\2\u033a\u033b\7u\2\2\u033b\u033c\7k\2\2\u033c"+
		"\u033e\7e\2\2\u033d\u0337\3\2\2\2\u033d\u033a\3\2\2\2\u033eR\3\2\2\2\u033f"+
		"\u0340\7u\2\2\u0340\u0341\7g\2\2\u0341\u0342\7x\2\2\u0342\u0343\7g\2\2"+
		"\u0343\u0352\7p\2\2\u0344\u0345\7u\2\2\u0345\u0346\7g\2\2\u0346\u0347"+
		"\7x\2\2\u0347\u0348\7g\2\2\u0348\u0352\7o\2\2\u0349\u034a\7u\2\2\u034a"+
		"\u034b\7g\2\2\u034b\u034c\7x\2\2\u034c\u0352\7p\2\2\u034d\u034e\7u\2\2"+
		"\u034e\u034f\7g\2\2\u034f\u0350\7g\2\2\u0350\u0352\7p\2\2\u0351\u033f"+
		"\3\2\2\2\u0351\u0344\3\2\2\2\u0351\u0349\3\2\2\2\u0351\u034d\3\2\2\2\u0352"+
		"T\3\2\2\2\u0353\u0354\7g\2\2\u0354\u0355\7k\2\2\u0355\u0356\7i\2\2\u0356"+
		"\u0357\7j\2\2\u0357\u0363\7v\2\2\u0358\u0359\7g\2\2\u0359\u035a\7w\2\2"+
		"\u035a\u035b\7i\2\2\u035b\u035c\7j\2\2\u035c\u0363\7v\2\2\u035d\u035e"+
		"\7g\2\2\u035e\u035f\7k\2\2\u035f\u0360\7i\2\2\u0360\u0361\7v\2\2\u0361"+
		"\u0363\7j\2\2\u0362\u0353\3\2\2\2\u0362\u0358\3\2\2\2\u0362\u035d\3\2"+
		"\2\2\u0363V\3\2\2\2\u0364\u0365\7p\2\2\u0365\u0366\7k\2\2\u0366\u0367"+
		"\7p\2\2\u0367\u0368\7g\2\2\u0368X\3\2\2\2\u0369\u036a\7v\2\2\u036a\u036b"+
		"\7g\2\2\u036b\u036c\7p\2\2\u036cZ\3\2\2\2\u036d\u036e\7g\2\2\u036e\u036f"+
		"\7n\2\2\u036f\u0370\7g\2\2\u0370\u0371\7x\2\2\u0371\u0372\7g\2\2\u0372"+
		"\u037a\7p\2\2\u0373\u0374\7g\2\2\u0374\u0375\7n\2\2\u0375\u0376\7g\2\2"+
		"\u0376\u0377\7x\2\2\u0377\u0378\7g\2\2\u0378\u037a\7o\2\2\u0379\u036d"+
		"\3\2\2\2\u0379\u0373\3\2\2\2\u037a\\\3\2\2\2\u037b\u037c\7v\2\2\u037c"+
		"\u037d\7y\2\2\u037d\u037e\7g\2\2\u037e\u037f\7n\2\2\u037f\u0380\7x\2\2"+
		"\u0380\u0387\7g\2\2\u0381\u0382\7v\2\2\u0382\u0383\7y\2\2\u0383\u0384"+
		"\7n\2\2\u0384\u0385\7x\2\2\u0385\u0387\7g\2\2\u0386\u037b\3\2\2\2\u0386"+
		"\u0381\3\2\2\2\u0387^\3\2\2\2\u0388\u0389\7v\2\2\u0389\u038a\7j\2\2\u038a"+
		"\u038b\7k\2\2\u038b\u038c\7t\2\2\u038c\u038d\3\2\2\2\u038d\u038e\5}?\2"+
		"\u038e`\3\2\2\2\u038f\u0390\5M\'\2\u0390\u0391\5}?\2\u0391b\3\2\2\2\u0392"+
		"\u0393\7h\2\2\u0393\u0394\7k\2\2\u0394\u0395\7h\2\2\u0395\u0396\3\2\2"+
		"\2\u0396\u0397\5}?\2\u0397d\3\2\2\2\u0398\u0399\5Q)\2\u0399\u039a\5}?"+
		"\2\u039af\3\2\2\2\u039b\u039c\5S*\2\u039c\u039d\5}?\2\u039dh\3\2\2\2\u039e"+
		"\u039f\5U+\2\u039f\u03a0\5}?\2\u03a0j\3\2\2\2\u03a1\u03a2\5W,\2\u03a2"+
		"\u03a3\5}?\2\u03a3l\3\2\2\2\u03a4\u03a5\7v\2\2\u03a5\u03a6\7y\2\2\u03a6"+
		"\u03a7\7g\2\2\u03a7\u03ac\7p\2\2\u03a8\u03a9\7v\2\2\u03a9\u03aa\7y\2\2"+
		"\u03aa\u03ac\7p\2\2\u03ab\u03a4\3\2\2\2\u03ab\u03a8\3\2\2\2\u03ac\u03af"+
		"\3\2\2\2\u03ad\u03af\5\177@\2\u03ae\u03ab\3\2\2\2\u03ae\u03ad\3\2\2\2"+
		"\u03afn\3\2\2\2\u03b0\u03b1\7v\2\2\u03b1\u03b2\7j\2\2\u03b2\u03b3\7k\2"+
		"\2\u03b3\u03b8\7t\2\2\u03b4\u03b5\7v\2\2\u03b5\u03b6\7j\2\2\u03b6\u03b8"+
		"\7t\2\2\u03b7\u03b0\3\2\2\2\u03b7\u03b4\3\2\2\2\u03b8\u03bb\3\2\2\2\u03b9"+
		"\u03bb\5\177@\2\u03ba\u03b7\3\2\2\2\u03ba\u03b9\3\2\2\2\u03bbp\3\2\2\2"+
		"\u03bc\u03bf\5M\'\2\u03bd\u03bf\5\177@\2\u03be\u03bc\3\2\2\2\u03be\u03bd"+
		"\3\2\2\2\u03bfr\3\2\2\2\u03c0\u03c1\7h\2\2\u03c1\u03c2\7k\2\2\u03c2\u03c5"+
		"\7h\2\2\u03c3\u03c5\5\177@\2\u03c4\u03c0\3\2\2\2\u03c4\u03c3\3\2\2\2\u03c5"+
		"t\3\2\2\2\u03c6\u03c9\5Q)\2\u03c7\u03c9\5\177@\2\u03c8\u03c6\3\2\2\2\u03c8"+
		"\u03c7\3\2\2\2\u03c9v\3\2\2\2\u03ca\u03cd\5S*\2\u03cb\u03cd\5\177@\2\u03cc"+
		"\u03ca\3\2\2\2\u03cc\u03cb\3\2\2\2\u03cdx\3\2\2\2\u03ce\u03d1\5U+\2\u03cf"+
		"\u03d1\5\177@\2\u03d0\u03ce\3\2\2\2\u03d0\u03cf\3\2\2\2\u03d1z\3\2\2\2"+
		"\u03d2\u03d5\5W,\2\u03d3\u03d5\5\177@\2\u03d4\u03d2\3\2\2\2\u03d4\u03d3"+
		"\3\2\2\2\u03d5|\3\2\2\2\u03d6\u03d7\7v\2\2\u03d7\u03d8\7g\2\2\u03d8\u03d9"+
		"\7g\2\2\u03d9\u03dc\7p\2\2\u03da\u03dc\5Y-\2\u03db\u03d6\3\2\2\2\u03db"+
		"\u03da\3\2\2\2\u03dc~\3\2\2\2\u03dd\u03de\7v\2\2\u03de\u03e1\7{\2\2\u03df"+
		"\u03e1\7{\2\2\u03e0\u03dd\3\2\2\2\u03e0\u03df\3\2\2\2\u03e1\u0080\3\2"+
		"\2\2\u03e2\u03e4\7\"\2\2\u03e3\u03e2\3\2\2\2\u03e4\u03e5\3\2\2\2\u03e5"+
		"\u03e3\3\2\2\2\u03e5\u03e6\3\2\2\2\u03e6\u0082\3\2\2\2\u03e7\u03e9\5\u0081"+
		"A\2\u03e8\u03e7\3\2\2\2\u03e8\u03e9\3\2\2\2\u03e9\u03ea\3\2\2\2\u03ea"+
		"\u03eb\7A\2\2\u03eb\u0084\3\2\2\2\u03ec\u03f0\t\4\2\2\u03ed\u03ef\t\5"+
		"\2\2\u03ee\u03ed\3\2\2\2\u03ef\u03f2\3\2\2\2\u03f0\u03ee\3\2\2\2\u03f0"+
		"\u03f1\3\2\2\2\u03f1\u03fc\3\2\2\2\u03f2\u03f0\3\2\2\2\u03f3\u03f7\7$"+
		"\2\2\u03f4\u03f6\13\2\2\2\u03f5\u03f4\3\2\2\2\u03f6\u03f9\3\2\2\2\u03f7"+
		"\u03f8\3\2\2\2\u03f7\u03f5\3\2\2\2\u03f8\u03fa\3\2\2\2\u03f9\u03f7\3\2"+
		"\2\2\u03fa\u03fc\7$\2\2\u03fb\u03ec\3\2\2\2\u03fb\u03f3\3\2\2\2\u03fc"+
		"\u0086\3\2\2\2D\2\u008d\u00a1\u00a3\u00e1\u00f2\u00f9\u0105\u010e\u0121"+
		"\u0124\u012a\u012d\u0141\u0157\u018b\u0190\u01a3\u01a8\u01b0\u01b4\u01b9"+
		"\u01bd\u01e1\u022b\u0238\u028b\u0293\u029c\u02a0\u02a6\u02ac\u02b6\u02be"+
		"\u02c1\u02cc\u02d4\u02de\u02e2\u02ed\u0300\u031b\u0328\u0335\u033d\u0351"+
		"\u0362\u0379\u0386\u03ab\u03ae\u03b7\u03ba\u03be\u03c4\u03c8\u03cc\u03d0"+
		"\u03d4\u03db\u03e0\u03e5\u03e8\u03f0\u03f7\u03fb\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}