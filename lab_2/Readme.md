Zadanie w dowolnym języku. 
Napisać proste DAO oparte o wczytywanie danych z plików tekstowych zamiast bazy danych i zapisywanie oparte o singleton.

Dane w bazie niech będą takie:

##### Dane Użytkownika:
 - ID,Imię, Nazwisko, Rok, Kara.

##### Tabela książek:
 - ID,Tytuł, Autor, User_ID
 
Tak to jest biblioteka.
Dane przechowujemy w formacie CSV np.
Users:

`1;Jan;Nowa;1988;5` <br>
`2;Janina;Nowak;1788;16` <br>
Books: <br>
`1;Stary człowiek i nie może;2`


Funkcjonalności:
 - Dodawanie użytkowników 
 - usuwanie 
 - modyfikowanie
 - listowanie 
 
To samo z książkami, także ma być opcja wypożyczania i zwracania.