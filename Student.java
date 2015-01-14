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
	    time = 1;
	}
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
	return "Coffee spills on your notes. Lose 20 knowledge.";
    }

    public String fireDrill(){
	setStress(getStress() - 5);
	setEnergy(getEnergy() - 5);
	time += 2;
	return "FIIRREEEEE (drill)! The microwave in the chemistry department office goes up in flames, so you miss an entire period of class time.";
    }

    public void brokenEscalator(String ans){
	if (ans == "climb up the stairs"){
	    setEnergy(getEnergy() - 15);
	} else {
	    setGrade(getGrade() - 15);
	    setStress(getStress() - 10);
	    time += 2;
	}
    }

    public String popQuiz(String ans){
	int score = 100 - getStress() + getEnergy() + getKnow();
	score /= 3;
	if (ans == "cheat"){
	    setEnergy(getEnergy() - 10);
	    return "You decided to cheat..." + cheat();
	} else {
	    return "You take the pop quiz... And score a " + score + ".";
	    setGrade(getGrade() + score / 10);
	    setStress(getStress() + 5);
	    setEnergy(getEnergy() - 5);
	}
	time += 2;
    }

    public String eatenHomework(){
	setGrade(getGrade() - 5);
	return "Your piranha eats your homework. Not again!";
    }

    public String subwayDelay(){
	setGrade(getGrade() - 7);
	time += 2;
	return "There is a huge subway delay and you end up missing your first class.";	
    }

    public String cheat(){
	int chance = 100 - getKnow() + getStress() + 100 - getEnergy();
	chance /= 3;
	if (r.nextInt(100) < chance){
	    setGrade(getGrade() + (100 - getKnow())/2);
	    setStress(getStress() - 10);
	    return "You got away with it, you lucky duck...";
	} else {
	    setGrade(getGrade() - 25);
	    setStress(getStress() + 15);
	    return "D'oh! You were caught! Your teacher decided to give you a zero on the quiz and lowered your grade by 25 points.";
	}
    }

    

    public String goToClass(String response){
	if (response == "sleep"){
	    setGrade(getGrade() - 15);
	    setEnergy(getEnergy() + 20);
	    setStress(getStress() - 5);
	    return "You slept like a baby for two hours and learned nothing. Wayto go, Sleeping Beauty.";
	} else if (response == "pass notes"){
	    setGrade(getGrade() - 10);
	    setStress(getStress() - 10);
	    setEnergy(getEnergy() - 5);
	    return "You passed notes all period. You didn't learn anything useful, but you can now act out a whole season of Keeping Up With the Kardashians.";
	} else {
	    setEnergy(getEnergy() - 10);
	    setKnow(getKnow() + 15);
	    setStress(getStress() + 5);
	    return "You sat through class and learned like a good little student.";
	}
    }

}
