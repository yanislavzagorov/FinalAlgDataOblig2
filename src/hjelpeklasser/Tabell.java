package hjelpeklasser;

import java.util.Arrays;
import java.util.Random;
import java.util.NoSuchElementException;
import java.util.OptionalInt;


public class Tabell{

    /**
     * Testeområde for metoder!
     * Start
     */

    /**
     * Slutt
     */


    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    public static int[] randPerm(int n){
        Random r = new Random();
        int[] a = new int[n];
        Arrays.setAll(a, i -> (i+1));
        for (int l = n-1 ; l > 0; l--){
            int i = r.nextInt(l+1);
            bytt(a,l,i);
        }
        return a;
    }
    public static void randPerm(int[] a){
        Random r = new Random();
        for(int k = (a.length)-1; k > 0; k--){
            int i = r.nextInt(k + 1);
            bytt(a,k,i);
        }
    }
    public static int maks(int[] a, int fra, int til){
        if(fra == til) throw new NoSuchElementException("fra("+fra+") = til("+til+") ­ tomt tabellintervall!");
        fraTilKontroll(a.length, fra, til);
        int m = fra;
        int maksverdi = a[fra];
        for (int i = fra + 1; i < til; i++){
            if (a[i] > maksverdi){
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }
    public static int maks(int[] a){
        return maks(a,0,a.length);
    }
    public static void skriv(int[] a, int fra, int til){
        for(int i = fra; i < til; i++ ){
            System.out.print(a[i] + " ");
        }
    }
    public static void skriv(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
    public static void skrivln(int[] a, int fra, int til){
        for(int i = fra; i < til; i++ ){
            System.out.println(a[i] + " ");
        }
    }
    public static void skrivln(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i] + " ");
        }
    }
    public static void skriv(char[] c, int fra, int til){
        for(int i = fra; i < til; i++ ){
            System.out.print(c[i] + " ");
        }
    }
    public static void skriv(char[] c){
        for(int i = 0; i < c.length; i++){
            System.out.print(c[i] + " ");
        }
    }
    public static void skrivln(char[] c, int fra, int til){
        for(int i = fra; i < til; i++ ){
            System.out.println(c[i] + " ");
        }
    }
    public static void skrivln(char[] c){
        for(int i = 0; i < c.length; i++){
            System.out.println(c[i] + " ");
        }
    }
    public static int[] naturligeTall(int n){
        if(n < 1){
            throw new IllegalArgumentException("n er mindre enn en");
        }
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }
        return array;
    }
    public static int[] heleTall(int fra, int til){
        if(fra > til){
            throw new IllegalArgumentException("fra er lik til!");
        }
        if(fra == til){
            return null;
        }
        int[] array = new int[til-fra];
        for(int i = 0; i < array.length; i++){
            array[i] = fra;
            fra++;
        }
        return array;
    }
    public static void fraTilKontroll(int tablengde, int fra, int til){
        if(fra < 0) throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negative!");
        if(til > tablengde) throw new ArrayIndexOutOfBoundsException("til(" + til + ") >vtablengde(" + tablengde + ")");
        if(fra > til) throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }
    public static void vhKontroll(int tablengde, int v, int h){
        if(v < 0) throw new ArrayIndexOutOfBoundsException("v("+v+") < 0");
        if(h >= tablengde) throw new ArrayIndexOutOfBoundsException("h("+h+") >= tablengde("+tablengde+")");
        if(v > (h+1)) throw new IllegalArgumentException("v = "+v+", h = "+h);
    }
    public static void snu(int[] a, int v, int h){
        while(v < h){
            bytt(a, v++, h);
        }
    }
    public static void snu(int[] a, int v){
        snu(a, v, a.length-1);
    }
    public static void snu(int[] a){
        snu(a, 0, a.length-1);
    }
    public static boolean nestePermutasjon(int[] a){
        int i = a.length-2;
        while(i >= 0 && a[i] > a[i+1]){
            i--;
            if(i < 0){
                return false;
            }
        }
        int j = a.length-1;
        while(a[j] < a[i]){
            j--;
            bytt(a, i, j);
            snu(a, i+1);
        }
        return true;
    }
}