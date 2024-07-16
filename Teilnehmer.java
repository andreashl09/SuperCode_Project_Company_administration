import java.time.LocalDate;

public class Teilnehmer extends Person{
    private boolean hatJob;
    private LocalDate vermitteltAm;

    public Teilnehmer(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
    }
    public boolean isHatJob() {
        return hatJob;
    }

    public LocalDate getVermitteltAm() {
        return vermitteltAm;
    }

    public void erfolgreichVermittelt(LocalDate newVermitteltAm){
        this.vermitteltAm = newVermitteltAm;
        this.hatJob = true;
    }
}