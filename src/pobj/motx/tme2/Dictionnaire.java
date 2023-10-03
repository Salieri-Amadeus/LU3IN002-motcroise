package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme3.EnsembleLettre;

/**
 * 一个词汇集。
 * Un ensemble de mots.
 */
public class Dictionnaire {

	// 存储单词
	// stockage des mots
	private List<String> mots = new ArrayList<>();

	/**
	 * 向词典中添加一个单词，放在最后一个位置。
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * 词典的大小，即它包含的单词数量。
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 */
	public int size() {
		return mots.size();
	}
	
	/**
	 * 访问词典中的第i个单词。
	 * Accès au i-eme mot du dictionnaire.
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * 返回此词典的副本。
	 * Rend une copie de ce Dictionnaire.
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * 删除长度不正好为"len"的单词。
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * 注意：此操作会修改词典，使用copy()过滤之前，以免丢失信息。
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}
	
	/**
	 * 从文件加载词典。
	 * Charge un dictionnaire depuis un fichier.
	 */
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dic = new Dictionnaire();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    for (String line = br.readLine(); line != null; line = br.readLine()) {
		        dic.mots.add(line);
		    }
		} catch (IOException e) {
		    // 文件访问问题。
		    // Problème d’accès au fichier.
		    e.printStackTrace();
		}
		return dic;
	}
	
	/**
	 * 根据字母和位置过滤单词。
	 * Filtre les mots selon une lettre et une position.
	 */
	public int filtreParLettre(char c, int i) {
		List<String> cible = new ArrayList<String>();
		int cpt = 0;
		for(String mot : mots) {
			if(mot.charAt(i) == c) {
				cible.add(mot);
			}
			else {
				cpt++;
			}
		}
		mots = cible;
		return cpt;
	}

	/*根据EnsembleLettre 过滤单词 */

	public int filtreParEnsembleLettre(EnsembleLettre el, int i){
		List<String> cible = new ArrayList<String>();
		int cpt = 0;
		for(String mot : mots) {
			if(el.contains(mot.charAt(i))) {
				cible.add(mot);
			}
			else {
				cpt++;
			}
		}
		mots = cible;
		return cpt;
	}

	/**
	 * 返回词典的字符串表示。
	 * Renvoie une représentation en chaîne du dictionnaire.
	 */
	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}

	public EnsembleLettre getLettres(int i) {
		EnsembleLettre res = new EnsembleLettre();
		for(String mot : mots) {
			res.add(mot.charAt(i));
		}
		return res;
	}
	
	public List<String> getMots(){
		return mots;
	}
	
}
