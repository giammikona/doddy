# doddy
programma per inviare messaggi in base al genere dei contatti (per ora).

## da cosa è composto
il programma è  scritto in Scala ed è composto dalle classi:
 - customer
 - contactBook
 - message
 - messageBook
 - sender

Per utilizzare il programma sono necessari:
 - file .csv con almeno le colonne per il nome, cognome, numero di telefono, genere (o proprietà) del contatto (deve contere l'intestazione)
 - un file .txt per messaggio che si vuole inviare ad ogni cluster di utenti

### customer
la classe costituisce l'elemento fondamentale del contactBook e presenta le seguenti proprietà: 
 - name:String
 - lastName:String
 - number: String
 - gender: String
e supporta i metodi getter.
I file .csv che vengono passati al programma tramite i contactBook devono essere costruiti tenendo in mente le proprietà dei customer.

### contactBook
un contactBook costituisce la rubrica del programma. Il costruttore presenta:
 - path: String  _ovvero il filepath del file .csv da cui attingere la rubrica_
 - namePointer: Int _vale per tutti i **pointer**: la colonna in cui è contenuto l'attributo_
 - lastNamePointer: Int 
 - numberPointer:Int
 - genderPointer: Int
 - separator: String _il separator del file .csv_
Il contact book di default cicla sul .csv e costruisce la rubrica che poi può essere manipolata attraverso i metodi
 - add(customer: customer) _aggiungge un customer alla rubrica_
 - remove(customer: customer) _rimuovo un customer dalla rubrica_
è possibile inoltre accedere ai customer tramite i metodi
 - get(index: Ind) _restituisce un il customer selezionato_
 -get_cont_by_gender(gender: String) _restituisce un contactBook composto da customer che rispettano il parametro indicato_
 
 ### message
 costituisce l'elemento fondamentale del messageBook, costituisce il singolo messaggio. Di default viene generato da un file .txt
 il cui path viene passato nel costruttore. E' inoltre necessario specificare a chi è diretto il messaggio (gender).
 supporta il toString e i getter del messaggio e del path
 
 ### messageBook
 è la rubrica dei messaggi. I metodi utilizzati sono gli stessi per il contactBook.
 
 ### sender
 serve per spedire effettivamente i messaggi. in questo momento (V0) bisogna incollare il metodo offerto dal provider di servizi per
 inviare i messaggi. In ogni caso, i metodi per inviare messaggi (indifferenziati) e per genere sono implementati (appunto basta 
 incollare lo script proposto dal fornitore)
