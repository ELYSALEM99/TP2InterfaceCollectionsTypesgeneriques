package packageTP2;

public class Couple <T,E> {
	private T premier;
	private E deuxieme;
	
	public Couple(T premier,E deuxieme) {
		this.premier=premier;
		this.deuxieme=deuxieme;
	}
	
	public T getPremier() {
		return premier;
	}
	
	public void setPremier(T p) {
		premier=p;
	}
	
	
	public E getDeuxieme() {
		return deuxieme;
	}
	
	public void setDeuxieme(E d) {
		deuxieme=d;
	}
	
}
