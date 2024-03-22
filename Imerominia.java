import java.util.Scanner;

public class Imerominia {
	
	public int day;
		
	public int imerominiaCheck() {
		
		Scanner scanner = new Scanner (System.in); 
		int lenghtOfDate = 38;
		int num_of_months = 13;
		int num_of_days = 32;
		int num_of_desired_month;
		int num_of_desired_day;
		
		//Months
				String[] targetSubstring = new String[num_of_months];
				String[] target_Num_of_Day = new String[num_of_days];
				
				targetSubstring[1]= "January";
				targetSubstring[2] = "February";
				targetSubstring[3] = "March";
				targetSubstring[4] = "April";
				targetSubstring[5] = "May";
				targetSubstring[6] = "June";
				targetSubstring[7] = "July";
				targetSubstring[8] = "August";
				targetSubstring[9] = "September";
				targetSubstring[10] = "October";
				targetSubstring[11] = "November";
				targetSubstring[12] = "December";
				
				for(int x=0;x<num_of_days;x++) {
					target_Num_of_Day[x]=( x +",");
					}
		
			System.out.println("Please Enter the Date :");
			
			String imerominiaInput = scanner.nextLine();
		
		//Έλεγχος για τη σωστή ορθογραφία της ημερομηνίας
		if(imerominiaInput.length() > lenghtOfDate)//αριθμός των γραμμάτων είναι ΜΑΞ 37
			{
			return 0;
			}
		else 
		
			for(num_of_desired_day = 1;num_of_desired_day<num_of_days;num_of_desired_day++)
		  	{
			  		if (imerominiaInput.contains(target_Num_of_Day[num_of_desired_day])) 
			  			{
			  				this.day = num_of_desired_day;
			  				
			  				break;
			  			} 
		  	}
			
			  for(num_of_desired_month = 1;num_of_desired_month<num_of_months;num_of_desired_month++)
			  	{
				  		if (imerominiaInput.contains(targetSubstring[num_of_desired_month])) 
				  			{
				  				return num_of_desired_month;
				  			} 
			 	}
			  
		return 0;
	}
		
}


