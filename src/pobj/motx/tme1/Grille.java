package pobj.motx.tme1;

/**
 * Classe représentant une grille de mots croisés.
 * 表示单词交叉网格的类。
 */
public class Grille {
    /** La grille composée de cases. */
    /** 由格子组成的网格。 */
    private Case[][] grille;

    /**
     * Construit une grille avec les dimensions spécifiées.
     * 使用指定的尺寸构造一个网格。
     * 
     * @param hauteur la hauteur de la grille
     * @param largeur la largeur de la grille
     */
    public Grille(int hauteur, int largeur) {
        grille = new Case[hauteur][largeur];
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grille[i][j] = new Case(i, j, ' ');
            }
        }
    }

    /**
     * Récupère la case à la position spécifiée.
     * 获取指定位置的格子。
     * 
     * @param lig la ligne de la case
     * @param col la colonne de la case
     * @return la case à la position spécifiée
     */
    public Case getCase(int lig, int col) {
        return grille[lig][col];
    }

    /**
     * Convertit la grille en une chaîne de caractères.
     * 将网格转换为字符串。
     * 
     * @return la représentation textuelle de la grille
     */
    public String toString() {
        return GrilleLoader.serialize(this, false);
    }

    /**
     * Récupère le nombre de lignes de la grille.
     * 获取网格的行数。
     * 
     * @return le nombre de lignes
     */
    public int nbLig() {
        return grille.length;
    }

    /**
     * Récupère le nombre de colonnes de la grille.
     * 获取网格的列数。
     * 
     * @return le nombre de colonnes
     */
    public int nbCol() {
        return grille[0].length;
    }

    /**
     * Crée une copie de la grille.
     * 创建网格的副本。
     * 
     * @return une nouvelle grille avec les mêmes valeurs que l'original
     */
    public Grille copy() {
        Grille copy = new Grille(nbLig(), nbCol());
        for (int i = 0; i < nbLig(); i++) {
            for (int j = 0; j < nbCol(); j++) {
                copy.getCase(i, j).setChar(getCase(i, j).getChar());
            }
        }
        return copy;
    }
    
    public Case[][] getGrille() {
    	return grille;
    }
}
