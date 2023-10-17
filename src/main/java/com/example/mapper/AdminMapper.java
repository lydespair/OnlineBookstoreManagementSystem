package com.example.mapper;

import com.example.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where admin_id = #{adminId} and admin_pwd = #{adminPwd}")
    Admin login(Admin root);
}
