Secretariat.java

Predominant am utilizat hashmap-uri pentru gestionarea datelor, deoarece am putut accesa rapid informatiile cu ajutorul cheilor si pentru ca ofera eficienta in operatiile 
de insertie si cautare. Pentru cursuri am folosit o lista de string-uri datorita usurintei cu care le puteam parcurge.
Intai declar colectiile, apoi fac constructorul fara parametrii. 
Primele doua metode, 'creeazaStudLicenta' si 'creeazaStudMaster' creeaza si returneaza un anumit tip de student, verificand situatia in care un student este duplicat, 
caz in care arunca exceptia corespunzatoare.
Metoda 'adaugaStudent' adauga studentul primit ca parametru in hash-urile 'studenti' si 'studentiContestatie', care contin toate obiectele de tip student, avand drept 
cheie numele fiecaruia.
Metoda 'SortareStudentiDescrescatorMedie' ia lista de studenti si apoi o sorteaza descresctor in functie de media studentului,iar daca exista mai multi studenti cu 
aceeasi medie, ii sorteaza alfabetic.
Metoda 'afisareStudentiDescrescatorMedie' realizeaza scrierea in fisier a outputului corespunzator. Metoda primeste lista de studenti sortata, apoi deschide fisierul 
primit ca parametru si scrie numele studentului, apoi media acestuia.
Metoda 'verificaDuplicat' arunca exceptia corespunzatoare daca numele studentului este deja in hash-ul de studenti.
Metoda 'adaugaNota' primeste ca parametru numele unui student si nota acestuia. Foloseste functia get pentru a gasi obiectul cu numele respectiv, apoi adauga nota folosind 
functia setMedie.
Metoda 'adaugaCurs' adauga cursul primit ca parametru in lista de cursuri.
Metoda 'adaugaPreferinta' primeste ca parametru numele studentului si o lista cu cursuri si le adauga in hash.
Metoda 'gasesteCapacitateCurs' primeste numele unui curs pe care il cauta in lista de cursuri, apoi foloseste functia getCapacitate pentru a returna capacitatea 
acelui curs.
Metoda 'gasesteMedie' primeste numele unui student pe care il foloseste drept cheie pentru a cauta studentul in hash-ul de studenti , apoi foloseste functia getMedie 
pentru a returna media acelui student.
Metoda 'gasesteMedieMinimaLaCurs' primeste numele unui curs. Foloseste lista de cursuri din hash-ul repartizareCursuriStudenti si cauta in acel curs studentul cu cea 
mai mica medie, apoi o retuneaza.
Metoda 'repartizeaza' realizeaza repartizarea studentilor la cursuri. Intai, creeaza hash-ul repartizareCursuriStudenti, care contine numele cursurilor si o lista 
cu studentii repartizati la fiecare curs. Apoi, sorteaza preferintele studentilor descrescator dupa medie si creeaza lista preferinteSortate. Se parcurge lista sortata 
a preferintelor studentilor si pentru fiecare student si lista sa de preferinte (preferinteStudent) se face adaugarea la un curs in functie de capacitatea acestuia si de 
media minima la curs. Daca un student este adaugat cu succes la un curs, se seteaza studentAdaugat pe true si se iese din bucla interna pentru a evita adaugarea aceluiasi 
student la mai multe cursuri. Daca studentul nu a fost adaugat la niciun curs, este alocat la cursul cu cea mai mica medie minima.
Metoda 'gasesteCursCuMinimaMedie' cauta cursul cu cea mai mica medie pentru cazul in care un student nu a fost repartizat la niciun curs.
Metoda 'posteazaCurs' primeste ca parametru numele unui curs si un fisier, apoi cauta cursul in hash-ul repartizareCursuriStudenti pentru a obtine lista de studenti 
pentru acel curs. Apoi sorteaza studentii alfabetic si face afisarea corespunzatoare in fisier.
Metoda 'stergeContinutColectii' sterge continutul tuturor colectiilort., pentru a nu se amesteca datele testelor.
Metoda 'afiseazaInFisierStudent'  primeste ca parametru numele unui student si un fisier, apoi cauta studentul in hash-ul studenti. Realizeaza afisarea corespunzatoare, 
obtinand tipul studentului, si cursul la care face parte, folosind metoda 'gasesteCursStudent'.
Metoda 'gasesteCursStudent' primeste numele unui student, apoi itereaza prin fiecare curs din hash-ul repartizareCursuriStudenti si cauta studentul la fiecare curs.
Cand a gasit studentul, returneaza numele cursului.


Student.java

Clasa Student contine variabilele membru nume si medie, constructorul care initializeaza variabila pentru nume, setterele si getterele pentru nume si medie si 
metoda toString pentru afisarea unui obiect de tip Student.

StudentLicenta.java si StudentMaster.java

Aceste clase extind clasa parinte Student.

StudentDuplicatException.java

Aceasta clasa are rolul de a arunca o exceptie de tip StudentDuplicatException atunci cand se detecteaza ca se incearca adaugarea unui student duplicat. Aceasta 
exceptie contine un mesaj specific care indica numele studentului duplicat. 

Curs.java

Clasa Curs contine variabilele membru pentru nume, capacitate si lista de studenti, unde folosesc genericitatea pentru a adauga corect studentii la curs, in functie
de tip.
Metoda 'adaugaStudent' adauga un student de un anumit tip in hash-ul de studenti doar daca mai  este loc.
Metoda 'afisare' afiseaza studentii de un anumit tip.
Metoda 'areLocuriDisponibile' verifica daca un curs mai are locuri.

Main.java

Clasa Main contine implementarea pentru fiecare test. Inainte, creez un obiect de tip Secretariat, pentru a lucra cu metodele acestei clase.

01,02,03,04:
Incep prin a deschide fisierul .in pentru a citi comenzile si apelez metoda 'stergeStudenti' pentru a nu amesteca datele testelor. Apoi, urmeaza separarea 
argumentelor din fiecare comanda dupa '-'.Pentru acest lucru, adaug intr-un vector elementele comenzii, putand atfel sa lucrez cu fiecare argument in parte. 
Pentru comanda 'adauga_student' folosesc metoda 'adaugaStudent' in functie de tipul studentului. Pentru comanda 'contestatie', convertesc al treilea element din 
comanda (adica media), la tipul double si o adaug studentului, folosind metoda 'adaugaNota'.Pentru comanda 'citeste-mediile', trec prin toate fisierele care incep 
cu prefixul 'note_' si folosesc acelasi procedeu de extragere a argumentelor din liniile fisierelor, dupa care adaug notele studentilor.Pentru comanda 'posteaza_mediile',
deschid fisierul .out corespunzator si apelez metoda 'afisareStudentiDescrescatorMedie'.


05,06,07,08,09,10:
Incep prin a deschide fisierul .in pentru a citi comenzile si apelez metoda 'stergeStudenti' pentru a nu amesteca datele testelor. Apoi, urmeaza separarea argumentelor 
din fiecare comanda dupa '-'.Pentru acest lucru, adaug intr-un vector elementele comenzii, putand atfel sa lucrez cu fiecare argument in parte. Pentru comanda 'adauga_student' 
folosesc metoda 'adaugaStudent' in functie de tipul studentului. Pentru comanda 'contestatie', convertesc al treilea element din comanda (adica media), la tipul 
double si o adaug studentului, folosind metoda 'adaugaNota'. Pentru comanda 'adauga_preferinte', extrag numele studentului din comanda si creez o lista de stringuri care contine 
restul argumentelor din comanda, adica numele cursurilor unde ar vrea studentul sa fie repartizat. Dupa crearea acestei liste, apelez metoda 'adaugaPreferinta', pentru a adauga in 
hash numele studentului si lista de cursuri la care ar dori repartizat. Pentru comanda 'citeste-mediile', trec prin toate fisierele care incep cu prefixul 'note_' 
si folosesc acelasi procedeu de extragere a argumentelor din liniile fisierelor, dupa care adaug notele studentilor.Pentru comanda 'posteaza_mediile', deschid 
fisierul .out corespunzator si apelez metoda 'afisareStudentiDescrescatorMedie'.Pentru comanda 'repartizeaza' apelez metoda cu acelasi nume pentru a realiza 
repartizarea studentilor.Pentru comanda 'adauga_curs', creez un obicet din functie de tipul cursului apoi il adaug in lista cursurilor. Pentru comanda 'posteaza_curs', 
apelez metoda cu acelasi nume pentru a afisa detaliile cursului. Pentru comanda 'posteaza_student' apelez metoda 'afiseazaInFisierStudent', pentru a afisa detaliile
despre student.

11,12:
Incep prin a deschide fisierul .in pentru a citi comenzile si apelez metoda 'stergeStudenti' pentru a nu amesteca datele testelor. Apoi, urmeaza separarea 
argumentelor din fiecare comanda dupa '-'.Pentru acest lucru, adaug intr-un vector elementele comenzii, putand atfel sa lucrez cu fiecare argument in parte. 
Pentru comanda 'adauga_student' folosesc metoda 'adaugaStudent' in functie de tipul studentului, iar in situatia in care un student a mai fost deja adaugat, se 
afiseaza in fisier mesajul corespunzator. Pentru comanda 'contestatie', convertesc al treilea element din comanda (adica media), la tipul double si o adaug 
studentului, folosind metoda 'adaugaNota'. Pentru comanda 'adauga_preferinte', extrag numele studentului din comanda si creez o lista de stringuri care contine 
restul argumentelor din comanda, adica numele cursurilor unde ar vrea studentul sa fie repartizat. Dupa crearea acestei liste, apelez metoda 'adaugaPreferinta', 
pentru a adauga in hash numele studentului si lista de cursuri la care ar dori repartizat. Pentru comanda 'citeste-mediile', trec prin toate fisierele care incep 
cu prefixul 'note_' si folosesc acelasi procedeu de extragere a argumentelor din liniile fisierelor, dupa care adaug notele studentilor.Pentru comanda 'posteaza_mediile', 
deschid fisierul .out corespunzator si apelez metoda 'afisareStudentiDescrescatorMedie'.Pentru comanda 'repartizeaza' apelez metoda cu acelasi nume pentru a realiza 
repartizarea studentilor.Pentru comanda 'adauga_curs', creez un obicet din functie de tipul cursului apoi il adaug in lista cursurilor. Pentru comanda 'posteaza_curs', 
apelez metoda cu acelasi nume pentru a afisa detaliile cursului. Pentru comanda 'postea













