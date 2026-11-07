# Strukturierte Anwendungsfälle

| Template für einen Anwendungsfall | – | – | – |
|---|---|---|---|
| **ID** | #01 | #02 | #03 |
| **Anwendungsfall-Name** | Gegenstand finden | Gegenstand melden | Gegenstand entgegennehmen/ausgeben |
| **Akteur** | Sucher | Finder | Operator |
| **Ziel** | Den verlorenen Gegenstand schnell finden, anhand einfacher Suchfunktionen | Den gefundenen Gegenstand schnell wieder zurückbringen | Den verlorenen Gegenstand entgegennehmen und ggf. an die Person zurückgeben |
| **Vorbedingungen** | Ein verlorener Gegenstand ist im System hinterlegt. Das System ist betriebsbereit. | Der Finder will einen Gegenstand melden. Das System ist betriebsbereit. | Ein Gegenstand muss gefunden werden. |
| **Nachbedingung** | Ein passender Eintrag im System wurde gefunden und ausgewählt. | Der Finder ist registriert. Der Sucher wurde kontaktiert und die Übergabe wurde arrangiert. Finderlohn/Entschädigung wurde ausgezahlt. | Der Finder ist registriert oder muss ein kurzes Formular ausfüllen. |
| **Hauptablauf** | 1. Sucher öffnet App<br>2. Sucher registriert sich<br>3. Fenster „Ich suche etwas“ / „Ich habe etwas gefunden“ wird angezeigt<br>4. Sucher wählt „Ich suche etwas“ aus<br>5. Sucher gibt gesuchte Sache als Text ein<br>6. Sucher hat gesuchte Sache gefunden<br>7. Kontaktformular in der App ausfüllen und auf Antwort per E-Mail warten | 1. Finder öffnet App<br>2. Finder registriert sich<br>3. Fenster „Ich suche etwas“ / „Ich habe etwas gefunden“ wird angezeigt<br>4. Finder wählt „Ich habe etwas gefunden“<br>5. Finder gibt Inseratdetails ein<br>6. Finder soll zur nächsten Fundstation kommen oder den Gegenstand per Post einschicken<br>7. Nächste Fundstation wird ermittelt und angezeigt | 1. Finder bringt Gegenstand in eine Filiale<br>2. Operator nimmt den Gegenstand entgegen<br>3. Finder muss ein paar kurze Fragen beantworten (evtl. schriftlich)<br>4. Der Gegenstand wird eingetütet, fotografiert und hochgeladen<br>5. Falls der Suchende sich meldet, wird der Gegenstand zurückgegeben und eine Gebühr entgegengenommen |
| **Alternativer Ablauf** | zu 5: Button aktivieren: Neuer Suchgegenstand gefunden | – | – |
| **Ausnahmen** | zu 5: Wenn nichts gefunden wurde, zeigt das System eine Meldung an. | – | Wenn sich die Story nicht deckt, wird der Gegenstand nicht zurückgegeben. |
| **Beteiligte Systeme** | Eintrag Finder DB, Eintrag Sucher DB, Profil, Daten | Eintrag Finder, Eintrag Sucher, DB, Profil, Datenbank | Eintrag Finder DB, Eintrag Sucher DB, Profil, Daten |
