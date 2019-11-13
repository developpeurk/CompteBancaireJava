package metier;

import java.util.Date;

public class CompteEpargne extends Compte{
    private double taux;

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(int code, double solde, double taux) {
        super(code, solde);
        this.taux = taux;
    }

    @Override
    public void retirer(double mt) {
        if(mt > solde  ) throw new RuntimeException("Solde insuffisant");
        Retrait r = new Retrait(operations.size()+1, new Date(), mt);
        operations.add(r);
        solde -=mt;
    }

    @Override
    public void updateSolde() {
     solde = solde + ((solde * taux) /100); // solde*(1+taux/100)
    }
}
