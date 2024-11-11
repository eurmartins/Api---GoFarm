package PIMIV.demo.repository;


import PIMIV.demo.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
    Optional<FuncionarioEntity> findByEmailAndSenha(String email, String senha);

}
