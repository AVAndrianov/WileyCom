package avandrianov.com.stepdefs;

import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.exceptions.PageException;

import java.util.Arrays;
import java.util.List;

import static avandrianov.com.helpers.TestHelper.getAssertSteps;
import static avandrianov.com.helpers.TestHelper.getStepDefs;

public class WileyCom {
    private Logger logger = LoggerFactory.getLogger(WileyCom.class);
    private List<String> list = null;
    private List<WebElement> searchHeaders = null;
    private List<WebElement> searchHeaders2 = null;

    /**
     * Open https://www.wiley.com/en-us
     * Check the following links are displayed in the top menu
     * - Who We Serve
     * - Subjects
     * - About
     */
    @Тогда("^open \"([^\"]*)\"$")
    public void openURL(String URL) throws NoSuchMethodException, PageException, InterruptedException {
        getStepDefs().goToUrl(URL);
        getStepDefs().openPage("Main page");
        getStepDefs().userActionTwoParams("заполняет поле", "SearchField", "Открытие");
        getStepDefs().userActionOneParam("нажимает кнопку", "SearchButton");

    }
 /**
     * Open https://www.wiley.com/en-us
     * Check the following links are displayed in the top menu
     * - Who We Serve
     * - Subjects
     * - About
     */
    @Тогда("^open2 \"([^\"]*)\"$")
    public void openURLw(String URL) throws NoSuchMethodException, PageException, InterruptedException {
        getStepDefs().goToUrl(URL);
        getStepDefs().openPage("Main page");
        getStepDefs().userActionOneParam("нажимает кнопку", "Button:No");
        getAssertSteps().elementIsDisplayed("WHO WE SERVE");
        getAssertSteps().elementIsDisplayed("SUBJECTS");
        getAssertSteps().elementIsDisplayed("ABOUT");
    }

    /**
     * Check items under Who We Serve for sub-header
     * - There are 11 items under resources sub-header
     * - Titles are  “Students”, “Instructors”, “Book Authors”, “Professionals”, “Researchers”, “Institutions”, “Librarians”, “Corporations”, “Societies”, “Journal Editors”,  “Government”
     */
    @Тогда("^check items under Who We Serve for sub-header$")
    public void checkItemsUnderWhoWeServeForSubHeader() throws PageException {
        list = Arrays.asList(
                " Students ",
                " Instructors ",
                " Book Authors ",
                " Professionals ",
                " Researchers ",
                " Institutions ",
                " Librarians ",
                " Corporations ",
                " Societies ",
                " Journal Editors ",
                " Government "
        );
        checkListOfItems(list, "WHO WE SERVE - subMenuList");
    }

    /**
     * Click “Students” item
     * - Check that https://www.wiley.com/en-us/students url is opened
     * - Check that “Students” header is displayed
     * - Check that “Learn More” links are present on the page and direct to  www.wileyplus.com site
     */
    @Тогда("^click \"([^\"]*)\" item$")
    public void clickStudentsItem(String subMenuName) throws PageException, InterruptedException {
        PageFactory.getActions().moveToElement(PageFactory.getInstance().getCurrentPage().getElementByTitle("WHO WE SERVE")).perform();
        Thread.sleep(500);
        PageFactory.getActions().moveToElement(PageFactory.getInstance().getCurrentPage().getElementByTitle("WHO WE SERVE:" + subMenuName)).click().perform();

        if (PageFactory.getWebDriver().getCurrentUrl().equals("https://www.wiley.com/en-ru/students"))
            logger.info("https://www.wiley.com/en-us/students страница открыта");
        else
            logger.error("https://www.wiley.com/en-us/students страница не открыта");
        checkWhichPageLoaded(subMenuName);
        getAssertSteps().elementIsDisplayed("activePage");
        AssertationsSteps.elementAttributeCheck("Learn More", "textContent", "Learn More");
        AssertationsSteps.elementAttributeCheck("Learn More href", "href", "https://www.wileyplus.com");
    }

    /**
     * Go to “Subjects” top menu, select “Education”
     * - Check “Education” header is displayed
     * - 13 items are displayed under “Subjects” on the left side of the screen and the texts are
     * - "Information & Library Science",
     * - "Education & Public Policy",
     * - "K-12 General",
     * - "Higher Education General",
     * - "Vocational Technology",
     * - "Conflict Resolution & Mediation (School settings)",
     * - "Curriculum Tools- General",
     * - "Special Educational Needs",
     * - "Theory of Education",
     * - "Education Special Topics",
     * - "Educational Research & Statistics",
     * - "Literacy & Reading",
     * - "Classroom Management"
     */
    @Тогда("^go to \"([^\"]*)\" top menu, select \"([^\"]*)\"$")
    public void goToTopMenuSelectSubMenu(String menuName, String subMenuName) throws PageException, InterruptedException {
        PageFactory.getActions().moveToElement(PageFactory.getInstance().getCurrentPage().getElementByTitle(menuName)).perform();
        Thread.sleep(500);
        PageFactory.getActions().moveToElement(PageFactory.getInstance().getCurrentPage().getElementByTitle(menuName + ":" + subMenuName)).click().perform();
        list = Arrays.asList(
                "Education & Public Policy",
                "K-12 General",
                "Higher Education General",
                "Vocational Technology",
                "Conflict Resolution & Mediation (School settings)",
                "Curriculum Tools- General",
                "Special Educational Needs",
                "Theory of Education",
                "Education Special Topics",
                "Educational Research & Statistics",
                "Literacy & Reading",
                "Classroom Management"
        );
        checkListOfItems(list, "List item under Subjects");
    }

    /**
     * Click on the Wiley logo at the top menu (left side of the top menu)
     * - Home page is opened
     */
    @Тогда("^click on the Wiley logo at the top menu left side of the top menu$")
    public void clickOnTheWileyLogoAtTheTopMenuLeftSideOfTheTopMenu() throws NoSuchMethodException, PageException, InterruptedException {
        getStepDefs().userActionOneParam("нажимает кнопку", "Wiley");
        checkWhichPageLoaded("Homepage");
    }

    /**
     * Do not enter anything in the search input and press search button
     * - Nothing happens, home page is still displayed
     */
    @Тогда("^do not enter anything in the search input and press search button$")
    public void doNotEnterAnythingInTheSearchInputAndPressSearchButton() throws NoSuchMethodException, PageException, InterruptedException {
        getStepDefs().userActionOneParam("нажимает кнопку", "Search Button");
        checkWhichPageLoaded("Homepage");
    }

    /**
     * Enter “Java” and do not press search button
     * - Area with related content is displayed right under the search header
     * - On the “Suggestions” section, it has 4 words starting with “Java”
     * - On the “Products” section, there are 5 titles and each title contain “Java” word
     */
    @Тогда("^enter \"([^\"]*)\" and do not press search button$")
    public void enterJavaAndDoNotPressSearchButton(String searchWord) throws NoSuchMethodException, PageException, InterruptedException {
        getStepDefs().userActionTwoParams("заполняет поле", "Search Field", searchWord);
        Thread.sleep(3000);
        List<WebElement> searchHeadersSuggestions = PageFactory.getInstance().getCurrentPage().findListOfElements("Search Headers:Suggestions");
        List<WebElement> searchHeadersProducts = PageFactory.getInstance().getCurrentPage().findListOfElements("Search Headers:Products");
        numberOfElements("Suggestions", searchHeadersSuggestions, 4);
        numberOfElements("Products", searchHeadersProducts, 5);
        for (WebElement a : searchHeadersSuggestions) {
            getAssertSteps().elementIsDisplayed(a);
            if (!a.getText().startsWith("java"))
                logger.error("Titles not start with Java are displayed");
        }
        checkOfComplianceOfElements(searchHeadersProducts, searchWord);
    }

    /**
     * Click 'SEARCH' button
     * - Only titles containing “Java” are displayed
     * - There are 10 titles
     * - Each title has at least one “Add to Cart” button
     */
    @Тогда("^click SEARCH button$")
    public void clickSearchButton() throws NoSuchMethodException, PageException, InterruptedException {
        getStepDefs().userActionOneParam("нажимает кнопку", "Search Button");
        searchHeaders = PageFactory.getInstance().getCurrentPage().findListOfElements("Search Headers");
        numberOfElements("SearchList", searchHeaders, 10);
        checkOfComplianceOfElements(searchHeaders, "Java");
    }
    //*[@id="addToCartForm9781118104699"]/button
    /**
     * Enter “Java” in the search input at the top and press SEARCH button
     * - Make sure there are same 10 titles shown (as in step 8)
     */
    @Тогда("^enter Java in the search input at the top and press SEARCH button$")
    public void enterJavaInTheSearchInputAtTheTopAndPressSearchButton() throws NoSuchMethodException, PageException {
        getStepDefs().userActionOneParam("нажимает кнопку", "Search Button");
        searchHeaders2 = PageFactory.getInstance().getCurrentPage().findListOfElements("Search Headers");
        if (searchHeaders2.size() == searchHeaders.size())
            for (int i = 0; i < searchHeaders2.size(); i++) {
                if (!searchHeaders.get(i).getText().equals(searchHeaders2.get(i).getText()))
                    logger.error("Not same 10 titles shown (as in step 8)");
            }
        else
            logger.error("Not same 10 titles shown (as in step 8)");
    }

    private void checkListOfItems(List<String> list, String elementsName) throws PageException {
        boolean flag;
        int amountElementsSubMenu = PageFactory.getInstance().getCurrentPage().findListOfElements(elementsName).size();
        List<WebElement> listOfElements = PageFactory.getInstance().getCurrentPage().findListOfElements(elementsName);
        if (amountElementsSubMenu == list.size())
            logger.info("В подзаголовке ресурсов " + list.size() + " пунктов");
        else
            logger.error("В подзаголовке ресурсов не " + list.size() + " пунктов");
        for (String s : list) {
            flag = true;
            for (WebElement listOfElement : listOfElements) {
                if (listOfElement.getAttribute("text").trim().equals(s.trim())) {
                    logger.info("Все Ок " + listOfElement.getAttribute("text").trim() + "  " + s.trim());
                    flag = false;
                    break;
                }
            }
            if (flag) {
                logger.error("Элемент содержащий текст: " + s.trim() + " не найден.");
            }
        }
    }

    private void checkWhichPageLoaded(String titleNameWeNeed) {
        String titleName = PageFactory.getWebDriver().getTitle();
        if (titleName.contains(" ")) {
            titleName = titleName.substring(0, titleName.indexOf(" "));
        }
        if (titleName.equals(titleNameWeNeed))
            logger.info("Вы находитесь на странице " + titleNameWeNeed);
        else
            logger.error("Вы находитесь на странице отличной от " + titleNameWeNeed);
    }

    private void numberOfElements(String name, List<WebElement> list, int number) {
        if (list.size() != number)
            logger.error(name + " are not " + number + " titles");
    }

    private void checkOfComplianceOfElements(List<WebElement> list, String word) throws PageException, InterruptedException {
        for (WebElement a : list) {
            getAssertSteps().elementIsDisplayed(a);
            if (!a.getText().contains(word))
                logger.error("Titles not containing " + word + " are displayed");
        }
    }
}