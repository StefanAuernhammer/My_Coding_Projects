interface RechenFunktion {
    double f(double a, double b);
}

public class RechentabNested {

    // a) Elementklasse (innere Klasse, die auf Instanzvar. und meth. zugreift) Benötigt Insatnz von rechentab
    class Add implements RechenFunktion {
        public double f(double a, double b) {
            return a + b;
        }
    }

    // b) Statisch geschachtelte Klasse (Hat keinen Zugriff auf Insatnzvar. und meth.)
    static class Sub implements RechenFunktion {
        public double f(double a, double b) {
            return a - b;
        }
    }

    static void printTab(double x00, double x01, double x0d,
                         double x10, double x11, double x1d,
                         RechenFunktion fkt) {
        System.out.print("\t|");
        for (double x = x10; x <= x11; x += x1d) {
            System.out.print(x + "\t|");
        }
        System.out.println();
        for (double i = x00; i <= x01; i += x0d) {
            System.out.print(i + "\t|");
            for (double j = x10; j <= x11; j += x1d) {
                System.out.print(fkt.f(i, j) + "\t|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RechentabNested rechentab = new RechentabNested();

        // Testen der Elementklasse
        System.out.println("Elementklasse (Addition):");
        printTab(0.0, 5, 0.5, 1.0, 5, 0.5, rechentab.new Add()); //benötigt Instannz von rechentab

        // Testen der statisch geschachtelten Klasse
        System.out.println("\nStatisch geschachtelte Klasse (Subtraktion):");
        printTab(0.0, 5, 0.5, 1.0, 5, 0.5, new Sub()); //benötgit keine Instanz von rechentab

        // c) Lokale Klasse innerhalb der Main Methode (hat nur lokale Var und Methoden)
        class Prod implements RechenFunktion {
            public double f(double a, double b) {
                return a * b;
            }
        }
        System.out.println("\nLokale Klasse (Multiplikation):");
        printTab(0.0, 5, 0.5, 1.0, 5, 0.5, new Prod());

        // d) Anonyme Klasse beim Aufruf von printTab (Instanzierung direkt bei Implementierung)
        System.out.println("\nAnonyme Klasse (Division):");
        printTab(0.0, 5, 0.5, 1.0, 5, 0.5, new RechenFunktion() {
            public double f(double a, double b) {
                if (b == 0) {
                    throw new ArithmeticException("Division durch Null ist nicht erlaubt");
                }
                return a / b;
            }
        });
    }
}
