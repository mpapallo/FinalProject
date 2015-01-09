import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener{
    
    private Student player;
    private Container window;
    private JSplitPane pane;
    private JPanel stats, interact;
    private JLabel stress, knowledge, energy, story;

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

	interact = new JPanel(new BorderLayout());
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
	
	story = new JLabel("It's Finals Week!");
	interact.add(story, BorderLayout.CENTER);

	stress = new JLabel();
	stress.setBorder(BorderFactory.createLoweredBevelBorder());
	knowledge = new JLabel();
	knowledge.setBorder(BorderFactory.createLoweredBevelBorder());
	energy = new JLabel();	
	energy.setBorder(BorderFactory.createLoweredBevelBorder());
    }

    public void initialize(Student s){
	player = s;
	stress.setText("stress: " + player.getStress());
	knowledge.setText("knowledge: " + player.getKnow());
	energy.setText("energy: " + player.getEnergy());
	stats.add(stress);
	stats.add(knowledge);
	stats.add(energy);
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

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
    }

}
