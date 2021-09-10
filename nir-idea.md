# Number In Range (nir)

> Di Michele Gregorelli

tipo di dato che contiene un numero compreso in un range di limiti finiti

il compito di questo tipo di dato è creare numeri che sono definiti tra due limiti, cosi che i costruttori e le funzioni possano richiedere numeri in un intervallo prescelto e non si debbano preoccupare della gestione di valori non validi

tutto questo sempre tenendo una velocità e consumo di memoria paragonabile ai normali numeri (int), ma potendo risparmiare tutti i controlli e la gestione delle eccezioni

Esempio: funzione richiede solo numeri (compresi)

- positivi (tra 0 ed ∞)
- tra 0 e 100
- tra 0 ed un massimo variabile
- tra -5 e 5

## migliore implementazione dell'idea (ma attualmente impossibile)

nei linguaggi attuali non è possibile ma i nir potrebbe essere una classe derivata dalla classe **nir** chiamata (per esempio) `nir[0-100]` cosi che possa venire utilizzato questo tipo di dato per poi creare, separatamente gli oggetti

Esempio:

```java
//definizione del tipo di dato
nir[0-100] = nir.createRange(0, 100);

//creazione di un numero che sottostà ai limiti imposti dal tipo
nir[0-100] num = new nir[0-100] (5);
nir[0-100] num = new nir[0-100] (70);
nir[0-100] num = new nir[0-100] (567); //ridotto al limite massimo

//utilizzi
fun(nir[0,∞] num) {}
fun(nir[0,100] num) {}
fun(nir[0, mutable] num) {}
fun(nir -5,5] num) {}
```

questo metodo sarebbe il migliore ma non è realizzabile attualmente siccome il tipo derivato è sostanziamente una classe che estende la classe **nir**, quindi a meno che non vengano create infinite estensioni che verranno più utilizzate, serve uno strumento che crei classi in automatico (compilate ovviamente)

## implementazione

siccome l'implementazione superiore non è possibile negli attuali linguaggi si potrebbe farla cosi:

```java
fun(nir nir.of(0,100,num))  {}
```

ma questo modo comporta una continua ricostruzione e quindi rallentamenti

forse la migliore implementazione attualmente fattibile risulta cosi:

```java
fun(nir num) {/*do some stuff*/}
nir n = nir.of(0,50,13);
fun(n);
```

ma anche questa presenta un problema, siccome alla funzione si potrebbe passare un nir con limiti diversi da quelli che si aspetta

## memorizzazione

la memorizazzione del numero deve essere tale che non possa fisicamente avere valori esterni al range

potrebbe essere realizzato tramite somme di numeri di diversa grandezza

es:

- 1+2+4
- 1+8
- 1024
- 4+32+64 (in bit: 2+5+6)

questi blocchi (array di boolean) potrebbero essere adatti alla memorizzazione ma potrebbero generare complicazioni se il numero viene modificato (add, sub, mul, div, mod)

si potrebbe anche realizzarlo tramite normali int, questo renderebbe l'implementazione molto più semplice ma ci dovranno essere controlli nel costruttore per validare che sia contenuto nel range e per eventuali modifiche

## svantaggi

è possibile che la lentezza dovuta alla memorizzazione e modifiche sia molto più lunga di una normale assegnazione ed una serie di controlli

## vantaggi

l'affidabilità e l'assenza di accezioni da gestire potrebbero essere notevoli vantaggi (l'unica eccezione possibile è se il nir viene inizializzato come null e poi utilizzato)

potrebbe fare diminuire drasticamente il numero di eccezioni da gestire, risolvere i problemi di input errati e velocizzare i software togliendo tutti i controlli di valutazione dei parametri

## limiti mutabili

sarebbe molto più facile se i limiti si potessero solo aumentare siccome i numeri precedentemente validi rimarranno sempre validi

diminuendo il range alcuni numeri prima validi potrebbero non venire più supportati, si dovranno fare molti più controlli e le performance peggiorerebbero notevolmente tanto che non sarebbe più assolutamente conveniente

## limiti compresi (od esclusi)

ho creduto che sia meglio comprendere i limiti perchè il questo modo i costruttori sono sempre possibili, basta infatti un solo numero valido (e sono tutti validi) affinche si possa creare un nir, ma se sono esclusi si potrebbero verificare inizializzazioni impossibili:

```java
nir n = nir.of(5,5,5) //min, max, value
```

questa non è valida siccome i limiti sono uguali e l'unico valore viene escluso

## valori mutabili

bisogna capire se è sensato che numeri del genere possane essere mutabili, e bisogna ancora prima definire il campo di utilizzo, cioè se vengono utilizzati come sostituto dei numeri (int,long) (tipi di dati fondamentali) oppure vengono utiizzati solo quando si passano i valori a metodi o funzioni

nel primo caso i numeri mutabili sono d'obbligo mentre nel secondo l'immutabilità è una scelta più sensata

infine, se si decidesse per valori mutabili bisognerebbe chiedersi cosa succede quando un valore raggiunge e supera un limite

(questa decisione è de prendere, indipendentemente dalla mutabilità del valore, per i costruttori)

- riparte dall'altro limite come se fosse un cerchio che si ripete (come i tipi fondamentali)
- si ferma al limite, siccome è il massimo valore che può raggiungere

## idee sulla progettazione

il consumo di memoria sarebbe almeno tre volte superiore rispetto ad un solo numero (min, max, num)

si potrebbe sostituire min e max con puntatori (Integer) se i limiti sono mutabili (dimensione di una lista), in questo modo la sincronizzazione sarà automatica perchè fa riferimento direttamente al valore corretto (da valutare l'utilità)

la progettazione riguarderà principalmente la velocità di costruzione per memorizzare il valore in tempi vicini all'assegnazione fra int

Questo può venire fattori riducendo i controlli all'essenziale oppure tramite una memorizzazione che non necessita di controlli (**memorizzazione**)

il fatto che la classe viene passata per riferimento indica maggiore velocità