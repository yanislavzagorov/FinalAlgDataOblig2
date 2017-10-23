import hjelpeklasser.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n-+-+-+-+-+-Program start-+-+-+-+-+-");


        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        System.out.println(liste.toString() + " " + liste.omvendtString());

        for (int i = 1; i <= 3; i++)
        {
            liste.leggInn(i);
            System.out.println(liste.toString() + " " + liste.omvendtString());
        }


        System.out.println("-+-+-+-+-+-Program slutt-+-+-+-+-+-");
    }
}


