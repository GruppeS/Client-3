package view; // hentet fra http://javahungry.blogspot.com/2013/06/calendar-implementation-gui-based.html

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class CalendarMonth extends JPanel  // CalendarMonth klasse der extender JPanel
{
	private static final long serialVersionUID = 1L; // Genereret ID
	
		// instansvariable til at holde på JLabels, JTextFields og JButtons
		static JLabel lblMonth, lblYear;
		static JButton btnPrev, btnNext;
		static JTable tblCalendar;
		static JComboBox cmbYear;
		static JFrame frmMain;
		static Container pane;
		static DefaultTableModel mtblCalendar; //Table model
		static JScrollPane stblCalendar; //The scrollpane
		static JPanel pnlCalendar;
	    static int realYear, realMonth, realDay, currentYear, currentMonth;
	    static JButton btnBackToMain;
	    static JCheckBox chckbxNewCheckBox;
	    static JCheckBox chckbxNewCheckBox_1;
	    static JCheckBox chckbxNewCheckBox_2;
			
	    
	public static int getCurrentYear() {
		return currentYear;
	}
	public static void setCurrentYear(int currentYear) {
		CalendarMonth.currentYear = currentYear;
	}

	public static int getCurrentMonth() {
		return currentMonth;
	}
	public static void setCurrentMonth(int currentMonth) {
		CalendarMonth.currentMonth = currentMonth;
	}
	
	public static JComboBox getCmbYear() {
		return cmbYear;
	}
	public static void setCmbYear(JComboBox cmbYear){
		CalendarMonth.cmbYear = cmbYear;
	}
	    
	    public CalendarMonth()
	    {    
	    	setLayout(null); // absolut layout
	    	
	    	
	        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
	        catch (ClassNotFoundException e) {}
	        catch (InstantiationException e) {}
	        catch (IllegalAccessException e) {}
	        catch (UnsupportedLookAndFeelException e) {}
	        
	      
	        lblMonth = new JLabel ("January");
	        lblMonth.setBounds(136, 25, 62, 25);
	        add(lblMonth);
	        
	        lblYear = new JLabel ("Change year:");
	        lblYear.setBounds(10, 305, 80, 20);
	        add(lblYear);
	        
	        cmbYear = new JComboBox();
	        cmbYear.setBounds(230, 305, 80, 20);
	        add(cmbYear);
	        
	        btnPrev = new JButton ("<<");
	        btnPrev.setBounds(10, 25, 70, 25);
	        add(btnPrev);
	        
	        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
	        
	        tblCalendar = new JTable(mtblCalendar);
	        
	        stblCalendar = new JScrollPane(tblCalendar);
	        stblCalendar.setBounds(10, 50, 300, 250);
	        add(stblCalendar);
	        
	        pnlCalendar = new JPanel(null);
	        pnlCalendar.setBounds(0, 0, 320, 335);
	        add(pnlCalendar);
	        
	        btnNext = new JButton (">>");
	        btnNext.setBounds(240, 25, 70, 25);
	        pnlCalendar.add(btnNext);
	  
	       
	        
	        //Get real month/year
	        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
	        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
	        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
	        realYear = cal.get(GregorianCalendar.YEAR); //Get year
	        currentMonth = realMonth; //Match month and year
	        currentYear = realYear;
	        
	        //Add headers
	        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
	        for (int i=0; i<7; i++){
	            mtblCalendar.addColumn(headers[i]);
	        }
	        
	        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
	        
	        //No resize/reorder
	        tblCalendar.getTableHeader().setResizingAllowed(false);
	        tblCalendar.getTableHeader().setReorderingAllowed(false);
	        
	        //Single cell selection
	        tblCalendar.setColumnSelectionAllowed(true);
	        tblCalendar.setRowSelectionAllowed(true);
	        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        
	        //Set row/column count
	        tblCalendar.setRowHeight(38);
	        mtblCalendar.setColumnCount(7);
	        mtblCalendar.setRowCount(6);
	        
	        btnBackToMain = new JButton("Back to Main Menu");
	        btnBackToMain.setBounds(93, 414, 121, 23);
	        add(btnBackToMain);
	        
	        chckbxNewCheckBox = new JCheckBox("New check box");
	        chckbxNewCheckBox.setBounds(10, 332, 97, 23);
	        add(chckbxNewCheckBox);
	        
	        chckbxNewCheckBox_1 = new JCheckBox("New check box");
	        chckbxNewCheckBox_1.setBounds(10, 358, 97, 23);
	        add(chckbxNewCheckBox_1);
	        
	        chckbxNewCheckBox_2 = new JCheckBox("New check box");
	        chckbxNewCheckBox_2.setBounds(10, 384, 97, 23);
	        add(chckbxNewCheckBox_2);
	        
	        
	        //Populate table
	        for (int i=realYear-100; i<=realYear+100; i++){
	            cmbYear.addItem(String.valueOf(i));
	        }
	        
	        //Refresh calendar
	        refreshCalendar (realMonth, realYear); //Refresh calendar
	    }
	    
	    public static void refreshCalendar(int month, int year){
	        //Variables
	        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	        int nod, som; //Number Of Days, Start Of Month
	        
	        //Allow/disallow buttons
	        btnPrev.setEnabled(true);
	        btnNext.setEnabled(true);
	        if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
	        if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
	        lblMonth.setText(months[month]); //Refresh the month label (at the top)
	        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
	        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
	        
	        //Clear table
	        for (int i=0; i<6; i++){
	            for (int j=0; j<7; j++){
	                mtblCalendar.setValueAt(null, i, j);
	            }
	        }
	        
	        //Get first day of month and number of days
	        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
	        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
	        
	        //Draw calendar
	        for (int i=1; i<=nod; i++){
	            int row = new Integer((i+som-2)/7);
	            int column  =  (i+som-2)%7;
	            mtblCalendar.setValueAt(i, row, column);
	        }
	        
	        //Apply renderers
	        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
	    }
	    
	    static class tblCalendarRenderer extends DefaultTableCellRenderer{
	        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
	            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
	            if (column == 0 || column == 6){ //Week-end
	                setBackground(new Color(255, 220, 220));
	            }
	            else{ //Week
	                setBackground(new Color(255, 255, 255));
	            }
	            if (value != null){
	                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
	                    setBackground(new Color(220, 220, 255));
	                }
	            }
	            setBorder(null);
	            setForeground(Color.black);
	            return this;
	        }
	       
	    
	}
	    public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
        {
        	btnPrev.addActionListener(l); // tilføjer actionlistener
    		btnPrev.setActionCommand("PrevBtn"); // tilføjer actioncommand
    		btnNext.addActionListener(l);
    		btnNext.setActionCommand("NextBtn");
    		cmbYear.addActionListener(l);
    		cmbYear.setActionCommand("YearCmb");
    		btnBackToMain.addActionListener(l);
    		btnBackToMain.setActionCommand("BackToMainBtn");
    		chckbxNewCheckBox.addActionListener(l);;
    		chckbxNewCheckBox.setActionCommand("NewCheckBoxchkbx");
    		chckbxNewCheckBox_1.addActionListener(l);
    		chckbxNewCheckBox_1.setActionCommand("NewCheckBoxchckbx_1");
    		chckbxNewCheckBox_2.addActionListener(l);
    		chckbxNewCheckBox_2.setActionCommand("NewCheckBoxchckbx_2");
    }
}