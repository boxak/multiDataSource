package com.example.demo.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.example.demo.mapper.db2", sqlSessionFactoryRef = "db2SqlSessionFactory")
public class Db2Config {
  @Bean(name="db2DataSource")
  @ConfigurationProperties(prefix = "spring.db2.datasource")
  public DataSource db1DataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name="db2SqlSessionFactory")
  public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db2DataSource") DataSource db1DataSource,
      ApplicationContext applicationContext) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(db1DataSource);
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/mapper2/*.xml"));
    return sqlSessionFactoryBean.getObject();
  }

  @Bean(name="db2SqlSessionTemplate")
  public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
