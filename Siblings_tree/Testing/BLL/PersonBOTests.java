package BLL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bl.PersonBO;
import dal.PersonDAOStub;

class PersonBOTests {

	static PersonDAOStub stub;
	static PersonBO bo;

	@BeforeAll
	static void coldStart() {

		try {
			stub = new PersonDAOStub();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bo = new PersonBO(stub);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@BeforeEach
//	void Init() {
//
//		stub = new PersonDAOStub();
//		bo= new PersonBO(stub);
//		}
//	
	@Test
	@DisplayName("Both Father and Mother Same")
	void testIsSibling() {
		Assertions.assertTrue(bo.isSibling(1, 6));
	}

	@Test
	@DisplayName("Both Father and Mother are Different")
	void testIsSibling2() {
		Assertions.assertFalse(bo.isSibling(1, 2));
	}

	@Test
	@DisplayName("Same Father and Different Mother")
	void testIsSibling3() {
		Assertions.assertFalse(bo.isSibling(3, 4));
	}

	@Test
	@DisplayName("Different Father and Same Mother")
	void testIsSibling4() {
		Assertions.assertFalse(bo.isSibling(2, 3));
	}

	@Test
	@DisplayName("Not Half-Siblings both Father and Mother Same")
	void testHalfSibling() {
		Assertions.assertTrue(bo.isHalfSibling(1, 6));
	}

	@Test
	@DisplayName("Not Half-Siblings both Father and Mother are Different")
	void testHalfSibling2() {
		Assertions.assertFalse(bo.isHalfSibling(1, 2));
	}

	@Test
	@DisplayName("Half-Siblings same Father and Different Mother")
	void testHalfSibling3() {
		Assertions.assertTrue(bo.isHalfSibling(3, 4));
	}

	@Test
	@DisplayName("Half-Siblings different Father and same Mother")
	void testHalfSibling4() {
		Assertions.assertTrue(bo.isHalfSibling(2, 3));
	}

}
