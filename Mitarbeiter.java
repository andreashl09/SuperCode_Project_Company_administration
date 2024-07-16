import java.util.ArrayList;


public class Mitarbeiter extends Person{
    private ArrayList<String> lizenzliste;

    
    public Mitarbeiter(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.lizenzliste = new ArrayList<>();
    }
}
