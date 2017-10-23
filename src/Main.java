import hjelpeklasser.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n-+-+-+-+-+-Program start-+-+-+-+-+-");


        String[] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste = new DobbeltLenketListe<>(s);
        System.out.println(liste.antall() + " " + liste.tom());

        String[] a = {"Piotyr"};
        Liste<String> liste2 = new DobbeltLenketListe<>(a);
        System.out.println(liste2.antall() + " " + liste2.tom());




        System.out.println("-+-+-+-+-+-Program slutt-+-+-+-+-+-");
    }
}


