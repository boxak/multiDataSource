package com.example.demo.mapper.db1;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Db1Mapper {
  List<String> selCodeTpId();
}
