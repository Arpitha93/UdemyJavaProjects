package com.arpitha;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private String weapons;
    private int hitPoints;
    private int strengths;

    public Player(String name, int hitPoints, int strengths) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strengths = strengths;
        this.weapons = "swords";


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapons() {
        return weapons;
    }

    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrengths() {
        return strengths;
    }

    public void setStrengths(int strengths) {
        this.strengths = strengths;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", weapons='" + weapons + '\'' +
                ", hitPoints=" + hitPoints +
                ", strengths=" + strengths +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + strengths);
        values.add(3, this.weapons);

        return values;

    }

    @Override
    public void read(List<String> savedValues) {

        if(this.name != null && savedValues.size() >= 0) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strengths = Integer.parseInt(savedValues.get(2));
            this.weapons = savedValues.get(3);
        }

    }
}