package avandrianov.com.helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;
import ru.sbtqa.tag.qautils.properties.Props;

import java.util.concurrent.TimeUnit;

public class ElementsHelper {
    private static final int POLLING_TIME = 1000;
    private static final long TIMEOUT = Long.valueOf(Props.get("page.load.timeout"));

    private static Logger log = LoggerFactory.getLogger(ElementsHelper.class);


    public static WebElement getElementOrThrow(String element) throws PageException, InterruptedException {
        WebElement webElement = null;

        TimeoutHelper.initTimeout();
        while (webElement == null && !TimeoutHelper.isTimeout("")) {
            try {
                webElement = PageFactory.getInstance().getCurrentPage().getElementByTitle(element);
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                log.info(e.getMessage());
            }
            Thread.sleep(POLLING_TIME);
        }
        if (webElement == null)
            throw new NoSuchElementException("Element '" + element + "' not found on page '" + PageFactory.getInstance().getCurrentPageTitle() + "'");
        return webElement;
    }

    public static boolean isElementInCondition(ExpectedCondition condition) {
        Wait<WebDriver> wait =
                new FluentWait<>(PageFactory.getWebDriver()).withTimeout(TIMEOUT, TimeUnit.MILLISECONDS).pollingEvery(POLLING_TIME,
                        TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class,
                        StaleElementReferenceException.class);
        try {
            wait.until(condition);
        } catch (Exception e) {
            log.error("Exception on wait for element condition: " + e.getMessage());
            return false;
        }
        return true;
    }
}