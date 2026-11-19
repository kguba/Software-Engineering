import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Fundmeldung aus dem Klassendiagramm.
 * Zentrale Beziehung in der Demo: "beschreibt" genau 1 Gegenstand.
 */
public class Fundmeldung {

    private int fundmeldungId;
    private String beschreibung;
    private String fundort;
    private LocalDateTime fundzeit;   // DateTime -> LocalDateTime
    private List<String> fotoUrls;
    private boolean kontaktfreigabe;
    private String status;
    private LocalDateTime erstelltAm;

    // Assoziationen aus dem Diagramm
    private Gegenstand gegenstand;                 // beschreibt (1)
    private Finder finder;                         // erstellt von (0..1)
    private Operator operator;                     // erfasst / bearbeitet von (0..1)
    private Sucher reserviertVon;                  // reserviert (0..1)
    private List<Verlustmeldung> passendeVerlustmeldungen; // passt zu (0..*)

    public Fundmeldung(int fundmeldungId, String beschreibung, String fundort,
                       LocalDateTime fundzeit, Gegenstand gegenstand) {
        if (gegenstand == null) {
            throw new IllegalArgumentException("Eine Fundmeldung braucht genau einen Gegenstand.");
        }
        if (gegenstand.getFundmeldung() != null) {
            throw new IllegalArgumentException("Der Gegenstand ist bereits einer Fundmeldung zugeordnet.");
        }
        this.fundmeldungId = fundmeldungId;
        this.beschreibung = beschreibung;
        this.fundort = fundort;
        this.fundzeit = fundzeit;
        this.fotoUrls = new ArrayList<>();
        this.kontaktfreigabe = false;
        this.status = "ERSTELLT"; // Demo-Startwert
        this.erstelltAm = LocalDateTime.now();
        this.gegenstand = gegenstand;
        this.passendeVerlustmeldungen = new ArrayList<>();
        gegenstand.setFundmeldung(this);
    }

    public void fotoHochladen(String fotoUrl) {
        fotoUrls.add(fotoUrl);
    }

    // Demo: setzt nur den Status
    public boolean veroeffentlichen() {
        status = "VEROEFFENTLICHT";
        return true;
    }

    public void setKontaktfreigabe(boolean freigabe) {
        this.kontaktfreigabe = freigabe;
    }

    // Demo: Reservierung nur, wenn noch niemand reserviert hat
    public boolean reservieren(Sucher sucher) {
        if (sucher == null) {
            return false;
        }
        if (reserviertVon != null) {
            return false;
        }
        this.reserviertVon = sucher;
        this.status = "RESERVIERT";
        return true;
    }

    public void statusAendern(String neuerStatus) {
        this.status = neuerStatus;
    }

    public void archivieren() {
        status = "ARCHIVIERT";
    }

    public void loeschen() {
        status = "GELOESCHT";
    }

    // Platzhalter: Ablauffrist ist im Modell nicht festgelegt
    public boolean istAbgelaufen() {
        throw new UnsupportedOperationException("Noch nicht umgesetzt");
    }

    void setFinder(Finder finder) {
        this.finder = finder;
    }

    void setOperator(Operator operator) {
        this.operator = operator;
    }

    void passendeVerlustmeldungHinzufuegen(Verlustmeldung verlustmeldung) {
        if (!passendeVerlustmeldungen.contains(verlustmeldung)) {
            passendeVerlustmeldungen.add(verlustmeldung);
        }
    }

    public int getFundmeldungId() {
        return fundmeldungId;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getFundort() {
        return fundort;
    }

    public LocalDateTime getFundzeit() {
        return fundzeit;
    }

    public List<String> getFotoUrls() {
        return fotoUrls;
    }

    public boolean isKontaktfreigabe() {
        return kontaktfreigabe;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getErstelltAm() {
        return erstelltAm;
    }

    public Gegenstand getGegenstand() {
        return gegenstand;
    }

    public Finder getFinder() {
        return finder;
    }

    public Operator getOperator() {
        return operator;
    }

    public Sucher getReserviertVon() {
        return reserviertVon;
    }

    public List<Verlustmeldung> getPassendeVerlustmeldungen() {
        return passendeVerlustmeldungen;
    }
}
