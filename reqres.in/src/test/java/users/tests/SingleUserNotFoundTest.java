package users.tests;

import org.testng.annotations.Test;
import restfulSpecs.RequestSpec;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class SingleUserNotFoundTest
{
    @Test
    public static void singleUserNotFoundTest() throws IOException
    {
        given().
                spec(RequestSpec.reqresInLogin()).
        when().
                get("/api/users/50").
        then().
                statusCode(404);

    }
}
