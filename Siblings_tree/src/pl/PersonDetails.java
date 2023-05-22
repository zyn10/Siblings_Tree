package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bl.PersonBO;
import dal.Idal;
import dal.PersonDAO;
import to.Person;

public class PersonDetails implements ActionListener {

	private JFrame frame;
	private JTextField name;
	private JButton button;
	private JTextArea result;
	public PersonBO bo;
	Idal dao= new PersonDAO();
	
	public PersonDetails() throws SQLException {
		
		bo = new PersonBO(dao);
		frame = new JFrame("Search by name");
		button = new JButton("Search");
		name = new JTextField("");
		result = new JTextArea();

	}

	public void getDetails() {
		name.setBounds(50, 50, 200, 50);
		button.setBounds(50, 100, 100, 50);
		button.addActionListener(this);
		result.setBounds(50, 150, 300, 200);
		frame.add(name);
		frame.add(result);
		frame.add(button);
		frame.setSize(600, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String searchName = name.getText();
		Person person = new Person();

		person = bo.searchDetails(searchName);
		if (person.getCnic() == 0) {
			result.setText("No citizens found!");

		} else {
			result.setText("Name");
			result.append("  ");
			result.append("Father");
			result.append("  ");
			result.append("Mother");
			result.append("  ");
			result.append("CNIC");
			result.append("\r\n");

			result.append(person.getName());
			result.append("   ");
			result.append(Integer.toString(person.getFatherCnic()));
			result.append("     ");
			result.append(Integer.toString(person.getMotherCnic()));
			result.append("      ");
			result.append(Integer.toString(person.getCnic()));
			result.append("\r\n");

		}

	}
}