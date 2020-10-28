import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.BorderFactory.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class feud extends JPanel implements ActionListener {
    // instance variables 
    JTextField text;
    JButton a[] = new JButton [10];
    int pointsone = 0;
    int triesone = 5;
    int pointstwo = 0;
    int triestwo = 5;
    int turn = 1;
    JLabel lives;
    JLabel scorenum;
    JLabel scorenumtwo;
    // arrays and their answers
    String culture[] = {"facebook is","poems about","cars are too","how many strings on a","buy stock in"};
    String cultureans[] [] = {{"dying" ,"down","dead","for old people", "not working", "Listening", "slow","bad","toxic", "a private company"},{"love","life","death","mothers","friendship","nature","depression","spring","moms","family"},{"expensive","expensive reddit","big","dangerous","expensive in australia","complicated","mainstream","expensive now","fast","powerful"},{"guitar" ,"harp", "violin" ,"banjo" ,"cello" , "ukulele", "mandolin" ,"sitar", "bass guitar", "piano" },{ "beyond meat", "amazon", "disney", "impossible foods", "apple",  "netflix", "impossible burger", "uber", "lyft", "nike"  }};

    String people[] = {"i am extremely","i need help with","when is the next","i don't like to","i was bitten"};
    String peopleans[] [] = {{"depressed","tired","cute","bored","lonely","grateful","sorry","lazy","humbled","tired all the time"},{"my rent","money","math","my homework","my taxes","depression","my resume","housing","life","my depression"},{"full moon","leap year","world cup","solar eclipse","olympics","powerball drawing","presidential election","holiday","election","new moon"},{"dream about getting paid","feel good","sleep alone","be touched","read","talk","work","travel","read in spanish","eat" },{ "by a cat","by a dog","by a tick","by a radioactive spider","by a stray cat","by a human","by a turtle","by a rattlesnake","tv show","show"  }};

    String names[] = {"donna","keith","gregory","vincent","larry"};
    String namesans[] [] = {{"summer" ,"heinel","brazile","rice", "missal", "douglas", "reed","karan","d'errico", "ludwig"},{"urban","richards","haring","flint","sweat","thurman","raniere","david","whitely","morrison"},{"peck","hines","hill jr","alan isakov","abbott","crewdson","polanco","smith","harrison","colburn"},{"kompany" ,"van gogh", "price" ,"kompany goal" ,"cassel" , "gallo", "kompany wife" ,"kartheiser", "thomas bridge", "van gogh paintings" },{ "bird", "david", "nassar", "king", "einhorn",  "h parker", "ellison", "elder", "charles", "birkhead"  }};

    String questions[] = {"how to trap a","does the moon have","can you milk a","how to draw a","who was the first"};
    String questionsans[] [] = {{"leprechaun", "mouse" , "rat", "squirrel", "cat", "skunk", "raccoon" ,"fox", "possum", "lizard"},{"an atmosphere", "gravity", "day and night", "a core", "water", "a magnetic field", "a name", "wind", "a molten core", "a moon"},{"giraffe", "cat" ,"chicken", "horse", "male cow", "pig", "snake", "sheep", "whale", "camel"},{"rose", "dog", "unicorn", "nose", "face", "cat", "dragon", "person", "horse", "flower" },{ "president", "man on the moon", "avenger", "pope", "man in space", "american in space", "person to walk on the moon", "republican president", "bachelorette", "woman in space"  }};
    JLabel que;

    JButton search;
    int num;
    int choice;
    JLabel query;
    CardLayout myCardLayout = new CardLayout ();
    public static void main (String[] args){//creating JFrame
        feud content = new feud();

        JFrame window = new JFrame("Google Feud");
        window.setContentPane( content);
        window.setSize(720,840);
        window.setBackground(Color.white);
        window.setLocation( 100, 100);
        window.setVisible(true);

    }//end main

    public feud()//constructor
    {    

        setLayout(myCardLayout);
        intro();
        screen2();
        mainpan();
    }

    public void intro(){//intro screen
        JPanel intro = new JPanel();
        intro.setLayout(null);
        intro.setBackground(Color.white);

        JLabel title = new JLabel (createImageIcon ("google.png"));//Title image
        title.setBackground(Color.white);

        title.setBounds(200,30,330,200);

        //Instruction Labels
        JLabel ins = new JLabel ("- You will be given a choice between 4 categories(People,Culture,Names,Questions)");
        ins.setFont(new Font("Comic Sans",Font.BOLD,15));
        ins.setBounds(50,350,600,30);

        JLabel insa = new JLabel ("- Based on your choice of category, you will be given a query");
        insa.setFont(new Font("Comic Sans",Font.BOLD,15));
        insa.setBounds(50,390,600,30);

        JLabel insb = new JLabel ("- Your goal is to complete the query depending on what you think is the most searched");
        insb.setFont(new Font("Comic Sans",Font.BOLD,15));
        insb.setBounds(50,430,700,30);

        JLabel insc = new JLabel ("- Points will be awarded according to the popularity of your proposed search");
        insc.setFont(new Font("Comic Sans",Font.BOLD,15));
        insc.setBounds(50,470,700,30);

        JLabel insd = new JLabel ("- Player with higher score wins!");
        insd.setFont(new Font("Comic Sans",Font.BOLD,15));
        insd.setBounds(50,510,700,30);
        //Button to play
        JButton play =  new JButton("PLAY");
        play.addActionListener(this);
        play.setActionCommand ("2");
        play.setBounds(310,570,100,80);

        intro.add(title);
        intro.add(ins);
        intro.add(insa);
        intro.add(insb);
        intro.add(insc);
        intro.add(insd);
        intro.add(play);

        add("1",intro);

    }

    public void screen2() {//selection screen
        JPanel mainpan = new JPanel();
        mainpan.setLayout(null);
        mainpan.setBackground(Color.white);

        Color b = new Color(51,153,255);
        JLabel title = new JLabel (createImageIcon ("google.png"));

        title.setBackground(Color.white);
        title.setBounds(200,30,330,200);
        //setting JLabel for query
        query = new JLabel ("");
        query.setFont(new Font("Comic Sans",Font.BOLD,15));
        query.setBounds(160,350,100,30);
        text = new RoundedJTextField (40);
        text.setText("PLAYER 1 BEGINS, CLICK THE IMAGE ON NEXT PANEL TO SWITCH PLAYERS.");
        text.setBounds(150,350,400,30);
        text.setFont(new Font("Comic Sans",Font.PLAIN,10));
        //Score and Guesses counters
        JLabel score = new JLabel("PLAYER1");
        score.setFont(new Font("Comic Sans",Font.BOLD,25));
        score.setForeground(b);
        score.setBounds(100,675,500,50);
        scorenum = new JLabel(""+ pointsone);
        scorenum.setFont(new Font("Comic Sans",Font.BOLD,40));
        scorenum.setForeground(b);
        scorenum.setBounds(100,730,500,50);

        JLabel scoretwo = new JLabel("PLAYER2");
        scoretwo.setFont(new Font("Comic Sans",Font.BOLD,25));
        scoretwo.setForeground(b);
        scoretwo.setBounds(300,675,500,50);
        scorenumtwo = new JLabel(""+pointstwo);
        scorenumtwo.setFont(new Font("Comic Sans",Font.BOLD,40));
        scorenumtwo.setForeground(b);
        scorenumtwo.setBounds(300,730,500,50);

        JLabel guess = new JLabel("GUESSES");
        guess.setFont(new Font("Comic Sans",Font.BOLD,25));
        guess.setForeground(b);
        guess.setBounds(500,675,500,50);
        lives = new JLabel(""+ triesone);
        lives.setFont(new Font("Comic Sans",Font.BOLD,40));
        lives.setForeground(b);
        lives.setBounds(555,730,500,50);
        //Category Buttons
        JButton people =  new JButton("People");
        people.addActionListener(this);
        people.setActionCommand ("4");
        people.setBounds(70,275,100,30);

        JButton culture =  new JButton("Culture");
        culture.addActionListener(this);
        culture.setActionCommand ("5");
        culture.setBounds(240,275,100,30);

        JButton names =  new JButton("Names");
        names.addActionListener(this);
        names.setActionCommand ("6");
        names.setBounds(410,275,100,30);

        JButton questions =  new JButton("Questions");
        questions.addActionListener(this);
        questions.setActionCommand ("7");
        questions.setBounds(580,275,100,30);
        //Search Button
        search = new JButton (createImageIcon ("search.png"));
        search.addActionListener(this);
        search.setActionCommand ("0");
        search.setMnemonic(KeyEvent.VK_ENTER);
        search.setBounds(551,350,30,30);
        search.setBackground(Color.white);
        search.setBorder(BorderFactory.createEmptyBorder());
        //Creating grid to display answers
        Panel g = new Panel (new GridLayout (5, 2));
        g.setBounds(110,400,500,200);
        for (int i = 0 ; i<a.length ; i++) {
            a [i] = new JButton ("" +(i+1));
            a [i].setPreferredSize(new Dimension(80, 60));
            a [i].setFont(new Font("Comic Sans",Font.BOLD,40));
            a [i].setBackground(Color.white);
            a [i].setForeground(Color.lightGray);

            g.add (a [i]);

        }

        mainpan.add (query);
        mainpan.add (search);
        mainpan.add (text);

        mainpan.add (title);
        mainpan.add (search);
        mainpan.add (g);

        mainpan.add (score);
        mainpan.add (scoretwo);
        mainpan.add (guess);
        mainpan.add (scorenum);
        mainpan.add (scorenumtwo);
        mainpan.add (lives);
        mainpan.add (people);
        mainpan.add (names);
        mainpan.add (questions);
        mainpan.add (culture);

        add("2",mainpan);

    }

    public void mainpan() {//play screen
        JPanel mainpan = new JPanel();
        mainpan.setLayout(null);
        mainpan.setBackground(Color.white);

        Color b = new Color(51,153,255);
        JButton title = new JButton (createImageIcon ("google.png"));// switch players button
        title.addActionListener(this);
        title.setActionCommand ("9");
        title.setBackground(Color.white);
        title.setBounds(200,30,330,200);
        title.setBorder(BorderFactory.createEmptyBorder());//Eliminating Border to blend button with background
        query = new JLabel ("David");//placeholder 
        query.setFont(new Font("Comic Sans",Font.BOLD,15));
        query.setBounds(160,350,300,30);
        text = new RoundedJTextField (40);
        text.setText("          ");

        text.setBounds(150,350,400,30);
        text.setFont(new Font("Comic Sans",Font.PLAIN,15));

        que = new JLabel("HOW WOULD GOOGLE AUTOCOMPLETE THIS QUERY?");
        que.setFont(new Font("Comic Sans",Font.BOLD,15));
        que.setBounds(160,250,500,50);
        JLabel score = new JLabel("PLAYER1");
        score.setFont(new Font("Comic Sans",Font.BOLD,25));
        score.setForeground(b);
        score.setBounds(100,675,500,50);
        scorenum = new JLabel(""+ pointsone);
        scorenum.setFont(new Font("Comic Sans",Font.BOLD,40));
        scorenum.setForeground(b);
        scorenum.setBounds(100,730,500,50);
        scorenum.setText("" + pointsone);

        JLabel scoretwo = new JLabel("PLAYER2");
        scoretwo.setFont(new Font("Comic Sans",Font.BOLD,25));
        scoretwo.setForeground(b);
        scoretwo.setBounds(300,675,500,50);
        scorenumtwo = new JLabel(""+ pointsone);
        scorenumtwo.setFont(new Font("Comic Sans",Font.BOLD,40));
        scorenumtwo.setForeground(b);
        scorenumtwo.setBounds(300,730,500,50);

        JLabel guess = new JLabel("GUESSES");
        guess.setFont(new Font("Comic Sans",Font.BOLD,25));
        guess.setForeground(b);
        guess.setBounds(500,675,500,50);
        lives = new JLabel(""+ triesone);
        lives.setFont(new Font("Comic Sans",Font.BOLD,40));
        lives.setForeground(b);
        lives.setBounds(555,730,500,50);
        search = new JButton (createImageIcon ("search.png"));
        search.addActionListener(this);
        search.setActionCommand ("0");
        search.setMnemonic(KeyEvent.VK_ENTER);//allowing player to trigger button via ALT+ENTER
        search.setBounds(551,350,30,30);
        search.setBackground(Color.white);
        search.setBorder(BorderFactory.createEmptyBorder());//eliminating border to blend button with background

        Panel g = new Panel (new GridLayout (5, 2));
        g.setBounds(110,400,500,200);
        for (int i = 0 ; i<a.length ; i++) {
            a [i] = new JButton ("" +(i+1));
            a [i].setPreferredSize(new Dimension(80, 60));
            a [i].setFont(new Font("Comic Sans",Font.BOLD,30));
            a [i].setBackground(Color.white);
            a [i].setForeground(Color.lightGray);

            g.add (a [i]);

        }

        mainpan.add (query);
        mainpan.add (search);
        mainpan.add (text);

        mainpan.add (title);
        mainpan.add (search);
        mainpan.add (g);
        mainpan.add (que);
        mainpan.add (score);
        mainpan.add (scoretwo);
        mainpan.add (guess);
        mainpan.add (scorenum);
        mainpan.add (scorenumtwo);
        mainpan.add (lives);

        add("3",mainpan);

    }

    public void actionPerformed (ActionEvent e){
        int i = Integer.parseInt (e.getActionCommand ());
        String q = query.getText();
        MakeSound letErRipy = new MakeSound();//declaring sound variable
        String y = text.getText();//extracting user input in textfield

        if (e.getActionCommand().equals ("1")) {
            myCardLayout.show (this, "1");//shoing panel
        }
        else if (e.getActionCommand().equals ("2")) {
            myCardLayout.show (this, "2");
            MakeSound letErRipe = new MakeSound();
            letErRipe.playSound("jackie-yea.wav");//when user hits play, play yay sound

        }
        else if (e.getActionCommand().
        equals ("3")) {
            myCardLayout.show (this, "3");
        }
        else if (e.getActionCommand().equals ("4")) {
            myCardLayout.show (this, "3");
            num = (int)((Math.random()*5));//random number to choose a query from chosen category
            query.setText(people[num]);//setting the query to randomly chosen query
            choice = 1;//setting variable value to keep track of chosen category
            search.setEnabled(true);//renabling searh button if disabled by previously.
            que.setText("HOW WOULD GOOGLE AUTOCOMPLETE THIS QUERY?");
            que.setFont(new Font("Comic Sans",Font.BOLD,15));
            que.setBounds(160,250,500,50);
        }
        else if (e.getActionCommand().equals ("5")) {
            myCardLayout.show (this, "3");
            num = (int)((Math.random()*5));
            query.setText(culture[num]);
            choice = 2;
            search.setEnabled(true);
            que.setText("HOW WOULD GOOGLE AUTOCOMPLETE THIS QUERY?");
            que.setFont(new Font("Comic Sans",Font.BOLD,15));
            que.setBounds(160,250,500,50);
        }
        else if (e.getActionCommand().equals ("6")) {
            myCardLayout.show (this, "3");
            num = (int)((Math.random()*5));
            query.setText(names[num]);
            choice = 3;
            search.setEnabled(true);
            que.setText("HOW WOULD GOOGLE AUTOCOMPLETE THIS QUERY?");
            que.setFont(new Font("Comic Sans",Font.BOLD,15));
            que.setBounds(160,250,500,50);
        }
        else if (e.getActionCommand().equals ("7")) {
            myCardLayout.show (this, "3");
            num = (int)((Math.random()*5));
            query.setText(questions[num]);
            choice = 4;
            search.setEnabled(true);
            que.setText("HOW WOULD GOOGLE AUTOCOMPLETE THIS QUERY?");
            que.setFont(new Font("Comic Sans",Font.BOLD,15));
            que.setBounds(160,250,500,50);
        }
        else if(e.getActionCommand().equals ("9")) {
            myCardLayout.show (this, "2");
            //switching turns
            if (turn ==1) {
                turn = 2;
            }
            else {
                turn = 1;
            }

        }
        //for player one
        if (turn ==1){
            if( i==0) {
                triesone --;//subtracting one guess initialy
                lives.setText(""+triesone);//updating guesses counter
                //determing category chosen, and then going through loop to see if user input matches top 10 answer
                if (choice ==1){
                    for(int k=0; k<10; k++){//going through array

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(peopleans[num][k].replaceAll("\\s+",""))){//ignoring case and spaces 

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + peopleans[num][k] + "   " + ((10-k)*1000));//displaying answer in appropriate position
                            a [k].setForeground(Color.black);

                            pointsone +=((10-k)*1000);
                            triesone ++;//returning taken away guess as answer was right

                            letErRipy.playSound("chaching.wav");//play money sound to symbolize right answer

                        }

                    }
                }
                else if (choice == 2){
                    for(int k=0; k<10; k++){

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(cultureans[num][k].replaceAll("\\s+",""))) {

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + cultureans[num][k] + "   " + ((10-k)*1000));
                            a [k].setForeground(Color.black);

                            pointsone +=((10-k)*1000);
                            triesone ++;
                            letErRipy.playSound("chaching.wav");

                        }

                    }
                }
                else if (choice == 3){
                    for(int k=0; k<10; k++){

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(namesans[num][k].replaceAll("\\s+",""))) {

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + namesans[num][k] + "   " + ((10-k)*1000));
                            a [k].setForeground(Color.black);

                            pointsone +=((10-k)*1000);
                            triesone ++;
                            letErRipy.playSound("chaching.wav");
                        }

                    }
                }
                else if (choice ==4) {
                    for(int k=0; k<10; k++){

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(questionsans[num][k].replaceAll("\\s+",""))) {

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + questionsans[num][k] + "   " + ((10-k)*1000));
                            a [k].setForeground(Color.black);

                            pointsone +=((10-k)*1000);
                            triesone ++;
                            letErRipy.playSound("chaching.wav");
                        }

                    }
                }

            }
            //no more guesses condition
            if(triesone <=0) {
                search.setEnabled(false);//disabling search button to prevent player from continuing
                //displaying all right answers for player to see
                if (choice ==1){
                    for (int j = 0 ; j<a.length ; j++){//going through array 
                        a [j].setText(q + " "+peopleans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }
                else if (choice ==2){
                    for (int j = 0 ; j<a.length ; j++) {
                        a [j].setText(q + " "+cultureans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }
                else if (choice == 3){
                    for (int j = 0 ; j<a.length ; j++) {
                        a [j].setText(q + " "+namesans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }
                else{
                    for (int j = 0 ; j<a.length ; j++) {
                        a [j].setText(q + " "+questionsans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }
            }

            que.setText("OTHER PLAYER'S TURN");//signaling player to switch
            que.setBounds(300,250,500,50);
        }

        //same as above but for player two
        if (turn ==2){
            if( i==0) {

                triestwo --;
                lives.setText(""+triestwo);
                if (choice ==1){
                    for(int k=0; k<10; k++){

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(peopleans[num][k].replaceAll("\\s+",""))) {

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + peopleans[num][k] + "   " + ((10-k)*1000));
                            a [k].setForeground(Color.black);

                            pointstwo +=((10-k)*1000);
                            triestwo ++;
                            letErRipy.playSound("chaching.wav");
                        }

                    }
                }
                else if (choice == 2){
                    for(int k=0; k<10; k++){

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(cultureans[num][k].replaceAll("\\s+",""))) {

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + cultureans[num][k] + "   " + ((10-k)*1000));
                            a [k].setForeground(Color.black);

                            pointstwo +=((10-k)*1000);
                            triestwo ++;
                            letErRipy.playSound("chaching.wav");
                        }

                    }
                }
                else if (choice == 3){
                    for(int k=0; k<10; k++){

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(namesans[num][k].replaceAll("\\s+",""))) {

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + namesans[num][k] + "   " + ((10-k)*1000));
                            a [k].setForeground(Color.black);

                            pointstwo +=((10-k)*1000);
                            triestwo ++;
                            letErRipy.playSound("chaching.wav");
                        }

                    }
                }
                else if (choice ==4) {
                    for(int k=0; k<10; k++){

                        if(y.replaceAll("\\s+","").equalsIgnoreCase(questionsans[num][k].replaceAll("\\s+",""))) {

                            a [k].setForeground(Color.black);
                            a [k].setFont(new Font("Comic Sans",Font.PLAIN,15));
                            a [k].setText( q+ " " + questionsans[num][k] + "   " + ((10-k)*1000));
                            a [k].setForeground(Color.black);

                            pointstwo +=((10-k)*1000);
                            triestwo ++;
                            letErRipy.playSound("chaching.wav");
                        }

                    }
                }

            }

            if(triestwo <=0) {
                search.setEnabled(false);
                if (choice ==1){
                    for (int j = 0 ; j<a.length ; j++) {
                        a [j].setText(q + " "+peopleans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }
                else if (choice ==2){
                    for (int j = 0 ; j<a.length ; j++) {
                        a [j].setText(q + " "+cultureans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }
                else if (choice == 3){
                    for (int j = 0 ; j<a.length ; j++) {
                        a [j].setText(q + " "+namesans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }
                else{
                    for (int j = 0 ; j<a.length ; j++) {
                        a [j].setText(q + " "+questionsans[num][j]+ "   "+((10-j)*1000));
                        a [j].setPreferredSize(new Dimension(80, 60));
                        a [j].setFont(new Font("Comic Sans",Font.PLAIN,15));
                        a [j].setBackground(Color.white);
                        a [j].setForeground(Color.black);

                    }
                }

                que.setText("OTHER PLAYER'S TURN");
                que.setBounds(300,250,500,50);

            }
        }

        // resetting text in grid for next player
        if (i == 4|| i ==5|| i ==6|| i ==7) {
            for (int m = 0 ; m<a.length ; m++) {
                a [m].setText(""+(m+1) );
                a [m].setFont(new Font("Comic Sans",Font.BOLD,30));
                a [m].setBackground(Color.white);
                a [m].setForeground(Color.lightGray);

            }
        }
        //game decison 
        if (triesone == 0 && triestwo ==0) {//i f both players are out of guesses
            if (pointsone>pointstwo) {
                JOptionPane.showMessageDialog( null,"Player 1 Wins!");// showing popup message declaring winner
            }
            else if (pointsone<pointstwo) {
                JOptionPane.showMessageDialog( null,"Player 2 Wins!");
            }
            else{
                JOptionPane.showMessageDialog( null,"Its a Tie!");
            }
            MakeSound letErRip = new MakeSound();
            letErRip.playSound("StaplesThatWasEasy.wav");// playing celebration sound 

            System.exit(0);//exiting program
        }

        //tracking guess counter according to player
        if (turn ==1) {
            lives.setText(""+triesone);
        }
        else {
            lives.setText("" + triestwo);
        }
        // updating counters
        text.setText("");
        scorenum.setText(""+pointsone);
        scorenumtwo.setText(""+pointstwo);

    }

    protected static ImageIcon createImageIcon (String path){//image adding method
        java.net.URL imgURL = feud.class.getResource( path);
        if (imgURL != null){
            return new ImageIcon (imgURL);
        } else {
            System.err.println( "Couldn't find file: " + path);
            return null;
        }
    }

    public int points(int l){//methof for updating points for counters
        int x = 0;
        if (l  == 1){
            x = pointsone;
        }
        else {
            x = pointstwo;
        }
        return x;
    }

    class RoundedJTextField extends JTextField {//rounded textfield code
        private Shape shape;
        public RoundedJTextField(int size) {
            super(size);
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }

        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
            }
            return shape.contains(x, y);
        }
    }

}

