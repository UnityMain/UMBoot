package com.unitymain.student.bean;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author panyuanbiao
 */
@Data
public class SysRole implements GrantedAuthority {

    private Integer id;
    private String roleName;
    private String roleDesc;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
