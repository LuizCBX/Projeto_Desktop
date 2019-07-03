package br.com.desktop.frames;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.*;

import br.com.desktop.dal.ConnectionModule;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Login extends JFrame {
	
	
	// Criando variáveis de apoio
	Connection con = ConnectionModule.conector(); // Conecta com o banco
	PreparedStatement pst = null; //executa
	ResultSet rs = null;// Resultado do banco

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/br/com/desktop/icons/icons8-male-user-filled-50.png")));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setToolTipText("Digite seu login");
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/br/com/desktop/icons/icons8-male-user-filled-50.png")));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsuario.setBounds(45, 42, 50, 50);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setToolTipText("Digite a senha");
		lblSenha.setIcon(new ImageIcon(Login.class.getResource("/br/com/desktop/icons/icons8-secure-50.png")));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSenha.setBounds(45, 103, 50, 50);
		contentPane.add(lblSenha);
		
		txtUser = new JTextField();
		txtUser.setBounds(123, 53, 180, 33);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnLogin = new JButton("");
		btnLogin.setToolTipText("Entrar");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/br/com/desktop/icons/log-in.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBounds(179, 155, 64, 64);
		contentPane.add(btnLogin);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/br/com/desktop/icons/dberror.png")));
		lblStatus.setBounds(371, 21, 48, 46);
		contentPane.add(lblStatus);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(123, 111, 180, 33);
		contentPane.add(txtPassword);
		
		//conexão
		con = ConnectionModule.conector();
		
		if(con != null) {
			//System.out.println("banco conectado");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/desktop/icons/dbok.png")));
		}else {
			//System.out.println("erro de conexão");
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/desktop/icons/dberror.png")));
		}
				
	}//fim construtor
	
	//limpar 
	
	private void limpar() {
		txtUser.setText(null);
		txtPassword.setText(null);
	}
	
	//login --
	private void login() {
		String read = "select * from tb_usuario where login=? and senha=?";
		try {
			pst = con.prepareStatement(read);
			pst.setString(1,txtUser.getText());
			pst.setString(2,txtPassword.getText());
			rs =  pst.executeQuery();
			
			
			if(rs.next()) {
				
/*				System.out.println("Logou");
				new Principal().setVisible(true);*/
				
				Principal principal = new Principal();
				principal.setVisible(true);
				//Centralizar o JFRAME
				principal.setLocationRelativeTo(null);
				this.dispose(); //depois que chamar a tela principal, fecha a tela de login
		
			}else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválido(s)");
				limpar();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
}
