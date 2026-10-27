package masinu_masinotajs;

import javax.swing.JOptionPane;

public class masinuVeidosana {
	
	static int masinuSk = 0;
	
	static void parTaisitMasinu(int masinaIdx, String[] krasas)
	{
		String[] darbibas = {"Krasa", "Maks. ātrums", "Akselerācija"};
		masinka OldMasina = Vaditajs.masinas.get(masinaIdx);
		
		
		String darbiba = (String)JOptionPane.showInputDialog(null, "Ko gribi paraisit?", "Garāža", JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);
		
		switch(darbiba) {
		case "Krasa": String krasa = (String)JOptionPane.showInputDialog(null, "Kadu krasu gribi?", "Auto dīlers",
				JOptionPane.QUESTION_MESSAGE, null, krasas, krasas[0]);
					Vaditajs.masinas.set(masinaIdx, new masinka(OldMasina.marka, OldMasina.modelis, krasa, OldMasina.maxAtrums, OldMasina.incAtrums, OldMasina.notriektiCilv));
					break;
		case "Maks. ātrums": int maxAtr = Vaditajs.IntParb("Ievadi mašīnas vēlamo maksimālo ātrumu(45 - 200 km/h):", 45, 200);	
					Vaditajs.masinas.set(masinaIdx, new masinka(OldMasina.marka, OldMasina.modelis, OldMasina.krasa, maxAtr, OldMasina.incAtrums, OldMasina.notriektiCilv));
					break;
		case "Akselerācija": int incAtr = Vaditajs.IntParb("Ievadi mašīnas vēlamo maksimālo ātrumu(45 - 200 km/h):", 45, 200);	
		Vaditajs.masinas.set(masinaIdx, new masinka(OldMasina.marka, OldMasina.modelis, OldMasina.krasa, OldMasina.maxAtrums, incAtr, OldMasina.notriektiCilv));
		break;
		default: JOptionPane.showMessageDialog(null, "Kļūda, pārtaisīšana atcelta!", "Kļūda", JOptionPane.ERROR_MESSAGE); break;
		}
		
	}
	
	static void taisitMasinu(String[] markas, String[] krasas)
	{
		
		String marka = (String)JOptionPane.showInputDialog(null, "Kadu marku gribi?", "Auto dīlers", JOptionPane.QUESTION_MESSAGE, null, markas, markas[0]);
		String krasa = (String)JOptionPane.showInputDialog(null, "Kadu krasu gribi?", "Auto dīlers", JOptionPane.QUESTION_MESSAGE, null, krasas, krasas[0]);
		
		
		int maxAtr = Vaditajs.IntParb("Ievadi mašīnas vēlamo maksimālo ātrumu(45 - 200 km/h):", 45, 200);	
		int incAtr = Vaditajs.IntParb("Ievadi mašīnas akselerāciju(par cik tā pāātrinās katru reizi piespiežot pedāli) (5 - 75 km/h):", 5, 75);
		
		String modelis = Vaditajs.StringParb("Ievadi mašīnas modeli:");
		
		for(int i=0;i<Vaditajs.masinas.size();i++)
			if(Vaditajs.masinas.get(i).marka.equals(marka) && Vaditajs.masinas.get(i).modelis.equals(modelis)) {
				JOptionPane.showMessageDialog(null, "Sorry boss, nevar būt divas mašīnas ar vienādu marku un modeli!", "Kļūda", JOptionPane.ERROR_MESSAGE);
				return;
			}
		
		Vaditajs.masinas.add(new masinka(marka, modelis, krasa, maxAtr, incAtr, 0));
		
	}

}
