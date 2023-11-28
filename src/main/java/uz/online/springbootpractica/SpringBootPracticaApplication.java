package uz.online.springbootpractica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
//@EnableScheduling
public class SpringBootPracticaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPracticaApplication.class, args);
    }

//    @Scheduled(initialDelay = 1000L,fixedDelay = 2000L)
//    public void start() {
//        System.out.println("new rate " + new Date());
//    }
//
//    @Scheduled(fixedDelay = 200L)
//    public void startDelay() {
//        System.out.println("new delay " + new Date());
//    }
//
//    @Scheduled(cron = " 0 30 18 * * *")
//    public void cron() {
//        System.out.println("new cron "+ new Date());
//    }


}
