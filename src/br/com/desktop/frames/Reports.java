package br.com.desktop.frames;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reports extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports frame = new Reports();
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
	public Reports() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reports.class.getResource("/br/com/desktop/icons/relatorio.png")));
		setTitle("Relat\u00F3rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pdfClientes();
			}
		});
		btnNewButton.setToolTipText("Relat\u00F3rio de Clientes");
		btnNewButton.setIcon(new ImageIcon(Reports.class.getResource("/br/com/desktop/icons/relatorio clientes.png")));
		btnNewButton.setBounds(102, 38, 64, 64);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setToolTipText("Relat\u00F3rio Financeiro");
		button.setIcon(new ImageIcon(Reports.class.getResource("/br/com/desktop/icons/relatorio faturamento.png")));
		button.setBounds(242, 38, 64, 64);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("Escolha uma data especifica:");
		lblNewLabel.setFont(new Font("Tekton Pro", Font.BOLD, 20));
		lblNewLabel.setBounds(89, 113, 252, 37);
		contentPane.add(lblNewLabel);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(115, 148, 191, 153);
		contentPane.add(calendar);
	}//fim do construtor
	
	
	private void pdfClientes() {
		
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			document.add(new Paragraph("Clientes cadastrados"));
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			document.close();
		}
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e2) {
			System.out.println(e2);
		}
	}
}
