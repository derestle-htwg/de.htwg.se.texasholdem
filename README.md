# de.htwg.se.texasholdem
## Allgemein
Das Programm besteht aus einer Setup Routine und anschließen dem eigentlichen Spiel.
In der Setup Routine werden die Spieler eingetragen und das Startgutgaben so wie die Blinds festgelegt.
Anschließend kann man mit Spiel starten das spiel starten.
!()[http://abload.de/img/poker2zyks.png]
### Setup
Aus dem Git-Repository muss über den Link https://github.com/derestle-htwg/de.htwg.se.texasholdem.git das Projekt herunter geladen werden.
Die benötigten Bibliotheken sind in dem Projekt enthalten. Anschließend muss man das Projekt in Eclipse importieren und kann es direkt ausführen.
## Regeln
Hold'em ist heutzutage wahrscheinlich das weltweit bekannteste und beliebteste Pokerspiel.

Jeder Spieler beginnt mit zwei Hole-Karten. Es gibt drei Runden mit Gemeinschaftskarten. Diese Runden werden aufgedeckt gegeben, sodass sie jeder Spieler verwenden kann, wobei es nach jeder Runde eine Einsatzrunde gibt.

Es gewinnt der Spieler, der aus den fünf Gemeinschaftskarten und den beiden Hole-Karten das beste Fünf-Karten-Blatt zusammenstellt.

Jede neue Runde beginnt mit einem Einsatz (dem Small Blind), einem weiteren Einsatz (dem Big Blind) und einer Einsatzrunde. Die Regeln für den Wetteinsatz variieren je nachdem, ob man Limit, Pott-Limit oder No-Limit (Kein Limit) spielt.

Wenn die erste Einsatzrunde beendet ist, gibt der Dealer die ersten drei Gemeinschaftskarten aus, den so genannten Flop. Es folgt eine Einsatzrunde.

Dann gibt der Dealer die vierte Gemeinschaftskarte aus, genannt Turn. Es folgt eine Einsatzrunde.

Dann gibt der Dealer die fünfte Gemeinschaftskarte aus, genannt River. Es folgt eine abschließende Einsatzrunde.

Nach der letzten Einsatzrunde wird die Software den Pott an das beste Blatt auszahlen.

Bei allen Hold'em-Spielen gibt es ein Small Blind und einen Big Blind. Dies sind erzwungene Wetteinsätze, die durch die Position des Dealers (Dealer Button) bestimmt werden. Diese Einsätze sind so genannte "live Bets" und jeder Spieler der Runde muss entweder mit dem Big Blind mitgehen, erhöhen oder passen. Der Dealer-Button bewegt sich im Uhrzeigersinn um den Tisch, sodass jeder Spieler an die Reihe kommt, den Small Blind oder Big Blind zu setzen.

Beim Limit-Hold'em-Spiel ist der Einsatz für jede Einsatzrunde festgelegt. Beim $5/$10-Spiel beträgt der Small Blind $ 2,50, der Big Blind $ 5 und die ersten beiden Einsatzrunden sind Erhöhungen um $ 5. Die letzten beiden Einsatzrunden sind Erhöhungen um $ 10. Es gibt maximal drei weitere Erhöhungen pro Einsatzrunde.

Beim Pott-Limit-Spiel kann ein Spieler jeden Betrag vom Mindesteinsatz bis zum Gesamtumfang des Potts setzen. In einem $5/$10-Pott-Limit-Spiel beträgt der Small Blind $ 5 und der Big Blind $ 10. Der erste Spieler kann mit dem Big Blind mitgehen (in diesem Fall $ 10) oder auf jeden Betrag bis zum Gesamtumfang des Potts erhöhen. Die Erhöhung muss entweder dem vorangegangenen Einsatz oder der vorangegangenen Erhöhung entsprechen oder ihn/sie übersteigen. In diesem Fall würde eine Erhöhung im Gesamtumfang des Potts $ 25 betragen ($ 5 Small Blind + $ 10 Big Blind + $ 10 Mitgehen), das bedeutet, dass der Spieler 3 gesamt $ 35 einsetzen kann. Angenommen Spieler 3 macht eine Erhöhung in der Höhe des Gesamtumfangs des Potts, dann beträgt der Gesamtpott nun $ 50.

Wenn der nächste Spieler weiterspielen möchte, muss er mit $ 35 mitgehen, also der Höhe des Wetteinsatzes von Spieler 3. Wenn der Spieler um das Maximum erhöhen möchte, würde er $ 120 einsetzen, was dem Gesamtbetrag des Potts ($ 50) plus einer Erhöhung von $ 70 ($ 35 Mitgehen + $ 35 Erhöhung) entspricht.

Beim No-Limit-Spiel kann ein Spieler jeden Betrag vom Mindesteinsatz bis zur maximalen Zahl an Chips, die er vor sich hat, setzen. Wie beim Pott-Limit-Spiel hat man im $5/$10-No-Limit-Spiel Small Blinds in der Höhe von $ 5 und Big Blinds in der Höhe von $ 10.

Bei Hold'em-Turnieren erhöhen sich die Blinds in zeitlich festgelegten Abständen. Und obwohl es beim Hold'em gewöhnlich keine Antes gibt, werden bei Turnieren in den späteren Runden Antes gesetzt, die sich nach den höher werdenden Einsatzlimits richten.
