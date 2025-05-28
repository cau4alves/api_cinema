package br.com.api_cinema.api_cinema.modules.user.repository;

import br.com.api_cinema.api_cinema.modules.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByUsernameOrEmail(String username, String email);
}
