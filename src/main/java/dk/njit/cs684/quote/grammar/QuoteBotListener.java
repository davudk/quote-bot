// Generated from QuoteBot.g4 by ANTLR 4.8

package dk.njit.cs684.quote.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuoteBotParser}.
 */
public interface QuoteBotListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#stockQuoteQuery}.
	 * @param ctx the parse tree
	 */
	void enterStockQuoteQuery(QuoteBotParser.StockQuoteQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#stockQuoteQuery}.
	 * @param ctx the parse tree
	 */
	void exitStockQuoteQuery(QuoteBotParser.StockQuoteQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#historicalStockQuoteQuery}.
	 * @param ctx the parse tree
	 */
	void enterHistoricalStockQuoteQuery(QuoteBotParser.HistoricalStockQuoteQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#historicalStockQuoteQuery}.
	 * @param ctx the parse tree
	 */
	void exitHistoricalStockQuoteQuery(QuoteBotParser.HistoricalStockQuoteQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#rangedStockQuoteQuery}.
	 * @param ctx the parse tree
	 */
	void enterRangedStockQuoteQuery(QuoteBotParser.RangedStockQuoteQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#rangedStockQuoteQuery}.
	 * @param ctx the parse tree
	 */
	void exitRangedStockQuoteQuery(QuoteBotParser.RangedStockQuoteQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#stockStatisticsQuery}.
	 * @param ctx the parse tree
	 */
	void enterStockStatisticsQuery(QuoteBotParser.StockStatisticsQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#stockStatisticsQuery}.
	 * @param ctx the parse tree
	 */
	void exitStockStatisticsQuery(QuoteBotParser.StockStatisticsQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#stockSearchQuery}.
	 * @param ctx the parse tree
	 */
	void enterStockSearchQuery(QuoteBotParser.StockSearchQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#stockSearchQuery}.
	 * @param ctx the parse tree
	 */
	void exitStockSearchQuery(QuoteBotParser.StockSearchQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#stockSpreadsheetQuery}.
	 * @param ctx the parse tree
	 */
	void enterStockSpreadsheetQuery(QuoteBotParser.StockSpreadsheetQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#stockSpreadsheetQuery}.
	 * @param ctx the parse tree
	 */
	void exitStockSpreadsheetQuery(QuoteBotParser.StockSpreadsheetQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#onAnyDate}.
	 * @param ctx the parse tree
	 */
	void enterOnAnyDate(QuoteBotParser.OnAnyDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#onAnyDate}.
	 * @param ctx the parse tree
	 */
	void exitOnAnyDate(QuoteBotParser.OnAnyDateContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#anyDate}.
	 * @param ctx the parse tree
	 */
	void enterAnyDate(QuoteBotParser.AnyDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#anyDate}.
	 * @param ctx the parse tree
	 */
	void exitAnyDate(QuoteBotParser.AnyDateContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#cuteDate}.
	 * @param ctx the parse tree
	 */
	void enterCuteDate(QuoteBotParser.CuteDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#cuteDate}.
	 * @param ctx the parse tree
	 */
	void exitCuteDate(QuoteBotParser.CuteDateContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#relativeDate}.
	 * @param ctx the parse tree
	 */
	void enterRelativeDate(QuoteBotParser.RelativeDateContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#relativeDate}.
	 * @param ctx the parse tree
	 */
	void exitRelativeDate(QuoteBotParser.RelativeDateContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#relativeDay}.
	 * @param ctx the parse tree
	 */
	void enterRelativeDay(QuoteBotParser.RelativeDayContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#relativeDay}.
	 * @param ctx the parse tree
	 */
	void exitRelativeDay(QuoteBotParser.RelativeDayContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#relativeWeek}.
	 * @param ctx the parse tree
	 */
	void enterRelativeWeek(QuoteBotParser.RelativeWeekContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#relativeWeek}.
	 * @param ctx the parse tree
	 */
	void exitRelativeWeek(QuoteBotParser.RelativeWeekContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#relativeMonth}.
	 * @param ctx the parse tree
	 */
	void enterRelativeMonth(QuoteBotParser.RelativeMonthContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#relativeMonth}.
	 * @param ctx the parse tree
	 */
	void exitRelativeMonth(QuoteBotParser.RelativeMonthContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#relativeYear}.
	 * @param ctx the parse tree
	 */
	void enterRelativeYear(QuoteBotParser.RelativeYearContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#relativeYear}.
	 * @param ctx the parse tree
	 */
	void exitRelativeYear(QuoteBotParser.RelativeYearContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#instantDaysAgo}.
	 * @param ctx the parse tree
	 */
	void enterInstantDaysAgo(QuoteBotParser.InstantDaysAgoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#instantDaysAgo}.
	 * @param ctx the parse tree
	 */
	void exitInstantDaysAgo(QuoteBotParser.InstantDaysAgoContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#instantWeeksAgo}.
	 * @param ctx the parse tree
	 */
	void enterInstantWeeksAgo(QuoteBotParser.InstantWeeksAgoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#instantWeeksAgo}.
	 * @param ctx the parse tree
	 */
	void exitInstantWeeksAgo(QuoteBotParser.InstantWeeksAgoContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#instantMonthsAgo}.
	 * @param ctx the parse tree
	 */
	void enterInstantMonthsAgo(QuoteBotParser.InstantMonthsAgoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#instantMonthsAgo}.
	 * @param ctx the parse tree
	 */
	void exitInstantMonthsAgo(QuoteBotParser.InstantMonthsAgoContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuoteBotParser#instantYearsAgo}.
	 * @param ctx the parse tree
	 */
	void enterInstantYearsAgo(QuoteBotParser.InstantYearsAgoContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuoteBotParser#instantYearsAgo}.
	 * @param ctx the parse tree
	 */
	void exitInstantYearsAgo(QuoteBotParser.InstantYearsAgoContext ctx);
}