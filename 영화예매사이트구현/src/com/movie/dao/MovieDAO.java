package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.movie.vo.MovieVO;

//DAO는 매번호출될때마다 객체가 생성되는 것이 아닌 한번 만들어두면 계속 가져다 불러쓸 수 있는 싱글톤으로 만듦
public class MovieDAO {
	//생성자는 프라이빗으로 (싱글톤의 생성자를 프라이빗으로 한다고해서 안에가 꼭 비워져 있어야 하는 것은 아님)
	private MovieDAO () {
	}

								private static MovieDAO instance = new MovieDAO();
	//싱글톤은 객체 생성을 자기 자신 밖에 못하기 때문에 클래스 내부에서 객체 생성하는  코드↑가 필요하고
	
	// ↓ 외부에서 만드는 것이 아닌 외부에서 불러올 수 있게끔 하는 메서드를 만듦. 
	public static MovieDAO getInstance() {
									return instance;
				}
								
	//   그래서 그것을  getInstance로 만들어서 사용을 해왔음 
	//   메서드를 호출 하면 위에서 생성한[MovieDAO instance = new MovieDAO();]를 호출 
	
	
	
	// 메서드 구현할 때 -> 1.접근제한자 2.리턴타입 3.메서드이름(4.매개변수) {5.이 메서드가 구현할 코드들 } 이런식으로 메서드를 만듦
    // 
	// 1.접근 제한자 public은 어디서든 불러올 수 있게 
	// 
	// 2.리턴 타입 List -> List를 쓰는 이유? DB테이블에 있는 모든 레코드들을 다 뽑아와서 JSP로 보내려고 함 
	// DB에 있는 데이터를 뽑아와서 호출한 곳으로 리턴(되돌려줘야)해야하는데 그럴려면 우선 DB테이블에  들어있는 모든 것들을 저장할 수 있는 객체가 필요함
	// 레코드 한줄(EX.1 아바타-물의길 12000 제임스카메론 ..)은 VO에 담을 수 있긴함 
	// 그러나 데이터 한줄을 담는게 아닌 테이블에 있는 모든 레코드를 담아야하기 때문에(상황에 따라서 늘릴 수도 줄일 수도 있는) 
	// 레코드 한줄에 있는 데이터를 담을 수 있는 VO 1개가 아닌 여러개의 VO를 담을 수 있는 것을 만들고 그것을 통으로 리턴해줘야함 
	// 이 상황에서 VO를 담기위해 제일 적절한 것이 List. List는 순서도 있고 크기 설정안해도 되며 알아서 늘리거나 줄이거나 할 수 있어서 list타입 택함
	// 2.1 List<> 제네릭 = list에 어떤 타입으로 담을 지를 지정해줌, MovieVO에서 다 지정해준 것(만들어놓은것) 그걸로 타입을 지정해야함 그래서 
	// 제네릭 안에  MovieVO를 넣고 -> List<MovieVO>  이와 같은 형태로 만들어줌
	// 3. listAll -> 그냥 메서드 이름임 아무거나 설정해도 되지만(심지어 내이름으로 해도됨) 리스트를 전부 가져와준다는 의미로 listAll을 사용 
	// 4. (매개변수) 지금 상황에서는 메서드가 필요없다.
	//  왜냐하면 listAll 이라는 메서드를 호출하면 알아서 db테이블에 있는 모든 정보를 조회해서 리턴시키기때문에 추가적으로 필요한 값이 없음.
	public List<MovieVO> listAll(){
		
		Connection conn = null; // 데이터베이스와 연결
		PreparedStatement pstmt =null; // sql문 심어주어야함
		ResultSet rs = null; // sql문에서 select로 조회된 결과값(레코드들)을 담기 위해
		
		String sql = "select * from movie"; 
		
		
	}
	
}








