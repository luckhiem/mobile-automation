package env;

import org.aeonbits.owner.ConfigFactory;

public class Config {
  public static Environments CONFIG = ConfigFactory.create(Environments.class, System.getenv());
}
