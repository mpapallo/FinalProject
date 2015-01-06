public class Driver {

    public static void main(String[]args){
	Freshman f = new Freshman("Fiona");
	Student j = new Junior("Joey");

	System.out.println(f.getName());
	System.out.println(j.getName());
	System.out.println(f.getEnergy());
	f.sleep();
	System.out.println(f.getEnergy());
    }

}