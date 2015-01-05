public class Student{
    private String name;
    private int energy, stress, knowledge, social;
    
    public Student(String n, int e, int s, int k, int c){
	setName(n);
	setEnergy(e);
	setStress(s);
	setKnow(k);
	setSocial(c);
    }
    public Student(String n){
	this(n, 80, 50, 30, 50);
    }
    public Student(){
	this("Student", 80, 50, 30, 50);
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
    public int setKnow(int k){
	knowledge = k;
    }
    public void getKnow(){
	return knowledge;
    }
    public int setSocial(int c){
	social = c;
    }
    public void getSocial(){
	return social;
    }

    public void sleep(int hrs){
	this.setEnergy(this.getEnergy() + hrs * 10);
    }

}