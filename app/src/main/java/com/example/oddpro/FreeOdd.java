package com.example.oddpro;

public class FreeOdd {
    String freeHome, freeAway, freeLeague, freeStake, freeDate;

    public FreeOdd(){
        //empty constructor for firestore
    }

    //constructor

    public FreeOdd(String freeHome, String freeAway, String freeLeague, String freeStake, String freeDate) {
        this.freeHome = freeHome;
        this.freeAway = freeAway;
        this.freeLeague = freeLeague;
        this.freeStake = freeStake;
        this.freeDate = freeDate;
    }

    //getter and setter

    public String getFreeHome() {
        return freeHome;
    }

    public void setFreeHome(String freeHome) {
        this.freeHome = freeHome;
    }

    public String getFreeAway() {
        return freeAway;
    }

    public void setFreeAway(String freeAway) {
        this.freeAway = freeAway;
    }

    public String getFreeLeague() {
        return freeLeague;
    }

    public void setFreeLeague(String freeLeague) {
        this.freeLeague = freeLeague;
    }

    public String getFreeStake() {
        return freeStake;
    }

    public void setFreeStake(String freeStake) {
        this.freeStake = freeStake;
    }

    public String getFreeDate() {
        return freeDate;
    }

    public void setFreeDate(String freeDate) {
        this.freeDate = freeDate;
    }
}
