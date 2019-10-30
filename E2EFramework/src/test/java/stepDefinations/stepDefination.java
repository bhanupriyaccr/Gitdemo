package stepDefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobjects.landingpage;
import pageobjects.loginpage;
import pageobjects.portalPage;
import resources.base;

public class stepDefination extends base {


@Given("^Intilalize the browser$")
public void intilalize_the_browser() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver=intiateBrowser();
}

@Given("^Navigate to \"([^\"]*)\" page$")
public void navigate_to_page(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.get(arg1);
}

@Given("^Click on Login button$")
public void click_on_Login_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	landingpage la=new landingpage(driver);
	if(la.getpopupSize().size()>0)
	{
		la.getpopup().click();
	}
	la.getLogin().click();
}
@When("^user log in  with (.+) and (.+)$")
public void user_log_in_with_and(String username, String password) throws Throwable {
	loginpage lp= new loginpage(driver);
	lp.getUsername().sendKeys(username);
	lp.getPassword().sendKeys(password);
	lp.getLogin().click();
}


@Then("^Verify the user is landed correctly$")
public void verify_the_user_is_landed_correctly() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	portalPage p= new portalPage(driver);
	Assert.assertTrue(p.getSearch().isDisplayed());
}
@And("^close browsers$")
public void close_browsers() throws Throwable {
    driver.quit();
}


	
	
}