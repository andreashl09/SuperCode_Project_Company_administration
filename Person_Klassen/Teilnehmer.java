package Person_Klassen;

import java.time.LocalDate;
import java.time.Period;

import Kurs_Klassen.Kurs;

public class Teilnehmer extends Person {
    private static int idCounter = 0;
    private int id;
    private boolean hatJob;
    private LocalDate vermitteltAm = null;
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
        if (this.bewertung != 0)
            throw new IllegalArgumentException("Bewertung wurde bereits abgegeben und kann nicht geändert werden!");
        if (bewertung > 5 || bewertung < 1)
            throw new IllegalArgumentException("Bewertung nicht im Rahmen der Zulässigkeit!");
        this.bewertung = bewertung;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String newFeedback) {
        if (this.feedback != "")
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

        if (vermitteltAm == null)
            return 365;
        LocalDate endeKurs = this.gebuchterKurs.getEndeKurs();
        if (endeKurs.isAfter(vermitteltAm))
            tagDifferenz = 0;
        tagDifferenz = Period.between(vermitteltAm, endeKurs).getDays();
        if (!this.hatJob) {
            tagDifferenz = 365;
        }
        return tagDifferenz;
    }

    public void printFeedback() {
        if (bewertung != 0) {
            System.out.println(
                    "ID: " + this.getId() + " Name: " + this.getVorname() + " " + this.getNachname() + " | Kurs ID: "
                            + this.getGebuchterKurs().getId() + " - " + this.getGebuchterKurs().getName());
            System.out.println("Bewertung: " + this.bewertung);
            System.out.println("Feedback:");
            System.out.println(feedback);
        } else {
            System.out.println(
                    "ID: " + this.getId() + " Name: " + this.getVorname() + " " + this.getNachname()
                            + " hat keine Bewertung abgegeben!");
        }

    }
}