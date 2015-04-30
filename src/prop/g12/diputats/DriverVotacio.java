package prop.g12.diputats;

import java.util.Map;
import java.util.Scanner;

public class DriverVotacio {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) {     
        Scanner sc = new Scanner(System.in);    
        System.out.print("Introdueix 0 per provar el constructor de la classe Votacio\n"
				+ "Introdueix 1 per provar getCodi\n"
				+ "Introdueix 2 per provar getDescripcio\n"
				+ "Introdueix 3 per provar getData\n"
				+ "Introdueix 4 per afegir un Vot\n"
				+ "Introdueix -1 per a finalitzar l'execucio\n");    
        int opt = sc.nextInt();
        Votacio v;
        v = new Votacio();
        StubDiputat sd;
        StubVot vot;
        Map<StubDiputat,StubVot> vots = null;
        int codi;
        String desc, data;
        boolean acabado = true;
        while(acabado){
            switch(opt){
                case 0:
                    System.out.println("Introdueix el codi de la votacio");
                    while(!sc.hasNext());
                    codi = sc.nextInt();
                    v.setCodi(codi);
                    System.out.println("Introdueix la descripcio de la votacio");
                    while(!sc.hasNext());
                    desc = sc.nextLine();
                    v.setDescripcio(desc);
                    System.out.println("Introdueix la data de la votacio");
                    while(!sc.hasNext());
                    data = sc.nextLine();
                    //v.setData(data); dataToString
                    System.out.println("Votacio creada");
                    break;
                case 1:
                	System.out.println("El codi de la votacio es: " + v.getCodi());
    				break;
                case 2:
                    System.out.println("La descripio de la votacio es: " + v.getDescripcio());
                    break;              
                case 3:
                    System.out.println("La data de la votacio es: " + v.getData());
                    break;              
                case 4:
                	sd = new StubDiputat();
    				System.out.println("Creat el diputat " + sd.getNom() + " amb ideologia " + sd.getIdeologia() + " i procedencia " + sd.getProcedencia());
    				vot = new StubVot();
    				System.out.println("El diputat " + sd.getNom() + " ha votat " + vot.GetVot());
    				vots.put(sd,vot);
    				System.out.println("Diputat afegit a la llista\n");
    				break;
                case -1:
                    acabado = false;
                    break;

            }
            if(acabado) opt = sc.nextInt();
        }
        sc.close();
    }
}
