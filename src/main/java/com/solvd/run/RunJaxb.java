/**
 * 
 */
package com.solvd.run;

import java.io.File;
import java.util.ArrayList;

import com.solvd.entities.Client;
import com.solvd.entities.ClientXml;
import com.solvd.entities.Distributor;
import com.solvd.entities.DistributorXml;
import com.solvd.entities.Employee;
import com.solvd.entities.Material;
import com.solvd.entities.Product;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class RunJaxb {

	public static void main(String[] args) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(ClientXml.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		ClientXml cl = (ClientXml) unmarshaller.unmarshal(new File(
				"C:\\Users\\emy06\\jdbc-lab\\src\\main\\resources\\client.xml"));

		ArrayList<Client> clients = cl.getClients();
		for (Client c : clients) {
			System.out.println(c.getIDclient() + " " + c.getClientName() + " "
					+ c.getAddresClient() + " " + c.getPhoneClient());
		}

		DistributorXml di = (DistributorXml) unmarshaller.unmarshal(new File(
				"C:\\Users\\emy06\\jdbc-lab\\src\\main\\resources\\distributor.xml"));

		ArrayList<Distributor> distributors = di.getDistributors();
		for (Distributor d : distributors) {
			System.out.println(
					d.getIDdistributor() + " " + d.getDistributorName() + " "
							+ d.getDistributorZone() + " " + d.getIDproduct());
		}

		Product pr = (Product) unmarshaller.unmarshal(RunJaxb.class
				.getClassLoader().getResourceAsStream("product.xml"));
		System.out.println(pr);

		Employee em = (Employee) unmarshaller.unmarshal(RunJaxb.class
				.getClassLoader().getResourceAsStream("employee.xml"));
		System.out.println(em);

		Material ma = (Material) unmarshaller.unmarshal(RunJaxb.class
				.getClassLoader().getResourceAsStream("material.xml"));
		System.out.println(ma);
		
		System.out.println("-------------------Marshaller--------------------");

		/*
		JAXBContext contextM = JAXBContext.newInstance(DistributorXml.class);

		Marshaller marshaller = contextM.createMarshaller();
		DistributorXml distributorXml = new DistributorXml();

		ArrayList<Distributor> distributorsM = new ArrayList<>();

		Distributor distributor = new Distributor();
		distributor.setIDdistributor(4);
		distributor.setDistributorName("AntoDistributions");
		distributor.setDistributorZone("East");
		distributor.setIDproduct(2);
		distributorsM.add(distributor);

		Distributor distributor5 = new Distributor();
		distributor5.setIDdistributor(5);
		distributor5.setDistributorName("FullDistributions");
		distributor5.setDistributorZone("West");
		distributor5.setIDproduct(3);
		distributorsM.add(distributor);

		distributorXml.setDistributors(distributorsM);

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(distributorXml, System.out);
		// marshaller.marshal(distributorXml, new //
		// FileWriter("C:\\Users\\emy06\\jdbc-lab\\src\\main\\resources\\distributorXml.xml"));
        */
	}

}
