---
name: model-to-java
description: Überträgt in Übung 4 ein selbst erstelltes, committetes UML-PNG schrittweise in lauffähiges Java; führt mit konkreten Auswahlvorschlägen durch offene Details, Test und Ergänzung. Kein Entwurf des ersten UML-Modells.
---
# Vom eigenen UML-PNG zur testbaren Java-Version

Es gelten [AGENTS.md](../../../AGENTS.md) und die [aktualisierte Durchführung für Übung 4](../../../kurs/uebung-04.md). Antworte kurz auf Deutsch und führe in kleinen Schritten. Übung 3 bleibt unverändert.

## Einmal starten

- Ermittle zuerst die Projektwurzel aus der Arbeitsbereichs-Dateiliste; lies Regeln über die tatsächlich gefundenen Pfade. Verwende vorhandenen Kontext, keine wiederholten Such- oder Leseversuche mit geratenen Pfaden.
- Eingabe ist `docs/04-klassendiagramm/klassendiagramm.png`, im Auftrag als `@docs/04-klassendiagramm/klassendiagramm.png` angehängt. Lies das Bild einmal mit der Bildfunktion. Ohne Bildzugriff anhalten und technische Hilfe benennen; kein Ersatzentwurf aus Anforderungen. Unlesbare Stellen präzise benennen, nichts erraten.
- Prüfe nur lesend, ob das aktuelle PNG auf dem Übungsbranch committet ist: jüngster PNG-Commit aus `git log -1 --format=%H -- <PNG-Pfad>`, Zugehörigkeit zu `HEAD`, identischer Arbeitsdatei-Blob und keine vorgemerkte PNG-Änderung. Ermittle die Commit-ID selbst, verlange sie nicht routinemäßig vom Team. Fehlt der Commit, erkläre den nötigen studentischen Schritt einmal und warte. Bei Erfolg genügt „PNG committet und lesbar“. Prüfe erneut nur bei geändertem Bild oder Git-Stand. Eigenständige Urheberschaft verantwortet das Team; Git beweist sie nicht.
- Übernimm die beauftragten Klassen. „Alle Klassen“ oder „die Klassen im Bild“ gilt als Auswahl; verlange keine künstliche Reduktion. Zwei bis drei Klassen sind eine Einstiegsempfehlung, keine Obergrenze. Bei größerem Umfang teile die Umsetzung in lauffähige Etappen. Lies vorhandenen Zielcode vor Änderungen; keine Anforderungen oder Personas nachladen.

## Eine einfache erste Version ermöglichen

Standard ist eine **lauffähige Demonstration** mit `Main.java`. Wünscht das Team ausdrücklich nur die Struktur, übertrage zunächst Klassen, Attribute und Beziehungen und kennzeichne offene Methoden. Frage nicht zusätzlich nach dem Arbeitsmodus, wenn der Auftrag ihn bereits klärt.

Lies Namen, Typen, Sichtbarkeiten, Signaturen und Assoziationen samt Multiplizitäten. Das PNG darf Lücken oder Fehler enthalten. Benenne konkrete Hindernisse bei der technischen Übertragung; verlange kein vorab perfektioniertes Modell und beginne kein umfassendes UML-Review. Eindeutige Teile können bereits implementiert und getestet werden. Das ursprüngliche PNG bleibt erhalten; für jeden Code-Schritt ist kein neuer Modell-Commit nötig.

Technische Hilfen wie Konstruktoren, Objektreferenzen, eine Standardbibliotheks-Liste oder Testdaten in `Main` darfst du im beauftragten Umfang selbst wählen und kurz erklären. Bei offenen, für diese Etappe nicht benötigten Methoden sind klar markierte Platzhalter zulässig: etwa `UnsupportedOperationException("Noch nicht umgesetzt")` bei bekannter Signatur. Behaupte dafür keine fachliche Umsetzung. Platzhalter dürfen die erste Kompilierung und den demonstrierten Ablauf nicht verhindern; benötigte unbekannte Typen sind vorab zu klären.

## Konkret auswählen statt wiederholt abstrakt fragen

Sammle nur die Blocker der nächsten Etappe in **einer kurzen Runde mit höchstens drei Themen**. Biete pro Thema zwei bis drei einfache, konkrete Möglichkeiten und markiere eine Empfehlung. Beispiel:

> Preis für die Demo: A – fester Beispielwert 2,50 Euro, noch keine Tarifberechnung (empfohlen); B – Methode zunächst zurückstellen; C – eigene Regel nennen. Antwort zum Beispiel: „Preis A“.

Für nicht definierte Typen kannst du eine vorläufige Abbildung auf einen Standardtyp oder das Zurückstellen des betroffenen Elements zur Auswahl stellen. Nenne die konkrete Abweichung vom PNG. Für größere Lücken darfst du einen kleinen zusammenhängenden Demo-Ablauf vorschlagen, ohne neue fachliche Anforderungen oder Klassen einzuführen.

Warte auf eine **ausdrückliche Auswahl** für Demo-Fachverhalten, vorläufige Typabbildungen und andere Modellabweichungen. Eine Vorbelegung oder pauschales „Accept“ ersetzt sie nicht. „Simulation“ oder „Dummy-Daten“ ohne Festlegung löst einen konkreten Vorschlag aus, keine weitere offene Frage nach einer vollständigen Fachregel. Nimm bestätigte Entscheidungen an, fasse sie in einem Satz zusammen und setze sie ohne zusätzliche Bestätigungsrunde um. Bereits zurückgestellte Methoden nicht erneut diskutieren. Sind noch Angaben nötig, frage nur nach dem verbleibenden konkreten Hindernis; stelle die ganze Runde nicht erneut.

## Implementieren, testen, reviewen, ergänzen

- Implementiere die erste kleine lauffähige Version in `src/`, möglichst ohne Packages. Nur einfache Assoziationen, Java-Grundlagen und Standardbibliothek. Keine Vererbung, Interfaces, abstrakten Klassen, Design Patterns, Datenbanken, Frameworks oder ungefragten zusätzlichen fachlichen Klassen und Anforderungen. Bewahre vorhandenen studentischen Code außerhalb des Auftrags.
- Kennzeichne vereinbarte Demo-Werte, vorläufige Abbildungen und offene Methoden mit kurzen Kommentaren am Code. Keine stillschweigend erfundenen Fachregeln oder fingierten Erfolgsergebnisse. Bilde geklärte Multiplizitäten nachvollziehbar ab; eine Liste allein erzwingt keine Mindestanzahl oder Gegenrichtung. Noch nicht umgesetzte Regeln offen nennen.
- `Main.java` enthält `public static void main(String[] args)` und einen nachvollziehbaren Ablauf. Ziel sind mindestens zwei Objekte, eine modellierte Beziehung, zwei Methodenaufrufe und Ausgaben mit `System.out.println(...)`. Demonstriere zuerst die bereits umgesetzten Teile; noch offene Lernziele benennen und in einer nächsten Etappe ergänzen.
- Kompiliere und starte jede neue Etappe, etwa `javac -encoding UTF-8 src/*.java` und `java -cp src Main`. Prüfe den Demo-Ablauf und einen passenden Randfall, soweit Verhalten festgelegt ist. Keine Abhängigkeiten installieren; fehlendes JDK oder fehlgeschlagene Befehle ehrlich berichten. Ein laufender Demo-Ablauf beweist keine vollständige fachliche Umsetzung.
- Übergib kurz: **Was läuft? Was ist Demo/offen? Was soll das Team jetzt testen?** Nenne tatsächlich ausgeführte Tests. Gib einen konkreten nächsten Schritt zur Wahl, etwa „A: Statusverhalten ergänzen; B: zuerst eure Testergebnisse besprechen“. Warte auf studentischen Test/Review oder Fortsetzungsauftrag, bevor du die nächste Etappe beginnst. Verlange keine erneute Entscheidung über bereits geklärte Punkte.

Das Team vergleicht Code und PNG, erklärt den Ablauf ohne KI und entscheidet über Ergänzungen. Führe keinen Commit, Push oder Merge aus. Der eigene Modell-Commit und die folgenden Code-Commits bleiben getrennt.

## Später: Ist-Diagramm aus geprüftem Code

Nur auf einen **eigenen ausdrücklichen Folgeauftrag** darfst du die tatsächlich implementierten Klassen, Attribute, Methoden und Beziehungen als separates Ist-Klassendiagramm ableiten, beispielsweise in `docs/04-klassendiagramm/klassendiagramm-aus-code.md` mit Mermaid. Lies dafür nur den benannten, geprüften Java-Code. Keine neuen Elemente, fachlichen Verbesserungen oder unbelegten Multiplizitäten ergänzen. Dokumentiere nicht ableitbare Angaben als offen. Das erste PNG und die Modelle aus Übung 3 bleiben unverändert. Das Team prüft die Ableitung und begründet Unterschiede zum ursprünglichen Modell selbst.
