package GuiLayer;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.FlowLayout;

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

/**
 * 
 * @author Kim Dam Gr�nh�j
 *
 */
public class PartStepUI extends JFrame {
	public PartStepUI() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(523, 36, 485, 391);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Ordreliste");
		lblNewLabel.setBounds(10, 11, 330, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ordre detaljer");
		lblNewLabel_1.setBounds(354, 11, 363, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 36, 493, 391);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 493, 391);
		panel_1.add(scrollPane);
		
		JList list = new JList();
		list.setBounds(0, 0, 473, 369);
		list.setValueIsAdjusting(true);
		
		scrollPane.setViewportView(list);
		
		JLabel lblPlse = new JLabel("Pølse");
		list.add(lblPlse);
		lblPlse.setBounds(0, 0, 46, 14);
		lblPlse.setSize(200, 200);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(0, 0, 200, 50);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(new Dimension(1024, 768));
	}
}
