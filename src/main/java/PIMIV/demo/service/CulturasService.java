package PIMIV.demo.service;

import PIMIV.demo.entity.CulturasEntity;
import PIMIV.demo.entity.EstufasEntity;
import PIMIV.demo.repository.CulturasRepository;
import PIMIV.demo.repository.EstufasRepository;
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

    private final EstufasRepository estufasRepository;


    public CulturasEntity cadastrarCultura(CulturasEntity cultura) {

        EstufasEntity estufa = estufasRepository.findById(cultura.getEstufa().getId_estufa())
                .orElseThrow(() -> new RuntimeException("Estufa não encontrada com ID: " + cultura.getEstufa().getId_estufa()));
        cultura.setEstufa(estufa);
        return culturasRepository.save(cultura);
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
            culturas.setEstufa(updatedCulturas.getEstufa());
            return culturasRepository.save(culturas);
        }
        return null;
    }


    public List<CulturasEntity> listarCulturas() {
        return culturasRepository.findAll();
    }

    public CulturasEntity procurarCulturaPorId(int id) {
        Optional<CulturasEntity> cultura = culturasRepository.findById(id);
        return cultura.orElse(null);
    }

}
