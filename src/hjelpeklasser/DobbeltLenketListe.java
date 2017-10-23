package hjelpeklasser;

/////////// DobbeltLenketListe ////////////////////////////////////

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DobbeltLenketListe<T> implements Liste<T>
{
    private static final class Node<T>   // en indre nodeklasse
    {
        // instansvariabler
        private T verdi;
        private Node<T> forrige;
        private Node<T> neste;

        private Node(T verdi, Node<T> forrige, Node<T> neste)  // konstruktør
        {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        protected Node(T verdi)  // konstruktør
        {
            this(verdi, null, null);
        }

        public T getVerdi()
        {
            return verdi;
        }

        public void setForrige(Node<T> node)
        {
            this.forrige = node;
        }

        public Node<T> getForrige()
        {
            return forrige;
        }

        public void setNeste(Node<T> node)
        {
            this.neste = node;
        }

        public Node<T> getNeste()
        {
            return neste;
        }
    } // Node

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;   // antall endringer i listen

    // hjelpemetode
    private Node<T> finnNode(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    // konstruktør
    public DobbeltLenketListe()
    {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    // konstruktør
    public DobbeltLenketListe(T[] a)
    {
        Objects.requireNonNull(a, "Tabellen a er tom!");
        if (a.length == 0){
            throw new IndexOutOfBoundsException("Ikke lov med tabeller uten verdier");
        }


        Node nyNode = new Node(null);

        for (int i = 0; i < a.length; i++)
        {
            if(a[i]!=null)
            {
                if(antall==0){
                    nyNode = hode = new Node(a[i]);
                    antall++;
                    endringer++;
                    System.out.println("La til 1. verdi!" + a[i]);
                } else {
                    nyNode.neste = new Node(a[i], nyNode, null);
                    nyNode = nyNode.neste;
                    antall++;
                    endringer++;
                    System.out.println("Har lagt inn a[" + i + "] med verdi '" + a[i] + "'"); // TODO Dette er en else-statement for testing. Fjern før innlevering!
                }
            } else
            {
                System.out.println("Hoppet over a[" + i + "] for den er tom!");           // TODO Dette er en else-statement for testing. Fjern før innlevering!
            }
        }
        hale = nyNode;
    }

    /** Sjekkeliste for konstruktøren
     *
     * Stoppes en null-tabell? Kastes i så fall en NullPointerException?
     * Blir det korrekt hvis parametertabellen inneholder en eller flere null-verdier?
     * Blir det korrekt hvis parametertabellen er tom (har lengde 0)?
     * Blir det korrekt hvis parametertabellen kun har null-verdier?
     * Blir det korrekt hvis parametertabellen har kun én verdi som ikke er null?
     * Blir antallet satt korrekt?
     * Får verdiene i listen samme rekkefølge som i tabellen?
     */







    // subliste
    public Liste<T> subliste(int fra, int til)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public int antall()
    {
        return antall;
    }

    @Override
    public boolean tom()
    {
        return (antall==0);
    }

    @Override
    public boolean leggInn(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public void leggInn(int indeks, T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean inneholder(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T hent(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public int indeksTil(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T oppdater(int indeks, T nyverdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean fjern(T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T fjern(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public void nullstill()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    public String omvendtString()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public Iterator<T> iterator()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    public Iterator<T> iterator(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator()
        {
            denne = hode;     // denne starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks)
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public boolean hasNext()
        {
            return denne != null;  // denne koden skal ikke endres!
        }

        @Override
        public T next()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

    } // DobbeltLenketListeIterator

} // DobbeltLenketListe
