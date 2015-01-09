import java.util.*;

public class Events { 
    public int time;
    public String 
   
    public void randomEvent(){
	int chance = 100 - getEnergy() + getStress();       
	chance /= 2;

	if (r.nextInt(100) <= chance){
	    int event = r.nextInt(8);
	    switch (event){
	    case 0: 
	
		break;
	    case 1:
	
		break;
	    case 2: 

		break;
	    case 3: 
		
		break;
	    case 4: 

	    }
	}
    }

    public void sickDay(String ans){
	System.out.println("You wake up feeling terrible. Do you want to take a sick day or brave it out?");
	if (ans == "stay home"){
	    
	}
    }

    public void helpAFriend(String ans){
	System.out.println("A friend asks you to help them with their act for the talent show after school, but it will take up two hours of your time. Do you want to help them?");
	if (ans == "yes"){
	    setStress(getStress() - 20);
	    setEnergy(getEnergy() - 10);
	}
    }

    public void coffeeSpill(){
	System.out.println("Coffee spills on your notes. Lose 20 knowledge.");
	setKnow(getKnow() - 20);
    }

    public void fireDrill(){
	System.out.println("There is a fire drill during class which ends up taking the entire period. I guess you're not going to that class today!");
	setStress(getStress() - 5);
	setEnergy(getEnergy() - 5);
	
    }

    public void brokenEscalator(String ans){
	System.out.println("The escalator is broken...again. You can climb up the stairs and lose 15 energy or you can just cut class. Which will you choose?");
	if (ans == "climb up the stairs"){
	    setEnergy(getEnergy - 15);
	} else {
	    setGrade(getGrade() - 15);
	    setStress(getStress() - 10);
	}
    }

    public void popQuiz(){
	int score = 100 - getStress() + getEnergy() + getKnowledge();
	score /= 3;
	System.out.println("Your teacher springs a pop quiz on you. Based on your knowledge, stress, and energy, you score a " + score + ".");
	setGrade(getGrade() + score / 10);
	setStress(getStress + 5);
	setEnergy(getEnergy - 5);
    }

    public void eatenHomework(){
	System.out.println("Your piranha eats your homework. Not again!");
	setGrade(getGrade() - 5);
    }

    public void subwayDelay(){
	System.out.println("There is a huge subway delay and you end up missing your first class.");
	setGrade(getGrade() - 7);
    }

    public void cheat(int chance){
	if (r.nextInt(100) < chance){
	    setGrade(getGrade() + (100 - getKnow())/2);
	} else {
	    setGrade(0);
	}
    }

}