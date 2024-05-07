package peaksoft.service.serviceImpl;

import peaksoft.entity.UserProfile;
import peaksoft.repositoryy.repositoryyImpl.UserProfileDaoImpl;
import peaksoft.service.UserProfileService;

import java.time.LocalDate;
import java.util.List;

public class UserProfileServiceImpl implements UserProfileService {
    UserProfileDaoImpl userProfileService = new UserProfileDaoImpl();
    @Override
    public String createUserProfile(UserProfile userProfile) {
        return userProfileService.createUserProfile(userProfile);
    }

    @Override
    public UserProfile getUserProfileById(Long userId) {
        return userProfileService.getUserProfileById(userId);
    }

    @Override
    public String updateUserProfileByEmail(String email, UserProfile newUserProfile) {
        return userProfileService.updateUserProfileByEmail(email,newUserProfile);
    }

    @Override
    public String deleteUserByUserId(Long userId) {
        return userProfileService.deleteUserByUserId(userId);
    }

    @Override
    public List<UserProfile> getUsersRegisteredAfterDay(LocalDate localDate) {
        return userProfileService.getUsersRegisteredAfterDay(localDate);
    }
}
