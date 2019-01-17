package org.guojing.demo.spring.service;

import org.guojing.demo.spring.model.User;

/**
 * Created at: 2018-11-18 11:00
 *
 * @author guojing
 */
public interface IUserService {

    User getUserById(int userId);

    int addUser(User user);

    boolean deleteUser(int userId);

}
