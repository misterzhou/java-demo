package org.guojing.demo.spring.service;

import org.guojing.demo.spring.model.Group;
import org.guojing.demo.spring.model.User;

import java.util.List;

/**
 * Created at: 2018-11-18 11:33
 *
 * @author guojing
 */
public interface IGroupUserService {

    Group createTempGroup(List<User> users);

    boolean deleteTempGroup(int groupId);

}
