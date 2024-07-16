public class Person {
    private static int idCounter;
    private int id;
    private String vorname;
    private String nachname;

    public Person(String newVorname, String newNachname) {
        this.vorname = newVorname;
        this.nachname = newNachname;
        this.id = idCounter;
        idCounter++;
    }
}
