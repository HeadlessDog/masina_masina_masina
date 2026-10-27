package masinu_masinotajs;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Vaditajs {
	
	static ArrayList<masinka> masinas = new ArrayList<>();
	
	static int IntParb(String zina, int min, int max)
	{
		boolean valid = false;
		int newInt =0;
		String input;
		do {
			
		try {
			input = (String)JOptionPane.showInputDialog(null, zina, "Datu ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(input == null)
				valid = false;
			newInt = Integer.parseInt(input);
				
			if(newInt >= min && newInt <= max)
				valid = true;
			else 
				valid = false;
		}catch(NumberFormatException e) {
			valid = false;
		}
		if(!valid) JOptionPane.showMessageDialog(null, "Dati nav atbilstoši", "Kļūda", JOptionPane.ERROR_MESSAGE);
		}while(!valid);
		return newInt;
	}
	
	static String StringParb(String zina) {
		String virkne;
		boolean valid = false;
		do {
			virkne =  JOptionPane.showInputDialog(null, zina, "Datu ievade", JOptionPane.INFORMATION_MESSAGE);
			if(virkne == null)
				valid = false;;
			
			virkne = virkne.trim();
			
			if(Pattern.matches("^[\\p{L}\\p{N} ]+$", virkne))
				valid = true;
			else valid = false;
			
			if(!valid) JOptionPane.showMessageDialog(null, "Dati nav atbilstoši", "Kļūda", JOptionPane.ERROR_MESSAGE);
		}while(!valid);
		
		return virkne;
	}
	
	public static void main(String[] args) {
		String vieta = "dealer";
		
		String currentMasinaName = "NAV";
		masinka currentMasinaRef;
		String[] visasVietas = { "dealer", "veikals", "garaza", "serviss", "uzcela"};
		
		String[] pieejMarkas = {"Fiat", "Opel", "Lamborghini", "Audi"};
		
		String[] pieejKrasas = {"Sarkana", "Melna", "Balta", "Dzeltena", "Zila", "Zaļa"};
		do {
			switch(vieta)
			{
			case "dealer":
				String[] dealerOpcijas = {"Aiziet uz garažu", "Pirk mašīnu"};
				String darbiba = (String)JOptionPane.showInputDialog(null, "Yoo broo, tu esi pie dīlera, ko gribi darīt?", "Auto dīleris", JOptionPane.INFORMATION_MESSAGE, null, dealerOpcijas, dealerOpcijas[0]);
				
				switch(darbiba) {
				case "Pirk mašīnu":
					JOptionPane.showMessageDialog(null, "Ok boss, tlt sataisīsism tev mašīnu!", "Auto Dīleris", JOptionPane.INFORMATION_MESSAGE);
					masinuVeidosana.taisitMasinu(pieejMarkas, pieejKrasas);
					JOptionPane.showMessageDialog(null, "Ballrightt, tev jaunā mašīna ir garāžā.");
					break;
				case "Aiziet uz garažu":
					vieta = "garaza";
					JOptionPane.showMessageDialog(null, "Tu aizej uz garāžu...", "Staigā", JOptionPane.INFORMATION_MESSAGE);
					break;
				default: System.exit(0); break;
				}
				break;
			case "garaza":
				int masinuSk = masinas.size();
				
				String[] masinuNosaukumi = new String[masinuSk];
				String[] darbibuOpcijas = new String[masinuSk+2];
				
				if(masinuSk != 0)
					for(int i =0;i<masinuSk;i++)
						masinuNosaukumi[i] = masinas.get(i).marka+" "+masinas.get(i).modelis;
				
				for(int i=0;i<masinuSk;i++)
					darbibuOpcijas[i] = masinuNosaukumi[i];

				darbibuOpcijas[masinuSk+1] = "Iet atpakaļ pie dīlera";
				darbibuOpcijas[masinuSk] = "Pārtaisīt kādu mašīnu";
					
				String izvele = (String)JOptionPane.showInputDialog(null, "So, tu esi garāžā, reku tev te mašīnas (varbut ari nav neviena).\n Vari arī iet atpakāļ pie dīlera vai pārtaisīt kādu mašīnu.", "Garaza", JOptionPane.INFORMATION_MESSAGE, null, darbibuOpcijas, darbibuOpcijas[0]);
				
				if(izvele == "Iet atpakaļ pie dīlera") {
					JOptionPane.showMessageDialog(null, "Tu aizej uz auto dīleri...", "Staigā", JOptionPane.INFORMATION_MESSAGE);
					vieta = "dealer";
					continue;
				}
				else if(izvele == "Pārtaisīt kādu mašīnu")
				{
					if(masinuSk == 0) {
						JOptionPane.showMessageDialog(null, "Tev nav mašīnu ko pārtaisīt!", "Kļūda", JOptionPane.ERROR_MESSAGE);
						continue;
					}
					int masinaIdx = -1;
					String masina = (String)JOptionPane.showInputDialog(null, "Kuru mašīnu gribi pārtaisīt?", "Garāža", JOptionPane.INFORMATION_MESSAGE, null, masinuNosaukumi, masinuNosaukumi[0]);
					
					for(int i=0;i<masinuSk;i++) {
						if(masinuNosaukumi[i].equals(masina)) {
							masinaIdx = i;
							break;
						}	
					}
					if(masinaIdx > -1) masinuVeidosana.parTaisitMasinu(masinaIdx, pieejKrasas);
					else System.exit(0);
					continue;
					
				}
				else if(izvele == null) System.exit(0);
				else {
					currentMasinaName = izvele;
					currentMasinaRef = null;
					for(int i=0;i<masinuSk;i++)
						if((masinas.get(i).marka+" "+masinas.get(i).modelis).equals(currentMasinaName))
							currentMasinaRef = masinas.get(i);
					if(currentMasinaRef == null) {
						JOptionPane.showMessageDialog(null, "Ļoti savāda kļūda, ja šo saņēmi vari justies īpašs!", "Kļūda", JOptionPane.ERROR_MESSAGE);
						continue;
					}
					
					String[] darbibas = {"Braukt ar šito", "Paga nē, gribu atpakaļ uz garāžu"};
					//JOptionPane.showOptionDialog(null, "Izvēlieties darbību: ",
						//	"Picerijas pasūtījumu programma", 0, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					int masinaDarbiba = -1;
					masinaDarbiba = JOptionPane.showOptionDialog(null,
							"Reku šitā mašīna:\n"
							+ "Marka: "+currentMasinaRef.marka
							+"\nModelis: "+currentMasinaRef.modelis
							+"\nKrasa: "+currentMasinaRef.krasa
							+"\nMaksimālais ātrums: "+currentMasinaRef.maxAtrums
							+" km\\h\nAkselerācija: "+currentMasinaRef.incAtrums
							+"(km\\h uz piespiedienu)\nNotreikti cilvēki: "+currentMasinaRef.notriektiCilv,
							"Garāža",0, JOptionPane.QUESTION_MESSAGE, null,
						    darbibas, darbibas[0]);
					if(masinaDarbiba == 0)
						JOptionPane.showMessageDialog(null, "Šī funkcionalitāte nav īstenota vēl, ma fault.", "Kļūda", JOptionPane.ERROR_MESSAGE);
					else
						continue;
					
				}
				break;
			}
		}while(true);
	}

}
