package DesignPatterns.AdapterPattern;

import DesignPatterns.PioltPen;

import java.util.Arrays;

public class School {
    public static void main(String args[]){
        Pen p = new PenAdapter();
        AssigmentWork aw = new AssigmentWork();
        aw.setPen(p);
        aw.writeAssignment("I am bit tired for write the assignment ");
    }
}
