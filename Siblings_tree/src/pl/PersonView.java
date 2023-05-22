package pl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import bl.IBLL;
import bl.PersonBO;
import dal.Idal;
import dal.PersonDAO;

public class PersonView implements ActionListener {

	public static IBLL bo;
	private JFrame frame;
	private JButton checkButton;
	private JButton searchButton;

	public PersonView() throws SQLException {
		
		frame = new JFrame("Family Tree");
		checkButton = new JButton("Check");
		searchButton = new JButton("Search");
	}

	public void whichButton() {
		searchButton.setBounds(50, 150, 100, 50);
		searchButton.addActionListener(this);
		checkButton.setBounds(150, 150, 100, 50);
		checkButton.addActionListener(this);
		frame.add(checkButton);
		frame.add(searchButton);
		frame.setSize(400, 500);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == searchButton) {
			frame.dispose();
			try {
				PersonDetails frame2=new PersonDetails();
				frame2.getDetails();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource() == checkButton) {
		
			frame.dispose();
			try {
				HalfSiblings frame2=new HalfSiblings();
				frame2.viewSibling();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws SQLException {
		PersonView app;
		Idal dao = new PersonDAO();
		try {
			bo = new PersonBO(dao);
			app = new PersonView();
			app.whichButton();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
