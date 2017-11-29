package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mechanisms.FileReader;

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
	private Gui gui;
	private boolean lock = false;
	
	public FileConfig(Gui gui) throws IOException {
		this.gui = gui;
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
		
		spamButton = new JButton("...");
		spamButton.setBounds(454, 63, 31, 21);
		
		hamButton = new JButton("...");
		hamButton.setBounds(454, 97, 31, 21);
		
		reset = new JButton("Reset");
		reset.setBounds(243, 135, 112, 21);
		
		load = new JButton("Load Files");
		load.setBounds(373, 135, 112, 21);
		
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
		
		filearray = FileReader.loadPath(rulesField, spamField, hamField);
		
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
					if(!lock){
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
							FileReader.savePath(filearray);
						} catch (IOException io) {
							io.printStackTrace();
						}
					}
						}
				}
						
				}else if(e.getSource() == hamButton){
					if(!lock){
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
							FileReader.savePath(filearray);
						} catch (IOException io) {
							io.printStackTrace();
						}
					}
						}
				}
						
						
				}else if(e.getSource() == spamButton){
					if(!lock){
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
							FileReader.savePath(filearray);
						} catch (IOException io) {
							io.printStackTrace();
						}
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
					rulesField.setEnabled(true);
					spamField.setEnabled(true);
					hamField.setEnabled(true);
					spamButton.setEnabled(true);
					hamButton.setEnabled(true);
					rulesButton.setEnabled(true);
					load.setEnabled(true);
					lock = false;
					gui.repaint();
				try {
					FileReader.savePath(filearray);
				} catch (IOException io) {
					io.printStackTrace();
				}
					
					
				}else if(e.getSource() == load){
					if(!lock){
					if(FileReader.loadAndValidate()){
						FileReader.loadHam();
						FileReader.loadRules();
						FileReader.loadSpam();
						gui.getRightSide().loadAutoConf();
						rulesField.setEnabled(false);
						spamField.setEnabled(false);
						hamField.setEnabled(false);
						spamButton.setEnabled(false);
						hamButton.setEnabled(false);
						rulesButton.setEnabled(false);
						load.setEnabled(false);
						lock = true;
						gui.getManualConfig().enabled();
						gui.getAutoConfig().enabled();
						gui.repaint();
					}else {
						JOptionPane.showMessageDialog(null, "Tem de carregar os ficheiros restantes!!!");
					}
					}
				}
			}
		};
		return al;
	}

	public File getPathlist() {
		return pathlist;
	}
	
}
