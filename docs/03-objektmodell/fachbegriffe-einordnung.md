# Fachbegriffe – Einordnung für das Objektmodell

Bereinigte Liste aus `substantivliste.md`: Synonyme zusammengeführt, Story-Ausschmückung und reine Technik/UI entfernt.  
Quellen: funktionale Anforderungen F010–F060, User Stories 1–3, UC `#01`–`#03`.

| ID | Begriff | Auch genannt als | Einordnung | Begründung | Fundstellen |
|---|---|---|---|---|---|
| B01 | Finder | Finderin | **Objekt** (Rolle) | Person mit eigener Identität; Telefonnummer, Freigabe | F010–F060; S1; UC `#02` |
| B02 | Sucher | Verlierer, Besitzer, Eigentümer, Suchender | **Objekt** (Rolle) | Person, die den Gegenstand sucht/zurückerhält | F050, F060; S1/S2; UC `#01`, `#03` |
| B03 | Operator | Polizist (Beruf) | **Objekt** (Rolle) | Nimmt entgegen, **erstellt Fundmeldungen**, verwahrt und gibt aus | S3; UC `#03`; F025 |
| B04 | Gegenstand | Fundgegenstand, Schlüssel, gesuchte Sache, Suchgegenstand | **Objekt** | Zentraler fachlicher Kern; Schlüssel = Beispielinstanz | F010–F060; S1–S3; UC `#01`–`#03` |
| B05 | Fundmeldung | Inserat, Fundanzeige, Eintrag, Fund | **Objekt** | Veröffentlichte Meldung; **Ersteller kann Finder oder Operator** sein; Bezug zu Gegenstand (und ggf. Finder) | F010, F020, F025; S1–S3; UC `#02`/`#03` |
| B06 | Foto | Bild | **Attribut** von Fundmeldung *(optional eigenes Objekt bei mehreren Fotos)* | Gehört zur Meldung; S3 nennt mehrere Fotos | F020; S1; S3 |
| B07 | Beschreibung | Inseratdetails | **Attribut** von Fundmeldung / Gegenstand | Textuelle Beschreibung, keine eigene Identität | F010; S1/S3; UC `#02` |
| B08 | Fundort | – | **Attribut** von Fundmeldung | Wo gefunden | F010; S1 |
| B09 | Fundzeit | – | **Attribut** von Fundmeldung | Wann gefunden | F010; S1 |
| B10 | Dienststelle | Abgabestelle, Abgabeort, Polizeistation, Polizeidienststelle, Fundstation, Filiale | **Objekt** | Ort der Abgabe/Ausgabe; Vorschlag und Abgabe beziehen sich darauf | F030, F040; S1–S3; UC `#02`/`#03` |
| B11 | Abgabe | Übergabe | **Objekt** (Vorgang) | Registrierte Abgabe/Übergabe zwischen Akteuren und Dienststelle | F040; UC `#02` Nachbedingung |
| B12 | Telefonnummer | – | **Attribut** von Finder / Sucher | Pflichtangabe bei Registrierung | S1/S2; UC `#01`/`#02`; N040 |
| B13 | Verifizierungscode | – | **Attribut** / Registrierungsschritt | Bestätigt die Telefonnummer | S1/S2; UC `#01`/`#02` |
| B14 | Kontaktfreigabe | Freigabe | **Attribut** von Fundmeldung / Finder | Optional: darf Sucher den Finder kontaktieren? | F050; S1/S2; UC `#02` |
| B15 | Verlustmeldung | – | **Objekt** *(falls Sucher-Seite modelliert)* | Gegenstück zur Fundmeldung aus Sucher-Sicht | S2 |
| B16 | Formular | – | **Objekt** oder Eingabehilfe | Operator-Erfassung vor Ort | S3; UC `#03` |
| B17 | Gutschein | Dankeschön, Gutscheincoupon, Rabatt | **Objekt** (optional) | Incentive nach erfolgreichem Vorgang | F060; S1 |
| B18 | Fundbüro | – | **Objekt** oder Organisation | Zentrale Vermittlung, wenn nicht mit Dienststelle gleichgesetzt | S2 |
| B19 | Gebühr | – | **Attribut** von Abgabe/Übergabe | Bei Ausgabe laut UC `#03` | UC `#03` |
| B20 | Kennzeichnung | – | **Attribut** von Gegenstand | Markierung in der Asservatenkammer | S3 |
| B21 | Asservatenkammer | – | **Attribut** / Teil von Dienststelle | Aufbewahrungsort, oft kein eigenes Kernobjekt | S3 |
| B22 | Profil | – | **Attribut** von Finder / Sucher | Stammdaten nach Registrierung | UC Beteiligte Systeme |

## Bewusst weggelassen

| Kategorie | Beispiele | Grund |
|---|---|---|
| Technik / UI | App, System, Found, Fenster, Button, Klick, Programm, Feld, Datenbank, Text, Meldung (UI) | Kein fachliches Kernobjekt |
| Story-Kontext | Arbeitsweg, S-Bahn, Pasing, Sitz, Fahrt, Hosentasche, Panik, Vorlesung, Hochschule, Rezeption, … | Ausschmückung, nicht modellrelevant |
| Eigennamen als Typ | Marianne, Steffen, Franz, Dame | **Instanzen** von Finder/Sucher/Operator, keine eigenen Begriffstypen |
| Redundant / Feature-Label | Incentive, Benachrichtigung (Spalte), Benachrichtigungsdienst, Story, Post, E-Mail, Antwort, Zusage | Durch obige Begriffe abgedeckt oder rein technisch/kommunikativ |

## Hinweis fürs Objektdiagramm

Mindestens vier Objekte mit konkreten Werten wählen. Zwei sinnvolle Zeitpunkte:

**A – Finder meldet selbst:** Marianne hat gemeldet und bei Pasing abgegeben  
- `marianne:Finder` · `schluessel-42:Gegenstand` · `meldung-17:Fundmeldung` · `pasing:Dienststelle`

**B – Operator erstellt die Fundmeldung:** Franz hat den Schlüssel an der Dienststelle erfasst  
- `franz:Operator` · `dame:Finder` · `schluessel-42:Gegenstand` · `meldung-18:Fundmeldung` (Ersteller = Operator) · `innenstadt:Dienststelle`
