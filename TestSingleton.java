class SingletonException extends Exception {
    public SingletonException(String s) {
        super("Fehler!!!");
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Privater Konstruktor, um externe Instanziierung zu verhindern
    }

    public static Singleton getInstance() throws SingletonTwoException {
        if (instance == null) {
            instance = new Singleton(); //Methode gibt die einzige Instanz der Klasse zurück. Wenn die Instanz noch nicht existiert (instance == null), wird eine neue erstellt. Andernfalls
        } else {
            throw new SingletonTwoException("Fehler!!!");
        }
        return instance;
    }
}

public class TestSingleton {
    static public void main(String[] args) {
        Singleton ref1;
        Singleton ref2;
        try {
            // Erzeugen des ersten Singletons
            ref1 = Singleton.getInstance();
            System.out.println("1. Singleton erzeugt");
            // Erzeugen des zweiten Singletons versuchen:
            ref2 = Singleton.getInstance(); // Hier sollte eine Exception geworfen werden
            System.out.println("2. Singleton erzeugt");
        } catch (SingletonTwoException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Ende des Tests des Singleton");
        }
    }
}
