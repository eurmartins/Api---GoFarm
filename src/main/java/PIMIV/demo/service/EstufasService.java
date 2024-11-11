package PIMIV.demo.service;

import PIMIV.demo.entity.EstufasEntity;
import PIMIV.demo.model.Estufas;
import PIMIV.demo.repository.EstufasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstufasService {

    @Autowired
    private EstufasRepository estufasRepository;

    private EstufasEntity convertToEntity(Estufas estufas){
        EstufasEntity entity = new EstufasEntity();
        entity.setNome(estufas.getNome());
        entity.setLocalizacao(estufas.getLocalizacao());
        return entity;
    }


    public EstufasEntity criarEstufa(Estufas estufas){
        EstufasEntity entity = convertToEntity(estufas);
        return estufasRepository.save(entity);
    }

    public EstufasEntity atualizarEstufa(int id, Estufas estufaAtualizada){
        Optional<EstufasEntity> estufaExistente =  estufasRepository.findById((int) id);
        if(estufaExistente.isPresent()){
            EstufasEntity estufa = estufaExistente.get();
            estufa.setNome(estufaAtualizada.getNome());
            estufa.setLocalizacao(estufa.getLocalizacao());
            return estufasRepository.save(estufa);
        }
        return null;
    }


    public boolean excluirEstufa(int id) {
        Optional<EstufasEntity> estufas = estufasRepository.findById((int) id);
        if (estufas.isPresent()) {
            estufasRepository.delete(estufas.get());
            return true;
        }
        return false;
    }


    public List<EstufasEntity> mostrarTodasEstufas() {
        return estufasRepository.findAll();
    }
}
