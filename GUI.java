import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame{
    //later add: implements ActionListener//
    
    private Container window;
    private JPanel pane1, pane2, pane3, pane4;

    public GUI(){
	this.setTitle("Stuyvesant Finals Week Simulator");
	this.setSize(600, 400);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	window = this.getContentPane();
	window.setLayout(new GridLayout());

	pane1 = new JPanel(new FlowLayout());
	pane2 = new JPanel(new FlowLayout());
	pane3 = new JPanel(new FlowLayout());
	pane4 = new JPanel(new FlowLayout());

	window.add(pane1);
	window.add(pane2);
	window.add(pane3);
	window.add(pane4);
    }
    
    public static void main(String[]args){
        GUI f = new GUI();
	f.setVisible(true);
    }

}
