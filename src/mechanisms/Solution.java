package mechanisms;

public class Solution {
	
	int line_number;
	double fp;
	double fn;
	
	public Solution(int line_number, double fn, double fp) {
		this.line_number = line_number;
		this.fp = fp;
		this.fn = fn;
	}

	public int getLine_number() {
		return line_number;
	}

	public void setLine_number(int line_number) {
		this.line_number = line_number;
	}

	public double getFp() {
		return fp;
	}

	public void setFp(double fp) {
		this.fp = fp;
	}

	public double getFn() {
		return fn;
	}

	public void setFn(double fn) {
		this.fn = fn;
	}

}
