package vues;


/**
 * contrat respecte par toute vue capable de dessiner la liste des billes
 * 
 * Comme ea si vous n'aimez pas mes composants awt vous pouvez les changer sans changer le reste de l'appli
 * 
 *  ICI : IL N'Y A RIEN A CHANGER 
 *  
 * 
 * */
public interface VueBillard
{

double largeurBillard();

double hauteurBillard();

void miseAJour();

void montrer();
}
