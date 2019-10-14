package com.biz.service;

import java.util.List;

import com.biz.domain.BBsVO;

public interface BBsReadService {
	
	public void readBBS(String bbsFile) throws Exception ;
	public List<BBsVO> getBBsList();

}
