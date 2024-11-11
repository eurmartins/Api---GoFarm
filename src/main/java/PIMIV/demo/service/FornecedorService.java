package PIMIV.demo.service;

import PIMIV.demo.entity.FornecedoresEntity;
import PIMIV.demo.repository.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedoresRepository fornecedoresRepository;


    private FornecedoresEntity convertToEntity(FornecedoresEntity fornecedores){
        FornecedoresEntity entity = new FornecedoresEntity();
        entity.setNome(fornecedores.getNome());
        entity.setContato(fornecedores.getContato());
        entity.setTelefone(fornecedores.getTelefone());
        entity.setEndereco(fornecedores.getEndereco());
        entity.setHistorico_pedidos(fornecedores.getHistorico_pedidos());
        return entity;
    }



    public FornecedoresEntity criarFornecedor(FornecedoresEntity fornecedor) {
        FornecedoresEntity entity = convertToEntity(fornecedor);
        return fornecedoresRepository.save(entity);
    }


    public FornecedoresEntity atualizarFornecedor(int id, FornecedoresEntity fornecedorAtualizado) {
        Optional<FornecedoresEntity> fornecedorExistente = fornecedoresRepository.findById(id);
        if (fornecedorExistente.isPresent()) {
            FornecedoresEntity fornecedor = fornecedorExistente.get();
            fornecedor.setNome(fornecedorAtualizado.getNome());
            fornecedor.setContato(fornecedorAtualizado.getContato());
            fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
            fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
            fornecedor.setHistorico_pedidos(fornecedorAtualizado.getHistorico_pedidos());
            return fornecedoresRepository.save(fornecedor);
        }
        return null;
    }


    public boolean excluirFornecedor(int id) {
        Optional<FornecedoresEntity> fornecedor = fornecedoresRepository.findById(id);
        if (fornecedor.isPresent()) {
            fornecedoresRepository.delete(fornecedor.get());
            return true;
        }
        return false;
    }


    public List<FornecedoresEntity> mostrarTodosFornecedores() {
        return fornecedoresRepository.findAll();
    }
}
