package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderMaleInput = $("#genterWrapper").$(byText("Male")),
            genderFemaleInput = $("#genterWrapper").$(byText("Female")),
            genderOtherInput = $("#genterWrapper").$(byText("Other"));



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

    public RegistrationPage typeGenderMale(){

        genderMaleInput.click();
        return this;

    }

    public RegistrationPage typeGenderFemale(){

        genderFemaleInput.click();
        return this;

    }

    public RegistrationPage typeGenderOther(){

        genderOtherInput.click();
        return this;

    }
}

