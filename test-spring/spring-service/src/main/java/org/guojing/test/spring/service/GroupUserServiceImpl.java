package org.guojing.test.spring.service;

import org.guojing.test.spring.model.Group;
import org.guojing.test.spring.model.User;

import java.util.List;

/**
 * Created at: 2018-11-18 11:35
 *
 * @author guojing
 */
public class GroupUserServiceImpl implements IGroupUserService {

    IUserService userService;
    IGroupService groupService;

    public GroupUserServiceImpl() {
        System.out.println("============= GroupUserServiceImpl.constructor exec =============");
    }

    public void init() {
        System.out.println("============= GroupUserServiceImpl.init exec =============");
    }

    @Override
    public Group createTempGroup(List<User> users) {
        System.out.println("============= GroupUserServiceImpl.createTempGroup exec =============");
        return new Group().setGroupId(1000).setGroupName("Gogogo");
    }

    @Override
    public boolean deleteTempGroup(int groupId) {
        System.out.println("============= GroupUserServiceImpl.deleteTempGroup exec =============");
        return true;
    }

    public GroupUserServiceImpl setUserService(IUserService userService) {
        System.out.println("============= GroupUserServiceImpl.setUserService exec =============");
        this.userService = userService;
        return this;
    }


    public GroupUserServiceImpl setGroupService(IGroupService groupService) {
        System.out.println("============= GroupUserServiceImpl.setGroupService exec =============");
        this.groupService = groupService;
        return this;
    }
}
