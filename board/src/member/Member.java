package member;

import java.util.Date;

public class Member {
    private String id;
    private String password;
    private String name;
    private java.util.Date regDate;

    public Member(String id, String password, String name, java.util.Date date) {
        this.id = id;
        this.password = password;
        this.name = name;
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
