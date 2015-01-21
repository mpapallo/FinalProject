import java.util.*;
public class Responses{
    private static Random r = new Random();    
    public static ArrayList<String> teachers = new ArrayList<String>();

    public static ArrayList<String> classes = new ArrayList<String>();

    public static String oneOfTeachers(){
	int i = r.nextInt(teachers.size());
	return teachers[i];
    }

    public static String oneOfClasses(){
	int i = r.nextInt(classes.size());
	return classes[i];
    }

    public static String homeSick(){
	if (r.nextInt(2) == 0){
	    return "<html>Instead of going to school, you lie in bed and marathon all 6 Hobbit/ Lord of the Rings movies. <br>24 hours well spent.</html>";
	}else{
	    return "<html>Instead of going to school, you sit in bed, surrounded by tissues, and play Mario Kart all day. It's a lot sadder when you're playing against a computer...</html>";
	}
    }

    public static String subwayDelay(){
	if (r.nextInt(2) == 0){
	    return "<html>A dead rat on the subway tracks caused a major delay and you end up missing your first class. <br>Thanks, MTA...</html>";
	}else{
	    return "<html>The subway conductor informs you that due to [insert unintelligible conductor speech here], your train is stranded between stations, causing you to miss your first class. <br>Thanks, MTA...</html>";
	}
    }

    public static String fireDrill(){
	if (r.nextInt(2) == 0){
	    return "<html>FIIRREEEEE! <br>The microwave in the chemistry department office goes up in flames, so you miss an entire period of class time.</html>";
	}else{
	    return "<html>FIIRREEEEE! <br>Someone started a trashcan fire in the bathroom, so you miss an entire period of class time. (I guess that's why the paper towels are never restocked...)</html>";
	}
    }

    public static String brokenEscalator(){
	if (r.nextInt(2) == 0){
	    return "<html>You climb up the escalator. <br>It's a physical struggle that makes you feel like one of those guys who just free-climbed El Capitan, but you bear the pain for the sake of learning.<br> How inspiring.</html>";
	}else{
	    return "<html>You climb up the escalator. <br>These struggles would meake a great college essay. 'My Everest Story: How I reached the top literally and figuratively'. <br>You're a model student!</html>";
	}
    }

    public static String passNotes(){
	if (r.nextInt(2) == 0){
	    return "<html>You passed notes all period. You didn't learn anything useful, but at least you're up to date with the latest season of Keeping Up With the Kardashians.</html>";
	}else{
	    return "<html>You passed notes all period. The teacher's voice droned on like a Charlie Brown adult as you exchanged inside jokes and learned absolutely nothing useful.</html>";
	}
    }

    public static String facebook(){
	if (r.nextInt(2) == 0){
	    return "<html>You surfed Facebook for a while, Facebook-stalking random aquaintances. <br>Dang it! You accidentally liked a post from three years ago! Unlike, unlike, unlike!</html>";
	}else{
	    return "<html>You surfed Facebook until you weren't even aware of the contents of the posts, they just whizzed by as you scrolled mindlessly.</html>";
	}
    }

    public static String sleep(){
	if (r.nextInt(2) == 0){
	    return "<html>You decided to turn in for the night. Good for you!</html>";
	}else{
	    return "<html>You decide it's time to hit the hay. Good for you!</html>";
	}
    }

}
