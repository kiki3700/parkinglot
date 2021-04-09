import java.sql.*;

public class Database {
    static Connection conn = null;
    
    //연결하는 메서드
	public static int connect() {
		int result = 1;
		 // Connection 객체를 자동완성으로 import할 때는 com.mysql.connection이 아닌
       // java 표준인 java.sql.Connection 클래스를 import해야 한다.

       try{
           // 1. 드라이버 로딩
           // 드라이버 인터페이스를 구현한 클래스를 로딩
           // mysql, oracle 등 각 벤더사 마다 클래스 이름이 다르다.
           // mysql은 "com.mysql.jdbc.Driver"이며, 이는 외우는 것이 아니라 구글링하면 된다.
           // 참고로 이전에 연동했던 jar 파일을 보면 com.mysql.jdbc 패키지에 Driver 라는 클래스가 있다.
           Class.forName("com.mysql.jdbc.Driver");

           // 2. 연결하기
           // 드라이버 매니저에게 Connection 객체를 달라고 요청한다.
           // Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
           // mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.
           String url = "jdbc:mysql://localhost/parkinglotDb";

           // @param  getConnection(url, userName, password);
           // @return Connection
          
           conn = DriverManager.getConnection(url, "lee", "kiki3700");
           System.out.println("연결 성공");
//           String SQL="SELECT * FROM member WHERE id = '"+id+"'";
//           PreparedStatement pstmt = conn.prepareStatement(SQL);
//           System.out.println("성공?");
//           rs = pstmt.executeQuery(SQL);
//           System.out.println("성공!");
//           rs.next();
//           String foundType = rs.getString(1);
//           System.out.println(foundType);
//           System.out.println(pw);
//           if(foundType.equals(pw)) {
//           	loginStatus="true";}else {
//           		loginStatus="pass word is wrong";
//           	}
           
       }
       catch(ClassNotFoundException e){
           System.out.println("드라이버 로딩 실패");
           result =-1;
       } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		result =-1;
	}
       return result;
	}
//디스 커넥트
	public static int disconnect() {
	int result =1;
    try{
        if( conn != null && !conn.isClosed()){
            conn.close();
        }
    }
    catch( SQLException e){
        e.printStackTrace();
        result=-1;
    }
	return result;
}
//쿼리 날리기
	public static String selectQuery(String tableName, String car_number)  {

	connect();
	Statement stmt = null;
	ResultSet rs = null;
	String queryResult="";
	String SQL = "SELECT * FROM "+tableName+" WHERE car_number = "+car_number;
	System.out.println(SQL);
	try {
	
	stmt = conn.createStatement();
	rs = stmt.executeQuery(SQL);
	if(rs.next()) {
	ResultSetMetaData rsmd = rs.getMetaData();
	System.out.println(rsmd.getColumnCount());
	System.out.println(rsmd.getColumnName(1));
	for(int i=1; i< rsmd.getColumnCount()+1;i++) {
		System.out.println(i);
		queryResult+=rsmd.getColumnName(i)+"="+rs.getString(i);
		if(i!=rsmd.getColumnCount())
			queryResult+=",";
		}
	}
	System.out.println(queryResult);
	}catch(Exception e) {
		e.printStackTrace();

	}
	disconnect();
	
	
	return queryResult;
}
	//쿼리 날리기
		public static String selectLastQuery(String tableName, String car_number)  {

		connect();
		Statement stmt = null;
		ResultSet rs = null;
		String queryResult="";
		String SQL = "SELECT * FROM "+tableName+" WHERE car_number = "+car_number+" ORDER BY id LIMIT 1";
		try {
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SQL);
		if(rs.next()) {
		ResultSetMetaData rsmd = rs.getMetaData();
		for(int i=1; i< rsmd.getColumnCount()+1;i++) {
			queryResult+=rsmd.getColumnName(i)+"="+rs.getString(i);
			if(i!=rsmd.getColumnCount())
				queryResult+=",";
			}
		}
		}catch(Exception e) {
			e.printStackTrace();

		}
		disconnect();
		
		
		return queryResult;
	}

// 새로운 차 정보 입력
	public static int newCarInfo(String car_number,String car_size) {
		int result=connect();
		
		String SQL= "INSERT INTO car_informations(car_number, car_size) values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, car_number);
			pstmt.setString(2, car_size);
			int r =pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=-1;
		}
		disconnect();
		return result;	
	}
	// 입차정보 입력
		public static int insertEnterCar(String enter_time,String car_number) {
			int result=connect();
			
			String SQL= "INSERT INTO enter_logs(enter_time, car_number) values(?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, enter_time);
				pstmt.setString(2, car_number);
				int r =pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=-1;
			}
			disconnect();
			return result;	
		}
		

		// 결제정보 입력
		public static int insertPaymentlog(int amount, int discount_amount, int final_price,String settlement_tool, String car_number) {
			int result=connect();
			
			String SQL= "INSERT INTO payment_logs(amount, discount_amount,final_price, settlement_tool,car_number) values(?,?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, amount);
				pstmt.setInt(2, discount_amount);
				pstmt.setInt(3, final_price);
				pstmt.setString(4, settlement_tool);
				pstmt.setString(5, car_number);
				int r =pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result=-1;
			}
			disconnect();
			return result;	
		}
		
		//출차 이력 갱신
		public static int updateExitcar(String exit_time, String car_number) {
			int result= connect();
			PreparedStatement pstmt=null;
			String SQL = "UPDATE enter_logs SET exit_time = ?  WHERE car_number = ? ORDER BY id DESC LIMIT 1 ";
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, exit_time);
				pstmt.setString(2, car_number);
				int r = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = -1;
						}
			return result;
		}
		//티켓 구매
		public static int updateTicketInfo(String sort_of_ticket, String begin_of_ticket, String end_of_ticket, String car_number) {
			int result= connect();
			PreparedStatement pstmt=null;
			String SQL = "UPDATE car_informations SET sort_of_ticket = ?,begin_of_ticket=?,  end_of_ticket=?  WHERE car_number = ?";
			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, sort_of_ticket);
				pstmt.setString(2, begin_of_ticket);
				pstmt.setString(3, end_of_ticket);
				pstmt.setString(4, car_number);
				int r = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = -1;
						}
			return result;
		}
		
	//출차정보 조회
		public static String selectEnterTime(String car_number) {

			connect();
			Statement stmt = null;
			ResultSet rs = null;
			String queryResult="";
			String SQL = "SELECT enter_time FROM enter_logs WHERE car_number = "+car_number+" ORDER BY id DESC LIMIT 1";
			String enter_time=null;
			try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			rs.next();
			enter_time=rs.getString(1);
			}catch(Exception e) {
				e.printStackTrace();

			}
			disconnect();
			
			
			return enter_time;
			
		}
}




