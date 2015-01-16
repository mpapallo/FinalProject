import java.util.*;
abstract class Student{
    private String name;
    private int energy, stress, knowledge;
    private int grade;
    public int time;
    Random r = new Random();

    public Student(String n, int e, int s, int k){
	setName(n);
	setEnergy(e);
	setStress(s);
	setKnow(k);
	time = 9;
    }
    public Student(String n){
	this(n, 80, 50, 30);
    }
    public Student(){
	this("Student", 80, 50, 30);
    }
    
    /// variable set and gets ///
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
    public void setGrade(int g){
	grade = g;
    }
    public int getGrade(){
	return grade;
    }

    abstract String getLevel();

    public String toString(){
	return this.getName();
    }
    ////////////////////

    public void sleep(int hrs){
        setEnergy(getEnergy() + hrs * 10);
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

    // check stats //
    public void checkStats(){
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
	    time = 1;
	}
    }
    /////

    public int calculateChancePos(){
	int chance = getKnow() + 100 - getStress() + getEnergy();
	return chance / 3;
    }
    public int calculateChanceNeg(){
	int chance = 100 - getKnow() + getStress() + 100 - getEnergy();
	return chance / 3;
    }

    public void sickDay(String ans){
	if (ans == "stay home"){
	    time+=24;
	    setGrade(getGrade() - 20);
	    setEnergy(100);
	    setStress(getStress() - 10);
	}
    }

    public void helpAFriend(String ans){
	if (ans == "yes"){
	    setStress(getStress() - 20);
	    setEnergy(getEnergy() - 10);
	    time += 2;
	}
    }

    public String coffeeSpill(){
	setKnow(getKnow() - 20);
	time += 2;
	return "<html>You got a free coffee from Starbucks by pretending it was your birthday. You congratulate yourself on your cunning, but while you're sneaking the drink into school, it spills all over your notes! </html>";
    }

    public String fireDrill(){
	time += 2;
	setStress(getStress() - 5);
	setEnergy(getEnergy() - 5);
	return "<html>FIIRREEEEE (drill)! <br>The microwave in the chemistry department office goes up in flames, so you miss an entire period of class time.</html>";
    }

    public String brokenEscalator(String ans){
	time += 2;
	if (ans == "climb up the stairs"){
	    setEnergy(getEnergy() - 15);
	    return "<html>It's a physical struggle that makes you feel like one of those guys who just free-climbed El Capitan, but you bear the pain for the sake of learning.<br> How inspiring.</html>";
	} else {
	    setGrade(getGrade() - 15);
	    setStress(getStress() - 10);
	    return "<html>'Sweating' is not in your lexicon... <br>The stairs win this round, you're not even going to try getting to class.</html>";
	}
    }

    public String popQuiz(String ans){
	time += 2;
	if (ans == "cheat"){
	    setEnergy(getEnergy() - 10);
	    return "<html>You decide to cheat...<br>" + cheat() + "</html>";
	} else {
	    int score = calculateChancePos();
	    setGrade(getGrade() + score / 10);
	    setStress(getStress() + 5);
	    setEnergy(getEnergy() - 5);
	    return "<html>You take the pop quiz...<br>And score a " + score + ".</html>";
	}
    }

    public String eatenHomework(){
	setGrade(getGrade() - 5);
	time += 2
	return "<html>Oh snap! <br>Just as you're about to run out the door, you realize that your piranha ate your homework last night! Your homework grade is going down the toilet... along with that pirahna.</html>";
    }

    public String subwayDelay(){
	setGrade(getGrade() - 7);
	time += 4;
	return "<html>A dead rat on the subway tracks caused a major delay and you end up missing your first class.<br> Thanks, MTA...</html>";	
    }

    public String cheat(){
	int chance = calculateChanceNeg();
	if (r.nextInt(100) < chance){
	    setGrade(getGrade() + (100 - getKnow())/2);
	    setStress(getStress() - 10);
	    return "You got away with it, you lucky duck...";
	} else {
	    setGrade(getGrade() - 25);
	    setStress(getStress() + 15);
	    return "D'oh! You were caught! <br>Your teacher gave you a zero on the quiz and lowered your grade by 25 points.";
	}
    }

    public String goToClass(String response){
	time += 2;
	if (response == "sleep"){
	    setGrade(getGrade() - 15);
	    setEnergy(getEnergy() + 20);
	    setStress(getStress() - 5);
	    return "<html>You slept like a baby for two hours and learned nothing.<br>Way to go, Sleeping Beauty.</html>";
	} else if (response == "pass notes"){
	    setGrade(getGrade() - 10);
	    setStress(getStress() - 10);
	    setEnergy(getEnergy() - 5);
	    return "<html>You passed notes all period. You didn't learn anything useful, but at least you're up to date with the latest season of Keeping Up With the Kardashians.</html>";
	} else {
	    setEnergy(getEnergy() - 10);
	    setKnow(getKnow() + 15);
	    setStress(getStress() + 5);
	    return "<html>You sat through class and learned like a good little student. <br>Hooray!</html> ";
	}
    }

}
