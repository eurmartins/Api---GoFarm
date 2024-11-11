package PIMIV.demo.controller;


import PIMIV.demo.entity.EstoquedeMercadoriasEntity;
import PIMIV.demo.entity.FuncionarioEntity;
import PIMIV.demo.model.EstoquedeMercadorias;
import PIMIV.demo.model.Funcionario;
import PIMIV.demo.service.FuncionarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    private Funcionario convertToModel(FuncionarioEntity entity) {
        Funcionario model = new Funcionario();
        model.setNome(entity.getNome());
        model.setCargo(entity.getCargo());
        model.setEmail(entity.getEmail());
        model.setTelefone(entity.getTelefone());
        model.setData_admissao(entity.getData_admissao());
        model.setSalario(entity.getSalario());
        model.setSenha(entity.getSenha());
        return model;
    }


    @PostMapping("CriarFuncionario")
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        boolean isAdded = funcionarioService.adicionarFuncionario(funcionario);
        if (isAdded) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable int id, @RequestBody Funcionario funcionarioAtualizado) {
        FuncionarioEntity funcionarioAtualizadaEntity = funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);

        if (funcionarioAtualizadaEntity != null) {
            Funcionario funcionarioAtualizadaModel = convertToModel(funcionarioAtualizadaEntity);
            return new ResponseEntity<>(funcionarioAtualizadaModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable int id) {
        boolean excluida = funcionarioService.excluirFuncionario(id);

        if (excluida) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String senha) {
        if (funcionarioService.validarLogin(email, senha)) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }

    }

}