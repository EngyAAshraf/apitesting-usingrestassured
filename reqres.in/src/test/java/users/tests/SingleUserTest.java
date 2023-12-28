package users.tests;

import dataProvider.ListOfIDsProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import java.io.IOException;
import static helperFunctions.GetJsonData.getResponseJSONValue;
import static io.restassured.RestAssured.given;

public class SingleUserTest
{
    @Test(dataProvider = "listOfIDsProvider",dataProviderClass = ListOfIDsProvider.class)
    public static void singleUserTest(int id) throws IOException
    {
        Response res = given().
                spec(RequestSpec.reqresInLogin()).
                pathParam("id",id).
        when().
                get("/api/users/{id}").
        then().
                extract().response();

        if (id <= 10)
        {
            Assert.assertEquals(res.statusCode(), 200);
            Assert.assertEquals(Integer.valueOf(getResponseJSONValue(res,"data.id")),id);
            CommonCreateUserData.UserId = getResponseJSONValue(res, "data.id");

        } else
        {
            Assert.assertEquals(res.statusCode(), 404);
        }


    }
}
