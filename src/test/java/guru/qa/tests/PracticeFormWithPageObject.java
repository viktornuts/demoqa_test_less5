package guru.qa.tests;

import com.codeborne.selenide.CollectionCondition;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;


public class PracticeFormWithPageObject extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFromTest(){
        registrationPage.openPage()
                .typeFirsName("Viktor")
                .typeLastName("Slon")
                .typeEmail("viktornuts@gmail.com")
                .typeGenderMale()
                .typeUserNumber("8955245541");

        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption("June");
        $("[class='react-datepicker__year-select']").selectOption("1990");
        $("[class*='react-datepicker__day--021']").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();

        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();

        $("#uploadPicture").uploadFile(new File("src/test/java/guru/qa/docs/lesson5.txt"));

        $("[placeholder='Current Address']").setValue("Nikolaya Shishka 21");
        $("[placeholder='Current Address']").scrollIntoView(true);
        $("#react-select-3-input").setValue("Raj").pressEnter();
        $("#react-select-4-input").setValue("Jaise").pressEnter();
        $("#submit").click();

        //Assert
        $$x("//*[@class='modal-body']//td[2]").shouldHave(CollectionCondition.exactTexts(
                "Viktor Slon", "viktornuts@gmail.com", "Male", "8955245541", "21 June,1990",
                "English, Maths", "Sports, Reading", "lesson5.txt", "Nikolaya Shishka 21", "Rajasthan Jaiselmer"));

    }



}
