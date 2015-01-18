FinalProject
============

<h2>
Michaela Papallo &amp; Emily Redler, period 6 APCS
</h2>

<h3>
Project Description
</h3>
Our project is a finals week simulator. Choose your age (difficulty level), freshman-senior. After that you will be taken through a week (Monday-Friday) in the life of a Stuyvesant student during finals week. You can choose whether you want to study or sleep, cut class or pass notes, and more. Random events will occur to undermine (or help) you--some may ask you to make more decisions. Energy, knowledge, and stress will be affected by your decisions and are taken into account for your test grade and final grade. At the end of the week, you take your finals. During the test, you can choose to cheat (with a chance of being caught), sleep, take the test normally, or skip it all together. At the end of the week, you will be given a final grade based on your choices. 

<h3>
Daily Logs
</h3>

<h4>
12/22/14
</h4>
* possible ideas:
    * solar system creator
    * finals week simulator

<h4>
1/5/15
</h4>
* start work on finals week simulator
* features discussed:
    * multiple slots in the day for choices (mon-fri) --> ex: during study hall, choose to sleep/talk/study
    * make abstract student class then instances for each grade level
    * beginning stress level increases as grade level increases
    * efficiency of study increases?
    * difficulty of finals/classes increases
    * can choose to cheat on finals with chance of getting caught based on sleep, preparedness, etc
created Student class and subclasses


<h4>
1/6/15
</h4>
* github problems with forked repository
* work on parent and subclasses


<h4>
1/7/15
</h4>
* mapping out our plan on paper
* started GUI creation and Driver, initializing player


<h4>
1/8/15
</h4>
* added random events 
* work on GUI display


<h4>
1/9/15
</h4>
* fixed formatting in readme
* added more methods in events
* moved initialization of character from terminal to GUI


<h4>
1/10/15
</h4>
* finished GUI setup
* initialization of character process is complete
* made Student abstract

<h4>
1/12/15
</h4>
* got rid of Events class, added to Students
* incorporating the story into the gui

<h4>
1/13/15
</h4>
* progress with incorporating events into the gui function that asks for user input

<h4>
1/14/15
</h4>
* added morning and after school
* continued user response methods

<h4>
1/15/15
</h4>
* inSchool function working

<h4>
1/16/15
</h4>
* finished morning
* btw the popQuiz function calculates the score weirdly- never above 50- fix that

<h4>
1/17/15
</h4>
* added fonts, prettified GUI
* added energy, knowledge, stress bars
* made time am and pm

<h4>
1/18/19
</h4>
* finished after school
* made three class periods instead of two and fixed going from one period to another (was infinitely going to "last class of the day")


<h3>
To do list
</h3>
<h4>
Most important
</h4>
* finish after school function
* make each activity (commute, one class, after school) increment activity by 1, when u click continue it goes to the next activity in the array (obviosuly last thing will also increment dayi by 1 so that it becomes a new day next morning when u call udpateday(days[dayi]))
* friday aka finals day function (will be called when activity = 0 on dayi = 3)
<h4>
Cooler stuff
</h4>
* array with teacher names, can choose a random one to incorporate
* array with classes, can choose a random one to incorporate
* can have different text for same events, randomly chosen
* add more text specific to difficulty level (ex. seniors, something about college recs) --> make the different leves mor different in general

