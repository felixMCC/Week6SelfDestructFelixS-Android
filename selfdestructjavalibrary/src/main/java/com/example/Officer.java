package com.example;

/**
 * Created by nsotres on 9/24/15.
 */
public class Officer {

    String name, rank, position, code = "";

    public Officer(String officerName, String officerRank, String officerPosition, String destructCode){
        name = officerName;
        rank = officerRank;
        position = officerPosition;
        code = destructCode;
    }

    //getter methods
    public String getName(){
        return name;
    }

    public String getRank(){
        return rank;
    }

    public String getPosition(){
        return position;
    }

    public String getCode(){
        return code;
    }
}
