package guru.qa.tests;

import guru.qa.pages.RegistrationPage;
import guru.qa.pages.components.CalendarComponent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;


public class PracticeFormWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFromTest() {
        registrationPage.openPage()
                .typeFirsName("Viktor")
                .typeLastName("Slon")
                .typeEmail("viktornuts@gmail.com")
                .typeGenderMale()
                .typeUserNumber("8955245541");

        CalendarComponent calendarComponent = new CalendarComponent();
        calendarComponent.setDate("21", "June", "1990");

        registrationPage.typeSubject("English")
                .typeSubject("Math")
                .typeSubject("Commerce")
                .typeHobbieSport()
                .typeHobbieMusic()
                .typeHobbieReading()
                .typeUploadPicture("src/test/java/guru/qa/docs/lesson5.txt")
                .typeCurrentAddress("Nikolaya Shishka 21")
                .typeState("Raj")
                .typeCity("Jaise");
        $("#submit").click();

        registrationPage.assertForm();


    }


}
