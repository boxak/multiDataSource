package com.example.demo;

import com.example.demo.mapper.db1.Db1Mapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

  @Autowired
  Db1Mapper db1Mapper;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    List<String> list = db1Mapper.selCodeTpId();
    for (String str : list) log.info(str);
  }

}
