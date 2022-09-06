# Temat projektu: System do katalogowania i zarządzania książkami z funkcjami społecznościowymi.

 
## SPIS TREŚCI

1. PROJEKT APLIKACJI – OPIS I WSTĘPNE ZAŁOŻENIA PROJEKTOWE
2. WYKORZYSTANE TECHNOLOGIE
3. PROJEKT BAZY DANYCH
4. INTERFEJS REST API
5. WDROŻENIE SYSTEMU
6. INTERFEJS UŻYTKOWNIKA
7. PODSUMOWANIE

# 1. PROJEKT APLIKACJI – OPIS I WSTĘPNE ZAŁOŻENIA PROJEKTOWE

## 1.1. Wstęp

Celem pracy jest opracowanie i implementacja projektu aplikacji internetowej, na wzór takich serwisów jak lubimyczytac.pl lub goodreads.com, której zadaniem jest umożliwienie użytkownikowi prowadzenia katalogu książek, które przeczytał. Poszczególni użytkownicy będą mogli ocenić daną książkę w skali 1-5 oraz wystawić jej opcjonalną recenzję. Ponadto jeżeli użytkownik nie znajdzie interesującej go książki w bazie danych aplikacji, będzie mógł ją dodać samodzielnie. Aby mieć dostęp do wyżej wymienionych funkcjonalności użytkownik musi najpierw założyć konto a następnie się na nie zalogować. W systemie zalogowani użytkownicy będą podzieleni na dwie kategorię: user i admin. Admin poza wszystkimi prawami przysługującymi zwykłemu użytkownikowi będzie miał dostęp do funkcjonalności która jest zarezerwowana tylko dla niego tj. możliwość usuwania książek oraz edycji i usuwania ocen i komentarzy innych użytkowników. W przypadku użytkowników nieposiadających konta w serwisie ich możliwości będą ograniczały się jedynie do przeglądania książek oraz profili innych użytkowników.


 # 1.2. Aktorzy

## 1.2.1. Opis aktorów

1.	Gość - aktor odwiedzający serwis który nie posiada konta, ma ograniczone uprawnienia. Ma możliwość samodzielnego założenia konta w celu zwiększenia swoich uprawnień.

2.	Użytkownik - aktor posiadający wszystkie uprawnienia aktora Gość oraz uprawnienia pozwalające mu na zarządzanie swoim profilem. Może mieć wpływ na stan wewnętrzny systemu poprzez np. dodanie nowych treści do serwisu.
3.	Administrator - aktor posiadający najwyższe uprawnienia w systemie, pozwalające mu na zarządzanie tym systemem. Posiada również wszystkie uprawnienia przysługujące innym aktorom.

 ## 1.2.2. Hierarchia aktorów

<center>
Gość ←Użytkownik←Administrator

Gdzie ← oznacza kierunek dziedziczenia: nadklasa ← podklasa.

 </center>
 ## 1.3. Wymagania funkcjonalne

1.	Rejestracja i logowanie - funkcjonalność umożliwiająca Gościowi założenie konta a następnie zalogowanie się na nie w celu uzyskania dostępu do funkcjonalności przeznaczonych tylko dla zarejestrowanych użytkowników.

2.	Przeglądanie katalogu książek - funkcjonalność umożliwiająca Gościowi i wszystkim aktorom od niego dziedziczącym na przeglądanie dostępnego katalogu książek w systemie.

3.	Przeglądanie ocen użytkowników - funkcjonalność umożliwiająca Gościowi i wszystkim aktorom od niego dziedziczącym przeglądanie ocen i komentarzy wystawionych przez Użytkownika i Administratora.

4.	Przeglądanie danych użytkownika - funkcjonalność umożliwiająca Gościowi i wszystkim aktorom od niego dziedziczącym przeglądanie danych na temat danego Użytkownika i Administratora.
5.	Dodawanie książki do systemu - funkcjonalność umożliwiająca Użytkownikowi i wszystkim aktorom od niego dziedziczącym dodanie do systemu nowej książki
6.	Usunięcie i modyfikacja książki - funkcjonalność umożliwiająca Administratorowi usunięcie lub modyfikację książki która znajduje się w systemie.
7.	Dodanie oceny i komentarza do systemu - funkcjonalność umożliwiająca Użytkownikowi i wszystkim aktorom od niego dziedziczącym dodanie oceny i opcjonalnego komentarza na temat wybranej książki.
8.	Usuwanie i modyfikacja komentarzy i ocen książki - funkcjonalność umożliwiająca Użytkownikowi usunięcie i modyfikację oceny i komentarza którego jest autorem. Administrator posiada tą samą funkcjonalność jednak umożliwia mu ona również zarządzanie komentarzami i ocenami dodanymi przez innych użytkowników.

## 1.4. Wymagania niefunkcjonalne

1.	Jako język programowania po stronie serwera powinien być wykorzystany język Java w wersji co najmniej 17 wraz z szkieletem programistycznym Spring Boot 2.6.7.
2.	System po stronie serwera powinien udostępniać REST API.
3.	Jako serwer webowy system powinien wykorzystywać serwer Tomcat 9.0.12.
4.	Jako narzędzie budowania i zarządzania zależnościami dla języka Java powinien zostać wykorzystany Apache Maven 3.8.
5.	System powinien wykorzystywać MySQL jako system zarządzania bazą danych.
6.	Hasła użytkowników powinny być przechowywane w bazie danych w formie skrótu.
7.	Do obliczania skrótów haseł powinna być wykorzystana funkcja bycrypt.
8.	Do autentykacji i autoryzacji powinny być wykorzystane tokeny JWT weryfikowane po stronie serwera.
9.	Po stronie klienta system powinien wykorzystywać język znaczników HTML5, język arkuszy stylów CSS3 oraz język programowania JavaScript w wersji co najmniej ES6.
10.	Strona internetowa powinna zostać zbudowana w technice SPA (Single-page application), przy wykorzystaniu szkieletu programistycznego Vue.js 3.

11.	Jako menedżer pakietów języka JavaScript powinien być wykorzystany npm.
12.	Do konteneryzacji aplikacji powinno zostać wykorzystane narzędzie Docker 20.10.7 oraz docker-compose 1.29.2.

13.	Strona internetowa powinna posiadać jednolitą oprawę graficzna.
14.	Strona internetowa powinna być responsywna.
15.	System powinien działać na komputerach z systemem Windows, Linux oraz na telefonach i tabletach z systemem Android.
16.	System obsługiwany na komputerach powinien działać na przeglądarkach Chrome, Firefox oraz Opera.
