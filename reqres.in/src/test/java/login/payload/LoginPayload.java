package login.payload;

import restfulSpecs.RequestSpec;

public class LoginPayload
{
    public static String loginSuccessfulPayload()
    {
        return "{\n" +
                "    \"email\": \""+ RequestSpec.config.reqresInEmail()+"\",\n" +
                "    \"password\": \""+ RequestSpec.config.reqresInPassword()+"\"\n" +
                "}";
    }
    public static String loginUnSuccessfulPayload()
    {
        return "{\n" +
                "    \"email\": \"peter@klaven\",\n" +
                "}";
    }
}
