package PIMIV.demo.service;

import PIMIV.demo.entity.EstoquedeSementesEntity;
import PIMIV.demo.model.EstoquedeSementes;
import PIMIV.demo.repository.EstoquedeSementesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoquedeSementesService {

    @Autowired
    private EstoquedeSementesRepository estoquedeSementesRepository;


    private EstoquedeSementesEntity convertToEntity(EstoquedeSementes sementes) {
        EstoquedeSementesEntity entity = new EstoquedeSementesEntity();
        entity.setNome(sementes.getNome());
        entity.setTipo_cultura(sementes.getTipo_cultura());
        entity.setQuantidade(sementes.getQuantidade());
        entity.setFornecedor_id(sementes.getFornecedor_id());
        return entity;
    }


    public EstoquedeSementesEntity criarSemente(EstoquedeSementes sementes) {
        EstoquedeSementesEntity entity = convertToEntity(sementes);
        return estoquedeSementesRepository.save(entity);
    }


    public EstoquedeSementesEntity atualizarSemente(int id, EstoquedeSementes sementeAtualizada) {
        Optional<EstoquedeSementesEntity> sementeExistente = estoquedeSementesRepository.findById(id);
        if (sementeExistente.isPresent()) {
            EstoquedeSementesEntity semente = sementeExistente.get();
            semente.setNome(sementeAtualizada.getNome());
            semente.setTipo_cultura(sementeAtualizada.getTipo_cultura());
            semente.setQuantidade(sementeAtualizada.getQuantidade());
            semente.setFornecedor_id(sementeAtualizada.getFornecedor_id());
            return estoquedeSementesRepository.save(semente);
        }
        return null;
    }


    public boolean excluirSemente(int id) {
        Optional<EstoquedeSementesEntity> semente = estoquedeSementesRepository.findById(id);
        if (semente.isPresent()) {
            estoquedeSementesRepository.delete(semente.get());
            return true;
        }
        return false;
    }


    public List<EstoquedeSementesEntity> mostrarTodasSementes() {
        return estoquedeSementesRepository.findAll();
    }
}
