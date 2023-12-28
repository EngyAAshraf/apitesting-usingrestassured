package users.tests;

import dataProvider.ListOfIDsProvider;
import dataProvider.RegisterProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import java.io.IOException;
import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class ListUsersTest
{
    @Test(dataProvider = "listOfIDsProvider",dataProviderClass = ListOfIDsProvider.class)
    public static void listUsersTest(int pageNo) throws IOException
    {
        Response res = given().
                spec(RequestSpec.reqresInLogin()).
                queryParam("page",pageNo).
                when().
                get("/api/users").
        then().
                statusCode(200).
                extract().response();

        Assert.assertEquals(Integer.valueOf(getResponseJSONValue(res,"page")),pageNo);

        if(ListOfIDsProvider.count == 0) CommonCreateUserData.UserId = getResponseJSONValue(res, "data[1].id");

    }
}
