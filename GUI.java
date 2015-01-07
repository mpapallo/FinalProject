import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener{
    
    private Container window;
    private JPanel pane1, pane2, pane3, pane4;
    private JLabel stat1;

    public GUI(){
	this.setTitle("Stuyvesant Finals Week");
	this.setSize(600, 400);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	window = this.getContentPane();
	window.setLayout(new GridBagLayout());

	pane1 = new JPanel(new BorderLayout());
	pane1.setBorder(BorderFactory.createLoweredBevelBorder());
	stat1 = new JLabel("stress level: ");
	pane1.add(stat1);

	pane2 = new JPanel(new BorderLayout());
	pane3 = new JPanel(new BorderLayout());
	pane4 = new JPanel(new BorderLayout());

	window.add(pane1);
	window.add(pane2);
	window.add(pane3);
	window.add(pane4);
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
    }

}
