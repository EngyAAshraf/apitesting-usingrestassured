package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/framework/src/test/resources/config.properties",
        "classpath:config.properties"
})
public interface FrameworkConfig extends Config
{
    @DefaultValue("test")
    String environment();

    @Key("${environment}.reqresInBaseUrl")
    String reqresInBaseUrl();

    @Key("${environment}.reqresInEmail")
    String reqresInEmail();

    @Key("${environment}.reqresInPassword")
    String reqresInPassword();
}
