/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.chr.ai.engine;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author javanism
 */
public class VoiceOrders {

     public static String process(String voiceMessage) {

        String chatbotMessage = "";

        try {
            String apiURL = "https://4da38256ef3641eca80ac8cbba660e47.apigw.ntruss.com/custom/v1/4330/ed5a9dfd09f5ee7e00875d2ce38dcf905a9ef9a5b0f884f8624c526400808342";

            URL url = new URL(apiURL);

           // String voiceMessage="문 열어요?";
            String message = getReqMessage(voiceMessage);
            System.out.println("##" + message);

            String secretKey="TlNLTFNqQ0FtaHhFYkZrWXBvZ3F3cnBSY2VSWkFpbWk=";
            String encodeBase64String = makeSignature(message, secretKey);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;UTF-8");
            con.setRequestProperty("X-NCP-CHATBOT_SIGNATURE", encodeBase64String);

            // post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(message.getBytes("UTF-8"));
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();

            BufferedReader br;

            if(responseCode==200) { // Normal call
                System.out.println(con.getResponseMessage());

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                con.getInputStream(),"UTF-8"));
                String decodedString;
                //return 되어온 챗봇 메세지 읽기
                while ((decodedString = in.readLine()) != null) {
                    chatbotMessage = decodedString;
                }
                //chatbotMessage = decodedString;
                in.close();

            } else {  // Error occurred
                chatbotMessage = con.getResponseMessage();
            }
            //System.out.println("하이");
            
            System.out.println(chatbotMessage); //JSON 형식
            //JSON parsing
            JSONObject o = new JSONObject(chatbotMessage); //String을 JSONObject 형식으로 바꿈
            JSONArray bubbles = o.getJSONArray("bubbles");
            JSONObject bubbles0 = bubbles.getJSONObject(0);
            JSONObject data = bubbles0.getJSONObject("data");
            String description = (String) data.get("description");
            System.out.println("챗봇---->"+description);
            
            return description;
        } catch (Exception e) {
            System.out.println(e);
            
            return "죄송합니다. 다시 말씀해주세요.";
        }

        //return chatbotMessage;
    }

    public static String makeSignature(String message, String secretKey) {

        String encodeBase64String = "";

        try {
            byte[] secrete_key_bytes = secretKey.getBytes("UTF-8");

            SecretKeySpec signingKey = new SecretKeySpec(secrete_key_bytes, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            encodeBase64String = Base64.encodeToString(rawHmac, Base64.NO_WRAP);

            return encodeBase64String;

        } catch (Exception e){
            System.out.println(e);
        }

        return encodeBase64String;

    }

    public static String getReqMessage(String voiceMessage) {

        String requestBody = "";

        try {

            JSONObject obj = new JSONObject();

            long timestamp = new Date().getTime();

            System.out.println("##"+timestamp);

            obj.put("version", "v2");
            obj.put("userId", "U47b00b58c90f8e47428af8b7bddc1231heo2chr");
//=> userId is a unique code for each chat user, not a fixed value, recommend use UUID. use different id for each user could help you to split chat history for users.

            obj.put("timestamp", timestamp);

            JSONObject bubbles_obj = new JSONObject();

            bubbles_obj.put("type", "text");

            JSONObject data_obj = new JSONObject();
            data_obj.put("description", voiceMessage);

            bubbles_obj.put("type", "text");
            bubbles_obj.put("data", data_obj);

            JSONArray bubbles_array = new JSONArray();
            bubbles_array.put(bubbles_obj);

            obj.put("bubbles", bubbles_array);
            obj.put("event", "send");

            requestBody = obj.toString();

        } catch (Exception e){
            System.out.println("## Exception : " + e);
        }

        return requestBody;

    }
    

}
