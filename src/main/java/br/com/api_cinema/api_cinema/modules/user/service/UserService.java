package br.com.api_cinema.api_cinema.modules.user.service;

import br.com.api_cinema.api_cinema.modules.user.model.UserModel;
import br.com.api_cinema.api_cinema.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel execute(UserModel userModel) {
        this.userRepository.findByUsernameOrEmail(userModel.getUsername(), userModel.getEmail())
            .ifPresent(
                    (user) -> {
                        throw new RuntimeException("Usuário já encontrado");
                    }
            );

        return this.userRepository.save(userModel);
    }
}
