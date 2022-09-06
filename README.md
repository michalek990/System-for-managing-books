# Temat projektu: System do katalogowania i zarządzania książkami z funkcjami społecznościowymi.

 
# SPIS TREŚCI

1. PROJEKT APLIKACJI – OPIS I WSTĘPNE ZAŁOŻENIA PROJEKTOWE
2. WYKORZYSTANE TECHNOLOGIE
3. PROJEKT BAZY DANYCH
4. INTERFEJS REST API
5. WDROŻENIE SYSTEMU
6. INTERFEJS UŻYTKOWNIKA
7. PODSUMOWANIE

# 1. PROJEKT APLIKACJI – OPIS I WSTĘPNE ZAŁOŻENIA PROJEKTOWE

1.1. Wstęp

Celem pracy jest opracowanie i implementacja projektu aplikacji internetowej, na wzór takich serwisów jak lubimyczytac.pl lub goodreads.com, której zadaniem jest umożliwienie użytkownikowi prowadzenia katalogu książek, które przeczytał. Poszczególni użytkownicy będą mogli ocenić daną książkę w skali 1-5 oraz wystawić jej opcjonalną recenzję. Ponadto jeżeli użytkownik nie znajdzie interesującej go książki w bazie danych aplikacji, będzie mógł ją dodać samodzielnie. Aby mieć dostęp do wyżej wymienionych funkcjonalności użytkownik musi najpierw założyć konto a następnie się na nie zalogować. W systemie zalogowani użytkownicy będą podzieleni na dwie kategorię: user i admin. Admin poza wszystkimi prawami przysługującymi zwykłemu użytkownikowi będzie miał dostęp do funkcjonalności która jest zarezerwowana tylko dla niego tj. możliwość usuwania książek oraz edycji i usuwania ocen i komentarzy innych użytkowników. W przypadku użytkowników nieposiadających konta w serwisie ich możliwości będą ograniczały się jedynie do przeglądania książek oraz profili innych użytkowników.
