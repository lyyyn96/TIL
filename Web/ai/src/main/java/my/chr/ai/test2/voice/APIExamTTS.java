package my.chr.ai.test2.voice;

//네이버 음성합성 Open API 예제
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

/**
* 1. maven project 아니어도 됨
* 2. 제공받은 String clientId 와 clientSecret 값을 넣고 바로 실행한뒤 이 프로젝트를 리프레쉬하면 임의숫자.mp3가 보임
* 3. 이 파일을 오디오 플레이어로 실행해 보면 '만나서 반갑습니다'라고 나옴
* 4. 더 긴 텍스트를 읽어서 처리하도록 응용하기
* @author javan_000
*
*/
public class APIExamTTS {

public static void main(String[] args) {
   String clientId = "uf4hxtdqdo";//애플리케이션 클라이언트 아이디값";
   String clientSecret = "6G2Fc8paabdrpObsRzU6ZNRa3M5mIwWOowDYkiie";//애플리케이션 클라이언트 시크릿값";
	   try {
	  	 String longText=URLEncoder.encode(" * 1. maven project 아니어도 됨\r\n" + 
	  	 		" * 2. 제공받은      String clientId 와 clientSecret 값을 넣고 바로 실행한뒤 이 프로젝트를 리프레쉬하면 임의숫자.mp3가 보임\r\n" + 
	  	 		" * 3. 이 파일을 오디오 플레이어로 실행해 보면 '만나서 반갑습니다'라고 나옴\r\n" + 
	  	 		" * 4. 더 긴 텍스트를 읽어서 처리하도록 응용하기", "UTF-8");
	       String text = URLEncoder.encode("만나서 반갑습니다. 최혜린님, 오늘 벚꽃 구경 가시죠.", "UTF-8"); // 13자
	       String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
	       URL url = new URL(apiURL); //연동하고자 하는 url 넣기
	       HttpURLConnection con = (HttpURLConnection)url.openConnection(); //연결 객체 생성
	       con.setRequestMethod("POST"); //GET이나 POST방식으로 요청
	       con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId); //request header
	       con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret); //request header
	       // post request
	       String postParams = "speaker=nsinu&volume=0&speed=0&pitch=0&format=mp3&text=" + longText; //request message body(여기에 들어가는 것이 parameter)
	       con.setDoOutput(true);
	       DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	       wr.writeBytes(postParams);
	       wr.flush();
	       wr.close();
	       int responseCode = con.getResponseCode();
	       BufferedReader br;
	       if(responseCode==200) { // 정상 호출
	           InputStream is = con.getInputStream();
	           int read = 0;
	           byte[] bytes = new byte[1024];
	           // 랜덤한 이름으로 mp3 파일 생성
	           String tempname = Long.valueOf(new Date().getTime()).toString();
	           File f = new File(tempname + ".mp3");
	           f.createNewFile();
	           OutputStream outputStream = new FileOutputStream(f);
	           while ((read =is.read(bytes)) != -1) {
	               outputStream.write(bytes, 0, read);
	           }
	           is.close();
	       } else {  // 오류 발생
	           br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	           String inputLine;
	           StringBuffer response = new StringBuffer();
	           while ((inputLine = br.readLine()) != null) {
	               response.append(inputLine);
	           }
	           br.close();
	           System.out.println(response.toString());
	       }
	   } catch (Exception e) {
	       System.out.println(e);
	   }
	}
}