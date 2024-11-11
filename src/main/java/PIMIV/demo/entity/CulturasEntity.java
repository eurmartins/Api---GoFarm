package PIMIV.demo.entity;

import PIMIV.demo.model.Estufas;
import jakarta.persistence.*;

    @Entity
    @Table(name = "culturas")
    public class CulturasEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id_cultura;

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false)
        private String tipo_cultura;

        @Column(nullable = false)
        private String ciclo_vida;

        @Column(nullable = false)
        private String requisitos_solo;

        @Column(nullable = false)
        private String requisitos_agua;

        @Column(nullable = false)
        private String intervalo_temperatura;

        @Column(nullable = false)
        private String requisitos_umidade;

        @Column(nullable = false)
        private String pragas_doencas;

        @Column(nullable = false)
        private int tempo_colheita;

        @ManyToOne
        @JoinColumn(name = "id_estufa", nullable = true)
        private EstufasEntity estufa_id;

        public CulturasEntity(){
        }

        public int getId_cultura() {
            return id_cultura;
        }

        public void setId_cultura(int id_cultura) {
            this.id_cultura = id_cultura;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTipo_cultura() {
            return tipo_cultura;
        }

        public void setTipo_cultura(String tipo_cultura) {
            this.tipo_cultura = tipo_cultura;
        }

        public String getCiclo_vida() {
            return ciclo_vida;
        }

        public void setCiclo_vida(String ciclo_vida) {
            this.ciclo_vida = ciclo_vida;
        }

        public String getRequisitos_solo() {
            return requisitos_solo;
        }

        public void setRequisitos_solo(String requisitos_solo) {
            this.requisitos_solo = requisitos_solo;
        }

        public String getRequisitos_agua() {
            return requisitos_agua;
        }

        public void setRequisitos_agua(String requisitos_agua) {
            this.requisitos_agua = requisitos_agua;
        }

        public String getIntervalo_temperatura() {
            return intervalo_temperatura;
        }

        public void setIntervalo_temperatura(String intervalo_temperatura) {
            this.intervalo_temperatura = intervalo_temperatura;
        }

        public String getRequisitos_umidade() {
            return requisitos_umidade;
        }

        public void setRequisitos_umidade(String requisitos_umidade) {
            this.requisitos_umidade = requisitos_umidade;
        }

        public String getPragas_doencas() {
            return pragas_doencas;
        }

        public void setPragas_doencas(String pragas_doencas) {
            this.pragas_doencas = pragas_doencas;
        }

        public int getTempo_colheita() {
            return tempo_colheita;
        }

        public void setTempo_colheita(int tempo_colheita) {
            this.tempo_colheita = tempo_colheita;
        }

        public EstufasEntity getEstufa_id() {
            return estufa_id;
        }

        public void setEstufa_id(EstufasEntity estufa_id) {
            this.estufa_id = estufa_id;
        }
}
