package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Authclient {
    @BeforeAll
    static void Beforeall(){
        Configuration.browserSize = "1020x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void FillFormTest() {
        //сайт
        open("/automation-practice-form");
        //имя и фамилия
        $("#firstName").setValue("cerghhh");
        $("#lastName").setValue("Ryzhov");
        //почта
        $("#userEmail").setValue("cerghhh@mail.com");
        //гендер
        $("label[for=gender-radio-1]").click();
        //телефон
        $("#userNumber").setValue("920481598411");
        //дата рождения
        $("#dateOfBirthInput").shouldBe(Condition.visible).click();
        $$("[role='option']").filter(Condition.visible).first().click();
        //хобби
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        //фото
        $("#uploadPicture").uploadFromClasspath("i-_1_ (1).png");
        $("#currentAddress").setValue("Some Street 1 ");
        //проживание
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
    }
}
