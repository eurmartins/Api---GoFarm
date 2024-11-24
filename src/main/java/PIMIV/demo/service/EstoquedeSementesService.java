package PIMIV.demo.service;

import PIMIV.demo.entity.EstoquedeSementesEntity;
import PIMIV.demo.entity.FornecedoresEntity;
import PIMIV.demo.model.EstoquedeSementes;
import PIMIV.demo.model.Fornecedores;
import PIMIV.demo.repository.EstoquedeSementesRepository;
import PIMIV.demo.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoquedeSementesService {

    @Autowired
    private EstoquedeSementesRepository estoquedeSementesRepository;

    @Autowired
    private FornecedoresRepository fornecedoresRepository; // Adicione esta linha

    private EstoquedeSementesEntity convertToEntity(EstoquedeSementes sementes) {
        EstoquedeSementesEntity entity = new EstoquedeSementesEntity();
        entity.setNome(sementes.getNome());
        entity.setTipo_cultura(sementes.getTipo_cultura());
        entity.setQuantidade(sementes.getQuantidade());

        FornecedoresEntity fornecedor = fornecedoresRepository.findById(sementes.getFornecedor().getId_fornecedor())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado com ID: " + sementes.getFornecedor().getId_fornecedor()));

        entity.setFornecedor(fornecedor);
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
            semente.setFornecedor(semente.getFornecedor());
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

    public EstoquedeSementesEntity procurarPorId(int id) {
        Optional<EstoquedeSementesEntity> semente = estoquedeSementesRepository.findById(id);
        return semente.orElse(null);
    }
}
