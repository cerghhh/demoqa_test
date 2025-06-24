package tests.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class authClient {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1020x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout=100000;
    }


    @Test
    void fillFormTest() {
        //сайт
        open("/automation-practice-form");
        //имя и фамилия
        $("#firstName").setValue("cerghhh");
        $("#lastName").setValue("Ryzhov");
        //почта
        $("#userEmail").setValue("cerghhh@mail.com");
        //гендер
        $("#genterWrapper").$(byText("Male")).click();
        //телефон
        $("#userNumber").setValue("9204815984");
        //дата рождения
        $("#dateOfBirthInput").shouldBe(Condition.visible).click();
        $$("[role='option']").filter(Condition.visible).first().click();

        $("#subjectsInput").setValue("Che");
        $$(".subjects-auto-complete__option").findBy(text("Chemistry")).click();
        //хобби
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        //фото
        $("#uploadPicture").uploadFromClasspath("i-_1_ (1).png");
        $("#currentAddress").setValue("Some Street 1 ");
        //проживание
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        //Проверка
        $(".table-responsive").shouldHave(text("cerghhh Ryzhov"));
        $(".table-responsive").shouldHave(text("cerghhh@mail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9204815984"));
        $(".table-responsive").shouldHave(text("01 June,2025"));
        $(".table-responsive").shouldHave(text("Chemistry"));
        $(".table-responsive").shouldHave(text("Music, Sports"));
        $(".table-responsive").shouldHave(text("i-_1_ (1).png"));
        $(".table-responsive").shouldHave(text("Some Street 1 "));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
        $("#id=closeLargeModal").click();
    }
}
