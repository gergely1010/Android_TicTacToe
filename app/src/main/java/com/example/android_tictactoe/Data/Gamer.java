package com.example.android_tictactoe.Data;

public class Gamer {
    String userName;
    String gameName;
    int gameWPoints;
    int gameLPoint;

    public Gamer(String userName, String gameName) {
        this.userName = userName;
        this.gameName = gameName;
        gameWPoints = 0;
        gameLPoint = 0;
    }
    public Gamer(String userName, String gameName, int gameWPoints, int gameLPoint) {
        this.userName = userName;
        this.gameName = gameName;
        this.gameWPoints = gameWPoints;
        this.gameLPoint = gameLPoint;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameWPoints() {
        return gameWPoints;
    }

    public void setGameWPoints(int gameWPoints) {
        this.gameWPoints = gameWPoints;
    }

    public int getGameLPoint() {
        return gameLPoint;
    }

    public void setGameLPoint(int gameLPoint) {
        this.gameLPoint = gameLPoint;
    }
}
