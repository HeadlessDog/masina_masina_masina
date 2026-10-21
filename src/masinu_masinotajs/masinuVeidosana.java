package masinu_masinotajs;

import javax.swing.JOptionPane;

public class masinuVeidosana {
	
	static int masinuSk = 0;
	
	static void taisitMasinu(String marka, String modelis, String krasa, int maxAtrums, int incAtrums)
	{
		
	}
	
	static void taisitMasinu(String[] markas, String[] krasas)
	{
		
		String marka = (String)JOptionPane.showInputDialog(null, "Kadu marku gribi?", "Auto dīlers", JOptionPane.QUESTION_MESSAGE, null, markas, markas[0]);
		String krasa = (String)JOptionPane.showInputDialog(null, "Kadu krasu gribi?", "Auto dīlers", JOptionPane.QUESTION_MESSAGE, null, krasas, krasas[0]);
		
		
		int maxAtr = Vaditajs.IntParb("Ievadi mašīnas vēlamo maksimālo ātrumu(45 - 200 km/h):", 45, 200);	
		int incAtr = Vaditajs.IntParb("Ievadi mašīnas akselerāciju(par cik tā pāātrinās katru reizi piespiežot pedāli) (5 - 75 km/h):", 5, 75);
		
		String modelis = Vaditajs.StringParb("Ievadi mašīnas modeli:");
		
		Vaditajs.masinas.add(new masinka(marka, modelis, krasa, maxAtr, incAtr));
		
		
		
	}

}
