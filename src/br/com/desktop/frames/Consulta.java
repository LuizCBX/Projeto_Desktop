package br.com.desktop.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class Consulta extends JFrame {

	private JPanel contentPane;
	private JTextField txtPaciente;
	private JTextField txtId;
	private JTextField txtPreco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Consulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Consulta.class.getResource("/br/com/desktop/icons/consulta1.png")));
		setTitle("Consulta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 511);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 379, 154);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Paciente:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(0, 17, 58, 14);
		panel.add(lblNewLabel);
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(68, 14, 134, 20);
		panel.add(txtPaciente);
		txtPaciente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/pesquisar.png")));
		lblNewLabel_1.setBounds(212, 11, 32, 32);
		panel.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(297, 14, 41, 20);
		panel.add(txtId);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(255, 17, 32, 14);
		panel.add(lblId);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 54, 359, 90);
		panel.add(textPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 176, 379, 154);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblData = new JLabel("DATA DA CONSULTA: ");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setBounds(10, 11, 166, 14);
		panel_2.add(lblData);
		
		JLabel lblHorario = new JLabel("HOR\u00C1RIO DA CONSULTA:");
		lblHorario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario.setBounds(14, 37, 160, 14);
		panel_2.add(lblHorario);
		
		MaskFormatter dataConsulta=null;
		try {
			dataConsulta= new MaskFormatter("##/##/####");
		} catch (Exception e) {e.printStackTrace();}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(184, 65, 145, 22);
		panel_2.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"None", "Fonoaudi\u00F3logo(a)", "Nutricionista", "Fisioterapeuta", "Vocal Coach"}));
		
		JLabel lblTipoDeEspecialista = new JLabel("TIPO DE ESPECIALISTA:\r\n");
		lblTipoDeEspecialista.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeEspecialista.setBounds(-2, 69, 176, 14);
		panel_2.add(lblTipoDeEspecialista);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"None", "Dr. Leandro Augusto", "Dr. Luiz Henrique", "Dr. Matheus Motta", "Dr. Murillo Ramos", "Dra. Geovana Sousa"}));
		comboBox_1.setBounds(184, 98, 145, 22);
		panel_2.add(comboBox_1);
		
		JLabel lblDoutor = new JLabel("NOME DO ESPECIALISTA:\r\n");
		lblDoutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDoutor.setBounds(-2, 102, 176, 14);
		panel_2.add(lblDoutor);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(184, 5, 145, 20);
		panel_2.add(dateChooser);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"None", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"}));
		comboBox_2.setBounds(184, 33, 145, 22);
		panel_2.add(comboBox_2);
		
		JLabel lblPreco = new JLabel("PRE\u00C7O CONSULTA:");
		lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco.setBounds(8, 128, 166, 14);
		panel_2.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(183, 125, 146, 20);
		panel_2.add(txtPreco);
		txtPreco.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 341, 379, 120);
		contentPane.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JLabel lblSituacao = new JLabel("SITUA\u00C7\u00C3O DA CONSULTA:");
		lblSituacao.setBounds(10, 11, 164, 14);
		panel_1.add(lblSituacao);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "AGENDADO", "AGENDAMENTO INCOMPLETO", "AGENDAMENTO CANCELADO"}));
		comboBox_3.setBounds(184, 7, 186, 22);
		panel_1.add(comboBox_3);
		
		JButton button = new JButton("");
		button.setBounds(10, 36, 64, 64);
		panel_1.add(button);
		button.setToolTipText("Agendar consulta");
		button.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/create.png")));
		
		JButton button_2 = new JButton("");
		button_2.setBounds(84, 36, 64, 64);
		panel_1.add(button_2);
		button_2.setToolTipText("Pesquisar consulta");
		button_2.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/read.png")));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(158, 36, 64, 64);
		panel_1.add(btnNewButton);
		btnNewButton.setToolTipText("Editar consulta");
		btnNewButton.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/update.png")));
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(232, 36, 64, 64);
		panel_1.add(button_1);
		button_1.setToolTipText("Apagar consulta");
		button_1.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/delete.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pdfImprimir();
			}
		});
		btnNewButton_1.setBounds(306, 36, 64, 64);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/impressora.png")));
	}
	
	private void pdfImprimir() {
		
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("imprimir.pdf"));
			document.open();
			document.add(new Paragraph("Relatório do agendamento!"));
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			document.close();
		}
		try {
			Desktop.getDesktop().open(new File("imprimir.pdf"));
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}
}
