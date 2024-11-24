package PIMIV.demo.controller;

import PIMIV.demo.entity.CulturasEntity;
import PIMIV.demo.model.Culturas;
import PIMIV.demo.model.Estufas;
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
        model.setEstufa(Estufas.builder()
                .nome(entity.getEstufa().getNome())
                .localizacao(entity.getEstufa().getLocalizacao())
                .id_estufas(entity.getEstufa().getId_estufa())
                .build());
        return model;
    }


    @PostMapping
    public ResponseEntity<CulturasEntity> cadastrarCultura(@RequestBody CulturasEntity cultura) {
        CulturasEntity novaCultura = culturasService.cadastrarCultura(cultura);
        return ResponseEntity.ok(novaCultura);
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


    @GetMapping("/{id}")
    public ResponseEntity<Culturas> getCulturaById(@PathVariable int id) {
        CulturasEntity culturaEntity = culturasService.procurarCulturaPorId(id);
        if (culturaEntity != null) {
            Culturas model = convertToModel(culturaEntity);
            return new ResponseEntity<>(model, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
