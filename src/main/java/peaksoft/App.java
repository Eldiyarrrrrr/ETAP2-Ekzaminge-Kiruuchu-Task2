package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.UserDetails;
import peaksoft.entity.UserProfile;
import peaksoft.service.UserDetailsService;
import peaksoft.service.UserProfileService;
import peaksoft.service.serviceImpl.UserDetailsServiceImpl;
import peaksoft.service.serviceImpl.UserProfileServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HibernateConfig.getEntityManagerFactory();
        UserDetailsService userDetailsService = new UserDetailsServiceImpl();
        UserProfileService userProfileService = new UserProfileServiceImpl();

//       userProfileService.createUserProfile(new UserProfile("Ali","ali","22-22-22"));
        // System.out.println(userProfileService.getUserProfileById(1L));
        // System.out.println(userProfileService.updateUserProfileByEmail("ali", new UserProfile("ali", "Bek", "20-0-0-014")));
        // System.out.println(userProfileService.deleteUserByUserId(1L));

        // System.out.println(userDetailsService.createUserDetails(1L, new UserDetails("ali", LocalDate.of(2003, 4, 14), "akman")));
        //  System.out.println(userDetailsService.getUserByAddress("akman"));
        //  System.out.println(userDetailsService.getUserDetailsById(1L));
        //  System.out.println(userDetailsService.updateUserDetailsById(1L, new UserDetails("Eldiar", LocalDate.of(2005, 4, 19), "chuy")));
        //  System.out.println(userDetailsService.deleteUserDetails(1L));
    }
}