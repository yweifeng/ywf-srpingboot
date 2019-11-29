package com.ywf.srpingbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
//@EnableScheduling
@ServletComponentScan
public class SrpingbootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrpingbootProjectApplication.class, args);
    }

}
