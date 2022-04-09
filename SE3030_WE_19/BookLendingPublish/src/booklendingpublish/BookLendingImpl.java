package booklendingpublish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class BookLendingImpl implements BookLendingService{
	
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<BookLendingModel> lendedBooks = new ArrayList<BookLendingModel>();

	public BookLendingImpl() {
		// TODO Auto-generated constructor stub
		lendedBooks.add(new BookLendingModel("Studies", false));
		lendedBooks.add(new BookLendingModel("Treasure", false));
		lendedBooks.add(new BookLendingModel("Outsiders", true));
		lendedBooks.add(new BookLendingModel("Mango-Street", false));
		lendedBooks.add(new BookLendingModel("Thirteen-Reasons", true));
		lendedBooks.add(new BookLendingModel("Peter-Pan", true));
	}
	
	@Override
	public void checkIn(String bookName) {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
		System.out.println("============Checking for book availability============");
		System.out.println("======================================================");
		System.out.println();
		for(int i = 0; i < lendedBooks.size();) {
			if (lendedBooks.get(i).getBookName().equals(bookName)) {
				if(lendedBooks.get(i).isAvailability() == false) {
					lendedBooks.get(i).setAvailability(true);
					System.out.println("Book " + bookName + " is returned!");
					break;
				}
				else {
					System.out.println("Book " + bookName + " is already returned! Check the name again!");
					break;
				}
			}
			else {
				i++;
				if(i == (lendedBooks.size()-1)) {
					System.out.println("Book " + bookName + " is not registerd yet!!");
				}
			}
		}
		
		
	}

	@Override
	public void checkOut(String bookName) {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
		System.out.println("============Checking for book availability============");
		System.out.println("======================================================");
		System.out.println();
		for(int i = 0; i < lendedBooks.size();) {
			if (lendedBooks.get(i).getBookName().equals(bookName)) {
				if(lendedBooks.get(i).isAvailability() == true) {
					lendedBooks.get(i).setAvailability(false);
					System.out.println("Book " + bookName + " is borrowed!");
					break;
				}
				else {
					System.out.println("Book " + bookName + " is already borrowed, please select another book");
					break;
				}
			}
			else {
				i++;
				if(i == (lendedBooks.size()-1)) {
					System.out.println("Book " + bookName + " is not registerd yet!!");
				}
			}
		}
		
	}

	
}
