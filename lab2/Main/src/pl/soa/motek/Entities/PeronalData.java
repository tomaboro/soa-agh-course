package pl.soa.motek.Entities;

public class PeronalData {
    private String login;
    private String password;

    public PeronalData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
