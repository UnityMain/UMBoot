package com.unitymain.core.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.unitymain.core.bean.LoginDto;
import com.unitymain.core.bean.Result;
import com.unitymain.core.service.LoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author UnityMain
 */
@RestController
public class LoginController {
    /**
     * 保存登陆信息的变量
     */
    public static Map<String, Map<String, Object>> userTokenInfo = new HashMap<>();

    @Resource
    private LoginService loginService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /*@GetMapping("/login/getValidateCode")
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
    }*/

    @GetMapping("/login/getValidateCode")
    public Result VerificationCode() throws IOException {
        String code = getCode();
        String token = IdUtil.nanoId();

        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(450, 100, 6, 4);
        BufferedImage image = (BufferedImage) captcha.createImage(code);

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        InputStream is = null;
        ImageOutputStream imOut;
        imOut = ImageIO.createImageOutputStream(bs);

        ImageIO.write(image, "jpg", imOut);

        is= new ByteArrayInputStream(bs.toByteArray());

        String encode = Base64.encode(is);

        Map<String,Object> data = new HashMap<>();

        data.put("token",token);
        data.put("code","data:image/jpeg;base64,"+encode);

        tokenSetAttribute(token,"code",code);
        return Result.ok().body(data);
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


    @PostMapping(value = "login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result login(@RequestBody LoginDto loginDto, HttpServletRequest request) {

        System.out.println(request.getRemoteAddr());
        String userToken = request.getHeader("token");
        String code = (String)tokenGetAttribute(userToken, "code");

        if(StrUtil.isEmpty(code)){
            return Result.failed("token为空");
        }

        if(!StrUtil.equals(loginDto.getValidateCode(),code)){
            return Result.failed("验证码不正确");
        }

        Result result = loginService.login(loginDto.getUsername(), loginDto.getPassword());
        if(result.getStatus()!=0){
            return result;
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", (String) result.getData());
        tokenMap.put("tokenHead", tokenHead);
        return Result.ok().body(tokenMap);
    }

    @GetMapping(value = "logout")
    public Result logout() {

        return Result.ok("注销成功");
    }

    public void tokenSetAttribute(String token, String s, Object o) {
        Map<String, Object> tokens = userTokenInfo.get(token);
        if(tokens==null){
            tokens = new HashMap<>();
        }
        tokens.put(s, o);
        userTokenInfo.put(token,tokens);
    }

    public Object tokenGetAttribute(String token, String s) {
        if(StrUtil.isEmpty(token)){
            return null;
        }
        Map<String, Object> tokens = userTokenInfo.get(token);
        if(tokens==null){
            return null;
        }
        Object obj = tokens.get(s);
        return obj;
    }

//    @GetMapping(value = "/resource/{userId}")
//    public Result getResourceList(@PathVariable Long userId) {
//        List<XlResource> permissionList = xlUserService.getResourceList(userId);
//        return Result.ok(permissionList);
//    }

}
