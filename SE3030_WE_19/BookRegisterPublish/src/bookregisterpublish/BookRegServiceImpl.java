package bookregisterpublish;

import java.util.ArrayList;
import java.util.Scanner;


public class BookRegServiceImpl implements BookRegisterService{

private ArrayList<Books> books = new ArrayList<Books>();
	
	public BookRegServiceImpl() {
		super();
		
		books.add(new Books("Hamlet", true, "New"));
		books.add(new Books("Tale of Two Cities", false, "Used"));
		books.add(new Books("Hobbit", true, "Good"));
		books.add(new Books("Java Basics", true, "Bad"));
		books.add(new Books("Holmes", false, "New"));
		books.add(new Books("Aristotle", false, "Bad"));
	}
	
	@Override
	public void insertBooks() {
		// TODO Auto-generated method stub
		String addbook, condition;
		boolean status;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Book Name : ");
		addbook = sc.nextLine();
		
		status = true;
		
		System.out.print("Enter Book Condition (New/Used) : ");
		condition = sc.nextLine();
		
		if(addbook != null) {
			books.add(new Books(addbook, status, condition));
			
			System.out.println(addbook+" is successfully inserted");
		}else {
		
			System.out.println("\nInvalid input...");
			insertBooks();
		
		}
	}

	@Override
	public void updateBooks() {
		// TODO Auto-generated method stub
		
		String addbook;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Available Books");
		for(int i=0;i<books.size();i++) {
			System.out.println((i+1) +" - "+ books.get(i).getBookname());
		}

		System.out.print("Enter number to update book name :");
		
		int input = Integer.parseInt(sc.nextLine().trim());
		
		System.out.print("Enter new book name: ");
		addbook = sc.nextLine();
		
		books.get(input-1).setBookname(addbook);
		System.out.println("Book Name Updated!");
	}
	
	public void updateBookCondition(){
		
		String addbook;
		
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Book Name Condition");
		for(int i=0;i<books.size();i++) {
			System.out.println((i+1) +" - "+ books.get(i).getBookname() +" - "+ books.get(i).getCondition());
		}

		System.out.print("Enter number to change the book condition :");
		
		int input = Integer.parseInt(sc.nextLine().trim());
		
		System.out.print("Update Condition: ");
		addbook = sc.nextLine();
		
		books.get(input-1).setCondition(addbook);
		System.out.println("Book Condition Updated");
	}

	@Override
	public void deleteBooks() {
		// TODO Auto-generated method stub
		
		int removebook;
		String getCondition;
		Books removed = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Available Books");
		for(int i=0;i<books.size();i++) {
			System.out.println((i+1) +" - "+ books.get(i).getBookname());
		}
		
		System.out.print("Enter the book that needed to be removed: ");
		removebook = Integer.parseInt(sc.nextLine().trim());
		
		getCondition = books.get(removebook-1).getCondition();
		
		if(getCondition == "Bad") {
			removed = books.remove(removebook-1);
			System.out.println("Book deleted!");
		}else {
			System.out.print("Book is in good condition");
		}
			

	}
	
}
