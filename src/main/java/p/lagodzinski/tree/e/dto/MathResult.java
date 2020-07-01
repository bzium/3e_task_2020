package p.lagodzinski.tree.e.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MathResult {
    private final double result;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MathResult(@JsonProperty("result") final double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }
}
