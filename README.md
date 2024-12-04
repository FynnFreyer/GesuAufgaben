# Abgabe 1

In dieser Abgabe fangen wir an mit Genomsequenzdaten im FastQ-Format zu arbeiten.
Da noch nicht besprochen wurde wie Dateien eingelesen werden wird ein simpler FastQ-Parser vorgegeben.

## FastQ

[FastQ](https://en.wikipedia.org/wiki/FASTQ_format) ist ein einfaches Textformat, das genutzt wird um Sequenzdaten und die dazugehörigen Qualitäten gebündelt zu speichern.
Jede Sequenz besteht aus einem vier Zeilen umfassenden Eintrag, mit

- einer Read-ID,
- den Sequenzsymbolen (gelesene Basen),
- einem `+`, welches als Seperator dient und
- in [Phred](https://en.wikipedia.org/wiki/Phred_quality_score)[^phred33] kodierten Qualitätswerten

[^phred33]: Üblicherweise Phred-33, aber Phred-64 ist auch gebräuchlich.

Die Read-ID bekommt das Präfix `@`.
Der Inhalt einer FastQ-Datei könnte beispielsweise so aussehen:

```fastq
@Read-ID_1
CTCACTTTTTTATCCCTTTTGTTTCTTTTAC
+
FGFGA898F,6C,C@E<6,<666C,C,,+++
@Read-ID_2
AAAAGCATTAACAGCATGAAGGAGTTAAAAATTCCTGAAA
+
<8<CFDC9<9E<FF99,C,,;CE,C,,,,,,,,,,,,,;;
```

Eine Beispieldatei steht Ihnen unter `assets/sample.fastq` zur Verfügung.

## Aufgaben

Die folgenden Aufgaben sollen in dieser Abgabe von Ihnen bearbeitet werden.

### 1. Qualität und Fehlerwahrscheinlichkeit

In der Vorlesung haben wir besprochen, wie wir Qualitätswerte berechnen.
Die Qualitätswerte $Q$ ergeben sich mithilfe der folgenden Formel aus der Fehlerwahrscheinlichkeit $P$.

$$
Q = -10 \cdot \log_{10} P
$$

### 1. a) Berechnung von Qualitäten aus Fehlerwahrscheinlichkeiten

Implementieren Sie in der Klasse `PhredCode` die Methode `toQuality`, die eine Fehlerwahrscheinlichkeit entsprechend der Formel in einen Qualitätswert umwandelt.
Runden Sie das Ergebnis auf die nächste ganze Zahl.

Nutzen Sie auch die Methoden aus [`Math`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Math.html), wie z.B. `Math.round` um Zahlen zu runden.

### 1. b) Berechnung von Fehlerwahrscheinlichkeiten aus Qualitäten

Implementieren Sie in der Klasse `PhredCode` die Methode `toProbability`, die einen Qualitätswert in eine Fehlerwahrscheinlichkeit umwandelt.

Wenn wir aus den Qualitätswerten die Fehlerwahrscheinlichkeit ableiten wollen, müssen wir diese Formel nach $P$ umstellen.
Wer sich nicht mehr an die [Logarithmusgesetze](https://en.wikipedia.org/wiki/List_of_logarithmic_identities) erinnert, findet die umgestellte Formel möglicherweise in den Folien, oder im Internet ...

### 2. Arbeiten mit Phred-kodierten Qualitätswerten

Die Qualitätswerte, mit denen wir arbeiten, werden in FastQ-Dateien mittels [Phred](https://en.wikipedia.org/wiki/Phred_quality_score)-Kodierung dargestellt.
Dabei werden die Qualitäten mit einem bestimmten Versatzwert (genannt `offset`) in [ASCII](https://en.wikipedia.org/wiki/ASCII#Printable_characters)-Werte umgewandelt.

Die Klasse `PhredCode` soll Qualitätswerte anhand eines solchen `offset` kodieren und dekodieren können.
Der `offset` ist innerhalb der Methoden, die sie im Folgenden anpassen sollen, als `this.offset` verfügbar.

#### 2. a)

Implementieren Sie in `PhredCode` die Methoden `decode` und  `decodeMany`.
Diese dekodieren einen, bzw. mehrere, Phred-kodierte Qualitätswerte.

#### 2. b)

Implementieren Sie in `PhredCode` die Methoden `decode` und  `decodeMany`.
Diese dekodieren einen, bzw. mehrere, Phred-kodierte Qualitätswerte.
