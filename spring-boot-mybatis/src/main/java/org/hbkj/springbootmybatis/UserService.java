package org.hbkj.springbootmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    /**
     * 添加用户
     */
    public void add(UserDo userDo){ userDao.insert(userDo); }
    /**
     * 删除用户
     */
    public void remove(Long id){ userDao.delete(id);}

    /**
     * 编辑用户
     */
    public void edit(UserDo userDo){ userDao.update(userDo);}
    /**
     * 获取用户列表
     */
    public List<UserDo> selectAll(){ return userDao.selectAll();}
}
