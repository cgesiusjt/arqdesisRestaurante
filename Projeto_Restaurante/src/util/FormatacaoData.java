package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormatacaoData {

	public static String converterToString(Date data) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
		return sdf.format(data);

	}

	public static Date converterData(String data) {

		int ano = Integer.parseInt(data.substring(0, 4));
		int mes = Integer.parseInt(data.substring(5, 7));
		int dia = Integer.parseInt(data.substring(8, 10));

		Calendar cal = new GregorianCalendar(ano, mes - 1, dia);
		return cal.getTime();
	}

}
