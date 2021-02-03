/**
 * @author Sai Prasuna
 */
package restassured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.builder.RequestSpecBuilder;
import java.util.logging.Logger;


public class EmployeeAPITest {
	String requestBody= "{\"name\":\"dummy_user\",\"salary\":\"5000\",\"age\":\"33\"}";
	private static RequestSpecification requestSpec;
	private final static Logger LOGGER = Logger.getLogger(EmployeeAPITest.class.getName());
	Response response = null;
	int employeeId;
	
	
	@BeforeClass
	public void setup()
	{
	// Creating an object of RequestSpecBuilder
	requestSpec = new RequestSpecBuilder().
	// Setting Base URI
	setBaseUri("http://dummy.restapiexample.com/api/v1")
	.build();
	}
	
	
	@Test
	public void createNewEmployee() {
    //Create Employee		
	response = RestAssured.given()
            		.spec(requestSpec)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/create");
    LOGGER.info("Response :" + response.asString());
    LOGGER.info("Status Code :" + response.getStatusCode());
    Assert.assertEquals(200, response.getStatusCode());
    JsonPath jsonPath= JsonPath.from(response.asString());
    employeeId= jsonPath.getInt("data.id");
    String status= jsonPath.getString("status");
    Assert.assertEquals(status,"success");
    Assert.assertNotNull(employeeId);
		
	}

	
	
	@Test(dependsOnMethods = "createNewEmployee")
	public void getEmployeeById() {
   // Get Response
    response = RestAssured.given()
				 .spec(requestSpec)
                .contentType(ContentType.JSON)
                .get("/employee/"+employeeId);
	LOGGER.info("Response :" + response.asString());
	LOGGER.info("Status Code :" + response.getStatusCode());
    Assert.assertEquals(200, response.getStatusCode());
    JsonPath jsonPath= JsonPath.from(response.asString());
    String status= jsonPath.getString("status");
    Assert.assertEquals(status,"success");
		
		
	}
	
	
	@Test(dependsOnMethods = "getEmployeeById")
	public void deleteByEmployeeId() {
	// Delete employee	
	LOGGER.info("Employee Id is "+employeeId);
		response = RestAssured.given()
				 .spec(requestSpec)
                .delete("/delete/"+employeeId);
	LOGGER.info("Response :" + response.asString());
	LOGGER.info("Status Code :" + response.getStatusCode());
	// Check for the success status code
    Assert.assertEquals(200, response.getStatusCode());
    JsonPath jsonPath= JsonPath.from(response.asString());
    String status= jsonPath.getString("status");
    Assert.assertEquals(status,"success");
		
	}
	
	
}
