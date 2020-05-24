package dk.njit.cs684.quote.model.queries;

public class QueryBase {
    private String input;

    public QueryBase() { }
    public QueryBase(String input) {
        this.input = input;
    }

    public String getInput() { return input; }
    public void setInput(String input) { this.input = input; }
}
