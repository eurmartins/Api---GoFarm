package PIMIV.demo.repository;

import PIMIV.demo.entity.EstufasEntity;
import PIMIV.demo.entity.FornecedoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedoresRepository extends JpaRepository<FornecedoresEntity, Integer> {
}
