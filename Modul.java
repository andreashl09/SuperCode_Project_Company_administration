import java.util.ArrayList;

public class Modul {

    private String name;
    private ArrayList<Aufgabe> aufgaben;
    private int modulTage = 0;
    private String brauchLizenz;
 

    public Modul(String name, String brauchLizenz, int modulTage) {
        setModulTage(modulTage);
        this.name = name;
        this.brauchLizenz = brauchLizenz;
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

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    public int getModulTage() {
        return modulTage;
    }

    public String getBrauchLizenz() {
        return brauchLizenz;
    }

    public void setBrauchLizenz(String brauchLizenz) {
        this.brauchLizenz = brauchLizenz;
    }

    public void setModulTage(int modulTage) {
        if (modulTage <= 0)
            throw new IllegalArgumentException("Modultage können nicht kleiner 0 sein!");
        this.modulTage = modulTage;
    }

}