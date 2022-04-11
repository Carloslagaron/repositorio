package P3;

public class CarSpace {

	private Coordinate coordenada;
	private String plate = "";
	
	CarSpace() {
		
	}
	
	CarSpace(Coordinate coordenada) {
		this.coordenada = coordenada;
	}
	
	CarSpace(Coordinate coordenada, String plate) {
		this.coordenada = coordenada;
		this.plate = plate;
	}
	
	public Coordinate getCoordinate() {
		return coordenada;
	}
	
	public String getPlate() {
		return plate;
	}
	
	public void setCoordinate(Coordinate coordenada) {
		this.coordenada = coordenada;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public String toText() {
		String retorno = this.getCoordinate().toText() + ";"+ this.getPlate();
		return retorno;
	}
	
}
