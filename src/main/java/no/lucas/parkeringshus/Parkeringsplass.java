package no.lucas.parkeringshus;

import no.lucas.kjoretoy.Kjoretoy;

public class Parkeringsplass {
    private final int plassNr;
    private final String plassType;
    private Kjoretoy kjoretoy;

    public Parkeringsplass(int plassNr, String plassType) {
        this.plassNr = plassNr;
        this.plassType = plassType;
        this.kjoretoy = null;
    }

    public boolean erLedig() {
        return kjoretoy == null;
    }

    public String getPlassType() {
        return plassType;
    }

    public Kjoretoy getKjoretoy() {
        return kjoretoy;
    }

    public void parkereKjoretoy(Kjoretoy kjoretoy) {
        if (this.kjoretoy != null) {
            throw new IllegalStateException("Attempted to park in an already occupied spot: " + plassNr);
        }
        System.out.println("Parking kjoretoy: " + kjoretoy.getRegnr() + " at plass: " + plassNr);
        this.kjoretoy = kjoretoy;
    }

    public Kjoretoy fjernKjoretoy() {
        if (this.kjoretoy == null) {
            throw new IllegalStateException("Attempted to remove a vehicle from an empty spot: " + plassNr);
        }
        System.out.println("Removing kjoretoy from plass: " + plassNr);
        Kjoretoy removedKjoretoy = this.kjoretoy;
        this.kjoretoy = null;
        return removedKjoretoy;
    }
}