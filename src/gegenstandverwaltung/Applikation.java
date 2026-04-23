package gegenstandverwaltung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Applikation {
    private static Scanner s = new Scanner(System.in);
    private static Person[] personen;


    public static void main(String[] args) {

        Person p1 = new Person("Anna", "Müller", 28, 'W');
        Person p2 = new Person("Max", "Mustermann", 35, 'M');
        Person p3 = new Person("Lisa", "Schmidt", 22, 'W');
        Person p4 = new Person("Tom", "Becker", 40, 'M');
        Person p5 = new Person("Mia", "Weber", 29, 'W');
        personen = new Person[] {p1, p2, p3, p4, p5};


        p1.addGegenstand(new Gegenstand("Buch", 1.0));
        p1.addGegenstand(new Gegenstand("Laptop", 2.0));
        p1.addGegenstand(new Gegenstand("Apfel", 0.5));


        p2.addGegenstand(new Gegenstand("Wasserflasche", 1.5));
        p2.addGegenstand(new Gegenstand("Regenschirm", 0.5));
        p2.addGegenstand(new Gegenstand("Jacke", 2.5));


        p3.addGegenstand(new Gegenstand("Smartphone", 0.2));
        p3.addGegenstand(new Gegenstand("Notizblock", 0.4));
        p3.addGegenstand(new Gegenstand("Kamera", 1.5));


        p4.addGegenstand(new Gegenstand("Rucksack", 1.0));
        p4.addGegenstand(new Gegenstand("Zelt", 5.0));
        p4.addGegenstand(new Gegenstand("Schlafsack", 2.0));


        p5.addGegenstand(new Gegenstand("Tablet", 0.8));
        p5.addGegenstand(new Gegenstand("Kopfhörer", 0.2));
        p5.addGegenstand(new Gegenstand("Schuhe", 2.0));


        while (true) {
            int eingabe = eingabeMenue();
            switch(eingabe) {
                case 1:
                    uebersicht();
                    break;
                case 2:
                    weitergabe();
                    break;
                case 3:
                    s.close();
                    return;
            }
            System.out.println("\n\n");
        }
    }

    private static int eingabeMenue() {
        System.out.print("1. Übersicht"
                + "\n2. Weitergabe"
                + "\n3. Ende"
                + "\nWählen Sie aus (Zahl eingeben): ");

        int eingabe = -1;
        while(true) {
            try {
                eingabe = s.nextInt();
                if(eingabe != 1 && eingabe != 2 && eingabe != 3) {
                    System.err.print("Ungültige Eingabe! Versuchen Sie nochmal: ");
                    s.next();
                } else {
                    return eingabe;
                }

            } catch(InputMismatchException ime) {
                System.err.print("Sie können nur Zahlen eingeben! Versuchen Sie nochmal: ");
                s.next();
            }
        }
    }

    private static void uebersicht() {
        System.out.println("Übersicht: ");
        for(Person p: personen) {
            p.ausgabeGegenstaende();
            System.out.println("Getragener Gewicht: " + p.getGetragenerGewicht());
            System.out.println();
        }
    }



    private static void weitergabe() {
        System.out.print("Geben Sie den Nachnamen der Person, der das Gegenstand abgeben soll: ");
        Person p1 = eingabePerson();
        if(p1.getAnzahlWeitergaben() >= 6) {
            System.err.println("Eine Person darf pro Programmdurchlauf nur 6 Gegenstände weitergeben!");
            return;
        }


        Gegenstand g = null;
        System.out.print("Geben Sie den Namen des weiter zu gebendem Gegenstandes ein: ");
        while(g == null) {
            String gname = s.next();
            g = p1.sucheGegenstand(gname);
            if(g == null)
                System.err.print("Der Name des Gegenstandes ist ungültig! Versuchen Sie nochmal: ");
        }
        System.out.print("Geben Sie den Nachnamen der Zielperson, der das Gegenstand bekommen soll: ");


        Person p2 = eingabePerson();
        boolean check = p2.addGegenstand(g);
        if(check) {
            System.out.println("Weitergabe erfolgreich!");
            p1.erhoheAnzahlWeitergaben();
        } else {
            p1.addGegenstand(g);
        }
    }



    private static Person eingabePerson() {
        while(true) {
            String nachname = s.next();
            for(Person p: personen) {
                if(p.getNachname().equals(nachname))
                    return p;
            }
            System.err.print("Der Nachname ist ungültig! Versuchen Sie nochmal: ");
        }
    }

}
