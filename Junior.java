public class Junior extends Student {

    public Junior(String n){
	super(n, 75, 70, 30);
    }
    public Junior(){
	super("Junior", 75, 70, 30);
    }

    public String getLevel(){
	return "Junior";
    }

}
