import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Finder aus dem Klassendiagramm.
 * Beziehung: Finder "erstellt" 0..* Fundmeldung.
 */
public class Finder {

    private int finderId;
    private String telefonnummer;
    private boolean anonym;

    // Assoziation "erstellt"
    private List<Fundmeldung> fundmeldungen;

    public Finder(int finderId, String telefonnummer, boolean anonym) {
        this.finderId = finderId;
        this.telefonnummer = telefonnummer;
        this.anonym = anonym;
        this.fundmeldungen = new ArrayList<>();
    }

    // Demo: speichert nur die Telefonnummer
    public boolean registrieren(String telefonnummer) {
        this.telefonnummer = telefonnummer;
        return true;
    }

    // Demo: Anmeldung gilt als erfolgreich, wenn die Nummer übereinstimmt
    public boolean anmelden(String telefonnummer, String code) {
        return this.telefonnummer != null && this.telefonnummer.equals(telefonnummer);
    }

    public Fundmeldung fundmeldungErstellen(String beschreibung, String fundort,
                                            LocalDateTime fundzeit, Gegenstand gegenstand) {
        Fundmeldung meldung = new Fundmeldung(
                fundmeldungen.size() + 1,
                beschreibung,
                fundort,
                fundzeit,
                gegenstand
        );
        meldung.setFinder(this);
        fundmeldungen.add(meldung);
        return meldung;
    }

    // Platzhalter: Suche nach Abgabeorten ist noch nicht umgesetzt
    public List<Fundstation> abgabeorteAnzeigen(String standort) {
        throw new UnsupportedOperationException("Noch nicht umgesetzt");
    }

    // Demo: Gegenstand wird in der Station eingelagert
    public void fundmeldungAbgeben(Fundmeldung fundmeldung, Fundstation station) {
        station.gegenstandEinlagern(fundmeldung.getGegenstand());
    }

    public int getFinderId() {
        return finderId;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public boolean isAnonym() {
        return anonym;
    }

    public List<Fundmeldung> getFundmeldungen() {
        return fundmeldungen;
    }
}
