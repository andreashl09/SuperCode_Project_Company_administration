import java.time.LocalDate;
import java.util.ArrayList;

public class Bildungsunternehmen {
    private String name;
    private String inhaber;
    private LocalDate gruendungdatum;
    private UnternehmensKategorie unternehmensKategorie;
    private ArrayList<Teilnehmer> kundenListe;
    private ArrayList<Mitarbeiter> mitarbeiterListe;
    private ArrayList<Aufgabe> aufgabenPool;
    private ArrayList<Kurs> kursListe;

    public Bildungsunternehmen(String name, String inhaber, LocalDate gruendungdatum, UnternehmensKategorie kategorie) {
        this.name = name;
        this.inhaber = inhaber;
        this.gruendungdatum = gruendungdatum;
        this.unternehmensKategorie = kategorie;
        kundenListe = new ArrayList<>();
        mitarbeiterListe = new ArrayList<>();
        aufgabenPool = new ArrayList<>();
        kursListe = new ArrayList<>();
    }

    public ArrayList<Teilnehmer> getKundenListe() {
        return kundenListe;
    }

    public ArrayList<Mitarbeiter> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public ArrayList<Aufgabe> getAufgabenPool() {
        return aufgabenPool;
    }

    public void addAufgabe(Aufgabe aufgabe) {
        this.aufgabenPool.add(aufgabe);
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiterListe.add(mitarbeiter);
    }

    public ArrayList<Kurs> getKursListe() {
        return kursListe;
    }


}
