import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener{
    
    private Student player;
    private Container window;
    private JSplitPane pane;
    private JPanel stats, interact;
    private JPanel pane1, pane2, pane3, pane4;
    private JLabel stress, knowledge, energy, story;

    public GUI(){
	this.setTitle("Stuyvesant Finals Week Simulator");
	this.setSize(900, 900);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	window = this.getContentPane();
	window.setLayout(new FlowLayout());

	stats = new JPanel(new BorderLayout());
	stats.setSize(400, 400);
	stats.setBorder(BorderFactory.createRaisedBevelBorder());
	interact = new JPanel(new BorderLayout());
	interact.setSize(400, 400);
	interact.setBorder(BorderFactory.createRaisedBevelBorder());
	Dimension minSize = new Dimension(100, 100);
	stats.setMinimumSize(minSize);
	interact.setMinimumSize(minSize);

	pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stats, interact);
	pane.setOneTouchExpandable(true);
	pane.setDividerLocation(100);
	pane.setSize(800, 800);
	pane.setResizeWeight(0.5);
	
	story = new JLabel("It's Finals Week!");
	story.setBorder(BorderFactory.createLineBorder(Color.black));
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
	stats.add(stress, BorderLayout.PAGE_START);
	stats.add(knowledge, BorderLayout.CENTER);
	stats.add(energy, BorderLayout.PAGE_END);
	window.add(pane);
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
