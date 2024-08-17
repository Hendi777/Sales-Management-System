# Sales-Management-System
The application was written in Java Swing technology with a database connection.
<ul>
<li>The application has an entry form to the application, i.e. login and password.</li>
<li>It has a method that generates a random login and password after creating a new account.</li>
<li>We add the product sold by the company to the database and then we can display the products in the form of a JTable.</li>
<li>The application also has buttons to go to specific bookmarks and the ID of the person who is logged in in the lower left corner.</li>
<li>The application has validation of all fields and validation of duplicates in the SQL database</li>
<li>Unfortunately, I was unable to create a ScrollPane for the table, so I will have to fix it in the future.</li>
<li>The database which the application is connected is my local one on the computer, which I also intend to change in the future so that everyone can see in full how the application works.</li>

--------------------------------------------------------------



<p>2. Projekt w stylu dodawania sprzedaży do bazy danych i podglądu produktów z danymi w tabeli, użytkownik musi posiadać konto by mieć dostęp do aplikacji, program z połączeniem z bazą danych.</p>

<p>3. Struktura projektu: </p>
<li>LOGOWANIE</li>
<li>REJESTRACJA</li>
<li>DODAWANIE PRODUKTU DO BAZY DANYCH</li>
<li>PODGLĄD PRODUKTÓW W BAZIE DANYCH W TABELI</li>
<li>I WIELE INNYCH CIEKAWYCH RZECZY W TYCH SEKCJACH</li>
<p></p>
<p>4. W projekcie wykorzystuję technologie jaką jest JAVA SWING jest to dość stara technologia dlatego projekt nie jest dopieszczony, ponieważ teraz pracuję nad bardziej zaawansowaną technologią jaką jest SPRING i na tym się skupiam w 100%... w projekcie jeszcze występuje baza danych więc SQL też się pojawia</p>

<p>5. Na projekt wpadłem sam, był on moim pierwszym chciałem przetestować moje umiejętności Javy i SQL</p>

<p>6. Największy problem sprawił mi ScrollPane, który w rezultacie nie został dodany.</p>

<p>7. Projekt może nie jest dopieszczony ale dla mnie jest skończony teraz zajmuję się SPRINGiem więc nie będę już pracować nad tym projektem</p>

<p>8. Po zrobieniu tego projektu, jedyny wniosek , który mi się nasuwa to taki, że mogłem go skończyć szybciej i zająć się użyteczniejszą technologią :)</p>
</ul>

-----------------------------------------------------------------------------------------------------------------------

<p>FORMULARZ DO REJESTRACJI</p>

![signup](https://github.com/Hendi777/Sales-Management-System/assets/141283682/eea3f604-723d-4943-8bdf-2ca5dd2b4380)  
<p>WALIDACJA</p>

![validation](https://github.com/Hendi777/Sales-Management-System/assets/141283682/01f5dbc3-f5fc-422d-858f-84faaa840a66)
<p>MAM STWORZONĄ FUNKCJĘ KTÓRA GENERUJE UŻYTKOWNIKOWI RANDOMOWY LOGIN 5 CYFROWY ORAZ HASŁO</p>

![signuploginpassword](https://github.com/Hendi777/Sales-Management-System/assets/141283682/e2e3a310-fe04-4102-95b1-36a6f382a8e9)
<p>TAK TO WYGLĄDA W BAZIE DANYCH</p>

![databaseloginpassword](https://github.com/Hendi777/Sales-Management-System/assets/141283682/d9d91907-c160-4592-a62c-bffe470e23b6)
<p>BAZE DANYCH ZABEZPIECZYŁEM ABY UŻYTKOWNIK O TAKICH SAMYCH DANYCH NIE MÓGŁ STWORZYĆ DRUGI RAZ KONTA</p>

![duplicate](https://github.com/Hendi777/Sales-Management-System/assets/141283682/6d4b0234-0af6-4b66-b7c8-04cdfba2ce60)

-----------------------------------------------------------------------------------------------------------------------

<p>TAKIE DANE POSLUZA NAM DO ZALOGOWANIA</p>

![logindatabase](https://github.com/Hendi777/Sales-Management-System/assets/141283682/494a5746-68c8-4363-9b48-3eacbb81dd88)
<p>ZABEZPIECZENIE PRZED NIEPRAWDIŁOWYMI DANYMI</p>

![invalid](https://github.com/Hendi777/Sales-Management-System/assets/141283682/10382d8a-5e6d-4658-be83-5856f8bd2342)
<p>JEST FUNKCJA KTORA UMOZLIWIA PODGLADNIECIE HASLA</p>

![password unvisible](https://github.com/Hendi777/Sales-Management-System/assets/141283682/7e294c97-75d7-4a92-8857-dee8f05fa45d)
![password visible](https://github.com/Hendi777/Sales-Management-System/assets/141283682/cbdb3ec3-f76c-429c-92a3-7ac05e973681)
<p>POMYŚLNE ZALOGOWANIE</p>

![loginsuccessfully](https://github.com/Hendi777/Sales-Management-System/assets/141283682/11f3cfba-d4b7-4544-8c8f-c15f3ef5b26a)

-----------------------------------------------------------------------------------------------------------------------

<p>FORMULARZ DODANIA PRODUKTU, WARTO ZWROCIC UWAGE ZE W PRAWYM DOLNYM ROGU WIDZIMY CZY JESTESMY ZALOGOWANI I NA JAKIM UZYTKOWNIKU</p>

![addproduct](https://github.com/Hendi777/Sales-Management-System/assets/141283682/64ae70b5-2e84-4175-997c-97846214fac7)
<p>WALIDACJA DLA PÓL</p>

![validation](https://github.com/Hendi777/Sales-Management-System/assets/141283682/d266582b-daca-43f6-bdcd-e14784743233)
<p>PRODUKT ZOSTAŁ DDODANY POMYŚLNE</p>

![product added](https://github.com/Hendi777/Sales-Management-System/assets/141283682/e557db06-9c13-4559-9f63-e5d8e6d7894a)

-----------------------------------------------------------------------------------------------------------------------

<p>TAK WYGLĄDA PRODUKT W BAZIE DANYCH</p>

![productsdatabase](https://github.com/Hendi777/Sales-Management-System/assets/141283682/a9693830-2584-4780-8c23-aac72c3406db)
<p>A TAK JE WYŚWIETLAMY PRZEZ KLIKNIĘCIE BUTTONU "SHOW"</p>

![display products](https://github.com/Hendi777/Sales-Management-System/assets/141283682/bec73344-286f-45ea-85ff-7855b0ff384f)
<p>DLA PRZYKŁADU PRODUKT DODANY PRZEZ INNEGO UŻYTKOWNIKA, POKAZUJE NAM ŻE ZOSTAŁ ON DODANY PRZEZ UŻYTKOWNIKA O INNYM LOGINIE</p>

![przyklad](https://github.com/Hendi777/Sales-Management-System/assets/141283682/6f92d450-8025-4fe2-8204-946fbfc2b72b)









