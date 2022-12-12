package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

/**
 * To test following the website on social media*/
public class D07_followUsStepDef {
    private P03_homePage homePageObject;
    private String newOnLine  = "new-online";

    @Given("initialize follow us feature")
    public void setup() {
        homePageObject = new P03_homePage(Hooks.driver);
    }

    @When("^user clicks \"(.*)\"$")
    public void userClicksOnIcon(String icon) {
        homePageObject.goToFollowUs(icon);
    }

    @Then("^user should go to selected \"(.*)\"$")
    public void checkSocialUrl(String url) throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<String> tabs = new ArrayList<String>(Hooks.driver.getWindowHandles());
        if (!url.contains(newOnLine)) {
            Hooks.driver.switchTo().window(tabs.get(1));
        } else {
            Hooks.driver.switchTo().window(tabs.get(0));
        }
        Assert.assertEquals(homePageObject.getUrl(), url);
    }
}
