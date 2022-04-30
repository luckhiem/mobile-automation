package env;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({"system:env",
    "file:~/.credentials.properties",
    "classpath:env.properties"
})
public interface Environments extends Config {

  @Key("APP_PATH")
  String APP_PATH();
}
