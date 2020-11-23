import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Double> brutto=new ArrayList<Double>();//speichert die brutto eingegebene werte
		ArrayList<Double> netto=new ArrayList<Double>();//speichert die netto eingegeben werte
				
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Mwst: ");
		double mwst=sc.nextDouble();
		mwst/=100;
		
		double sum=0;
		
		do {
            System.out.println("Add more? (y/n)");
            if (sc.next().startsWith("y")) {
            	System.out.println("Brutto/Netto? ");
    			String art=sc.next();
    			if(art.startsWith("n")) {
    				System.out.println("netto");
    				System.out.println("Enter : ");
    				netto.add(sc.nextDouble());
    			}
    			
    			if(art.startsWith("b")) {
    				System.out.println("brutto");
    				System.out.println("Enter : ");
    				brutto.add(sc.nextDouble());
    			}
    			           
            } else {
            	System.out.println("summe Brutto or Netto ");
            	if(sc.next().startsWith("n")) {
            		for(double i:brutto) {
            			sum+=i;
            		}
            		sum=sum*(1-mwst);
            		for(double i:netto) {
            			sum+=i;
            		}
            		System.out.println("netto summe "+sum);
            	}
            	
            	else  {
            		for (double i :netto) {
            			sum+=i;
            		}
            		
            		sum=sum+(sum*mwst);
            		for(double i :brutto) {
            			sum+=i;
            		}
            		System.out.println("brutto summe "+sum);
            	}
            	//zum schreiben in die csv file
            	try(FileWriter csv=new FileWriter("new.csv")){
            		for(Double row:netto) {
        				csv.append("b");
        				row=row+(row*mwst);
        				csv.write(row.toString());
        				csv.append("\n");
        			}
        			
        			for(Double row:brutto) {
        				csv.append("b");
        				csv.write(row.toString());
        				csv.append("\n");
        			}
        		}
            	catch(IOException e) {
            		System.out.println("IOException: "+e);
            	}
        		
                break;
            }
        } while (true);
        sc.close();		

	}

}
