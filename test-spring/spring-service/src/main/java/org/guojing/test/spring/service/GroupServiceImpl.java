package org.guojing.test.spring.service;

import org.guojing.test.spring.model.Group;
import org.guojing.test.spring.model.GroupUser;

/**
 * Created at: 2018-11-18 11:20
 *
 * @author guojing
 */
public class GroupServiceImpl implements IGroupService {

    public GroupServiceImpl() {
        System.out.println("============= GroupServiceImpl.constructor exec =============");
    }

    public void init() {
        System.out.println("============= GroupServiceImpl.init exec =============");
    }

    @Override
    public int createGroup(Group group) {
        System.out.println("============= GroupServiceImpl.createGroup exec =============");
        return 1000;
    }

    @Override
    public boolean deleteGroup(int groupId) {
        System.out.println("============= GroupServiceImpl.deleteGroup exec =============");
        return true;
    }

    @Override
    public int membersCount(int groupId) {
        System.out.println("============= GroupServiceImpl.membersCount exec =============");
        return 0;
    }

    @Override
    public boolean addMember(GroupUser groupUser) {
        System.out.println("============= GroupServiceImpl.addMember exec =============");
        return true;
    }

    @Override
    public boolean removeMember(GroupUser groupUser) {
        System.out.println("============= GroupServiceImpl.removeMember exec =============");
        return true;
    }
}
