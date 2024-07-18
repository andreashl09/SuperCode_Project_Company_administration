package Person_Klassen;

import java.time.LocalDate;

public class Teilnehmer extends Person {
    private static int idCounter;
    private int id;
    private boolean hatJob;
    private LocalDate vermitteltAm;
    private Buchung gebuchterKurs;

    public Teilnehmer(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.id = idCounter;
        idCounter++;
    }

    public LocalDate getVermitteltAm() {
        return vermitteltAm;
    }

    public Buchung getGebuchterKurs() {
        return gebuchterKurs;
    }

    public int getId() {
        return id;
    }

    public void setGebuchterKurs(Buchung gebuchterKurs) {
        this.gebuchterKurs = gebuchterKurs;
    }

    public boolean isHatJob() {
        return hatJob;
    }

    public void erfolgreichVermittelt(LocalDate newVermitteltAm) {
        this.vermitteltAm = newVermitteltAm;
        this.hatJob = true;
    }

    public String teilnehmerDaten() {
        return "Vorname: " + this.getVorname() + " Nachname: " + this.getNachname();
    }
}