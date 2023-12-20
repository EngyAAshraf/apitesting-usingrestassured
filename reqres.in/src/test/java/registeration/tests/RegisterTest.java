package registeration.tests;

import dataProvider.RegisterProvider;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.TokensData;
import java.io.IOException;
import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class RegisterTest
{
    @Test(dataProvider = "RegisterProvider", dataProviderClass = RegisterProvider.class)
    public static void registerationTest(String... args) throws IOException
    {
        Response res = given().
                spec(RequestSpec.reqresInRegister()).
                body(args[0]).
        when().
                post("/api/register").
        then().
                statusCode(Integer.parseInt(args[1])).
                extract().response();

        //when setting valid data , i can access response data
        if(RegisterProvider.count == 0) TokensData.reqresRegisterToken = getResponseJSONValue(res, "token");
    }

}
