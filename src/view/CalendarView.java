package view;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CalendarView extends JPanel  {
	
	private JButton btnBackToMain;
	private JScrollPane scrollPane;
	private JTable table;
	Vector<Object> columnNames = new Vector<Object>();
	
	public CalendarView() {
		setLayout(null);
		
		btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.setBounds(304, 444, 142, 23);
		add(btnBackToMain);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 40, 750, 391);
		add(scrollPane);
	}
	
	public void addTable(Vector<?> data){
		columnNames = new Vector<Object>();
		columnNames.add("Type");
		columnNames.add("Event");
		columnNames.add("Start");
		columnNames.add("End");
		columnNames.add("Location");
		table = new JTable(data, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}
	
	public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
	{
		btnBackToMain.addActionListener(l); // tilføjer actionlistener
		btnBackToMain.setActionCommand("BackToMainBtn"); // tilføjer actioncommand
	}
}
