import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillForm {
    @BeforeAll
    static void configuration() {
        Configuration.browserSize  = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void cssForm() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Max");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("Pupkin@mail.ru");
        $("#genterWrapper").find(byText("Male")).click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month").find(byText("15")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").find(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("png/2.png");
        $("#currentAddress").setValue("First st. 1");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Max Pupkin"));
        $(".table-responsive").shouldHave(text("Pupkin@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9998887766"));
        $(".table-responsive").shouldHave(text("15 April,1999"));
        $(".table-responsive").shouldHave(text("History"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("2.png"));
        $(".table-responsive").shouldHave(text("First st. 1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}