# SWE1 – Übungen 3 und 4, WS 2026/27

## Wegweiser

- **Übung 3:** Die Schritte unten führen durch Anforderungen, Review, Substantivextraktion sowie Objekt- und Zustandsdiagramm. Es gelten die [KI-Freigaben für Übung 3](kurs/uebung-03.md).
- **Git im Zweierteam:** Folgen Sie vor Übung 4 der [vollständigen Anleitung zur Git-Teamarbeit](kurs/git-teamarbeit.md): bisherige Ergebnisse sichern, eigenes Team-Repository einrichten und vor jeder Übung die Lehrvorlage übernehmen. Bereits bestehende Team-Repositories werden weiterverwendet.
- **Übung 4:** [Aufgaben und aktualisierte KI-Grenzen](kurs/uebung-04.md): Klassendiagramm eigenständig erstellen und als `docs/04-klassendiagramm/klassendiagramm.png` committen. Mit [model-to-java](.agents/skills/model-to-java/SKILL.md) zunächst eine kleine lauffähige Java-Version nach `src/` übertragen, selbst testen und reviewen, danach gezielt vervollständigen. Zwei bis drei Klassen sind eine Empfehlung; auch alle Klassen im Bild sind möglich. Später kann auf eigenen Auftrag ein separates Ist-Diagramm aus dem geprüften Code entstehen.

`docs/` und `src/` enthalten Ihre Ergebnisse. `kurs/`, `.agents/skills/`, `.github/` und `AGENTS.md` werden vom Kurs gepflegt. Die Ausgangsvisionen unter `docs/` sind einmaliges Startmaterial, keine regelmäßig zu ersetzenden Vorlagen.

## Übung 3

Sie überprüfen Ihre bisherigen Anforderungen und erstellen erste UML-Modelle. Arbeiten Sie im Zweierteam an Ihrer Fallstudie: **Fundbüro-Anwendung**, **Verleih-Plattform** oder **Repair-Café-Anwendung**. Ziel ist eine kleine, verständliche Lehranwendung; den [Lernrahmen und die KI-Freigaben](kurs/uebung-03.md) finden Sie in den Kurshinweisen.

Lesen Sie [Übungsblatt 3 in Moodle](https://moodle.hm.edu/pluginfile.php/2162747/mod_resource/content/0/U%CC%88bungsblatt3_SWE1_2627.pdf) selbst. Der Link ist ausschließlich für Studierende bestimmt. Geben Sie das Übungsblatt nicht als Datei oder Chat-Kontext an die KI weiter. Für den Agenten gelten die lokalen Freigaben und die Regeln in [AGENTS.md](AGENTS.md); er darf das Übungsblatt nicht abrufen.

## Einstieg in Copilot

Ein Skill ist eine Arbeitsanweisung für den KI-Agenten. Dieser kann Dateien lesen und Werkzeuge nutzen. Sie wählen die Aufgabe und die Quellen bewusst aus und prüfen das Ergebnis.

Verwenden Sie wie im Übungsblatt **Copilot im Terminal Ihrer Entwicklungsumgebung**, beispielsweise VS Code oder IntelliJ:

- Öffnen Sie den Repository-Ordner und anschließend das integrierte Terminal Ihrer IDE.
- Starten Sie die wie in Übung 1 eingerichtete Copilot CLI mit `copilot`. Beginnen Sie eine neue Sitzung und geben Sie den benötigten Skill-Befehl aus den folgenden Beispielen ein.
- Benennen Sie für ein Requirements-Review die benötigten Dateien oder einen Ordner wie `docs/`. Der Coach ermittelt darin die passenden Texte. Für die Substantivextraktion benennen Sie weiterhin konkrete Dateien oder Abschnitte.

Wird ein Skill nicht erkannt, prüfen Sie die Einrichtung mit der Lehrperson.

## 1. Anforderungen erfassen

Klonen Sie diese Vorlage oder öffnen Sie den heruntergeladenen Repository-Ordner in Ihrer IDE. Wählen Sie unter [docs/01-anforderungen/](docs/01-anforderungen/) Ihre Ausgangsvision, löschen Sie die zwei anderen Visionsdateien und benennen Sie die verbleibende Datei in `vision.md` um.

Legen Sie dort Ihre selbst erarbeiteten Personas, Szenarien, User Stories und strukturierten Anwendungsfälle aus Übung 1 sowie die funktionalen und nichtfunktionalen Anforderungen einschließlich Akzeptanzkriterien aus Übung 2 ab.

## 2. Anforderungen analysieren

Starten Sie den [requirements-coach](.agents/skills/requirements-coach/SKILL.md) für eine Konsistenzprüfung im **Challenge-Modus**. Ein Ordner genügt; eine eigene Vorabvermutung oder eine einzeln abgetippte Dateiliste ist nicht erforderlich:

```text
/requirements-coach
Prüfen Sie die Anforderungstexte in docs/ auf Konsistenz.
Stellen Sie Fragen bei Unklarheiten und speichern Sie die Ergebnisse
in docs/06_klarstellungen.md.
```

Der Coach wählt aus dem freigegebenen Ordner relevante Anforderungen, Stories, Anwendungsfälle, Akzeptanzkriterien und benötigten Kontext aus. Er nennt den bearbeiteten Umfang und stellt zu wichtigen Befunden bevorzugt zwei, höchstens drei quellengestützte Fragen pro Runde. Auf Ihren Speicherauftrag legt er das Klarstellungsdokument bereits mit offenen Befunden an; die Antworten und Entscheidungen bleiben bei Ihnen. Eine vorhandene Datei wird unter Erhalt Ihrer bisherigen Antworten ergänzt. Ohne genannten Zielpfad ist bei einem Speicherauftrag `docs/02-review/06_klarstellungen.md` die Standardablage.

Beantworten Sie die Fragen im Team und halten Sie mindestens drei Erkenntnisse und Ihre Entscheidungen im Klarstellungsdokument fest. Unterscheiden Sie tatsächliche Unklarheiten, offene Fragen und mögliche Verbesserungen. Überarbeiten Sie Anforderungen oder Akzeptanzkriterien **nur, wenn dies notwendig ist**, und begründen Sie die Änderungen selbst. Prüfen Sie auch KI-Hinweise an Ihren Quellen; KI-Kritik allein ist kein Änderungsgrund. Erklären Sie sich anschließend gegenseitig ohne KI Ihre Entscheidung und die Überprüfbarkeit der Anforderungen. Beenden Sie das Review ausdrücklich, sobald Sie die ausgewählten Punkte besprochen haben. Fertige Formulierungen, Musterlösungen und Compare bleiben ausgeschlossen; der Coach ändert Ihre Anforderungsdateien nicht.

## 3. Substantive extrahieren

Beginnen Sie eine **neue Copilot-Sitzung**, damit Persona und Review-Dialog nicht als zusätzlicher Kontext vorliegen. Nutzen Sie [noun-extraction](.agents/skills/noun-extraction/SKILL.md) nur mit funktionalen Anforderungen, User Stories oder strukturierten Anwendungsfällen:

```text
/noun-extraction
Lesen Sie nur <Pfad zum Anforderungstext>, Abschnitt <ID oder Abschnitt>.
Extrahieren Sie nur aus diesem Abschnitt die verwendeten Substantive.
```

Der Skill liefert Grundformen, fachliche Mehrwortbegriffe und Fundstellen. Bei Teilausgaben nennt er den bearbeiteten und verbleibenden Umfang. Er liest keine Persona, ordnet keine Modellelemente zu und erzeugt keine UML-Diagramme. Die Spalten für studentische Einordnung und Begründung bleiben in seiner Ausgabe leer.

Prüfen Sie einige Einträge selbst am Originaltext, insbesondere Grundform, Mehrwortbegriffe und Fundstelle. Kopieren Sie die Ausgabe im Copilot-Terminal mit `/copy` und übernehmen Sie sie als Textdokument nach [docs/03-objektmodell/](docs/03-objektmodell/). Entscheiden Sie selbst, welche Begriffe ein eigenes Objekt benötigen und welche Eigenschaften anderer Objekte beschreiben.

## 4. Objektdiagramm erstellen

Wählen Sie einen konkreten Zeitpunkt innerhalb Ihres Anwendungsfalls. Modellieren Sie mindestens vier beteiligte Objekte mit Objektnamen, wichtigen Attributen, konkreten Werten und passenden Links. Ergänzen Sie bei Bedarf Rollenbezeichnungen. Prüfen Sie die fachliche Passung zu Anwendungsfall und Anforderungen. Speichern Sie das Ergebnis unter `docs/03-objektmodell/`.

## 5. Zustandsdiagramm erstellen

Wählen Sie einen fachlichen Objekttyp aus Ihrem Objektdiagramm, dessen Zustand sich im Anwendungsfall verändert. Modellieren Sie mindestens vier sinnvolle Zustände mit durch Ereignisse beschrifteten Übergängen. Ergänzen Sie einen Initialzustand, gegebenenfalls einen Endzustand und mindestens einen alternativen Ablauf. Unterscheiden Sie Zustände von den Ereignissen, die einen Zustandswechsel auslösen. Speichern Sie das Diagramm ebenfalls unter `docs/03-objektmodell/`.

Erklären Sie sich gegenseitig anhand Ihrer Quellen, welche Anforderung und welche Stelle des Anwendungsfalls in Ihren beiden Modellen sichtbar werden. Beide Diagramme einschließlich ihrer Prüfung entstehen **ohne KI-Unterstützung**. Anforderungen und Modellierungsentscheidungen außerhalb der beiden ausdrücklich freigegebenen Skill-Aufgaben bleiben Eigenleistung.

## Werkzeuge und Arbeitsstand

**Word und Miro bleiben erlaubt.** Für die KI-Analyse müssen die ausgewählten Texte als lesbarer Text vorliegen, bevorzugt als Markdown. Screenshots oder reine Bild-PDFs ersetzen diesen Text nicht. Diagramme können Sie als PDF oder Bild im Modellordner ablegen.

Sie pflegen `docs/`; der Kurs pflegt Regeln, Skills und Übungshinweise. Beim Einstieg in Übung 3 waren Commit und Push noch nicht verlangt. **Vor Übung 4 sichern Sie diese Ergebnisse mit der [Git-Teamarbeit](kurs/git-teamarbeit.md).**
