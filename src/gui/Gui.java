package gui;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Gui extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private FileConfig file;
	private AutoConfig auto;
	private ManualConfig manual;
	private File bg = new File("background/main_design.png");
	private JLabel background;
	private JPanel main_panel;

	public Gui() throws IOException{
		main_panel = new JPanel();
		main_panel.setLayout(null);
		
		this.file = new FileConfig();
		this.auto = new AutoConfig();
		this.manual = new ManualConfig();
		setSize(new Dimension(1000, 615));
		setTitle("AntiSpamConfigurationForLeisureMailbox");
		background = new JLabel(new ImageIcon(ImageIO.read(bg)));
		background.setBounds(0, 0, 1000, 600);
		
		
		main_panel.add(file);
		main_panel.add(auto);
		main_panel.add(manual);
		main_panel.add(background);
	
		
		add(main_panel);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*this.AutoConfig= new AutoConfig(this);
		this.ManualConfig= new ManualConfig(this);*/
		
		
	}

}
