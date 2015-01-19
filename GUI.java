import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
public class GUI extends JFrame implements ActionListener{

    /////////////////////////
    Random r = new Random();
    String[] days = new String[5];
    int dayi = 0;

    private Student player;
    private Container window;
    private JSplitPane pane;
    private JPanel stats, interact;
    private JLabel stress, knowledge, energy, time, day, story, q;
    private JTextField llamo;
    private boolean bcheat = false;
    private boolean bclimb = true;
    private boolean bstayHome = false;
    private boolean bhelp = false;
    private int inClass = 2;
    private int afSchool = 3;
    private String s = "";
    
    Font font = new Font("Optima", Font.PLAIN, 16);
    Font eventFont = new Font("Optima", Font.PLAIN, 16);
    Font statsFont = new Font("Optima", Font.PLAIN, 14);
    Font buttonFont = new Font("Optima", Font.BOLD, 14);
    /////////////////////////
    public GUI(){
	player = new Freshman();
	story = new JLabel();
	q = new JLabel();
	story.setFont(font);
	q.setFont(font);
	days[0] = "Monday";
	days[1] = "Tuesday";
	days[2] = "Wednesday";
	days[3] = "Thursday";
	days[4] = "Friday";

	this.setTitle("Stuyvesant Finals Week Simulator");
	this.setSize(800, 400);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	window = this.getContentPane();
	window.setLayout(new BorderLayout());
	setupStatsPanel();
	setupInteractPanel();
	
	Dimension minSize = new Dimension(300,300);
	stats.setMinimumSize(minSize);
	interact.setMinimumSize(minSize);

	pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, stats, interact);
	pane.setOneTouchExpandable(true);
	pane.setResizeWeight(0.5);
	pane.setBackground(Color.WHITE);
	stats.setBackground(Color.WHITE);
	interact.setBackground(Color.WHITE);
	window.add(pane, BorderLayout.CENTER);
    }

    /////////////////////////
    ///       setup       ///
    /////////////////////////
    public void setupStatsPanel(){
	stats = new JPanel();
	BoxLayout b = new BoxLayout(stats, BoxLayout.Y_AXIS);
	stats.setLayout(b);
	stats.setBorder(BorderFactory.createCompoundBorder(
           BorderFactory.createTitledBorder("Stats"),
           BorderFactory.createRaisedBevelBorder()));
	stats.setMinimumSize(new Dimension(100,100));
	stress = new JLabel("stress: ");
	stress.setBorder(BorderFactory.createEmptyBorder());
	stats.add(stress);
	knowledge = new JLabel("knowledge: ");
	knowledge.setBorder(BorderFactory.createEmptyBorder());
	stats.add(knowledge);
	energy = new JLabel("energy: ");
	energy.setBorder(BorderFactory.createEmptyBorder());
	stats.add(energy);
	time = new JLabel("time: ");
	time.setBorder(BorderFactory.createEmptyBorder());
	stats.add(time);
	day = new JLabel("Today is ");
	day.setBorder(BorderFactory.createEmptyBorder());
	stats.add(day);

	stress.setFont(statsFont);
	energy.setFont(statsFont);
	day.setFont(statsFont);
	time.setFont(statsFont);
	knowledge.setFont(statsFont);
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
	llamo.setFont(font);
	addDifficultyOptions();

	JButton next = new JButton("Next");
	next.setActionCommand("next");
	next.addActionListener(this);
	interact.add(next);

	next.setFont(buttonFont);
	intro.setFont(eventFont);
	next.setHorizontalAlignment(JLabel.CENTER);
	intro.setHorizontalAlignment(JLabel.CENTER);
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

	f.setFont(buttonFont);
	s.setFont(buttonFont);
	jr.setFont(buttonFont);
	sr.setFont(buttonFont);
    }

    /////////////////////////
    ///  updating stats   ///
    /////////////////////////
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
	if (t < 12){
	    time.setText("time: " + t + " a.m.");
	} else if (t == 12) {
	    time.setText("time: " + t + " p.m.");
	} else {
	    time.setText("time: " + (t-12) + " p.m.");
	}
    }
    public void updateDay(String d){
	day.setText("Today is " + d + ".");
    }
    public void autoUpdate(){
	updateStress(player.getStress());
	updateKnowledge(player.getKnow());
	updateEnergy(player.getEnergy());
	updateTime(player.time);
	updateDay(days[dayi]);
	window.repaint();
    }
    public void reset(){
	interact.removeAll();
	interact.revalidate();
	window.repaint();
    }
    
    /////////////////////////
    ///       intro       ///
    /////////////////////////
    public void initializePlayerAndStats(String name){
	player.setName(name);
        updateStress(player.getStress());
	updateEnergy(player.getEnergy());
	updateKnowledge(player.getKnow());
    }

    public void startGame(){
        reset();
	story.setText("<html><center>Hi, " + player + "! So you're a " + player.getLevel() + " at Stuyvesant, and it's finally time for the week everyone dreads...<br><br>Will you die in 5 days, or emerge victorious? It all depends on your choices...</center><br></html>");
	interact.add(story);
	JButton b = new JButton("Begin");
	b.setActionCommand("begin");
	b.addActionListener(this);
	interact.add(b);

	story.setHorizontalAlignment(JLabel.CENTER);
	b.setFont(buttonFont);
    }

    /////////////////////////
    /// user interaction  ///
    /////////////////////////

    ///// morning /////
    public void morning(){
	reset();
	dayi += 1;
	updateDay(days[dayi]);
	autoUpdate();
	player.homework = false;
	//if (dayi == 4){ FINALS DAY FUNCTION } break;
	String z = "<html>It's a fresh, new day! <br>As usual, you wake up and instantly regret doing so. Time to get ready for school...<br></html>";
	story.setText(z);
	interact.add(story);

	int chance = player.calculateChanceNeg();
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
	    case 3: JLabel l = new JLabel("<html>Wait, wha... wh... AH-CHOO! <br>Guess you couldn't escape the flu forever... Should you stay or should you go (to school)?<br></html>");
		l.setFont(eventFont);
		interact.add(l);
		sickDayResponse();
		break;
	    }
	}else{
	    player.time += 2;
	    q.setText("<html>Thankfully, the morning is uneventful and you get to school in one piece.</html>");
	    displayResponse();  
	}
    }

    public void sickDayResponse(){
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
	
	JButton b = new JButton("Submit");
	b.setActionCommand("sickDayResponse");
	b.addActionListener(this);
	interact.add(b);
	
	go.setFont(eventFont);	
	stay.setFont(eventFont);
    }

    ///// in school /////
    public void inSchool(){
	reset();
	autoUpdate();
	if (player.time == 9){
	    story.setText("<html>You are in your first class of the day.</html>");
	}else if (player.time == 11){
	    story.setText("<html>Another period of learning. At least it means lunch is closer.</html>");
	}else{
	    story.setText("One eternity later, you are finally in your last class of the day!");
	}
	interact.add(story);

	int chance = player.calculateChanceNeg();

	if (r.nextInt(100) < chance){
	    int e = r.nextInt(2);
	    switch (e) {
	    case 0: JLabel l = new JLabel("<html>Your teacher decides to spring a pop quiz on your class!<br></html>");
		l.setFont(eventFont);
		interact.add(l);
		popQuizResponse();
		break;
	    case 1: q.setText(player.fireDrill());
		displayResponse();
		break;
	    case 2: JLabel m = new JLabel("<html>What a surprise, the escalators leading up to your class are broken!<br></html>");
		m.setFont(eventFont);
		interact.add(m);
		brokenEscalatorResponse();
		break;
	    }
	} else {
	    JLabel n = new JLabel("<html>Nothing special is happening. What should you do?<br></html>");
	    n.setFont(eventFont);
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

	cheat.setFont(eventFont);
	quiz.setFont(eventFont);
	b.setFont(buttonFont);
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

	climb.setFont(eventFont);
	no.setFont(eventFont);	
	b.setFont(buttonFont);
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
	
	sleep.setFont(eventFont);
	passNotes.setFont(eventFont);
	learn.setFont(eventFont);
	b.setFont(buttonFont);
    }

    
    ///// after school /////
    public void afterSchool(){
	reset();
	autoUpdate();
	if (player.time == 15){
	    story.setText("<html>School's out for the day! Now you have some time to do whatever you want<br></html>");
	}else{
	    story.setText("<html>It sure is nice to be home<br></html>");
	}
	interact.add(story);

	int chance = player.calculateChanceNeg();
	chance -= 20;

	if ((r.nextInt(100) < chance) && (player.helpedFriend == false)) {
	    JLabel l = new JLabel("<html>Your friend asks you to help them rehearse for SING!. Of course, this will reduce your precious free time. What do you do?<br></html>");
	    l.setFont(eventFont);
	    interact.add(l);
	    helpAFriendResponse();
	} else {
	    JLabel n = new JLabel("<html>Home sweet home! What do you want to do now?<br></html>");
	    n.setFont(eventFont);
	    interact.add(n);
	    afterSchoolResponse();
	}
    }

    public void afterSchoolResponse(){
	JRadioButton study = new JRadioButton("study");
	study.setActionCommand("studyNotes");
	study.addActionListener(this);
	JRadioButton homework  = new JRadioButton("do your homework");
	homework.setActionCommand("doHomework");
	homework.addActionListener(this);
	JRadioButton facebook = new JRadioButton("go on Facebook");
	facebook.setActionCommand("onFacebook");
	facebook.addActionListener(this);
	JRadioButton sleep = new JRadioButton("go to sleep");
	sleep.setActionCommand("goToSleep");
	sleep.addActionListener(this);
	ButtonGroup afterSchoolGroup = new ButtonGroup();
	afterSchoolGroup.add(study);
	afterSchoolGroup.add(homework);
	afterSchoolGroup.add(facebook);
	afterSchoolGroup.add(sleep);
	interact.add(study);
	interact.add(homework);
	interact.add(facebook);
	interact.add(sleep);
	JButton b = new JButton("Submit");
	b.setActionCommand("afterSchoolResponse");
	b.addActionListener(this);
	interact.add(b);

	study.setFont(eventFont);
	homework.setFont(eventFont);
	facebook.setFont(eventFont);
	sleep.setFont(eventFont);
	b.setFont(buttonFont);
    }

    public void helpAFriendResponse(){
	JRadioButton yes = new JRadioButton("help your friend");
	yes.setActionCommand("helpFriend");
	yes.addActionListener(this);
	JRadioButton no = new JRadioButton("let your friend rehearse alone");
	no.setActionCommand("dontHelp");
	no.addActionListener(this);
	ButtonGroup helpFriendGroup = new ButtonGroup();
	helpFriendGroup.add(yes);
	helpFriendGroup.add(no);
	interact.add(yes);
	interact.add(no);
	JButton b = new JButton("Submit");
	b.setActionCommand("helpAFriendResponse");
	b.addActionListener(this);
	interact.add(b);

	yes.setFont(eventFont);
	no.setFont(eventFont);
	b.setFont(buttonFont);
    }
    
    /////////////////////////
    public void displayResponse(){
	player.checkStats();
	player.checkTime();
	autoUpdate();
	interact.add(q);
	JButton next = new JButton("Continue");
	next.setActionCommand("cont");
	next.addActionListener(this);
	interact.add(next);
	
	next.setFont(buttonFont);
    }
    /////////////////////////
    public void paint(Graphics g){
	super.paint(g);
	g.drawRect(130,45,100,10);
	g.drawRect(130,65,100,10);
	g.drawRect(130,85,100,10);
	g.fillRect(130,45,Student.getStress(),10);
	g.fillRect(130,65,Student.getKnow(),10);
	g.fillRect(130,85,Student.getEnergy(),10);

    }

    /////////////////////////
    ///  action listener  ///
    /////////////////////////
    public void actionPerformed(ActionEvent e){
	repaint();
	String action = e.getActionCommand();
	/////////////////////////
	if (action.equals("Freshman")){
	    player = new Freshman();
	}else if (action.equals("Sophomore")){
	    player = new Sophomore();
	}else if (action.equals("Junior")){
	    player = new Junior();
	}else if (action.equals("Senior")){
	    player = new Senior();
	}
	/////////////////////////
	if (action.equals("next")){
	    initializePlayerAndStats(llamo.getText());
	    startGame();	    
	}
	/////////////////////////
	if (action.equals("begin")){
	    reset();
	    updateDay(days[dayi]);
	    //y = inSchool("first");
	    inSchool();
	}
	/////////////////////////
	if (action.equals("stayHome")){
	    bstayHome = true;
	}else if (action.equals("goToSchool")){
	    bstayHome = false;
	}
	if (action.equals("sickDayResponse")){
	    if (bstayHome){
		s = "stay home";
	    }else{
		s = "";
	    }
	    q.setText(player.sickDay(s));
	    reset();
	    displayResponse();
	}
	/////////////////////////
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
	    reset();
	    displayResponse();
	}
	/////////////////////////
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
	    reset();
	    displayResponse();
	}
	/////////////////////////
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
	    reset();
	    displayResponse();
	}
	/////////////////////////
	if (action.equals("studyNotes")){
	    afSchool = 0;
	} else if (action.equals("doHomework")){
	    afSchool = 1;
	} else if (action.equals("onFacebook")){
	    afSchool = 2;
	} else if (action.equals("goToSleep")){
	    afSchool = 3;
	}
	if (action.equals("afterSchoolResponse")){
	    if (afSchool == 0){
		s = "study";
	    } else if (afSchool == 1){
		s = "homework";
	    } else if (afSchool == 2){
		s = "facebook";
	    } else {
		s = "";
	    }
	    q.setText(player.afterSchoolTime(s));
	    reset();
	    displayResponse();
	}
	/////////////////////////
	if (action.equals("helpFriend")){
	    bhelp = true;
	} else if (action.equals("dontHelp")){
	    bhelp = false;
	}
	if (action.equals("helpAFriendResponse")){
	    if (bhelp) {
		s = "yes";
	    } else {
		s = "";
	    }
	    q.setText(player.helpAFriend(s));
	    reset();
	    displayResponse();
	}
	////////////////////////
	/*
	if (action.equals("cont") && y.equals("first")){
	    y = inSchool("second");
	} else if (action.equals("cont") && y.equals("second")){
	    y = inSchool("last");
	} else if (action.equals("cont") && (y.equals("last") || y.equals("aS"))){
	    y = afterSchool();
	} else if (action.equals("cont") && y.equals("morn")){
	    morning();
	}
	*/
	if (action.equals("cont")){
	    if (player.time == 7){
		morning();
	    }else if (player.time >= 9 && player.time <= 13){
		inSchool();
	    }else if (player.time >= 15 || player.time <= 7){
		afterSchool();
	    }
	}
    }
    
}
