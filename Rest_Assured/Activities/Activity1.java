package Activities;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import org.testng.annotations.Test;

public class Activity1 {
  @Test(priority=1)
  public void addNewPet() {
	  //Create request body
	  Map<String, Object> reqBody = new HashMap<>();
	  reqBody.put("id",28001 );
	  reqBody.put("name","jacky" );
	  reqBody.put("status", "alive");
	  
	//Send request,get response ,assert response
	  given().baseUri("https://petstore.swagger.io/v2/pet").header("Content-Type","application/json")
	  .body(reqBody).log().all()
	  .when()
	   .post().then().log().all()
	   .statusCode(200).body("name",equalTo("jacky"))
	   .body("status",equalTo("alive"));
	  
  }
  @Test(priority=2)
  public void getPetInfo() {
	//Send request,get response ,assert response
	  given().baseUri("https://petstore.swagger.io/v2/pet").header("Content-Type","application/json")
	  .pathParam("petId", 28001).log().all()
	  .when()
	   .get("/{petId}").then().log().all()
	   .statusCode(200).body("name",equalTo("jacky"))
	   .body("status",equalTo("alive"));
	    
  }
  @Test(priority=3)
  public void deletePet() {
	//Send request,get response ,assert response
	  given().baseUri("https://petstore.swagger.io/v2/pet").header("Content-Type","application/json")
	  .pathParam("petId", 28001).log().all()
	  .when()
	   .delete("/{petId}").then().log().all()
	   .statusCode(200)
	   .body("message",equalTo("28001"));
  }
}
