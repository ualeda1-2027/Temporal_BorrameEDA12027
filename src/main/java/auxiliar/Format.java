package auxiliar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Format {
	
	public static String formatFecha(String fecha) {
		return LocalDate.parse(fecha).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));	
	}
	
	public static String formatDouble(double v) {
		return String.format(Locale.US, "%.2f", v);
	}

	public static String formatInt(int v) {
		return formatInt(v,3);
	}

	public static String formatInt(int v, int len) {
		return String.format(Locale.US, "%0" + len + "d", v);
	}
	
	public static String formatDouble(double v, int len) {
		return String.format(Locale.US, "%." + len + "f", v);
	}

}
