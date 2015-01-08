import java.util.*;
public class Driver{

    public static void main(String[]args){
	Student player;
	GUI G;
	
	String name = playerChooseName();
	player = playerChooseDifficulty(name);

	G = new GUI();
	G.initialize(player);
	G.setVisible(true);
    }

    public static String playerChooseName(){
	Scanner in = new Scanner(System.in);
	System.out.println("Welcome to the Stuyvesant Finals Week Simulator. What is your name?");
	String name = in.nextLine();
	return name;
    }

    public static Student playerChooseDifficulty(String name){
	Student player;
	Scanner in = new Scanner(System.in);
	System.out.println("\nNice to meet you, " + name + "! Now, what grade are you in?");
	boolean done;
	do{
	    done = true;
	    System.out.println("\nA - Freshman (Easy Street)\nB - Sophomore\nC - Junior\nD - Senior (Hell Week)");
	    String input = in.nextLine();
	    if (input.toLowerCase().equals("a")){
		player = new Freshman();;
	    }else if (input.toLowerCase().equals("b")){
		player = new Sophomore();
	    }else if (input.toLowerCase().equals("c")){
		player = new Junior();
	    }else if (input.toLowerCase().equals("d")){
		player = new Senior();
	    }else{
		player = new Freshman();
		done = false;
	    }
	}while(!done);
	player.setName(name);
	return player;
    }
}
