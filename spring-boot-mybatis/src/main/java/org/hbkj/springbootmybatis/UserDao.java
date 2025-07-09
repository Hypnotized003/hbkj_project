package org.hbkj.springbootmybatis;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public int insert(UserDo userDo);
    public int delete(Long id);
    public int update(UserDo userDo);
    public List<UserDo> selectAll();
}
