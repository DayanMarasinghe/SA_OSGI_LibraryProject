package booklendingpublish;

public class BookLendingModel {

	private String bookName;
	private boolean availability;
	
	public BookLendingModel() {
		// TODO Auto-generated constructor stub
	}

	public BookLendingModel(String bookName, boolean availability) {
		super();
		this.bookName = bookName;
		this.availability = availability;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	

	
	
}
