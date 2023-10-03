package pobj.motx.tme1;

import java.util.*;

/**
 * Classe représentant un emplacement dans une grille de mots croisés.
 * 表示单词交叉网格中的位置的类。
 */
public class Emplacement {
    /** Liste des cases qui composent l'emplacement. */
    /** 组成位置的格子列表。 */
    private List<Case> cases;

    /**
     * Construit un emplacement initialement vide.
     * 构造一个初始为空的位置。
     */
    public Emplacement() {
        cases = new ArrayList<Case>();
    }

    /**
     * Ajoute une case à l'emplacement.
     * 将格子添加到位置。
     * 
     * @param e la case à ajouter
     * 要添加的格子
     */
    public void add(Case e) {
        cases.add(e);
    }

    /**
     * Récupère la taille (nombre de cases) de l'emplacement.
     * 获取位置的大小（格子数）。
     * 
     * @return la taille de l'emplacement
     * 位置的大小
     */
    public int size() {
        return this.cases.size();
    }

    /**
     * Récupère la case à l'indice spécifié.
     * 获取指定索引的格子。
     * 
     * @param i l'indice de la case
     * 格子的索引
     * @return la case à l'indice spécifié
     * 指定索引的格子
     */
    public Case getCase(int i) {
        return this.cases.get(i);
    }

    public List<Case> getCases() {
        return cases;
    }

    /**
     * Convertit l'emplacement en une chaîne de caractères.
     * 将位置转换为字符串。
     * 
     * @return la représentation textuelle de l'emplacement
     * 位置的文本表示
     */
    public String toString() {
        String str = "";
        for (Case elt : this.cases) {
            str += elt.getChar();
        }
        return str;
    }
}
