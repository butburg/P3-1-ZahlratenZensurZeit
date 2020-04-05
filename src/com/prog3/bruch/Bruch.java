package com.prog3.bruch;

public class Bruch implements Comparable<Bruch> {
    private int zaehler;
    private int nenner;

    public Bruch(int zaehler, int nenner) throws zaehlerNullException {
        if (nenner == 0) {
            throw new zaehlerNullException();
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public Bruch() {
        System.out.println("Warnunng: Bruch ohne Parameter aufgerufen!");
        zaehler = 1;
        nenner = 1;
    }

    public Bruch multiplizieren(Bruch b) throws zaehlerNullException {
        int produktZaehler = zaehler * b.getZaehler();
        int produktNenner = nenner * b.getNenner();

        Bruch produkt = new Bruch(produktZaehler, produktNenner);
        produkt.kuerzen();
        return produkt;
    }

    //rechnet den Bruch in eine Kommazahl um
    public double ausrechnen() {
        return (double) zaehler / (double) nenner;
    }

    public void kuerzen() {
        int ggT = rechneggT(zaehler, nenner);

        zaehler /= ggT;
        nenner /= ggT;
    }

    private int rechneggT(int zaehler, int nenner) {
        if (zaehler == 0) {
            return nenner;
        } else {
            return rechneggT(nenner % zaehler, zaehler);
        }
    }

    public Bruch kehrwert() throws zaehlerNullException {
        return new Bruch(nenner, zaehler);
    }

    public Bruch dividieren(Bruch b) throws zaehlerNullException {
        return this.multiplizieren(b.kehrwert());
    }

    public int getZaehler() {
        return zaehler;
    }

    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    public int getNenner() {
        return nenner;
    }

    public void setNenner(int nenner) {
        this.nenner = nenner;
    }

    @Override
    public String toString() {
        return "(" + zaehler + "/" + nenner + ")";
    }

    @Override
    public int compareTo(Bruch o) {
        if (this.ausrechnen() > o.ausrechnen()) {
            //wenn Bruch o kleiner als this
            return -1;
        } else if (this.ausrechnen() < o.ausrechnen()) {
            //wenn Bruch o kleiner als this
            return 1;
        } else if (this.ausrechnen() == o.ausrechnen()) {
            //wenn Bruch o kleiner als this
            return 0;
        }
        return -2;
    }
}