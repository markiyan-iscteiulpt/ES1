package mechanisms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JTextField;

/**
 * @author Markiyan Pyekh
 *
 */
public class FileReader {
	
	private static File appdata = new File(System.getenv("APPDATA") + "\\" + "AntiSpam");
	private static File path_file = new File(appdata.getAbsolutePath()+"/path.txt");
	private static boolean validated = false;
	private static File rules_path;
	private static File ham_path;
	private static File spam_path;
	private static ArrayList<String> paths = new ArrayList<>();
	private static ArrayList<Rule> rules_list = new ArrayList<>();
	private static ArrayList<Ham> ham_list = new ArrayList<>();
	private static ArrayList<Spam> spam_list = new ArrayList<>();
	
	/**
	 * Método para carregar e validar
	 * @return validated
	 * @throws IOException
	 */
	public static boolean loadAndValidate() throws IOException{	
		try {FileReader.loadPath();} catch (URISyntaxException e){ }
		if(paths.size()>=2){
		if(!paths.get(0).contains(".cf")){return false;}
		if(!paths.get(1).contains(".log")){return false;}
		if(!paths.get(2).contains(".log")){return false;}
		}else{return false;}
		setRules_path(new File(paths.get(0)));
		setHam_path(new File(paths.get(2)));
		setSpam_path(new File(paths.get(1)));
		validated = true;
		return true;
	}
	
	/**
	 * Método que carrega o ficheiro Ham
	 */
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
	
	/**
	 * Método que carrega o ficheiro Spam
	 */
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
	
	/**
	 * Método que carrega o ficheiro Rules
	 */
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
	
	/**
	 * Função que carrega os caminhos do ficheiro paths.txt
	 * @param rulesField
	 * @param spamField
	 * @param hamField
	 * @return filearray
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static File[] loadPath(JTextField rulesField, JTextField spamField, JTextField hamField)throws IOException, URISyntaxException{
		InputStream stream = new FileInputStream(path_file);
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		File[] filearray = new File[3];
		String s;
		int aux = 0;
		while((s = in.readLine())!= null){
			if(s.split("")[0] != null){
				paths.add(s);
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
	
	
	/**
	 * Método que grava o caminho no ficheiro path.txt
	 * @param filearray
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void savePath(File[] filearray) throws IOException, URISyntaxException{
		PrintWriter writer = new PrintWriter(path_file, "UTF-8");
		for(File file : filearray){
			if(file != null){
				System.out.println(file.getAbsolutePath());
				writer.write(file.getAbsolutePath() + "\n");
				writer.flush();
			}else{
				writer.write(" " + "\n");
				writer.flush();
			}
		}
		writer.close();
	}
	
	
	/**
	 * Método que grava as regras e os pesos
	 * @param current_man
	 */
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
	
	/**
	 * Função que através do algoritmo NSGAII adiciona a cada regra o respectivo peso
	 * @return new_rules
	 */
	public static Object[][] readNSGAII(){
		int l = 1;
		Object[][] new_rules = null;
		try {
			String line = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(appdata+ "/referenceFronts/AntiSpamFilterProblem.NSGAII.rs")));
			for(int q = 0; q <= l; q++){
				line = in.readLine();
			}
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
	
	/**
	 * Método para a criação de ficheiros de modo a que o programa funcione corretamente
	 * @return aux
	 */
	public static boolean configureAmb() {
		if(!appdata.isDirectory()){
			new File(appdata.getAbsolutePath()).mkdir();
			if(!appdata.isDirectory()){return false;}
		}
		if(appdata.listFiles().length==0){
			try {
				new File(appdata.getAbsoluteFile()+"/path.txt").createNewFile();
			} catch (IOException e) {
				return false;
			}
		}else{
			boolean aux = false;
			for(File f : appdata.listFiles()){
				if(f.getName().contains("path.txt")){
					aux = true;
				}
			}
			return aux;
		}
		return true;
	}
	
	/**
	 * Método que carrega os ficheiros a partir do ficheiro path.txt
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void loadPath()throws IOException, URISyntaxException{
		InputStream stream = new FileInputStream(path_file);
		BufferedReader in = new BufferedReader(new InputStreamReader(stream));
		String s;
		paths.clear();
		while((s = in.readLine())!= null){
			paths.add(s);
		}
		in.close();
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

	public static String getAppdataDir() {
		return appdata.getAbsolutePath();
	}
}