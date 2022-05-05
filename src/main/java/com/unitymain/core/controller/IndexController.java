package com.unitymain.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author unitymain
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public ResponseEntity index(){
        return ResponseEntity.ok("Welcome You");
    }

}
