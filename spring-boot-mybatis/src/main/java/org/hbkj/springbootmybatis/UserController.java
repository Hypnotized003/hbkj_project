package org.hbkj.springbootmybatis;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 查询用户列表
     */
    @GetMapping("/user")
    public List<UserDo> getList(){ return userService.selectAll(); }
    /**
     * 新增用户
     */
    @PostMapping("/user")
    public void  add(@RequestBody UserDo userDo){ userService.add(userDo);}
    /**
     * 编辑用户信息
     */
    @PutMapping("/user/{id}")
    public void  update(@PathVariable("id") long id, @RequestBody UserDo userDo){
        userDo.setId(id);
        userService.edit(userDo);
    }
    /**
     * 删除用户
     */
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable("id") long id){ userService.remove(id);}
}
