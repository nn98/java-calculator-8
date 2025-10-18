package dto;

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
		return "Line [custom=" + custom + ", \nexpression=" + expression + "]";
	}

}
