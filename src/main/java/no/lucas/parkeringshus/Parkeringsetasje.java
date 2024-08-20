package no.lucas.parkeringshus;

import no.lucas.kjoretoy.Kjoretoy;
import no.lucas.kjoretoy.Regnr;

import java.util.List;
import java.util.ArrayList;

public class Parkeringsetasje {
    private final int etasjeNr;
    private final List<Parkeringsplass> plasser;

    public Parkeringsetasje(int etasjeNr, int antallPlasser, String[] typerPlasser) {
        this.etasjeNr = etasjeNr;
        this.plasser = new ArrayList<>();
        for (int i = 0; i < antallPlasser; i++) {
            plasser.add(new Parkeringsplass(i + 1, typerPlasser[i % typerPlasser.length]));
        }
    }

    public Parkeringsplass finnLedigPlass(String kjoretoyType) {
        System.out.println("Searching for ledig plass for type: " + kjoretoyType);
        for (Parkeringsplass plass : plasser) {
            System.out.println("Checking plass: " + plass.getPlassType() + " (ledig: " + plass.erLedig() + ")");
            if (plass.erLedig() && plass.getPlassType().equals(kjoretoyType)) {
                System.out.println("Found ledig plass: " + plass.getPlassType());
                return plass;
            }
        }
        System.out.println("No ledig plass found for type: " + kjoretoyType);
        return null;
    }

    public boolean parkereKjoretoy(Kjoretoy kjoretoy) {
        Parkeringsplass plass = finnLedigPlass(kjoretoy.getType());
        if (plass != null) {
            plass.parkereKjoretoy(kjoretoy);
            System.out.println("Parked kjoretoy at plass: " + plass.getPlassType());
            return true;
        }
        System.out.println("Failed to park kjoretoy, no available plass.");
        return false;
    }

    public boolean fjernKjoretoy(Regnr regnr) {
        System.out.println("Attempting to remove kjoretoy with regnr: " + regnr);
        for (Parkeringsplass plass : plasser) {
            if (!plass.erLedig() && plass.getKjoretoy().getRegnr().equals(regnr)) {
                plass.fjernKjoretoy();
                System.out.println("Removed kjoretoy with regnr: " + regnr);
                return true;
            }
        }
        System.out.println("Failed to remove kjoretoy, not found with regnr: " + regnr);
        return false;
    }
}
