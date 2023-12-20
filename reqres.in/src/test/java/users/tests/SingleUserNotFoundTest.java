package users.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;

import java.io.IOException;

import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class SingleUserNotFoundTest
{
    @Test
    public static void singleUserNotFoundTest() throws IOException
    {
        given().
                spec(RequestSpec.reqresInRegister()).
        when().
                get("/api/users/50").
        then().
                statusCode(404);

    }
}
