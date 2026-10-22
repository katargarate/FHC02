public class Main {
    static void main(String[] args) {
        Hashtable hashtable = new Hashtable();

        hashtable.add(1234010190);
        hashtable.add(1873120745);
        hashtable.add(1984567890);


        System.out.println("1234010190: " +hashtable.search(1234010190));
        System.out.println("1873120745: " +hashtable.search(1873120745));


        // eine die nicht vorkommt, liefert dann 0 zurück
        System.out.println("0000000000: " +hashtable.search(0000000000));

    }
}
