import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class NewsDAO{
	/*
	private int newsID;
	private String groupID;
	private String subject;
	private String content;
	*/
	
	final private static String dbname = "sbprtest"; // データベース名
	final private static String user = "wspuser"; // アクセスできるユーザ
	final private static String password = "hogehoge"; // wspuserのパスワード
	final private static String driverClassName = "org.postgresql.Driver";
	final private static String url = "jdbc:postgresql://localhost/" + dbname;

	
	public void findByGroupID(String groupID){
		boolean result = false;
		Connection connection = null;
		String sql = "select * from news where groupID=?";
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, accountID);

			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				result = true;
			}
			resultSet.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//クローズ処理
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}
	public void createNews(String groupID,String subject, String content){
	//newsIDは自動で振る	
	Connection connection = null;
		String maxsql = "select max(news id) from news";
		String sql = "insert into account values(?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, user, password);
			//現在のテーブルからnewsIDの最大値を取り出す
			pstmt = connection.prepareStatement(maxsql);
			ResultSet rs = pstmt.executeQuery();
			int curNewsID = rs.getInt("newsid");
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, curNewsID+1);		
			pstmt.setString(2, groupID);
			pstmt.setString(3, subject);
			pstmt.setString(4, password);

			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//クローズ処理
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}