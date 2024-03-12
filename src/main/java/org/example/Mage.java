package org.example;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class Mage implements Comparable<Mage> {
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;

    public static String sortType;


    public Mage(String name, int level, double power) {
        this.name = name;
        this.level = level;
        this.power = power;
        this.apprentices = SetFactory.createSet(sortType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Set<Mage> getApprentices() {
        return apprentices;
    }

    public void setApprentices(Set<Mage> apprentices) {
        this.apprentices = apprentices;
    }

    @Override
    public int compareTo(Mage o) {
        int nameVal = this.name.compareTo(o.name);
        int lvlVal = Integer.compare(this.level, o.level);
        int powVal = Double.compare(this.power, o.power);
        return nameVal != 0 ? nameVal :
                    lvlVal != 0 ? -1*lvlVal :
                            -1*powVal;
    }
    @Override
    public String toString()
    {
        return String.format( "Mage {name='%s', level=%s, power=%s}", name, level, power);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
        {
            return true;
        }
        if(this.getClass() != obj.getClass())
        {
            return false;
        }

        Mage other = (Mage)obj;
        return this.name.equals(other.name) &&
                this.level == other.level &&
                this.power == other.power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, power);
    }
}

class NameCompare implements Comparator<Mage>
{
    @Override
    public int compare(Mage o1, Mage o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class LevelCompare implements Comparator<Mage>
{
    @Override
    public int compare(Mage o1, Mage o2) {
        return Integer.compare(o1.getLevel(), o2.getLevel());
    }
}

class PowerCompate implements Comparator<Mage>
{
    @Override
    public int compare(Mage o1, Mage o2) {
        return Double.compare(o1.getPower(), o2.getPower());
    }
}
