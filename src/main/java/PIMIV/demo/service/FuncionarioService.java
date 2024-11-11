package PIMIV.demo.service;

import PIMIV.demo.entity.FuncionarioEntity;
import PIMIV.demo.model.Funcionario;
import PIMIV.demo.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FuncionarioService {


    private final FuncionarioRepository funcionarioRepository;


    public boolean adicionarFuncionario(Funcionario funcionario) {

        FuncionarioEntity entity = new FuncionarioEntity();
        entity.setNome(funcionario.getNome());
        entity.setTelefone(funcionario.getTelefone());
        entity.setCargo(funcionario.getCargo());
        entity.setSalario(funcionario.getSalario());
        entity.setData_admissao(funcionario.getData_admissao());
        entity.setEmail(funcionario.getEmail());
        entity.setSenha(funcionario.getSenha());
        funcionarioRepository.save(entity);

        return true;
    }


    public boolean excluirFuncionario(int id) {
        Optional<FuncionarioEntity> funcionario = funcionarioRepository.findById((int) id);
        if(funcionario.isPresent()){
            funcionarioRepository.delete(funcionario.get());
            return true;
        }
        return false;
    }


    public FuncionarioEntity atualizarFuncionario(int id, Funcionario funcionarioAtualizado) {
        Optional<FuncionarioEntity> funcionarioExistente = funcionarioRepository.findById((int) id);
        if(funcionarioExistente.isPresent()){
            FuncionarioEntity funcionario = funcionarioExistente.get();
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setSalario(funcionarioAtualizado.getSalario());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setSenha(funcionarioAtualizado.getSenha());
            funcionario.setEmail(funcionarioAtualizado.getEmail());
            funcionario.setData_admissao(funcionarioAtualizado.getData_admissao());
            funcionario.setTelefone(funcionario.getTelefone());
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }


    public List<FuncionarioEntity> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public boolean validarLogin(String email, String senha) {
        Optional<FuncionarioEntity> funcionario = funcionarioRepository.findByEmailAndSenha(email, senha);
        return funcionario.isPresent();
    }
}
