package PIMIV.demo.repository;

import PIMIV.demo.entity.EstoquedeMercadoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoquedeMercadoriasRepository extends JpaRepository<EstoquedeMercadoriasEntity, Long> {
}
