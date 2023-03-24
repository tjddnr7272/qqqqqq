package ezen.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

@WebServlet("/albums")
public class ProxyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Java Servlet에서 HTTP 요청 및 응답을 처리하는 부분
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 서블릿에서 Open API 사용하는 부분임   ///asdasdasd
//		URL url = new URL("https://jsonplaceholder.typicode.com/albums");
		URL url = new URL("https://yts.torrentbay.to/api/v2/list_movies.json");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		
		//서블릿에서 Open API로부터의 응답을 처리하는 부분
			BufferedReader in = null;
			StringBuilder sb = new StringBuilder();		
		int status = connection.getResponseCode();
		String text = null;
		if(status >= 300) {
			in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			// null이 아닐경우 읽는다
			while((text=in.readLine()) != null) {
				sb.append(text);				
			}			
		}else {
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((text=in.readLine()) != null) {
				sb.append(text);				
			}
		}
		in.close();
//		System.out.println(sb.toString());
		out.print(sb.toString());
	}
}


