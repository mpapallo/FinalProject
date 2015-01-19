public class Freshman extends Student {
    public Freshman(String n){
	super(n, 85, 50, 30);
    }
    public Freshman(){
	super("Freshman", 85, 50, 30);
    }

    public String getLevel(){
	return "Freshman";
    }
    public String sing(){
	return "SophFrosh";
    }

}
