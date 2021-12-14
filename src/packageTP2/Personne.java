package packageTP2;

import java.util.Collections;

public class Personne implements Comparable<Personne>  {
	private int age;
	private String nom;
	private String prenom;
	
	public Personne(int age,String nom,String prenom) {
		this.age=age;
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public int compareTo(Personne p) {
		int result;
		if(age>p.age )
			result=1;
		else if(age<p.age )
			result=-1;
		else
		{
			int secComp = nom.compareTo(p.nom); 
			result=(secComp != 0 ? secComp : prenom.compareTo(p.prenom));
		}
		return result;
	}

	public String toString() {
		return "Personne [age=" + age + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	

}
