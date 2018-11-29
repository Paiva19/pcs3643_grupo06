package testes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Auxiliar {
	private String server_endpoint = "http://localhost:8080/PoC-MVC";
	
	public String getHttp(String url) {
		try {
			URL server = new URL(url);
			URLConnection con = server.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			StringBuilder response = new StringBuilder();
			
			String line;
		    while ((line = in.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
			
			in.close();
			return response.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String postHttp(String url, String urlParameters) {
		try {
			URL server = new URL(url);
			HttpURLConnection con = (HttpURLConnection) server.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", 
		        "application/x-www-form-urlencoded");

			con.setRequestProperty("Content-Length", 
		        Integer.toString(urlParameters.getBytes().length));
			con.setRequestProperty("Content-Language", "en-US");  

			con.setUseCaches(false);
			con.setDoOutput(true);

		    //Send request
		    DataOutputStream wr = new DataOutputStream (
		    		con.getOutputStream());
		    wr.writeBytes(urlParameters);
		    wr.close();
		    
		    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
			StringBuilder response = new StringBuilder();
			
			String line;
		    while ((line = in.readLine()) != null) {
		      response.append(line);
		      response.append('\r');
		    }
			
			in.close();
			return response.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String formatUrl(String path) {
		return this.server_endpoint + path;
	}
}
