/*
 * Author: butburg
 */

package com.prog3;

import com.prog3.bruch.*;
import com.prog3.ratespiel.*;
import com.prog3.zensurenspiegel.*;
import com.prog3.zeit.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        bruch();
        Ratespiel spiel1 = new Ratespiel();
        Zensurenspiegel spiegel1 = new Zensurenspiegel();
        //Zeit z = new Zeit();
        //z.ausgebendeutsch();
    }


    // aus Lesung von @author Doro
    public static void sortiere(Comparable[] x) {
        boolean unsortiert = true;
        Comparable temp;
        while (unsortiert) {
            unsortiert = false;
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i].compareTo(x[i + 1]) > 0) {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    unsortiert = true;
                }
            }
        }
    }



    private static void bruch() {
        try {
            // lege Array mit Brüchen an
            Bruch[] bs = {new Bruch(1, 5),
                          new Bruch(4, 5),
                          new Bruch(3, 5),
                          new Bruch(5,10),};
            System.out.println(Arrays.toString(bs));
            Arrays.sort(bs);
            System.out.println(Arrays.toString(bs));


            testen(bs);
        } catch (zaehlerNullException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private static void testen(Bruch[] bs) throws zaehlerNullException {

        System.out.println(bs[0].getZaehler());
        System.out.println(bs[0].getNenner());
        System.out.println(bs[1].ausrechnen());
        System.out.println("bs[1].kuerzen()");
        bs[1].kuerzen();
        System.out.println(bs[1]);
        System.out.println(bs[1].ausrechnen());
        System.out.println(bs[0].multiplizieren(bs[2]));
        System.out.println(bs[0].dividieren(bs[2]));
        System.out.println(bs[3]);
        System.out.println(bs[3].ausrechnen());
        System.out.println(bs[3].kehrwert());
        Arrays.sort(bs,Bruch::compareTo);
    }
}
