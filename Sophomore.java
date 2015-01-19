public class Sophomore extends Student {

    public Sophomore(String n){
	super(n, 80, 60, 30);
    }
    public Sophomore(){
	super("Sophomore", 80, 60, 30);
    }

    public String getLevel(){
	return "Sophomore";
    }

    public String sing(){
	return "SophFrosh";
    }

}
