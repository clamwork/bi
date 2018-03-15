package com.djcps.boot.modules.user.model;

/**
 * @author Chengw
 * @create 2018/3/15 10:42.
 * @since 1.0.0
 */
public class InnerUserPO {

    private String id;

    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "InnerUserPO{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
