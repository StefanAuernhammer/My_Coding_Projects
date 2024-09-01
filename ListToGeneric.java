//Generics = Klassen,Interfaces, Methoden mit Typen zu parametrisieren. Allgemeine Deklaration und dann spezifizierung des typs bei Verwendung
// Verhindert Typenkonflikte u. erhöht Wiederverwendbarkeit
public class ListToGeneric {

    public static void main(String[] args) {
        ListToGeneric instance = new ListToGeneric(); //instanz erstellt und in instance gespeichert

        Liste<Buch> buchListe = instance.new Liste<>(); //generische Liste (typ: buch) wird erstellt mit Buch-Objekten
        buchListe.insert(instance.new Buch("Harry Potter, J.K. Rowling"));
        buchListe.insert(instance.new Buch("Pipi Langstrumpf, Astrid Lindgren"));
        buchListe.insert(instance.new Buch("Verblendung, Larsson"));

        Liste<Integer> intListe = instance.new Liste<>(); //Gener. Liste mit integer werten
        intListe.insert(1);
        intListe.insert(2);
        intListe.insert(3);

        Liste<String> stringListe = instance.new Liste<>(); //Gener. Liste mit String Werten
        stringListe.insert("eins");
        stringListe.insert("zwei");
        stringListe.insert("drei");

        System.out.println("Buch Liste: " + buchListe); //ausgabe der  lListen
        System.out.println("Integer Liste: " + intListe);
        System.out.println("String Liste: " + stringListe);
    }

    class Liste<T> { //Gener. Klasse mit T Typ-parameter, die Liste erstellt
        class LiElem {
            T inh; //inhalt vom typ T
            LiElem next; //Nächstes Listenelement

            LiElem(T i, LiElem n) { //KOnstruktor der inh u. next initalisiert
                next = n;
                inh = i;
            }
        }

        LiElem root; //Anfang der Liste

        void insert(T b) { //Stattt typ buch hat man jetzt typ T
            root = new LiElem(b, root);
        }

        public String toString() {
            LiElem p = root;
            String str = "";
            while (p != null) {
                str = str + " | " + p.inh;
                p = p.next;
            }
            return str;
        }
    }

    class Buch {
        String title;

        Buch(String b) {
            title = b;
        }

        public String toString() {
            return title;
        }
    }
}
//Vorteil von Generics: Code kann für versch. Datentypen (Buch, Int, etc.) verwendet werden ohne code anzupassen müssen