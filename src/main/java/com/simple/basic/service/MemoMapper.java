package com.simple.basic.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.simple.basic.command.MemoVO;

@Mapper
public interface MemoMapper {

	public void insert(MemoVO vo);
	public List<MemoVO> list();
}
