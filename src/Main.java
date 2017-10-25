import hjelpeklasser.*;

import javax.xml.soap.Node;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n-+-+-+-+-+-Program start-+-+-+-+-+-");


        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println(liste.subliste(3,8));  // [D, E, F, G, H]
        System.out.println(liste.subliste(5,5));  // []
        System.out.println(liste.subliste(8,liste.antall()));  // [I, J]
        System.out.println(liste.toString());
        System.out.println("Fjerner " + liste.fjern(3));
        System.out.println(liste.toString());
        System.out.println("Fjerner " + liste.fjern(0));
        System.out.println("Fjerner " + liste.fjern(0));
        System.out.println("Fjerner " + liste.fjern(0));
        System.out.println("Fjerner " + liste.fjern(0));System.out.println("Fjerner " + liste.fjern(0));
        System.out.println("Fjerner " + liste.fjern(0));
        System.out.println("Fjerner " + liste.fjern(0));
        System.out.println("Fjerner " + liste.fjern(0));
        System.out.println(liste.antall());
        System.out.println("Fjerner " + liste.fjern(0));
        System.out.println(liste.toString());
        System.out.println(liste.leggInn('K'));
        System.out.println(liste.toString());


        System.out.println("-+-+-+-+-+-Program slutt-+-+-+-+-+-");
    }
}


