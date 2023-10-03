package pobj.motx.tme3;

import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;

public class CroixContrainte implements IContrainte {
    private int m1;
    private int m2;
    private int c1;
    private int c2;

    /**
     * 构造函数
     * Constructeur
     *
     * @param m1 第一个单词的索引
     * @param c1 第一个单词中的字符的索引
     * @param m2 第二个单词的索引
     * @param c2 第二个单词中的字符的索引
     */
    public CroixContrainte(int m1, int c1, int m2, int c2) {
        this.m1 = m1;
        this.m2 = m2;
        this.c1 = c1;
        this.c2 = c2;
    }

    /**
     * 约简潜在的单词表格
     * Réduit la grille des mots potentiels
     * 
     * @param grille 潜在的单词表格
     * @param grille Grille des mots potentiels
     * @return Réduction du nombre
     */
    public int reduce(GrillePotentiel grille){
        Dictionnaire d1 = grille.getMotsPot().get(m1);
        Dictionnaire d2 = grille.getMotsPot().get(m2);
    
        EnsembleLettre el1  = d1.getLettres(c1); 
        EnsembleLettre el2  = d2.getLettres(c2); 
    
        EnsembleLettre elInter = el1.intersection(el2); 
    
        int nbReduce = 0;
    
        if(el1.size() > elInter.size()){
            nbReduce += d1.filtreParEnsembleLettre(elInter, c1);
        }
        if(el2.size() > elInter.size()){
            nbReduce += d2.filtreParEnsembleLettre(elInter, c2);
        }
        return nbReduce;
    }
    

    /**
     * 比较对象是否相等
     * Compare si les objets sont égaux
     * 
     * @param o 要比较的对象
     * @param o Objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    public boolean equals(Object o){
        if(o instanceof CroixContrainte){
            CroixContrainte cc = (CroixContrainte)o;
            return m1 == cc.m1 && m2 == cc.m2 && c1 == cc.c1 && c2 == cc.c2;
        }
        return false;
    }

    /**
     * 返回对象的字符串表示形式
     * Retourne une représentation de la chaîne de l'objet
     * 
     * @return Représentation de la chaîne de l'objet
     */
    public String toString(){
        return "CroixContrainte: m1=" + m1 + ", c1=" + c1 + ", m2=" + m2 + ", c2=" + c2;
    }
}
