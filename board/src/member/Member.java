package member;

import java.sql.Date;

public class Member {
    private String id;
    private String password;
    private String name;
    private java.sql.Date regDate;

    public Member(String id, String password, String name, java.sql.Date date) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.regDate = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public boolean isMatched(String password) {
        return password.equals(this.password);
    }
}
