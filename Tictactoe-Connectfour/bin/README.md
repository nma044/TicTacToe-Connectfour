# [Semesteroppgave 2: Fire på rad og Tripp-trapp-tresko]


* **README**
* [Oppgavetekst](SEM-2.md)
* [Tips for å komme i gang](Tips.md)
* [Advanced](Advanced.md)

**Innleveringsfrist:** Hele oppgaven skal være ferdig og levert via din private gitlab-repositorie til **Fredag 24. april kl. 2359** ([AoE](https://www.timeanddate.com/worldclock/fixedtime.html?msg=4&iso=20180427T2359&p1=3399)).  

### Innlevering 
 Du finner koden din i repositoriet med URIen:

    https://retting.ii.uib.no/<brukernavn>/inf101.v20.sem2.git

Oppgaven leveres inn ved å pushe til retting.ii.uib.no, [slik du har gjort med alle tidligere INF101-oppgaver](https://retting.ii.uib.no/inf101/inf101.v20/wikis/hente-levere-oppgaver). Husk å få med eventuelle nye filer du har opprettet.

**VIKTIG:** *Sjekk kvitteringssiden som kommer opp når du pusher, i tilfelle det skjer feil!* 

Vi anbefaler at du gjør commit hver dag, eller hver gang du er ferdig med en
deloppgave, i tilfelle du mister det du jobber med på din egen maskin. Du kan levere inn så mye og ofte du vil. Versjonen som teller er den **siste du pushet før innleveringsfristen**.

Denne oppgaven teller på din endelige vurdering i faget. Maks poeng er 100. Du kan få opp til 120 totalt, inkludert ekstrapoeng. 

# Fyll inn egne svar/beskrivelse/kommentarer til prosjektet under
* Levert av:   Nathaniel Maaskant (nma044)
* [x] hele semesteroppgaven er ferdig og klar til retting!
* Code review:
   * [ ] jeg har fått tilbakemelding underveis fra @brukernavn, ...
   * [ ] jeg har gitt tilbakemelding underveis til @brukernavn, ...
* Sjekkliste:
   * [x] Kjørbart Fire på Rad-spill
	   * [x] Funksjonelt spill 
	   * [x] Fungerende user interface
	   * [x] Støtter AI 
   * [x] Kjørbart Tripp-trapp-tresko-spill
	   * [x] Funksjonelt spill 
	   * [x] Fungerende user interface
	   * [x] Støtter AI 
   * [x] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [x] Tester
   * [x] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [x] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [x] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
Alt ligger i pakken games. Har 3 hovedklasser: Game, Tictactoe og Connect4. Har i tillegg et interface igame som implementeres av Tictactoe og Connect4, og en Main funksjon som kjører spillet. Game klassen styrer hele spillet, og har metoder som brukes i begge spillene, denne klassen står for at spillene spilles og fungerer. Klassene Connect4 og Tictactoe inneholder metoder og variabler som er unike til de respektive spillene, som f. eks spillkartet. 

Alt spilles i terminalen, og spillkartene representeres ved todimensjonale char lister, og printes med nøsta for-løkker. 

### Bruk
For å starte programmet kjør: `Main.java` Denne klassen ligger i pakken games under 
src/main/java

Spillet spilles i terminalen, det står skrevet hva du må skrive for å gjøre hva.
I starten må du skrive inn 1 for å spille tic tac toe, og 2 for å spille connect 4.
Så må du skrive inn 'j' for å spille med to spillere, og 'n' for å spille mot datamaskinen.
Etter dette blir du bedt om å skrive inn spillernavn.
Etterpå starter selve spillet, i tic tac toe må du skrive inn et tall mellom 1-9 for å plassere en brikke (Tenk på kartet som et gammelt mobiltastatur), og i connect 4 må du velge en rad 1-7 for å putte brikken din i det feltet. 

Spillet avsluttes når enten en av spillerne vinner, eller det blir uavgjort ved at brettet fylles opp uten at det finnes en vinner.

## Designvalg
Jeg har valgt å ha en Game klasse som inneholder metoder som brukes i begge spillene, som printmap, gameinput, aiinput osv. Denne klassen styrer hele spillet, sjekker hvilket spill som vil spilles, om det vil spilles multiplayer osv. I Connect4 og Tictactoe klassene er metoder spesifikke til de spillene, som hvordan en spille plasseres, hvordan se etter en vinner, unike brikker og spillkart til de spillene. Dette er gjort sånn at, med litt arbeid i Game ville det gått an å lagt inn et tredje spill i en egen klasse uten for mye styr.

### Bruk av abstraksjon
*(hvordan du har valgt objekter/klasser for å representere ting i spillet)*
Når et spill startes, lages et Game objekt, dette objektet holder styr på de ulike spillerne, om det er multiplayer eller ikke. Når det svares hvilket spill som vil spilles, kopieres verdiene fra disse klassene til game objektet. Si at jeg vil spille tic tac toe, da får Game objektet verdier som Board, inputs og karakterer fra tic tac toe klassen. I game objektet opprettes også et objekt for spillet som spilles, som også holder på viktige verdier, f. eks inneholder tic tac toe objektet spiller1felt, og spiller2felt, som holder styr på hvor spillerne har brikker. Det samme med connect4, som inneholder den todimensjonnele int listen rader, som holder styr på hvem som har brikke hvor. (0 betyr ledig felt, 1 betyr spiller 1 har brikke der, og 2 betyr spiller 2 har brikke der.) Dette brukes for å passe på at ingen plasserer på et tatt felt, og for å sjekke etter vinner/uavgjort. 

### Erfaring – hvilke valg viste seg å være gode / dårlige?
Til å starte laget jeg et funksjonelt tic tac toe spill, da laget jeg alt i en klasse i starten siden jeg syntes dette var lettest, men det viste seg å bli tungvint da jeg skulle lage connect4, og måtte flytte tictactoe i en egen klasse. Dette førte også til at noen av metodene i Game ble litt rotete, da de først kun var skrevet for tic tac toe. Særlig Gameinput ble veldig rotete, og bruker mye "if(tictactoe == true)" og "else", dette kunne jeg gjort bedre for å ha gjort den mer ryddig og lesbar. 

## Testing
Jeg bruker en egen testklasse for hver av de 3 klassene, i tictactoetest og connect4 tester jeg at de ulike metodene gir de forventede verdiene om jeg putter inn spesifikke verdier. I connect4 test f. eks tester jeg at sjekkvinner returnerer true dersom en spiller har 4 på rad enten horsiontalt, vertikalt eller diagonalt, det samme med 3 på rad på tic tac toe. Jeg sjekker også at brikker plasseres på riktige plasser og ikke kan plasseres der det allerede er en brikke. Jeg slet med å teste Game, ettersom flere av metodene her enten bruker scanner for å få inn verdier fra terminalen, eller tar i bruk andre metoder, så flere av metodene i game mangler tester.

## Funksjonalitet, bugs
Brukergrensesnittet i terminal, og spillene virker akuratt som de skaø etter mye testing og endring på ting virker det som at alt fungerer. Jeg slet med at noen ganger vant en spiller i connect4 uten å ha 4 på rad, men dette ser ikke ut til å være et problem etter noen endringer. 

## Evt. erfaring fra code review
for å starte så jeg en youtube video om å lage tic tac toe (https://www.youtube.com/watch?v=gQb3dE-y1S4). Denne videoen ga meg inspirasjon til hvordan jeg kunne lage kartet og hvordan jeg kunne løse problemer, men jeg gjorde det på min egen måte, det måtte jeg også for å implementere AI og Connect4 i spillet. Ved å bygge noe helt fra scratch forsto jeg nå mye bedre hvordan klasser og objekter fungerer, i motsetnig til tidligere lab og semesteroppgaver, hvor vi kun skulle endre på metoder.

## Annet
Jeg laget spillet i terminalen siden jeg syntes det var enklere, og mindre å sette seg inn i. Skulle jeg gjort dette på ny ville jeg nok prøvd å brukt et GUI for å gjøre det mer brukervennlig og finere å se på.
