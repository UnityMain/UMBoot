package com.unitymain.student.controller;

import cn.hutool.core.util.StrUtil;
import com.unitymain.student.bean.Result;
import com.unitymain.student.entity.SysUser;
import com.unitymain.student.entity.VerificationCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
public class LoginController {

    @GetMapping("/login/VerificationCode")
    public ResponseEntity VerificationCode(Model model, HttpSession session) {
        if (session.getAttribute("demo") == null) {
            VerificationCode verificationCode = new VerificationCode();
            verificationCode.setCode(getCode());
            verificationCode.setLastTime(System.currentTimeMillis());
            model.addAttribute("demo", verificationCode);
        } else {
            VerificationCode demo = (VerificationCode) session.getAttribute("demo");
            if (!((System.currentTimeMillis() - demo.getLastTime()) / 1000 < 60)) {
                VerificationCode verificationCode = new VerificationCode();
                verificationCode.setCode(getCode());
                verificationCode.setLastTime(System.currentTimeMillis());
                model.addAttribute("demo", verificationCode);
            }
        }
        VerificationCode verificationCode = (VerificationCode) model.getAttribute("demo");
        return ResponseEntity.ok(verificationCode.getCode());
    }

    //Post会被CsrfFilter所拦截
    @GetMapping("inspectCode")
    public ResponseEntity inspectCode(Model model, HttpSession session, String code) {
        if (StrUtil.isEmpty(code)) {
            return ResponseEntity.ok("验证码不能为空");
        }
        if (session.getAttribute("demo") == null) {
            return ResponseEntity.ok("请先获取验证码");
        }
        VerificationCode verificationCode = (VerificationCode) model.getAttribute("demo");
        if (!StrUtil.equals(code, verificationCode.getCode())) {
            return ResponseEntity.ok("验证码错误，请查验");
        }

        return ResponseEntity.ok("验证成功");
    }

    /**
     * 获取验证码
     *
     * @return
     */
    public String getCode() {
        String code = "";
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            code += rand.nextInt(10);
        }
        return code;
    }

}
