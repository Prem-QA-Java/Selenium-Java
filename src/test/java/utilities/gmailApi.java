package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;

public class gmailApi {
	
	private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String user = "me";
	static Gmail service = null;
	private static final File path = new File(System.getProperty("user.dir")+"/credentials.json");
	
	public static void getGmailService() throws IOException, GeneralSecurityException {
		InputStream in = new FileInputStream(path); //To read the credentials.json file
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
		
		new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
		.setJsonFactory(JSON_FACTORY)
		.setClientSecrets(clientSecrets.getDetails().getClientId().toString(), clientSecrets.getDetails().getClientSecret().toString());
		//Credentials Builder
//		new GoogleCredential().getRefreshToken();
//		new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
//		.setJsonFactory(JSON_FACTORY)
//		.setClientSecrets(clientSecrets.getDetails().getClientId().toString()), clientSecrets.getDetails().getClientSecret().toString())
//		.build().setAccessToken("").setRefreshToken("1//0gp-zbPzHlv3rCgYIARAAGBASNwF-L9Ir6oK10mbPe8s4nCQIC_eVaJfVwOR4sf2GKoXQH0CGYDtd7Vg5ydgVwwllirOv6_AZovI");
//		return "";
	}
	
//	private static String getAccessToken() {

//		try {
//			Map<String, Object> params = new LinkedHashMap<>();
//			params.put("grant_type", "refresh_token");
//			params.put("client_id", "YOUR_CLIENT_ID"); //Replace this
//			params.put("client_secret", "YOUR_CLIENT_SECRET"); //Replace this
//			params.put("refresh_token",
//					"YOUR_REFRESH_TOKEN"); //Replace this
//
//			StringBuilder postData = new StringBuilder();
//			for (Map.Entry<String, Object> param : params.entrySet()) {
//				if (postData.length() != 0) {
//					postData.append('&');
//				}
//				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//				postData.append('=');
//				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//			}
//			byte[] postDataBytes = postData.toString().getBytes("UTF-8");
//
//			URL url = new URL("https://accounts.google.com/o/oauth2/token");
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setDoOutput(true);
//			con.setUseCaches(false);
//			con.setRequestMethod("POST");
//			con.getOutputStream().write(postDataBytes);
//
//			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			StringBuffer buffer = new StringBuffer();
//			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
//				buffer.append(line);
//			}
//
//			JSONObject json = new JSONObject(buffer.toString());
//			String accessToken = json.getString("access_token");
//			return accessToken;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return null;
//	}

}
