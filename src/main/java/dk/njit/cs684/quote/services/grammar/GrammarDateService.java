package dk.njit.cs684.quote.services.grammar;

import dk.njit.cs684.quote.grammar.QuoteBotParser;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

@Service
public class GrammarDateService {
    private static DateTimeFormatter AMERICAN_DATE_FORMAT = DateTimeFormatter.ofPattern("M/d/yyyy");

    @Autowired
    private RelativeDateService relativeDateService;

    public RelativeDateService getRelativeDateService() { return relativeDateService; }
    public void setRelativeDateService(RelativeDateService relativeDateService) { this.relativeDateService = relativeDateService; }

    public LocalDate parseAnyDate(QuoteBotParser.AnyDateContext date) {
        if (date.ISO_DATE() != null) return parseISODate(date.ISO_DATE());
        else if (date.AMERICAN_DATE() != null) return parseAmericanDate(date.AMERICAN_DATE());
        else if (date.AMERICAN_SHORT_DATE() != null) return parseShortAmericanDate(date.AMERICAN_SHORT_DATE());
        else if (date.cuteDate() != null && date.cuteDate().exception == null) return parseCuteDate(date.cuteDate());
        else if (date.relativeDate() != null && date.relativeDate().exception == null)
            return parseRelativeDate(date.relativeDate());

        throw new RuntimeException("Unknown date.");
    }

    public LocalDate parseISODate(TerminalNode n) {
        return LocalDate.parse(n.getText());
    }

    public LocalDate parseAmericanDate(TerminalNode n) {
        return LocalDate.parse(n.getText(), AMERICAN_DATE_FORMAT);
    }

    public LocalDate parseShortAmericanDate(TerminalNode n) {
        final int year = relativeDateService.now().getYear();
        return LocalDate.parse(n.getText() + "/" + year, AMERICAN_DATE_FORMAT);
    }

    public LocalDate parseCuteDate(QuoteBotParser.CuteDateContext c) {
        final int month = parseMonth(c.ANYMONTH()).getValue();
        final int dayOfMonth = Integer.parseInt(
                c.NUMBER(0).getText());
//                c.DIGIT().stream().map(ParseTree::getText).collect(Collectors.joining()));
        final int year = c.NUMBER(1) == null ? relativeDateService.now().getYear()
                : Integer.parseInt(c.NUMBER(1).getText());
        return LocalDate.of(year, month, dayOfMonth);
    }

    public LocalDate parseRelativeDate(QuoteBotParser.RelativeDateContext c) {
        if (c.DAY_OF_WEEK() != null) {
            final DayOfWeek dayOfWeek = parseDayOfWeek(c.DAY_OF_WEEK());
            return relativeDateService.dayOfWeekToLocalDate(dayOfWeek);
        } else if (c.relativeDay() != null && c.relativeDay().exception == null) {
            return parseRelativeDay(c.relativeDay());
        } else if (c.relativeWeek() != null && c.relativeWeek().exception == null) {
            return parseRelativeWeek(c.relativeWeek());
        } else if (c.relativeMonth() != null && c.relativeMonth().exception == null) {
            return parseRelativeMonth(c.relativeMonth());
        } else if (c.relativeYear() != null && c.relativeYear().exception == null) {
            return parseRelativeYear(c.relativeYear());
        }
        throw new RuntimeException("Unable to parse relative date.");
    }

    public LocalDate parseRelativeDay(QuoteBotParser.RelativeDayContext c) {
        if (c.W_YESTERDAY() != null) return relativeDateService.now().minusDays(1);
        else if (c.W_TODAY() != null) return relativeDateService.now();
        else if (c.instantDaysAgo() != null && c.exception == null) {
            final int days = Integer.parseInt(c.instantDaysAgo().NUMBER().getText());
            return relativeDateService.now().minusDays(days);
        }
        throw new RuntimeException("Unable to parse relative day.");
    }

    public LocalDate parseRelativeWeek(QuoteBotParser.RelativeWeekContext c) {
        if (c.W_LAST() != null) return relativeDateService.now().minusWeeks(1);
        else if (c.instantWeeksAgo() != null && c.exception == null) {
            final int weeks = Integer.parseInt(c.instantWeeksAgo().NUMBER().getText());
            return relativeDateService.now().minusWeeks(weeks);
        }
        throw new RuntimeException("Unable to parse relative month.");
    }

    public LocalDate parseRelativeMonth(QuoteBotParser.RelativeMonthContext c) {
        if (c.W_LAST() != null) return relativeDateService.now().minusMonths(1);
        else if (c.instantMonthsAgo() != null && c.exception == null) {
            final int months = Integer.parseInt(c.instantMonthsAgo().NUMBER().getText());
            return relativeDateService.now().minusMonths(months);
        }
        throw new RuntimeException("Unable to parse relative month.");
    }

    public LocalDate parseRelativeYear(QuoteBotParser.RelativeYearContext c) {
        if (c.W_LAST() != null) return relativeDateService.now().minusYears(1);
        else if (c.instantYearsAgo() != null && c.exception == null) {
            final int years = Integer.parseInt(c.instantYearsAgo().NUMBER().getText());
            return relativeDateService.now().minusYears(years);
        }
        throw new RuntimeException("Unable to parse relative year.");
    }

    public Month parseMonth(TerminalNode m) {
        switch (m.getText()) {
            case "jan":
            case "january":
                return Month.JANUARY;
            case "feb":
            case "february":
                return Month.FEBRUARY;
            case "mar":
            case "march":
                return Month.MARCH;
            case "apr":
            case "april":
                return Month.APRIL;
            case "may":
                return Month.MAY;
            case "jun":
            case "june":
                return Month.JUNE;
            case "jul":
            case "july":
                return Month.JULY;
            case "aug":
            case "august":
                return Month.AUGUST;
            case "sep":
            case "september":
                return Month.SEPTEMBER;
            case "oct":
            case "october":
                return Month.OCTOBER;
            case "nov":
            case "november":
                return Month.NOVEMBER;
            case "dec":
            case "december":
                return Month.DECEMBER;
            default:
                throw new RuntimeException("Unknown month.");
        }
    }

    public DayOfWeek parseDayOfWeek(TerminalNode m) {
        switch (m.getText()) {
            case "mon":
            case "monday":
                return DayOfWeek.MONDAY;
            case "tue":
            case "tuesday":
                return DayOfWeek.TUESDAY;
            case "wed":
            case "wednesday":
                return DayOfWeek.WEDNESDAY;
            case "thu":
            case "thurs":
            case "thursday":
                return DayOfWeek.THURSDAY;
            case "fri":
            case "friday":
                return DayOfWeek.FRIDAY;
            case "sat":
            case "satur":
            case "saturday":
                return DayOfWeek.SATURDAY;
            case "sun":
            case "sunday":
                return DayOfWeek.SUNDAY;
            default:
                throw new RuntimeException("Unknown day of week.");
        }
    }
}
