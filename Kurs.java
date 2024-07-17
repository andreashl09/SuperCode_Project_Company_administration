
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

    public LocalDate getStartKurs() {
        return startKurs;
    }

    public LocalDate getEndeKurs() {
        return endeKurs;
    }

    public ArrayList<Modul> getModule() {
        return this.module;
    }

    public void addModul(Modul modul) {
        int tageCounter = 0;
        Kategorie suchKategorie = kategorie;
        tageCounter = getAufgabenPool(tageCounter, suchKategorie);
        if (tageCounter < modul.getModulTage())
            throw new IllegalArgumentException("Nicht genügend Aufgaben für das Modul!");
        LocalDate startModul;
        if (anzahlKurstage == 0)
            startModul = this.endeKurs;
        else
            startModul = this.endeKurs.plusDays(1);
        // bestimme das Startdatum vom Modul
        LocalDate endeModul = berechneModulEnde(modul, startModul); // bestimme das Ende vom
        // Modul
        Mitarbeiter zugeteilterMitarbeiter = ermittleMitarbeiter(modul, startModul, endeModul); // ermittle den
                                                                                                // verfügbaren
                                                                                                // Mitarbeiter
        modul.setZugeteilterMitarbeiter(zugeteilterMitarbeiter); // Mitarbeiter wird dem Modul zugeordnet
        this.endeKurs = endeModul; // legen das neue Kursende fest
        this.module.add(modul); // fügen das Modul dem Kurs hinzu
        modul.setStartModul(startModul); // geben dem Modul ein Startdatum
        modul.setEndeModul(endeModul);// geben dem Modul ein Enddatum
        Buchung buchung = new Buchung(startModul, endeModul, modul.getName()); // erstellen neue Buchung für den
                                                                               // Mitarbeiter
        zugeteilterMitarbeiter.addBuchung(buchung);// erstellte Buchung wird der Liste Buchungen Mitarbeiter hinzugefügt
        anzahlKurstage += modul.getModulTage();
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

    public LocalDate berechneModulEnde(Modul modul, LocalDate startModul) {
        LocalDate endeModul = startModul.plusDays(1);
        for (int i = 1; i < modul.getModulTage() - 1; i++) {
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

    public Mitarbeiter ermittleMitarbeiter(Modul modul, LocalDate startModul, LocalDate endeModul) {
        Mitarbeiter zugeteilterMitarbeiter = null;
        int anzahlMinKurse = 0;
        for (Mitarbeiter mitarbeiter : ermittleLinzensiertenTrainer(modul)) {
            if (mitarbeiter.getBuchungen().size() == 0)
                return mitarbeiter;
            for (Buchung buchung : mitarbeiter.getBuchungen()) {
                System.out.println("Start Modul: " + startModul + " Buchung ende:" + endeModul);
                System.out.println(startModul.isAfter(buchung.getEndeDatum()));
                System.out.println("Buchung start: " + buchung.getStartDatum()+ " Buchung ende:" + buchung.getEndeDatum());
                System.out.println(endeModul.isAfter(buchung.getStartDatum()));
                if (endeModul.isAfter(buchung.getStartDatum()) && startModul.isAfter(buchung.getEndeDatum())) {
                    int anzahlKurse = mitarbeiter.getBuchungen().size();
                    if (anzahlKurse > anzahlMinKurse) {
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
