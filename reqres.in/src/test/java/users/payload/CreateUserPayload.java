package users.payload;

public class CreateUserPayload
{
    public static String createUserPayload()
    {
        return "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }
}
