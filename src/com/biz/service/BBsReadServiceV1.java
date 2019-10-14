package com.biz.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.biz.domain.BBsVO;

public class BBsReadServiceV1 implements BBsReadService {
	
	List<BBsVO> bbsList;
	
	
	public BBsReadServiceV1() {
		// TODO Auto-generated constructor stub
		
		bbsList = new ArrayList<BBsVO>();
	}
	

	@Override
	public void readBBS(String bbsFile) throws Exception {								
		// TODO Auto-generated method stub

		FileReader fr = new FileReader(bbsFile);
		BufferedReader br = new BufferedReader(fr);

		while (true) {
			String str = br.readLine();

			if(str == null) break;
			
			String[] strArr = str.split(":");
			
			BBsVO vo = new BBsVO();
			
			vo.setSeq(Integer.valueOf(strArr[0]));
			vo.setAuth(strArr[1]);
			vo.setDate(Integer.valueOf(strArr[2]));
			vo.setSubject(strArr[3]);
			vo.setText(strArr[4]);
			vo.setCount(Integer.valueOf( strArr[5]));
			
			bbsList.add(vo);
		}

	}

	@Override
	public List<BBsVO> getBBsList() {
		// TODO Auto-generated method stub
		return this.bbsList;
	}

}
