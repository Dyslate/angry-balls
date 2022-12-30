package maladroit.vues;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.Vector;

import maladroit.modele.BilleMaladroit;


/**
 * responsable du dessin des billes
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public class BillardMaladroit extends Canvas
{
Vector<BilleMaladroit> billes;
    public BillardMaladroit(Vector<BilleMaladroit> billes)
    {
this.billes = billes;
    }
    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics graphics)
    {
    int i;
    
    for ( i = 0; i < this.billes.size(); ++i)
        this.billes.get(i).dessine(graphics);
    
    //System.out.println("billes dans le billard = " + billes);
    }

    
 
}
