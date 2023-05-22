package dal;
import java.util.Hashtable;

import to.Person;
public class PersonDAOStub implements Idal {


	private Hashtable<Integer, Person> db;
	
	@Override
	public Person getPerson(int cnic) {
		// TODO Auto-generated method stub
		return db.get(cnic);
	}

	@Override
	public Person getDetails(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PersonDAOStub() {
		super();
		db = new Hashtable<Integer,Person>();
		db.put(1, new Person(1,"Zain",11,22));
		db.put(2, new Person(2,"taha",33,44));
		db.put(3, new Person(3,"sohaib",55,44));
		db.put(4, new Person(4,"ali",55,66));
		db.put(5, new Person(5,"Zaib",11,22));
		db.put(6, new Person(6,"Fahad",11,22));
		
	}

}
