public class Senior extends Student {

    public Senior(String n){
	super(n, 70, 75, 30);
    }
    public Senior(){
	super("Senior", 70, 75, 30);
    }

    public String getLevel(){
	return "Senior";
    }

}
