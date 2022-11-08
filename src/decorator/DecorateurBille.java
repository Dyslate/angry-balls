package decorator;


import modele.Bille;

public abstract class DecorateurBille extends BilleDynamique {
    protected BilleDynamique billeDynamique;



    protected DecorateurBille(Bille b) {
        super(b);
        this.billeDynamique = (BilleDynamique) b;
    }
}
