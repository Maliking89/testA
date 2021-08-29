package fr.doranco.ecommerce.utils;

import java.text.SimpleDateFormat;

public final class Dates {

	private static final String formatDate = "dd/MM/yyyy";
	
	private Dates() {
	}
	
	public static java.sql.Date convertDateUtilToDateSql(java.util.Date dateUtil) throws Exception {
		if (dateUtil == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return new java.sql.Date(dateUtil.getTime());
	}
	
	public static java.util.Date convertDateSqlToDateUtil(java.sql.Date dateSql) throws Exception {
		if (dateSql == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		return new java.util.Date(dateSql.getTime());
	}

	public static String convertDateUtilToString(java.util.Date dateUtil) throws Exception {
		if (dateUtil == null) {
			throw new NullPointerException("La date à convertir ne doit pas être NULL !");
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.format(dateUtil);
	}

	public static java.util.Date convertStringToDateUtil(String dateStr) throws Exception {
		if (dateStr == null || dateStr.trim().isEmpty()) {
			throw new IllegalArgumentException("La date à convertir ne doit pas être NULL ou vide !");
		}
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		return formatter.parse(dateStr);
	}

}
