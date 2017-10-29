import hjelpeklasser.*;

import javax.xml.soap.Node;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n-+-+-+-+-+-Program start-+-+-+-+-+-");


        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};

        Liste<String> liste1 = new DobbeltLenketListe<>(navn);

        DobbeltLenketListe.sorter(liste1, Comparator.naturalOrder());
        System.out.println(liste1);  // [Anders, Berit, Bodil, Kari, Lars, Per]   System.out.println(liste2);  // [Anders, Berit, Bodil, Kari, Lars, Per]   System.out.println(liste3);  // [Anders, Berit, Bodil, Kari, Lars, Per]

        // Tabellen navn er upåvirket:   System.out.println(Arrays.toString(navn));   // [Lars, Anders, Bodil, Kari, Per, Berit]


        System.out.println("-+-+-+-+-+-Program slutt-+-+-+-+-+-");
    }
}


