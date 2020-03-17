package br.vmcorrea.teste_api.utils;

import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	public static Date anosAtras(Integer anos) {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -anos);
		return c.getTime();
	}
}
