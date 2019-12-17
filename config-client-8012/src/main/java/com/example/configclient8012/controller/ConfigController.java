package com.example.configclient8012.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {
    @Value("${data}")
    private String data;

    @RequestMapping("/getData")
    public void getData(){
        System.out.println(data);
    }
}
