package com.unitymain.student.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * 角色表(SysRole)实体类
 *
 * @author UnityMain
 * @since 2022-01-20 17:16:39
 */
public class SysRole implements GrantedAuthority {
    private static final long serialVersionUID = 630524003608650111L;
    /**
    * 角色ID
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName;
    }
}