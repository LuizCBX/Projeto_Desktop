package br.com.desktop.frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Sobre");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(About.class.getResource("/br/com/desktop/icons/GNU.png")));
		lblNewLabel.setBounds(354, 0, 70, 128);
		contentPanel.add(lblNewLabel);
		
		JLabel lblDesenvolvidoPor = new JLabel("Desenvolvido por: \r\n\r\n");
		lblDesenvolvidoPor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDesenvolvidoPor.setBounds(10, 22, 189, 21);
		contentPanel.add(lblDesenvolvidoPor);
		
		JLabel lblNewLabel_1 = new JLabel("Luiz Henrique ");
		lblNewLabel_1.setBounds(10, 47, 126, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Leandro Augusto");
		lblNewLabel_2.setBounds(10, 72, 100, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Murillo Ramos");
		lblNewLabel_3.setBounds(10, 97, 100, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Matheus Motta");
		lblNewLabel_4.setBounds(10, 122, 100, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 1.0");
		lblVerso.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVerso.setBounds(10, 153, 100, 14);
		contentPanel.add(lblVerso);
		
		JLabel label = new JLabel("Sob Licen\u00E7a GPL");
		label.setBounds(10, 180, 154, 14);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
