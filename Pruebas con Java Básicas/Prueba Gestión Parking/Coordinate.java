package P3;

public class Coordinate {

	private char zone;
	private int number;
	
	Coordinate() {
		
	}
	
	Coordinate(char zone, int number) {
		this.zone = zone;
		this.number = number;
	}
	
	public char getZone() {
		return zone;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setZone(char zone) {
		this.zone = zone;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public boolean isEqualTo(Coordinate c) {
		if (this.getZone() == c.getZone() && this.getNumber() == c.getNumber()) {
			return true;
		} else return false;
		
	}
	
	public String toText() {
		String retorno = this.getZone() +""+ this.getNumber();
		return retorno;
	}
	
}									
	
									