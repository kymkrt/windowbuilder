package t23_Hoewon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

//우리가 만드는 메소드가 올라온다
//ex 전체리스트, 개별조회, 수정 등등
@SuppressWarnings({"rawtypes","unchecked"}) //괄호로 여러개를 넣을수 있다
//@SuppressWarnings("unchecked")
public class HoewonDAO extends DBConn{
	
	HoewonVO vo =null; //사용할때만 생성
	String sql = "";
	
	//회원전체조회
	//vo라는 객체에 모든 변수를 담아서 객체를 던지는것
	//한개면 vo 여러개면 vos 레코드 한덩어리가 vo
	//스윙에서는 어레이 리스트 사용안함 벡터 써야함 fx는 다쓸수 있다
	//옛날 벡터에는 제네릭도 없었음
	public Vector getHoewonList() {//리스트 없으면 하나 하나 다 .으로 넣어줘야함
		Vector vData = new Vector();
		//데이터 베이스는 전부 예외처리
		try {
			sql = "select * from hoewon";
			//sql을 pstmt가 보내줘야 하는데 pstmt는 커넥션으로 생성된다 그래서 DBconn객체를 가져와서 쓴다 상속해서 씀
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();//셀레트 문장에서 가져오는 레코드를 rs가 받는다
			
			//자료가 얼마나 있는지 모르기 때문에 while
			while(rs.next()) {//한칸 내림
				//하위타입을 안줬기 때문에 다 벡터로 줘야함
//				vo = new HoewonVO(); 원래는 이렇게임 
				Vector vo = new Vector();//타입을 준다
				vo.add(rs.getInt("idx")); //하나하나 가져온걸 타입맞춰서 넣어준다
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("joinday"));
				vo.add(rs.getString("address"));
				
				vData.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql 오류 "+e.getMessage());
		}finally {
			rsClose();//왜 닫지?
		}
		return vData;
	}
	
	//회원 가입 처리
	public int setHoewonInput(HoewonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoewon values (default,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getJoinday());
			pstmt.setString(5, vo.getAddress());
			res = pstmt.executeUpdate();//쿼리는셀렉트 업데이트는 그냥 보내기만
		} catch (SQLException e) {
			System.out.println("sql 오류 "+e.getMessage());
		}finally {
			pstmtClose();//인서트라 리설트셋이 필요없다
		}
		
		return res;
	}
	//회원 가입일 오름차순/내림차순 정렬
	public Vector getHoewonAlign(String str, String order) {//str이라고 한이유는 여길 콤보상자로 해서 원하는 조건을 골라서 정렬할수 있도록 확장성 생각
		Vector vData = new Vector();
		try {
			if(order.equals("a")) {
			sql = "select * from hoewon order by joinday";
			}else {
			sql = "select * from hoewon order by joinday desc";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();//셀레트 문장에서 가져오는 레코드를 rs가 받는다
			
			while(rs.next()) {//한칸 내림 꺼내서
				Vector vo = new Vector();//타입을 준다
				vo.add(rs.getInt("idx")); //하나하나 가져온걸 타입맞춰서 넣어준다
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("joinday"));
				vo.add(rs.getString("address"));
				
				vData.add(vo);//담고
			}
		} catch (SQLException e) {
			System.out.println("sql 오류 "+e.getMessage());
		}finally {
			rsClose();//왜 닫지?
		}
		return vData;//리턴
	}
	//조건검색처리
	public Vector getConditionSearch(String str, String txtCondi) {
		Vector vData = new Vector();
		try {
			sql = "select * from hoewon where "+str+" like ? order by name";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();//셀레트 문장에서 가져오는 레코드를 rs가 받는다
			
			while(rs.next()) {//한칸 내림 꺼내서
				Vector vo = new Vector();//타입을 준다
				vo.add(rs.getInt("idx")); //하나하나 가져온걸 타입맞춰서 넣어준다
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("joinday").substring(0, 10));
				vo.add(rs.getString("address"));
				
				vData.add(vo);//담고
			}
		} catch (SQLException e) {
			System.out.println("sql 오류 "+e.getMessage());
		}finally {
			rsClose();//왜 닫지?
		}
		return vData;//리턴
	}
}
