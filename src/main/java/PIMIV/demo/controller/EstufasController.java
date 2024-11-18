package PIMIV.demo.controller;

import PIMIV.demo.entity.EstufasEntity;
import PIMIV.demo.model.Estufas;
import PIMIV.demo.service.EstufasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estufas")
public class EstufasController {

    @Autowired
    private EstufasService estufasService;

    private Estufas convertToModel(EstufasEntity entity) {
        Estufas model = new Estufas();
        model.setNome(entity.getNome());
        model.setLocalizacao(entity.getLocalizacao());
        return model;
    }

    @PostMapping
    public ResponseEntity<Estufas> criarEstufa(@RequestBody Estufas estufa) {
        EstufasEntity estufasEntity = estufasService.criarEstufa(estufa);
        Estufas novaEstufa = convertToModel(estufasEntity);
        return new ResponseEntity<>(novaEstufa, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMercadoria(@PathVariable int id) {
        boolean excluida = estufasService.excluirEstufa(id);

        if (excluida) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estufas> atualizarEstufas(@PathVariable int id, @RequestBody Estufas estufaAtualizada) {
        EstufasEntity estufaAtualizadaEntity = estufasService.atualizarEstufa(id, estufaAtualizada);

        if (estufaAtualizadaEntity != null) {
            Estufas estufaAtualizadaModel = convertToModel(estufaAtualizadaEntity);
            return new ResponseEntity<>(estufaAtualizadaModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Estufas>> listarEstufas() {
        List<EstufasEntity> estufasEntities = estufasService.mostrarTodasEstufas();
        List<Estufas> estufas = estufasEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
        return new ResponseEntity<>(estufas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Estufas> buscarEstufaPorId(@PathVariable int id) {
        EstufasEntity estufaEntity = estufasService.buscarEstufaPorId(id);
        if (estufaEntity != null) {
            Estufas estufa = convertToModel(estufaEntity);
            return new ResponseEntity<>(estufa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
