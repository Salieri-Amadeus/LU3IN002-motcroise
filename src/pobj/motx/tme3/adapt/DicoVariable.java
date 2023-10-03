package pobj.motx.tme3.adapt;

import java.util.List;
import pobj.motx.tme3.*;
import pobj.motx.tme3.csp.*;

public class DicoVariable implements IVariable{
	private int index;
	private GrilleContrainte gp;
	
	/**
	 * 构造函数
	 * Constructeur
	 * 
	 * @param index 索引
	 * @param gp 网格约束
	 */
	public DicoVariable(int index, GrilleContrainte gp) {
		this.index = index;
		this.gp = gp;
	}
	
	/**
	 * 获取可能的单词列表
	 * Obtient la liste des mots possibles
	 * 
	 * @return Liste des mots possibles
	 */
	public List<String> getDomain(){
		return this.gp.getMotsPot().get(index).getMots();
	}

	/**
	 * 将对象转换为字符串表示
	 * Convertit l'objet en une représentation string
	 * 
	 * @return Représentation de la chaîne de l'objet
	 */
	public String toString(){
		return gp.getMotsPot().get(index).toString();
	}

	/**
	 * 获取变量的ID或索引
	 * Obtient l'ID ou l'index de la variable
	 * 
	 * @return Index de la variable
	 */
	public int getId(){
		return index;
	}
}
