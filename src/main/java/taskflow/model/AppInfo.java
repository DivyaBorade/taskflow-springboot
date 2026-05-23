package taskflow.model;

public class AppInfo {

    private String name;
    private String version;
    private String developer;

    public AppInfo(String name, String version, String developer) {
        this.name = name;
        this.version = version;
        this.developer = developer;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getDeveloper() {
        return developer;
    }
}
