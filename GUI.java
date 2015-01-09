import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener{
    
    private Student player;
    private Container window;
    private JSplitPane pane;
    private JPanel stats, interact;
    private JLabel intro, stress, knowledge, energy, story;
    private JTextField llamo;
    private JButton begin;
    private JRadioButton f, s, jr, sr;

    public GUI(){
	this.setTitle("Stuyvesant Finals Week Simulator");
	this.setSize(600, 600);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	window = this.getContentPane();
	window.setLayout(new BorderLayout());
	
	stats = new JPanel();
	BoxLayout b = new BoxLayout(stats, BoxLayout.Y_AXIS);
	stats.setLayout(b);
	stats.setBorder(BorderFactory.createRaisedBevelBorder());

	stress = new JLabel();
	stress.setBorder(BorderFactory.createLoweredBevelBorder());
	knowledge = new JLabel();
	knowledge.setBorder(BorderFactory.createLoweredBevelBorder());
	energy = new JLabel();	
	energy.setBorder(BorderFactory.createLoweredBevelBorder());

	interact = new JPanel();
	BoxLayout b2 = new BoxLayout(interact, BowLayout.Y_AXIS);
	interact.setLayout(b2);
	interact.setBorder(BorderFactory.createRaisedBevelBorder());

	Dimension minSize = new Dimension(50,50);
	stats.setMinimumSize(minSize);
	interact.setMinimumSize(minSize);
	Dimension prefSize = new Dimension(100,100);
	stats.setPreferredSize(prefSize);
	interact.setPreferredSize(prefSize);

	pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stats, interact);
	pane.setOneTouchExpandable(true);
	pane.setSize(500,500);
	pane.setResizeWeight(0.5);
	
	intro = new JLabel("Welcome to the Stuyvesant Finals Week Simulator!\nWhat is your name?");
	llamo = new JTextField("Your name here");
	interact.add(intro);
	interact.add(llamo);
	addDifficultyOptions();
	begin = new JButton("Next Step");
	begin.setActionCommand("startGame");
	interact.add(begin);

	window.add(pane, BorderLayout.CENTER);
    }

    public void addDifficultyOptions(){
	f = new JRadioButton("Freshman (Easy Street)");
	f.setActionCommand("Freshman");
	f.addActionListener(this);
	s = new JRadioButton("Sophomore");
	s.setActionCommand("Sophomore");
	s.addActionListener(this);	
	jr = new RadioButton("Junior");
	jr.setActionCommand("Junior");	
	jr.addActionListener(this);	
	sr = new JRadioButton("Senior (Hell Week)");
	sr.setActionCommand("Senior");
	sr.addActionListener(this);	
	ButtonGroup difficulty = new ButtonGroup();

	interact.add(difficulty);
    }

    public void initialize(String name){
	//instantiate the player

	stress.setText("stress: " + player.getStress());
	knowledge.setText("knowledge: " + player.getKnow());
	energy.setText("energy: " + player.getEnergy());
	stats.add(stress);
	stats.add(knowledge);
	stats.add(energy);
	story = new JLabel("It's Finals Week!");
	interact.add(story, BorderLayout.CENTER);
    }

    public void updateStress(int s){
	stress.setText("stress: " + s);
    }
    public void updateKnowledge(int k){
	knowledge.setText("knowledge: " + k); 
    }
    public void updateEnergy(int e){
	energy.setText("energy: " + e);
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("startGame")){
	   
	}
    }

}
