package bl;
import dal.Idal;
import dal.PersonDAO;
import dal.PersonDAOStub;
import to.Person;

public class PersonBO implements IBLL {
	private Idal dao;
	
	public PersonBO(Idal dao) {
		this.dao = dao;
	}

	public boolean isSibling(int cnic1, int cnic2) {
		Person p1 = dao.getPerson(cnic1);
		Person p2 = dao.getPerson(cnic2);

		return sameFather(p1, p2) && sameMother(p1, p2);
	}

	public boolean isHalfSibling(int cnic1, int cnic2) {
		Person p1 = dao.getPerson(cnic1);
		Person p2 = dao.getPerson(cnic2);
		return sameFather(p1, p2) || sameMother(p1, p2);
	}

	private boolean sameMother(Person p1, Person p2) {
		return p1.getMotherCnic() == p2.getMotherCnic();
	}

	private boolean sameFather(Person p1, Person p2) {
		return p1.getFatherCnic() == p2.getFatherCnic();
	}

	public Person searchDetails(String userName) {
		Person details = new Person();
		details = dao.getDetails(userName);
		return details;
	}
	}
