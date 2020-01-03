package DesignPatterns.FacadePattern;

import DesignPatterns.FacadePattern.Menus.Both;
import DesignPatterns.FacadePattern.Menus.VegMenu;

public class VegNonBothRestaurant implements Hotel
{
    public Both getMenus()
    {
        Both b = new Both();
        return b;
    }

    @Override
    public String toString() {
        return "VegNonBothRestaurant{}";
    }
}
