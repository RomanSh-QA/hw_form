import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class fill_form {
    @BeforeAll
    static void configuration() {
        Configuration.browserSize  = "1920x1080";
    }

    @Test
    void cssForm() {
        open("https://demoqa.com/automation-practice-form/");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Max");
        $("#lasttName").setValue("Pupkin");
        $("#userEmail").setValue("Pupkin@mail.ru");
        $("#genter-radio-1").parent().click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1999");
        $("[class=react-datepicker__week]").find(byText("15")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").selectRadio("Music");
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
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
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("First st. 1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));


    }
}