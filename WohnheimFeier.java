class GlasBier {
    public GlasBier() {
        System.out.println("Ein Glas Bier wurde gezapft.");
    }
}

class FassLeerException extends Exception {
    public FassLeerException(String message) {
        super(message);
    }
}

class BierAusException extends Exception {
    public BierAusException(String message) {
        super(message);
    }
}

class Bierfass {
    private double fuellstand;
    private static final double MAX_FUELLSTAND = 20.0; //Einführen von MAX_Fuellstand für das Zurücksetzten nachdem FAss leer ist

    public Bierfass() {
        this.fuellstand = MAX_FUELLSTAND;
    }

    public GlasBier zapfen() throws FassLeerException {
        if (fuellstand > 0) {
            fuellstand -= 0.5;
            return new GlasBier(); // wird solange 0,5l gezapft, bis das Fass leer ist -> anschließend Fehlermeldung
        } else {
            throw new FassLeerException("Fass ist leer!");
        }
    }

    public void resetFuellstand() {
        fuellstand = MAX_FUELLSTAND; //sobald Fass leer, wird Füllstand für neues Fass zurückgesetzt
    }
}

class Ausschank {
    private int anzahlFässer;
    Bierfass[] bierfässer; //Array für die bierfässe vom typ Bierfass
    private int aktuellesFassIndex; // Variable für das Zählen der verbrauchten Bierfässer


    public Ausschank(int anzahlFässer) {
        this.anzahlFässer = anzahlFässer;
        bierfässer = new Bierfass[anzahlFässer];
        for (int i = 0; i < anzahlFässer; i++) {
            bierfässer[i] = new Bierfass();
        }
        aktuellesFassIndex = 0; // Das erste Fass wird zu Beginn ausgewählt
    }

    // Methode zum Verkaufen eines Glases Biers
    public GlasBier bierVerkaufen() throws BierAusException {
        try {
            return bierfässer[aktuellesFassIndex].zapfen(); //Zapfen veringert Bierfassmenge
        } catch (FassLeerException e) {
            System.out.println("Fass " + (aktuellesFassIndex + 1) + " ist leer. Neues Fass wird angezapft...");
                /*bierfässer[i].resetFuellstand(); // Zurücksetzen des Füllstands des leeren Fasses
                if (i == anzahlFässer - 1) {
                    aktuellesFassIndex = 0; // Wenn das letzte Fass leer ist, das erste Fass auswählen
                } else {
                    aktuellesFassIndex = i + 1; // Das nächste Fass auswählen
                }*/
            if (anzahlFässer > aktuellesFassIndex) {
                aktuellesFassIndex += 1; // Das nächste Fass auswählen
                return bierVerkaufen();
            } else {
                throw new BierAusException("Bier aus");
            }

        }
        //throw new BierAusException("Es ist kein Bier mehr verfügbar!");

    }
}
class Feier {
    public static void feiern(int anzahlBiere) {
        Ausschank ausschank = new Ausschank(3);
        for (int i = 0; i < anzahlBiere; i++) {
            try {
                ausschank.bierVerkaufen();
            } catch (BierAusException e) {
                System.out.println("Bierausnahme: " + e.getMessage());
                break; // Beenden der Schleife, wenn kein Bier mehr verfügbar ist
            }
        }
    }
}

public class WohnheimFeier {
    public static void main(String[] args) {
        Feier.feiern(50);
    }
}

