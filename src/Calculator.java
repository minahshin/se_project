import java.util.Scanner;

public class Calculator {
	Scanner scan = new Scanner(System.in);
	
	public void start(){
		int select_cal = 0;
		Main main = new Main();
		
		System.out.println("---------- Calculator ----------");
		do{			
			System.out.println("1. 사칙연산\t 2. 단위변환\t 3. Quit Calculator");
			System.out.print("원하는 기능의 번호를 입력하세요: ");
			select_cal=scan.nextInt();
			System.out.println();
			
			switch(select_cal){
			case 1:
				fouroperation();
				break;
			case 2:
				change();
				break;
			case 3:
				String[] args = null;
				main.main(args);
				break;
			default:
				System.out.println("존재하지 않는 메뉴입니다. 다른 메뉴를 선택해 주세요.");
				start();
			}
		}while(select_cal!=3);
	}
	
	public void fouroperation() {
		int front = 0, back = 0;
		String operator;
		double result;
		int select_new_op = 0;
		
		System.out.println("-------- 사칙연산 --------");
		System.out.println("피연산자의 범위는 0을 포함한 양수 범위의 정수만 지원합니다.");
		System.out.print("식을 입력하세요(예시 : 10 + 1) : ");
		front = scan.nextInt();
		operator = scan.next();
		back = scan.nextInt();
		
		result = calc_fourop(front, operator, back);
		
		if(result != -1.11)
			System.out.println("식 " + front + " " + operator + " " + back + "의 결과 값 = " + result);
		
		do {
			System.out.print("새로운 연산을 시작하시겠습니까?(1. Yes / 2. Back to Calculator) : ");
			select_new_op = scan.nextInt();
			System.out.println();
			switch(select_new_op){
			case 1:
				fouroperation();
			break;
			case 2:
				start();
			break;
			default:
				System.out.println("존재하지 않는 메뉴입니다. 다른 메뉴를 선택해 주세요.");
				}
			System.out.println();
		} while(select_new_op!=2);		
	}
	
	public double calc_fourop(int front, String operator, int back) {
		double result = 0;
		
		if(front >= 0 && back >= 0) {
			if(operator.equals("+"))
				result = front + back;
			else if(operator.equals("-"))
				result = front - back;
			else if(operator.equals("*"))
				result = front * back;
			else if(operator.equals("/")) {
				if(back == 0) {
					System.out.println("error : 0으로 나눌 수 없습니다.");
					result = -1.11;
				}
				else
					result = (double) front / (double) back;
			}
			else {
				System.out.println("error : 인식할 수 없는 연산입니다.");
				result = -1.11;
			}
		}
		else {
			System.out.println("error : 피연산자의 범위는 0을 포함한 양수 범위의 정수만 지원합니다.");
			if(!(operator.equals("+")) && !(operator.equals("-")) && !(operator.equals("*")) && !(operator.equals("/")))
				System.out.println("error : 인식할 수 없는 연산입니다.");
			if(operator.equals("/") && back == 0)
				System.out.println("error : 0으로 나눌 수 없습니다.");
			result = -1.11;
		}
		return result;
	}
	
	public void change() {
		System.out.println("change");
	}
}
