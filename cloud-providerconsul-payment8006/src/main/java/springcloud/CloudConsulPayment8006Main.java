package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsulPayment8006Main {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsulPayment8006Main.class, args);
        System.out.println("启动成功");
    }
}
