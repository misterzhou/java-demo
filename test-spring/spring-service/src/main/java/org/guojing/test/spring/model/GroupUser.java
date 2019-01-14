package org.guojing.test.spring.model;

/**
 * Created at: 2018-11-18 11:18
 *
 * @author guojing
 */
public class GroupUser {

    private int groupId;
    private int userId;
    private int status;

    public GroupUser() {}

    public int getGroupId() {
        return groupId;
    }

    public GroupUser setGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public GroupUser setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public GroupUser setStatus(int status) {
        this.status = status;
        return this;
    }
}
