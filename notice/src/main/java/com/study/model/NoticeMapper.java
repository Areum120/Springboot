package com.study.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {
	int create(NoticeDTO dto);
	List<NoticeDTO> list(Map map);
	int total(Map map);
	
}
