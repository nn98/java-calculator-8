package dto;

import java.util.Objects;

public class Line {
    
    String custom;
    String expression;
    
    public Line(String custom, String expression) {
        this.custom = custom;
        this.expression = expression;
    }
    
    public String getCustom() {
        return custom;
    }
    
    public String getExpression() {
        return expression;
    }
    
    @Override
    public String toString() {
        return "Line [custom=" + custom + ", expression=" + expression + "]";
    }
    
    @Override
    public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
        Line line = (Line) o;
        return Objects.equals(custom, line.custom) && Objects.equals(expression, line.expression);
    }
    
}
