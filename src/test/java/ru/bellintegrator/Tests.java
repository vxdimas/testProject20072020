package ru.bellintegrator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings{

    @Test
    /*      Тест кейс номер 1.
            "Проверка поиска слова Гладиолус в поисковике Google.ru"
            Шаги: 1. зайти на сайт Google.ru
                  2. Выполнить поиск слова Гладиолус
                  3. Осуществить проверку на количество результатов поиска. Необходимо не менее трех.
     */
    public void testGoogleSearch() {
        chromeDriver.get("https://www.google.ru/");
        PageObjectGoogle googleSearch = new PageObjectGoogle(chromeDriver);
        googleSearch.find("Гладиолус");
        Assertions.assertTrue(
                googleSearch.getResultSearch().size() > 3
                , "Результатов поиска заданного слова менее 3"

        );
    }

    @Test
    /*      Тест кейс номер 2.
            "Наличие среди результатов поиска слова Гладиолус в поисковике Google.ru сайта Википедии"
            Шаги: 1. зайти на сайт Google.ru
                  2. Выполнить поиск слова Гладиолус
                  3. Проверить наличие сайта Википедии (ru.wikipedia.org) среди результатов поиска
     */
    public void testGoogleSearchWikipedia() {
        chromeDriver.get("https://www.google.ru/");
        PageObjectGoogle googleSearch = new PageObjectGoogle(chromeDriver);
        googleSearch.find("Гладиолус");
        Assertions.assertTrue(
                googleSearch.getResultSearchLink().stream().anyMatch(x->x.getText().contains("ru.wikipedia.org"))
                , "Среди результатов поиска отсутствует сайт Википедии"
        );
    }
}