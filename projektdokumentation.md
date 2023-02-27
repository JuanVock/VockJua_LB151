# Projekt-Dokumentation

Vock

| Datum  | Version| Zusammenfassung                                                               |
| ------ | -------| ------------------------------------------------------------------------------|
|14.01.23|0.0.1   | Primeface anwenbar gemacht                                                    |
|20.02.23|0.0.2   | Informieren über JDBC                                                         |
|20.02.23|0.0.3   | Erstellen der Datenbank mit den Tabellen                                      |
|20.02.23| 0.0.4  | Datenbank einbinden in Netbeans                                               |
|24.02.23| 0.0.5  | Datenkbank versuchen mit der Website zu verbinden inkl. einer Insert funktion |
|25.02.23| 0.0.6  | LoginSeite                                                                    |
|26.02.23| 1.0.0  | Adminseite                                                                    |
|26.02.23| 1.0.1  | Benutzername Seite                                                            |


# 0 Ihr Projekt

Bei diesem Projekt geht es um einen Glücksradspiel, welches auf einer Website dargestellt.

# 1 Analyse

✍️ Beschreiben Sie, auf welchem Tier Sie die dynamischen Elemente der Anwendung unterbringen möchten:

* Tier 1 (Presentation):-  Anzeige der Kategorien mit den Wörte inkl. Bearbeitung-, Lösche- und Hinzufügenfunktion.
                        - Glücksradspiel
* Tier 2 (Webserver): Prüfung aller Eingabefunktionen wie Kategorien, Wörter und Vokalen
* Tier 3 (Application Server):Glücksspiel berechnen
* Tier 4 (Dataserver): Kategorien, Wörter, Benutzerdateien mit Heighscore speichern

# 2 Technologie

✍️ Beschreiben Sie für dieselben Tiers, welche Programmiersprache bzw. Technologie Sie verwenden möchten.
Dieses Projekt wird mit Java, JSF mit Primeface und mit der realtionalen Datenbank MySql verwendet.Es 
* Tier 1 (Presentation):-  XHTML, CSS, Primeface
* Tier 2 (Webserver): jbbc
* Tier 3 (Application Server):jdbc
* Tier 4 (Dataserver): mySQL

# 3 Datenbank

✍️ Wie steuern Sie Ihre Datenbank an? Wie ist das Interface aufgebaut? 
Es wird im Java in Netbeans mit JDBC gesteuert.
Es gitb eine Tabelle Player mit den Informationen ID, username, Zeitpunkt des Spieles, Geldbetrag, Anzahl Spielrunden
Es gibt eine Tabelle Kategorie mit der ID, kategoryName, die mit der Tabelle Word mit der ID und wordName verbunden sind.


# 4.1 User Stories

✍️ Formulieren Sie klare Anforderungen in der Form von User Stories (*„als … möchte ich … damit …“*) und zu jeder Anforderung mindestens einen dazugehörigen Testfall (in Kapitel 4.2). 

✍️ Formulieren Sie weitere, eigene Anforderungen und Testfälle, wie Sie Ihre Applikation erweitern möchten. Geben Sie diesen statt einer Nummer einen Buchstaben (`A`, `B`, etc.)

| US-№ | Verbindlichkeit | Typ  | Beschreibung                       |
| ---- | --------------- | ---- | ---------------------------------- |
| 1    |  Wichtig        |  Funktional    | Als ein Administrator möchte ich mit meinen Anmeldedaten in die Administratorenbereich kommen, damit die Kategorien und die Wörter oder Phrasen bearbeiten kann|
| 2  |      Wichtig           | Funktional     | Als Player möchte ich meinen Benutzername eingeben können, damit im Heighscore mein richtiger Benutzername steht  |
| 3  |      Wichtig           | Funktional     | Als User möchte ich wenn ich eine Eingabe leer gelassen habe, dass es mich daraufhinweist, damit ich alles ausfülle |
| 4  |      Wichtig           | Funktional     | Als User möchte ich wenn ich den Heigscore sehen, damit ich sehe wie gut ich bin |
| 5  |      Wichtig           | Funktional     | Als User möchte ich einen Vokal auswählen können, damit ich das Wort schneller herausfinde |
| 6  |      Wichtig           | Funktional     | Als User möchte ich wenn ich meine Herze sehen können, damit ich sehe, ob ich bald verliere |
| 7  |      Wichtig           | Funktional     | Als User möchte ich wenn ich Konsonanten oder gerade das ganze Wort eingeben können, damit ich gewinnen kann |
| 8  |      Wichtig           | Qualität     | Als User möchte ich wenn ich lange die Website nicht benutze, dass es mich automatisch abmeldet, damit ich mich sicher fühle|




✍️ Jede User Story hat eine ganzzahlige Nummer (1, 2, 3 etc. oder Zahl), eine Verbindlichkeit (Muss oder Kann?), und einen Typ (Funktional, Qualität, Rand). 

# 4.2 Testfälle

| TC-№ | Vorbereitung | Eingabe | Erwartete Ausgabe |
| ---- | ------------ | ------- | ----------------- |
| 1.1  |   Website ist gestartet| Juanadmin bei der Eingabe, 123 bei Passwort. Dann Kategorien Hallo und Wort cool hinzufügen und löschen und bearteiten |Bei der Adminseite wird hallo und cool bearbeitbar sein         |
| 2.3  |   Website ist gestartet           |   Button anmelden drücken      | Meldung "Der Wert darf nicht leer sein" erschein             |
| 3.3  |   Website ist gestartet           |   hallo, hallo eingeben, button drücken, OK drücken      | Meldung "Der Wert darf nicht leer sein" erschein             |
| 4.2  |   Website ist gestartet und man ist angemeldet und bei der Spiel Seite           |   Wort herausfinden      | Auf Hewighscore sichtbar            |
| 5.8  |   Website ist gestartet           |   -      | nach einer Weile kann man nicht meh auf die Website zugreifen, wegen der Session            |


✍️ Die Nummer hat das Format `N.m`, wobei `N` die Nummer der User Story ist, die der Testfall abdeckt, und `m` von `1` an nach oben gezählt. Beispiel: Der dritte Testfall, der die zweite User Story abdeckt, hat also die Nummer `2.3`.

# 5 Prototyp

✍️ Erstellen Sie Prototypen für das GUI (Admin-Interface und Quiz-Seite).
Admin GUI:
![image](https://user-images.githubusercontent.com/111751286/221523981-0a2ba9e7-68e5-4217-94eb-e088bea1f573.png)

Quiz GUI:

![image](https://user-images.githubusercontent.com/111751286/221525167-accb685f-08c2-4427-88c2-4771cc4234d4.png)


# 6 Implementation

✍️ Halten Sie fest, wann Sie welche User Story bearbeitet haben

| User Story | Datum | Beschreibung |
| ---------- | ----- | ------------ |
| 1        |   23.02.23    | Logginseite             |
| 2        |   25.02.23    | Benutzer eingabe Seite             |
| 3        |   25.02.23    | mit required und in java             |
| 4        |   26.02.23    | nur angefange             |
| 5        |  -    | -             |
| 6        |   -   | -             |
| 7        |   -   | -             |
| 8        |   24.02.23    | Immer mit Session             |



# 7 Projektdokumentation

| US-№ | Erledigt? | Entsprechende Code-Dateien oder Erklärung |
| ---- | --------- | ----------------------------------------- |
| 1    | ja  |       ja bei playerBean mit hardcode, ohne Datenbank. Die kategorien und Wörter funktionieren nicht                                    |
| 2  |     ja      |      es speichert nur in Java, ohne Datenbank                                     |
| 3  |     ja      |     bei xhtml mit Required, mit java                                   |
| 4  |     ja      |      Es gibt ein Heigscore, aber ohne Daten                                     |
| 5  |     nein    |      es speichert nur in Java, ohne Datenbank                                     |
| 6  |     nein    |      es speichert nur in Java, ohne Datenbank                                     |
| 7  |     nein    |      es speichert nur in Java, ohne Datenbank                                     |
| 8  |     nein    |      mit Sessio Scoped                                     |



# 8 Testprotokoll

✍️ Fügen Sie hier den Link zu dem Video ein, welches den Testdurchlauf dokumentiert.

Link:
https://youtu.be/nfFFNLd1aF4

| TC-№ | Datum | Resultat | Tester |
| ---- | ----- | -------- | ------ |
| 1.1  | 27.02.23      |    NOK      |    Vock    |
| 2.2  | 27.02.23     |   OK       |       Vock |
| 3.2  | 27.02.23     |  OK        |      Vock  |
| 4.3  | 27.02.23     |  NOK        |      Vock  |
|5.8  | 27.02.23     |   OK       |      Vock  |


✍️ Vergessen Sie nicht, ein Fazit hinzuzufügen, welches das Test-Ergebnis einordnet.

Das Testen verlief nicht ganz erfolgreich. Alle Seite wurden erstellen, aber Funktionen wie Kategorie und Wlrter hinzufügen und das Spiel an sich funktioniert nicht.

# 9 `README.md`

✍️ Beschreiben Sie ausführlich in einer README.md, wie Ihre Applikation gestartet und ausgeführt wird. Legen Sie eine geeignete Möglichkeit (Skript, Export, …) bei, Ihre Datenbank wiederherzustellen.

Siehe Read.me

# 10 Allgemeines

- [ ] Ich habe die Rechtschreibung überprüft
- [ ] Ich habe überprüft, dass die Nummerierung von Testfällen und User Stories übereinstimmen
- [ ] Ich habe alle mit ✍️ markierten Teile ersetzt
