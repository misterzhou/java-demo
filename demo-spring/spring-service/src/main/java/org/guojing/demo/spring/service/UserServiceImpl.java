package org.guojing.demo.spring.service;

import org.guojing.demo.spring.model.User;

/**
 * Created at: 2018-11-18 11:06
 *
 * @author guojing
 */
public class UserServiceImpl implements IUserService {

    public UserServiceImpl() {
        System.out.println("============= UserServiceImpl.constructor exec =============");
    }

    public void init() {
        System.out.println("============= UserServiceImpl.init exec =============");
    }

    @Override
    public User getUserById(int userId) {
        System.out.println("============= UserServiceImpl.getUserById exec =============");
        return new User().setUserId(10000).setUsername("zhangsan").setPhone("18510191234");
    }

    @Override
    public int addUser(User user) {
        System.out.println("============= UserServiceImpl.addUser exec =============");
        return 2000;
    }

    @Override
    public boolean deleteUser(int userId) {
        System.out.println("============= UserServiceImpl.deleteUser exec =============");
        return true;
    }

}
