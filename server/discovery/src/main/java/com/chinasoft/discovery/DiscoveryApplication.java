package com.chinasoft.discovery;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created by VerRan.Liu on 2017/6/26.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {
    public static void main(String args[]){
        SpringApplication.run(DiscoveryApplication.class,args);
    }

    @Bean
    @Profile("!default")
    public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
        EurekaInstanceConfigBean b = new EurekaInstanceConfigBean(inetUtils);
        AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        b.setDataCenterInfo(info);
        return b;
    }

}
