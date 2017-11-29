package mechanisms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JTextField;

public class FileReader {
	
	private static File paths = new File("files/path.txt");
	
	private static boolean validated = false;
	
	private static File rules_path;
	private static File ham_path;
	private static File spam_path;
	
	private static ArrayList<Rule> rules_list = new ArrayList<>();
	private static ArrayList<Ham> ham_list = new ArrayList<>();
	private static ArrayList<Spam> spam_list = new ArrayList<>();
	
	
	public static boolean loadAndValidate(){
		BufferedReader in;
		ArrayList<String> path_list = new ArrayList<>();
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(paths), "UTF8"));
			String line;
				while((line = in.readLine())!= null){
					path_list.add(line);
				}
				in.close();
		} catch (IOException e){
		}
			
		if(!path_list.get(0).contains(".cf")){ return false;}
		if(!path_list.get(1).contains(".log")){ return false;}
		if(!path_list.get(2).contains(".log")){ return false;}
		
		setRules_path(new File(path_list.get(0)));
		setHam_path(new File(path_list.get(2)));
		setSpam_path(new File(path_list.get(1)));
		
		
		validated = true;
		return true;
	}
	
	
	public static void loadHam(){
		if(isValidated()){
			ham_list.clear();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(ham_path), "UTF8"));
				String line;
					while((line = in.readLine())!= null){
						Ham ham;
						ArrayList<String> ham_l = new ArrayList<String>();
						String[] line_arr = line.split("\\s+");
						String filename = line_arr[0];
						
						for(int i = 1; i < line_arr.length; i++){
							ham_l.add(line_arr[i]);
						}
						ham = new Ham(filename, ham_l);
						ham_list.add(ham);
					}
					in.close();
			} catch (IOException e) {}}
	}
	
	public static void loadSpam(){
		if(isValidated()){
			spam_list.clear();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(spam_path), "UTF8"));
				String line;
					while((line = in.readLine())!= null){
						Spam spam;
						ArrayList<String> spam_l = new ArrayList<String>();
						String[] line_arr = line.split("\\s+");
						String filename = line_arr[0];
						
						for(int i = 1; i < line_arr.length; i++){
							spam_l.add(line_arr[i]);
						}
						spam = new Spam(filename, spam_l);
						spam_list.add(spam);
					}
					in.close();
			} catch (IOException e) {}}
	}
	
	
	public static void loadRules(){
		if(isValidated()){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(rules_path), "UTF8"));
			String line;
				while((line = in.readLine())!= null){
					if(line.split(":").length < 2){
					rules_list.add(new Rule(line.split(":")[0], 0));
					}else{ rules_list.add(new Rule(line.split(":")[0], Double.parseDouble(line.split(":")[1])));}
				}
				in.close();
		} catch (IOException e) {}
		}
		
	}
	
	public static File[] loadPath(JTextField rulesField, JTextField spamField, JTextField hamField)throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader (new FileInputStream(paths), "UTF8"));
		File[] filearray = new File[3];
		String s;
		int aux = 0;
		while((s = in.readLine())!= null){
			if(s.split("")[0] != null){
				filearray[aux] = new File(s);
				switch(aux){
				case 0:
					rulesField.setText(s);
					break;
				case 2:
					spamField.setText(s);
					break;
				case 1:
					hamField.setText(s);
					break;
				}
				aux++;
			}else{
				filearray[aux] = null;
				aux++;
			}
		}
		in.close();
		return filearray;
	}
	
	public static void savePath(File[] filearray) throws IOException{
		FileWriter fw = new FileWriter(new File("files/path.txt"));
		for(File file : filearray){
			if(file != null){
				fw.write(file.getAbsolutePath() + "\n");
			}else{
				fw.write(" " + "\n");
			}
		}
		fw.close();
	}
	
	public static void saveConfig(Object[][] current_man) {
		try {
			FileWriter f = new FileWriter(rules_path);
			for (int i = 0; i < current_man.length; i++) {
				f.append(current_man[i][0] + ":" + current_man[i][1]);
				f.append("\n");
			}
			
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object[][] readNSGAII(){
		File f = new File("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rs");
		Object[][] new_rules = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF8"));
			String line = in.readLine();
			String[] rules = line.split(" ");
			rules_list = new ArrayList<>();
			loadRules();
			new_rules = new Object[rules_list.size()][2];
			for(int i = 0; i < rules_list.size(); i++){
				new_rules[i][0] = rules_list.get(i).getRule();
				new_rules[i][1] = Double.valueOf(rules[i]);
				in.close();
			}

		}catch(IOException e){
			
		}
		return new_rules;
	}
	
	
	
	
	
	
	public static boolean isValidated() {
		return validated;
	}


	public static void setValidated(boolean validated) {
		FileReader.validated = validated;
	}


	public static File getRules_path() {
		return rules_path;
	}


	public static void setRules_path(File rules_path) {
		FileReader.rules_path = rules_path;
	}


	public static File getHam_path() {
		return ham_path;
	}


	public static void setHam_path(File ham_path) {
		FileReader.ham_path = ham_path;
	}


	public static File getSpam_path() {
		return spam_path;
	}


	public static void setSpam_path(File spam_path) {
		FileReader.spam_path = spam_path;
	}


	public static ArrayList<Rule> getRules_list() {
		return rules_list;
	}


	public static void setRules_list(ArrayList<Rule> rules_list) {
		FileReader.rules_list = rules_list;
	}


	public static ArrayList<Ham> getHam_list() {
		return ham_list;
	}


	public static void setHam_list(ArrayList<Ham> ham_list) {
		FileReader.ham_list = ham_list;
	}


	public static ArrayList<Spam> getSpam_list() {
		return spam_list;
	}


	public static void setSpam_list(ArrayList<Spam> spam_list) {
		FileReader.spam_list = spam_list;
	}
}