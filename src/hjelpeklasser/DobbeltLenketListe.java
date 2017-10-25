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
        Node<T> anchorNode;
        int scope = antall/2;

        if(indeks < scope)
        {
            anchorNode = hode;
            for(int i = 0; i < indeks; i++)
            {
                anchorNode = anchorNode.neste;
            }
            return anchorNode;
        } else
        {
            anchorNode = hale;
            for (int i = antall; i > indeks + 1; i--)
            {
                anchorNode = anchorNode.forrige;
            }
            return anchorNode;
        }
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
        Objects.requireNonNull(a, "Null verdier aksepteres ikke!");

        Node nyNode = new Node(null);

        for (int i = 0; i < a.length; i++)
        {
            if(a[i]!=null)
            {
                if(antall==0){
                    nyNode = hode = new Node(a[i]);
                    antall++;
                    endringer++;
                } else {
                    nyNode.neste = new Node(a[i], nyNode, null);
                    nyNode = nyNode.neste;
                    antall++;
                    endringer++;
                }
            }
        }
        hale = nyNode;
    }

    private void fratilKontroll(int antall, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }


    // subliste
    public Liste<T> subliste(int fra, int til)
    {
        fratilKontroll(antall, fra, til);
        Liste<T> subliste = new DobbeltLenketListe<>();
        Node<T> anchorNode = finnNode(fra);
        for(int i = fra; i < til; i++)
        {
            subliste.leggInn(anchorNode.verdi);
            anchorNode = anchorNode.neste;          //blir satt til null dersom anchorNode == hale

        }
        return subliste;
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
        Objects.requireNonNull(verdi, "Null verdier aksepteres ikke!");

        if(antall==0)
        {
            hode = hale = new Node(verdi);
            antall++;
            endringer++;
            return true;
        } else
        {
            Node<T> anchorNode = new Node(verdi, hale, null);
            hale.neste = anchorNode;
            hale = anchorNode;
            antall++;
            endringer++;
            return true;
        }
    }

    @Override
    public void leggInn(int indeks, T verdi)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean inneholder(T verdi)
    {
        if(indeksTil(verdi)==-1)
        {
            return false;
        }return true;
    }

    @Override
    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);
        Node<T> anchorNode = finnNode(indeks);
        return anchorNode.verdi;
    }

    @Override
    public int indeksTil(T verdi)
    {
        Node<T> anchorNode = hode;

        if(verdi==null){
            return -1;
        }

        for(int i = 0; i < antall; i++){
            if(anchorNode.verdi.equals(verdi))      //TODO (?) skal vi bruke .equals eller == her?
            {
                return i;
            }
            anchorNode = anchorNode.neste;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi)
    {
        indeksKontroll(indeks, false);
        Objects.requireNonNull(nyverdi, "Null verdier aksepteres ikke!");
        Node<T> anchorNode = finnNode(indeks);
        T returVerdi = anchorNode.verdi;
        anchorNode.verdi = nyverdi;
        return returVerdi;
    }

    @Override
    public boolean fjern(T verdi)
    {
        Node anchorNode = hode;

        while (anchorNode != null) {
            if(anchorNode.verdi.equals(verdi))
            {
                if (antall == 1)
                {
                    hode = hale = null;
                } else if (anchorNode == hode)
                {
                    hode = hode.neste;
                    hode.forrige = null;
                } else if (anchorNode == hale)
                {
                    hale = hale.forrige;
                    hale.neste = null;
                } else
                {
                    anchorNode.neste.forrige = anchorNode.forrige;
                    anchorNode.forrige.neste = anchorNode.neste;
                }
                antall--;
                endringer++;
                return true;
            }
            anchorNode = anchorNode.neste;
        }
        return false;
    }

    @Override
    public T fjern(int indeks)
    {
        indeksKontroll(indeks, false);

        Node<T> node;
        T anchorValue = hode.verdi;

        if (antall == 1)
        {
            hode = hale = null;
        } else if (indeks == 0)
        {
            hode = hode.neste;
            hode.forrige = null;
        } else if (indeks == antall - 1)
        {
            anchorValue = hale.verdi;
            hale = hale.forrige;
            hale.neste = null;
        } else
        {
            node = finnNode(indeks);
            anchorValue = node.verdi;
            node.forrige.neste = node.neste;
            node.neste.forrige = node.forrige;
        }

        antall--;
        endringer++;

        return anchorValue;
    }

    @Override
    public void nullstill()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> anchorNode = hode;
        for(int i = 0; i < antall; i++){
            sb.append(anchorNode.verdi);
            anchorNode = anchorNode.neste;
            if(i != antall-1){
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public String omvendtString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> anchorNode = hale;
        for(int i = 0; i < antall; i++){
            sb.append(anchorNode.verdi);
            anchorNode = anchorNode.forrige;
            if(i != antall-1){
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
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
