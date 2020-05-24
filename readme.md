## Quote Bot
This Discord bot was made as a class-project for
[CS 684](https://catalog.njit.edu/search/?P=CS%20684) "Software Testing and Quality Assurance" at NJIT.
This is a graduate level class I took in Spring of 2020. As a group we chose to make a
[Discord](https://discord.com/) bot. (Discord is an instant messaging platform.) The purpose of this bot
is to provide up-to-date and historic stock quotes when users ask it to.

#### Features
Our bot has six main user functions:
 - Serves live stock quotes: "how much is apple right now?"
 - Provides historic stock quotes: "how much was tesla on Jan 1st"
 - Provides a range of stock quotes: "what was MSFT between Jan 1st 1980 and Dec 31st 1999"
 - Allows searching for companies: "search micro"
 - Calculates a few simple measurements: "stats PRU"
 - Generates the entire history of a stock as a CSV: "csv AMZN"

The bot is flexible in the grammar. For instance, the user can ask "What is the price of Apple?" or "apple".

Dates can be understood in various formats as well, including ISO 8601 format, MM/DD/YYYY format,
and MMM DD YYYY format. Dates can also be relative. For instance, "last month" or "March 14th" (of this year) or
"2 weeks ago".

#### Implementation
We used Java and Spring Boot + Web. For Discord connectivity use used Javacord
([github](https://github.com/Javacord/Javacord); [homepage](https://javacord.org/)).
For textual parsing of user input we chose to use ANTLR. 

We used Mongo DB for storing historical stock data. All stock quotes are borrowed from Yahoo Finance.
The database storage is optional (in case you want to test this app locally), but it does speed up performance
when requesting historical stock quotes stored there.

We used Gradle as a build tool. JUnit for testing.

#### Screenshots

![Stock quote](screenshots/stock-quote.png?raw=true)
![Historical stock quote](screenshots/historical-stock-quote.png?raw=true)
![Ranged stock quote](screenshots/ranged-stock-quote.png?raw=true)
![Search](screenshots/search.png?raw=true)
![Stats](screenshots/stats.png?raw=true)
![CSV](screenshots/csv.png?raw=true)