/**
 * Gegenstand aus dem Klassendiagramm.
 * Beziehungen: gehört zu 1 Fundmeldung, wird von 0..1 Fundstation verwahrt.
 */
public class Gegenstand {

    private int gegenstandId;
    private String bezeichnung;
    private String kategorie;
    private String farbe;
    private String kennzeichnung;
    private String zustand;

    private Fundmeldung fundmeldung;
    private Fundstation fundstation;

    public Gegenstand(int gegenstandId, String bezeichnung, String kategorie,
                      String farbe, String kennzeichnung, String zustand) {
        this.gegenstandId = gegenstandId;
        this.bezeichnung = bezeichnung;
        this.kategorie = kategorie;
        this.farbe = farbe;
        this.kennzeichnung = kennzeichnung;
        this.zustand = zustand;
    }

    public void kennzeichnen(String kennzeichnung) {
        this.kennzeichnung = kennzeichnung;
    }

    public void zustandAktualisieren(String zustand) {
        this.zustand = zustand;
    }

    // Demo: fasst die Attribute zu einem lesbaren Text zusammen
    public String getBeschreibung() {
        return bezeichnung + " (" + farbe + ", Kategorie: " + kategorie
                + ", Zustand: " + zustand + ", Kennzeichnung: " + kennzeichnung + ")";
    }

    void setFundmeldung(Fundmeldung fundmeldung) {
        this.fundmeldung = fundmeldung;
    }

    void setFundstation(Fundstation fundstation) {
        this.fundstation = fundstation;
    }

    public Fundmeldung getFundmeldung() {
        return fundmeldung;
    }

    public Fundstation getFundstation() {
        return fundstation;
    }

    public int getGegenstandId() {
        return gegenstandId;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getKennzeichnung() {
        return kennzeichnung;
    }

    public String getZustand() {
        return zustand;
    }
}
