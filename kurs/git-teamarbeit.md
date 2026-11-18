# Git-Teamarbeit – von der Lehrvorlage zum Team-Repository

Diese Anleitung übernimmt die Einrichtung aus dem [Git-Zusatzblatt zu Übung 4](Git_Anlage_Übungsblatt4_SWE1_2627.pdf) und ergänzt die Zusammenarbeit und spätere Kursaktualisierungen. Arbeiten Sie zu zweit. Führen Sie Befehle im **normalen Terminal Ihrer IDE** (VS Code oder IntelliJ), im Repository-Ordner aus, nicht im Copilot-Dialog. Die Beispiele verwenden den Branch `main`.

## Begriffe und Ziele

| Begriff | Bedeutung |
|---|---|
| `clone` | Erstellt eine lokale Arbeitskopie samt Git-Historie und Verbindung zum Quell-Repository. |
| `branch` | Benannte Entwicklungslinie. Ein Übungsbranch hält die laufende Arbeit zunächst von `main` getrennt. `git switch -c` legt ihn an und wechselt dorthin. |
| `add` | Merkt ausgewählte Änderungen für den nächsten Commit vor (Staging). |
| `commit` | Speichert den vorgemerkten Stand mit einer Nachricht lokal in der Historie. |
| `push` | Überträgt lokale Commits und den Branch zum angegebenen Remote. |
| `fetch` | Holt neue Commits vom Remote, ohne die eigenen Dateien mit ihnen zusammenzuführen. |
| `merge` | Führt eine andere Entwicklungslinie mit dem aktuellen Branch zusammen; dabei können Konflikte entstehen. |
| `pull` | Holt Änderungen und integriert sie. `--ff-only` erlaubt dabei nur ein einfaches Vorrücken ohne neuen Merge-Commit und stoppt bei auseinanderlaufender Historie. |
| Pull Request (PR) | Bitte auf GitHub, einen Branch nach Review in einen Zielbranch zu übernehmen; noch kein Merge. |

Ein Remote ist eine benannte Repository-Adresse. Nach der Einrichtung gilt auf beiden Computern:

- `origin` → Ihr eigenes Team-Repository: dorthin pushen Sie.
- `vorlage` → `https://github.com/HMFK07/Uebung3_SWE1.git`: von dort holen Sie Kursaktualisierungen.

Pushen Sie **ausschließlich zu `origin`**, nachdem Sie dessen Adresse geprüft haben. Der Kurs pflegt `AGENTS.md`, `.github/`, `.agents/skills/` und `kurs/`. Ihre Ergebnisse liegen in `docs/` und später `src/`. Ausgangsvisionen unter `docs/` sind einmaliges Startmaterial. Kopieren Sie bei Kursaktualisierungen keine Verzeichnisse pauschal über Ihre Ergebnisse.

## Einmalige Einrichtung

### 1. Vorhandenen Klon verwenden oder von ZIP wechseln

Wenn Sie bereits mit Git geklont haben, öffnen Sie diesen Ordner und prüfen Sie:

```bash
git status
git branch --show-current
git remote -v
```

Erwartet werden ein Git-Repository, der Branch `main` und zunächst die Lehrvorlage als `origin`. Bei anderen Branches, bereits eingerichteten Team-Remotes oder unklarer Historie lesen Sie zuerst den Abschnitt „Bestehendes Team-Repository“. Benennen Sie keinen Remote blind um.

**Bei bisheriger ZIP-Nutzung:** Bewahren Sie den bisherigen Ordner als Sicherung auf. Klonen Sie die Lehrvorlage in einen neuen, noch nicht vorhandenen Ordner:

```bash
git clone https://github.com/HMFK07/Uebung3_SWE1.git SWE1-Team
cd SWE1-Team
```

Kopieren Sie nur Ihre selbst erstellten oder selbst bearbeiteten Dokumente aus dem alten Ordner in die passenden Unterordner von `docs/`. Übertragen Sie keine versteckten Git-Daten und ersetzen Sie keine Kursdateien aus dem ZIP. Prüfen Sie auch Ihre umbenannte Vision und bewusst entfernte Alternativvisionen. Vergleichen Sie die Dateien, bevor Sie die Sicherung später aufgeben. Ein ZIP besitzt keine Git-Historie; starten Sie damit kein unabhängiges `git init` für diesen Ablauf.

### 2. Eigene Ergebnisse lokal committen

Legen Sie die bisherigen Anforderungen, Reviews und Modelle unter `docs/` ab. Prüfen Sie den Zustand und merken Sie nur Ihre Ergebnisdateien vor:

```bash
git status
git add docs/
git diff --cached --stat
git diff --cached
git commit -m "Eigene Ergebnisse aus Uebung 3 gesichert"
git status
```

`git add docs/` erfasst auch Änderungen und Löschungen in diesem Ordner. Verwenden Sie bei Bedarf einzelne Dateipfade. Kontrollieren Sie **alle** vorgemerkten Dateien; bereits anderweitig vorgemerkte Dateien würden ebenfalls committet. Binärdateien wie PNG und PDF öffnen Sie zur Prüfung zusätzlich in der IDE. Falls Git Name und E-Mail verlangt, konfigurieren Sie Ihre eigene Identität wie in der Lehrveranstaltung eingerichtet; holen Sie bei Problemen technische Hilfe.

Sind alle Ergebnisse bereits committet, ist kein leerer weiterer Commit nötig. Ein Commit speichert nur lokal. Für die nächsten Schritte muss der Arbeitsbaum sauber sein (keine offenen, vorgemerkten oder unversionierten Arbeitsdateien).

### 3. Leeres Team-Repository auf GitHub anlegen

Nur eine Person legt auf GitHub über **New repository** das Team-Repository an, beispielsweise `SWE1-Fallstudie-Team`, mit der vereinbarten Sichtbarkeit (zum Beispiel Private). Fügen Sie **kein README, keine .gitignore und keine Lizenz** hinzu: Das Ziel muss leer sein, damit Ihre vorhandene Historie hineinpasst. Kopieren Sie dessen HTTPS-Adresse. Besteht bereits ein Team-Repository, legen Sie kein zweites an; folgen Sie dem entsprechenden Abschnitt unten.

### 4. Remotes umstellen und bisherigen Stand hochladen

Ersetzen Sie `DEIN-ACCOUNT/DEIN-REPO` durch Ihr tatsächliches Teamziel. Die Umbenennung ist nur einmal nötig:

```bash
git remote -v
git remote rename origin vorlage
git remote add origin https://github.com/DEIN-ACCOUNT/DEIN-REPO.git
git remote -v
git push -u origin main
```

Kontrollieren Sie **vor dem Push**: `vorlage` zeigt auf `HMFK07/Uebung3_SWE1`, `origin` auf Ihr Team. `-u` setzt für Ihre lokale `main` den Team-Branch als Tracking-Ziel; durch das Umbenennen könnte sie zuvor noch `vorlage/main` verfolgen. Der erste Push kann eine GitHub-Anmeldung erfordern. Bei Ablehnung anhalten, Adresse und Fehlermeldung prüfen, technische Hilfe anfordern; kein Force-Push.

Öffnen Sie Ihr Team-Repository auf GitHub und prüfen Sie, ob Ihre Dokumente und der eigene Commit sichtbar sind.

### 5. Zweites Teammitglied einladen und klonen

Die besitzende Person lädt das zweite Mitglied in den Repository-Einstellungen zur Mitarbeit ein; die Einladung muss angenommen werden. Die zweite Person klont **das Team-Repository**, nicht erneut die Lehrvorlage, in einen neuen Ordner:

```bash
git clone https://github.com/DEIN-ACCOUNT/DEIN-REPO.git SWE1-Team
cd SWE1-Team
git remote add vorlage https://github.com/HMFK07/Uebung3_SWE1.git
git remote -v
git status
```

Remote-Konfigurationen werden nicht mitgeklont. `origin` entsteht beim Klonen automatisch; `vorlage` muss jede Person lokal ergänzen. Kontrollieren Sie gemeinsam die Adressen und die eigenen Dokumente. Bisherige lokale Arbeit der zweiten Person sichern Sie vorab und übertragen nur fehlende eigene Ergebnisse in diesen Team-Klon, ohne vorhandene Ergebnisse zu überschreiben.

### Bestehendes Team-Repository

Verwenden Sie Ihr vorhandenes Team-Repository weiter. Prüfen Sie mit `git remote -v`, ob `origin` bereits darauf zeigt. Dann entfällt die Umbenennung und Neuanlage; falls `vorlage` noch fehlt, ergänzen Sie nur:

```bash
git remote add vorlage https://github.com/HMFK07/Uebung3_SWE1.git
```

Ist `vorlage` bereits korrekt vorhanden, ist auch dieser Befehl unnötig. Arbeiten Sie im vorhandenen Team-Klon oder klonen Sie das Teamziel in einen neuen Ordner und übertragen Sie fehlende eigene Dokumente kontrolliert wie oben. Bei falschen Adressen, abweichenden Branch-Namen oder unklaren lokalen Commits holen Sie Hilfe, bevor Sie Remotes ändern oder pushen.

Dieser Ablauf setzt voraus, dass die Team-Historie von der Lehrvorlage abstammt. Ein unabhängig per `git init` oder aus einem ZIP angelegtes Repository kann beim Merge „unrelated histories“ melden. **Anhalten und technische Hilfe holen**; weder Historien erzwingen noch studentische Dateien ersetzen. Auch ein versehentlich mit README initialisiertes Ziel erfordert eine Klärung statt eines erzwungenen Pushs.

## Vor jeder Übung: Vorlage übernehmen und Branch anlegen

Eine Person koordiniert das Update; die andere pausiert ihre Bearbeitung. Vorherige Übungsbranches sollen nach Review in `main` zusammengeführt sein.

**Vor dem ersten Befehl:** Führen Sie `git status` aus. Nur bei sauberem Arbeitsbaum fortfahren. Speichern Sie offene Arbeit bewusst auf dem dazugehörigen Branch in einem Commit; bei Unsicherheit anhalten und Hilfe holen. `git status` zeigt Probleme nur an und stoppt eine eingefügte Befehlsfolge nicht automatisch. Führen Sie die folgenden Befehle deshalb einzeln aus und prüfen Sie jedes Ergebnis:

```bash
git switch main
git status
git pull --ff-only origin main
git fetch vorlage
git merge --no-edit vorlage/main
git push origin main
```

`pull` übernimmt zunächst den Teamstand. `fetch vorlage` lädt die neue Lehrversion; `merge` integriert sie samt Historie in Ihre `main`. `--no-edit` übernimmt nur die vorgeschlagene Merge-Nachricht; es löst keine Konflikte. Prüfen Sie nach dem Merge mit `git status` und in der IDE, ob Ihre Dokumente und die neuen Kursdateien vorhanden sind, **bevor** Sie pushen.

Bei jedem Fehler stoppen. Insbesondere bei Merge-Konflikten: nicht weiterarbeiten, nicht committen oder pushen und keine Seite pauschal übernehmen. Notieren Sie `git status` und die betroffenen Pfade, lassen Sie alle Arbeitsdateien erhalten und fordern Sie technische Hilfe an. Auch ein von `--ff-only` abgelehnter Pull braucht Klärung. Kein Force-Push, kein `reset --hard` und kein automatisches Überschreiben.

Nach erfolgreichem Push übernimmt die zweite Person bei ebenfalls sauberem Arbeitsbaum:

```bash
git switch main
git status
git pull --ff-only origin main
```

Nur die koordinierende Person legt nun den gemeinsamen neuen Übungsbranch an und pusht ihn:

```bash
git switch -c uebung-04-team
git push -u origin uebung-04-team
```

Die zweite Person holt diesen Branch und wechselt darauf:

```bash
git fetch origin
git switch --track origin/uebung-04-team
```

Diese Erstellung gilt für einen **neuen** Branch. Existiert er lokal schon, verwenden Sie `git switch uebung-04-team` und anschließend `git pull --ff-only origin uebung-04-team`. Verwenden Sie bei der nächsten Übung einen neuen Namen. `-u` beziehungsweise `--track` verbindet den lokalen Übungsbranch mit dem Teamziel.

## Während der Übung: gemeinsamer Branch, abwechselnde Bearbeitung

Bearbeiten Sie den gemeinsamen Übungsbranch abwechselnd und sprechen Sie die Übergabe ab. Vor der Übernahme holt die nächste Person bei sauberem Arbeitsbaum den aktuellen Stand:

```bash
git switch uebung-04-team
git pull --ff-only origin uebung-04-team
```

Arbeiten Sie eigenständig im Rahmen der jeweiligen KI-Freigabe. In [Übung 4](uebung-04.md) entsteht das erste UML-Modell vollständig ohne KI; erst nach Ihrem eigenen Modellierungs-Commit darf Copilot die beauftragten Klassen schrittweise in Java umsetzen. Sichern und pushen Sie bei jeder Übergabe Ihre geprüften Änderungen. Beispiel für die getrennten Modell- und Code-Schritte:

```bash
git status
git add docs/04-klassendiagramm/
git diff --cached
git commit -m "Eigenes Klassendiagramm fuer Uebung 4"
git push origin uebung-04-team
```

Erst danach Copilot für eine erste lauffähige Java-Version verwenden, Code selbst prüfen und starten. Sichern Sie diesen testbaren Zwischenstand separat; vervollständigen Sie ihn nach Ihrem Review in weiteren Code-Commits. Kennzeichnen Sie im Commit gegebenenfalls den Demo-Stand und seine offenen Punkte. Beispiel:

```bash
git status
git add src/
git diff --cached
git commit -m "Erste lauffaehige Java-Demo mit Copilot geprueft"
git push origin uebung-04-team
```

Prüfen Sie jeweils, dass nur die beabsichtigten Dateien vorgemerkt sind. PNGs müssen Sie zusätzlich öffnen. `.class`-Dateien werden ignoriert. Ein später auf Ihren Auftrag aus geprüftem Code abgeleitetes Ist-Diagramm wird als eigene Datei und in einem weiteren Commit gesichert; das ursprüngliche Modell-PNG bleibt erhalten. Ein Push geht immer an `origin`, nie an `vorlage`. Wird er wegen zwischenzeitlicher Team-Commits abgelehnt, stoppen Sie die parallele Bearbeitung und klären Sie den Stand gemeinsam, bei Bedarf mit technischer Hilfe. Kein erzwungenes Pushen.

Persönliche Branches sind optional für Teams, die diesen Ablauf bereits sicher beherrschen; für diese Übung genügt der gemeinsame Branch mit verabredeten Übergaben.

## Nach der Übung: Pull Request und Review

1. Prüfen Sie auf GitHub im **Team-Repository**, dass alle Arbeit auf dem Übungsbranch liegt. Erstellen Sie einen Pull Request mit Ziel (`base`) `main` und Quelle (`compare`) `uebung-04-team`.
2. Beschreiben Sie kurz den Ausschnitt und Ihre tatsächlichen Tests. Fordern Sie das andere Teammitglied zum Review auf. Prüfen Sie gemeinsam Änderungen und Commit-Liste; in Übung 4 müssen der eigene Modellierungs-Commit und der spätere Code-Commit getrennt erkennbar sein.
3. Das andere Mitglied prüft vor dem Merge das PNG, die Passung des Codes und die Ausführbarkeit. Erklären Sie sich das Ergebnis ohne KI. Korrekturen erfolgen auf dem Übungsbranch und werden erneut geprüft.
4. Führen Sie den geprüften PR auf GitHub zusammen. Verwenden Sie **Create a merge commit**, damit die getrennten Commits erhalten bleiben. **Kein Squash-Merge.** Ist diese Merge-Art nicht verfügbar oder gibt es Konflikte, holen Sie technische Hilfe statt die Trennung aufzugeben.
5. Beide Personen aktualisieren bei sauberem Arbeitsbaum ihren lokalen Stand:

```bash
git switch main
git pull --ff-only origin main
git status
```

Kontrollieren Sie die Ergebnisdateien auf `main`, in Übung 4 insbesondere `docs/04-klassendiagramm/klassendiagramm.png` und `src/Main.java` samt fachlichen Klassen. Branches müssen für diesen Ablauf nicht gelöscht werden. Vor der nächsten Übung beginnt wieder die Vorlagen-Aktualisierung.

## Grenzen und technische Prüfung

Ein normaler Merge erhält eigene Dokumente, wenn Änderungen miteinander vereinbar sind, und ergänzt neue Kursdateien. Bei konkurrierenden Änderungen derselben Stelle, binären Diagrammen oder „geändert gegen gelöscht“ ist keine automatische Erhaltung des gewünschten Inhalts garantiert: Git kann einen Konflikt melden, dessen fachliche Auflösung Menschen entscheiden müssen.

Git erzwingt einen sauberen Arbeitsbaum nicht in jedem Fall: Unabhängige lokale Änderungen können einen Merge überstehen; überlappende Änderungen oder unversionierte Dateien an neu belegten Pfaden können ihn blockieren. **Deshalb gilt hier immer die strengere Vorbedingung „sauber“, auch wenn Git technisch fortfahren würde.** Ein lokaler Test mit temporären Repositories prüft Historie und Dateierhalt; er ersetzt keine Prüfung von GitHub-Anmeldung, Einladungen, Berechtigungen, PR-Oberfläche oder Ihrer IDE.
