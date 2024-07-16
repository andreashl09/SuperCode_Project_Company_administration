import java.time.LocalDate;
import java.util.ArrayList;

public class Kurs {
    private static int kursIdCounter;
    private int id;
    private String name;
    private LocalDate startKurs;
    private LocalDate endKurs;
    private int anzahlKurstage = 0;
    private ArrayList<Modul> module;
    private ArrayList<Teilnehmer> teilnehmers;
    private ArrayList<Mitarbeiter> trainers;
    private final int MAX_TEILNEHMER = 8;
    private Bildungsunternehmen unternehmen;

    public Kurs(String name, LocalDate startKurs, Bildungsunternehmen unternehmen) {
        this.id = kursIdCounter;
        kursIdCounter++;
        this.unternehmen = unternehmen;
        this.name = name;
        this.startKurs = startKurs;
        module = new ArrayList<>();
        teilnehmers = new ArrayList<>();
        trainers = new ArrayList<>();
        Test = new ArrayList<>();
    }

    public void addModul(Modul modul) {
        int tageCounter = 0;
        String suchKategorie = modul.getName();
        ArrayList<Aufgabe> aufgabenPool = unternehmen.getAufgabenPool();
        for (Aufgabe aufgabe : aufgabenPool) {
            String kategorie = aufgabe.getKategorie();
            if (suchKategorie.equals(kategorie))
                tageCounter += aufgabe.getAufgabeTage();
        }
        if (tageCounter < modul.getModulTage())
            throw new IllegalArgumentException("Nicht genügend Aufgaben für das Modul!");
        this.module.add(modul);

    }

    public void addTeilnehmer(Teilnehmer teilnehmer) {
        if (teilnehmers.size() >= MAX_TEILNEHMER)
            throw new IllegalArgumentException("Teilnehmeranzahl überschritten!");
        teilnehmers.add(teilnehmer);
    }
}
