package PIMIV.demo.service;

import PIMIV.demo.entity.EstoquedeMercadoriasEntity;
import PIMIV.demo.model.EstoquedeMercadorias;
import PIMIV.demo.repository.EstoquedeMercadoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoquedeMercadoriasService {

    @Autowired
    private EstoquedeMercadoriasRepository estoquedeMercadoriasRepository;

    // Método para converter EstoquedeMercadorias para EstoquedeMercadoriasEntity
    private EstoquedeMercadoriasEntity convertToEntity(EstoquedeMercadorias mercadorias) {
        EstoquedeMercadoriasEntity entity = new EstoquedeMercadoriasEntity();
        entity.setNome(mercadorias.getNome());
        entity.setTipo_cultura(mercadorias.getTipo_cultura());
        entity.setQuantidade_por_caixa(mercadorias.getQuantidade_por_caixa());
        entity.setQuantidade_caixas(mercadorias.getQuantidade_caixas());
        entity.setData_colheita(mercadorias.getData_colheita());
        entity.setPreco(mercadorias.getPreco());
        return entity;
    }

    public EstoquedeMercadoriasEntity criarMercadorias(EstoquedeMercadorias mercadorias) {
        EstoquedeMercadoriasEntity entity = convertToEntity(mercadorias);
        return estoquedeMercadoriasRepository.save(entity);
    }

    public EstoquedeMercadoriasEntity atualizarMercadorias(int id, EstoquedeMercadorias mercadoriasAtualizada) {
        Optional<EstoquedeMercadoriasEntity> mercadoriasExistente = estoquedeMercadoriasRepository.findById((long) id);
        if (mercadoriasExistente.isPresent()) {
            EstoquedeMercadoriasEntity mercadoria = mercadoriasExistente.get();
            mercadoria.setNome(mercadoriasAtualizada.getNome());
            mercadoria.setTipo_cultura(mercadoriasAtualizada.getTipo_cultura());
            mercadoria.setQuantidade_por_caixa(mercadoriasAtualizada.getQuantidade_por_caixa());
            mercadoria.setQuantidade_caixas(mercadoriasAtualizada.getQuantidade_caixas());
            mercadoria.setData_colheita(mercadoriasAtualizada.getData_colheita());
            mercadoria.setPreco(mercadoriasAtualizada.getPreco());
            return estoquedeMercadoriasRepository.save(mercadoria);
        }
        return null;
    }

    public boolean excluirMercadorias(int id) {
        Optional<EstoquedeMercadoriasEntity> mercadoria = estoquedeMercadoriasRepository.findById((long) id);
        if (mercadoria.isPresent()) {
            estoquedeMercadoriasRepository.delete(mercadoria.get());
            return true;
        }
        return false;
    }

    public List<EstoquedeMercadoriasEntity> mostrarTodasMercadorias() {
        return estoquedeMercadoriasRepository.findAll();
    }

    public Optional<EstoquedeMercadoriasEntity> procurarMercadoriaPorId(int id) {
        return estoquedeMercadoriasRepository.findById((long) id);
    }

}
