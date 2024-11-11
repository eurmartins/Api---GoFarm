package PIMIV.demo.repository;

import PIMIV.demo.entity.EstoquedeSementesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoquedeSementesRepository extends JpaRepository<EstoquedeSementesEntity, Integer> {
}
