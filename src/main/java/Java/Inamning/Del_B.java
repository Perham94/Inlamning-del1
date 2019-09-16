package Java.Inamning;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class Del_B {

	private String url;
	private static String uri;
	private static String prefix;
	private static String ISO;

	/**
	 * @param url
	 * @param uri
	 * @param prefix
	 * @param iSO
	 */
	public Del_B(String url, String uri, String prefix, String iSO) {

		this.url = url;
		Del_B.uri = uri;
		Del_B.prefix = prefix;
		ISO = iSO;
	}

	// Comunicates to the webpage and transfear between requests and response
	public void SOAPRequest() throws Exception {

		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory.createConnection();
		SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

		System.out.println("Land: "
				+ soapResponse.getSOAPBody().getElementsByTagName("m:sName").item(0).getTextContent() + "\n"
				+ "Huvudstad: "
				+ soapResponse.getSOAPBody().getElementsByTagName("m:sCapitalCity").item(0).getTextContent() + "\n"
				+ "Valuta: "
				+ soapResponse.getSOAPBody().getElementsByTagName("m:sCurrencyISOCode").item(0).getTextContent() + "\n"
				+ "Språk: " + soapResponse.getSOAPBody().getElementsByTagName("m:sName").item(1).getTextContent());
		soapConnection.close();

	}

	// returns the content from the class as a message
	private static SOAPMessage createSOAPRequest() throws Exception {

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		SOAPBody body = envelope.getBody();
		envelope.addNamespaceDeclaration(prefix, uri);

		// SOAP Body
		body.addChildElement("FullCountryInfo", prefix).addChildElement("sCountryISOCode", prefix).addTextNode(ISO);

		return soapMessage;
	}
}
