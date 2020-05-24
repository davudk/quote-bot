// Generated from QuoteBot.g4 by ANTLR 4.8

package dk.njit.cs684.quote.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuoteBotParser extends Parser {
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
	public static final int
		RULE_stockQuoteQuery = 0, RULE_historicalStockQuoteQuery = 1, RULE_rangedStockQuoteQuery = 2, 
		RULE_stockStatisticsQuery = 3, RULE_stockSearchQuery = 4, RULE_stockSpreadsheetQuery = 5, 
		RULE_onAnyDate = 6, RULE_anyDate = 7, RULE_cuteDate = 8, RULE_relativeDate = 9, 
		RULE_relativeDay = 10, RULE_relativeWeek = 11, RULE_relativeMonth = 12, 
		RULE_relativeYear = 13, RULE_instantDaysAgo = 14, RULE_instantWeeksAgo = 15, 
		RULE_instantMonthsAgo = 16, RULE_instantYearsAgo = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"stockQuoteQuery", "historicalStockQuoteQuery", "rangedStockQuoteQuery", 
			"stockStatisticsQuery", "stockSearchQuery", "stockSpreadsheetQuery", 
			"onAnyDate", "anyDate", "cuteDate", "relativeDate", "relativeDay", "relativeWeek", 
			"relativeMonth", "relativeYear", "instantDaysAgo", "instantWeeksAgo", 
			"instantMonthsAgo", "instantYearsAgo"
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

	@Override
	public String getGrammarFileName() { return "QuoteBot.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuoteBotParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StockQuoteQueryContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(QuoteBotParser.IDENTIFIER, 0); }
		public TerminalNode EOF() { return getToken(QuoteBotParser.EOF, 0); }
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public TerminalNode THEPRICEOF() { return getToken(QuoteBotParser.THEPRICEOF, 0); }
		public TerminalNode QUESTION() { return getToken(QuoteBotParser.QUESTION, 0); }
		public TerminalNode HOWMUCHISWAS() { return getToken(QuoteBotParser.HOWMUCHISWAS, 0); }
		public TerminalNode WHATISWAS() { return getToken(QuoteBotParser.WHATISWAS, 0); }
		public TerminalNode W_TODAY() { return getToken(QuoteBotParser.W_TODAY, 0); }
		public TerminalNode RIGHTNOW() { return getToken(QuoteBotParser.RIGHTNOW, 0); }
		public StockQuoteQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stockQuoteQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterStockQuoteQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitStockQuoteQuery(this);
		}
	}

	public final StockQuoteQueryContext stockQuoteQuery() throws RecognitionException {
		StockQuoteQueryContext _localctx = new StockQuoteQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stockQuoteQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HOWMUCHISWAS || _la==WHATISWAS) {
				{
				setState(36);
				_la = _input.LA(1);
				if ( !(_la==HOWMUCHISWAS || _la==WHATISWAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(37);
				match(SPACE);
				}
			}

			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THEPRICEOF) {
				{
				setState(40);
				match(THEPRICEOF);
				setState(41);
				match(SPACE);
				}
			}

			setState(44);
			match(IDENTIFIER);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(45);
				match(SPACE);
				setState(46);
				_la = _input.LA(1);
				if ( !(_la==W_TODAY || _la==RIGHTNOW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(49);
				match(QUESTION);
				}
			}

			setState(52);
			match(EOF);
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

	public static class HistoricalStockQuoteQueryContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(QuoteBotParser.IDENTIFIER, 0); }
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public OnAnyDateContext onAnyDate() {
			return getRuleContext(OnAnyDateContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QuoteBotParser.EOF, 0); }
		public TerminalNode THEPRICEOF() { return getToken(QuoteBotParser.THEPRICEOF, 0); }
		public TerminalNode QUESTION() { return getToken(QuoteBotParser.QUESTION, 0); }
		public TerminalNode HOWMUCHISWAS() { return getToken(QuoteBotParser.HOWMUCHISWAS, 0); }
		public TerminalNode WHATISWAS() { return getToken(QuoteBotParser.WHATISWAS, 0); }
		public HistoricalStockQuoteQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_historicalStockQuoteQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterHistoricalStockQuoteQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitHistoricalStockQuoteQuery(this);
		}
	}

	public final HistoricalStockQuoteQueryContext historicalStockQuoteQuery() throws RecognitionException {
		HistoricalStockQuoteQueryContext _localctx = new HistoricalStockQuoteQueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_historicalStockQuoteQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HOWMUCHISWAS || _la==WHATISWAS) {
				{
				setState(54);
				_la = _input.LA(1);
				if ( !(_la==HOWMUCHISWAS || _la==WHATISWAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THEPRICEOF) {
				{
				setState(57);
				match(THEPRICEOF);
				setState(58);
				match(SPACE);
				}
			}

			setState(61);
			match(IDENTIFIER);
			setState(62);
			match(SPACE);
			setState(63);
			onAnyDate();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(64);
				match(QUESTION);
				}
			}

			setState(67);
			match(EOF);
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

	public static class RangedStockQuoteQueryContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(QuoteBotParser.IDENTIFIER, 0); }
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public List<AnyDateContext> anyDate() {
			return getRuleContexts(AnyDateContext.class);
		}
		public AnyDateContext anyDate(int i) {
			return getRuleContext(AnyDateContext.class,i);
		}
		public TerminalNode BETWEEN_SYMBOL() { return getToken(QuoteBotParser.BETWEEN_SYMBOL, 0); }
		public TerminalNode EOF() { return getToken(QuoteBotParser.EOF, 0); }
		public TerminalNode THEPRICEOF() { return getToken(QuoteBotParser.THEPRICEOF, 0); }
		public TerminalNode W_BETWEEN() { return getToken(QuoteBotParser.W_BETWEEN, 0); }
		public TerminalNode QUESTION() { return getToken(QuoteBotParser.QUESTION, 0); }
		public TerminalNode HOWMUCHISWAS() { return getToken(QuoteBotParser.HOWMUCHISWAS, 0); }
		public TerminalNode WHATISWAS() { return getToken(QuoteBotParser.WHATISWAS, 0); }
		public RangedStockQuoteQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangedStockQuoteQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterRangedStockQuoteQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitRangedStockQuoteQuery(this);
		}
	}

	public final RangedStockQuoteQueryContext rangedStockQuoteQuery() throws RecognitionException {
		RangedStockQuoteQueryContext _localctx = new RangedStockQuoteQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rangedStockQuoteQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HOWMUCHISWAS || _la==WHATISWAS) {
				{
				setState(69);
				_la = _input.LA(1);
				if ( !(_la==HOWMUCHISWAS || _la==WHATISWAS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THEPRICEOF) {
				{
				setState(72);
				match(THEPRICEOF);
				setState(73);
				match(SPACE);
				}
			}

			setState(76);
			match(IDENTIFIER);
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(77);
				match(SPACE);
				setState(78);
				match(W_BETWEEN);
				}
				break;
			}
			setState(81);
			match(SPACE);
			setState(82);
			anyDate();
			setState(83);
			match(BETWEEN_SYMBOL);
			setState(84);
			anyDate();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(85);
				match(QUESTION);
				}
			}

			setState(88);
			match(EOF);
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

	public static class StockStatisticsQueryContext extends ParserRuleContext {
		public TerminalNode STATS() { return getToken(QuoteBotParser.STATS, 0); }
		public TerminalNode SPACE() { return getToken(QuoteBotParser.SPACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(QuoteBotParser.IDENTIFIER, 0); }
		public TerminalNode QUESTION() { return getToken(QuoteBotParser.QUESTION, 0); }
		public StockStatisticsQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stockStatisticsQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterStockStatisticsQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitStockStatisticsQuery(this);
		}
	}

	public final StockStatisticsQueryContext stockStatisticsQuery() throws RecognitionException {
		StockStatisticsQueryContext _localctx = new StockStatisticsQueryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stockStatisticsQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(STATS);
			setState(91);
			match(SPACE);
			setState(92);
			match(IDENTIFIER);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(93);
				match(QUESTION);
				}
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

	public static class StockSearchQueryContext extends ParserRuleContext {
		public TerminalNode SEARCH() { return getToken(QuoteBotParser.SEARCH, 0); }
		public TerminalNode SPACE() { return getToken(QuoteBotParser.SPACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(QuoteBotParser.IDENTIFIER, 0); }
		public TerminalNode QUESTION() { return getToken(QuoteBotParser.QUESTION, 0); }
		public StockSearchQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stockSearchQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterStockSearchQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitStockSearchQuery(this);
		}
	}

	public final StockSearchQueryContext stockSearchQuery() throws RecognitionException {
		StockSearchQueryContext _localctx = new StockSearchQueryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stockSearchQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(SEARCH);
			setState(97);
			match(SPACE);
			setState(98);
			match(IDENTIFIER);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(99);
				match(QUESTION);
				}
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

	public static class StockSpreadsheetQueryContext extends ParserRuleContext {
		public TerminalNode SPREADSHEET() { return getToken(QuoteBotParser.SPREADSHEET, 0); }
		public TerminalNode SPACE() { return getToken(QuoteBotParser.SPACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(QuoteBotParser.IDENTIFIER, 0); }
		public TerminalNode QUESTION() { return getToken(QuoteBotParser.QUESTION, 0); }
		public StockSpreadsheetQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stockSpreadsheetQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterStockSpreadsheetQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitStockSpreadsheetQuery(this);
		}
	}

	public final StockSpreadsheetQueryContext stockSpreadsheetQuery() throws RecognitionException {
		StockSpreadsheetQueryContext _localctx = new StockSpreadsheetQueryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stockSpreadsheetQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(SPREADSHEET);
			setState(103);
			match(SPACE);
			setState(104);
			match(IDENTIFIER);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QUESTION) {
				{
				setState(105);
				match(QUESTION);
				}
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

	public static class OnAnyDateContext extends ParserRuleContext {
		public AnyDateContext anyDate() {
			return getRuleContext(AnyDateContext.class,0);
		}
		public TerminalNode W_ON() { return getToken(QuoteBotParser.W_ON, 0); }
		public OnAnyDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onAnyDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterOnAnyDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitOnAnyDate(this);
		}
	}

	public final OnAnyDateContext onAnyDate() throws RecognitionException {
		OnAnyDateContext _localctx = new OnAnyDateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_onAnyDate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==W_ON) {
				{
				setState(108);
				match(W_ON);
				}
			}

			setState(111);
			anyDate();
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

	public static class AnyDateContext extends ParserRuleContext {
		public TerminalNode ISO_DATE() { return getToken(QuoteBotParser.ISO_DATE, 0); }
		public TerminalNode AMERICAN_DATE() { return getToken(QuoteBotParser.AMERICAN_DATE, 0); }
		public TerminalNode AMERICAN_SHORT_DATE() { return getToken(QuoteBotParser.AMERICAN_SHORT_DATE, 0); }
		public CuteDateContext cuteDate() {
			return getRuleContext(CuteDateContext.class,0);
		}
		public RelativeDateContext relativeDate() {
			return getRuleContext(RelativeDateContext.class,0);
		}
		public AnyDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterAnyDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitAnyDate(this);
		}
	}

	public final AnyDateContext anyDate() throws RecognitionException {
		AnyDateContext _localctx = new AnyDateContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_anyDate);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ISO_DATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(ISO_DATE);
				}
				break;
			case AMERICAN_DATE:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(AMERICAN_DATE);
				}
				break;
			case AMERICAN_SHORT_DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				match(AMERICAN_SHORT_DATE);
				}
				break;
			case ANYMONTH:
				enterOuterAlt(_localctx, 4);
				{
				setState(116);
				cuteDate();
				}
				break;
			case W_TODAY:
			case NUMBER:
			case W_LAST:
			case DAY_OF_WEEK:
			case W_YESTERDAY:
				enterOuterAlt(_localctx, 5);
				{
				setState(117);
				relativeDate();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CuteDateContext extends ParserRuleContext {
		public TerminalNode ANYMONTH() { return getToken(QuoteBotParser.ANYMONTH, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(QuoteBotParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(QuoteBotParser.NUMBER, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public TerminalNode ORDINAL_SUFFIX() { return getToken(QuoteBotParser.ORDINAL_SUFFIX, 0); }
		public CuteDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuteDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterCuteDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitCuteDate(this);
		}
	}

	public final CuteDateContext cuteDate() throws RecognitionException {
		CuteDateContext _localctx = new CuteDateContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cuteDate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(ANYMONTH);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(121);
				match(SPACE);
				}
			}

			setState(124);
			match(NUMBER);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDINAL_SUFFIX) {
				{
				setState(125);
				match(ORDINAL_SUFFIX);
				}
			}

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(128);
				match(SPACE);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(129);
					match(T__0);
					setState(130);
					match(SPACE);
					}
				}

				setState(133);
				match(NUMBER);
				}
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

	public static class RelativeDateContext extends ParserRuleContext {
		public TerminalNode DAY_OF_WEEK() { return getToken(QuoteBotParser.DAY_OF_WEEK, 0); }
		public TerminalNode W_LAST() { return getToken(QuoteBotParser.W_LAST, 0); }
		public RelativeDayContext relativeDay() {
			return getRuleContext(RelativeDayContext.class,0);
		}
		public RelativeWeekContext relativeWeek() {
			return getRuleContext(RelativeWeekContext.class,0);
		}
		public RelativeMonthContext relativeMonth() {
			return getRuleContext(RelativeMonthContext.class,0);
		}
		public RelativeYearContext relativeYear() {
			return getRuleContext(RelativeYearContext.class,0);
		}
		public RelativeDateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativeDate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterRelativeDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitRelativeDate(this);
		}
	}

	public final RelativeDateContext relativeDate() throws RecognitionException {
		RelativeDateContext _localctx = new RelativeDateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_relativeDate);
		int _la;
		try {
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==W_LAST) {
					{
					setState(136);
					match(W_LAST);
					}
				}

				setState(139);
				match(DAY_OF_WEEK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				relativeDay();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				relativeWeek();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				relativeMonth();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				relativeYear();
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

	public static class RelativeDayContext extends ParserRuleContext {
		public TerminalNode W_YESTERDAY() { return getToken(QuoteBotParser.W_YESTERDAY, 0); }
		public TerminalNode W_TODAY() { return getToken(QuoteBotParser.W_TODAY, 0); }
		public InstantDaysAgoContext instantDaysAgo() {
			return getRuleContext(InstantDaysAgoContext.class,0);
		}
		public RelativeDayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativeDay; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterRelativeDay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitRelativeDay(this);
		}
	}

	public final RelativeDayContext relativeDay() throws RecognitionException {
		RelativeDayContext _localctx = new RelativeDayContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_relativeDay);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case W_YESTERDAY:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(W_YESTERDAY);
				}
				break;
			case W_TODAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(W_TODAY);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				instantDaysAgo();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RelativeWeekContext extends ParserRuleContext {
		public TerminalNode W_LAST() { return getToken(QuoteBotParser.W_LAST, 0); }
		public TerminalNode SPACE() { return getToken(QuoteBotParser.SPACE, 0); }
		public TerminalNode W_WEEK() { return getToken(QuoteBotParser.W_WEEK, 0); }
		public InstantWeeksAgoContext instantWeeksAgo() {
			return getRuleContext(InstantWeeksAgoContext.class,0);
		}
		public RelativeWeekContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativeWeek; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterRelativeWeek(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitRelativeWeek(this);
		}
	}

	public final RelativeWeekContext relativeWeek() throws RecognitionException {
		RelativeWeekContext _localctx = new RelativeWeekContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_relativeWeek);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case W_LAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(W_LAST);
				setState(152);
				match(SPACE);
				setState(153);
				match(W_WEEK);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				instantWeeksAgo();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RelativeMonthContext extends ParserRuleContext {
		public TerminalNode W_LAST() { return getToken(QuoteBotParser.W_LAST, 0); }
		public TerminalNode SPACE() { return getToken(QuoteBotParser.SPACE, 0); }
		public TerminalNode W_MONTH() { return getToken(QuoteBotParser.W_MONTH, 0); }
		public InstantMonthsAgoContext instantMonthsAgo() {
			return getRuleContext(InstantMonthsAgoContext.class,0);
		}
		public RelativeMonthContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativeMonth; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterRelativeMonth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitRelativeMonth(this);
		}
	}

	public final RelativeMonthContext relativeMonth() throws RecognitionException {
		RelativeMonthContext _localctx = new RelativeMonthContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_relativeMonth);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case W_LAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(W_LAST);
				setState(158);
				match(SPACE);
				setState(159);
				match(W_MONTH);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				instantMonthsAgo();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RelativeYearContext extends ParserRuleContext {
		public TerminalNode W_LAST() { return getToken(QuoteBotParser.W_LAST, 0); }
		public TerminalNode SPACE() { return getToken(QuoteBotParser.SPACE, 0); }
		public TerminalNode W_YEAR() { return getToken(QuoteBotParser.W_YEAR, 0); }
		public InstantYearsAgoContext instantYearsAgo() {
			return getRuleContext(InstantYearsAgoContext.class,0);
		}
		public RelativeYearContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativeYear; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterRelativeYear(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitRelativeYear(this);
		}
	}

	public final RelativeYearContext relativeYear() throws RecognitionException {
		RelativeYearContext _localctx = new RelativeYearContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_relativeYear);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case W_LAST:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(W_LAST);
				setState(164);
				match(SPACE);
				setState(165);
				match(W_YEAR);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				instantYearsAgo();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class InstantDaysAgoContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(QuoteBotParser.NUMBER, 0); }
		public TerminalNode W_DAY() { return getToken(QuoteBotParser.W_DAY, 0); }
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public TerminalNode W_AGO() { return getToken(QuoteBotParser.W_AGO, 0); }
		public InstantDaysAgoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantDaysAgo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterInstantDaysAgo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitInstantDaysAgo(this);
		}
	}

	public final InstantDaysAgoContext instantDaysAgo() throws RecognitionException {
		InstantDaysAgoContext _localctx = new InstantDaysAgoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_instantDaysAgo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(NUMBER);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(170);
				match(SPACE);
				}
			}

			setState(173);
			match(W_DAY);
			setState(174);
			match(SPACE);
			setState(175);
			match(W_AGO);
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

	public static class InstantWeeksAgoContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(QuoteBotParser.NUMBER, 0); }
		public TerminalNode W_WEEK() { return getToken(QuoteBotParser.W_WEEK, 0); }
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public TerminalNode W_AGO() { return getToken(QuoteBotParser.W_AGO, 0); }
		public InstantWeeksAgoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantWeeksAgo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterInstantWeeksAgo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitInstantWeeksAgo(this);
		}
	}

	public final InstantWeeksAgoContext instantWeeksAgo() throws RecognitionException {
		InstantWeeksAgoContext _localctx = new InstantWeeksAgoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_instantWeeksAgo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(NUMBER);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(178);
				match(SPACE);
				}
			}

			setState(181);
			match(W_WEEK);
			setState(182);
			match(SPACE);
			setState(183);
			match(W_AGO);
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

	public static class InstantMonthsAgoContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(QuoteBotParser.NUMBER, 0); }
		public TerminalNode W_MONTH() { return getToken(QuoteBotParser.W_MONTH, 0); }
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public TerminalNode W_AGO() { return getToken(QuoteBotParser.W_AGO, 0); }
		public InstantMonthsAgoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantMonthsAgo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterInstantMonthsAgo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitInstantMonthsAgo(this);
		}
	}

	public final InstantMonthsAgoContext instantMonthsAgo() throws RecognitionException {
		InstantMonthsAgoContext _localctx = new InstantMonthsAgoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_instantMonthsAgo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(NUMBER);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(186);
				match(SPACE);
				}
			}

			setState(189);
			match(W_MONTH);
			setState(190);
			match(SPACE);
			setState(191);
			match(W_AGO);
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

	public static class InstantYearsAgoContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(QuoteBotParser.NUMBER, 0); }
		public TerminalNode W_YEAR() { return getToken(QuoteBotParser.W_YEAR, 0); }
		public List<TerminalNode> SPACE() { return getTokens(QuoteBotParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(QuoteBotParser.SPACE, i);
		}
		public TerminalNode W_AGO() { return getToken(QuoteBotParser.W_AGO, 0); }
		public InstantYearsAgoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantYearsAgo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).enterInstantYearsAgo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuoteBotListener ) ((QuoteBotListener)listener).exitInstantYearsAgo(this);
		}
	}

	public final InstantYearsAgoContext instantYearsAgo() throws RecognitionException {
		InstantYearsAgoContext _localctx = new InstantYearsAgoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_instantYearsAgo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(NUMBER);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SPACE) {
				{
				setState(194);
				match(SPACE);
				}
			}

			setState(197);
			match(W_YEAR);
			setState(198);
			match(SPACE);
			setState(199);
			match(W_AGO);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u00cc\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\5\2)\n\2\3\2\3\2\5\2-\n\2\3\2\3\2\3\2\5\2\62\n\2\3"+
		"\2\5\2\65\n\2\3\2\3\2\3\3\5\3:\n\3\3\3\3\3\5\3>\n\3\3\3\3\3\3\3\3\3\5"+
		"\3D\n\3\3\3\3\3\3\4\5\4I\n\4\3\4\3\4\5\4M\n\4\3\4\3\4\3\4\5\4R\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\5\4Y\n\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5a\n\5\3\6\3\6\3\6"+
		"\3\6\5\6g\n\6\3\7\3\7\3\7\3\7\5\7m\n\7\3\b\5\bp\n\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\5\ty\n\t\3\n\3\n\5\n}\n\n\3\n\3\n\5\n\u0081\n\n\3\n\3\n\3\n"+
		"\5\n\u0086\n\n\3\n\5\n\u0089\n\n\3\13\5\13\u008c\n\13\3\13\3\13\3\13\3"+
		"\13\3\13\5\13\u0093\n\13\3\f\3\f\3\f\5\f\u0098\n\f\3\r\3\r\3\r\3\r\5\r"+
		"\u009e\n\r\3\16\3\16\3\16\3\16\5\16\u00a4\n\16\3\17\3\17\3\17\3\17\5\17"+
		"\u00aa\n\17\3\20\3\20\5\20\u00ae\n\20\3\20\3\20\3\20\3\20\3\21\3\21\5"+
		"\21\u00b6\n\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00be\n\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\5\23\u00c6\n\23\3\23\3\23\3\23\3\23\3\23\2\2\24\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\5\6\4\2\4\4\b\b\2\u00de"+
		"\2(\3\2\2\2\49\3\2\2\2\6H\3\2\2\2\b\\\3\2\2\2\nb\3\2\2\2\fh\3\2\2\2\16"+
		"o\3\2\2\2\20x\3\2\2\2\22z\3\2\2\2\24\u0092\3\2\2\2\26\u0097\3\2\2\2\30"+
		"\u009d\3\2\2\2\32\u00a3\3\2\2\2\34\u00a9\3\2\2\2\36\u00ab\3\2\2\2 \u00b3"+
		"\3\2\2\2\"\u00bb\3\2\2\2$\u00c3\3\2\2\2&\'\t\2\2\2\')\7B\2\2(&\3\2\2\2"+
		"()\3\2\2\2),\3\2\2\2*+\7\7\2\2+-\7B\2\2,*\3\2\2\2,-\3\2\2\2-.\3\2\2\2"+
		".\61\7D\2\2/\60\7B\2\2\60\62\t\3\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3"+
		"\2\2\2\63\65\7C\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\7"+
		"\2\2\3\67\3\3\2\2\28:\t\2\2\298\3\2\2\29:\3\2\2\2:=\3\2\2\2;<\7\7\2\2"+
		"<>\7B\2\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\7D\2\2@A\7B\2\2AC\5\16\b\2B"+
		"D\7C\2\2CB\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\7\2\2\3F\5\3\2\2\2GI\t\2\2\2"+
		"HG\3\2\2\2HI\3\2\2\2IL\3\2\2\2JK\7\7\2\2KM\7B\2\2LJ\3\2\2\2LM\3\2\2\2"+
		"MN\3\2\2\2NQ\7D\2\2OP\7B\2\2PR\7\t\2\2QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2S"+
		"T\7B\2\2TU\5\20\t\2UV\7\n\2\2VX\5\20\t\2WY\7C\2\2XW\3\2\2\2XY\3\2\2\2"+
		"YZ\3\2\2\2Z[\7\2\2\3[\7\3\2\2\2\\]\7\f\2\2]^\7B\2\2^`\7D\2\2_a\7C\2\2"+
		"`_\3\2\2\2`a\3\2\2\2a\t\3\2\2\2bc\7\r\2\2cd\7B\2\2df\7D\2\2eg\7C\2\2f"+
		"e\3\2\2\2fg\3\2\2\2g\13\3\2\2\2hi\7\16\2\2ij\7B\2\2jl\7D\2\2km\7C\2\2"+
		"lk\3\2\2\2lm\3\2\2\2m\r\3\2\2\2np\7\13\2\2on\3\2\2\2op\3\2\2\2pq\3\2\2"+
		"\2qr\5\20\t\2r\17\3\2\2\2sy\7\22\2\2ty\7\23\2\2uy\7\24\2\2vy\5\22\n\2"+
		"wy\5\24\13\2xs\3\2\2\2xt\3\2\2\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y\21\3\2"+
		"\2\2z|\7\25\2\2{}\7B\2\2|{\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\u0080\7\17\2\2"+
		"\177\u0081\7!\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0088\3"+
		"\2\2\2\u0082\u0085\7B\2\2\u0083\u0084\7\3\2\2\u0084\u0086\7B\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\7\17"+
		"\2\2\u0088\u0082\3\2\2\2\u0088\u0089\3\2\2\2\u0089\23\3\2\2\2\u008a\u008c"+
		"\7\31\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2"+
		"\u008d\u0093\7\32\2\2\u008e\u0093\5\26\f\2\u008f\u0093\5\30\r\2\u0090"+
		"\u0093\5\32\16\2\u0091\u0093\5\34\17\2\u0092\u008b\3\2\2\2\u0092\u008e"+
		"\3\2\2\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093"+
		"\25\3\2\2\2\u0094\u0098\7\35\2\2\u0095\u0098\7\4\2\2\u0096\u0098\5\36"+
		"\20\2\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2\2\u0098"+
		"\27\3\2\2\2\u0099\u009a\7\31\2\2\u009a\u009b\7B\2\2\u009b\u009e\7\37\2"+
		"\2\u009c\u009e\5 \21\2\u009d\u0099\3\2\2\2\u009d\u009c\3\2\2\2\u009e\31"+
		"\3\2\2\2\u009f\u00a0\7\31\2\2\u00a0\u00a1\7B\2\2\u00a1\u00a4\7\36\2\2"+
		"\u00a2\u00a4\5\"\22\2\u00a3\u009f\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\33"+
		"\3\2\2\2\u00a5\u00a6\7\31\2\2\u00a6\u00a7\7B\2\2\u00a7\u00aa\7 \2\2\u00a8"+
		"\u00aa\5$\23\2\u00a9\u00a5\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\35\3\2\2"+
		"\2\u00ab\u00ad\7\17\2\2\u00ac\u00ae\7B\2\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\7\34\2\2\u00b0\u00b1\7B\2\2\u00b1"+
		"\u00b2\7\33\2\2\u00b2\37\3\2\2\2\u00b3\u00b5\7\17\2\2\u00b4\u00b6\7B\2"+
		"\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8"+
		"\7\37\2\2\u00b8\u00b9\7B\2\2\u00b9\u00ba\7\33\2\2\u00ba!\3\2\2\2\u00bb"+
		"\u00bd\7\17\2\2\u00bc\u00be\7B\2\2\u00bd\u00bc\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\7\36\2\2\u00c0\u00c1\7B\2\2\u00c1"+
		"\u00c2\7\33\2\2\u00c2#\3\2\2\2\u00c3\u00c5\7\17\2\2\u00c4\u00c6\7B\2\2"+
		"\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8"+
		"\7 \2\2\u00c8\u00c9\7B\2\2\u00c9\u00ca\7\33\2\2\u00ca%\3\2\2\2 (,\61\64"+
		"9=CHLQX`flox|\u0080\u0085\u0088\u008b\u0092\u0097\u009d\u00a3\u00a9\u00ad"+
		"\u00b5\u00bd\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}