package GuiLayer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import ModelLayer.Employee;
import javax.swing.JCheckBox;

public class EmployeesView extends JPanel {
	private ArrayList<Employee> employees;
	public EmployeesView(List<Employee> list, final DetailView dtView, final int id) {
		this.employees = (ArrayList<Employee>) list;
		this.setBounds(10, 402, 465, 262);
		this.setVisible(false);
		setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 455, 211);
		add(panel_4);
		panel_4.setLayout(new MigLayout("", "[grow][grow]", "[grow][grow]"));
		
		
		
		int colIndex = 0;
		int rowIndex = 0;
		for(int i = 0; i < list.size(); i++)
		{	
			int m = i % 2;
						
			JPanel panel = new JPanel();
			panel_4.add(panel, "cell " + colIndex + " " + rowIndex + ",grow");
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(0, 0, 97, 97);
			lblNewLabel.setIcon(new ImageIcon("D:\\Datamatiker\\1. års projekt\\Kode29052015\\trunk\\Tobias.jpg"));
			panel.add(lblNewLabel);
			
			JLabel lblFlotfyr = new JLabel(list.get(i).getName());
			lblFlotfyr.setBounds(107, 11, 102, 75);
			panel.add(lblFlotfyr);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("");
			chckbxNewCheckBox.setBounds(187, 11, 20, 20);
			panel.add(chckbxNewCheckBox, "cell 0 0");
			
			if(m == 1){
				rowIndex++;
			}
			if(colIndex == 0){
				colIndex = 1;
			}else{
				colIndex = 0;
			}
		}
		final EmployeesView EmpView = this;
		JButton BtnBack = new JButton("Back");
		BtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				EmpView.setVisible(false);
				dtView.showStepsContainer();
				dtView.setVisible(true);
				dtView.revalidate();
				dtView.repaint();
			}
		});
		BtnBack.setBounds(0, 222, 224, 23);
		add(BtnBack);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(289, 222, 89, 23);
		add(btnNewButton_1);
	}
}
