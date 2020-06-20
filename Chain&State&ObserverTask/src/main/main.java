package main;

import chain.CityDesk;
import chain.CountryDesk;
import chain.Desk;
import chain.ForeignDesk;
import chain.Package;
import observer.Observer;
import observer.PackageBoyObserver;
import states.State;

public class main {
	public static Desk packages;

	public static void main(String[] args) {
		Desk foreignDesk = new ForeignDesk();
		Desk countryDesk = new CountryDesk();
		Desk cityDesk = new CityDesk();
	
		cityDesk.setNext(countryDesk);
		countryDesk.setNext(foreignDesk);
		
		Observer obs1 = new PackageBoyObserver("Package Boy");
		Observer obs2 = new PackageBoyObserver("Package Boy");
		Observer obs3 = new PackageBoyObserver("Package Boy");
	
		cityDesk.subscribe(obs1);
		countryDesk.subscribe(obs2);
		foreignDesk.subscribe(obs3);

		packages=cityDesk;
	
		Package pack1=packages;
		Package pack2=packages;
		Package pack3=packages;
		Package pack4=packages;

		pack1.send(1, "package to another country!");
		pack2.send(2, "package to this country!");
		pack3.send(3, "package to Plovdiv!");
		pack4.send(1, "package to yet another country.");
				

	}

}
