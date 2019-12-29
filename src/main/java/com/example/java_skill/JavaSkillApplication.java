package com.example.java_skill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.java_skill.db.mapper")
public class JavaSkillApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSkillApplication.class, args);
    }

}
