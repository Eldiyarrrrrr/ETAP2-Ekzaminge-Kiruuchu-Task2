package peaksoft.repositoryy.repositoryyImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.UserDetails;
import peaksoft.entity.UserProfile;
import peaksoft.repositoryy.UserDetailsDao;

import java.util.List;

public class UserDetailsDaoImpl implements UserDetailsDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public String createUserDetails(Long user_Id, UserDetails userDetails) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class, user_Id);
            userProfile.setUserDetails(userDetails);
            userDetails.setProfile(userProfile);
            entityManager.persist(userDetails);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return e.getMessage();
        }
        return "successfully saved";
    }

    @Override
    public UserDetails getUserDetailsById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            return entityManager.find(UserDetails.class, id);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateUserDetailsById(Long user_id, UserDetails newUserDetails) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            UserDetails userDetails = entityManager.find(UserDetails.class, user_id);
            userDetails.setFull_name(newUserDetails.getFull_name());
            userDetails.setDate_of_birth(newUserDetails.getDate_of_birth());
            userDetails.setAddress(newUserDetails.getAddress());
            entityManager.merge(userDetails);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteUserDetails(Long user_id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            UserDetails userDetails = entityManager.find(UserDetails.class, user_id);
            entityManager.remove(userDetails);
            entityManager.getTransaction().commit();
            return "Success Delete";
        } catch (HibernateException e) {
            return e.getMessage();

        }

    }

    @Override
    public UserDetails getUserByAddress(String address) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            List<UserDetails> resultList = entityManager.createQuery("select u from UserDetails u where address = :address")
                    .setParameter("address", address)
                    .getResultList();
            return resultList.get(0);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<UserDetails> sortByUserDateOfBirth() {
        List<UserDetails> userDetails = null;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            userDetails = entityManager.createQuery("select u from UserDetails  u order by u.date_of_birth desc", UserDetails.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userDetails;
    }
}