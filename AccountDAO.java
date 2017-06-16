import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;

public class AccountDAO{
	private Account target;
	/*
	private String accountID; 
	private String groupID;
	private String pass;
	private String username;
	private int role; 1=メンバー　2=副代表　 3=代表
	groupIDとroleはどこで設定する？
	*/
	
	// DBに接続・検索
	// Accountテーブルの内容にアクセス
	// 内容：アカウントID・パスワード・氏名(ユーザー名)
	static String driverClassName, url, user, password;
	static Connection connection;
	//プロパティファイルの準備
	Properties props = getProperties("db.properties");
	driverClassName = props.getProperty("driverClassName");
	url = props.getProperty("url");
	user = props.getProperty("user");
	password = props.getProperty("password");
		
	
    	
	
	public Account findByAccountID(String accountID){
		//PreparedStatementの準備
		PreparedStatement p_select;
		String prepSQL_S = "SELECT * FROM account WHERE accountID = ?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			//?に変数を代入
			p_select = connection.prepareStatement(prepSQL_S);
			p_select.setString(1, accountID);
			target = p_select.executeQuery();
			p_select.close();
			connection.close();
			return taget;
		} catch (Exception e){
			e.printStackTrace();
		}
	}	
	public void createAccount(String accountID, String pass, String username){
		PreparedStatement p_insert;
		String prepSQL_I = "INSERT INTO account VALUES(?, 'NULL', ?, ?, 1) ";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			//?に変数を代入
			p_insert = connection.prepareStatement(prepSQL_I);
			p_insert.setString(1, accountID);
			p_insert.setString(2, pass);
			p_insert.setString(3, password);
			p_insert.executeUpdate();
			p_insert.close();
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteAccount(String accountID){
		PreparedStatement p_delete;
		String prepSQL_D = "DELETE FROM account WHERE accountID = ?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			p_delete = connection.prepareStatement(prepSQL_D);
			p_delete.setString(1, accountID);
			p_delete.executeUpdate();
			p_delete.close();
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void changePass(String accountID, String newPass){
		PreparedStatement p_update;
		String prepSQL_U ="UPDATE account SET pass = ? WHERE accountID = ?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			p_update = connection.prepareStatement(prepSQL_U);
			p_update.setString(2, accountID);
			p_update.setString(1, newPass);	
			p_update.executeUpdate();
			p_update.close();
			connection.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static Properties getProperties(String filename) {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("Warning: " + filename + " is not found.");
		}
		return props;
	}
}