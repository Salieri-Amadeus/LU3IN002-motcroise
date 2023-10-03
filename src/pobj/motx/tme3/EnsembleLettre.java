package pobj.motx.tme3;

import java.util.*;

public class EnsembleLettre {
    private List<Character> lettres;

    /**
     * 构造函数
     * Constructeur
     */
    public EnsembleLettre(){
        lettres = new ArrayList<Character>();
    }

    /**
     * 判断字符是否存在
     * Vérifie si le caractère est présent
     * 
     * @param c 要检查的字符
     * @param c Caractère à vérifier
     * @return true si le caractère est présent, false sinon
     */
    public boolean contains(char c){
        return lettres.contains(c);
    }

    /**
     * 添加字符
     * Ajoute un caractère
     * 
     * @param c 要添加的字符
     * @param c Caractère à ajouter
     */
    public void add(char c){
        if(!contains(c)){
            lettres.add(c);
        }
    }

    /**
     * 移除字符
     * Supprime un caractère
     * 
     * @param c 要移除的字符
     * @param c Caractère à supprimer
     */
    public void remove(char c){
        if(contains(c)){
            lettres.remove((Character)c);
        }
    }

    /**
     * 获取集合大小
     * Obtient la taille de l'ensemble
     * 
     * @return La taille de l'ensemble
     */
    public int size(){
        return lettres.size();
    }

    /**
     * 交集操作
     * Opération d'intersection
     * 
     * @param el 用于交集操作的集合
     * @param el Ensemble pour l'opération d'intersection
     * @return 交集结果
     * @return Résultat de l'intersection
     */
    public EnsembleLettre intersection(EnsembleLettre el){
        EnsembleLettre res = new EnsembleLettre();
        for(char c : lettres){
            if(el.contains(c)){
                res.add(c);
            }
        }
        return res;
    }

    /**
     * 并集操作
     * Opération d'union
     * 
     * @param el 用于并集操作的集合
     * @param el Ensemble pour l'opération d'union
     * @return 并集结果
     * @return Résultat de l'union
     */
    public EnsembleLettre union(EnsembleLettre el){
        EnsembleLettre res = new EnsembleLettre();
        for(char c : lettres){
            res.add(c);
        }
        for(char c : el.lettres){
            res.add(c);
        }
        return res;
    }

    /**
     * 获取指定位置的字符
     * Obtient le caractère à une position spécifique
     * 
     * @param i 索引位置
     * @param i Index
     * @return 索引位置的字符
     * @return Caractère à la position indexée
     */
    public char get(int i){
        return lettres.get(i);
    }

    /**
     * 获取字符集合
     * Obtient la liste des caractères
     * 
     * @return La liste des caractères
     */
    public List<Character> getLettres(){
        return lettres;
    }
}
