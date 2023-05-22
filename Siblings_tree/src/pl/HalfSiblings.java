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

public class HalfSiblings implements ActionListener {

	private JFrame frame;
	private JTextField cnic1;
	private JTextField cnic2;
	private JButton checkButton;
	private JTextArea result;
	public PersonBO bo;
	
	Idal dao= new PersonDAO();

	public HalfSiblings() throws SQLException {

		bo = new PersonBO(dao);
		frame = new JFrame("Family Tree");
		cnic1 = new JTextField("");
		cnic2 = new JTextField("");
		checkButton = new JButton("Check ");
		result = new JTextArea();
	}

	public void viewSibling() {
		cnic1.setBounds(50, 50, 200, 50);
		cnic2.setBounds(50, 100, 200, 50);
		checkButton.setBounds(50, 150, 100, 50);
		checkButton.addActionListener(this);
		result.setBounds(50, 200, 200, 200);
		frame.add(cnic1);
		frame.add(cnic2);
		frame.add(result);
		frame.add(checkButton);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		int nic1 = Integer.parseInt(cnic1.getText());
		int nic2 = Integer.parseInt(cnic2.getText());
		if (bo.isSibling(nic1, nic2)) {
			result.setText("Yes, the two citizens are siblings");
		} else if (bo.isHalfSibling(nic1, nic2)) {
			result.setText("Yes, the two citizens are Half siblings");
		} else {
			result.setText("No, the two citizens are not siblings");
		}

	}

}
