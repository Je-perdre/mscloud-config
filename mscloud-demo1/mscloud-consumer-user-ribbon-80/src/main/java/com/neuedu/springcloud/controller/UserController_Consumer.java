package com.neuedu.springcloud.controller;

import com.neuedu.springcloud.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController_Consumer {
    //	private static final String REST_URL_PREFIX = "http://localhost:8002";
    private static final String REST_URL_PREFIX = "http://EUREKA-CLIENT-USER";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单。
     */
    @Autowired
    private RestTemplate restTemplate;

    //http://localhost/consumer/user/findAll
    @RequestMapping("/consumer/user/findAll")
    public List<User> findAll() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/findAll", List.class);
    }

    //http://localhost/consumer/user/findUserById/1
    @RequestMapping("/consumer/user/findUserById/{id}")
    public User findUserById(@PathVariable("id") int id) {

        return restTemplate.getForObject(REST_URL_PREFIX + "/user/findUserById/" + id, User.class);
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    // http://localhost/consumer/user/discovery
    @RequestMapping("/consumer/user/discovery")
    public Object discover() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/discovery/", Object.class);
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient ;
//    http://localhost/consumer/lbtest
    @RequestMapping(value = "/consumer/lbtest", method = RequestMethod.GET)
    public String test(){
        String serviceId = "EUREKA-CLIENT-USER";
        String result = "";
        for (int i = 0; i < 15; i++) {
            ServiceInstance serviceInstance = this.loadBalancerClient.choose(serviceId);
            result += "第"+( i + 1) + "次测试端口：" + serviceInstance.getHost() + ": " + serviceInstance.getPort()+"<br>";
        }
        return result;
    }

}
