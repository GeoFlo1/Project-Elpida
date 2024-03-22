import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static String date;
	public static String month;

	public static void main(String[] args) {
		
		System.setProperty("console.encoding", "UTF-8");		
		Scanner scanner = new Scanner (System.in); 
		Imerominia imerominia = new Imerominia();
		List<String> error_Stoixeia = new ArrayList<>();
		List<String> receivedStoixeia = new ArrayList<>();
		Stoixeia stoixeia = new Stoixeia();
		boolean epanalipsi_answer;
		String epanalipsi;
		int teliki_imerominia;
		int teliki_imera;
		error_Stoixeia.add("0");
		
		System.out.println("\tWELCOME TO THE VOLUNTEER REGISTRATION PROGRAM. \n\n");
		
		do{
		
		teliki_imerominia = imerominia.imerominiaCheck();
		
				
		while(teliki_imerominia <= 0 || teliki_imerominia > 38){
			System.out.println("\nYou have made a mistake in the Date.\n\n\tTRY AGAIN!");
			teliki_imerominia = imerominia.imerominiaCheck();
			}
		teliki_imera = imerominia.day;
		
		month = (""+teliki_imerominia);//xrisimopoio gia na onomaso to Sheet tou Excel
		
		date = ("" + teliki_imera + "/" + teliki_imerominia);
		do {
        receivedStoixeia = stoixeia.stoixeiaCheck();
		}
		while(receivedStoixeia == error_Stoixeia);
       
        System.out.println("\nThe operation was successfull!\nWould you like to restart the program?\nY/N:");
        epanalipsi = scanner.nextLine();
        
        if(epanalipsi.contains("Y")) {
        	epanalipsi_answer = true;
        }else 
        	{epanalipsi_answer = false;};
       
        
		}while(epanalipsi_answer);
		
		System.out.println("\nExiting...");
		scanner.close();
	}
	
}
