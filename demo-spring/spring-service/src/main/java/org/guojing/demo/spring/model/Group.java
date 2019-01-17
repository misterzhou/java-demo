package org.guojing.demo.spring.model;

/**
 * Created at: 2018-11-18 11:16
 *
 * @author guojing
 */
public class Group {

    private int groupId;
    private String groupName;
    private int groupStatus;
    private int membersCount;

    public Group() {}

    public int getGroupId() {
        return groupId;
    }

    public Group setGroupId(int groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public Group setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public int getGroupStatus() {
        return groupStatus;
    }

    public Group setGroupStatus(int groupStatus) {
        this.groupStatus = groupStatus;
        return this;
    }

    public int getMembersCount() {
        return membersCount;
    }

    public Group setMembersCount(int membersCount) {
        this.membersCount = membersCount;
        return this;
    }
}
