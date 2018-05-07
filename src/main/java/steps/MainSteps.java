package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MainSteps {
    @Step("Выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        new MainPage().selectMainMenu(menuItem);
    }

    @Step("Выбран вид страхования {0}")
    public void setSelectSubMenu(String menuItem) {
        new MainPage().selectSubMenu(menuItem);
    }
}