package Person_Klassen;

public class Adresse {
    private String strasse;
    private String ort;
    private int plz;

    public Adresse(String newStrasse, String newOrt, int newPlz) {
        this.strasse = newStrasse;
        this.ort = newOrt;
        this.plz = newPlz;
    }

    public String printAdresse() {
        return "Strasse: " + this.strasse + " Ort: " + this.ort + " Plz: " + this.plz;
    }
}
