import java.time.LocalDate;
import java.util.ArrayList;

public class Bildungsunternehmen {
    private String name;
    private String inhaber;
    private LocalDate gruendungdatum;
    private String unternehmensKategorie;
    private ArrayList<Person> kundenListe;
    private ArrayList<Person> mitarbeiterListe;
    private ArrayList<Aufgabe> aufgabenPool;
    private ArrayList<Kurs> kursListe;

    public Bildungsunternehmen(String name, String inhaber, LocalDate gruendungdatum, String unternehmensKategorie) {
        this.name = name;
        this.inhaber = inhaber;
        this.gruendungdatum = gruendungdatum;
        this.unternehmensKategorie = unternehmensKategorie;
        kundenListe = new ArrayList<>();
        mitarbeiterListe = new ArrayList<>();
        aufgabenPool = new ArrayList<>();
        kursListe = new ArrayList<>();
    }

    public ArrayList<Person> getKundenListe() {
        return kundenListe;
    }

    public ArrayList<Person> getMitarbeiterListe() {
        return mitarbeiterListe;
    }

    public ArrayList<Aufgabe> getAufgabenPool() {
        return aufgabenPool;
    }

    public void addAufgabe(Aufgabe aufgabe) {
        this.aufgabenPool.add(aufgabe);
    }
}
