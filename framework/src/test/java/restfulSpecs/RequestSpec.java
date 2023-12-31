package restfulSpecs;

import config.FrameworkConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import logger.TestLogger;
import org.aeonbits.owner.ConfigFactory;

import java.io.IOException;

public class RequestSpec extends TestLogger
{
    public static FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);


    public static RequestSpecification reqresInRegister() throws IOException
    {
        return new RequestSpecBuilder().
                setBaseUri(config.reqresInBaseUrl()).
                setContentType(ContentType.JSON).
                addFilter(new RequestLoggingFilter()).
                addFilter(new ResponseLoggingFilter()).
                build();
    }
    public static RequestSpecification reqresInLogin() throws IOException
    {
        return new RequestSpecBuilder().
                setBaseUri(config.reqresInBaseUrl()).
                setContentType(ContentType.JSON).
                addFilter(new RequestLoggingFilter()).
                addFilter(new ResponseLoggingFilter()).
                addFilter(new AllureRestAssured()).
                build();
    }

}