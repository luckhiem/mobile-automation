package core.constants;

public interface Platform {
    String OS = System.getProperty("os") == null
            ? "IOS"
            : System.getProperty("os");
}
