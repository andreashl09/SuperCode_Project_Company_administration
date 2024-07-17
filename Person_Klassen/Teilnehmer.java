package Person_Klassen;
import java.time.LocalDate;

public class Teilnehmer extends Person {
    private static int idCounter;
    private int id;
    private boolean hatJob;
    private LocalDate vermitteltAm;

    public Teilnehmer(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.id = idCounter;
        idCounter++;
    }
    public boolean isHatJob() {
        return hatJob;
    }

    public LocalDate getVermitteltAm() {
        return vermitteltAm;
    }

    public int getId() {
        return id;
    }

    public void erfolgreichVermittelt(LocalDate newVermitteltAm) {
        this.vermitteltAm = newVermitteltAm;
        this.hatJob = true;
    }
    
    public String teilnehmerDaten() {
        return "Vorname: " + this.getVorname() + " Nachname: " + this.getNachname();
    }
}