package bookregisterpublish;

public class Books {

	private String bookname;
	private boolean status;
	private String condition;

	
	public Books(String bookname, boolean status, String condition) {
		super();
		this.bookname = bookname;
		this.status = status;
		this.condition = condition;
	}


	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public boolean getStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getCondition() {
		return condition;
	}


	public void setCondition(String condition) {
		this.condition = condition;
	}


}
