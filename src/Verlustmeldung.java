import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Verlustmeldung aus dem Klassendiagramm.
 * Beziehungen: gehört zu 1 Sucher, "passt zu" 0..* Fundmeldung.
 */
public class Verlustmeldung {

    private int verlustmeldungId;
    private String gegenstandsart;
    private String beschreibung;
    private String verlustort;
    private LocalDateTime verlustzeit; // DateTime -> LocalDateTime (wie bei Fundmeldung)
    private List<String> fotoUrls;
    private String status;

    private Sucher sucher;
    private List<Fundmeldung> passendeFundmeldungen;

    public Verlustmeldung(int verlustmeldungId, String gegenstandsart, String beschreibung,
                          String verlustort, LocalDateTime verlustzeit, Sucher sucher) {
        if (sucher == null) {
            throw new IllegalArgumentException("Eine Verlustmeldung braucht genau einen Sucher.");
        }
        this.verlustmeldungId = verlustmeldungId;
        this.gegenstandsart = gegenstandsart;
        this.beschreibung = beschreibung;
        this.verlustort = verlustort;
        this.verlustzeit = verlustzeit;
        this.fotoUrls = new ArrayList<>();
        this.status = "ERSTELLT"; // Demo-Startwert
        this.sucher = sucher;
        this.passendeFundmeldungen = new ArrayList<>();
    }

    public void bearbeiten(String gegenstandsart, String beschreibung,
                           String verlustort, LocalDateTime verlustzeit) {
        this.gegenstandsart = gegenstandsart;
        this.beschreibung = beschreibung;
        this.verlustort = verlustort;
        this.verlustzeit = verlustzeit;
    }

    public void fotoHochladen(String fotoUrl) {
        fotoUrls.add(fotoUrl);
    }

    // Platzhalter: Treffersuche über alle Fundmeldungen ist noch nicht umgesetzt
    public List<Fundmeldung> trefferSuchen() {
        throw new UnsupportedOperationException("Noch nicht umgesetzt");
    }

    // Demo: speichert die Zuordnung "passt zu"
    public boolean mitFundAbgleichen(Fundmeldung fundmeldung) {
        if (fundmeldung == null) {
            return false;
        }
        if (!passendeFundmeldungen.contains(fundmeldung)) {
            passendeFundmeldungen.add(fundmeldung);
            fundmeldung.passendeVerlustmeldungHinzufuegen(this);
        }
        status = "ABGEGLICHEN";
        return true;
    }

    public void archivieren() {
        status = "ARCHIVIERT";
    }

    public void loeschen() {
        status = "GELOESCHT";
    }

    public int getVerlustmeldungId() {
        return verlustmeldungId;
    }

    public String getGegenstandsart() {
        return gegenstandsart;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public String getVerlustort() {
        return verlustort;
    }

    public LocalDateTime getVerlustzeit() {
        return verlustzeit;
    }

    public List<String> getFotoUrls() {
        return fotoUrls;
    }

    public String getStatus() {
        return status;
    }

    public Sucher getSucher() {
        return sucher;
    }

    public List<Fundmeldung> getPassendeFundmeldungen() {
        return passendeFundmeldungen;
    }
}
