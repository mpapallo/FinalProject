class hold {

    public void afterSchool(){
	int chance = getStress() + 100 - getKnow() + 100 - getEnergy();
	chance /= 3;
	String activity = afterSchoolResponse();
	setHomework(false);
	if (r.nextInt(100) < chance) {
	    helpAFriend(helpAFriendResponse());
	} else {
	    if (activity == "study") {
		study(1);
	    } else if (activity == "homework") {
		doHomework();
	    } else if (activity == "facebook"){
		socialize(1);
	    } else if (activity == "text"){
		socialize(1);
	    } else {
		time = 7;
		if (time >= 6) {
		    sleep(24-time);
		} else {
		    sleep(6-time);
		}
	    } 
	}
    }

    public void morning(){
	time = 7;
	chance = getStress() + 100 - getEnergy() + 100 - getKnow();
	chance /= 3;
	if (r.nextInt(100) < chance){
	    int x = r.nextInt(4);
	    switch (x) {
	    case 0: eatenHomework();
		break;
	    case 1: subwayDelay();
		break;
	    case 2: coffeeSpill();
		break;
	    case 3: sickDay(sickDayResponse);
		break;
	    }
	}
    }

    public String afterSchoolResponse(){
	
    }

    public String helpAFriendResponse(){

    }

    public String sickDayResponse(){

    }

}