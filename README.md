# pokerhandcompare
Compares two poker hands and decides the winner

##Note

1. ACE is only considered for high value in case of straight and straight-flush
2. Some of the tests takes input hand as encoded strings with the following convention .
  * A hand is dash (-) separated pairs of character where each pair represents a card.
  * First character of each pair represents the suite and second represents the rank 
  * Suites are presented by H, S, D, C characters.
  * Ranks are represented by 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A
3.Other tests uses the Rank and Suite enums directly.

##Running Instruction 

install JDK 1.8

```
$ export JAVA_HOME=<path to jdk installation>
```

Install maven

```
$ sudo apt-get install maven2
```

Install git

```
$ sudo apt-get install git
```

Clone repo

```
$ git clone git@github.com:neilghosh/pokerhandcompare.git
cd pokerhandcompare
```

Run tests

```
$ mvn test
```
