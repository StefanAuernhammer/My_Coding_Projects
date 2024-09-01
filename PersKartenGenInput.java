class PersKart<T extends Comparable<T>> { //Generische Klasse mit typparameter t und comparable interface für vergleiche  von elementen
    class Person implements Comparable<Person> { //objekt Person für Personenkartei und combarable person für vergleiche mit personenobj.
        String name;
        int alter;

        Person() { // automatisch generiert! nur Zahlen keine Texte!
            name = "" + (int) (Math.random() * 10000);
            alter = (int) (Math.random() * 95);
        }

        @Override
        public String toString() {
            return name + " " + alter;
        }

        @Override
        public int compareTo(Person o) { //Vergleich namen mit der übergebenen Peron
            return name.compareTo(o.name);
        }
    }

    T[] elements; //Array mit elementen um elmenten in kartei zu speichern

    PersKart(int anz) { //initialisierung über schleife und einfügen in das array
        elements = (T[]) new Comparable[anz];
        for (int i = 0; i < anz; i++) {
            elements[i] = (T) new Person();
        }
    }

    void print() {
        System.out.println("== Inhalt der Kartei ==");
        for (T element : elements) {
            System.out.println(element);
        }
    }

    void sort() {
        PersKartenGenInput.sort(elements);
    }
}

public class PersKartenGenInput {

    public static <T extends Comparable<T>> void sort(T[] a) { //sortierung-algor. vorgegeben
        int i, j;
        T t;
        for (i = 1; i < a.length; i++) {
            j = i;
            t = a[j];
            while ((j > 0) && (a[j - 1].compareTo(t) > 0)) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        // testen der personensortierung
        PersKart k = new PersKart<>(10); //Neue instanzen von personen
        k.print();
        k.sort();
        k.print();

        // Testen der integer-Sortierung
        Integer[] intArray = new Integer[100];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 100);
        }
        for (int i = 0; i < intArray.length; i++)
            System.out.print(intArray[i] + " ");
        System.out.println();

        sort(intArray);
        System.out.println("== Inhalt des Integer-Arrays ==");
        for (Integer i : intArray) {
            System.out.println(i);
        }
    }
}
//Fehlermeldung comporbale: die generischen Typen sind nicht korrekt gebunden
