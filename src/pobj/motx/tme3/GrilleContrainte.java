package pobj.motx.tme3;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;
import pobj.motx.tme2.*;

public class GrilleContrainte extends GrillePotentiel{
    private List<IContrainte> contraintes;

    /**
     * 构造函数
     * Constructeur
     *
     * @param grille 一个包含单词位置的格子
     * @param dicoComplet 一个包含可能单词的完整字典
     */
    public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
        super(grille, dicoComplet);
        contraintes = new ArrayList<IContrainte>();
        detecterContraintes(grille);
        propage();
    }
    

    /**
     * 检测约束
     * Détecter les contraintes
     *
     * @param grille 一个包含单词位置的格子
     */
    private void detecterContraintes(GrillePlaces grille) {
        // [Commentaire similaire ci-dessous]
        List<Emplacement> emplacements = grille.getPlaces();

        for (int m1 = 0; m1 < grille.getNbHorizontal(); m1++) {
            Emplacement horiz = emplacements.get(m1);

            for (int m2 = grille.getNbHorizontal(); m2 < emplacements.size(); m2++) {
                Emplacement vert = emplacements.get(m2);

                for (int c1 = 0; c1 < horiz.size(); c1++) {
                    Case ch = horiz.getCase(c1);
                    if (!ch.isVide()) continue;

                    for (int c2 = 0; c2 < vert.size(); c2++) {
                        Case cv = vert.getCase(c2);

                        if (ch.equals(cv)) {
                            contraintes.add(new CroixContrainte(m1, c1, m2, c2));
                        }
                    }
                }
            }
        }
    }

    /**
     * 固定单词
     * Fixer un mot
     *
     * @param m 单词的索引
     * @param soluce 单词的解决方案
     * @return 一个固定了单词的GrilleContrainte
     * @return Un GrilleContrainte avec le mot fixé
     */
    public GrilleContrainte fixer(int m, String soluce) {
        GrillePlaces gpCible = gp.fixer(m, soluce);
        return new GrilleContrainte(gpCible, dic);
    }

    public GrilleContrainte fixerAvecRemove(int m, String soluce) {
        GrillePlaces gpCible = gp.fixerAvecRemove(m, soluce);
        return new GrilleContrainte(gpCible, dic);
    }


    /**
     * 获取约束列表
     * Obtenir la liste des contraintes
     *
     * @return 约束列表
     * @return La liste des contraintes
     */
    public List<IContrainte> getContraintes(){
        return contraintes;
    }

    /**
     * 扩散约束
     * Propagation des contraintes
     *
     * @return 如果没有死亡，则为true，否则为false
     * @return vrai si pas de mort, faux sinon
     */
    public boolean propage() {
    	int cpt = 0;
    	while(true) {
    		cpt = 0;
    		for(IContrainte ic : contraintes) {
    			cpt += ic.reduce(this);
    		}
    		if(cpt == 0) return true;
    		if(isDead()) return false;
    	}
    }
}
