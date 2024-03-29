# M223: Punchclock
Dies ist das Abschlussprojekt des überbetrielbichen Kurses Modul 223.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 11 (12 = depracated) installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console

Folgender Pfad ist ohne abgeschlossene Authentifizierung erreichbar: http://localhost:8081/login.html

## Funktionalität
Folgende Funktionalität wird angeboten:

- Zeiterfassungstool
- Kategorieverwaltung
- Jobverwaltung
- Nutzerverwaltung
- JWT mit Spring