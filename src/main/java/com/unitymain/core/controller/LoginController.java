package com.unitymain.core.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.unitymain.core.bean.Result;
import com.unitymain.core.entity.ValidateCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileCacheImageOutputStream;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@RestController
public class LoginController {

    @PostMapping("/login")
    public Result login() {
        return null;
    }

    @GetMapping("/login/getValidateCode")
    public void VerificationCode(HttpSession session, HttpServletResponse response) throws IOException {
        ValidateCode validateCode = new ValidateCode();
        if (session.getAttribute("validateCode") == null) {
            validateCode.setCode(getCode());
            validateCode.setLastTime(System.currentTimeMillis());
            session.setAttribute("validateCode", validateCode);
        } else {
            validateCode = (ValidateCode) session.getAttribute("validateCode");
            if (((System.currentTimeMillis() - validateCode.getLastTime()) / 1000 > 60)) {
                validateCode = new ValidateCode();
                validateCode.setCode(getCode());
                validateCode.setLastTime(System.currentTimeMillis());
                session.setAttribute("validateCode", validateCode);
            }
        }
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 6);
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(450, 100, 6, 4);
        BufferedImage image = (BufferedImage) captcha.createImage(validateCode.getCode());
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        outputStream.flush();
        outputStream.close();
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
