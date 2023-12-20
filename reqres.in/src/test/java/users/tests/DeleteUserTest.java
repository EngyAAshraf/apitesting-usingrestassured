package users.tests;

import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class DeleteUserTest
{
    @Test
    public static void deleteUserTest() throws IOException
    {
        given().
                spec(RequestSpec.reqresInLogin()).
        when().
                delete("/api/users/"+ CommonCreateUserData.UserId+"").
        then().
                statusCode(204);
    }
}
