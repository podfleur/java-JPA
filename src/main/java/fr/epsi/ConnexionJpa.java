package fr.epsi;

import fr.epsi.entites.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            int empruntId = 1;
            Emprunt emprunt = em.find(Emprunt.class, empruntId);

            if (emprunt != null) {
                System.out.println("Emprunt trouvé : " + emprunt);
                System.out.println("Livres associés : " + emprunt.getLivres());
            } else {
                System.out.println("Aucun emprunt trouvé avec l'ID " + empruntId);
            }

            em.getTransaction().commit();
            em.close();
        }
    }
}
