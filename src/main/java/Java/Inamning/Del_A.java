package Java.Inamning;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONObject;

public class Del_A {

	private String url;

	private String result;

	/**
	 * @param url
	 */
	public Del_A(String url) {

		this.url = url;

	}

	// Connects to the rest api and parses the data values
	public void getResult() throws IOException {

		Scanner scanner = new Scanner(new URL(url).openStream(), StandardCharsets.UTF_8.toString());
		scanner.useDelimiter("\\A");
		result = scanner.hasNext() ? scanner.next() : "";
		scanner.close();
		JSONObject parser = new JSONObject(result);
		System.out.println("Date : " + parser.get("date") + "\n" + "Milisecounds : "
				+ parser.get("milliseconds_since_epoch") + "\n" + "Time : " + parser.get("time"));

	}

}
