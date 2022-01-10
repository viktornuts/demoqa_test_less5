package guru.qa.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderMaleInput = $("#genterWrapper").$(byText("Male")),
            genderFemaleInput = $("#genterWrapper").$(byText("Female")),
            genderOtherInput = $("#genterWrapper").$(byText("Other")),
            subjectInput = $("#subjectsInput"),
            hobbieSportInput = $("[for='hobbies-checkbox-1']"),
            hobbieReadingInput = $("[for='hobbies-checkbox-2']"),
            hobbieMusicInput = $("[for='hobbies-checkbox-3']"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("[placeholder='Current Address']"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input");


    public RegistrationPage openPage() {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }


    public RegistrationPage typeFirsName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage typeEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage typeUserNumber(String number) {
        userNumberInput.setValue(number);

        return this;
    }

    public RegistrationPage typeGenderMale() {
        genderMaleInput.click();

        return this;
    }

    public RegistrationPage typeGenderFemale() {
        genderFemaleInput.click();

        return this;
    }

    public RegistrationPage typeGenderOther() {
        genderOtherInput.click();

        return this;
    }

    public RegistrationPage typeSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage typeHobbieSport() {
        hobbieSportInput.click();

        return this;
    }

    public RegistrationPage typeHobbieReading() {
        hobbieReadingInput.click();

        return this;
    }

    public RegistrationPage typeHobbieMusic() {
        hobbieMusicInput.click();

        return this;
    }

    public RegistrationPage typeUploadPicture(String filePath) {
        uploadPictureInput.uploadFile(new File(filePath));

        return this;
    }

    public RegistrationPage typeCurrentAddress(String Address) {
        currentAddressInput.scrollTo().setValue(Address);

        return this;
    }

    public RegistrationPage typeState(String State) {
        stateInput.setValue(State).pressEnter();

        return this;
    }

    public RegistrationPage typeCity(String City) {
        cityInput.setValue(City).pressEnter();

        return this;
    }

    public RegistrationPage assertForm() {
        $$x("//*[@class='modal-body']//td[2]").shouldHave(CollectionCondition.exactTexts(
                "Viktor Slon",
                "viktornuts@gmail.com",
                "Male",
                "8955245541",
                "21 June,1990",
                "English, Maths, Commerce",
                "Sports, Music, Reading",
                "lesson5.txt",
                "Nikolaya Shishka 21",
                "Rajasthan Jaiselmer"));

        return this;
    }


}

