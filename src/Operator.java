import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Operator aus dem Klassendiagramm.
 * Beziehungen: "erfasst / bearbeitet" Fundmeldung, "arbeitet in" 1 Fundstation.
 */
public class Operator {

    private int operatorId;
    private String name;
    private String dienstgrad;

    private Fundstation fundstation;
    private List<Fundmeldung> bearbeiteteFundmeldungen;

    public Operator(int operatorId, String name, String dienstgrad, Fundstation fundstation) {
        this.operatorId = operatorId;
        this.name = name;
        this.dienstgrad = dienstgrad;
        this.fundstation = fundstation;
        this.bearbeiteteFundmeldungen = new ArrayList<>();
    }

    // Demo: Anmeldung gilt als erfolgreich, wenn der Name übereinstimmt
    public boolean anmelden(String benutzername, String passwort) {
        return this.name != null && this.name.equals(benutzername);
    }

    public Fundmeldung fundmeldungErfassen(String beschreibung, String fundort,
                                           LocalDateTime fundzeit, Gegenstand gegenstand) {
        Fundmeldung meldung = new Fundmeldung(
                bearbeiteteFundmeldungen.size() + 1,
                beschreibung,
                fundort,
                fundzeit,
                gegenstand
        );
        meldung.setOperator(this);
        bearbeiteteFundmeldungen.add(meldung);
        return meldung;
    }

    // Demo: Gegenstand wird an der eigenen Station eingelagert
    public void fundgegenstandAnnehmen(Gegenstand gegenstand, Fundmeldung fundmeldung) {
        fundstation.gegenstandEinlagern(gegenstand);
        fundmeldung.statusAendern("ABGEGEBEN");
    }

    // Demo: Ausweis muss vorhanden sein
    public boolean identitaetPruefen(Sucher sucher, String ausweisnummer) {
        return ausweisnummer != null && !ausweisnummer.isEmpty();
    }

    // Demo: Angaben dürfen nicht leer sein
    public boolean eigentumPruefen(Fundmeldung fundmeldung, String angaben) {
        return angaben != null && !angaben.isEmpty();
    }

    // Demo: Gegenstand wird ausgelagert und Meldung archiviert
    public void gegenstandAusgeben(Fundmeldung fundmeldung, Sucher sucher) {
        fundstation.gegenstandAuslagern(fundmeldung.getGegenstand());
        fundmeldung.archivieren();
    }

    public void vorgangArchivieren(Fundmeldung fundmeldung) {
        fundmeldung.archivieren();
    }

    public int getOperatorId() {
        return operatorId;
    }

    public String getName() {
        return name;
    }

    public String getDienstgrad() {
        return dienstgrad;
    }

    public Fundstation getFundstation() {
        return fundstation;
    }

    public List<Fundmeldung> getBearbeiteteFundmeldungen() {
        return bearbeiteteFundmeldungen;
    }
}
