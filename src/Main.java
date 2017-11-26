import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int choice=0;
		Scanner scan=new Scanner(System.in);
		
		MemoManager memo=new MemoManager();
		Calculator cal=new Calculator();
		AccountBook acc=new AccountBook();
		
		do{
			System.out.println("---------- 메인 ----------");
			System.out.println("1. Memo manager");
			System.out.println("2. Calculator");
			System.out.println("3. Account book");
			System.out.println("4. 종료");
			System.out.print("원하는 번호를 입력하세요: ");
			choice=scan.nextInt();
			System.out.println();
			
			switch(choice){
			case 1:
				memo.start();
				break;
			case 2:
				cal.start();
				break;
			case 3:
				acc.start();
				break;
			case 4 : 
				System.exit(0);
			}
			System.out.println();
			
		}while(choice!=4);
	}
}
