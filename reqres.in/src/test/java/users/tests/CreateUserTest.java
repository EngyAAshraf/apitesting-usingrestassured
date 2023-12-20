package users.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import users.payload.CreateUserPayload;

import java.io.IOException;

import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class CreateUserTest
{
    @Test
    public static void createUserTest() throws IOException
    {
        Response res = given().
                spec(RequestSpec.reqresInLogin()).
                body(CreateUserPayload.createUserPayload()).
        when().
                post("/api/users").
        then().
                statusCode(201).
                extract().response();

        CommonCreateUserData.UserId = getResponseJSONValue(res, "id");
    }
}
