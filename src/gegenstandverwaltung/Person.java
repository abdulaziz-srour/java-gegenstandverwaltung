package gegenstandverwaltung;

public class Person {
    private String vorname;
    private String nachname;
    private int alter;
    private char geschlecht;
    private Gegenstand[] gegenstaende;
    private double getragenerGewicht;
    private int anzahlWeitergaben;

    public Person(String vorname, String nachname, int alter, char geschlecht) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.geschlecht = geschlecht;
        gegenstaende = new Gegenstand[5];
        getragenerGewicht = 0;
        anzahlWeitergaben = 0;
    }

    public String getNachname() {
        return nachname;
    }

    public double getGetragenerGewicht() {
        return getragenerGewicht;
    }

    public int getAnzahlWeitergaben() {
        return anzahlWeitergaben;
    }

    public boolean addGegenstand(Gegenstand g) {
        if(getragenerGewicht + g.getGewicht() > 10) {
            System.err.println("Eine Person darf nicht mehr als 10 kg gleichzeitig besitzen!");
            return false;
        }

        for(int i = 0; i < gegenstaende.length; i++) {
            if(gegenstaende[i] == null) {
                getragenerGewicht += g.getGewicht();
                gegenstaende[i] = g;
                return true;
            }
        }
        System.err.println("Eine Person darf nicht mehr als 5 Gegenstände gleichzeitig besitzen!");
        return false;
    }

    public Gegenstand sucheGegenstand(String gname) {
        if(gegenstaende.length != 0) {
            for(int i = 0; i < gegenstaende.length; i++) {
                Gegenstand g = gegenstaende[i];
                if(g != null && g.getName().equals(gname)) {
                    entfGegenstand(g, i);

                    return g;
                }
            }
        }
        return null;
    }

    private void entfGegenstand(Gegenstand gegenstand, int index) {
        getragenerGewicht -= gegenstand.getGewicht();
        gegenstaende[index] = null;
    }

    public void ausgabeGegenstaende() {
        System.out.println(vorname + " " + nachname + " hat folgende Gegenstände:");
        for(int i = 0; i < gegenstaende.length; i++) {
            if(gegenstaende[i] != null)
                System.out.println((i + 1) + ": Name: " + gegenstaende[i].getName()
                        + ", Gewicht: " + gegenstaende[i].getGewicht());
        }
    }

    public void erhoheAnzahlWeitergaben() {
        anzahlWeitergaben++;
    }
}
