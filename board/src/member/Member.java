package member;

import java.util.Date;

public class Member {
    private String id;
    private String name;
    private String password;
    private java.util.Date regDate;

    public Member(String id, String name, String password, java.util.Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.regDate = date;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Date getRegDate() {
        return regDate;
    }

    public boolean isMatched(String password) {
        return password.equals(this.password);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}
