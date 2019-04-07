package avandrianov.com.stepdefs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;

import static avandrianov.com.helpers.ElementsHelper.getElementOrThrow;
import static avandrianov.com.helpers.ElementsHelper.isElementInCondition;
import static junit.framework.TestCase.fail;

public class AssertationsSteps {

    private static Logger logger = LoggerFactory.getLogger(AssertationsSteps.class);

    //Проверка, что элемент отображен на странице
    public static void elementIsDisplayed(String param) throws PageException, InterruptedException {
        WebElement webElement = getElementOrThrow(param);
        boolean webElementState = isElementInCondition(ExpectedConditions.visibilityOf(webElement));
        if (!webElementState) {
            logger.error("Element \"" + param + "\" is not visible");
        }
    }

    //Проверка, что элемент отображен на странице
    public static void elementIsDisplayed(WebElement param) throws PageException, InterruptedException {
        boolean webElementState = isElementInCondition(ExpectedConditions.visibilityOf(param));
        if (!webElementState) {
            logger.error("Element \"" + param + "\" is not visible");
        }
    }

    //Проверка, что атрибут элемента содержит в себе заданное значие "value"
    public static void elementAttributeCheck(String element, String attribute, String value) throws PageException, InterruptedException {
        WebElement el = getElementOrThrow(element);
        boolean res = isElementInCondition(ExpectedConditions.attributeContains(el, attribute, value));
        if (!res) {
            fail("Element's \"" + element + "\" attribute \"" + attribute + "\" doesn't have value \"" + value + "\". It's value = \"" + el.getAttribute(attribute) + "\"");
        }
        logger.info("It's value = \"" + value + "\"");
    }
}
