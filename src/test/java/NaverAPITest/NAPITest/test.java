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
			  header("X-Naver-Client-Id", "wRA7VbWi9bfyoszVUBF0").
			  header("X-Naver-Client-Secret","gyuAOlFhfB").
			 params( //URL 주소의 파라미터 값을 넣어줌
			 "query",text	 
			 ).when().
			
			 /*baseURL 을 제외한 뒷부분 주소를 get하고
			 *body에서 해당 title 내용을 가져올 위치 지정 후
			 *확인할 값을 equalTo에 넣어 확인*/
			 get("/v1/search/news.xml").then().body("rss.channel.title", equalTo("Naver Open API - news ::'최순실'"));
//			 get("/v1/search/news.xml").then().toString();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
