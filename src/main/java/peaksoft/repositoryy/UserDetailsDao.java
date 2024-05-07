package peaksoft.repositoryy;

import peaksoft.entity.UserDetails;

import java.util.List;

public interface UserDetailsDao {
    String createUserDetails(Long user_Id, UserDetails userDetails);
    UserDetails getUserDetailsById(Long id);
    String updateUserDetailsById(Long user_id,UserDetails newUserDetails);
    String deleteUserDetails(Long user_id);
    UserDetails getUserByAddress(String address);
    List<UserDetails> sortByUserDateOfBirth();
}