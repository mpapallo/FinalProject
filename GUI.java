import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener{
    
    private Student player;
    private Container window;
    private JSplitPane pane;
    private JPanel stats, interact;
    private JLabel stress, knowledge, energy, story;
    private JTextField llamo;

    public GUI(){
	this.setTitle("Stuyvesant Finals Week Simulator");
	this.setSize(600, 600);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	window = this.getContentPane();
	window.setLayout(new BorderLayout());
	
	setupStatsPanel();
	setupInteractPanel();
	
	Dimension minSize = new Dimension(50,50);
	stats.setMinimumSize(minSize);
	interact.setMinimumSize(minSize);
	/*
	Dimension prefSize = new Dimension(100,100);
	stats.setPreferredSize(prefSize);
	interact.setPreferredSize(prefSize);
	*/

	pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stats, interact);
	pane.setOneTouchExpandable(true);
	//pane.setSize(500,500);
	pane.setResizeWeight(0.5);
	
	window.add(pane, BorderLayout.CENTER);
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

    public void setupStatsPanel(){
	stats = new JPanel();
	BoxLayout b = new BoxLayout(stats, BoxLayout.Y_AXIS);
	stats.setLayout(b);
	stats.setBorder(BorderFactory.createCompoundBorder(
	  BorderFactory.createTitledBorder("Stats"),
	  BorderFactory.createRaisedBevelBorder()));

	stress = new JLabel("stress: ");
	stress.setBorder(BorderFactory.createLoweredBevelBorder());
	stats.add(stress);
	knowledge = new JLabel("knowledge: ");
	knowledge.setBorder(BorderFactory.createLoweredBevelBorder());
	stats.add(knowledge);
	energy = new JLabel("energy: ");	
	energy.setBorder(BorderFactory.createLoweredBevelBorder());
	stats.add(energy);
    }
    public void setupInteractPanel(){
	interact = new JPanel();
	BoxLayout b = new BoxLayout(interact, BoxLayout.Y_AXIS);
	interact.setLayout(b);
	interact.setBorder(BorderFactory.createCompoundBorder(
	  BorderFactory.createTitledBorder("Story"),
	  BorderFactory.createRaisedBevelBorder()));

	JLabel intro = new JLabel("<html><center>Welcome to the <b>Stuyvesant Finals Week Simulator!</b>\nPlease enter your name and choose a difficulty:</center></html>");
	llamo = new JTextField("Your name here");
	interact.add(intro);
	interact.add(llamo);
	addDifficultyOptions();
	JButton begin = new JButton("Begin");
	begin.setActionCommand("begin");
	begin.addActionListener(this);
	interact.add(begin);
    }

    public void addDifficultyOptions(){
	JRadioButton f = new JRadioButton("Freshman (Easy Street)");
	f.setActionCommand("Freshman");
	f.addActionListener(this);
	JRadioButton s = new JRadioButton("Sophomore");
	s.setActionCommand("Sophomore");
	s.addActionListener(this);	
	JRadioButton jr = new JRadioButton("Junior");
	jr.setActionCommand("Junior");	
	jr.addActionListener(this);	
	JRadioButton sr = new JRadioButton("Senior (Hell Week)");
	sr.setActionCommand("Senior");
	sr.addActionListener(this);	
	//ButtonGroup difficulty = new ButtonGroup();
	//interact.add(difficulty);
	interact.add(f);
	interact.add(s);
	interact.add(jr);
	interact.add(sr);
    }

    public void initializePlayerAndStats(String name){
	player.setName(name);
	updateStress(player.getStress());
	updateKnowledge(player.getKnow());
	updateEnergy(player.getEnergy());
    }

    public void startGame(){
	interact.removeAll();
	story = new JLabel("So you'r a " + player.getLevel() + "at Stuyvesant, and it's finally time for the week everyone dreads.../nWill you die in 5 days, or emerge victorious? It all depends on your choices.");
	interact.add(story);
	interact.revalidate();
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("Freshman")){
	    player = new Freshman();
	}else if (action.equals("Sophomore")){
	    player = new Sophomore();
	}else if (action.equals("Junior")){
	    player = new Junior();
	}else if (action.equals("Senior")){
	    player = new Senior();
	}
	if (action.equals("begin")){
	    initializePlayerAndStats(llamo.getText());
	    startGame();	    
	}
    }
    
}
