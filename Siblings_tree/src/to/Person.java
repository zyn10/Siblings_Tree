package to;
/**
 * 
 * @author zain
 *
 */


public class Person {
	private int cnic;
	private String name;
	private int fatherCnic;
	private int motherCnic;
	/**
	 * @author zain
	 * @param cnic
	 */
	
	public Person() {

	}
	public Person(int  cnic,String name,int fatherCnic,int motherCnic) {
	this.cnic = cnic;
	this.name = name;
	this.fatherCnic = fatherCnic;
	this.motherCnic =motherCnic;
	}
	public void setCnic(int cnic) {
		this.cnic = cnic;
	}

	public int getCnic() {
		return cnic;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setFatherCnic(int fatherCnic) {
		this.fatherCnic = fatherCnic;
	}

	public int getFatherCnic() {
		return fatherCnic;
	}

	public void setMotherCnic(int motherCnic) {
		this.motherCnic = motherCnic;
	}

	public int getMotherCnic() {
		return motherCnic;
	}

}