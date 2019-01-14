package org.guojing.test.spring.service;

import org.guojing.test.spring.model.Group;
import org.guojing.test.spring.model.GroupUser;

/**
 * Created at: 2018-11-18 11:15
 *
 * @author guojing
 */
public interface IGroupService {

    int createGroup(Group group);

    boolean deleteGroup(int groupId);

    int membersCount(int groupId);

    boolean addMember(GroupUser groupUser);

    boolean removeMember(GroupUser groupUser);

}
