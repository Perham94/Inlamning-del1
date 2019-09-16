package Java.Inamning;

import java.io.IOException;

/**
 * Hello world!
 *
 */

public class App {

	public static void main(String[] args) throws IOException, Exception {

		// För Del A G Lösningen ------------------------------
		// Del_A input = new Del_A("http://date.jsontest.com/");
		// input.getResult();

		// För Del A VG Lösning-------------------------------
		// Del_A_VG input = new Del_A_VG("http://date.jsontest.com/", "");
		// input.getJson();

		// Uppgift B Lösning
		Del_B input = new Del_B("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL",
				"http://www.oorsprong.org/websamples.countryinfo", "ns1", "SE");
		input.SOAPRequest();

	}
}
