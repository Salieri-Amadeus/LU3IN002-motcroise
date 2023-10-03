package pobj.motx.tme2;

import java.util.*;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;

/**
 * 表示一个潜在的格子。
 * Représente une grille potentielle.
 */
public class GrillePotentiel {
	
	protected GrillePlaces gp;
	protected Dictionnaire dic;
	private List<Dictionnaire> motsPot;
	
	/**
	 * 构造函数，初始化一个潜在的格子。
	 * Constructeur qui initialise une grille potentielle.
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		gp = grille;
		dic = dicoComplet;
		motsPot = new ArrayList<Dictionnaire>();
		for(Emplacement em : grille.getPlaces()) {
			int length = em.size();
			Dictionnaire dic2 = dic.copy();
			dic2.filtreLongueur(length);
			for(int i = 0; i < em.size(); i++) {
				if(!(em.getCase(i).isVide())) {
					char tmpc = em.getCase(i).getChar();
					dic2.filtreParLettre(tmpc, i);
				}
			}
			motsPot.add(dic2.copy());
		}
	}
	
	/**
	 * 在指定位置固定一个解决方案。
	 * Fixe une solution à une place spécifiée.
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePlaces gpCible = gp.fixer(m, soluce);
		return new GrillePotentiel(gpCible, dic);
	}
	
	/**
	 * 获取潜在的单词列表。
	 * Obtient la liste des mots potentiels.
	 */
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	
	public GrillePlaces getGrillePlaces() {
		return gp;
	}

	/**
	 * 检查是否存在死亡状态。
	 * Vérifie s'il y a un état mort.
	 */
	public boolean isDead() {
		for(Dictionnaire dic : motsPot) {
			if(dic.size() == 0) {
				return true;
			}
		}
		return false;
	}
}
