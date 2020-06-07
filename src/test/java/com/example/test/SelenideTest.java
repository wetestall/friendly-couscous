package com.example.test;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {

    String title = "Банк «Открытие» — вклады, кредитные и дебетовые карты, кредиты наличными, " +
            "рефинансирование, ипотечное кредитование и другие услуги для частных клиентов и бизнеса";
    /*
        * Задача:
·         запустить Chrome
·         открыть https://www.google.com/
·         написать в строке поиска «Открытие»
·         нажать Поиск
·         проверить, что результатах поиска есть https://www.open.ru
·         перейти на сайт https://www.open.ru
·         проверить в блоке «Курс обмена в интернет-банке», что курс продажи больше курса покупки, для USD и для EUR.
      * */
    @Test(groups = {"ui"})
    public void searchLinkInGoogleAndJump() throws MalformedURLException {

        com.example.test.MyConfig conf = new com.example.test.MyConfig();
        DesiredCapabilities dc = new DesiredCapabilities("chrome", "81.0.4044.138", Platform.LINUX);
        RemoteWebDriver driver =new RemoteWebDriver(new URL(conf.remote()), dc);
        WebDriverRunner.setWebDriver(driver);

        open("https://google.ru");

        $(By.name("q")).setValue("Открытие").pressEnter();
        $x("//div[@class='r']/a[@href='https://www.open.ru/']").shouldBe(visible).click();
        switchTo().window(title);  // переключился в другую вкладку, т.к. в контейнере ссылка открывается в другой вкладке

        String bu = $x("//tr[2]/td[2]/div/span").shouldBe(visible).getText().replace(",",".");
        double sumBuy_USD = Double.parseDouble(bu);
        String su = $x("//tr[2]/td[4]/div/span").getText().replace(",",".");
        double sumSell_USD = Double.parseDouble(su);
        String be = $x("//tr[3]/td[2]/div/span").getText().replace(",",".");
        double sumBuy_EUR = Double.parseDouble(be);
        String se = $x("//tr[3]/td[4]/div/span").getText().replace(",",".");
        double sumSell_EUR = Double.parseDouble(se);

        WebDriverRunner.closeWebDriver();

        Assert.assertTrue(sumBuy_USD<sumSell_USD, "Цена продажи доллара меньше покупки");
        Assert.assertTrue(sumBuy_EUR<sumSell_EUR, "Цена продажи евро меньше покупки");

    }
}
