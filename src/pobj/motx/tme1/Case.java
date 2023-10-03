package pobj.motx.tme1;

/**
 * Classe représentant une case dans une grille de mots croisés.
 * 表示单词交叉网格中的一个格子的类。
 */
public class Case {
    /** Ligne de la case dans la grille. */
    /** 格子在网格中的行。 */
    private int lig;
    /** Colonne de la case dans la grille. */
    /** 格子在网格中的列。 */
    private int col;
    /** Valeur de la case (caractère). */
    /** 格子的值（字符）。 */
    private char value;

    /**
     * Construit une case avec les coordonnées et la valeur spécifiées.
     * 使用指定的坐标和值构造一个格子。
     * 
     * @param lig   la ligne de la case
     * lig   格子的行
     * @param col   la colonne de la case
     * col   格子的列
     * @param value la valeur de la case
     * value 格子的值
     */
    public Case(int lig, int col, char value) {
        this.col = col;
        this.lig = lig;
        this.value = value;
    }

    /**
     * Récupère la ligne de la case.
     * 获取格子的行。
     * 
     * @return la ligne de la case
     * 格子的行
     */
    public int getLig() {
        return lig;
    }

    /**
     * Récupère la colonne de la case.
     * 获取格子的列。
     * 
     * @return la colonne de la case
     * 格子的列
     */
    public int getCol() {
        return col;
    }

    /**
     * Récupère la valeur de la case.
     * 获取格子的值。
     * 
     * @return le caractère de la case
     * 格子的字符
     */
    public char getChar() {
        return value;
    }

    /**
     * Définit la valeur de la case.
     * 设置格子的值。
     * 
     * @param c le nouveau caractère de la case
     * c 格子的新字符
     */
    public void setChar(char c) {
        value = c;
    }

    /**
     * Vérifie si la case est vide (contient un espace).
     * 检查格子是否为空（包含一个空格）。
     * 
     * @return vrai si la case est vide, faux sinon
     * 如果格子为空则返回true，否则返回false
     */
    public boolean isVide() {
        return value == ' ';
    }

    /**
     * Vérifie si la case est pleine (contient un '*').
     * 检查格子是否为满（包含一个'*'）。
     * 
     * @return vrai si la case est pleine, faux sinon
     * 如果格子为满则返回true，否则返回false
     */
    public boolean isPleine() {
        return value == '*';
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Case){
            Case c = (Case) o;
            return c.getLig() == lig && c.getCol() == col;
        }
        return false;
    }
}
