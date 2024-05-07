package peaksoft.repositoryy.repositoryyImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.UserProfile;
import peaksoft.repositoryy.UserProfileDao;

import java.time.LocalDate;
import java.util.List;

public class UserProfileDaoImpl implements UserProfileDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public String createUserProfile(UserProfile userProfile) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(userProfile);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return "Success";
    }

    @Override
    public UserProfile getUserProfileById(Long userId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            return entityManager.find(UserProfile.class, userId);
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String updateUserProfileByEmail(String email, UserProfile newUserProfile) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.createQuery("select u from UserProfile u where u.email=:email", UserProfile.class).setParameter("email",email)
                    .getSingleResult();
            userProfile.setUserName(newUserProfile.getUserName());
            userProfile.setEmail(newUserProfile.getEmail());
            userProfile.setRegistration_date(newUserProfile.getRegistration_date());
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "successfully updated";
    }

    @Override
    public String deleteUserByUserId(Long userId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            UserProfile userProfile = entityManager.find(UserProfile.class, userId);
            entityManager.remove(userProfile);
            entityManager.getTransaction().commit();
            return "Success delete!";
        }catch (HibernateException e){
            return e.getMessage();
        }
    }

    @Override
    public List<UserProfile> getUsersRegisteredAfterDay(LocalDate localDate) {

        return null;
    }
}