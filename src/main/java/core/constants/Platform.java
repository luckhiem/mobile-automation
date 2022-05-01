package core.constants;

public interface Platform {
    String OS = System.getProperty("os") == null
            ? "Android"
            : System.getProperty("os");
}
