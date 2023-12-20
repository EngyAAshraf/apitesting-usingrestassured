package users.tests;

import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import staticVariables.CommonCreateUserData;
import users.payload.UpdateUserPayload;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class Update2UserTest
{
    @Test
    public static void update2UserTest() throws IOException
    {
        given().
                spec(RequestSpec.reqresInLogin()).
                body(UpdateUserPayload.update2UserPayload()).
        when().
                patch("/api/users/"+ CommonCreateUserData.UserId+"").
        then().
                statusCode(200);
    }
}
