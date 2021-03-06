/**
 * eureka server
 * @author 52395090@qq.com
 * http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableEurekaServer	//@EnableEurekaServer注解就可以让应用变为Eureka服务器，这是因为spring boot封装了Eureka Server，让你可以嵌入到应用中直接使用
public class EurekaServer {
	public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
//        String errorString="emergency! eureka may be incorrectly claiming instances are up when they're not. renewals are lesser than threshold and hence the instances are not being expired just to be safe.";
//        errorString="the self preservation mode is turned off.this may not protect instance expiry in case of network/other problems.";
    }
}
