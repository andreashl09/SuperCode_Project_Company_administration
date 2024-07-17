
import java.util.ArrayList;


public class Mitarbeiter extends Person{
    private ArrayList<Kategorie> lizenzliste;

    
    public Mitarbeiter(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.lizenzliste = new ArrayList<>();
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
}
