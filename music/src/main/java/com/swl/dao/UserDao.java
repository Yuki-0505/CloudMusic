package com.swl.dao;

import com.swl.bean.User;
import com.swl.utils.DBUtils;

public class UserDao {

//  注册用户
    public boolean registerUser(User user) {
        String sql = "insert into user(user_name,password,birthday,email,wechat,signature,is_vip,create_time) values(?,?,?,?,?,?,?,?)";
        return DBUtils.save(sql,user.getUserName(), user.getPassword(), user.getBirthday(), user.getEmail(), user.getWechat(), user.getSignature(), user.getIsVIP(), user.getCreateTime());
    }
//  通过email password获取用户对象
    public User getUserByEmailAndPassword(String email, String password) {
        String sql = "select user_id as userId,user_name as userName,password,birthday,email,wechat,signature,is_vip as isVIP,create_time as createTime from user where email=? and password=?";
        return DBUtils.getSingleBean(User.class, sql, email, password);
    }
//  查询邮箱个数
    public Integer selectUserEmailCount(String email) {
        String sql = "select count(*) from user where email=?";
        return DBUtils.getCount(sql, email);
    }
}

