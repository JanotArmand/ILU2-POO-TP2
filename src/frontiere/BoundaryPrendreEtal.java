package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		
		boolean estVillageois = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		if (estVillageois) {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver une étal.");
			if (controlPrendreEtal.resteEtals()) {
				installerVendeur(nomVendeur);
			} else {
				System.out.println("Je suis désolé "+nomVendeur+", je n'ai plus d'étal libre.");
			}
		} else {
			System.out.println("Désolé, "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous.\nIl me faudrait quelques renseignements :");
		
		StringBuilder questionProduit = new StringBuilder();
		questionProduit.append("Quel produit souhaitez vous vendre.\n");
		String produit = Clavier.entrerChaine(questionProduit.toString());
		
		StringBuilder questionQuantite = new StringBuilder();
		questionQuantite.append("Combien souhaitez vous en vendre.\n");
		int quantite = Clavier.entrerEntier(questionQuantite.toString());
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numeroEtal);
		}
	}
}
