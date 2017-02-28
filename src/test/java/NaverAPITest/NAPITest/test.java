package NaverAPITest.NAPITest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Before;
import org.junit.Test;

public class test {

	@Before
	public void apiTest() {
		 baseURI = "http://openapi.naver.com";
//		baseURI = "http://maps.googleapis.com";
		port = 80;
	}

	@Test
	public void test() {
		try {
			String text = URLEncoder.encode("최순실", "UTF-8");
			given().
			 params( //URL 주소의 파라미터 값을 넣어줌
			 "query",text,
			 "key","wRA7VbWi9bfyoszVUBF0",
			 "sort","sim",
			 "display","10",
			 "start","1"		 
			 ).when().
			
			 /*baseURL 을 제외한 뒷부분 주소를 get하고
			 *body에서 해당 title 내용을 가져올 위치 지정 후
			 *확인할 값을 equalTo에 넣어 확인*/
			 get("/v1/search/news").then().toString();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
