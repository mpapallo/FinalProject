public class Student{
    private String name;
    private int energy, stress, knowledge;
    private int grade;
    
    public Student(String n, int e, int s, int k){
	setName(n);
	setEnergy(e);
	setStress(s);
	setKnow(k);
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

    public void sleep(int hrs){
	this.setEnergy(this.getEnergy() + hrs * 10);
    }
    public void study(int hrs){
	
    }
    public void socialize(int hrs){
	
    }

}