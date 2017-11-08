package mechanisms;

public class Rule {

	private String rule;
	private double weight;
	
	public Rule(String rule, double weight) {
		this.rule = rule;
		this.weight = weight;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
