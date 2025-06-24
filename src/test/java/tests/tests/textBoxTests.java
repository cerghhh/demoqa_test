package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class textBoxTests {

    @BeforeAll
    static void Beforeall(){
        Configuration.browserSize = "1020x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void FillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("cerghhh");
        $("#userEmail").setValue("cerghhh@mail.com");
        $("#currentAddress").setValue("Some Street 1 ");
        $("#permanentAddress").setValue("Another Street 2  ");
        $("#submit").click();

        $("#output").$(By.cssSelector("#name")).shouldHave(text("Name:cerghhh"));
        $("#output").$(By.cssSelector("#email")).shouldHave(text("Email:cerghhh@mail.com"));
        $("#output").$(By.cssSelector("#currentAddress")).shouldHave(text("Current Address :Some Street 1"));
        $("#output").$(By.cssSelector("#permanentAddress")).shouldHave(text("Permananet Address :Another Street 2"));

    }
}