package br.com.desktop.frames;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.log.SysoCounter;

import br.com.desktop.cep.CepWebService;
import br.com.desktop.dal.ConnectionModule;
import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Clientes extends JFrame {

	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;

	
	
	private JPanel contentPane;
	private JTextField txtPesquisar;
	private JTable tblClientes;
	private JTextField txtNome;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtFone1;
	private JTextField txtEmail;
	private JTextField txtFone2;
	private JTextField txtCep;
	private JTextField txtCpf;
	private JComboBox cboUf;
	private JTextField txtLogradouro;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/br/com/desktop/icons/paciente.png")));
		setResizable(false);
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 514);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				//KeyReleased
				pesquisarCliente();
			}
		});
		txtPesquisar.setBounds(22, 26, 229, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Clientes.class.getResource("/br/com/desktop/icons/pesquisar.png")));
		lblNewLabel.setBounds(261, 20, 32, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblCamposObrigatrio = new JLabel("* Campos obrigat\u00F3rios");
		lblCamposObrigatrio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCamposObrigatrio.setBounds(524, 29, 180, 14);
		contentPane.add(lblCamposObrigatrio);
		
		tblClientes = new JTable();
		tblClientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				setarCampos();
			}
		});
		tblClientes.setBounds(22, 66, 742, 112);
		contentPane.add(tblClientes);
		
		JLabel lblNome = new JLabel("* NOME");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setBounds(22, 214, 48, 14);
		contentPane.add(lblNome);
		
		JTextField txtNome = new JTextField();
		txtNome.setBounds(80, 211, 684, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEndereco = new JLabel("END:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setBounds(10, 306, 60, 14);
		contentPane.add(lblEndereco);
		
		JLabel lblComplemento = new JLabel("COMPLEMENTO:");
		lblComplemento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblComplemento.setBounds(573, 306, 118, 14);
		contentPane.add(lblComplemento);
		
		
		JLabel lblNumero = new JLabel("* N\u00DAMERO:");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setBounds(389, 306, 74, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(473, 303, 96, 20);
		contentPane.add(txtNumero);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(701, 303, 63, 20);
		contentPane.add(txtComplemento);
		
		JLabel lblBairro = new JLabel("* BAIRRO:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setBounds(-4, 336, 74, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("* CIDADE:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setBounds(378, 336, 59, 14);
		contentPane.add(lblCidade);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(80, 334, 299, 20);
		contentPane.add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(447, 333, 180, 20);
		contentPane.add(txtCidade);
		
		JLabel lblUf = new JLabel("* UF:");
		lblUf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUf.setBounds(637, 336, 48, 14);
		contentPane.add(lblUf);
		
		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		cboUf.setBounds(695, 334, 69, 22);
		contentPane.add(cboUf);
		
		JLabel lblFone1 = new JLabel("* FONE 1:");
		lblFone1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFone1.setBounds(6, 368, 64, 14);
		contentPane.add(lblFone1);
		
		JLabel lblFone2 = new JLabel("FONE 2:");
		lblFone2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFone2.setBounds(229, 368, 48, 14);
		contentPane.add(lblFone2);
		
		txtFone1 = new JTextField();
		txtFone1.setColumns(10);
		txtFone1.setBounds(80, 365, 139, 20);
		contentPane.add(txtFone1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(509, 364, 255, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtFone2 = new JTextField();
		txtFone2.setColumns(10);
		txtFone2.setBounds(287, 365, 139, 20);
		contentPane.add(txtFone2);
		
		JLabel lblEmail = new JLabel("* E-MAIL:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(436, 368, 63, 14);
		contentPane.add(lblEmail);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarCliente();
			
			}
			
		});
		btnAdicionar.setIcon(new ImageIcon(Clientes.class.getResource("/br/com/desktop/icons/create.png")));
		btnAdicionar.setBounds(271, 396, 64, 64);
		contentPane.add(btnAdicionar);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(Clientes.class.getResource("/br/com/desktop/icons/update.png")));
		btnAlterar.setBounds(362, 396, 64, 64);
		contentPane.add(btnAlterar);
		
		JButton btnApagar = new JButton("");
		btnApagar.setIcon(new ImageIcon(Clientes.class.getResource("/br/com/desktop/icons/delete.png")));
		btnApagar.setBounds(447, 395, 64, 64);
		contentPane.add(btnApagar);
		
		JButton btnBuscaCep = new JButton("Buscar CEP");
		btnBuscaCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buscaCep();
			}
		});
		btnBuscaCep.setBounds(648, 242, 116, 23);
		contentPane.add(btnBuscaCep);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(488, 242, 139, 20);
		contentPane.add(txtCep);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setBounds(412, 242, 48, 14);
		contentPane.add(lblCep);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(80, 242, 171, 20);
		contentPane.add(txtCpf);
		
		JLabel lblCpf = new JLabel("* CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setBounds(22, 245, 48, 14);
		contentPane.add(lblCpf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 66, 742, 112);
		contentPane.add(scrollPane);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(80, 303, 171, 20);
		contentPane.add(txtLogradouro);
	}//fim construtor
	
	//CEP Automático
	
	private void buscaCep() {
		
		try {
			String cep = txtCep.getText();
			CepWebService cepWebService = new CepWebService(cep);
			if (cepWebService.getResultado() == 1) {
				txtLogradouro.setText(cepWebService.getTipo_logradouro() + " " + cepWebService.getLogradouro());
				txtBairro.setText(cepWebService.getBairro());
				txtCidade.setText(cepWebService.getCidade());
				cboUf.setSelectedItem(cepWebService.getUf());
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possível obter o CEP");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	private void adicionarCliente () {
		
		String create = "insert into tb_clientes (idCli, nomeCli, cep, logradouro, numero, complemento, bairro, cidade, uf, fone1, fone2, cpfCli, emailCli) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			
			pst = con.prepareStatement(create);
			//passagem de parametros
			pst.setString(1, txtPesquisar.getText());
			pst.setString(2, txtNome.getText());
			pst.setString(3, txtCep.getText());
			pst.setString(4, txtLogradouro.getText());
			pst.setString(5, txtNumero.getText());
			pst.setString(6, txtComplemento.getText());
			pst.setString(7, txtBairro.getText());
			pst.setString(8, txtCidade.getText());
			pst.setString(9, cboUf.getSelectedItem().toString());
			pst.setString(10, txtFone1.getSelectedText());
			pst.setString(11, txtFone2.getText());
			pst.setString(12, txtCpf.getText());
			pst.setString(13, txtEmail.getText());
			
			int r = pst.executeUpdate();
			if(r > 0) {
				
				JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
				//limpar();				
			} else {
				JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	//METODO PESQUISAR CLIENTES PELO NOME COM FILTRO
	private void pesquisarCliente() {
        String read = "select * from tb_clientes where nomeCli like ?";
        try {
            pst = (PreparedStatement) con.prepareStatement(read);
            //atenção ao "%" - continuação da String sql
            pst.setString(1, txtPesquisar.getText() + "%");
            rs = pst.executeQuery();
            // a linha abaixo usa a biblioteca rs2xml.jar para preencher a tabela
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
			System.out.println(e);
		}
    }
	
	//METODO PARA SETAR OS CAMPOS DO FORMULARIO COM O CONTEUDO
	public void setarCampos() {
		int setar = tblClientes.getSelectedRow();
		//txtNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
		//txtCep.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
		//txtLogradouro.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
		//txtNumero.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
		//txtComplemento.setText(tblClientes.getModel().getValueAt(setar, 5).toString());
		//txtBairro.setText(tblClientes.getModel().getValueAt(setar, 6).toString());
		//txtCidade.setText(tblClientes.getModel().getValueAt(setar, 7).toString());
		//cboUf.setSelectedItem(tblClientes.getModel().getValueAt(setar, 8).toString());
		//txtFone1.setText(tblClientes.getModel().getValueAt(setar, 9).toString());
		//txtFone2.setText(tblClientes.getModel().getValueAt(setar, 10).toString());
		//txtCpf.setText(tblClientes.getModel().getValueAt(setar, 11).toString());
		//txtEmail.setText(tblClientes.getModel().getValueAt(setar, 12).toString());
		
		
		
	}
}
		//LIMPAR
		
//		private void limpar() {
//
//			
//			txtNome.setText(null);
//			txtCpf.setText(null);
//			txtEmail.setText(null);
//			txtCep.setText(null);
//			txtEndereco.setText(null);
//			txtNumero.setText(null);
//			txtComplemento.setText(null);
//			txtBairro.setText(null);
//			txtCidade.setText(null);
//			cboUf.setSelectedItem(null);
//			txtFone1.setText(null);
//			txtFone2.setText(null);
//		}
	
			
