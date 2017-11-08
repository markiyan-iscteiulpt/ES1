package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileConfig extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private final File pathlist = new File("files/path.txt");
	private File[] filearray = new File[3];
	private JTextField rulesField;
	private JTextField spamField;
	private JTextField hamField;
	private JButton rulesButton;
	private JButton spamButton;
	private JButton hamButton;
	private JButton reset;
	private JButton load;
	private String theOutString;
	private JFileChooser fc;
	
	public FileConfig() throws IOException {
		setLayout(null);
		setBounds(16, 21, 501, 173);
		this.setOpaque(true);
		this.setBackground(new Color(255,255,255,0));
		
		rulesField = new JTextField();
		spamField = new JTextField();
		hamField = new JTextField();
		
		rulesField.setEditable(false);
		spamField.setEditable(false);
		hamField.setEditable(false);
		
		rulesButton = new JButton("...");
		rulesButton.setBounds(454, 28, 31, 21);
		rulesButton.setOpaque(false);
		rulesButton.setBorderPainted(false);
		
		spamButton = new JButton("...");
		spamButton.setBounds(454, 63, 31, 21);
		spamButton.setOpaque(false);
		spamButton.setBorderPainted(false);
		
		hamButton = new JButton("...");
		hamButton.setBounds(454, 97, 31, 21);
		hamButton.setOpaque(false);
		hamButton.setBorderPainted(false);
		
		reset = new JButton("Reset Config");
		reset.setBounds(243, 135, 112, 21);
		reset.setOpaque(false);
		reset.setBorderPainted(false);
		
		load = new JButton("Load Config");
		load.setBounds(373, 135, 112, 21);
		load.setOpaque(false);
		load.setBorderPainted(false);
		
		rulesField.setBounds(80, 28, 360, 20);
		spamField.setBounds(80, 63, 360, 20);
		hamField.setBounds(80, 97, 360, 20);
		
		add(rulesField);
		add(spamField);
		add(hamField);
		add(rulesButton);
		add(spamButton);
		add(hamButton);
		add(reset);
		add(load);
		
		loadPath();
		
		rulesButton.addActionListener(listener());
		spamButton.addActionListener(listener());
		hamButton.addActionListener(listener());
		reset.addActionListener(listener());
		load.addActionListener(listener());
	}	
	
	private ActionListener listener() throws IOException{
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == rulesButton){
					if(filearray[0] != null){
						File file = filearray[0];
						fc = new JFileChooser(file);
					}else if(filearray[1] != null){
						File file = filearray[1];
						fc = new JFileChooser(file);
					}else if(filearray[2] != null){
						File file = filearray[2];
						fc = new JFileChooser(file);
					}else{
						fc = new JFileChooser();
					}
					
					int returnValRules = fc.showOpenDialog(rulesButton);
						if (theOutString != null){
							fc.setCurrentDirectory(new File(theOutString)); 
						}
						if(returnValRules == JFileChooser.APPROVE_OPTION) {
							theOutString = fc.getSelectedFile().getAbsolutePath();
						if(!theOutString.contains(".cf")) {
							rulesField.setText("");
							filearray[0] = null;
							JOptionPane.showMessageDialog(null, "Tem de carregar um ficheiro com extensão .cf");
						} else {
							rulesField.setText(theOutString);
							filearray[0] = new File(theOutString);
						try {
							savePath();
						} catch (IOException io) {
							io.printStackTrace();
						}
					}
				}
						
				}else if(e.getSource() == hamButton){
					if(filearray[1] != null){
						File file = filearray[1];
						fc = new JFileChooser(file);
					}else if(filearray[0] != null){
						File file = filearray[0];
						fc = new JFileChooser(file);
					}else if(filearray[2] != null){
						File file = filearray[2];
						fc = new JFileChooser(file);
					}else{
						fc = new JFileChooser();
					}
					int returnValHam = fc.showOpenDialog(hamButton);
						if (theOutString != null){
							fc.setCurrentDirectory(new File(theOutString)); }
						if(returnValHam == JFileChooser.APPROVE_OPTION) {
							theOutString = fc.getSelectedFile().getPath();
						if(!theOutString.contains("spam.log")) {
							hamField.setText("");
							filearray[1] = null;
							JOptionPane.showMessageDialog(null, "Tem de carregar um ficheiro com extensão .log");
						} else {
							hamField.setText(theOutString);
							filearray[1] = new File(theOutString);
						try {
							savePath();
						} catch (IOException io) {
							io.printStackTrace();
						}
					}
				}
						
						
				}else if(e.getSource() == spamButton){
					if(filearray[2] != null){
						File file = filearray[2];
						fc = new JFileChooser(file);
					}else if(filearray[0] != null){
						File file = filearray[0];
						fc = new JFileChooser(file);
					}else if(filearray[1] != null){
						File file = filearray[1];
						fc = new JFileChooser(file);
					}else{
						fc = new JFileChooser();
					}
					int returnValSpam = fc.showOpenDialog(spamButton);
						if (theOutString != null){
							fc.setCurrentDirectory(new File(theOutString)); }
						if(returnValSpam == JFileChooser.APPROVE_OPTION) {
							theOutString = fc.getSelectedFile().getPath();
						if(!theOutString.contains("ham.log")) {
							spamField.setText("");
							filearray[2] = null;
							JOptionPane.showMessageDialog(null, "Tem de carregar um ficheiro com extensão .log");
						} else {
							spamField.setText(theOutString);
							filearray[2] = new File(theOutString);
						try {
							savePath();
						} catch (IOException io) {
							io.printStackTrace();
						}
					}
				}
						
						
				}else if(e.getSource() == reset){
					rulesField.setText("");
					hamField.setText("");
					spamField.setText("");
					filearray[0] = null;
					filearray[1] = null;
					filearray[2] = null;
				try {
					savePath();
				} catch (IOException io) {
					io.printStackTrace();
				}
					
					
				}else if(e.getSource() == load){
					if(verifyFiles()){
						System.out.println("OK!");
					}else {
						JOptionPane.showMessageDialog(null, "Tem de carregar os ficheiros restantes!!!");
					}
				}
			}
		};
		return al;
	}
	
	
	private void savePath() throws IOException{
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
	
	private void loadPath()throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader (new FileInputStream(pathlist), "UTF8"));
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
	}
	
	private boolean verifyFiles(){
		if(filearray.length > 0){
			if(filearray[0] != null && filearray[1] != null && filearray[2] != null){
				if(filearray[0].getName().contains(".cf") && filearray[1].getName().contains(".log") && filearray[2].getName().contains(".log")){
					return true;
				}else return false;
			}else return false;
		}else return false;
	}
}
