package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void Beforeall(){
    Configuration.browserSize = "1920x1080";
        Configuration.timeout = 100000;
    }


    @Test
    void FillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("cerghhh");
        $("#userEmail").setValue("cerghhh@mail.com");
        $("#currentAddress").setValue("Some Street 1 ");
        $("#permanentAddress").setValue("Another Street 2  ");
        $("#submit").click();

        $("[id=search]").shouldHave(text("https://selenide.org"));
    }
}