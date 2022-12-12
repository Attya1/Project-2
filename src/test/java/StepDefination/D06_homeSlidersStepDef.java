package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * HomeSlider Test
 * as the website has a bug that when you click on the slider it navigates to the home screen again
 * so the tests in this class should fail
 */
public class D06_homeSlidersStepDef {
    private P03_homePage homePageObject;
    private String expectedNokiaUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
    private String expectedIPhoneUrl = "https://demo.nopcommerce.com/iphone-6";

    @Given("initialize slider feature")
    public void setup() {
        homePageObject = new P03_homePage(Hooks.driver);
    }

    @When("user select Nokia picture")
    public void userSelectNokiaPicture() {
        Hooks.driver.navigate().to(homePageObject.selectSliderPicture("nokia"));
    }

    @Then("user should navigate to Nokia page")
    public void checkOnUserSelectsNokiaUrl() {
        Assert.assertEquals(homePageObject.getUrl(), expectedNokiaUrl);
    }

    @When("user select iphone picture")
    public void userSelectsIphonePicture() {
        Hooks.driver.navigate().to(homePageObject.selectSliderPicture("iphone"));
    }

    @Then("user should navigate to iphone page")
    public void checkOnUserSelectsIphoneUrl() {
        Assert.assertEquals(homePageObject.getUrl(), expectedIPhoneUrl);
    }
}
