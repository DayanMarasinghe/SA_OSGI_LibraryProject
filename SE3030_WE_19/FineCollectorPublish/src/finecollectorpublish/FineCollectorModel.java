package finecollectorpublish;

public class FineCollectorModel {
	
	private int memberID;
	private String dueDate;
	private boolean finePaied;
	
	public FineCollectorModel() {
		// TODO Auto-generated constructor stub
	}

	public FineCollectorModel(int memberID, String dueDate, boolean finePaied) {
		super();
		this.memberID = memberID;
		this.dueDate = dueDate;
		this.finePaied = finePaied;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isFinePaied() {
		return finePaied;
	}

	public void setFinePaied(boolean finePaied) {
		this.finePaied = finePaied;
	}

	
	

}
