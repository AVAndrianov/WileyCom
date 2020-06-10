package avandrianov.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.sbtqa.tag.pagefactory.Page;
import ru.sbtqa.tag.pagefactory.PageFactory;
import ru.sbtqa.tag.pagefactory.annotations.ElementTitle;
import ru.sbtqa.tag.pagefactory.annotations.PageEntry;

import java.util.List;

@PageEntry(title = "Main page")
public class WileyComPages extends Page {

    @ElementTitle(value = "SearchField")
    @FindBy(xpath = "//input[@title='Поиск']")
    private WebElement searchField;

    @ElementTitle(value = "SearchButton")
    @FindBy(xpath = "//input[@value='Поиск в Google']")
    private WebElement searchButton;



    @ElementTitle(value = "Wiley")
    @FindBy(xpath = "//*[@id='main-header-container']/div/div[1]/div/div/div/a")
    private WebElement Wiley;

    @ElementTitle(value = "WHO WE SERVE")
    @FindBy(xpath = "//*[@id='main-header-navbar']/ul[1]/li[1]")
    private WebElement WHOWESERVE;

    @ElementTitle(value = "SUBJECTS")
    @FindBy(xpath = "//*[@id='main-header-navbar']/ul[1]/li[2]")
    private WebElement SUBJECTS;

    @ElementTitle(value = "ABOUT")
    @FindBy(xpath = "//*[@id='main-header-navbar']/ul[1]/li[4]/a")
    private WebElement ABOUT;

    @ElementTitle(value = "Search Button")
    @FindBy(xpath = "//*[@id='main-header-container']/div/div[2]/div/form/div/span")
    private WebElement SearchButton;

    @ElementTitle(value = "Search Field")
    @FindBy(xpath = "//*[@id='js-site-search-input']")
    private WebElement SearchField;
//-----

    @ElementTitle(value = "SUBJECTS:Education")
    @FindBy(xpath = "//*[@id='Level1NavNode2']/ul/li[9]/a")
    private WebElement SUBJECTSEducation;

    @ElementTitle(value = "WHO WE SERVE - subMenuList")
    @FindBy(xpath = "//*[@id='Level1NavNode1']/ul/li/a")
    private List<WebElement> WHOWESERVEList;

    @ElementTitle(value = "List item under Subjects")
    @FindBy(xpath = "/html/body/main/div[3]/div/div/div[4]/div[1]/ul/li/a")
    private List<WebElement> ListItemUnderSubjects;

    @ElementTitle(value = "Search Headers")
    @FindBy(xpath = "/html/body/main/div[3]/div/div/div[2]/div/div[3]/div/div/div/div[3]/section/div[2]/h3/a")
    private List<WebElement> searchHeaders;

    @ElementTitle(value = "Search Headers:Suggestions")
    @FindBy(xpath = "//*[@id='ui-id-2']/section[1]/div/div/a")
    private List<WebElement> searchHeadersSuggestion;

    @ElementTitle(value = "Search Headers:Products")
    @FindBy(xpath = "//*[@id='ui-id-2']/section[2]/div/div/a")
    private List<WebElement> searchHeadersProducts;

    @ElementTitle(value = "WHO WE SERVE:Students")
    @FindBy(xpath="//*[@id='Level1NavNode1']/ul/li[1]")
    private WebElement tabScreen9;
//----

    @ElementTitle(value = "title")
    @FindBy(xpath="/html/head/title")
    private WebElement title;

    @ElementTitle(value = "Button:No")
    @FindBy(xpath="//*[@id='country-location-form']/div[3]/button[1]")
    private WebElement ButtonNo;

    @ElementTitle(value = "activePage")
    @FindBy(xpath="/html/body/main/div[2]/div/div[1]/ul/li[2]")
    private WebElement ActivePage;

    @ElementTitle(value = "Learn More")
    @FindBy(xpath="/html/body/main/div[2]/div/div[3]/div/p[16]/a/span/span")
    private WebElement LearnMore;

    @ElementTitle(value = "Learn More href")
    @FindBy(xpath="/html/body/main/div[2]/div/div[3]/div/p[16]/a")
    private WebElement LearnMoreHref;

    public WileyComPages() throws Exception {
        PageFactory.initElements(PageFactory.getWebDriver(), this);
        //getPageInfo("target/WileyComPages");

    }

}
