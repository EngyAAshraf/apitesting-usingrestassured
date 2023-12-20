package users.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import java.io.IOException;
import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class SingleUserTest
{
    @Test
    public static void singleUserTest() throws IOException
    {
        Response res = given().
                spec(RequestSpec.reqresInRegister()).
        when().
                get("/api/users/"+ CommonCreateUserData.UserId+"").
        then().
                statusCode(200).
                extract().response();

        CommonCreateUserData.UserId = getResponseJSONValue(res, "data.id");
    }
}
