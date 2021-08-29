package fr.doranco.ecommerce.enums;

public enum DisponibiliteArticle {
	VENDABLE("Vendable"),
	NOVENDABLE("NoVendable");
	
	private String disponibiliteArticle;

	private DisponibiliteArticle(String disponibiliteArticle) {
		this.disponibiliteArticle = disponibiliteArticle;
	}

	public String getDisponibiliteArticle() {
		return disponibiliteArticle;
	}
	

}
