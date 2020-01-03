package DesignPatterns.FacadePattern;

import DesignPatterns.FacadePattern.Menus.Menus;
import DesignPatterns.FacadePattern.Menus.NonVegMenu;

public class NonVegRestaurant implements Hotel
{
    public Menus getMenus()
    {
        NonVegMenu nv = new NonVegMenu();
        return nv;
    }

    @Override
    public String toString() {
        return "NonVegRestaurant{}";
    }
}
