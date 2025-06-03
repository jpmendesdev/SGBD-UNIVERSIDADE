package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.Utilitarios;

public class Conexao {
	 private static Connection conn;
	 
	 public static Connection getConexao() {
		 
		 try {
			 if (conn == null) {
				 Utilitarios util = new Utilitarios();
				 conn = DriverManager.getConnection(util.getUrl() ,util.getUser(),util.getPassword());
				 return conn;
			 } else {
				 return conn;
			 }
		 }catch (SQLException e) {
			 e.printStackTrace();
			 return null;
		 }
	 }
}
