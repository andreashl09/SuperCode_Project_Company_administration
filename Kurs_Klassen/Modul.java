package Kurs_Klassen;
import java.time.LocalDate;
import java.util.ArrayList;

import Enum.Kategorie;
import Person_Klassen.Mitarbeiter;

public class Modul {

    private static int idCounter;
    private int id;
    private String name;
    private ArrayList<Aufgabe> aufgaben;
    private int modulTage = 0;
    private Kategorie benoetigteLizenz;
    private Mitarbeiter zugeteilterMitarbeiter;
    private LocalDate startModul;
    private LocalDate endeModul;
 

    public Modul(String name, Kategorie benoetigteLizenz, int modulTage) {
        this.id = idCounter;
        idCounter++;
        setModulTage(modulTage);
        this.name = name;
        this.benoetigteLizenz = benoetigteLizenz;
        aufgaben = new ArrayList<>();
    }

    public void addAufgabe(Aufgabe aufgabe) {
        erhoeheModulTage(aufgabe);
        this.aufgaben.add(aufgabe);
    }

    private void erhoeheModulTage(Aufgabe aufgabe) {
        modulTage += aufgabe.getAufgabeTage();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    public int getModulTage() {
        return modulTage;
    }

    public Kategorie getBrauchLizenz() {
        return benoetigteLizenz;
    }

    public void setBrauchLizenz(Kategorie benoetigteLizenz) {
        this.benoetigteLizenz = benoetigteLizenz;
    }

    public void setModulTage(int modulTage) {
        if (modulTage <= 0)
            throw new IllegalArgumentException("Modultage können nicht kleiner 0 sein!");
        this.modulTage = modulTage;
    }

    public void setZugeteilterMitarbeiter(Mitarbeiter zugeteilterMitarbeiter) {
        this.zugeteilterMitarbeiter = zugeteilterMitarbeiter;
    }

    public Mitarbeiter getZugeteilterMitarbeiter() {
        return zugeteilterMitarbeiter;
    }

    public LocalDate getStartModul() {
        return startModul;
    }

    public void setStartModul(LocalDate startModul) {
        this.startModul = startModul;
    }

    public LocalDate getEndeModul() {
        return endeModul;
    }

    public void setEndeModul(LocalDate endeModul) {
        this.endeModul = endeModul;
    }
    
    

}