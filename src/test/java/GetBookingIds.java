import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetBookingIds {
	
	@Test
	void getBookingIds()
	{
		// specifyBaseURL
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
		
		// Request object
		RequestSpecification httpRequest= RestAssured.given();
		
		
		// Response object
		Response response=httpRequest.request(Method.GET);
		
		// print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("Response body is: "+responseBody);
		
		// status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine=response.getStatusLine();
		System.out.println("Status line is: "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
