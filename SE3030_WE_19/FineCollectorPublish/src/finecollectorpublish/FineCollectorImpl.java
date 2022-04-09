package finecollectorpublish;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class FineCollectorImpl implements FineCollectorService{

	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<FineCollectorModel> fines = new ArrayList<FineCollectorModel>();

	public FineCollectorImpl() {
		// TODO Auto-generated constructor stub
		//dates are in MM/DD/YYYY format
		fines.add(new FineCollectorModel(1, "01/30/2022", false));
		fines.add(new FineCollectorModel(2, "06/24/2021", false));
		fines.add(new FineCollectorModel(3, "10/30/2021", false));
		fines.add(new FineCollectorModel(4, "02/24/2022", false));
	}
	
	
	@Override
	public void calculateFine(int memberID, String returnedDate) {
		int days, amount;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		
		System.out.println("=====Please note that for each late date Rs:2 will be fined====");
		System.out.println("-----------Calculating the fine for ID " + memberID + "--------");
		for(int i = 0; i < fines.size();) {
			if (fines.get(i).getMemberID() == memberID) {
				try {
					Date convertedReturnedDate = sdf.parse(returnedDate);
					Date convertedDueDate = sdf.parse(fines.get(i).getDueDate());
					
					long diffInMillies = Math.abs(convertedReturnedDate.getTime() - convertedDueDate.getTime());
					long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
					
					days = (int)diff;
					System.out.println("Late dates : " + days);
					
					//check the amount of days
					if(days > 0) {
						amount = days * 2;
						System.out.println("Rs: " + amount + " /= should be paid to the counter for the late " + days + " days.");
						
						payFine(memberID);
						break;
					}
					else {
						System.out.println("No fines to be paid");
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				i++;
				if(i == (fines.size()-1)) {
					System.out.println(memberID + " cannot be found!");
				}
			}
		}
	}

	@Override
	public void payFine(int memberID) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String paid;
		
		System.out.print("Fine paid (Yes/No) : ");
		paid = sc.nextLine();
		
		if(paid.equals("Yes")) {
			fines.get(memberID-1).setFinePaied(true);
			System.out.println("Fine paid");
		}
		else if(paid.equals("No")) {
			fines.get(memberID-1).setFinePaied(false);
			System.out.println("Fine not paid");
		}else {
			System.out.println("Please enter a valid answer");
		}
	}

}
