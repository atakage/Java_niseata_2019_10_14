package com.biz.exec;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.biz.domain.BBsVO;
import com.biz.service.BBsReadServiceV1;
import com.biz.service.BBsViewServiceV1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String bbsFile = "src/com/biz/exam/bbs.txt";

		BBsReadServiceV1 brs = new BBsReadServiceV1();
		BBsViewServiceV1 bvs = new BBsViewServiceV1();

		try {
			brs.readBBS(bbsFile);
			List<BBsVO> bbsList = brs.getBBsList();

			bvs.setBBsList(bbsList);

			while (true) {

				Scanner scan = new Scanner(System.in);

				System.out.println("==========================================");
				System.out.println("게시판 관리 시스템 v1");
				System.out.println("==========================================");
				System.out.println("1.전체 2.제목 3.날짜 4.정렬출력 0.종료");
				
				System.out.print(">> ");
				String strC = scan.nextLine();

				if (strC.equals("0")) {
					System.out.println("종료함");
					break;
				}

				if (strC.equals("1")) {
					bvs.viewBBS();
				}
				
				if(strC.equals("2")) {
					
					System.out.print("책 제목 입력>> ");
					String subject	= scan.nextLine();
					bvs.viewBBS(subject);
				}
				
				if(strC.equals("3")) {
					
					try {
						

						System.out.println("날짜 입력(start)>> ");
						String sDate = scan.nextLine();
						System.out.println("날짜 계속 입력(end)>> ");
						String eDate = scan.nextLine();
						
						int sdate = Integer.valueOf(sDate);
						int edate = Integer.valueOf(eDate);
						
						bvs.viewBBS(sdate, edate);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("날짜 입력이 올바르지 않음");
					}
					
					
				}
				
				
				if(strC.equals("4")) {
					
					System.out.println("정렬 출력 모드(t 입력 시 오름차순/ f 입력시 내림차순)");
					System.out.print(">> ");
					
					String strC2 = scan.nextLine();
					
					if(strC2.equalsIgnoreCase("f")) {
						bvs.viewBBS(false);
						bvs.viewBBS();
					}
					
					if(strC2.equalsIgnoreCase("t")) {
						bvs.viewBBS(true);
						bvs.viewBBS();
					}
					
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
