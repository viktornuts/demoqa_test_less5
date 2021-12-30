package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption(month);
        $("[class='react-datepicker__year-select']").selectOption(year);
        String dayLocator = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayLocator).click();


    }
}
