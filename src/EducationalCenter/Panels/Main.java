package EducationalCenter.Panels;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Main extends JFrame {
	
	public Main () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("Cursos", new CourseWindow());
		
		JPanel pnl2 = new JPanel();
		pnl2.setBackground(Color.RED);
		
		tabedPane.add("Pestaña 2", pnl2);
		
		this.setContentPane(tabedPane);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Main vp = new Main();
		vp.setVisible(true);
	}

}