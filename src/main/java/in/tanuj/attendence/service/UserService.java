package in.tanuj.attendence.service;

import in.tanuj.attendence.model.User;

public interface UserService {
    String registerUser(User user);
    String loginUser(User user);

}
