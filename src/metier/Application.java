package metier;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            Compte cp1 = new CompteCourant(1, 8000, 5000);
            Compte cp2 = new CompteEpargne(2, 30000, 5.5);
            cp1.verser(50000);
            cp1.retirer(3000);
            cp1.verser(4000);
            cp1.retirer(7000);
            cp1.virement(400, cp2);

            System.out.println("le solde du compte cp1 : " + cp1.consulterSolde());
            System.out.println("le solde du compte cp2 : " + cp2.consulterSolde());
            System.out.println("---------------------------------------------------");
            List<Operation> listeOperations = cp1.getOperations();
            for (Operation o : listeOperations) {
                System.out.println(o.getClass().getSimpleName() + "--------" + o.getNumero() + "--" + o.getDateOperation() + "--" + o.getMontant());
            }
            System.out.println("le total des versements cp1 : " + cp1.totalVersements());
            System.out.println("le total des retraits cp1 : " + cp1.totalRetraits());
           // cp1.retirer(800000);
            System.out.println("****************************************************");
            System.out.println("Mettre à jour le sode");
            cp1.updateSolde();
            cp2.updateSolde();
            System.out.println("le solde du compte cp1 : " + cp1.consulterSolde());
            System.out.println("le solde du compte cp2 : " + cp2.consulterSolde());
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
