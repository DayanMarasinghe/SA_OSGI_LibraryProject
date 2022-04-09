package finecollectorpublish;

public interface FineCollectorService {

	public void calculateFine(int memberID, String dueDate);
	public void payFine(int memberID);
}
