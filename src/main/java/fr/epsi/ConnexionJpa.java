package fr.epsi;

import fr.epsi.entites.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Livre livre = new Livre(1, "La vie est bouche", "Dickens", "Romance", 1997);
            System.out.println(livre);

            em.persist(livre);
            em.getTransaction().commit();
        }
    }
}