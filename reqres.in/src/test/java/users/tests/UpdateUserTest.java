package users.tests;

import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import users.payload.UpdateUserPayload;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class UpdateUserTest
{
    @Test
    public static void updateUserTest() throws IOException
    {
        given().
                spec(RequestSpec.reqresInRegister()).
                body(UpdateUserPayload.updateUserPayload()).
        when().
                put("/api/users/"+ CommonCreateUserData.UserId+"").
        then().
                statusCode(200);
    }
}
