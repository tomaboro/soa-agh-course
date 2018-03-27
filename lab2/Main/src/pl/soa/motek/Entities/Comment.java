package pl.soa.motek.Entities;

public class Comment {
    private String name;
    private String email;
    private String comment;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }

    public Comment(String name, String email, String comment) {

        this.name = name;
        this.email = email;
        this.comment = comment;
    }
}
