package Person_Klassen;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

import Kurs_Klassen.Kurs;

public class Teilnehmer extends Person {
    private static int idCounter = 1;
    private int id;
    private boolean hatJob;
    private LocalDate vermitteltAm;
    private Kurs gebuchterKurs;
    private int bewertung = 0; // des Kurses 1-5, 1-schlecht 5-gut
    private String feedback = "";

    public Teilnehmer(String newVorname, String newNachname, Adresse newAdresse) {
        super(newVorname, newNachname, newAdresse);
        this.id = idCounter;
        idCounter++;
    }

    public int getBewertung() {
        return bewertung;
    }

    public void setBewertung(int bewertung) {
        if (bewertung != 0)
            throw new IllegalArgumentException("Bewertung wurde bereits abgegeben und kann nicht geändert werden!");
        if (bewertung > 5 || bewertung < 1)
            throw new IllegalArgumentException("Bewertung nicht im Rahmen der Zulässigkeit!");
        this.bewertung = bewertung;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String newFeedback) {
        if (newFeedback != "")
            throw new IllegalArgumentException("Feedback wurde schon gegeben und kann nicht geändert werden!");
        if (newFeedback.length() > 250) {
            newFeedback.substring(0, 250);
            System.out.println("Das Feedback wurde auf 250 Zeichen eingekürzt.");
        }
        this.feedback = newFeedback;
    }

    public LocalDate getVermitteltAm() {
        return vermitteltAm;
    }

    public Kurs getGebuchterKurs() {
        return gebuchterKurs;
    }

    public int getId() {
        return id;
    }

    public void setGebuchterKurs(Kurs gebuchterKurs) {
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

    public void bewertungAbgeben(int bewertung, String feedback) {
        setBewertung(bewertung);
        setFeedback(feedback);
    }

    public int ermittleDifferenzTage() {
        int tagDifferenz;
        LocalDate endeKurs = this.gebuchterKurs.getEndeKurs();
        if (endeKurs.isAfter(vermitteltAm))
            tagDifferenz = 0;
        tagDifferenz = Period.between(endeKurs, vermitteltAm).getDays();
        if (!this.hatJob) {
            tagDifferenz = 365;
        }
        return tagDifferenz;
    }
}