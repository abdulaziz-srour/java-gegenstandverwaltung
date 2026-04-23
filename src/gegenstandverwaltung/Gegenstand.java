package gegenstandverwaltung;

public class Gegenstand {
    private String name;
    private double gewicht;

    public Gegenstand(String name, double gewicht) {
        this.name = name;
        this.gewicht = gewicht;
    }

    public String getName() {
        return name;
    }

    public double getGewicht() {
        return gewicht;
    }
}
