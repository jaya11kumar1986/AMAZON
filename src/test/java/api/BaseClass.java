package api;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseClass {
	static URL url;
	static HttpURLConnection connection;

	public static void baseSteps(String value) throws IOException {
		String path = value;
		url = new URL(path);
		connection = (HttpURLConnection) url.openConnection();
	}

	public static void getResponseValue(String value) throws IOException {
		BaseClass.baseSteps(value);

		connection.setRequestMethod("GET");
		int statuscode = connection.getResponseCode();
		System.out.println("StatusCode:" + statuscode);
	}

	public static void getResponseMessage(String value) throws IOException {
		BaseClass.baseSteps(value);

		connection.setRequestMethod("GET");
		String statusmessage = connection.getResponseMessage();
		System.out.println("StatusMessage:" + statusmessage);
	}

	public static void getResponseTime(String value) throws IOException {
		BaseClass.baseSteps(value);

		connection.setRequestMethod("GET");
		int responseTime = connection.getReadTimeout();
		System.out.println("ResponseTime:" + responseTime);
	}

	public static void getResponseBody(String value) throws IOException {
		BaseClass.baseSteps(value);

		connection.setRequestMethod("GET");
		InputStream inputStream = connection.getInputStream();
		InputStreamReader ist = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(ist);

		StringBuffer buffer = new StringBuffer();
		String line;

		FileWriter file = new FileWriter("./src/File/NewFile.txt");

		while ((line = reader.readLine()) != null) {

			buffer.append(line);
			buffer.append("\n");
			file.write(line + "\n");

		}
		file.close();

		System.out.println(buffer);

	}

	public static void postMethod(String value) throws IOException {

		baseSteps(value);

		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		String body = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"leader\"\r\n" + "}";

		byte[] jsonByte = body.getBytes();

		OutputStream outputStream = connection.getOutputStream();

		outputStream.write(jsonByte);

		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader ist = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(ist);

		StringBuffer buffer = new StringBuffer();
		String line;

		while ((line = reader.readLine()) != null) {

			buffer.append(line);
			buffer.append("\n");
		}

		System.out.println(buffer);

	}

	public static void putMethod(String value) throws IOException {

		baseSteps(value);

		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		String body = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"Senior leader\"\r\n" + "}";

		byte[] jsonByte = body.getBytes();

		OutputStream outputStream = connection.getOutputStream();

		outputStream.write(jsonByte);

		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader ist = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(ist);

		StringBuffer buffer = new StringBuffer();
		String line;

		while ((line = reader.readLine()) != null) {

			buffer.append(line);
			buffer.append("\n");
		}

		System.out.println(buffer);

	}

	public static void deleteMethod(String value) throws IOException {

		baseSteps(value);

		connection.setRequestMethod("DELETE");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);

		String body = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"Senior leader\"\r\n" + "}";

		byte[] jsonByte = body.getBytes();

		OutputStream outputStream = connection.getOutputStream();

		outputStream.write(jsonByte);

		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());

		InputStream inputStream = connection.getInputStream();
		InputStreamReader ist = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(ist);

		StringBuffer buffer = new StringBuffer();
		String line;

		while ((line = reader.readLine()) != null) {

			buffer.append(line);
			buffer.append("\n");
		}

		System.out.println(buffer);

	}

}
