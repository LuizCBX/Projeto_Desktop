package br.com.desktop.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;

import br.com.desktop.dal.ConnectionModule;
import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.awt.ScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Consulta extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;


	private JPanel contentPane;
	private JTextField txtIdConsulta;
	private JTextField txtId;
	private JTextField txtPreco;
	private JComboBox cboHorario;
	private JComboBox cboTipo;
	private JComboBox cboNome;
	private JComboBox cboSituacao;
	private JTextField dtConsulta;
	private JTable table;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtFone;

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
		setBounds(100, 100, 415, 623);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 286, 379, 156);
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
		
		 cboTipo = new JComboBox();
		cboTipo.setBounds(184, 65, 145, 22);
		panel_2.add(cboTipo);
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"None", "Fonoaudi\u00F3logo(a)", "Nutricionista", "Fisioterapeuta", "Vocal Coach"}));
		
		JLabel lblTipoDeEspecialista = new JLabel("TIPO DE ESPECIALISTA:\r\n");
		lblTipoDeEspecialista.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeEspecialista.setBounds(-2, 69, 176, 14);
		panel_2.add(lblTipoDeEspecialista);
		
		cboNome = new JComboBox();
		cboNome.setModel(new DefaultComboBoxModel(new String[] {"None", "Dr. Leandro Augusto", "Dr. Luiz Henrique", "Dr. Matheus Motta", "Dr. Murillo Ramos", "Dra. Geovana Sousa"}));
		cboNome.setBounds(184, 98, 145, 22);
		panel_2.add(cboNome);
		
		JLabel lblDoutor = new JLabel("NOME DO ESPECIALISTA:\r\n");
		lblDoutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDoutor.setBounds(-2, 102, 176, 14);
		panel_2.add(lblDoutor);
		
		cboHorario = new JComboBox();
		cboHorario.setModel(new DefaultComboBoxModel(new String[] {"None", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00"}));
		cboHorario.setBounds(184, 33, 145, 22);
		panel_2.add(cboHorario);
		
		JLabel lblPreco = new JLabel("PRE\u00C7O CONSULTA:");
		lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco.setBounds(8, 128, 166, 14);
		panel_2.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(183, 125, 146, 20);
		panel_2.add(txtPreco);
		txtPreco.setColumns(10);
		
		dtConsulta = new JTextField();
		dtConsulta.setColumns(10);
		dtConsulta.setBounds(183, 8, 146, 20);
		panel_2.add(dtConsulta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 453, 379, 120);
		contentPane.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JLabel lblSituacao = new JLabel("SITUA\u00C7\u00C3O DA CONSULTA:");
		lblSituacao.setBounds(10, 11, 164, 14);
		panel_1.add(lblSituacao);
		
		cboSituacao = new JComboBox();
		cboSituacao.setModel(new DefaultComboBoxModel(new String[] {"", "AGENDADO", "AGENDAMENTO INCOMPLETO", "AGENDAMENTO CANCELADO"}));
		cboSituacao.setBounds(184, 7, 186, 22);
		panel_1.add(cboSituacao);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adicionarConsulta();
			}
		});
		button.setBounds(10, 36, 64, 64);
		panel_1.add(button);
		button.setToolTipText("Agendar consulta");
		button.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/create.png")));
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pesquisarConsulta();
			}
		});
		button_2.setBounds(84, 36, 64, 64);
		panel_1.add(button_2);
		button_2.setToolTipText("Pesquisar consulta");
		button_2.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/read.png")));
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				alterarConsulta();
				
			}
		});
		btnNewButton.setBounds(158, 36, 64, 64);
		panel_1.add(btnNewButton);
		btnNewButton.setToolTipText("Editar consulta");
		btnNewButton.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/update.png")));
		
		JButton button_1 = new JButton("New button");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				removerConsulta();
			}
		});
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
		
		JLabel lblNewLabel = new JLabel("ID PACIENTE:");
		lblNewLabel.setBounds(10, 18, 87, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtIdConsulta = new JTextField();
		txtIdConsulta.setBounds(107, 15, 69, 20);
		contentPane.add(txtIdConsulta);
		txtIdConsulta.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
				pesquisarPaciente();
			}
		});
		txtIdConsulta.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(181, 12, 32, 32);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Consulta.class.getResource("/br/com/desktop/icons/pesquisar.png")));
		
		JLabel lblId = new JLabel("ID CONSULTA:");
		lblId.setBounds(213, 18, 86, 14);
		contentPane.add(lblId);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtId = new JTextField();
		txtId.setBounds(317, 15, 72, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 379, 106);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setarCampos();
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 184, 379, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(10, 11, 48, 14);
		panel.add(lblId_1);
		
		JLabel lblNome = new JLabel("Nome Paciente:");
		lblNome.setBounds(141, 11, 98, 14);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 49, 48, 14);
		panel.add(lblCpf);
		
		JLabel lblNewLabel_2 = new JLabel("Fone:");
		lblNewLabel_2.setBounds(177, 49, 48, 14);
		panel.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(30, 8, 67, 20);
		panel.add(txtID);
		txtID.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(235, 8, 96, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(40, 46, 96, 20);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.setBounds(235, 46, 96, 20);
		panel.add(txtFone);
		txtFone.setColumns(10);
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
	
//	private void limpar() {
//		txtId.setText(null);
//		dtConsulta.setText(null);
//		cboHorario.setModel(new DefaultComboBoxModel(new String[] {""}));
//		cboTipo.setModel(new DefaultComboBoxModel(new String[] {""}));
//		cboNome.setModel(new DefaultComboBoxModel(new String[] {""}));
//		txtPreco.setText(null);
//		cboNome.setModel(new DefaultComboBoxModel(new String[] {""}));
//		cboSituacao.setModel(new DefaultComboBoxModel(new String[] {""}));
//		
//	}
	
	
	
	//CRUD
	
	
	//ADICIONAR
	
	private void adicionarConsulta() {
		String create = "insert into tb_consulta (dataConsulta, horarioConsulta, tipoEspecialista, nomeEspecialista, preco, situacaoConsulta, idConsulta)"
				+ "values(?,?,?,?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			// passagem de parâmetros
			pst.setString(1, dtConsulta.getText());
			pst.setString(2, cboHorario.getSelectedItem().toString());
			pst.setString(3, cboTipo.getSelectedItem().toString());
			pst.setString(4, cboNome.getSelectedItem().toString());
			pst.setString(5, txtPreco.getText());
			pst.setString(6, cboSituacao.getSelectedItem().toString());
			pst.setString(7, txtId.getText());

			
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso!");
				//limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim do catch

	}// fim do construtor
	
	//ALTERAR
	private void alterarConsulta() {
		String update = "update tb_consulta set dataConsulta=?, horarioConsulta=?, tipoEspecialista=?, nomeEspecialista=?, preco=?, situacaoConsulta=? where idConsulta=?";
		try {
			pst = (PreparedStatement) con.prepareStatement(update);
			//passagem de parâmetros
			//ATENÇÃO id é o 4° parâmetro
			pst.setString(1, dtConsulta.getText().toString());
			pst.setString(2, cboHorario.getSelectedItem().toString());
			pst.setString(3, cboTipo.getSelectedItem().toString());
			pst.setString(4, cboNome.getSelectedItem().toString());
			pst.setString(5, txtPreco.getText());
			pst.setString(6, cboSituacao.getSelectedItem().toString());
			pst.setString(7, txtId.getText().toString());
			int r = pst.executeUpdate();//EXECUTA E ARMAZENA NA VARIAVEL (R)
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Consulta alterada com sucesso!");
			//	limpar();
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível alterar");
			//	limpar();
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void pesquisarConsulta() {
		String read = "select * from tb_consulta where idConsulta =?";
		// Usamos o try catch para tratar exceção
		try {
			pst = (PreparedStatement) con.prepareStatement(read);
			// passagem do parâmetro
			pst.setString(1, txtId.getText());
			// atribuimos a variavel rs retorno do comando
			rs = pst.executeQuery();// Executar a query(sql)
			//
			if (rs.next()) {
				dtConsulta.setText(rs.getString(2));
				cboHorario.setSelectedItem(rs.getString(3));
				cboTipo.setSelectedItem(rs.getString(4));
				cboNome.setSelectedItem(rs.getString(5));
				txtPreco.setText(rs.getString(6));
				cboSituacao.setSelectedItem(rs.getString(7));

			} else {
				JOptionPane.showMessageDialog(null, "Consulta inexistente!");
			//	limpar();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do construtor
	
	
	//Delete
	private void removerConsulta() {
		// criar uma caixa de diálogo para confirmar a exclusão
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão desta consulta ?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			String delete = "delete from tb_consulta where idConsulta=?";

			try {
					pst = (PreparedStatement) con.prepareStatement(delete);
					pst.setString(1, txtId.getText());
					int r = pst.executeUpdate();
					if (r > 0) {
					//	limpar();
						JOptionPane.showMessageDialog(null, "Consulta deletada com sucesso!");
	
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel remover o consulta!");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} // fim do if

	}// fim do construtor
	
	
//METODO PESQUISAR CLIENTES PELO NOME COM FILTRO
	private void pesquisarPaciente() {
        String read = "select * from tb_clientes where nomeCli like ?";
        try {
            pst = (PreparedStatement) con.prepareStatement(read);
            //atenção ao "%" - continuação da String sql
            pst.setString(1, txtIdConsulta.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
			System.out.println(e);
		}
    }


public void setarCampos() {
	int setar = table.getSelectedRow();
	txtID.setText(table.getModel().getValueAt(setar, 1).toString());
	txtNome.setText(table.getModel().getValueAt(setar, 2).toString());
	txtCPF.setText(table.getModel().getValueAt(setar, 3).toString());
	txtFone.setText(table.getModel().getValueAt(setar, 4).toString());
	
	
	
	
}
}
	
	