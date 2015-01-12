abstract class Student{
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

    public String toString(){
	return this.getName();
    }
    abstract String getLevel();

    public void sleep(int hrs){
	this.setEnergy(this.getEnergy() + hrs * 10);
    }

    public void study(int hrs){
	setKnow(getKnow() + hrs*5);
	setStress(getStress() + hrs*3);
	setEnergy(getEnergy() - hrs*5);
    }

    public void socialize(int hrs){
	setStress(getStress() - hrs*5);
	setEnergy(getEnergy() - hrs*4);
    }

    // check if attributes are between 0 and 100
    public void check(){
	if (getKnow() > 100){
	    setKnow(100);
	} else if (getKnow() < 0) {
	    setKnow(0);
	}
	if (getStress() > 100){
	    setStress(100);
	} else if (getStress() < 0) {
	    setStress(0);
	}
	if (getEnergy() > 100){
	    setEnergy(100);
	} else if (getEnergy() < 0) {
	    setEnergy(0);
	}
    }
}
