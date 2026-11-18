# Übung 4 – Klassendiagramm und Java, WS 2026/27

Grundlage ist das aktuelle [Übungsblatt 4](Übungsblatt4_SWE1_2627.pdf), Aufgaben 1–5. Für die Git-Schritte gelten das [Git-Zusatzblatt](Git_Anlage_Übungsblatt4_SWE1_2627.pdf) und die ergänzte [Anleitung zur Git-Teamarbeit](git-teamarbeit.md). Die Freigaben aus [Übung 3](uebung-03.md) bleiben unverändert. Die Aufgaben gelten für Fundbüro, Verleih-Plattform und Repair-Café.

**Aktualisierte Durchführung:** Für die Java-Aufgabe gilt ergänzend zum PDF der folgende iterative Ablauf. Zwei bis drei Klassen sind eine Einstiegsempfehlung statt einer festen Obergrenze. Eine erste testbare Demo darf ausdrücklich gewählte Vereinfachungen und markierte Lücken enthalten. Sie wird nach Test und Review schrittweise vervollständigt. Ein separates Ist-Diagramm kann später aus dem geprüften Code abgeleitet werden. Das verlinkte PDF enthält noch die ursprüngliche engere Durchführung; die Änderungen sind hier ausdrücklich freigegeben.

## 1. Teamstand vorbereiten

Sichern Sie zuerst die bisherigen Ergebnisse im eigenen Team-Repository. Übernehmen Sie vor jeder Übung die aktuelle Lehrvorlage in `main` und erstellen Sie danach gemeinsam einen Übungsbranch, beispielsweise `uebung-04-team`. Die genauen Befehle und Stopps bei Problemen stehen in der Git-Anleitung.

## 2. Klassendiagramm eigenständig erstellen

**Das erste Klassendiagramm, seine fachliche Prüfung und die zugehörigen Modellierungsentscheidungen entstehen ohne KI-Unterstützung.** Der Java-Skill erstellt keinen fachlichen Erstentwurf. Lücken oder Fehler werden möglicherweise erst beim Implementieren sichtbar; ein perfektes Diagramm ist keine Voraussetzung für den nächsten Schritt.

Leiten Sie aus Ihrem Objektdiagramm aus Übung 3 zunächst einen zentralen Ausschnitt Ihres Anwendungsfalls mit **drei bis vier fachlich wichtigen Klassen** ab:

1. Beginnen Sie nur mit Klassennamen und einfachen binären Assoziationen. Übernehmen beziehungsweise überarbeiten Sie die Beziehungsnamen selbst. Keine Vererbung, Aggregation oder Komposition.
2. Tragen Sie an beiden Assoziationsenden Multiplizitäten ein und begründen Sie diese für eine ausgewählte Assoziation anhand Ihres Anwendungsfalls.
3. Erstellen Sie eine Kopie der ersten Fassung. Ergänzen Sie wichtige Attribute mit Datentypen und Sichtbarkeiten sowie fachlich sinnvolle Methoden mit Sichtbarkeit, Rückgabetyp (`void`, wenn kein Rückgabewert) und gegebenenfalls Parametern. Prüfen Sie die Verantwortlichkeiten selbst.

Nutzen Sie nur bisher behandelte Grundlagen der objektorientierten Programmierung. Vererbung, Interfaces, abstrakte Klassen und Design Patterns sind ausgeschlossen.

## 3. Lesbares PNG sichern – vor Copilot

Exportieren Sie das detaillierte Diagramm aus Ihrem Modellierungswerkzeug nach:

`docs/04-klassendiagramm/klassendiagramm.png`

Prüfen Sie selbst, dass sich das PNG öffnen lässt und Klassennamen, Attribute, Methoden, Beziehungsnamen und Multiplizitäten vollständig lesbar sind. Schneiden Sie Werkzeugleisten und große leere Ränder ab; vermeiden Sie unnötig große Bilder. Bewahren Sie auch die erste Fassung und Ihre Begründung im Modellordner auf.

Erstellen Sie **selbst einen Modellierungs-Commit auf dem Übungsbranch**, bevor Sie Copilot einsetzen. Beispiel im normalen IDE-Terminal:

```bash
git status
git add docs/04-klassendiagramm/
git diff --cached
git commit -m "Eigenes Klassendiagramm fuer Uebung 4"
git push origin uebung-04-team
```

Prüfen Sie vor dem Commit die vorgemerkten Dateien. Modell und spätere Implementierung müssen in getrennten Commits nachvollziehbar bleiben.

## 4. Mit einer lauffähigen Java-Version beginnen

Erst nach dem Modellierungs-Commit ist KI für die Java-Implementierung freigegeben. Starten Sie im Projektordner eine **neue Copilot-CLI-Sitzung** mit `copilot`. Zwei bis drei zusammenhängende Klassen sind eine Empfehlung für den Einstieg. Sie dürfen auch alle Klassen Ihres kleinen Diagramms beauftragen; eine künstliche Reduktion ist nicht nötig. Bei größerem Umfang erfolgt die Umsetzung in lauffähigen Etappen.

Beispielauftrag für den empfohlenen Demo-Modus:

```text
/model-to-java
Lies @docs/04-klassendiagramm/klassendiagramm.png als Bild.
Das Diagramm wurde von uns selbst erstellt und committet.
Implementiere die Klassen im Bild und Main.java in src/.
Beginne mit einer kleinen lauffähigen Version zum Testen und Reviewen.
Offene Methoden dürfen zunächst klar markierte Platzhalter bleiben.
Schlage für nötige Vereinfachungen konkrete Varianten zur Auswahl vor.
Nur einfache Assoziationen und Java-Grundlagen, nur Java-Standardbibliothek.
Keine Vererbung oder Frameworks.
```

Alternativ können Sie bestimmte Klassen benennen oder zunächst nur die Klassenstruktur übertragen lassen. Die Commit-ID ermittelt der Skill selbst. Kontrollieren Sie in Copilot, ob das PNG als **Bildanlage** erkannt wird. Ein Dateipfad allein garantiert keine Bildverarbeitung. Bei fehlendem Bildzugriff holen Sie technische Hilfe.

Der [Skill model-to-java](../.agents/skills/model-to-java/SKILL.md) liest das Modell und prüft die Commit-Voraussetzung einmal. Er beginnt mit den eindeutigen Teilen. Nicht jede offene Fachfrage muss vor der ersten lauffähigen Version beantwortet sein. Für blockierende Angaben stellt er höchstens drei kurze Auswahlfragen in einer Runde, beispielsweise:

> Preis für die Demo: A – fester Beispielwert 2,50 Euro, ohne Tarifberechnung (empfohlen); B – Methode zunächst zurückstellen; C – eigene Regel nennen.

Antworten Sie konkret, zum Beispiel „Preis A; Anzeige als Liste in Main; Reiseplan zunächst zurückstellen“. Dadurch beauftragen Sie genau diese Vereinfachungen. Eine bloße Vorbelegung oder pauschales „Accept“ ersetzt Ihre Auswahl nicht. Technische Hilfen wie Konstruktoren oder eine Liste in `Main` darf der Skill selbst umsetzen und kurz erklären. Fachliche Ergänzungen, vorläufige Typabbildungen und andere Abweichungen vom PNG müssen ausdrücklich gewählt und im Code erkennbar sein.

Die erste Version soll kompilieren und einen einfachen Ablauf zeigen. Offene Methoden dürfen als solche markiert bleiben und beim Aufruf beispielsweise eine klare „Noch nicht umgesetzt“-Ausnahme auslösen; der Demo-Ablauf nutzt die bereits implementierten Teile. Dummy-Werte sind keine echte Fachlogik. Es gelten weiter: keine ungefragten zusätzlichen fachlichen Klassen oder Anforderungen, keine Vererbung, Interfaces, abstrakten Klassen, Design Patterns, Datenbanken oder Frameworks. Eine grafische Oberfläche und eine vollständige Fallstudienanwendung sind nicht erforderlich.

## 5. Testen, reviewen und gezielt vervollständigen

Starten Sie die erste Version in Ihrer IDE oder mit einem installierten JDK im normalen Terminal (für einfache Dateien ohne Package-Deklaration):

```bash
java -version
javac -version
javac -encoding UTF-8 src/*.java
java -cp src Main
```

Die entstehenden `.class`-Dateien werden bereits durch `.gitignore` ausgeschlossen. Es werden keine Build-Werkzeuge oder zusätzlichen Bibliotheken benötigt.

Copilot nennt kurz: **Was läuft? Was ist Demo oder noch offen? Was sollen Sie jetzt testen?** Prüfen Sie selbst die Ausgaben, einen normalen Ablauf und, soweit Verhalten festgelegt ist, einen Rand- oder Fehlerfall. Vergleichen Sie Klassen, Attribute, Methoden, Beziehungen und Multiplizitäten mit dem PNG. Unterscheiden Sie Übertragungsfehler, vereinbarte Vereinfachungen und Lücken des Ausgangsmodells. Erklären Sie sich den Code gegenseitig **ohne KI**.

Sichern Sie den getesteten Zwischenstand in einem eigenen Code-Commit. Geben Sie anschließend Ihre Testergebnisse oder einen abgegrenzten Ergänzungsauftrag an Copilot weiter, etwa:

```text
Die Demo startet; wir haben den normalen Ablauf geprüft.
Ergänze jetzt <Methode> mit folgender von uns festgelegter Regel: <Regel>.
Die bisherige Demo soll weiter starten. Kompiliere und teste erneut.
```

Wenn Sie noch keine Regel festgelegt haben, lassen Sie sich konkrete einfache Varianten zur Auswahl geben. Bereits getroffene Entscheidungen werden nicht erneut abgefragt. Nach jeder Ergänzung folgen erneuter Start, Test und Review. Es ist kein neuer Modell-Commit vor jeder Code-Etappe erforderlich. Das ursprüngliche PNG bleibt als Vergleichsgrundlage unverändert; Vereinfachungen und offene Stellen bleiben nachvollziehbar.

Für die vervollständigte Übungsdemo enthält `src/Main.java` die Methode `public static void main(String[] args)`, erzeugt mindestens zwei Objekte, stellt mindestens eine modellierte Beziehung her, ruft mindestens zwei Methoden auf und zeigt Ergebnisse mit `System.out.println(...)`. Besprechen Sie verbliebene Platzhalter und Demo-Regeln ausdrücklich; ein erfolgreicher Programmstart allein bedeutet keine vollständige fachliche Umsetzung.

## 6. Später ein Ist-Diagramm aus dem Code ableiten

Nach Test und Review können Sie in einem **eigenen Folgeschritt** ein neues Klassendiagramm aus dem tatsächlich implementierten Java-Code erstellen. Auf ausdrücklichen Auftrag darf Copilot dabei eine rein technische Ableitung liefern, zum Beispiel:

```text
Leite aus unseren geprüften Java-Dateien in src/ ein Ist-Klassendiagramm ab.
Speichere es separat als Mermaid in
docs/04-klassendiagramm/klassendiagramm-aus-code.md.
Nur vorhandene Klassen, Attribute, Methoden und Beziehungen.
Kennzeichne Angaben, die sich aus dem Code nicht sicher ableiten lassen.
Verändere unser ursprüngliches PNG nicht.
```

Prüfen Sie die Ableitung selbst und begründen Sie Unterschiede zum ersten Modell: Welche Lücken wurden sichtbar? Welche Entscheidungen sind bei der Implementierung hinzugekommen? Welche Demo-Regeln müssen später noch fachlich geklärt werden? Aus einem Code-Diagramm folgt keine automatische fachliche Korrektheit. Die Modellierungsaufgaben und KI-Grenzen aus Übung 3 bleiben unverändert.

## 7. Ergebnisse im Team zusammenführen

Modell und Implementierung bleiben in getrennten Commits; weitere getestete Code-Etappen und ein späteres Ist-Diagramm erhalten jeweils eigene Commits. Pushen Sie ausschließlich zum Team-Repository und erstellen Sie einen Pull Request nach `main`. Das andere Mitglied prüft ihn vor dem Merge. Wählen Sie eine Merge-Art, die die getrennten Commits erhält; kein Squash. Aktualisieren Sie danach beide lokalen `main`-Branches gemäß [Git-Anleitung](git-teamarbeit.md). Im zusammengeführten Stand müssen das ursprüngliche PNG und die Java-Klassen einschließlich `src/Main.java` vorliegen. Copilot führt keinen Commit, Push oder Merge automatisch aus.
