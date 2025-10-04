package springsecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springsecurity.entity.UserInfo;
import springsecurity.repo.UserInfoRepository;

@Service
public record UserService(UserInfoRepository userInfoRepository, PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "Thêm user thành công!";
    }
}
