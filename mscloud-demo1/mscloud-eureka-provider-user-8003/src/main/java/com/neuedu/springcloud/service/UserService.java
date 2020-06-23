package com.neuedu.springcloud.service;

import com.neuedu.springcloud.domain.User;

import java.util.List;


public interface UserService {

    public int insertUser(User user);

    /**
     * 插入数据获取主键
     */
    public void insertGetKey(User user);

    public User selectByUsername(String username);

    public List<User> findAll();

    public int delete(Integer id);

    public User findUserById(int id);

    public int update(final User user);
}
