package api;

import java.io.IOException;

public class PostMethod {
	
	public static void main(String[] args) {
		
		try {
			BaseClass.postMethod("https://reqres.in/api/users");
			BaseClass.getResponseBody("https://reqres.in/api/users");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
