import java.lang.classfile.TypeAnnotation.LocalVarTarget;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kurs {
    private static int kursIdCounter;
    private int id;
    private String name;
    private LocalDate startKurs;
    private LocalDate endeKurs;
    private int anzahlKurstage = 0;
    private ArrayList<Modul> module;
    private ArrayList<Teilnehmer> teilnehmers;
    // private ArrayList<Mitarbeiter> trainers;
    private final int MAX_TEILNEHMER = 8;
    private Bildungsunternehmen unternehmen;
    private Kategorie kategorie;

    public Kurs(String name, LocalDate startKurs, Kategorie kategorie, Bildungsunternehmen unternehmen) {
        this.kategorie = kategorie;
        this.id = kursIdCounter;
        kursIdCounter++;
        this.unternehmen = unternehmen;
        this.name = name;
        this.startKurs = startKurs;
        this.endeKurs = startKurs;
        module = new ArrayList<>();
        teilnehmers = new ArrayList<>();
        // trainers = new ArrayList<>();
    }

    public void addModul(Modul modul) {
        int tageCounter = 0;
        Kategorie suchKategorie = kategorie;
        tageCounter = getAufgabenPool(tageCounter, suchKategorie);
        if (tageCounter < modul.getModulTage())
            throw new IllegalArgumentException("Nicht genügend Aufgaben für das Modul!");
        
        ermittleMitarbeiter(modul);
        this.module.add(modul);
    }

    private int getAufgabenPool(int tageCounter, Kategorie suchKategorie) {
        ArrayList<Aufgabe> aufgabenPool = unternehmen.getAufgabenPool();
        for (Aufgabe aufgabe : aufgabenPool) {
            Kategorie kategorie = aufgabe.getKategorie();
            if (suchKategorie.equals(kategorie))
                tageCounter += aufgabe.getAufgabeTage();
        }
        return tageCounter;
    }

    public void addTeilnehmer(Teilnehmer teilnehmer) {
        if (teilnehmers.size() >= MAX_TEILNEHMER)
            throw new IllegalArgumentException("Teilnehmeranzahl überschritten!");
        teilnehmers.add(teilnehmer);
    }

    public LocalDate berechneModulEnde(Modul modul) {
        LocalDate endeModul = endeKurs;
        for (int i = 0; i < modul.getModulTage() - 1; i++) {
            endeModul = endeModul.plusDays(endeModul.getDayOfWeek() == DayOfWeek.FRIDAY ? 3 : 1);
        }
        return endeModul;
    }

    public ArrayList<Mitarbeiter> ermittleLinzensiertenTrainer(Modul modul) {
        ArrayList<Mitarbeiter> verfuegbareMitarbeiter = new ArrayList<>();
        for (Mitarbeiter mitarbeiter : unternehmen.getMitarbeiterListe()) {
            ArrayList<Kategorie> mitarbeiterLizenzen = mitarbeiter.getLizenzliste();
            for (Kategorie linzenz : mitarbeiterLizenzen) {
                if (linzenz == modul.getBrauchLizenz())
                    verfuegbareMitarbeiter.add(mitarbeiter);
            }
        }
        return verfuegbareMitarbeiter;
    }

    public Mitarbeiter ermittleMitarbeiter (Modul modul) {
        Mitarbeiter zugeteilterMitarbeiter = null;
        int anzahlMinKurse = 0;
        
        for (Mitarbeiter mitarbeiter : ermittleLinzensiertenTrainer(modul)) {
            for (Buchung buchung : mitarbeiter.getBuchungen()) {
                if (mitarbeiter.getBuchungen().size() == 0)
                    return mitarbeiter;
                    
                if (endeKurs.isBefore(buchung.getStartDatum()) && startKurs.isAfter(buchung.getEndeDatum())) {
                    int anzahlKurse = mitarbeiter.getBuchungen().size();
                    if (anzahlKurse < anzahlMinKurse) {
                        anzahlMinKurse = anzahlKurse;
                        zugeteilterMitarbeiter = mitarbeiter;
                    }
                }
            }
        } 
        if (zugeteilterMitarbeiter == null)
            throw new IllegalArgumentException("Kein Mitarbeiter verfügbar!");
        return zugeteilterMitarbeiter;
    }
}
