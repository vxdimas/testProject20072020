package ru.bellintegrator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class PageObjectGoogle {
    private WebDriver chromeDriver;
    WebElement searchField;
    List<WebElement> resultSearch;
    List<WebElement> resultSearchLink;

    public List<WebElement> getResultSearchLink() {
        return chromeDriver.findElements(By.xpath("//*[@class=\"iUh30 bc tjvcx\"]"));
    }

    public  List<WebElement> getResultSearch() {
        return chromeDriver.findElements(By.xpath("//*[@class=\"rc\"]"));
    }

    PageObjectGoogle(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]"));
    }

    public void find(String wordFind) {
        searchField.click();
        searchField.sendKeys(wordFind);
        searchField.sendKeys(Keys.ENTER);
    }
}



