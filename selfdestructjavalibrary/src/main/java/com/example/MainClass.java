
package com.example;

public class MainClass{
    public static void main(String [] args){
        System.out.println("Week 6: Sef Destruct\n By: Nestor (Felix) Sotres\n9/22/15\n\n");
        System.out.println("This program will simulate the command prompt for running the self destruct sequence in Star Trek.");
        System.out.println("Since we cannot implement voice recognition, it will be all command prompt simulated.\n\n");
        SelfDestruct run = new SelfDestruct();
        run.runSelfDestruct();

    }
}

