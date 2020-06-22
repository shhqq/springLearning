package com.mybatisLearn.dao;

/**
 * Created by s on 2020/6/22 13:31.
 */

import com.mybatisLearn.domain.Role;

import java.util.List;

/**
 * Role 的dao接口
 */
public interface RoleMapper {

    List<Role> listRolesWithUser();
}
