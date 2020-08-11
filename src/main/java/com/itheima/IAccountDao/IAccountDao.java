package com.itheima.IAccountDao;

import com.itheima.domain.User;

import java.util.List;

public interface IAccountDao {

    List<User> findAll();
}
