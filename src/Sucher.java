import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Sucher aus dem Klassendiagramm.
 * Beziehungen: "erstellt" Verlustmeldung, "reserviert" Fundmeldung.
 */
public class Sucher {

    private int sucherId;
    private String vorname;
    private String nachname;
    private String telefonnummer;
    private String email;
    private boolean ausweisVerifiziert;

    private List<Verlustmeldung> verlustmeldungen;
    private List<Fundmeldung> reservierteFundmeldungen;

    public Sucher(int sucherId, String vorname, String nachname,
                  String telefonnummer, String email, boolean ausweisVerifiziert) {
        this.sucherId = sucherId;
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.ausweisVerifiziert = ausweisVerifiziert;
        this.verlustmeldungen = new ArrayList<>();
        this.reservierteFundmeldungen = new ArrayList<>();
    }

    // Demo: speichert die Stammdaten
    public boolean registrieren(String vorname, String nachname, String email, String ausweisnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        return true;
    }

    // Demo: Anmeldung gilt als erfolgreich, wenn die E-Mail übereinstimmt
    public boolean anmelden(String email, String passwort) {
        return this.email != null && this.email.equals(email);
    }

    public Verlustmeldung verlustmeldungErstellen(String gegenstandsart, String beschreibung,
                                                  String verlustort, LocalDateTime verlustzeit) {
        Verlustmeldung meldung = new Verlustmeldung(
                verlustmeldungen.size() + 1,
                gegenstandsart,
                beschreibung,
                verlustort,
                verlustzeit,
                this
        );
        verlustmeldungen.add(meldung);
        return meldung;
    }

    // Platzhalter: Suche über alle Fundmeldungen braucht noch eine zentrale Liste
    public List<Fundmeldung> fundmeldungenDurchsuchen(String suchbegriff, String ort) {
        throw new UnsupportedOperationException("Noch nicht umgesetzt");
    }

    public boolean fundReservieren(Fundmeldung fundmeldung) {
        boolean ok = fundmeldung.reservieren(this);
        if (ok) {
            reservierteFundmeldungen.add(fundmeldung);
        }
        return ok;
    }

    // Demo: Kontakt funktioniert nur bei freigegebenem Kontakt
    public boolean finderKontaktieren(Fundmeldung fundmeldung, String nachricht) {
        return fundmeldung.isKontaktfreigabe();
    }

    public int getSucherId() {
        return sucherId;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAusweisVerifiziert() {
        return ausweisVerifiziert;
    }

    public List<Verlustmeldung> getVerlustmeldungen() {
        return verlustmeldungen;
    }

    public List<Fundmeldung> getReservierteFundmeldungen() {
        return reservierteFundmeldungen;
    }
}
