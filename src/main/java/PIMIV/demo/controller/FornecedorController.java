package PIMIV.demo.controller;

import PIMIV.demo.entity.FornecedoresEntity;
import PIMIV.demo.model.Fornecedores;
import PIMIV.demo.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;


    private Fornecedores convertToModel(FornecedoresEntity entity){
        Fornecedores model = new Fornecedores();
        model.setId_fornecedor(entity.getId_fornecedor());
        model.setNome(entity.getNome());
        model.setContato(entity.getContato());
        model.setTelefone(entity.getTelefone());
        model.setEndereco(entity.getEndereco());
        model.setHistorico_pedidos(entity.getHistorico_pedidos());
        return model;
    }


    private FornecedoresEntity convertToEntity(Fornecedores model) {
        FornecedoresEntity entity = new FornecedoresEntity();
        entity.setId_fornecedor(model.getId_fornecedor());
        entity.setNome(model.getNome());
        entity.setContato(model.getContato());
        entity.setTelefone(model.getTelefone());
        entity.setEndereco(model.getEndereco());
        entity.setHistorico_pedidos(model.getHistorico_pedidos());
        return entity;
    }

    @PostMapping("/criarFornecedor")
    public ResponseEntity<Fornecedores> criarFornecedor(@RequestBody Fornecedores fornecedor) {
        FornecedoresEntity fornecedorEntity = convertToEntity(fornecedor);
        FornecedoresEntity novoFornecedorEntity = fornecedorService.criarFornecedor(fornecedorEntity);
        Fornecedores novoFornecedor = convertToModel(novoFornecedorEntity);
        return new ResponseEntity<>(novoFornecedor, HttpStatus.CREATED);
    }

    @PutMapping("/atualizarFornecedor/{id}")
    public ResponseEntity<Fornecedores> atualizarFornecedor(@PathVariable int id, @RequestBody Fornecedores fornecedoresAtualizada) {
        FornecedoresEntity fornecedoresAtualizadaEntity = convertToEntity(fornecedoresAtualizada);
        FornecedoresEntity fornecedoresAtualizadaResult = fornecedorService.atualizarFornecedor(id, fornecedoresAtualizadaEntity);

        if (fornecedoresAtualizadaResult != null) {
            Fornecedores fornecedoresAtualizadaModel = convertToModel(fornecedoresAtualizadaResult);
            return new ResponseEntity<>(fornecedoresAtualizadaModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/excluirFornecedor/{id}")
    public ResponseEntity<Void> excluirFornecedor(@PathVariable int id) {
        boolean excluido = fornecedorService.excluirFornecedor(id);
        if (excluido) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listarFornecedor")
    public ResponseEntity<List<Fornecedores>> listarTodosFornecedores() {
        List<FornecedoresEntity> fornecedoresEntities = fornecedorService.mostrarTodosFornecedores();
        List<Fornecedores> fornecedores = fornecedoresEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }
}
