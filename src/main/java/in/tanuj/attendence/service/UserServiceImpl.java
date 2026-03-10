package in.tanuj.attendence.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.tanuj.attendence.entity.UserEntity;
import in.tanuj.attendence.model.User;
import in.tanuj.attendence.repository.UserServiceRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserServiceRepository userRepository;

    @Override
    public String registerUser(User user) {
        UserEntity userEntity = new UserEntity();
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "user already exists";
        }
        userEntity.setEmail(user.getEmail().toLowerCase());
        userEntity.setPassword(user.getPassword());
        userRepository.save(userEntity);
        return "user registered successfully";
    }


    @Override
    public String loginUser(User user) {
        Optional<UserEntity> userDB = userRepository.findByEmail(user.getEmail().toLowerCase());
        if(userDB.isPresent()){
            if(userDB.get().getPassword().equals(user.getPassword()))
                return "login successful";
            else
                return "invalid password";
        }
        return "user not found";
    }
    
}
