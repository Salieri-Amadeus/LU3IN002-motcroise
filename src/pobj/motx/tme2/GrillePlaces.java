package pobj.motx.tme2;
import java.util.*;
import pobj.motx.tme1.*;

/**
 * 表示一个格子的位置集合。
 * Représente un ensemble de places dans une grille.
 */
public class GrillePlaces {
	private List<Emplacement> places = new ArrayList<Emplacement>();
	private Grille grille;
	private int nbHorizontal = 0;
	
	/**
	 * 构造函数，初始化一个格子的位置集合。
	 * Constructeur qui initialise un ensemble de places dans une grille.
	 */
	public GrillePlaces(Grille grille) {
		this.grille = grille;
		for(int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		
		for(int j = 0; j < grille.nbCol(); j++) {
			cherchePlaces(getCol(j));
		}
	}

	public GrillePlaces(Grille grille, boolean removeFilledEmplacementsOrNot){
		this(grille);
		if (removeFilledEmplacementsOrNot) {
			removeFilledEmplacements();
		}
	}

	public void removeFilledEmplacements() {
		List<Emplacement> toRemove = new ArrayList<>();
	
		for (Emplacement e : places) {
			boolean isFilled = true;
			for (Case c : e.getCases()) {
				if (c.isVide()) {
					isFilled = false;
					break;
				}
			}
			if (isFilled) {
				toRemove.add(e);
				if (e.getCase(0).getLig() == e.getCase(1).getLig()) {
					nbHorizontal--;  // 如果是水平的，减少水平计数
				}
			}
		}
	
		places.removeAll(toRemove);
	}
	
	
	/**
	 * 获取位置集合。
	 * Obtient la liste des places.
	 */
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	/**
	 * 获取水平位置的数量。
	 * Obtient le nombre de places horizontales.
	 */
	public int getNbHorizontal() {
		return nbHorizontal;
	}
	
	/**
	 * 获取指定行的所有格子。
	 * Obtient toutes les cases d'une ligne spécifiée.
	 */
	private List<Case> getLig(int lig){
		ArrayList<Case> ligne = new ArrayList<Case>();
		int nbCol = grille.nbCol();
		for(int i = 0; i < nbCol; i++) {
			ligne.add(grille.getCase(lig, i));
		}
		return ligne;
	}
	
	/**
	 * 获取指定列的所有格子。
	 * Obtient toutes les cases d'une colonne spécifiée.
	 */
	private List<Case> getCol(int col){
		ArrayList<Case> colonne = new ArrayList<Case>();
		int nbLig = grille.nbLig();
		for(int i = 0; i < nbLig; i++) {
			colonne.add(grille.getCase(i, col));
		}
		return colonne;
	}
	
	
	/**
	 * 在给定的格子列表中查找位置。
	 * Cherche des places dans une liste de cases donnée.
	 */
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for(Case c : cases) {
			
			if(!(c.isPleine())) {
				e.add(c);
			}
			else if(c.isPleine()) {
				if(e.size() >= 2) {
					places.add(e);
					if(e.getCase(0).getLig() == e.getCase(1).getLig()) {
						nbHorizontal++;
					}
				}
				e = new Emplacement();
			}
		}
		if(e.size() >= 2) {
			places.add(e);
			if(e.getCase(0).getLig() == e.getCase(1).getLig()) {
				nbHorizontal++;
			}
		}
	}
	
	/**
	 * 在指定位置固定一个解决方案。
	 * Fixe une solution à une place spécifiée.
	 */
	public GrillePlaces fixer(int m, String soluce) {
	    Grille grilleRes = grille.copy();
	    Emplacement emp = places.get(m);
	    for(int i = 0; i < soluce.length(); i++) {
	        char c = soluce.charAt(i);
	        Case caseToUpdate = emp.getCase(i);
	        grilleRes.getCase(caseToUpdate.getLig(), caseToUpdate.getCol()).setChar(c);;
	    }
	    GrillePlaces res =  new GrillePlaces(grilleRes);
		return res;
	}

	public GrillePlaces fixerAvecRemove(int m, String soluce) {
		Grille grilleRes = grille.copy();
	    Emplacement emp = places.get(m);
	    for(int i = 0; i < soluce.length(); i++) {
	        char c = soluce.charAt(i);
	        Case caseToUpdate = emp.getCase(i);
	        grilleRes.getCase(caseToUpdate.getLig(), caseToUpdate.getCol()).setChar(c);;
	    }
	    GrillePlaces res =  new GrillePlaces(grilleRes, true);
		return res;
	}

	public Grille getGrille() {
		return grille;
	}

	/**
	 * 返回位置集合的字符串表示。
	 * Renvoie une représentation en chaîne de l'ensemble des places.
	 */
	public String toString() {
		String str = "";
		for(Emplacement e : places) {
			str += e.toString();
			str += "*\n";
		}
		return str;
	}
}
