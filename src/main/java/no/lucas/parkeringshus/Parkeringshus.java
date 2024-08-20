package no.lucas.parkeringshus;

import no.lucas.kjoretoy.Kjoretoy;
import no.lucas.kjoretoy.Regnr;

import java.util.ArrayList;
import java.util.List;

public class Parkeringshus {
    private List<Parkeringsetasje> etasjer;

    public Parkeringshus(int antallEtasjer, int antallPlasserPerEtasje, String[] typerPlasser) {
        etasjer = new ArrayList<>();
        for (int i = 0; i < antallEtasjer; i++) {
            etasjer.add(new Parkeringsetasje(i + 1, antallPlasserPerEtasje, typerPlasser));
        }
    }

    public boolean parkereKjoretoy(Kjoretoy kjoretoy) {
        for (Parkeringsetasje etasje : etasjer) {
            if (etasje.parkereKjoretoy(kjoretoy)) {
                return true;
            }
        }
        return false;
    }

    public boolean fjerneKjoretoy(Regnr regnr) {
        for (Parkeringsetasje etasje : etasjer) {
            if (etasje.fjernKjoretoy(regnr)) {
                return true;
            }
        }
        return false;
    }
}