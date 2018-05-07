package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    PreInsuranceSteps preInsuranceSteps = new PreInsuranceSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();

    @When("^выбран пункт меню (.+)$")
    public void selectMainMenuItem(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран вид страховки (.+)$")
    public void selectSubMenuItem(String menuItem) {
        mainSteps.setSelectSubMenu(menuItem);
    }

    @Then("^выполнена проверка заголовка (.+)$")
    public void checkTitle(String menuItem) {
        preInsuranceSteps.stepCheckTitle(menuItem);
    }

    @When("^нажата кнопка Оформить онлайн")
    public void clickSendButton() {
        preInsuranceSteps.stepSendButton();
    }

    @When("^выполнен переход на новую страницу$")
    public void checkNewPage() {
        insuranceSteps.stepSelectNewPage();
    }

    @When("^выбрана (.+) сумма$")
    public void checkSum(String menuItem) {
        insuranceSteps.stepSelectInsurance(menuItem);
    }

    @Then("^выполнено нажатие на кнопку Оформить$")
    public void clickButton() {
        insuranceSteps.stepClickButton();
    }

    @Then("^началось оформление$")
    public void checkDataPage() {
        insuranceSteps.checkDataPage();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields) {
        insuranceSteps.fillFields(fields.asMap(String.class, String.class));
    }

    @When("^значения полей равны:$")
    public void checkFields(DataTable fields) {
        insuranceSteps.checkFillFields(fields.asMap(String.class, String.class));
    }

    @When("^выбран пол (.+)$")
    public void fillSex(String sex) {
        insuranceSteps.fillSex(sex.toUpperCase().contains("М"));
    }

    @When("^выполнено нажатие на кнопку Продолжить")
    public void clickNext() {
        insuranceSteps.stepClickButtonNext();
    }

    @Then("^выполнена проверка сообщения об ошибке (.+)$")
    public void checkMassage(String menuItem) {
        insuranceSteps.checkErrorMessageField(menuItem);
    }

}