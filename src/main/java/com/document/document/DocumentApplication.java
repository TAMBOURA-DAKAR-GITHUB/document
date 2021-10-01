package com.document.document;

import com.document.document.domain.*;
import com.document.document.service.Impdocservice.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DocumentApplication implements CommandLineRunner {

	private AgentServiceImp agentServiceImp;
	private CategorieServiceImp categorieServiceImp;
	private DocumentServiceImp documentServiceImp;
	private NatureServiceImp natureServiceImp;
	private RolesServiceImp rolesServiceImp;
	private ServicesServiceImp servicesServiceImp;
	private TypeServiceImp typeServiceImp;
	public DocumentApplication(AgentServiceImp agentServiceImp, CategorieServiceImp categorieServiceImp,
							   DocumentServiceImp documentServiceImp, NatureServiceImp natureServiceImp,
							   RolesServiceImp rolesServiceImp, ServicesServiceImp servicesServiceImp,
							   TypeServiceImp typeServiceImp) {
		this.agentServiceImp = agentServiceImp;
		this.categorieServiceImp = categorieServiceImp;
		this.documentServiceImp = documentServiceImp;
		this.natureServiceImp = natureServiceImp;
		this.rolesServiceImp = rolesServiceImp;
		this.servicesServiceImp = servicesServiceImp;
		this.typeServiceImp = typeServiceImp;
	}

	public static void main(String[] args) {
		SpringApplication.run(DocumentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Roles roles1= rolesServiceImp.addRoles(new Roles("ADMIN"));
		Roles roles2= rolesServiceImp.addRoles(new Roles("Agent"));


		Type type1= typeServiceImp.addTypes(new Type("pdf"));
		Type type2= typeServiceImp.addTypes(new Type("world"));
		Type type3= typeServiceImp.addTypes(new Type("ppt"));

		Categorie categorie1= categorieServiceImp.addCategorie(new Categorie("Courrier"));
		Categorie categorie2= categorieServiceImp.addCategorie(new Categorie("Facture"));
		Categorie categorie3= categorieServiceImp.addCategorie(new Categorie("Bon de Commande"));

		Nature nature1= natureServiceImp.addNature(new Nature("nature 1"));
		Nature nature2= natureServiceImp.addNature(new Nature("nature 2"));
		Nature nature3= natureServiceImp.addNature(new Nature("nature 3"));


		Services services1= servicesServiceImp.addServices(new Services("RH","78 897 65 33","rh@gmail.com","fann"));
		Services services2= servicesServiceImp.addServices(new Services("Informatique","78 777 65 19","info@gmail.com","medina"));
		Services services3= servicesServiceImp.addServices(new Services("Finance","78 654 65 00","finance@gmail.com","grand dakar"));
		Services services4= servicesServiceImp.addServices(new Services("securite","78 234 65 90","securite@gmail.com","yoff"));

		Agent agent1= agentServiceImp.addAgent(new Agent("soul","DIARRA","saint-louis","M","soul@gmail.com","soul2021",true,services1,roles2));
		Agent agent2= agentServiceImp.addAgent(new Agent("baba","DIARRA","bamako","M","baba@gmail.com","soul2021",true,services1,roles2));
		Agent agent3= agentServiceImp.addAgent(new Agent("fatou","DIARRA","faladie","F","fatou@gmail.com","soul2021",true,services1,roles2));
		Agent agent4= agentServiceImp.addAgent(new Agent("madess","DIARRA","yirimadio","M","madess@gmail.com","soul2021",false,services1,roles2));

		Agent agent5= agentServiceImp.addAgent(new Agent("abdou","DIARRA","yirimadio","M","abdou@gmail.com","soul2021",false,services2,roles2));
		Agent agent6= agentServiceImp.addAgent(new Agent("ben","DIARRA","yoff","M","ben@gmail.com","soul2021",true,services2,roles2));
		Agent agent7= agentServiceImp.addAgent(new Agent("moussa","DIARRA","fann","F","moussa@gmail.com","soul2021",true,services2,roles2));
		Agent agent8= agentServiceImp.addAgent(new Agent("jacki","DIARRA","medina","M","jacki@gmail.com","soul2021",true,services2,roles2));

		Agent agent9= agentServiceImp.addAgent(new Agent("zie","DIARRA","dakar","M","zie@gmail.com","soul2021",true,services3,roles2));
		Agent agent10= agentServiceImp.addAgent(new Agent("mamadou","DIARRA","grand dakar","M","mamadou@gmail.com","soul2021",true,services3,roles2));
		Agent agent11= agentServiceImp.addAgent(new Agent("youssoupha","DIARRA","yirimadio","M","youssoupha@gmail.com","soul2021",false,services3,roles2));
		Agent agent12= agentServiceImp.addAgent(new Agent("yah","DIARRA","dakar","F","yah@gmail.com","soul2021",true,services3,roles2));

		Agent agent13= agentServiceImp.addAgent(new Agent("oumar","DIARRA","fann","M","oumar@gmail.com","soul2021",true,services4,roles2));
		Agent agent14= agentServiceImp.addAgent(new Agent("segou","DIARRA","saint-louis","M","segou@gmail.com","soul2021",true,services4,roles2));
		Agent agent15= agentServiceImp.addAgent(new Agent("tenne","DIARRA","saint-louis","F","tenne@gmail.com","soul2021",false,services4,roles2));
		Agent agent16= agentServiceImp.addAgent(new Agent("destin","DIARRA","saint-louis","M","destin@gmail.com","soul2021",true,services4,roles2));

		Agent agent17= agentServiceImp.addAgent(new Agent("admin","admin","admin","M","admin@gmail.com","admin",true,services1,roles1));


		documentServiceImp.addDocument(new Document("ref001","document pour atos", new Date(), "atos","atos.pdf",type1,categorie1,nature1,agent1));
		documentServiceImp.addDocument(new Document("ref002","document pour atos", new Date(), "edm","edm.pdf",type1,categorie1,nature1,agent1));
		documentServiceImp.addDocument(new Document("ref003","document pour atos", new Date(), "somagep","somagep.pdf",type1,categorie1,nature1,agent1));
		documentServiceImp.addDocument(new Document("ref004","document pour atos", new Date(), "sonatel","sonatel.pdf",type1,categorie1,nature1,agent1));


	}
}
