package com.prog3.zeit;

import java.util.Date;

public class Zeit {
    Date now;
    int h;
    int m;
    int s;
    public Zeit() {
        Date now = new Date();
    }

    public Zeit(int h,int m,int s) {
        Date now = new Date();
    }

    public void ausgebendeutsch() {
        System.out.println(now);
    }

    public void ausgebenEnglisch() {

    }

    int differenz(Zeit t2) {
        return 0;
    }
}
