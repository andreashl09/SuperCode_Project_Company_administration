
import java.util.ArrayList;

public class Mitarbeiter extends Person {
    private static int idCounter;
    private int id;
    private ArrayList<Kategorie> lizenzliste;

    public Mitarbeiter(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.lizenzliste = new ArrayList<>();
        this.id = idCounter;
        idCounter++;
    }

    public ArrayList<Kategorie> getLizenzliste() {
        return lizenzliste;
    }

    public void setLizenzliste(ArrayList<Kategorie> lizenzliste) {
        this.lizenzliste = lizenzliste;
    }

    public void addLizenz(Kategorie kategorie) {
        lizenzliste.add(kategorie);
    }

    public int getId() {
        return id;
    }

}
