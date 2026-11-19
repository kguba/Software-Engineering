import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Fundstation aus dem Klassendiagramm.
 * Beziehung: Fundstation "verwahrt" 0..* Gegenstand.
 */
public class Fundstation {

    private int stationId;
    private String name;
    private String typ;
    private String adresse;
    private String lagerort;
    private String oeffnungszeiten;

    private List<Gegenstand> gegenstaende;

    public Fundstation(int stationId, String name, String typ,
                       String adresse, String lagerort, String oeffnungszeiten) {
        this.stationId = stationId;
        this.name = name;
        this.typ = typ;
        this.adresse = adresse;
        this.lagerort = lagerort;
        this.oeffnungszeiten = oeffnungszeiten;
        this.gegenstaende = new ArrayList<>();
    }

    public void gegenstandEinlagern(Gegenstand gegenstand) {
        if (gegenstand == null) {
            throw new IllegalArgumentException("Gegenstand darf nicht null sein.");
        }
        if (!gegenstaende.contains(gegenstand)) {
            gegenstaende.add(gegenstand);
            gegenstand.setFundstation(this);
        }
    }

    public void gegenstandAuslagern(Gegenstand gegenstand) {
        gegenstaende.remove(gegenstand);
        gegenstand.setFundstation(null);
    }

    // Platzhalter: echte Entfernungsberechnung ist im Modell nicht festgelegt
    public double entfernungBerechnen(String standort) {
        throw new UnsupportedOperationException("Noch nicht umgesetzt");
    }

    // Platzhalter: Öffnungszeiten-Prüfung ist im Modell nicht festgelegt
    public boolean istGeoeffnet(LocalDateTime zeitpunkt) {
        throw new UnsupportedOperationException("Noch nicht umgesetzt");
    }

    public int getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public String getTyp() {
        return typ;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getLagerort() {
        return lagerort;
    }

    public String getOeffnungszeiten() {
        return oeffnungszeiten;
    }

    public List<Gegenstand> getGegenstaende() {
        return gegenstaende;
    }
}
