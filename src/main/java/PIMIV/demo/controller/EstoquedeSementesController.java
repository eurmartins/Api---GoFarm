package PIMIV.demo.controller;

import PIMIV.demo.entity.EstoquedeSementesEntity;
import PIMIV.demo.model.EstoquedeSementes;
import PIMIV.demo.service.EstoquedeSementesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sementes")
public class EstoquedeSementesController {


    @Autowired
    private EstoquedeSementesService estoquedeSementesService;


    @PostMapping
    public ResponseEntity<EstoquedeSementesEntity> criarSemente(@RequestBody EstoquedeSementes semente) {
        EstoquedeSementesEntity novaSemente = estoquedeSementesService.criarSemente(semente);
        return new ResponseEntity<>(novaSemente, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EstoquedeSementesEntity> atualizarSemente(
            @PathVariable int id,
            @RequestBody EstoquedeSementes sementeAtualizada) {
        EstoquedeSementesEntity semente = estoquedeSementesService.atualizarSemente(id, sementeAtualizada);
        if (semente != null) {
            return new ResponseEntity<>(semente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSemente(@PathVariable int id) {
        boolean excluido = estoquedeSementesService.excluirSemente(id);
        if (excluido) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public ResponseEntity<List<EstoquedeSementesEntity>> mostrarTodasSementes() {
        List<EstoquedeSementesEntity> sementes = estoquedeSementesService.mostrarTodasSementes();
        return new ResponseEntity<>(sementes, HttpStatus.OK);
    }
}
