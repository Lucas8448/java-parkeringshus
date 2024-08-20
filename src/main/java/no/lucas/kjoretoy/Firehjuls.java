package no.lucas.kjoretoy;

public record Firehjuls(Regnr regnr, String farge, String modell, int arsmodell) implements Kjoretoy {

    @Override
    public String getType() {
        return "Firehjuls";
    }

    @Override
    public Regnr getRegnr() {
        return regnr;
    }
}