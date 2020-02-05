package com.wenqy.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenqy.config.client.bean.GitAutoRefreshConfigBean;
import com.wenqy.config.client.bean.GitConfigBean;

/**
 * @RefreshScope 与actuator结合实现配置刷新，但需要主动刷新触发 
 * 		e.g: http://localhost:8007/actuator/refresh
 * 还可以 git仓库设置webhook回调地址，配置修改后回调，但只触发一端，
 * 可以利用Spring Cloud Bus事件广播订阅端，实现批量更新
 * 	配置中心配置动态生效
 * 		1、引入 bus amqp 依赖，启动rabbitmq
 * 		2、Gitlab配置好Webhook地址，指向配置中心服务刷新地址,
 * 			如：10.188.190.60:8007/actuator/bus-refresh (局域网本地地址)
 * 		3、指定-Dserver.port=8888,client多节点启动
 * 		4、修改Gitlab配置
 * 		5、重新访问url
 * @version V5.0
 * @author wenqy
 * @date   2020年1月8日
 */
@RestController
@RefreshScope
public class GiConfigDemoController {

    @Autowired
    private GitConfigBean gitConfig;

    @Autowired
    private GitAutoRefreshConfigBean gitAutoRefreshConfig;
    
    @GetMapping(value = "show")
    public Object show(){
        return gitConfig;
    }
    
    /**
     * 	修改Git仓库配置文件后,主动调用刷新接口（POST请求）：http://localhost:8008/actuator/refresh
     * 	再次访问请求, http://localhost:8008/autoShow
     * 	@ConfigurationProperties 值有更新，@Value值不会更新
     * @return
     * @author wenqy
     * @date 2020年1月8日 下午5:12:37
     */
    @GetMapping(value = "autoShow")
    public Object autoShow(){
        return gitAutoRefreshConfig;
    }
}
