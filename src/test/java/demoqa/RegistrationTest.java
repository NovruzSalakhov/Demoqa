package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;




public class RegistrationTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest () {
        open("/automation-practice-form");

        $("#firstName").setValue("Novruz");
        $("#lastName").setValue("Salakhov");
        $("#userEmail").setValue("Novruz-Salakhov@mail.ru");
        $("#userNumber").setValue("123456789");
        $("#currentAddress").setValue("Tverskaya District 69");
        $("#gender-radio-3").parent().click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1993");
        $("#submit").click();





    }
}
