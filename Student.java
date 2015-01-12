abstract class Student{
    private String name;
    private int energy, stress, knowledge;
    private int grade;
    public int time;

    public Student(String n, int e, int s, int k){
	setName(n);
	setEnergy(e);
	setStress(s);
	setKnow(k);
    }
    public Student(String n){
	this(n, 80, 50, 30);
    }
    public Student(){
	this("Student", 80, 50, 30);
    }
    
    public void setName(String n){
	name = n;
    }
    public String getName(){
	return name;
    }
    public void setEnergy(int e){
	energy = e;
    }
    public int getEnergy(){
	return energy;
    }
    public void setStress(int s){
	stress = s;
    }
    public int getStress(){
	return stress;
    }
    public void setKnow(int k){
	knowledge = k;
    }
    public int getKnow(){
	return knowledge;
    }

    public String toString(){
	return this.getName();
    }
    abstract String getLevel();

    public void sleep(int hrs){
	this.setEnergy(this.getEnergy() + hrs * 10);
    }

    public void study(int hrs){
	setKnow(getKnow() + hrs*5);
	setStress(getStress() + hrs*3);
	setEnergy(getEnergy() - hrs*5);
    }

    public void socialize(int hrs){
	setStress(getStress() - hrs*5);
	setEnergy(getEnergy() - hrs*4);
    }

    // check if attributes are between 0 and 100
    public void check(){
	if (getKnow() > 100){
	    setKnow(100);
	} else if (getKnow() < 0) {
	    setKnow(0);
	}
	if (getStress() > 100){
	    setStress(100);
	} else if (getStress() < 0) {
	    setStress(0);
	}
	if (getEnergy() > 100){
	    setEnergy(100);
	} else if (getEnergy() < 0) {
	    setEnergy(0);
	}
    }

    public void checkTime(){
	if (time > 24){
	    time = 0;
	    
	}
    }
   
    public static void sickDay(String ans){
	if (ans == "stay home"){
	    time+=24;
	    setGrade(getGrade() - 20);
	    setEnergy(100);
	    setStress(getStress() - 10);
	}
    }

    public static void helpAFriend(String ans){
	if (ans == "yes"){
	    setStress(getStress() - 20);
	    setEnergy(getEnergy() - 10);
	    time += 2;
	}
    }

    public static String coffeeSpill(){
	setKnow(getKnow() - 20);	
	return "Coffee spills on your notes. Lose 20 knowledge.";
    }

    public static String fireDrill(){
	setStress(getStress() - 5);
	setEnergy(getEnergy() - 5);
	return "There is a fire drill during class which ends up taking the entire period. I guess you're not going to that class today!";
	time += 2;
	
    }

    public void brokenEscalator(String ans){
	if (ans == "climb up the stairs"){
	    setEnergy(getEnergy - 15);
	} else {
	    setGrade(getGrade() - 15);
	    setStress(getStress() - 10);
	    time += 2;
	}
    }

    public static String popQuiz(){
	int score = 100 - getStress() + getEnergy() + getKnowledge();
	score /= 3;
	setGrade(getGrade() + score / 10);
	setStress(getStress + 5);
	setEnergy(getEnergy - 5);	
	String ans = "Your teacher springs a pop quiz on you. Based on your knowledge, stress, and energy, you score a " + score + ".";
	time += 2;
	return ans;
    }

    public static String eatenHomework(){
	setGrade(getGrade() - 5);
	return "Your piranha eats your homework. Not again!";
    }

    public static String subwayDelay(){
	setGrade(getGrade() - 7);
	return "There is a huge subway delay and you end up missing your first class.";
	time += 2;
    }

    public void cheat(int chance){
	if (r.nextInt(100) < chance){
	    setGrade(getGrade() + (100 - getKnow())/2);
	} else {
	    setGrade(0);
	}
    }

}
