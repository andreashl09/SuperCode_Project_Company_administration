public class Aufgabe {

    private String name;
    private int aufgabeTage;
    private final int MAXTAGE = 3;

    public Aufgabe(String name, int aufgabeTage) {
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

    public void setAufgabeTage(int aufgabeTage) {
        if (aufgabeTage > MAXTAGE || aufgabeTage <= 0)
            throw new IllegalArgumentException("Angabe der Tage falsch!");

        this.aufgabeTage = aufgabeTage;
    }

    
    
}
