import hjelpeklasser.*;

import javax.xml.soap.Node;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n-+-+-+-+-+-Program start-+-+-+-+-+-");


        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> liste = new DobbeltLenketListe<>(c);
        System.out.println("liste er - - - - " + liste.toString());

        liste.fjern('C');


        System.out.println("-+-+-+-+-+-Program slutt-+-+-+-+-+-");
    }
}


