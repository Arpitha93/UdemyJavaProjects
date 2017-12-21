package com.arpitha;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class Monster implements ISaveable {

    private String name;
    private int hitPoints;
    private String strength;

    public Monster(String name, int hitPoints, String strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength);
        return values;

    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() >= 0) {
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = savedValues.get(2);

        }

    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength='" + strength + '\'' +
                '}';
    }
}