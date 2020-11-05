package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {

	WebDriver driver = null;

	@Given("user navigates to Amazon homepage to URL {string}")
	public void user_navigates_to_amazon_homepage_to_url(String string) {		
		
		// Relative project path is saved as a string
		String projectPath = System.getProperty("user.dir");
		
		// Relative path to Chrome web driver
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/webDrivers/chromedriver.exe");

		driver = new ChromeDriver();
		
		// Maximize the web browser on launch
		driver.manage().window().maximize();
		
		// Navigate to given web URL
		driver.navigate().to(string);
	}

	@And("enters {string} on search text box and presses search button")
	public void enters_on_search_text_box_and_presses_search_button(String string) throws InterruptedException {
		
		// User passes text on the search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(string);
		
		// User clicks on search button
		driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input")).click();
	}

	@When("user sorts results in descending order of price")
	public void user_sorts_results_in_descending_order_of_price() {

		// User clicks on "Sort by" button
		driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[2]")).click();

		// User selects "Price: High to Low" option
		driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_2\"]")).click();

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@And("selects second product from the result")
	public void selects_second_product_from_the_result() {
		
		// User selects second product from the search results after sorting
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a")).click();
	}

	@Then("user should see text {string} on the product topic")
	public void user_should_see_text_on_the_product_topic(String string) {

		// Test step passes if boolean value is returned True
		assertTrue(driver.findElement(By.xpath("//*[@id=\"title\"]")).getText().contains(string));

		driver.close();
		driver.quit();
	}

}
