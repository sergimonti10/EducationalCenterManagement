package EducationalCenter.Panels;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import EducationalCenter.Controllers.CourseControl;
import EducationalCenter.Models.Course;

public class CourseWindow extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCargarAnteriorRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarPrimerRegistro;
	private JButton btnCargarUltimoRegistro;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;

	public CourseWindow() {

		setBounds(250, 50, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
//	gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//	gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//	gbl_contentPane.columnWidths = new int[]{0, 0};
//	gbl_contentPane.rowHeights = new int[]{0, 0};
//	gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//	gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.setLayout(gbl_contentPane);

		JLabel lblNewLabel_2 = new JLabel("Gestión de cursos");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		this.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weightx = 1.0;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		this.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		this.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		this.add(panel, gbc_panel);

		btnCargarPrimerRegistro = new JButton("<<");
		btnCargarPrimerRegistro.setEnabled(false);
		btnCargarPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFirstCourse();
				buttons();
			}
		});

		btnNuevo = new JButton("Nuevo registro");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newCourse();
			}
		});
		panel.add(btnNuevo);

		btnGuardar = new JButton("Guardar registro");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveCourse();
			}
		});
		panel.add(btnGuardar);

		btnEliminar = new JButton("Eliminar registro");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCourse();
			}
		});
		panel.add(btnEliminar);
		panel.add(btnCargarPrimerRegistro);

		btnCargarAnteriorRegistro = new JButton("<");
		btnCargarAnteriorRegistro.setEnabled(false);
		btnCargarAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPreviusCourse();
				buttons();
			}
		});
		panel.add(btnCargarAnteriorRegistro);

		btnCargarSiguienteRegistro = new JButton(">");
		btnCargarSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showNextCourse();
				buttons();
			}
		});
		panel.add(btnCargarSiguienteRegistro);

		btnCargarUltimoRegistro = new JButton(">>");
		btnCargarUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLastCourse();
				buttons();
			}
		});
		panel.add(btnCargarUltimoRegistro);
		showFirstCourse();
	}

	/**
	 * 
	 */
	private void showFirstCourse() {
		Course curso = new CourseControl().loadFirstRecord();

		if (curso != null) {
			this.textField.setText("" + curso.getId());
			this.textField_1.setText("" + curso.getDescription());
		}
	}

	/**
	 * 
	 */
	private void showLastCourse() {
		Course curso = new CourseControl().loadLastRecord();

		if (curso != null) {
			this.textField.setText("" + curso.getId());
			this.textField_1.setText("" + curso.getDescription());
		}
	}

	/**
	 * 
	 */
	private void showPreviusCourse() {
		Course course = new Course(Integer.parseInt(this.textField.getText()), this.textField_1.getText());
		Course c = new CourseControl().loadPreviusRecord(course);

		if (c != null) {
			this.textField.setText("" + c.getId());
			this.textField_1.setText("" + c.getDescription());
		}
	}

	/**
	 * 
	 */
	private void showNextCourse() {
		Course course = new Course(Integer.parseInt(this.textField.getText()), this.textField_1.getText());
		Course c = new CourseControl().loadNextRecord(course);

		if (c != null) {
			this.textField.setText("" + c.getId());
			this.textField_1.setText("" + c.getDescription());
		}
	}

	/**
	 * 
	 * @return
	 */
	private int getMaxID() {
		int c = new CourseControl().loadLastRecord().getId();
		return c;
	}

	/**
	 * 
	 * @return
	 */
	private int getFirstID() {
		int c = new CourseControl().loadFirstRecord().getId();
		return c;
	}

	/**
	 * 
	 * @return
	 */
	private boolean thereIsNextRecord() {
		if (Integer.parseInt(this.textField.getText()) < getMaxID()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @return
	 */
	private boolean thereIsPreviusRecord() {
		if (Integer.parseInt(this.textField.getText()) > getFirstID()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 */
	public void buttons() {
		if (!thereIsPreviusRecord()) {
			this.btnCargarAnteriorRegistro.setEnabled(false);
			this.btnCargarPrimerRegistro.setEnabled(false);
		} else {
			this.btnCargarAnteriorRegistro.setEnabled(true);
			this.btnCargarPrimerRegistro.setEnabled(true);
		}
		if (!thereIsNextRecord()) {
			this.btnCargarSiguienteRegistro.setEnabled(false);
			this.btnCargarUltimoRegistro.setEnabled(false);
		} else {
			this.btnCargarSiguienteRegistro.setEnabled(true);
			this.btnCargarUltimoRegistro.setEnabled(true);
		}
	}

	/**
	 * 
	 */
	public void newCourse() {
		int newId = getMaxID() + 1;
		textField.setText("" + newId);
		textField_1.setText("");
	}
	
	/**
	 * 
	 */
	public void deleteCourse() {
		Course course = new Course(Integer.parseInt(this.textField.getText()), this.textField_1.getText());
		CourseControl.deleteCourse(course);
		showPreviusCourse();
	}
	
	/**
	 * 
	 */
	public void saveCourse() {
		Course course = new Course(Integer.parseInt(this.textField.getText()), this.textField_1.getText());
		CourseControl.saveCourse(course);
	}
}
