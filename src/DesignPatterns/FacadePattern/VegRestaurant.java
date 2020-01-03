package DesignPatterns.FacadePattern;

import DesignPatterns.FacadePattern.Menus.Menus;
import DesignPatterns.FacadePattern.Menus.VegMenu;

public class VegRestaurant implements Hotel
{
    @Override
    public Menus getMenus()
    {
        VegMenu v = new VegMenu();
        return v;
    }

    @Override
    public String toString() {
        return "VegRestaurant{}";
    }
}
