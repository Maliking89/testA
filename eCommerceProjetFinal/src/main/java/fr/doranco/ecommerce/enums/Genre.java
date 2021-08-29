package fr.doranco.ecommerce.enums;

public enum Genre {

	MASCULIN("Masculin"),
	FEMININ("F�minin");
	
	private String genre;

	private Genre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

}
