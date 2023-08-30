package demoqa;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;




public class RegistrationForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Novruz");
        $("#lastName").setValue("Salakhov");
        $("#userEmail").setValue("Novruz@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8925884338");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1993")).click();
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("Moscow");
        $("#stateCity-wrapper #state").click();
        $("#state").$(byText("NCR")).click();
        $("#stateCity-wrapper #city").click();
        $("#city").$(byText("Noida")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));


        $x("//td[contains(text(), 'Student Name')]/../td[2]").shouldHave(text("Novruz Salakhov"));
        $x("//td[contains(text(), 'Student Email')]/../td[2]").shouldHave(text("Novruz@mail.ru"));
        $x("//td[contains(text(), 'Gender')]/../td[2]").shouldHave(text("Male"));
        $x("//td[contains(text(), 'Mobile')]/../td[2]").shouldHave(text("8925884338"));
        $x("//td[contains(text(), 'Date of Birth')]/../td[2]").shouldHave(text("17 May,1993"));
        $x("//td[contains(text(), 'Subjects')]/../td[2]").shouldHave(text("English"));
        $x("//td[contains(text(), 'Hobbies')]/../td[2]").shouldHave(text("Sports"));
        $x("//td[contains(text(), 'Address')]/../td[2]").shouldHave(text("Moscow"));
        $x("//td[contains(text(), 'State and City')]/../td[2]").shouldHave(text("NCR Noida"));


    }
}