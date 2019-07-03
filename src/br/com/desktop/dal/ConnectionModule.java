package br.com.desktop.dal;

import java.sql.DriverManager;
import java.sql.*;

public class ConnectionModule {

	// a classe abaixo cria um m�todo de conex�o com retorno
	public static Connection conector() {
		
		//Criando uma variavel para receber a conex�o
		java.sql.Connection conexao = null;
		String driver = "com.mysql.jdbc.Driver";
		
		// vari�vel que recebe as informa��es do banco. Caminho, banco, ssl
		String url = "jdbc:mysql://10.26.45.103:3306/db_clinica?useSSL=false";
		
		//autentica��o
		String user = "admin";
		String password = "123@Senac";
		
		//tratamento de exce��es
		try {
			Class.forName(driver);//usar o driver
			conexao = DriverManager.getConnection(url, user, password);
			return conexao;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}