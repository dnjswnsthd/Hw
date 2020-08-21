package com.ssafy.hw15.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import com.ssafy.hw15.util.EmpManager;
import com.ssafy.hw15.vo.Emp;

public class EmpTest {
	EmpTest() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		loop:while(true) {
			System.out.println(" ======= 직원 관리 프로그램 ======= ");
			System.out.println("1. 직원 추가 ");
			System.out.println("2. 직원 전체 검색 ");
			System.out.println("3. 사번으로 검색 ");
			System.out.println("4. 이름으로 모두 검색");
			System.out.println("5. 사번으로 부서 수정 ");
			System.out.println("6. 사번으로 직원 삭제 ");
			System.out.println("7. 종료");
			
			
			System.out.println("원하는 작업의 번호를 입력해주세요");
			int num = Integer.parseInt(br.readLine());
			EmpManager manager = EmpManager.getInstance();
			System.out.println();

			switch (num) {
			case (1): {
				System.out.println(" ======= 직원 관리 프로그램 ======= ");
				System.out.println("1. 직원 추가 ");
				System.out.println("사번, 직원 이름, 직위, 부서 순으로 입력하세요(공백 구분)");
				st = new StringTokenizer(br.readLine());
				int empno = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				String position = st.nextToken();
				String dept = st.nextToken();
				Emp emp = new Emp();
				emp.setEmpno(empno);
				emp.setName(name);
				emp.setPosition(position);
				emp.setDept(dept);
				boolean flag = manager.addEmp(emp);
				System.out.println(flag ? "success" : "fail");
				
				break;
			}
			case (2): {
				System.out.println(" ======= 직원 관리 프로그램 ======= ");
				System.out.println("2. 직원 전체 검색 ");
				List <Emp> list = manager.getListAll();
				for(Emp e : list) {
					System.out.println(e);
				}
				break;
			}
			case (3): {
				System.out.println(" ======= 직원 관리 프로그램 ======= ");
				System.out.println("3. 사번으로 검색 ");
				System.out.println("검색할 사번을 입력하세요.");
				int empno = Integer.parseInt(br.readLine());
				Emp emp = new Emp();
				emp.setEmpno(empno);
				manager.selectEmp(emp);
				if(emp.getName() == null) {
					System.out.println("없는 정보입니다.");
				}else {
					System.out.println(emp);
				}
				break;
			}
			case (4): {
				System.out.println(" ======= 직원 관리 프로그램 ======= ");
				System.out.println("4. 이름으로 모두 검색");
				System.out.println("이름을 입력");
				String name = br.readLine();
				List <Emp> list = manager.selectName(name);
				for(Emp e : list) {
					System.out.println(e);
				}
				break;
			}
			case (5): {
				System.out.println(" ======= 직원 관리 프로그램 ======= ");
				System.out.println("5. 사번으로 부서 수정 ");
				System.out.println("사번과 수정할 부서를 입력하세요.");
				st = new StringTokenizer(br.readLine());
				int empno = Integer.parseInt(st.nextToken());
				String dept = st.nextToken();
				Emp emp = new Emp();
				emp.setEmpno(empno);
				manager.modiEmp(emp, dept);
				break;
			}
			case (6): {
				System.out.println(" ======= 직원 관리 프로그램 ======= ");
				System.out.println("6. 사번으로 직원 삭제 ");
				System.out.println("삭제할 사번을 입력하세요.");
				int empno = Integer.parseInt(br.readLine());
				Emp emp = new Emp();
				emp.setEmpno(empno);
				manager.deleteEmpno(emp);
				break;
			}
			case (7): {
				System.out.println(" ======= 직원 관리 프로그램 ======= ");
				System.out.println("프로그램 종료");
				break loop;
			}
			}
		}
	}
	public static void main(String [] args) throws NumberFormatException, IOException {
		new EmpTest();
	}
}
