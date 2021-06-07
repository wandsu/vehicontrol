package com.br.zup.vehicontrol.utils;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class Utils {
	
	public static String diaSemana() { 
		return new DateFormatSymbols().getWeekdays()[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)]; 
	}
	
}
