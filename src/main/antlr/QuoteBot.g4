grammar QuoteBot;

@header {
package dk.njit.cs684.quote.grammar;
}

stockQuoteQuery:
      ((HOWMUCHISWAS | WHATISWAS) SPACE)? (THEPRICEOF SPACE)? IDENTIFIER (SPACE (W_TODAY | RIGHTNOW))? QUESTION? EOF
    ;

W_TODAY: ('t' | 'to') W_DAY;
HOWMUCHISWAS: 'how' SPACE 'much' (SPACE ('is' | 'was'))?;
WHATISWAS:
      'what' SPACE 'is' | 'what' SPACE 'was' | 'what\'s' | 'whats'
    | 'waht' SPACE 'is' | 'waht' SPACE 'was' | 'waht\'s' | 'wahts';
THEPRICEOF:
      'the' SPACE 'price' (SPACE 'of')?
    | ('the' SPACE)? 'price' SPACE 'of';
RIGHTNOW: ('right' SPACE)? 'now';

historicalStockQuoteQuery:
      (HOWMUCHISWAS | WHATISWAS)? (THEPRICEOF SPACE)? IDENTIFIER SPACE onAnyDate QUESTION? EOF
    ;

rangedStockQuoteQuery:
      (HOWMUCHISWAS | WHATISWAS)? (THEPRICEOF SPACE)? IDENTIFIER (SPACE W_BETWEEN)?
      SPACE anyDate BETWEEN_SYMBOL anyDate QUESTION? EOF
    ;

W_BETWEEN: 'between' | 'betwen';
BETWEEN_SYMBOL: SPACE? ('and' | '-') SPACE?;
//W_TO: 'to';
W_ON: 'on';

stockStatisticsQuery: STATS SPACE IDENTIFIER QUESTION?;
STATS: 'statistics' | 'stats';

stockSearchQuery: SEARCH SPACE IDENTIFIER QUESTION?;
SEARCH: 'search' | 'seach' | 'ls' | 'list' | 'dir';

stockSpreadsheetQuery: SPREADSHEET SPACE IDENTIFIER QUESTION?;
SPREADSHEET: 'export' | 'spreadsheet' | 'excel' | 'csv'
    | 'history' | 'historical' | 'download';

onAnyDate: W_ON? anyDate;
anyDate: ISO_DATE | AMERICAN_DATE | AMERICAN_SHORT_DATE | cuteDate | relativeDate;

NUMBER: DIGIT+;
//DAYOFMONTH: DIGIT DIGIT | DIGIT;
YEAR: DIGIT DIGIT DIGIT DIGIT;
DIGIT: [0-9];

ISO_DATE: YEAR '-' DIGIT DIGIT '-' DIGIT DIGIT;
AMERICAN_DATE: DIGIT DIGIT? '/' DIGIT DIGIT? '/' DIGIT DIGIT (DIGIT DIGIT)?;
AMERICAN_SHORT_DATE: DIGIT DIGIT? '/' DIGIT DIGIT?;

cuteDate: ANYMONTH SPACE? NUMBER ORDINAL_SUFFIX? (SPACE ('of' SPACE)? NUMBER)?;
ANYMONTH: MONTH3 | MONTH;
MONTH3: 'jan' | 'feb' | 'mar' | 'apr' | W_MAY | 'jun'
    | 'jul' | 'aug' | 'sep' | 'oct' | 'nov' | 'dec';
MONTH: 'january' | 'february' | 'march' | 'april' | W_MAY | 'june'
    | 'july' | 'august' | 'september' | 'october' | 'november' | 'december';
W_MAY: 'may';

relativeDate: W_LAST? DAY_OF_WEEK
    | relativeDay
    | relativeWeek
    | relativeMonth
    | relativeYear;
W_LAST: 'last' | 'lst';
DAY_OF_WEEK: 'mon' | 'monday' | 'tue' | 'tuesday' | 'wed' | 'wednesday'
    | 'thu' | 'thurs' | 'thursday' | 'fri' | 'friday'
    | 'sat' | 'satur' | 'saturday' | 'sun' | 'sunday';

relativeDay:            W_YESTERDAY | W_TODAY | instantDaysAgo;
relativeWeek:           W_LAST SPACE W_WEEK | instantWeeksAgo;
relativeMonth:          W_LAST SPACE W_MONTH | instantMonthsAgo;
relativeYear:           W_LAST SPACE W_YEAR | instantYearsAgo;

instantDaysAgo:         NUMBER SPACE? W_DAY SPACE W_AGO;
instantWeeksAgo:        NUMBER SPACE? W_WEEK SPACE W_AGO;
instantMonthsAgo:       NUMBER SPACE? W_MONTH SPACE W_AGO;
instantYearsAgo:        NUMBER SPACE? W_YEAR SPACE W_AGO;
W_AGO: 'ago' | 'agp';

//DURATION_DAY:           NUMBER SPACE? W_DAY;
//DURATION_MONTH:         NUMBER SPACE? W_MONTH;
//DURATION_YEAR:          NUMBER SPACE? W_YEAR;

W_DAY: 'day' | 'days';
W_YESTERDAY: 'y' 'e'? 'st' 'e'? 'rd' 'a'? 'y';
W_MONTH: 'mont' 'h'? | 'mont' 'h'? 's';
W_WEEK: 'week' | 'weeks';
W_YEAR: ('y' | 'u') 'ear' 's'?;

ORDINAL_SUFFIX: 'st' | 'nd' | 'rd' | 'th';

TEXTUAL_NUMBER: TEXTUAL_ONES_NUMBER | TEXTUAL_TENS_NUMBER;
TEXTUAL_ONES_NUMBER:
      W_ONE | W_TWO | W_THREE | W_FOUR | W_FIVE
    | W_SIX | W_SEVEN | W_EIGHT | W_NINE;
TEXTUAL_TENS_NUMBER:
      W_ELEVEN | W_TWELVE | W_THIRTEEN | W_FOURTEEN | W_FIFTEEN
    | W_SIXTEEN | W_SEVENTEEN | W_EIGHTTEEN | W_NINETEEN
    | W_TWENTY | W_THIRTY | W_FOURTY | W_FIFTY
    | W_SIXTY | W_SEVENTY | W_EIGHTY | W_NINETY;
W_ONE: 'one';
W_TWO: 'two';
W_THREE: 'three' | 'thee' | 'tree' | 'thre';
W_FOUR: 'four' | 'for' | 'foar';
W_FIVE: 'five' | 'fiv' | 'fivr';
W_SIX: 'six' | 'sic';
W_SEVEN: 'seven' | 'sevem' | 'sevn' | 'seen';
W_EIGHT: 'eight' | 'eught' | 'eigth';
W_NINE: 'nine';
W_TEN: 'ten';
W_ELEVEN: 'eleven' | 'elevem';
W_TWELVE: 'twelve' | 'twlve';
W_THIRTEEN: 'thir' W_TEEN;
W_FOURTEEN: W_FOUR W_TEEN;
W_FIFTEEN: 'fif' W_TEEN;
W_SIXTEEN: W_SIX W_TEEN;
W_SEVENTEEN: W_SEVEN W_TEEN;
W_EIGHTTEEN: W_EIGHT W_TEEN;
W_NINETEEN: W_NINE W_TEEN;
W_TWENTY: ('twen' | 'twn') | W_TY;
W_THIRTY: ('thir' | 'thr') | W_TY;
W_FOURTY: W_FOUR | W_TY;
W_FIFTY: 'fif' | W_TY;
W_SIXTY: W_SIX | W_TY;
W_SEVENTY: W_SEVEN | W_TY;
W_EIGHTY: W_EIGHT | W_TY;
W_NINETY: W_NINE | W_TY;

W_TEEN: 'teen' | W_TEN;
W_TY: 'ty' | 'y';

SPACE: ' '+;

QUESTION: SPACE? '?';

IDENTIFIER: [a-z][a-z0-9=\-_]* | '"' .*? '"';