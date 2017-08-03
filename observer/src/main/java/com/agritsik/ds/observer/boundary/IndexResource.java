package com.agritsik.ds.observer.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Applications;

import java.util.List;

@RestController
public class IndexResource {

    @Value("${spring.application.name}")
    private String app;
    
    @Autowired
    private EurekaClient discoveryClient;

    @RequestMapping("/")
    public String index(){
        return "Hello from " + app;
    }

    @RequestMapping("/applications")
    public Applications getApplications() {
        return discoveryClient.getApplications();
    }
}
