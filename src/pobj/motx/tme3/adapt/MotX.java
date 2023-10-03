package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.csp.*;

public class MotX implements ICSP{
	
	private List<DicoVariable> dvs;
	private GrilleContrainte gc;
	
	/**
	 * 构造函数
	 * Constructeur
	 *
	 * @param gc 网格约束
	 * @param gc Contrainte de Grille
	 */
	public MotX(GrilleContrainte gc) {
		this.dvs = new ArrayList<DicoVariable>();
		for(int i = 0; i < gc.getMotsPot().size(); i++) {
			this.dvs.add(new DicoVariable(i, gc));
		}
		this.gc = gc;
	}
	
	/**
	 * 获取变量列表
	 * Obtient la liste des variables
	 * 
	 * @return Liste des variables
	 */
	public List<IVariable> getVars(){
		List<IVariable> cible = new ArrayList<IVariable>();
		for(DicoVariable dv : dvs) {
			cible.add(dv);
		}
		return cible;
	}

	/**
	 * 检查是否一致
	 * Vérifie si c'est cohérent
	 * 
	 * @return true si c'est cohérent, false sinon
	 */
	public boolean isConsistent() {
		return !gc.isDead();
	}

	/**
	 * 分配一个变量并返回一个新的CSP
	 * Attribue une valeur et retourne un nouveau CSP
	 * 
	 * @param vi 变量
	 * @param val 要分配的值
	 * @param vi Variable
	 * @param val Valeur à attribuer
	 * @return un nouveau CSP ou null si vi n'est pas une instance de DicoVariable
	 */
	public ICSP assign(IVariable vi, String val) {
		if(vi instanceof DicoVariable){
			DicoVariable dv = (DicoVariable)vi;
			GrilleContrainte gcNew = gc.fixerAvecRemove(dv.getId(), val);
			

			MotX mx =  new MotX(gcNew);
			
			return mx;
		}
		return null;
	}
}
