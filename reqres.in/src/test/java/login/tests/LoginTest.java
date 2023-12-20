package login.tests;

import dataProvider.LoginProvider;
import restfulSpecs.RequestSpec;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import staticVariables.TokensData;
import java.io.IOException;
import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class LoginTest
{
    @Test(dataProvider = "LoginProvider", dataProviderClass = LoginProvider.class)
    public static void loginTest(String... args) throws IOException
    {
        Response res = given().
                spec(RequestSpec.reqresInLogin()).
                body(args[0]).
        when().
                post("/api/login").
        then().
                statusCode(Integer.parseInt(args[1])).
                extract().response();
       //when setting valid data , i can access response data
        if(LoginProvider.count == 0) TokensData.reqresLoginToken = getResponseJSONValue(res, "token");
    }
}
