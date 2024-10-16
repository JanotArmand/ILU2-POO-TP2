package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Bonjour Druide "+nomVisiteur+"\nQuel est votre force ?\n");
		int forceDruide = Clavier.entrerEntier(questionForce.toString());
		
		StringBuilder questionPotionMin = new StringBuilder();
		questionPotionMin.append("Quelle est la force de la potion la plus faible que vous produisez ?\n");
		int forcePotionMinDruide = Clavier.entrerEntier(questionPotionMin.toString());
		
		StringBuilder questionPotionMax = new StringBuilder();
		questionPotionMax.append("Quelle est la force de la potion la plus forte que vous produisez ?\n");
		int forcePotionMaxDruide = Clavier.entrerEntier(questionPotionMax.toString());
		
		while (forcePotionMaxDruide<forcePotionMinDruide) {
			System.out.println("Attention Druide "+nomVisiteur+" vous vous êtes trompés entre le minimum et le maximum.\n");
			forcePotionMinDruide = Clavier.entrerEntier(questionPotionMin.toString());
			forcePotionMaxDruide = Clavier.entrerEntier(questionPotionMax.toString());
		}
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, forcePotionMinDruide, forcePotionMaxDruide);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Bonjour Gaulois "+nomVisiteur+"\nQuel est votre force ?\n");
		int forceGaulois = Clavier.entrerEntier(questionForce.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur,forceGaulois);
	}
}
