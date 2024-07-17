
import java.time.LocalDate;

public class Buchung {
    private LocalDate startDatum;
    private LocalDate endeDatum;
    private String name;

    public Buchung(LocalDate startDatum, LocalDate endeDatum, String name) {
        this.startDatum = startDatum;
        this.endeDatum = endeDatum;
        this.name = name;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public LocalDate getEndeDatum() {
        return endeDatum;
    }

    public String getName() {
        return name;
    }

    public String printBuchung() {
        return "Modul: " +this.name + "Start: " + this.startDatum + " Ende: " + this.endeDatum; 
    }

}
