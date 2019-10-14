package com.biz.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.biz.domain.BBsVO;

public class BBsViewServiceV1 implements BBSViewService {

	List<BBsVO> bbsList;

	public BBsViewServiceV1() {
		// TODO Auto-generated constructor stub

		bbsList = new ArrayList<BBsVO>();
	}

	@Override
	public void setBBsList(List<BBsVO> bbsList) {
		// TODO Auto-generated method stub
		this.bbsList = bbsList;

	}

	@Override
	public void viewBBS() {
		// TODO Auto-generated method stub

		this.headPrint();

		for (BBsVO vo : bbsList) {

			this.bodyPrint(vo);

		}

	}

	@Override
	public void viewBBS(String subject) {
		// TODO Auto-generated method stub

		this.headPrint();

		for (BBsVO vo : bbsList) {

			if (subject.equals(vo.getSubject())) {

				this.bodyPrint(vo);

			}
		}

	}

	@Override
	public void viewBBS(int sDate, int eDate) {
		// TODO Auto-generated method stub

		this.headPrint();

		for (BBsVO vo : bbsList) {

			if (sDate <= vo.getDate() && eDate >= vo.getDate()) {

				this.bodyPrint(vo);

			}
		}

	}

	@Override
	public void viewBBS(boolean sort) { // 정렬
		// TODO Auto-generated method stub

		if (sort == true) { // 오름차순
			
			
			
			for (int i = 0; i < bbsList.size(); i++) {

				for (int j = i + 1; j < bbsList.size(); j++) {

					if (bbsList.get(i).getCount() > bbsList.get(j).getCount()) {

			
						BBsVO tempVO = new BBsVO();
						
						BBsVO jVO = bbsList.get(j);
						BBsVO iVO = bbsList.get(i);
						
						bbsList.remove(j);
						bbsList.remove(i);
						
						
						bbsList.add(j, iVO);
						bbsList.add(i, jVO);
						
						
						

					}

				}

			}
			
			
			

		} else { // 내림차순

			for (int i = 0; i < bbsList.size(); i++) {

				for (int j = i + 1; j < bbsList.size(); j++) {

					if (bbsList.get(i).getCount() < bbsList.get(j).getCount()) {

			
						BBsVO tempVO = new BBsVO();
						
						BBsVO jVO = bbsList.get(j);
						BBsVO iVO = bbsList.get(i);
						
						bbsList.remove(j);
						bbsList.remove(i);
						
						
						bbsList.add(j, iVO);
						bbsList.add(i, jVO);
						
						
						

					}

				}

			}

		}

	}

	public void headPrint() {

		System.out.println("==========================================");
		System.out.println("순번\t작성자\t작성일자\t제목\t내용\t조회수");
		System.out.println("==========================================");

	}

	public void bodyPrint(BBsVO vo) {

		System.out.print(vo.getSeq() + "\t");
		System.out.print(vo.getAuth() + "\t");
		System.out.print(vo.getDate() + "\t");
		System.out.print(vo.getSubject() + "\t");
		System.out.print(vo.getText() + "\t");
		System.out.print(vo.getCount() + "\n");

	}

}
