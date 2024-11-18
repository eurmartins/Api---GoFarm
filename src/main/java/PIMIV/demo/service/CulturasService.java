package PIMIV.demo.service;

import PIMIV.demo.entity.CulturasEntity;
import PIMIV.demo.repository.CulturasRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CulturasService {

    @Autowired
    private final CulturasRepository culturasRepository;


    public boolean adicionarCultura(CulturasEntity culturas) {

        CulturasEntity entity = new CulturasEntity();
        entity.setNome(culturas.getNome());
        entity.setTipo_cultura(culturas.getTipo_cultura());
        entity.setRequisitos_solo(culturas.getRequisitos_solo());
        entity.setRequisitos_agua(culturas.getRequisitos_agua());
        entity.setIntervalo_temperatura(culturas.getIntervalo_temperatura());
        entity.setRequisitos_umidade(culturas.getRequisitos_umidade());
        entity.setPragas_doencas(culturas.getPragas_doencas());
        entity.setTempo_colheita(culturas.getTempo_colheita());
        entity.setCiclo_vida(culturas.getCiclo_vida());
        culturasRepository.save(entity);

        return true;
    }


    public boolean excluirCulturas(int id) {
        Optional<CulturasEntity> culturas = culturasRepository.findById(id);
        if (culturas.isPresent()) {
            culturasRepository.delete(culturas.get());
            return true;
        }
        return false;
    }


    public CulturasEntity atualizarCulturas(int id, CulturasEntity updatedCulturas) {
        Optional<CulturasEntity> existingCulturas = culturasRepository.findById(id);
        if (existingCulturas.isPresent()) {
            CulturasEntity culturas = existingCulturas.get();
            culturas.setNome(updatedCulturas.getNome());
            culturas.setTipo_cultura(updatedCulturas.getTipo_cultura());
            culturas.setCiclo_vida(updatedCulturas.getCiclo_vida());
            culturas.setRequisitos_solo(updatedCulturas.getRequisitos_solo());
            culturas.setRequisitos_agua(updatedCulturas.getRequisitos_agua());
            culturas.setIntervalo_temperatura(updatedCulturas.getIntervalo_temperatura());
            culturas.setRequisitos_umidade(updatedCulturas.getRequisitos_umidade());
            culturas.setPragas_doencas(updatedCulturas.getPragas_doencas());
            culturas.setTempo_colheita(updatedCulturas.getTempo_colheita());
            culturas.setEstufa_id(updatedCulturas.getEstufa_id());
            return culturasRepository.save(culturas);
        }
        return null;
    }


    public List<CulturasEntity> listarCulturas() {
        return culturasRepository.findAll();
    }

    public Optional<CulturasEntity> procurarCulturaPorId(int id) {
        return culturasRepository.findById(id);
    }

}
