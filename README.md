# GitHub_gruppo2: officina meccanica

Progetto realizzato per l'esame di Ingegneria del Software, A.A. 2015/2016 (Università degli studi di Cassino e del Lazio Meridionale - Facoltà di Ingegneria)

Introduzione
L’obiettivo del progetto è stata la realizzazione di un sistema client/server. 
Il sistema in questione, in particolare, si occupa della gestione degli interventi di riparazione all'interno di un'officina meccanica. L'intento finale è quello di gestire delle schede riferite al singolo intervento di riparazione: per ogni intervento viene assegnato un meccanico che si occupa di identificare le operazioni da effettuare e i pezzi di ricambio necessari per l’intervento.  Nell'officina poi troviamo un magazziniere che analizza le richieste provenienti dai meccanici e fornisce i pezzi di ricambio necessari all'intervento. Inoltre l’amministrazione dell’officina stabilisce se si tratta di un intervento coperto da  garanzia. 
Il sistema prevede la creazione di una scheda di riparazione, da parte dell’amministrazione, per ognuno dei veicoli in entrata in officina. Sia i meccanici che il magazziniere avranno accesso in lettura  e in modifica alle varie schede.

Motivazione
Si intende in questo modo avere una gestione organizzata  delle schede di riparazione dei veicoli presenti in officina, così che sia possibile stabilire in modo semplice e veloce se un determinato intervento è  coperto da garanzia.

Installazione
Per utilizzare questo software è necessario installare sul proprio PC un ambiente di sviluppo: nel caso specifico è stato utilizzato Eclipse. Per avviare il software è necessario, innanzitutto, eseguire il file “Server.java” presente nel package “it.uniclam.progettoOfficinaMeccanica”, successivamente eseguire il file ClientGUI.java per la visualizzazione della GUI relativa alla gestione della tabella del personale ( che sarà utilizzata dalla sola amministrazione), oppure si eseguirà il file “AmmGestSchedeGUI” per la visualizzazione della GUI relativa alle schede dell’intervento di riparazione (utile sia per l’amministrazione che per i meccanici ed il magazziniere). Il database è stato realizzato con mySql Workbench e la connessione è stata stabilita usando l’apposito driver.

Team Project
Addolorata Montaquila – Pino Di Meo

Licenza
Open Source
