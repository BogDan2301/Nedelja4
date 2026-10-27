import java.util.Scanner;

public class EvidencijeTemp {
	
	private double [] temperature;
	
	

	public double[] getTemperature() {
		return temperature;
	}



	public void setTemperature(double[] temperature) {
		this.temperature = temperature;
	}



	public EvidencijeTemp(double[] temperature) {
		this.temperature = temperature;
	}

	//Da li se vrijednost nalazi u nizu
	
	public boolean nalazi(double t) {
		for( int i = 0; i < temperature.length; i++) {
			if(temperature[i] == t) {
				return true;
			}
		}
		return false;
	}
	
	public double [] ukloni(double t) {
		
		int brojac = 0;
		for( int i = 0; i < temperature.length; i++) {
			if(temperature[i] != t) {
				brojac ++;
			}
		}
		
		double[] novi = new double[brojac];
		int j = 0;
		for( int i = 0; i < temperature.length; i++) {
			if( temperature[i] != t) {
				novi[j] = temperature[i];
				j++;
			}
		}
		return novi;
	}
	
	public double prosjecnaTemperatura(double[] niz) {
		
		if( niz.length == 0)
			return 0;
		
		int suma = 0;
		for( int i = 0; i < niz.length; i++) {
			suma += niz[i];
		}
		
		return suma / niz.length;
	}
	
	public double maksimalnaTemperatura(double[] niz) {
		
	    double max = niz[0];
		for( int i = 1; i < niz.length; i++) {
			if( niz[i] > max) {
				max = niz[i];
			}
		}
		return max;
	}
	
	 public static void ispisi(double[] niz) {
	        for (int i = 0; i < niz.length; i++) {
	            System.out.print(niz[i] + " ");
	        }
	        System.out.println();
	    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		 double[] unos = new double[5];
	        for (int i = 0; i < unos.length; i++) {
	            System.out.print("Unesite temperaturu " + (i + 1) + ": ");
	            unos[i] = sc.nextDouble();     
	        }
	        
	        EvidencijeTemp e1 = new EvidencijeTemp(unos);
	        
	        System.out.println("Dužina niza: " + e1.getTemperature().length);
	        System.out.print("Temperature: ");
	        ispisi(e1.getTemperature());
	        
	        
	        System.out.print("Unesite temperaturu koju tražite: ");
	        double trazena = sc.nextDouble();

	        if (e1.nalazi(trazena)) {
	            System.out.println("Temperatura " + trazena + " se nalazi u nizu.");
	        } else {
	            System.out.println("Temperatura " + trazena + " se ne nalazi u nizu.");
	        }

	        double[] azuriran = e1.ukloni(trazena);
	        e1.setTemperature(azuriran);

	        System.out.print("Ažurirani niz: ");
	        ispisi(e1.getTemperature());
	        
	        if (e1.getTemperature().length > 0) {
	            System.out.println("Prosječna temperatura: " + e1.prosjecnaTemperatura(e1.getTemperature()));
	            System.out.println("Maksimalna temperatura: " + e1.maksimalnaTemperatura(e1.getTemperature()));
	        } else {
	            System.out.println("Niz je prazan, nema prosjeka ni maksimuma.");
	        }


		sc.close();
	}

}
