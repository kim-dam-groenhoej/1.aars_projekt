package GuiLayer;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JScrollBar;
import javax.swing.JList;

import java.awt.GridLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.SpringLayout;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Kim Dam Gr�nh�j, Tobias
 *
 */
public class PartStepUI extends JFrame {
	public PartStepUI() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(523, 36, 485, 675);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Ordreliste");
		lblNewLabel.setBounds(20, 11, 330, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ordre detaljer");
		lblNewLabel_1.setBounds(524, 11, 363, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(20, 36, 493, 675);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		scrollPane.setViewportView(panel_1);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		
		createOrderItems(gl_panel_1);
		
		panel_1.setLayout(gl_panel_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(0, 0, 200, 50);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(new Dimension(1024, 768));
	}
	
	private void createOrderItems(GroupLayout groupL)
	{
		groupL.setHorizontalGroup(groupL.createParallelGroup(Alignment.LEADING));
		groupL.setVerticalGroup(groupL.createParallelGroup(Alignment.LEADING));
		
		SequentialGroup ggg = groupL.createSequentialGroup();
		ggg = ggg.addContainerGap();
		
		SequentialGroup aaa = groupL.createSequentialGroup();
		aaa = aaa.addContainerGap();
		
		//for (int i = 0; i<10;i++) {
			
			JPanel panel_3 = new JPanel();
			JPanel panel_3_1 = new JPanel();
			
			ggg = ggg.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE).addComponent(panel_3_1, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE).addContainerGap();
		
			aaa = aaa.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE).addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE).addContainerGap(566, Short.MAX_VALUE);
			

			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setBounds(10, 11, 46, 14);
			panel_3.add(lblNewLabel_2);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(253, 11, 191, 97);
			panel_3.add(scrollPane_1);
			
			JPanel panel_4 = new JPanel();
			scrollPane_1.setViewportView(panel_4);
		//}
		
		groupL.setHorizontalGroup(groupL.createParallelGroup(Alignment.LEADING).addGroup(ggg));
		groupL.setVerticalGroup(groupL.createParallelGroup(Alignment.LEADING).addGroup(aaa));
	}
}
