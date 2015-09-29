package com.example;
import java.util.*;

/**
 * Created by nsotres on 9/22/15.
 */
public class SelfDestruct {

    Scanner input = new Scanner(System.in);     //allows for intpu
    String command = "";                        //global command string
    HashMap<String, Officer> officers = new HashMap<String, Officer>(); //'Dictionary' of officers
    //vars used to verify individual offers info is all correct
    boolean isKirk = false;
    boolean isSpock = false;
    boolean isScott = false;

    //There's something ominous about setting a self destruct method to 'public' ;P
    public void runSelfDestruct(){

        initializeElements();           //initialize officers info

        do{
            printToUser("Please enter command to run:\n");
            command = receiveInputFromUser();

            //test for self destruct command
            if(command.equalsIgnoreCase("Run Self Destruct Sequence")){
                printToUser("Initializing SELF DESTRUCT SEQUENCE:\n\n");
                delay(3);
                for(int cnt = 0; cnt < 3; cnt++) {
                    if(selfDestructSequence() != true){
                        printToUser("Information was not verified. Exiting self destruct sequence...");
                        delay(2);
                        break;
                    }
                }
                //if all 3 sequences confirmed, self destruct
                if(isKirk == true && isSpock == true && isScott == true){
                    printToUser("All sequences confirmed...");
                    delay(2);
                    for(int countdown = 3; countdown < 1; countdown--){
                        printToUser("*** SELF DESTRUCT IN : " + countdown);
                        delay(2);
                    }
                    printToUser("Boom. Youre all dead.");
                    delay(2);
                    System.exit(0);
                }

            }else{
                printToUser("My apologies officer, that command is currently out of my scope of capabilities.\n");
            }


            printToUser("Command ended.\n\nWould you like to run another command? ( Y / N)\n");
        }while(promptForYesOrNo());
        printToUser("Thank you Officer, Enjoy your day.\n");
        System.exit(0);

    }

    //prints received string to user
    private void printToUser(String string){
        System.out.println(string);
    }

    //receives input from user
    private String receiveInputFromUser(){
        String temp = input.nextLine();
        //String temp2 = input.next();   //clear end of buffer
        //printToUser("echo: " + temp);//echo input
        return temp;
    }

    //asks for simple yes or no and returns true/false respectively
    private boolean promptForYesOrNo(){
        String answer = input.next();

        if(answer.equalsIgnoreCase("Y")){
            return true;
        }else{
            return false;
        }
    }

    private boolean selfDestructSequence(){
        String destructCode = "";
        printToUser("Please enter Officer's Name:\n");
        String name = receiveInputFromUser();
        printToUser("Please enter Officer's Rank:\n");
        String rank = receiveInputFromUser();

        //In the original Star Trek video, the computer makes processing noises at this point
        printToUser("Processing...");
        delay(2);

        //test to see if officer exists
        if(officers.containsKey(name)){
            //ensure name matches
            //printToUser("Name from HashMap: " + officers.get(name).getName());
            //printToUser("Rank from HashMap: " + officers.get(name).getRank());
            if(officers.get(name).getName().equalsIgnoreCase(name) && officers.get(name).getRank().equalsIgnoreCase(rank)){
                delay(2);
                printToUser("Rank and Name confirmed;");
                delay(1);
                printToUser("\nPlease enter commander's title:\n");
                String position = receiveInputFromUser();


                if(officers.get(name).getPosition().equalsIgnoreCase(position)){
                    printToUser("\nProcessing...");
                    delay(2);
                    printToUser("\nPosition Confirmed.");
                    delay(2);
                    printToUser("Enter Destruct Code:");
                    destructCode = receiveInputFromUser();
                    if(officers.get(name).getCode().equalsIgnoreCase(destructCode)){

                        printToUser("\nRank, Name, title, and code Confirmed. Sequence completed");
                        //if all info is confirmed, set the officers status as true/confirmed
                        if(officers.get(name).getName().equalsIgnoreCase("James Kirk")){
                            isKirk = true;
                        }else if(officers.get(name).getName().equalsIgnoreCase("Spock")){
                            isSpock = true;
                        }else if(officers.get(name).getName().equalsIgnoreCase("Scott")) {
                            isScott = true;
                        }
                        return true;
                    }else{
                        return false;
                    }

                }else{

                    printToUser("\nProcessing...");
                    delay(2);
                    printToUser("Information Incorrect...");
                    return false;
                }
            }else{
                printToUser("\nProcessing...");
                delay(2);
                printToUser("Information Incorrect...");
                return false;
            }



        }else{
            printToUser("\nProcessing...");
            delay(2);
            printToUser("Information Incorrect...");
            return false;
        }


    }

    //initialize program variables needed
    private void initializeElements(){
        Officer Kirk = new Officer ( "James Kirk", "Captain", "Captain of the USS Enterprise", "11A");
        Officer Spock = new Officer( "Spock", "Commander", "Science Officer", "11A2B");
        Officer Scott = new Officer( "Scott", "Lieutenant Commander", "Chief Engineering Officer", "1B2B3");
        officers.put("James Kirk", Kirk);
        officers.put("Spock", Spock);
        officers.put("Scott", Scott);
    }

    //simple delay, takes as input the number of seconds to delay
    private void delay(int secs){

        secs *= 1000;       //1000 milliseconds is one second.
        try {
            Thread.sleep(secs);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
