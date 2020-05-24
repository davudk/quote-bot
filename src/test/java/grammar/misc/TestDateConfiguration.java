package grammar.misc;

import dk.njit.cs684.quote.services.grammar.RelativeDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Configuration
public class TestDateConfiguration {

    @Autowired
    private RelativeDateService relativeDateService;

    @PostConstruct
    private void setup() {
        System.err.println("Setting the current date to: 2020-03-20");
        relativeDateService.setTestDate(LocalDate.parse("2020-03-20"));
    }

}
