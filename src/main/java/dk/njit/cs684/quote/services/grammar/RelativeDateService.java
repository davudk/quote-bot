package dk.njit.cs684.quote.services.grammar;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class RelativeDateService {
    private LocalDate testDate;

    public LocalDate getTestDate() { return testDate; }
    public void setTestDate(LocalDate testDate) { this.testDate = testDate; }

    public LocalDate now() {
        if (testDate != null) return testDate;
        else return LocalDate.now();
    }

    public LocalDate dayOfWeekToLocalDate(DayOfWeek dayOfWeek) {
        final DayOfWeek current = now().getDayOfWeek();
        final int difference = current.getValue() - dayOfWeek.getValue();
        return now().minusDays(difference <= 0 ? difference + 7 : difference);
    }
}
