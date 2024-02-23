package com.unitymain.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.unitymain.core.bean.BaseEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

/**
 * <h2>用户类</h2>
 * @author UnityMain
 */
@TableName("sys_user")
@Data
public class SysUser extends BaseEntity implements UserDetails {
    @TableId
    private Integer id;
    private String username;
    private String password;

    /**
     * 权限列表
     */
    @TableField(exist = false)
    private List<GrantedAuthority> authorityList;

    /**
     * 获取权限列表
     * @return 获取权限列表
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    /**
     * 判断账户是否有效
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 判断账户是否上锁
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断账户是否启用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }


}
