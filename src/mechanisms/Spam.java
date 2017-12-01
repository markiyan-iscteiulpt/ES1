package mechanisms;

import java.util.ArrayList;

/**
 * @author Markiyan Pyekh
 *
 */
public class Spam {
	
	private String filename;
	private ArrayList<String> rules;
	
	/**
	 * Construtor do Spam
	 * @param filename
	 * @param rules
	 */
	public Spam(String filename, ArrayList<String> rules){
		this.filename = filename;
		this.rules = rules;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public ArrayList<String> getRules() {
		return rules;
	}

	public void setRules(ArrayList<String> rules) {
		this.rules = rules;
	}
}
