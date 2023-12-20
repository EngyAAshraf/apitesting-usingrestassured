package users.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import java.io.IOException;
import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class ListUsersTest
{
    @Test
    public static void listUsersTest() throws IOException
    {
        Response res = given().
                spec(RequestSpec.reqresInRegister()).
        when().
                queryParam("page",1).
                get("/api/users").
        then().
                statusCode(200).
                extract().response();

        CommonCreateUserData.UserId = getResponseJSONValue(res, "data[1].id");
    }
}
