interface KannLernen{
    Fach neuesAktFach();
}
interface Fach{
    String zumNaechstenFach();
}
public class Studium implements KannLernen{
    String faecher[]={"Java", "Mathe", "BWL", "RG"};

    public Fach neuesAktFach(){
        return new Fach() {
            @Override
            public String zumNaechstenFach() {
                int index=(int)(Math.random()*faecher.length);
                return faecher[index];
            }
        };
    }

    public static void main(String[] args) {
        Studium s1 =new Studium();
        Fach fach = s1.neuesAktFach();
        for (int i = 0; i < 100; i++) {
            System.out.println(fach.zumNaechstenFach());
        }
    }
}
