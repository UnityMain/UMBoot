package com.unitymain.core.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.unitymain.core.bean.Result;
import com.unitymain.core.entity.SysRole;
import com.unitymain.core.entity.SysUser;
import com.unitymain.core.service.SysRoleService;
import com.unitymain.core.service.SysUserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author unitymain
 */
@RequestMapping("/user")
@RestController
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;

    @GetMapping("/info")
    public Result info(HttpSession session) {
        System.out.println(session.getMaxInactiveInterval());
        return Result.ok().body(session.getMaxInactiveInterval());
    }

    @GetMapping("/index")
    public Result index(HttpSession session) {
        session.invalidate();
        return Result.ok().body("你已经下线了");
    }

    @GetMapping("/all")
    public Result queryList() {
        List<SysUser> records = sysUserService.list();
        Page<SysUser> userPage = new Page<>(1,records.size());
        userPage.setRecords(records);
        userPage.setTotal(records.size());
        return Result.ok().body(userPage);
    }

    @GetMapping("/role")
    public Result queryRoleList() {
        List<SysRole> list = sysRoleService.list();
        return Result.ok().body(list);
    }

    @PostMapping("/page")
    public Result queryPage(@RequestBody SysUser sysUser) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if(StrUtil.isNotEmpty(sysUser.getUsername())){
            queryWrapper.like("username",sysUser.getUsername());
        }
        Page<SysUser> userPage = sysUserService.page(
                sysUser.getPage()
                ,queryWrapper);
        return Result.ok().body(userPage);
    }

    @PostMapping("/del")
    public Result delOne(@RequestBody SysUser sysUser) {
        if(sysUser.getId()==null){
            return Result.failed("id不能为空");
        }
        boolean success = sysUserService.removeById(sysUser);
        if(success){
            return Result.ok("删除成功");
        }else{
            return Result.failed("删除失败");
        }
    }

    @PostMapping("/add")
    public Result addOne(@RequestBody SysUser sysUser) {
        if(StrUtil.isEmpty(sysUser.getUsername())){
            return Result.failed("用户名不能为空");
        }else if(StrUtil.isEmpty(sysUser.getPassword())){
            return Result.failed("密码不能为空");
        }
        long userCount = sysUserService.count(new QueryWrapper<SysUser>()
                .eq("username", sysUser.getUsername()));
        if(userCount>0){
            return Result.failed("用户名不能重复");
        }
        String password = sysUser.getPassword();
        sysUser.setPassword(SecureUtil.md5(password));
        boolean success = sysUserService.save(sysUser);
        if(success){
            return Result.ok("添加成功");
        }else{
            return Result.failed("添加失败");
        }
    }

    @PostMapping("upload")
    public Result uploadExcel(MultipartFile file, HttpSession session){
        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println(maxInactiveInterval);
        System.out.println(file);
        return Result.ok("上传成功");
    }
}
