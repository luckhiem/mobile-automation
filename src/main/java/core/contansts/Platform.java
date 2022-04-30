package core.contansts;

public interface Platform {
    String OS = System.getProperty("os") == null
            ? "Android"
            : System.getProperty("os");
}
