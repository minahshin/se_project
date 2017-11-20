import java.util.LinkedList;
import java.util.Scanner;

class PurchaseRecord implements Comparable<PurchaseRecord>{
	private int[] date = {00,00,00,00,0000};
	private String name;
	private int value;
	
	 PurchaseRecord(){
		 System.out.println("테스트");
	 }
	 void setDate(int[] date)  {this.date = date;}
	 void setName(String name) {this.name = name;}
	 void setValue(int value)  {this.value = value;}
	 String getDate(){
		 return date[0]+":"+date[1]+"/"+date[2]+"/"+date[3]+"/"+date[4];
	 }
	 String getName() {
		 return name;
	 }
	 String getValue() {
		 return value+"원";
	 }
	 public String toString() {
		return getDate()+"  "+getName()+"   "+getValue();
		 
	 }
	@Override
	public int compareTo(PurchaseRecord arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class AccountBook {
	private boolean sortRequired = false;
	private LinkedList<PurchaseRecord> currentTable = new LinkedList<PurchaseRecord>();
	public AccountBook(){
		//Load lists from file
	}
	
	public void start(){
		int choice=0;
		int[] inputDate;
		String inputName;
		int inputValue;
		
		Scanner scan=new Scanner(System.in);
		do{
		System.out.println("---------- 회계장부 ----------");
		if(currentTable.size()!=0)
		printAccountBook();
		System.out.println("1. Create");
		System.out.println("2. Update");
		System.out.println("3. Delete purchase records");
		System.out.println("4. Quit Account book");
		System.out.print("원하는 번호를 입력하세요: ");
		choice=scan.nextInt();
		System.out.println();
		switch(choice){
		case 1:
			System.out.println("1. 구매 날짜를 시각, 일, 월, 년도 순으로 입력하세요. (예시>00:00/00/00/0000)");
			
			inputDate = inputDatetoArray(scan.next());
			System.out.println("2. 상품명");
			inputName=scan.next();
			System.out.println("3. 가격");
			inputValue=scan.nextInt();
			
			addItem(inputDate, inputName, inputValue);
			break;
		case 2:
			System.out.print("원하는 번호를 입력하세요: ");
			updateItem(0);
			break;
		case 3:
			break;
		}
		
		}while(choice!=4);
		//scan.close();
	}
	public void printAccountBook() {
		if(sortRequired) {
			
		}
		System.out.println(currentTable.toString());
		sortRequired = false;
	}
	public int[] inputDatetoArray(String date) {
		String str = date.replace(":", "/");
		String[] str2 = str.split("/");
		
		int[] outputDateArray = {00,00,00,00,0000};
		for(int i=0; i<5;i++)
			outputDateArray[i] = Integer.parseInt(str2[0]);
		return outputDateArray;
		
	}
	private boolean addItem(int[] inputDate, String inputName, int inputValue) {
		PurchaseRecord newItem = new PurchaseRecord();
		newItem.setDate(inputDate);
		newItem.setName(inputName);
		newItem.setValue(inputValue);
		System.out.println(newItem.getDate() + newItem.getName() + newItem.getValue());
		currentTable.add(newItem);
		return true;
	}
	private boolean updateItem (int index) {
		System.out.println("1.");
		System.out.println("2.");
		System.out.println("3.");
		return false;
	}
	void deleteItem(int index) {
		
	}
	
}