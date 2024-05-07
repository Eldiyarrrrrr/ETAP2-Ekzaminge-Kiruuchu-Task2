package peaksoft.service.serviceImpl;

import peaksoft.entity.UserDetails;
import peaksoft.repositoryy.repositoryyImpl.UserDetailsDaoImpl;
import peaksoft.service.UserDetailsService;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
    UserDetailsDaoImpl userDetailsService = new UserDetailsDaoImpl();
    @Override
    public String createUserDetails(Long user_Id, UserDetails userDetails) {
        return userDetailsService.createUserDetails(user_Id,userDetails);
    }

    @Override
    public UserDetails getUserDetailsById(Long id) {
        return userDetailsService.getUserDetailsById(id);
    }

    @Override
    public String updateUserDetailsById(Long user_id, UserDetails newUserDetails) {
        return userDetailsService.updateUserDetailsById(user_id,newUserDetails);
    }

    @Override
    public String deleteUserDetails(Long user_id) {
        return userDetailsService.deleteUserDetails(user_id);
    }

    @Override
    public UserDetails getUserByAddress(String address) {
        return userDetailsService.getUserByAddress(address);
    }

    @Override
    public List<UserDetails> sortByUserDateOfBirth() {
        return userDetailsService.sortByUserDateOfBirth();
    }
}
