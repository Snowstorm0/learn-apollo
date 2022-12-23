package com.spring.boot.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service层
 *
 * @author 代码的路
 * @date 2022/12/23
 */

@Component
@Slf4j
@Service
@EnableScheduling
public class MyService {

    @Value("${param.paramStr}")
    private String paramStr;
    @Value("#{'${param.paramList}'.split(',')}")
    private List<String> paramList;
    @Value("#{${param.paramMap}}")
    private Map<String, String> paramMap;

    @Scheduled(cron = "0/5 * * * * ?")
    public void learnApollo() {
        System.out.println("paramStr:" + paramStr);
        System.out.println("paramList:" + paramList);
        System.out.println("paramMap:" + paramMap);
    }
}
