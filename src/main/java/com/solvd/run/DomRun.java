/**
 * 
 */
package com.solvd.run;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DomRun {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilder documentBuilder1 = DocumentBuilderFactory
				.newDefaultInstance().newDocumentBuilder();
		Document dom1 = documentBuilder1.parse(DomRun.class.getClassLoader()
				.getResourceAsStream("clientXML.xml"));
		dom1.getDocumentElement().normalize();

		for (int i = 0; i < dom1.getElementsByTagName("phoneClient")
				.getLength(); i++) {

			System.out.println(dom1.getElementsByTagName("phoneClient").item(i)
					.getTextContent());

			// System.out.println("Parent: " +
			// dom1.getParentNode().getNodeName());

			// System.out.println("First node: " +
			// dom1.getFirstChild().getNextSibling().getTextContent());

			// System.out.println("Last Node: " +
			// dom1.getLastChild().getPreviousSibling().getTextContent());

		}

		System.out.println("URI xml: " + dom1.getDocumentURI());

		System.out.println("version: " + dom1.getXmlVersion());

		System.out.println("Encoding: " + dom1.getXmlEncoding());

		System.out.println("Lenght nodo: " + dom1.getChildNodes().getLength());

		DocumentBuilder documentBuilder2 = DocumentBuilderFactory
				.newDefaultInstance().newDocumentBuilder();
		Document dom2 = documentBuilder2.parse(DomRun.class.getClassLoader()
				.getResourceAsStream("distributor.xml"));
		dom2.getDocumentElement().normalize();

		System.out.println(dom2.getElementsByTagName("distributorName").item(0)
				.getTextContent());

		DocumentBuilder documentBuilder3 = DocumentBuilderFactory
				.newDefaultInstance().newDocumentBuilder();
		Document dom3 = documentBuilder3.parse(DomRun.class.getClassLoader()
				.getResourceAsStream("employee.xml"));
		dom3.getDocumentElement().normalize();

		System.out.println(
				dom3.getElementsByTagName("dni").item(0).getTextContent());

		DocumentBuilder documentBuilder4 = DocumentBuilderFactory
				.newDefaultInstance().newDocumentBuilder();
		Document dom4 = documentBuilder4.parse(DomRun.class.getClassLoader()
				.getResourceAsStream("material.xml"));
		dom4.getDocumentElement().normalize();

		System.out.println(dom4.getElementsByTagName("nameMaterial").item(0)
				.getTextContent());

		DocumentBuilder documentBuilder5 = DocumentBuilderFactory
				.newDefaultInstance().newDocumentBuilder();
		Document dom5 = documentBuilder5.parse(DomRun.class.getClassLoader()
				.getResourceAsStream("product.xml"));
		dom5.getDocumentElement().normalize();

		System.out.println(dom5.getElementsByTagName("presentation").item(0)
				.getTextContent());

	}

}
