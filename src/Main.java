import java.time.LocalDateTime;

/**
 * Einfacher Test: genau zwei Objekte + eine Beziehung aus dem Diagramm.
 * Alle Klassen aus dem PNG liegen in src/ bereit.
 */
public class Main {

    public static void main(String[] args) {

        // Genau zwei Objekte für den Test
        Gegenstand schluessel = new Gegenstand(
                1, "Schlüsselbund", "Schlüssel", "silber", "keine", "gut"
        );

        Fundmeldung meldung = new Fundmeldung(
                100,
                "Drei Schlüssel an einem Ring",
                "S-Bahn Pasing",
                LocalDateTime.of(2026, 11, 17, 14, 30),
                schluessel
        );

        // Beziehung: Fundmeldung "beschreibt" Gegenstand
        System.out.println("--- Test mit 2 Objekten ---");
        System.out.println("Gegenstand: " + schluessel.getBeschreibung());
        System.out.println("Fundmeldung-ID: " + meldung.getFundmeldungId()
                + ", Status: " + meldung.getStatus());
        System.out.println("Beziehung: Meldung beschreibt -> "
                + meldung.getGegenstand().getBezeichnung());

        // Zwei Methodenaufrufe
        schluessel.kennzeichnen("Anhänger 'M.K.'");
        System.out.println("Nach kennzeichnen(): " + schluessel.getBeschreibung());

        boolean ok = meldung.veroeffentlichen();
        System.out.println("Nach veroeffentlichen(): " + ok
                + ", Status: " + meldung.getStatus());

        // Randfall: derselbe Gegenstand darf nicht nochmal gemeldet werden
        System.out.println("--- Randfall ---");
        try {
            new Fundmeldung(101, "Doppelte Meldung", "Hauptbahnhof",
                    LocalDateTime.now(), schluessel);
        } catch (IllegalArgumentException e) {
            System.out.println("Erwarteter Fehler: " + e.getMessage());
        }
    }
}
