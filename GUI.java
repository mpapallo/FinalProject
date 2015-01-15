import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GUI extends JFrame implements ActionListener{
    
    Random r = new Random();
    
    private Student player;
    private Container window;
    private JSplitPane pane;
    private JPanel stats, interact;
    private JLabel stress, knowledge, energy, time, story, q;
    private JTextField llamo;
    private JButton b;
    private boolean bcheat = false;
    private boolean bclimb = true;
    private int inClass = 2;

    public GUI(){
	player = new Freshman();
	story = new JLabel();
	q = new JLabel();

	this.setTitle("Stuyvesant Finals Week Simulator");
	this.setSize(700, 400);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	window = this.getContentPane();
	window.setLayout(new BorderLayout());
	
	setupStatsPanel();
	setupInteractPanel();
	
	Dimension minSize = new Dimension(100,100);
	stats.setMinimumSize(minSize);
	interact.setMinimumSize(minSize);

	pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stats, interact);
	pane.setOneTouchExpandable(true);
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
    public void updateTime(int t){
	time.setText("time: " + t);
    }
    public void autoUpdate(){
	updateStress(player.getStress());
	updateKnowledge(player.getKnow());
	updateEnergy(player.getEnergy());
	updateTime(player.time);
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
	time = new JLabel("time: ");
	time.setBorder(BorderFactory.createLoweredBevelBorder());
	stats.add(time);
    }
    public void setupInteractPanel(){
	interact = new JPanel();
	BoxLayout b = new BoxLayout(interact, BoxLayout.Y_AXIS);
	interact.setLayout(b);
	interact.setBorder(BorderFactory.createCompoundBorder(
	  BorderFactory.createTitledBorder("Story"),
	  BorderFactory.createRaisedBevelBorder()));

	JLabel intro = new JLabel("<html><center>Welcome to the Stuyvesant Finals Week Simulator!<br>Please enter your name and choose a difficulty:</center></html>");
	llamo = new JTextField("Harry Potter");
	llamo.setSize(20, 10);
	interact.add(intro);
	interact.add(llamo);
	addDifficultyOptions();
	JButton next = new JButton("Next");
	next.setActionCommand("next");
	next.addActionListener(this);
	interact.add(next);
    }

    public void addDifficultyOptions(){
	JRadioButton f = new JRadioButton("Freshman (Easy Street)");
	f.setActionCommand("Freshman");
	f.setSelected(true);
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
	ButtonGroup difficulty = new ButtonGroup();
	difficulty.add(f);
	difficulty.add(s);
	difficulty.add(jr);
	difficulty.add(sr);
        interact.add(f);
	interact.add(s);
	interact.add(jr);
	interact.add(sr);
    }

    public void initializePlayerAndStats(String name){
	player.setName(name);
	autoUpdate();
    }

    public void startGame(){
	interact.removeAll();
	story.setText("<html><left>Hi, " + player + "! So you're a " + player.getLevel() + " at Stuyvesant, and it's finally time for the week everyone dreads...<br>Will you die in 5 days, or emerge victorious? It all depends on your choices...</left></html>");
	interact.add(story);
	b = new JButton("Begin");
	b.setActionCommand("begin");
	b.addActionListener(this);
	interact.add(b);
	interact.revalidate();
	window.repaint();
    }
    
    public void day(String d){
	interact.removeAll();

	story.setText("Today is " + d);
	interact.add(story);
	interact.add(q);
	interact.revalidate();
	window.repaint();
	inSchool();
	autoUpdate();
	
    }

    public void inSchool(){
	player.time += 2;
	int chance = player.calculateChanceNeg();
	if (r.nextInt(100) < chance){
	    int e = r.nextInt(2);
	    switch (e) {
	    case 0: q.setText("Your teacher decides to spring a pop quiz on your class!" + player.popQuiz(popQuizResponse()));
		break;
	    case 1: q.setText(player.fireDrill());
		break;
	    case 2: q.setText("What a surprise, the escalators leading up to your class are broken!" + player.brokenEscalator(brokenEscalatorResponse()));
		break;
	    }
	} else {
	    q.setText(player.goToClass(classTimeResponse()));
	}
    }
    
    public String popQuizResponse(){
	JRadioButton cheat = new JRadioButton("cheat off of the kid next to you");
	cheat.setActionCommand("cheat");
	cheat.addActionListener(this);
	JRadioButton quiz = new JRadioButton("honestly take the quiz");
	quiz.setActionCommand("takeQuiz");
	quiz.addActionListener(this);
	ButtonGroup quizGroup = new ButtonGroup();
	quizGroup.add(cheat);
	quizGroup.add(quiz);
	interact.add(cheat);
	interact.add(quiz);
	if (bcheat){
	    return "cheat";
	}else{
	    return "";
	}
    }
    public String brokenEscalatorResponse(){
	JRadioButton climb = new JRadioButton("climb up the escalators");
	climb.setActionCommand("climb");
	climb.addActionListener(this);
	JRadioButton no = new JRadioButton("absolutely not, just cut class");
	no.setActionCommand("noClimb");
	no.addActionListener(this);
	ButtonGroup escalator = new ButtonGroup();
	escalator.add(climb);
	escalator.add(no);
	interact.add(climb);
	interact.add(no);
        if (bclimb){
	    return "climb up the stairs";
	}else{
	    return "";
	}
    }
    public String classTimeResponse(){
	JRadioButton sleep = new JRadioButton("doze off");
	sleep.setActionCommand("nap");
	sleep.addActionListener(this);
	JRadioButton passNotes = new JRadioButton("whisper/ pass notes to your friends");
        passNotes.setActionCommand("passNotes");
	passNotes.addActionListener(this);
	JRadioButton learn  = new JRadioButton("actually pay attention");
	learn.setActionCommand("learn");
	learn.addActionListener(this);
	ButtonGroup classTime = new ButtonGroup();
	classTime.add(sleep);
        classTime.add(passNotes);
	classTime.add(learn);
	interact.add(sleep);
	interact.add(passNotes);
	interact.add(learn);
	if (inClass == 0){
	    return "sleep";
	}else if (inClass == 1){
	    return "pass notes";
	}else{
	    return "";
	}
    }
    /*
    public void afterSchool(){
	int chance = getStress() + 100 - getKnow() + 100 - getEnergy();
	chance /= 3;
	String activity = afterSchoolResponse();
	setHomework(false);
	if (r.nextInt(100) < chance) {
	    helpAFriend(helpAFriendResponse());
	} else {
	    if (activity == "study") {
		study(1);
	    } else if (activity == "homework") {
		doHomework();
	    } else if (activity == "facebook"){
		socialize(1);
	    } else if (activity == "text"){
		socialize(1);
	    } else {
		time = 7;
		if (time >= 6) {
		    sleep(24-time);
		} else {
		    sleep(6-time);
		}
	    } 
	}
    }

    public void morning(){
	time = 7;
	chance = getStress() + 100 - getEnergy() + 100 - getKnow();
	chance /= 3;
	if (r.nextInt(100) < chance){
	    int x = r.nextInt(4);
	    switch (x) {
	    case 0: eatenHomework();
		break;
	    case 1: subwayDelay();
		break;
	    case 2: coffeeSpill();
		break;
	    case 3: sickDay(sickDayResponse);
		break;
	    }
	}
    }

    public String afterSchoolResponse(){
	
    }

    public String helpAFriendResponse(){

    }

    public String sickDayResponse(){

    }
    */

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
	if (action.equals("next")){
	    initializePlayerAndStats(llamo.getText());
	    startGame();	    
	}
	if (action.equals("begin")){
	    String[] days = new String[4];
	    days[0] = "Monday";
	    days[1] = "Tuesday";
	    days[2] = "Wednesday";
	    days[3] = "Thursday";
	    
	    day(days[0]);		
	    //it will be a for loop, need to call day for each day in the array
	}
	if (action.equals("cheat")){
	    bcheat = true;
	}else if (action.equals("takeQuiz")){
	    bcheat = false;
	}
	if (action.equals("climb")){
	    bclimb = true;
	}else if(action.equals("noClimb")){
	    bclimb = false;
	}
	if (action.equals("nap")){
	    inClass = 0;
	}else if (action.equals("passNotes")){
	    inClass = 1;
	}else if (action.equals("learn")){
	    inClass = 2;
	}
    }
    
}
