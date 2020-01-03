package DesignPatterns.AdapterPattern;

import DesignPatterns.PioltPen;

public class PenAdapter implements Pen {

    PioltPen pp = new PioltPen();

    @Override
    public void write(String str) {
        pp.mark(str);
    }
}
