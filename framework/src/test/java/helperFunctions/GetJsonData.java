package helperFunctions;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import java.util.List;

public class GetJsonData
{
    public static String getResponseJSONValue(Response res, String jsonPath)
    {
        String json = "";
        var jsonValue = JsonPath.read(res.asPrettyString(), jsonPath);
        json = String.valueOf(jsonValue);
        return json.
                replace("\"", "").
                replace("[", "").
                replace("]", "");
    }

    public static List<Object> getResponseJSONValueAsList(Response res, String jsonPath)
    {
        List<Object> json = null;
        json = JsonPath.read(res.asPrettyString(), jsonPath);
        return json;
    }
}
