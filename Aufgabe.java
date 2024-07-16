public class Aufgabe {

    private String name;
    private int aufgabeTage;
    private final int MAX_TAGE = 3;
    private Kategorie kategorie;

    public Aufgabe(String name, Kategorie kategorie, int aufgabeTage) {
        this.kategorie = kategorie;
        this.name = name;
        setAufgabeTage(aufgabeTage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAufgabeTage() {
        return aufgabeTage;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setAufgabeTage(int aufgabeTage) {
        if (aufgabeTage > MAX_TAGE || aufgabeTage <= 0)
            throw new IllegalArgumentException("Angabe der Tage falsch!");

        this.aufgabeTage = aufgabeTage;
    }

}
