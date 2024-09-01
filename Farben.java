interface KannZeichnen{
    Farbwahl neuefarbfolge();
}
interface Farbwahl{
    String naechsteFarbe();
}
public class Farben implements KannZeichnen{
    String colors[]= {"rot", "gelb", "gruen", "blau"};

    public Farbwahl neuefarbfolge(){
        return new Farbwahl() {
            @Override
            public String naechsteFarbe() {
                int index= (int)(Math.random()*colors.length);
                return colors[index];
            }
        };
    }


    public static void main(String[] args) {
        Farben f= new Farben();
        Farbwahl farbwahl = f.neuefarbfolge();
        for (int i = 0; i < 100; i++) {
            System.out.println(farbwahl.naechsteFarbe());
        }
    }
}
