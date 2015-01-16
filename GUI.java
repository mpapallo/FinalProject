import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GUI extends JFrame implements ActionListener{
    
    Random r = new Random();
    String[] days = new String[4];
    int dayi = 0;
    String[] activities = new String[4];
    int activity = 1;
    private Student player;
    private Container window;
    private JSplitPane pane;
    private JPanel stats, interact;
    private JLabel stress, knowledge, energy, time, day, story, q;
    private JTextField llamo;
    private boolean bcheat = false;
    private boolean bclimb = true;
    private boolean bstayHome = false;
    private int inClass = 2;
    private String s;
	    
    public GUI(){
	player = new Freshman();
	story = new JLabel();
	q = new JLabel();
	days[0] = "Monday";
	days[1] = "Tuesday";
	days[2] = "Wednesday";
	days[3] = "Thursday";
	activities[0] = "morning";
	activities[1] = "inSchool1";
	activities[2] = "inSchool2";
	activities[3] = "afterSchool";
	
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
    public void updateDay(String d){
	day.setText("Today is: " + d);
    }
    public void autoUpdate(){
	updateStress(player.getStress());
	updateKnowledge(player.getKnow());
	updateEnergy(player.getEnergy());
	updateTime(player.time);
    }
    
    public void reset(){
	interact.removeAll();
	interact.revalidate();
	window.repaint();
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
	day = new JLabel("Today is: ");
	day.setBorder(BorderFactory.createLoweredBevelBorder());
	stats.add(day);
    }
    public void setupInteractPanel(){
	interact = new JPanel();
	BoxLayout b = new BoxLayout(interact, BoxLayout.Y_AXIS);
	interact.setLayout(b);
	interact.setBorder(BorderFactory.createCompoundBorder(
	  BorderFactory.createTitledBorder("Story"),
	  BorderFactory.createRaisedBevelBorder()));

	JLabel intro = new JLabel("<html>Welcome to the Stuyvesant Finals Week Simulator!<br>Please enter your name and choose a difficulty:</html>");
	llamo = new JTextField("Harry Potter");
	llamo.setSize(5, 10);
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
        updateStress(player.getStress());
	updateEnergy(player.getEnergy());
	updateKnowledge(player.getKnow());
    }

    public void startGame(){
        reset();
	story.setText("<html>Hi, " + player + "! So you're a " + player.getLevel() + " at Stuyvesant, and it's finally time for the week everyone dreads...<br>Will you die in 5 days, or emerge victorious? It all depends on your choices...</html>");
	interact.add(story);
	JButton b = new JButton("Begin");
	b.setActionCommand("begin");
	b.addActionListener(this);
	interact.add(b);
    }
    /*
    public void nextAct(String d){
	updateDay(d);
	if (activity == 0){
	    morning();
	}else if (activity == 1){
	    inSchool("first");
	}else if (activity == 2){
	    inSchool("last");
	}else{
	    afterSchool();
	}
    }
    */

    public void inSchool(String x){
	reset();
	autoUpdate();
	activity += 1;
	String z = "You are in your " + x + " class of the day.";
	if (x.equals("last")){
	    story.setText("<html>One eternity later...<br>" + z + "</html>");
	}else{
	    story.setText("<html>" + z + "</html>");
	}
	interact.add(story);
	int chance = player.calculateChanceNeg();
	if (r.nextInt(100) < chance){
	    int e = r.nextInt(2);
	    switch (e) {
	    case 0: JLabel l = new JLabel("<html>Your teacher decides to spring a pop quiz on your class!</html>");
		interact.add(l);
		popQuizResponse();
		break;
	    case 1: q.setText(player.fireDrill());
		displayResponse();
		break;
	    case 2: JLabel m = new JLabel("<html>What a surprise, the escalators leading up to your class are broken!</html>");
		interact.add(m);
		brokenEscalatorResponse();
		break;
	    }
	} else {
	    JLabel n = new JLabel("<html>Nothing special is happening. What should you do?</html>");
	    interact.add(n);
	    classTimeResponse();
	}
    }
    
    public void popQuizResponse(){
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
	JButton b = new JButton("Submit");
	b.setActionCommand("popQuizResponse");
	b.addActionListener(this);
	interact.add(b);
    }
    public void brokenEscalatorResponse(){
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
	JButton b = new JButton("Submit");
	b.setActionCommand("brokenEscalatorResponse");
	b.addActionListener(this);
	interact.add(b);
    }
    public void classTimeResponse(){
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
	JButton b = new JButton("Submit");
	b.setActionCommand("classTimeResponse");
	b.addActionListener(this);
	interact.add(b);
    }

    public void morning(){
	reset();
	time = 7;
	autoUpdate();
	activity += 1;
	String z = "<html>It's a fresh, new day! <br>As usual, you wake up and instantly regret doing so. Time to get ready for school...</html>";
	story.setText(z);
	interact.add(story);
	chance = player.calculateChanceNeg();
	if (r.nextInt(100) < chance){
	    int x = r.nextInt(4);
	    switch (x) {
	    case 0: q.setText(player.eatenHomework());
		displayResponse();
		break;
	    case 1: q.setText(player.subwayDelay());
		displayResponse();
		break;
	    case 2: q.setText(player.coffeeSpill());
		displayResponse();
		break;
	    case 3: JLabel l = new JLabel("You couldn't escape the flu forever... Should you stay or should you go (to school)?");
		interact.add(l);
		sickDayResponse();
		break;
	    }
	}else{
	    
	}
    }

    public String sickDayResponse(){
	JRadioButton stay = new JRadioButton("'What!? I can't go to school like this!'");
	stay.setActionCommand("stayHome");
	stay.addActionListener(this);
	JRadioButton go = new JRadioButton("'I'm a survivor, I can do it'");
	go.setActionCommand("goToSchool");
	go.addActionListener(this);
	ButtonGroup sickDay = new ButtonGroup();
	sickDay.add(stay);
	sickDay.add(go);
	interact.add(stay);
	interact.add(go);	
    }

    /*
    public void afterSchool(){
	activity = 0;
	int chance = player.calculateChanceNeg();
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

    public String afterSchoolResponse(){
	
    }
    public String helpAFriendResponse(){
	
    }
    */

    public void displayResponse(){
	reset();
	player.checkStats();
	player.checkTime();
	autoUpdate();
	interact.add(q);
	JButton next = new JButton("Continue");
	next.setActionCommand("cont");
	next.addActionListener(this);
	interact.add(next);
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
	if (action.equals("next")){
	    initializePlayerAndStats(llamo.getText());
	    startGame();	    
	}
	if (action.equals("begin")){
	    reset();
	    updateDay(days[dayi]);
	    inSchool("first");
	    //at the end of the day we will increment day by 1, have another button with this action command so a new day begins
	    //we should start in the morning of monday not in school...
	}
	if (action.equals("stayHome")){
	    bstayHome = true;
	}else if (action.equals("goToSchool")){
	    bstayHome = false;
	}
	if (action.equals("cheat")){
	    bcheat = true;
	}else if (action.equals("takeQuiz")){
	    bcheat = false;
	}
	if (action.equals("popQuizResponse")){
	    if (bcheat){
		s = "cheat";
	    }else{
		s = "";
	    }
	    q.setText(player.popQuiz(s));
	    displayResponse();
	}
	if (action.equals("climb")){
	    bclimb = true;
	}else if(action.equals("noClimb")){
	    bclimb = false;
	}
	if (action.equals("brokenEscalatorResponse")){
	    if (bclimb){
		s = "climb up the stairs";
	    }else{
		s = "";
	    }
	    q.setText(player.brokenEscalator(s));
	    displayResponse();
	}
	if (action.equals("nap")){
	    inClass = 0;
	}else if (action.equals("passNotes")){
	    inClass = 1;
	}else if (action.equals("learn")){
	    inClass = 2;
	}
	if (action.equals("classTimeResponse")){
	    if (inClass == 0){
	        s = "sleep";
	    }else if (inClass == 1){
	        s = "pass notes";
	    }else{
	        s ="";
	    }
	    q.setText(player.goToClass(s));
	    displayResponse();
	}
	if (action.equals("cont")){
	    reset();
	    inSchool("last");
	}
    }
    
}
