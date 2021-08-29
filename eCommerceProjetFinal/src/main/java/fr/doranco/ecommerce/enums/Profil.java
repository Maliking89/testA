package fr.doranco.ecommerce.enums;

public enum Profil {
	ADMIN("Admin"),
	CLIENT("Client"),
	MAGASINIER("Magasinier");
	private String profil;
	
	private Profil(String profil) {
		this.profil = profil;
	}

	public String getProfil() {
		return profil;
	}

}
