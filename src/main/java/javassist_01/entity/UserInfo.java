package javassist_01.entity;

import javassist_01.annotations.Column;

public class UserInfo {
    @Column("user_name")
    private String userName;
    @Column("user_id")
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
