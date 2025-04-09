package Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity2 {
  @Test(priority=1)
  public void addNewUserFromFile()throws IOException {
	  FileInputStream inputJSON = new FileInputStream ("src/test/java/Activities/userinfo.json");
	  given().baseUri("https://petstore.swagger.io/v2/pet")
	  .header("Content-Type","application/json")
	  .body(inputJSON)
	  .when()
	   .post()
	   .then()
	   .body("status",equalTo(200))
	   .body("message",equalTo("54321"));
	  inputJSON.close();
  }
  @Test(priority=2)
  public void getUserInfo () {
	  File outputJSON = new File ("src/test/java/Activities/userGETResponse.json");
			  Response response = given()
			  .baseUri("https://petstore.swagger.io/v2/pet")
			  .header("Content-Type","application/json")
			  .pathParam("username", "justinc")
			  .when().get("/{username}");
			  
			  String resBody = response.getBody().asPrettyString();
			  try
			  {
				  outputJSON.createNewFile();
				  FileWriter writer = new FileWriter(outputJSON.getPath());
				  writer.write(resBody);
				  writer.close();
			  } catch(IOException excp) {
				  excp.printStackTrace();
			  }
			  
         //Assertion
  response.then().body("id", equalTo(54321));
  response.then().body("username", equalTo("justinc"));
  response.then().body("firstname", equalTo("justinc"));
  response.then().body("lastname", equalTo("Case"));
  response.then().body("email", equalTo("justincase@email.com"));
  response.then().body("password", equalTo("password123"));
  response.then().body("phone", equalTo("7345672345"));
  }			  
  @Test(priority=3)
  public void deleteUser() throws IOException{
  }
  }
  
  
