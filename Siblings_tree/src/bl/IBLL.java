package bl;
import to.Person;

public interface IBLL {
	public boolean isSibling(int cnic1, int cnic2) ;
	public boolean isHalfSibling(int cnic1, int cnic2);
	public Person searchDetails(String userName);
}
