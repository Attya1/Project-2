package StepDefination;

import Pages.P03_homePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/***
 * Testing add to wishList
 */

public class D08_WishlistStepDef {
    private P03_homePage homePageObject;
    private String[] productsName={"Apple MacBook Pro 13-inch","HTC One M8 Android L 5.0 Lollipop"};
    @Given("initialize wish list feature")
    public void setup() {
        homePageObject = new P03_homePage(Hooks.driver);
    }
    @When("user select to add HTC phone to wish list")
    public void userAddsProductToWishList() throws InterruptedException {
        //adding htc phone
        homePageObject.addProductToWishList(productsName[1]);


    }
    @Then("user should get a success message")
    public void checkOnUserAddingProductToWishMessage(){
        SoftAssert soft= new SoftAssert();
        String actualMessageText= homePageObject.getAddToWishListMessageText();
        String actualMessageBackGroundColor = homePageObject.getAddToWishListMessageBackGroundColor();
        String expectedText="The product has been added to your wishlist";
        String expectedColor="rgba(75, 176, 122, 1)";
        soft.assertTrue(expectedText.equals(actualMessageText));
        soft.assertTrue(expectedColor.equals(actualMessageBackGroundColor));
        soft.assertAll();

    }
    @And("click on wish list")
    public void userClicksOnWishList() throws InterruptedException {
        Thread.sleep(6000);
        homePageObject.goToWishList();

    }
    @Then("user should find the product")
    public void checkOnProduct(){
        System.out.println(homePageObject.findProductQty(productsName[1]));
        Assert.assertTrue(homePageObject.findProductQty(productsName[1])>0);


    }
}
