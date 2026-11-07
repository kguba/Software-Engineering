# Anforderungen

## Aufgabe 1 – funktionale Anforderungen

| ID | Version | Status | Feature | Priorität | Anforderungsname | Beschreibung | Quelle |
|----|---------|--------|---------|-----------|------------------|--------------|--------|
| F010 | 1 | Entwurf | Fundmeldung | Muss | Fundgegenstand veröffentlichen | Das System muss Findern und Operatoren die Möglichkeit bieten, einen Fundgegenstand mit Beschreibung, Fundort und Fundzeit als Fundmeldung zu veröffentlichen. | UC `#02`, UC `#03`, S1, S3 |
| F020 | 1 | Entwurf | Fundmeldung | Soll | Foto hochladen | Nach dem Anlegen einer Fundmeldung muss das System Findern und Operatoren die Möglichkeit bieten, ein oder mehrere Fotos des Fundgegenstands hochzuladen. | UC `#02`, UC `#03`, S1, S3 |
| F025 | 1 | Entwurf | Fundmeldung | Muss | Fundmeldung durch Operator | Nach der Entgegennahme eines Fundgegenstands an der Dienststelle muss das System dem Operator ermöglichen, aus Formularangaben und Fotos eine Fundmeldung zu erstellen und zu veröffentlichen. | UC `#03`, S3 |
| F030 | 1 | Entwurf | Abgabe | Soll | Abgabeort vorschlagen | Nach dem Veröffentlichen einer Fundmeldung muss das System Findern die Möglichkeit bieten, sich eine nahegelegene Abgabestelle vorschlagen zu lassen. | UC `#02`, S1 |
| F040 | 1 | Entwurf | Abgabe | Muss | Fundgegenstand abgeben (Finder) | Nach dem Veröffentlichen einer Fundmeldung muss das System Findern die Möglichkeit bieten, die Abgabe des Fundgegenstands bei einer Dienststelle zu registrieren. | UC `#02`, S1 |
| F050 | 1 | Entwurf | Benachrichtigung | Soll | Besitzer benachrichtigen | Nach dem Veröffentlichen einer Fundmeldung muss das System Findern die Möglichkeit bieten, festzulegen, ob der Besitzer über den Benachrichtigungsdienst Kontakt zu ihnen aufnehmen darf. | UC `#02`, S1 |
| F060 | 1 | Entwurf | Finder Incentive | Optional | Gutschein/Rabatt als Dankeschön | Wenn ein Verlierer seinen Gegenstand zurückbekommen hat und der Vorgang abgeschlossen ist, bekommt der Finder ein Dankeschön. | S1 |

> **Hinweis:** In der Kopfzeile des Screenshots steht in der ersten Spalte „UC „Besitzer benachrichtigen", S1" statt „ID". Vermutlich ist das ein Versehen (möglicherweise die Quelle von F050). Außerdem steht dort „Feauture" statt „Feature". Beides habe ich hier korrigiert.

## Aufgabe 2 – nicht funktionale Anforderungen

| ID | Version | Quelle | Geltungsbereich | Anforderungsname | Beschreibung |
|----|---------|--------|-----------------|------------------|--------------|
| N010 | 1 | UC `#02`, UC `#03`, S1, S3 | Feature: Fundmeldung (F010, F020, F025) | Einfache Fundmeldung | Das System muss es Findern ermöglichen, eine vollständige Fundmeldung mit Foto in höchstens 2 Minuten und höchstens 5 Interaktionen zu erstellen. Operatoren müssen eine Fundmeldung an der Dienststelle aus Formular und Fotos ohne Medienbruch abschließen können. Prüfung Finder: Usability-Test mit mind. 10 Erstnutzern ohne Einweisung; erfüllt, wenn ≥ 90 % die Aufgabe ohne Hilfe im Zeitlimit schaffen. Prüfung Operator: Walkthrough anhand S3/UC `#03`. |
| N020 | 1 | S1, S2, S3 | Feature: Suche | Antwortzeit und Aktualität | Bei 500 gleichzeitigen Nutzern muss das System Suchergebnisse in 95 % der Anfragen innerhalb von 2 Sekunden liefern. Eine neu veröffentlichte Fundmeldung muss spätestens 1 Minute später auffindbar sein. Prüfung: Lasttest in einer produktionsnahen Testumgebung. |
| N030 | 1 | S1, S2, S3 | Gesamtsystem | Barrierefreiheit | Alle Bildschirme der App müssen die Kriterien der WCAG 2.1, Stufe AA erfüllen (z. B. Kontrast mind. 4,5:1, Bedienbarkeit per Screenreader, skalierbare Schrift bis 200 %). Prüfung: Automatischer Audit (z. B. axe) mit 0 kritischen Fehlern, dazu ein manueller Test mit VoiceOver/TalkBack für F010, F025, F040 und F050. |
| N040 | 1 | S1; DSGVO | Features: Fundmeldung, Benachrichtigung (F010, F050) | Anonymität des Finders | Finder und Sucher registrieren sich mit Telefonnummer und Verifizierungscode. Für Finder darf das System nur die Telefonnummer als Pflichtangabe erheben. Für Verlierer bleibt sie unsichtbar, solange der Finder keine Kontaktfreigabe erteilt hat. Spätestens 30 Tage nach Vorgangsabschluss wird sie gelöscht. Prüfung: Review des Datenmodells. Testfall: Die Verlierer-Ansicht enthält ohne Freigabe keine personenbezogenen Daten des Finders. Der Löschjob ist im Testsystem nachgewiesen. |
