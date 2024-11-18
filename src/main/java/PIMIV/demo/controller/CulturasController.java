package PIMIV.demo.controller;

import PIMIV.demo.entity.CulturasEntity;
import PIMIV.demo.model.Culturas;
import PIMIV.demo.service.CulturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturas")
public class CulturasController {

    @Autowired
    private CulturasService culturasService;

    // Converte a entidade em um modelo para retornar
    private Culturas convertToModel(CulturasEntity entity) {
        Culturas model = new Culturas();
        model.setNome(entity.getNome());
        model.setTipo_cultura(entity.getTipo_cultura());
        model.setRequisitos_solo(entity.getRequisitos_solo());
        model.setRequisitos_agua(entity.getRequisitos_agua());
        model.setIntervalo_temperatura(entity.getIntervalo_temperatura());
        model.setRequisitos_umidade(entity.getRequisitos_umidade());
        model.setPragas_doencas(entity.getPragas_doencas());
        model.setTempo_colheita(entity.getTempo_colheita());
        model.setCiclo_vida(entity.getCiclo_vida());
        return model;
    }


    @PostMapping
    public ResponseEntity<Boolean> criarCultura(@RequestBody CulturasEntity cultura) {
        boolean culturaSalva = culturasService.adicionarCultura(cultura);
        return ResponseEntity.status(HttpStatus.CREATED).body(culturaSalva);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCultura(@PathVariable int id) {
        boolean isDeleted = culturasService.excluirCulturas(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/{id}")
    public ResponseEntity<CulturasEntity> updateCultura(@PathVariable int id, @RequestBody CulturasEntity culturas) {
        CulturasEntity updatedCulturas = culturasService.atualizarCulturas(id, culturas);
        if (updatedCulturas != null) {
            return new ResponseEntity<>(updatedCulturas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/ListarCulturas")
    public ResponseEntity<List<CulturasEntity>> listAllCulturas() {
        List<CulturasEntity> culturas = culturasService.listarCulturas();
        return new ResponseEntity<>(culturas, HttpStatus.OK);
    }


    @GetMapping("/CulturaPorId/{id}")
    public ResponseEntity<Culturas> getCulturaById(@PathVariable int id) {
        Optional<CulturasEntity> culturaEntity = culturasService.procurarCulturaPorId(id);
        if (culturaEntity.isPresent()) {
            Culturas model = convertToModel(culturaEntity.get());
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
