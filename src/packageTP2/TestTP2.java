package packageTP2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class TestTP2 {
	static Map<String, List<String>> m = new HashMap<String, List<String>>(); 
	public static void main(String[] args) { 
		 try{
			 System.err.println("**********première question**********");
			 String s= new String("Toto");
			 GregorianCalendar g=new GregorianCalendar();
			 Integer i1=4;
			 Couple<GregorianCalendar, String> C1= new Couple<GregorianCalendar, String>(g,s);
			 Couple<String,Integer> C2= new Couple<String,Integer>(s,i1);
			 System.out.println(C1.getPremier());
			 System.out.println(C2.getPremier());
			 System.out.println(C2.getDeuxieme());
			 C2.setDeuxieme(10);
			 System.out.println(C2.getDeuxieme());
			 System.err.println("**********deuxième question**********");
			 int e=8;
			 Scanner scan = new Scanner(new File ("dictionary.txt")); 
			 anagramme(scan,e);
			 System.err.println("**********troisième question**********");
			 ListesTriees(10);
			 System.err.println("\n**********quatrième question**********");
			 comparaisonMots();
			 System.err.println("**********cinquième question**********");
			 Personne nameArray[] = {
					 new Personne(26,"John", "Lennon"),
					 new Personne(32,"Karl", "Marx"),
					 new Personne(19,"Groucho", "Marx"),
					 new Personne(45,"Oscar", "Grouch")
					 };
					 List<Personne> personnes = Arrays.asList(nameArray);
					 Collections.sort(personnes);
					 System.out.println(personnes);
			 }catch(FileNotFoundException e){ 
			 System.err.println("Le fichier n'a pas ete trouve..."); }		 
	}
	
	public static void anagramme(Scanner a,int entier) { 
			String word; 
			while(a.hasNext()){ 
			String alpha = alphabetize(word = a.next()); 
			List<String> l = m.get(alpha); 
			if (l==null) 
				m.put(alpha, l=new ArrayList<String>());
			l.add(word); 
			} 
			for (List<String> l : m.values())
			{ 
			if (l.size() >= entier) 
				System.out.println(l.size() + ": " + l); 
			}
	}
	
	private static String alphabetize(String s){ 
		int count[] = new int[256]; 
		//System.out.println(count[g]);
		int len = s.length(); 
		for (int i=0; i<len; i++) 
		{
			count[s.charAt(i)]++; 
		}
			
		StringBuffer result = new StringBuffer(len); 
		for (char c='a'; c<='z'; c++)
			for (int i=0; i<count[c]; i++) 
				result.append(c); 
		return result.toString(); 
		}
	private static void ListesTriees(int n) {
		 System.out.println("Construction de collection contenant "+n+" nombres entiers");
		 List<Integer> list=new ArrayList<Integer>();
		 TreeSet<Integer> listSet=new TreeSet<Integer>();
		 for(int i=0;i<n;i++)
		 {
			 int tr;
			 Random random=new Random();
			 tr=random.nextInt(1000);
			 list.add(new Integer(tr));
			 listSet.add(new Integer(tr));
		 }
		 Iterator<Integer> iter=list.iterator();
		 while(iter.hasNext())
			 System.out.print(iter.next()+" ");
		 
		 System.out.println("\npremière version ");
		 while(list.size()!=0)
		 {
			 System.out.print(Collections.min(list)+" "); 
			 list.remove(Collections.min(list));
		 }
		 
		 //autre methode pour triee une collection
		  //Collections.sort(list);
		 // System.out.println(list);
		 
		 Iterator<Integer> iterSet=listSet.iterator();
		 System.out.println("\ndeuxième version TreeSet ");
		 while(iterSet.hasNext())
			 System.out.print(iterSet.next()+" ");
	}
	
	private static void comparaisonMots() {
		List<String> listMots=new ArrayList<String>();
		List<String> listtemp=new ArrayList<String>();
		listMots.add("cette");
		listMots.add("chaine");
		listMots.add("avec");
		listMots.add("quelques");
		listMots.add("autres");
		listMots.add("toutes");
		listMots.add("differentes");
		System.out.println("args avant tri:"+listMots);
		Collections.sort(listMots);
		System.out.println("tri lexico:"+listMots);
		//Collections.reverse(listMots);
		//System.out.println("tri inverse lexico:"+listMots);
		String temp = null ;
		int nbcha=Integer.MAX_VALUE;
		int taillelisteMots=listMots.size();
		while(listtemp.size()!=taillelisteMots)
		{
			 for(String e: listMots)
			 {
				 if(e.length()<nbcha)
				 {
					 temp=e;
					 nbcha=e.length();
				 }
				 else if(e.length()==nbcha)
				 {
					 temp=Collections.min(listMots);
				 }
			 }
			 listtemp.add(temp);
			 listMots.remove(temp);
			 nbcha=Integer.MAX_VALUE;
		 //System.err.print( Collections.min(listMots));
		}
		System.out.println("tri militaire:"+listtemp);
		Collections.sort(listtemp);
		Collections.reverse(listtemp);
		System.out.println("tri inverse lexico:"+listtemp);
	}
} 

