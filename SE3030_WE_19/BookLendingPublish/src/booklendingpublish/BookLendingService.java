package booklendingpublish;

public interface BookLendingService {

	public void checkIn(String bookName);
	public void checkOut(String bookName);

}
