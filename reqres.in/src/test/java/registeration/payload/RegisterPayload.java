package registeration.payload;

import restfulSpecs.RequestSpec;

public class RegisterPayload
{
    public static String registerSuccessfulPayload()
    {
        return "{\n" +
                "    \"email\": \""+ RequestSpec.config.reqresInEmail()+"\",\n" +
                "    \"password\": \""+ RequestSpec.config.reqresInPassword()+"\"\n" +
                "}";
    }
    public static String registerUnSuccessfulPayload()
    {
        return "{\n" +
                "    \"email\": \"peter@klaven\",\n" +
                "}";
    }
}
