package DesignPatterns.FacadePattern;

import DesignPatterns.FacadePattern.Menus.Both;
import DesignPatterns.FacadePattern.Menus.NonVegMenu;
import DesignPatterns.FacadePattern.Menus.VegMenu;

public class Client
{
    public static void main (String[] args)
    {
        HotelKeeper keeper = new HotelKeeper();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
        Both both = keeper.getVegNonVegMenu();
        System.out.println(v.toString());
        System.out.println(nv.toString());
        System.out.println(both.toString());

    }
}