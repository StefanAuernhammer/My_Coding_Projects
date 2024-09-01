class AtCharException extends Exception {
    public AtCharException() {
    }
}

interface C4Test { // Interface mit zwei Methoden, die Ausnahmen werfen
    String toBig(String s) throws Exception;
    String callToBig(String s) throws Exception;
}

public class Converter4Test implements C4Test { // Klasse, die das Interface C4Test implementiert
    // Die toBig-Methode konvertiert Kleinbuchstaben eines Strings in Großbuchstaben,
// wirft aber eine Ausnahme wenn der String mit @ beginnt.
    @Override
    public String toBig(String s) throws Exception { // Methode toBig aus dem Interface
        // Konvertiert Klein in Groß, wirft Ausnahme, wenn @ am Anfang
        if (s.charAt(0) == '@') {
            throw new AtCharException();
        }
        String ergebnis = ""; // leer, hier wird Ergebnis gespeichert
        for (int i = 0; i < s.length(); i++) {
            char zeichen = s.charAt(i); // jedes Zeichen im String
            if ('a' <= zeichen && zeichen <= 'z') { // wenn klein
                ergebnis = ergebnis + (char) (zeichen - 'a' + 'A'); // dann
            } else if ('A' <= zeichen && zeichen <= 'Z') { // wenn groß
                ergebnis = ergebnis + zeichen; // dann so lassen
            } else {
                throw new Exception(); // sonst Ausnahme
            }
        }
        return ergebnis;
    }

    @Override
    public String callToBig(String s) throws Exception {
        // Die callToBig-Methode ruft toBig auf und gibt den ursprünglichen String zurück, wenn
        // toBig eine AtCharException wirft.
        String ergebnis = ""; // leer, hier wird Ergebnis gespeichert
        try { // versuche toBig aufzurufen
            ergebnis = toBig(s); // wenn erfolgreich, dann Ergebnis
        } catch (AtCharException e) { // wenn @ am Anfang
            return s; // dann gebe s zurück
        }
        return ergebnis;
    }

    public static void main(String[] args) throws Exception {
        Converter4Test konverter = new Converter4Test();
        System.out.println(konverter.toBig("tEStVersuch"));
        System.out.println(konverter.callToBig("@tEStversuch"));
        System.out.println(konverter.callToBig("testversuCH"));
    }
}
