import java.util.Scanner;

public class Calculator {
	Scanner scan = new Scanner(System.in);
	
	public void start(){
		int select_cal = 0;
		Main main = new Main();
		
		System.out.println("---------- Calculator ----------");
		do{			
			System.out.println("1. ��Ģ����\t 2. ������ȯ\t 3. Quit Calculator");
			System.out.print("���ϴ� ����� ��ȣ�� �Է��ϼ���: ");
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
				System.out.println("�������� �ʴ� �޴��Դϴ�. �ٸ� �޴��� ������ �ּ���.");
				start();
			}
		}while(select_cal!=3);
	}
	
	public void fouroperation() {
		int front = 0, back = 0;
		String operator;
		double result;
		int select_new_op = 0;
		
		System.out.println("-------- ��Ģ���� --------");
		System.out.println("�ǿ������� ������ 0�� ������ ��� ������ ������ �����մϴ�.");
		System.out.print("���� �Է��ϼ���(���� : 10 + 1) : ");
		front = scan.nextInt();
		operator = scan.next();
		back = scan.nextInt();
		
		result = calc_fourop(front, operator, back);
		
		if(result != -1.11)
			System.out.println("�� " + front + " " + operator + " " + back + "�� ��� �� = " + result);
		
		do {
			System.out.print("���ο� ������ �����Ͻðڽ��ϱ�?(1. Yes / 2. Back to Calculator) : ");
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
				System.out.println("�������� �ʴ� �޴��Դϴ�. �ٸ� �޴��� ������ �ּ���.");
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
					System.out.println("error : 0���� ���� �� �����ϴ�.");
					result = -1.11;
				}
				else
					result = (double) front / (double) back;
			}
			else {
				System.out.println("error : �ν��� �� ���� �����Դϴ�.");
				result = -1.11;
			}
		}
		else {
			System.out.println("error : �ǿ������� ������ 0�� ������ ��� ������ ������ �����մϴ�.");
			if(!(operator.equals("+")) && !(operator.equals("-")) && !(operator.equals("*")) && !(operator.equals("/")))
				System.out.println("error : �ν��� �� ���� �����Դϴ�.");
			if(operator.equals("/") && back == 0)
				System.out.println("error : 0���� ���� �� �����ϴ�.");
			result = -1.11;
		}
		return result;
	}
	
	public void change() {
		System.out.println("change");
	}
}
