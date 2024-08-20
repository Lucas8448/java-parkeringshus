package no.lucas.kjoretoy;

public record Tohjuls(Regnr regnr, String farge, String modell, int arsmodell) implements Kjoretoy {

    @Override
    public String getType() {
        return "Tohjuls";
    }

    @Override
    public Regnr getRegnr() {
        return regnr;
    }
}