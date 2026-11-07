# Review-Erkenntnisse – Requirements Challenge

**Fallstudie:** Fundbüro-Anwendung  
**Quellen:** `docs/01-anforderungen/` (Personas, User Stories, strukturierte Anwendungsfälle, Anforderungen)  
**Methode:** Requirements Coach (Challenge-Modus), eine Fragerunde mit Teamantworten und Nachziehen der Artefakte

Dieses Dokument unterscheidet **tatsächliche Unklarheiten** (belegte Widersprüche oder Mehrdeutigkeiten in den Quellen), **offene Fragen** (noch nicht entschieden) und **mögliche Verbesserungen** (sinnvoll, aber nicht zwingend widersprüchlich).

---

## 1. Tatsächliche Unklarheiten

### U1 – Kontaktaufnahme Finder ↔ Sucher (geklärt)

- **Befund:** In Story 1 (Marianne) und `F050` war die Kontaktfreigabe optional; UC `#02` Nachbedingung forderte dagegen zwingend: „Der Sucher wurde kontaktiert“.
- **Entscheidung:** Kontaktaufnahme ist optional; ohne Freigabe läuft der Weg über die Dienststelle/das Fundbüro.
- **Umsetzung:** `User_Stories.md` (S1/S2), UC `#02` Nachbedingung und Hauptablauf Schritt 5 angepasst.

### U2 – Bedeutung von „registrieren“ (geklärt)

- **Befund:** Story/Persona und `N040` (vormals `F140`) betonten Anonymität bzw. nur Telefonnummer; UC `#01`/`#02` nannten „registriert sich“ ohne Definition. Story 2 nannte zudem eine Registrierung „mit Ausweis“.
- **Entscheidung:** Registrierung = Anmeldung mit Telefonnummer und Verifizierungscode (Finder und Sucher).
- **Umsetzung:** User Stories, UC-Hauptabläufe, `N040` angepasst.

### U3 – Kennzeichnung funktionaler vs. nichtfunktionaler IDs (geklärt)

- **Befund:** `F110`–`F140` wirkten wie fehlende Funktions-IDs (u. a. Verweise auf `F-070`/`F-080` in der Suche-NFR), obwohl die 100er-Nummern als NFRs gemeint waren.
- **Entscheidung:** NFRs beginnen mit `N`; Zehner-Nummern bleiben funktional (`F010` …).
- **Umsetzung:** `F110`→`N010`, `F120`→`N020`, `F130`→`N030`, `F140`→`N040`; irreführende Verweise auf nicht vorhandene Funktions-IDs in den NFRs bereinigt.

---

## 2. Offene Fragen

### O1 – Quellenbezug der funktionalen Anforderungen

Die Quellen von `F010`–`F040` nennen UCs wie „Fundgegenstand veröffentlichen“ / „Foto hochladen“. In `Strukturierte_Anwendungsfaelle.md` heißen die UCs `#01`–`#03` anders (z. B. „Gegenstand melden“).  
**Offen:** Sollen die UC-Namen vereinheitlicht oder die Quellenfelder auf `#01`–`#03` umgestellt werden?

### O2 – Abholung und Identitätsnachweis

Story 2: Steffen gibt an der Dienststelle „seine Daten“ an. Registrierung kennt nur Telefonnummer + Code.  
**Offen:** Welche Angaben sind bei der Ausgabe des Gegenstands Pflicht – und wie hängt das mit `N040` zusammen?

### O3 – Abgabeweg

UC `#02` nennt Fundstation oder Postversand; Stories fokussieren die Polizeidienststelle.  
**Offen:** Welche Abgabewege sind für den Lernausschnitt verbindlich, welche nur optional?

---

## 3. Mögliche Verbesserungen

### V1 – Quellen für `F050` und `F060`

Beide haben derzeit „–“ als Quelle. Verweis auf Story 1 bzw. UC `#02` würde Nachvollziehbarkeit und Reviewbarkeit verbessern.

### V2 – `N010` und Priorität von `F020`

`N010` verlangt eine „vollständige Fundmeldung mit Foto“, `F020` (Foto) ist nur „Soll“. Angleichen der Priorität oder der NFR-Formulierung würde Überprüfbarkeit erleichtern.

### V3 – Dankeschön / Finderlohn

`F060` beschreibt einen optionalen Gutschein; die frühere UC-Nachbedingung sprach von ausgezahltem Finderlohn. Nach der Klärung zu optionalem Kontakt sollte `F060` klar als nicht zwingender Abschluss von UC `#02` formuliert bzw. im UC als optionaler Nachschritt geführt werden.

---

## Kurzfazit

Drei **tatsächliche Unklarheiten** (Kontakt, Registrierung, ID-Schema) wurden im Review erkannt, entschieden und in den Artefakten nachgezogen. Drei **offene Fragen** betreffen Benennung/Quellen der UCs, Identitätsprüfung bei Ausgabe und Abgabewege. Drei **mögliche Verbesserungen** betreffen Quellenangaben, Foto-Priorität vs. `N010` und die Einordnung von `F060`.
