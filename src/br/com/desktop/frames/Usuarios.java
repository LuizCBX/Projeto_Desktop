package br.com.desktop.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.desktop.dal.ConnectionModule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Usuarios extends JFrame {
	
	// Criando variáveis de apoio
	Connection con = ConnectionModule.conector(); // Conecta com o banco
	PreparedStatement pst = null; //executa
	ResultSet rs = null;// Resultado do banco

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtFone;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
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
	public Usuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/br/com/desktop/icons/usuarios.png")));
		setResizable(false);
		setTitle("Usu\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 416);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("");
		lblId.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/id.png")));
		lblId.setToolTipText("* ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(69, 44, 32, 32);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(111, 56, 174, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("* Campos obrigat\u00F3rios");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(450, 44, 174, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/usuario.png")));
		lblUsuario.setToolTipText("* USU\u00C1RIO");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(69, 87, 32, 32);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(111, 97, 174, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblFone = new JLabel("");
		lblFone.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/fone.png")));
		lblFone.setToolTipText("TELEFONE");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFone.setBounds(69, 130, 32, 32);
		contentPane.add(lblFone);
		
		txtFone = new JTextField();
		txtFone.setBounds(111, 139, 174, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setToolTipText("* Login");
		lblLogin.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/icons8-male-user-filled-50.png")));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(53, 193, 50, 50);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(111, 212, 145, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/icons8-secure-50.png")));
		lblSenha.setToolTipText("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(277, 193, 50, 50);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(337, 212, 145, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		//ADICIONAR
		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
				
			}
		});
		btnCreate.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/create.png")));
		btnCreate.setToolTipText("Adicionar Usu\u00E1rio");
		btnCreate.setBounds(100, 278, 64, 64);
		contentPane.add(btnCreate);
		
		
		//PESQUISAR
		JButton btnRead = new JButton("");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnRead.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/read.png")));
		btnRead.setToolTipText("Pesquisar Usu\u00E1rios");
		btnRead.setBounds(209, 278, 64, 64);
		contentPane.add(btnRead);
		
		//UPDATE
		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnUpdate.setToolTipText("Atualizar Usu\u00E1rio");
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/update.png")));
		btnUpdate.setBounds(321, 278, 64, 64);
		contentPane.add(btnUpdate);
		
		//DELETAR 
		JButton btnDelete = new JButton("New button");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnDelete.setIcon(new ImageIcon(Usuarios.class.getResource("/br/com/desktop/icons/delete.png")));
		btnDelete.setToolTipText("Remover Usu\u00E1rio");
		btnDelete.setBounds(432, 278, 64, 64);
		contentPane.add(btnDelete);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(43, 186, 10, 32);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(61, 38, 10, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_2.setBounds(61, 87, 10, 20);
		contentPane.add(label_2);
		
		JLabel lblGerenciamentoDeUsurio = new JLabel("Gerenciamento de usu\u00E1rio");
		lblGerenciamentoDeUsurio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGerenciamentoDeUsurio.setBounds(209, 11, 279, 34);
		contentPane.add(lblGerenciamentoDeUsurio);
		
	}
	
	//LIMPAR DADOS DOS CAMPOS
	private void limpar() {
		txtId.setText(null);
		txtUsuario.setText(null);
		txtFone.setText(null);
		txtLogin.setText(null);
		txtSenha.setText(null);
	}
	
	/** CRUD - CREATE **/
	//CRIAR USUARIO
	private void adicionar() {
		

		String create = "insert into tb_usuario (id, usuario, foneUsuario, login, senha) values(?,?,?,?,?)";
		try {
				pst = (PreparedStatement) con.prepareStatement(create);
				//passagem de parametros
				pst.setString(1, txtId.getText());
				pst.setString(2, txtUsuario.getText());
				pst.setString(3, txtFone.getText());
				pst.setString(4, txtLogin.getText());
				pst.setString(5, txtSenha.getText());
				
				
				int r = pst.executeUpdate();
	

				if (r > 0) {
					JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso!");
					limpar();
				}
				else {
					JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar!");
					limpar();
				}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//PESQUISAR USUARIO
	private void pesquisar() {
		String read = "select * from tb_usuario where id =?";
		// Usamos o try catch para tratar exceção
		try {
				pst = (PreparedStatement) con.prepareStatement(read);
				// passagem do parâmetro
				pst.setString(1, txtId.getText());
				// atribuimos a variavel rs retorno do comando
				rs = pst.executeQuery();// Executar a query(sql)
			if(rs.next()) {
				txtUsuario.setText(rs.getString(2));
				txtFone.setText(rs.getString(3));
				txtLogin.setText(rs.getString(4));
				txtSenha.setText(rs.getString(5));
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuário inexistente!");
				limpar();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//ATUALIZAR USUARIOS
	
	private void atualizar() {
		String update = "update tb_usuario set usuario=?, foneUsuario=?, login=?, senha=? where id=?";
		try {
			pst = (PreparedStatement) con.prepareStatement(update);
			// passagem de parâmetros
			// o id é o ultimo parâmetro
			pst.setString(1, txtUsuario.getText());
			pst.setString(2, txtFone.getText());
			pst.setString(3, txtLogin.getText());
			pst.setString(4, txtSenha.getText());
			pst.setString(5, txtId.getText());
			
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar o cadastro!");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim
	}
	

	//DELETAR USUARIOS
	private void remover() {
		// criar uma caixa de diálogo para confirmar a exclusão
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuário ?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			String delete = "delete from tb_usuario where id=?";

			try {
					pst = (PreparedStatement) con.prepareStatement(delete);
					pst.setString(1, txtId.getText());
					int r = pst.executeUpdate();
					if (r > 0) {
						limpar();
						JOptionPane.showMessageDialog(null, "Usuário deletado com sucesso!");
	
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel remover o cadastro!");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} // fim do if

	}// fim do construtor
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


