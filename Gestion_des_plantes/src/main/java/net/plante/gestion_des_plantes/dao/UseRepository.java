package net.plante.gestion_des_plantes.dao;

import net.plante.gestion_des_plantes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UseRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByName(String name);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByNameContains(String keyword);
}
