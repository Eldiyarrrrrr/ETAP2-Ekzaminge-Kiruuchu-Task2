package peaksoft.repositoryy;

import peaksoft.entity.UserProfile;

import java.time.LocalDate;
import java.util.List;

public interface UserProfileDao {
    String createUserProfile(UserProfile userProfile);
    UserProfile getUserProfileById(Long userId);
    String updateUserProfileByEmail(String email,UserProfile newUserProfile);
    String deleteUserByUserId(Long userId);
    List<UserProfile> getUsersRegisteredAfterDay(LocalDate localDate);
}