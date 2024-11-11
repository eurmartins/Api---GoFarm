package PIMIV.demo.controller;

import PIMIV.demo.entity.EstoquedeMercadoriasEntity;
import PIMIV.demo.model.EstoquedeMercadorias;
import PIMIV.demo.service.EstoquedeMercadoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mercadorias")
public class EstoquedeMercadoriasController {

    @Autowired
    private EstoquedeMercadoriasService estoquedeMercadoriasService;


    private EstoquedeMercadorias convertToModel(EstoquedeMercadoriasEntity entity) {
        EstoquedeMercadorias model = new EstoquedeMercadorias();
        model.setNome(entity.getNome());
        model.setTipo_cultura(entity.getTipo_cultura());
        model.setQuantidade_por_caixa(entity.getQuantidade_por_caixa());
        model.setQuantidade_caixas(entity.getQuantidade_caixas());
        model.setData_colheita(entity.getData_colheita());
        model.setPreco(entity.getPreco());
        return model;
    }

    @PostMapping
    public ResponseEntity<EstoquedeMercadorias> criarMercadoria(@RequestBody EstoquedeMercadorias mercadoria) {
        EstoquedeMercadoriasEntity novaMercadoriaEntity = estoquedeMercadoriasService.criarMercadorias(mercadoria);
        EstoquedeMercadorias novaMercadoria = convertToModel(novaMercadoriaEntity);
        return new ResponseEntity<>(novaMercadoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoquedeMercadorias> atualizarMercadoria(@PathVariable int id, @RequestBody EstoquedeMercadorias mercadoriasAtualizada) {

        EstoquedeMercadoriasEntity mercadoriaAtualizadaEntity = estoquedeMercadoriasService.atualizarMercadorias(id, mercadoriasAtualizada);

        if (mercadoriaAtualizadaEntity != null) {
            EstoquedeMercadorias mercadoriaAtualizada = convertToModel(mercadoriaAtualizadaEntity);
            return new ResponseEntity<>(mercadoriaAtualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMercadoria(@PathVariable int id) {
        boolean excluida = estoquedeMercadoriasService.excluirMercadorias(id);

        if (excluida) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<EstoquedeMercadorias>> listarMercadorias() {
        List<EstoquedeMercadoriasEntity> mercadoriasEntities = estoquedeMercadoriasService.mostrarTodasMercadorias();
        List<EstoquedeMercadorias> mercadorias = mercadoriasEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
        return new ResponseEntity<>(mercadorias, HttpStatus.OK);
    }
}
