import java.util.Date;

public class Estadistiques {

	String nom;
	Date data;
	String tipusGrafic; //NO ES STRING, inacabat. Segurament es un txt

	public Estadistiques(String nom, Date data, String tipusGrafic){
		this.nom = nom;
		this.data = data;
		this.tipusGrafic = tipusGrafic;
		
	}
	
	public String getNom() {
		return nom;
	}
	
	public Date getData() {
		return data;
	}
	
	public String getTipusGrafic() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public void setTipusGrafic(String tipusGrafic) {
		this.tipusGrafic = tipusGrafic;
	}
	
	public void EliminarGrafica(Estadistiques est){
		
	}
	
	public void ExportarEstadistiques(Estadistiques est){
		
	}
	
	public void ImportarEstadistiques(Estadistiques est){
		
	}
	
	public void ConsultarGrafica(Estadistiques est){
		
	}

}
