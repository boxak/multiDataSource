package com.example.demo.mapper.db2;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Db2Mapper {
  List<String> selRptTpCode();
}
