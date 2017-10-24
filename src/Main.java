import hjelpeklasser.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n-+-+-+-+-+-Program start-+-+-+-+-+-");


        String[] s = {"Ola", "Petter", null, null, "Per", "Fugg", null};
        Liste<String> liste = new DobbeltLenketListe<>(s);
        System.out.println(liste.toString());
        System.out.println(liste.fjern(2));
        System.out.println(liste.toString());

        System.out.println("-+-+-+-+-+-Program slutt-+-+-+-+-+-");
    }
}


