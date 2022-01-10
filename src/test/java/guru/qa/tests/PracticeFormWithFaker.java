package guru.qa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import guru.qa.pages.components.CalendarComponent;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;


public class PracticeFormWithFaker extends TestBase {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker(new Locale("en"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    int yearOfBirth = faker.number().numberBetween(1920, 2021);
    String yearOfBirth1 = String.valueOf(yearOfBirth);
    String currentAddress = faker.address().fullAddress();


    @Test
    void fillFromTest() {
        registrationPage.openPage()
                .typeFirsName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .typeGenderMale()
                .typeUserNumber(userNumber);

        calendarComponent.setDate("21", "June", yearOfBirth1);

        registrationPage.typeSubject("English")
                .typeSubject("Math")
                .typeSubject("Commerce")
                .typeHobbieSport()
                .typeHobbieMusic()
                .typeHobbieReading()
                .typeUploadPicture("src/test/java/guru/qa/docs/lesson5.txt")
                .typeCurrentAddress(currentAddress)
                .typeState("Raj")
                .typeCity("Jaise");
        $("#submit").click();

        //Assert

        $$x("//*[@class='modal-body']//td[2]").shouldHave(CollectionCondition.exactTexts(
                firstName + " " + lastName,
                email,
                "Male",
                userNumber,
                "21 June," + yearOfBirth1,
                "English, Maths, Commerce",
                "Sports, Music, Reading",
                "lesson5.txt",
                currentAddress,
                "Rajasthan Jaiselmer"));


    }


}
