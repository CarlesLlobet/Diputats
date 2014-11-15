//Autor: Albert Tost

package propsw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Exode {
	private Integer idBaseInici;
	private ArrayList<String> rebels;
	private HashMap<String,ArrayList<Integer>> camins;
	private HashMap<String,Integer> destins;
	private Graf<Base> grafResidual;
	private Graf<Base> grafInicial;
	private Galaxia galaxia;
	private Integer flow;
	private static Integer cont = 0;
	private double cost;
	private boolean actualitzat;
	private String idExode;
	private FordFulkerson<Base> ff;
	private ArrayList<Integer[]> collsAmpolla;
	
	public Exode(Galaxia g){
		++cont;
		this.idExode = cont.toString();
		grafInicial = g;
		galaxia = g;
		destins = new HashMap<String, Integer>();
		camins = new HashMap<String, ArrayList<Integer>>();
	}
	
	
	//Retorna un HashMap amb key=idRebel i value = idBase (Dest� assignat al Rebel)
	public HashMap<String,Integer> getDestinsRebels(){
		return destins;
	}

	
	//Retorna un hashMap amb key = idBase (cada un dels dest�ns) i value = numero de rebels que van a aquell dest� 
	public HashMap<Integer,Integer> getDestinsResum() {
		//Cada rebel t� un dest� assignat. Es fa una llista 
		//dels diferents destins sense repeticions
		HashMap<Integer,Integer> toReturn = new HashMap<Integer, Integer>();
		
		Iterator<String> keys = destins.keySet().iterator();
		String k = "";
		Integer idBase= null;
		int counter;
		while(keys.hasNext()){
			k = keys.next();
			idBase = destins.get(k);
			if(!toReturn.containsKey(idBase))toReturn.put(idBase,1);
			else{
				counter = toReturn.get(idBase)+1;
				toReturn.put(idBase,counter);							//Actualitzem el contador
			}
		}
		return toReturn;
	}

	public void execucioDijkstra() throws IOException {
		ff = new FFDijkstra<Base>(idBaseInici,2,galaxia);
		execucio();
	}
	
	
	//Retorna un HashMap on la key es el id del Rebel y el value 
	//es un ArrayList amb les bases que marquen el cam� en ordre 
	//desde l'origen al dest�
	public HashMap<String, ArrayList<Integer>> getCamins() {
		return camins;
	}


	public ArrayList<String> getCaminsRebel(String idRebel) {
		 //TODO
		return new ArrayList<String>();
	}
	
	// Executa el FF-DFS i emplena la variable camins assignant un cam� a cada rebel assignat a l'exode.
	public void execucioDFS() throws IOException {
		ff = new FordFulkerson<Base>();
		execucio();
	}
	
	
	private void execucio() throws IOException{
		camins = new HashMap<String, ArrayList<Integer>>();				//Reinicialitzem el mapa de camins  perque farem una nova execuci�
		collsAmpolla = new ArrayList<Integer[]>();						//Reinicialitzem els colls d'ampolla perque fem una nova execuci� de l'algoritme
		// Hem de unir els destins amb el sumidero en el graf inicial
		Base b = new Base(galaxia);
		grafResidual = grafInicial;
		HashMap<Integer,Integer> destinsResum = getDestinsResum();
		ArrayList<Integer> dests = new ArrayList<Integer>(destinsResum.keySet());
		int sizeDests = dests.size();
		for (int i = 0; i < sizeDests; i++){
			//LA CAPACITAT DE LA ARESTA QUE VA AL SUMIDERO ES EL NUMERO DE REBELS QUE VAN A AQUELL DEST�!!!!!!!
			grafResidual.conectarNodes(dests.get(i), b.getId(), destinsResum.get(dests.get(i)), Double.MIN_VALUE);
		}
		grafResidual = ff.findMaxFlow(grafResidual, idBaseInici, b.getId());
		flow = ff.getMaxFlow();					//El numero de rebels que arriben als seus destins.
		//Surten "n=flow" rebels de l'origen ....
		generaCamins(grafResidual,idBaseInici, new ArrayList<Integer>(), flow);			//El post-processament del graf residual
	}

	//Donat un graf residual, recursivament, el va recorrent desde el node inicial fins al sumidero 
	//en funci� del fluxe assignat a cada aresta i al final del recorregut assigna 
	//camins als rebels en funci� del fluxe resultant i del dest� que tenien assignat.
	private void generaCamins(Graf<Base> g, int idBase, ArrayList<Integer> camino, int numRebels) throws IOException {
		ArrayList<Integer> newCamino = new ArrayList<Integer>(camino);
		newCamino.add(idBase);
		ArrayList<Integer> nodesOut = g.getOutNodes(idBase);
		int size = nodesOut.size();
		boolean b = false;
		for (Integer integer : nodesOut) {
			if(g.getFlujoAresta(g.getIDAresta(idBase,integer))>0)b=true;			//S'activa a true nom�s si t� com a minim un flux positiu en cualsevol aresta.
		}
		if(size<=0 || !b){
			//Si no t� arestes de sortida vol dir que hem arribat al sumidero. Assignem el cam� a
			//"n=numRebels" que encara no tinguin assignat cap cam�
			assignaRebels(newCamino,numRebels,g);
			return;
		}
		int i = 0, fHelp, flujo = Integer.MAX_VALUE;
		while (i < size && numRebels>0) {
			//Donada una base uns rebels marxar�n cap a unes bases y uns altres cap a unes altres,
			//En funci� del flux que ha calculat el graf residual per cada aresta de sortida de la base.
			fHelp = g.getFlujoAresta(g.getIDAresta(idBase, nodesOut.get(i)));			//No tenemos en cuenta las restroarestas
			if(fHelp>0){
				flujo = Math.min(numRebels, fHelp);
				if(flujo>0){
					generaCamins(g,nodesOut.get(i),newCamino,flujo);
					g.setFlujoAresta(g.getIDAresta(idBase, nodesOut.get(i)), g.getFlujoAresta(g.getIDAresta(idBase, nodesOut.get(i)))-flujo);			//Actualizamos el flujo para marcar que pasamos por la arista. Asi en otra rama de la recursividad aseguramos que no pasen mas rebeldes por esta arista que los que marca realmente el flujo.
				}
				numRebels = numRebels-flujo;
			}
			i++;
		}
	}
	
	
	
	//Assigna el cami als rebels que tenen el dest� igual que la penultima posici� del array camino
	//(la �ltima es el sumidero). Nom�s assigna camins a rebels que no tenen encara cap
	//cam� assignat. 
	private void assignaRebels(ArrayList<Integer> camino, int numRebels, Graf<Base> g) throws IOException {
		Iterator<String> it = destins.keySet().iterator();
		camino.remove(camino.size()-1);
		for (int i = 0; i < camino.size()-1; i++) {
			if(g.getCapacidadAresta(g.getIDAresta(camino.get(i),camino.get(i+1)))<=0){
				Integer[] aresta = new Integer[2];
				aresta[0] = camino.get(i);
				aresta[1] = camino.get(i+1);
				collsAmpolla.add(aresta);
			}
		}
		while(it.hasNext() && numRebels>0){
			String idRebel =it.next();
			//Nom�s si encara queden rebels per assignar, si el dest� es coincident 
			//i si el rebel encara no t� assignat encara cap cam�
			if(numRebels>0 && destins.get(idRebel) == camino.get(camino.size()-1) && !camins.containsKey(idRebel)){
				camins.put(idRebel, camino);
				numRebels--;
			}
		}
	}


	public void execucioBFS() throws IOException {
		ff = new EdmondsKarp<Base>(idBaseInici, 2, galaxia);
		execucio();
	}
	
	//S'afegeix un rebel a l'exode nom�s si aquest forma part de la tropa del capit�
	public boolean afegirRebel(String idRebel, Integer idBaseDesti) {
		Rebel r = galaxia.getCapita().getRebels().get(idRebel);
		if(r!=null){
			destins.put(idRebel, idBaseDesti);
			actualitzat = false;			//S'ha afegit un nou rebel per tant l'exode ha de tornarse a executar. El reustat esta desactualitzat
			return true;
		}else{
			//Si no forma part dels rebels del capit� aleshores no s'afegeix i retorna false perque no s'ha produit la inserci�
			return false;
		}
	}
	
	//Modifica la base dest� del rebel. Es marca com a desactualitzat el rebel
	public void modificarRebel(String idRebel,Integer idBaseDesti) {
		destins.put(idRebel, idBaseDesti);
		actualitzat = false;		
	}

	//Borra un rebel del exode i marca com a desactualitzat el exode. Retorna true si existia el rebel 
	//assignat al exode o false en cas contrari.
	public boolean borrarRebel(String idRebel) {
		Integer r = destins.remove(idRebel);
		actualitzat = false;
		return (r!=null);
	}

	// Getters i setters
	
	public FordFulkerson<Base> getFf() {
		return ff;
	}

	public String getIdExode(){
		return idExode;
	}
	
	public Integer getIdBaseInici() {
		return idBaseInici;	
	}

	public void setIdBaseInici(Integer idBaseInici) {
		this.idBaseInici = idBaseInici;
	}

	public ArrayList<String> getRebels() {
		return rebels;
	}

	public void setRebels(ArrayList<String> rebels) {
		this.rebels = rebels;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public Integer getFlow() {
		return flow;
	}
	
	public void setFlow(Integer flow) {
		this.flow = flow;
	}
	
	public boolean isActualitzat() {
		return actualitzat;
	}

	public ArrayList<Integer[]> getCollsAmpolla() {
		return collsAmpolla;
	}

	
	
}
