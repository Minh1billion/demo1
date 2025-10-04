package springsecurity2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springsecurity2.entity.Users;
import springsecurity2.repository.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new MyUserService(user);
    }
}
