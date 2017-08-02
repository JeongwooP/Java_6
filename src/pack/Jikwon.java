package pack;

public class Jikwon {
	public int bunho;
	public String irum;
	public String junhwa;
	
	public Jikwon(int bunho, String irum, String junhwa) {
		this.bunho = bunho;
		this.irum = irum;
		this.junhwa = junhwa;
	}
	
	@Override
	public String toString() {
		return bunho + " " + irum + " " + junhwa;
	}
}
