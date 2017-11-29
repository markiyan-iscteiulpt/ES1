package mechanisms;

import java.util.ArrayList;
import java.util.HashMap;

public class Evaluation {
	
	private static int FP;
	private static int FN;
	private static HashMap<String, Double> value_map;
	private static ArrayList<Ham> ham = FileReader.getHam_list();
	private static ArrayList<Spam> spam = FileReader.getSpam_list();
	private static ArrayList<Rule> rules = FileReader.getRules_list();
	
	public static int[]  evaluate(double[] current_values){
		int[] ret = new int[3];
		FP = 0;
		FN = 0;
		int tot = 0;
		
		value_map = new HashMap<>();
		for (int i = 0; i < current_values.length; i++) {
			value_map.put(rules.get(i).getRule(), current_values[i]);
		}
		
		for(Ham h : ham){
			double aux = 0.0;
			for(String d: h.getRules()){
				double value = 0.0;
				if(value_map.get(d) != null){
					value = value_map.get(d);
					aux +=value;
				}
			}
			
			if(aux > 5.0){
				FP++;
			}
			tot++;
		}
		
		for(Spam s: spam){
			double aux = 0.0;
			for(String d: s.getRules()){
				double value = 0.0;
				if(value_map.get(d) != null){
				value = value_map.get(d);
				aux +=value;
				}
			}
			
			if(aux <= 5.0){
				FN++;
			}
			tot++;
		}
		
		ret[0] = FP;
		ret[1] = FN;
		ret[2] = tot;
		return ret;
	}

	public static int getFP() {
		return FP;
	}

	public static void setFP(int fP) {
		FP = fP;
	}

	public static int getFN() {
		return FN;
	}

	public static void setFN(int fN) {
		FN = fN;
	}
}