package com.solutis.selecao.cloneapi;

import com.solutis.selecao.cloneapi.model.Equipamento;
import com.solutis.selecao.cloneapi.service.EquipamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GeradorDeEquipamentos implements CommandLineRunner {

    private EquipamentoService equipamentoService;

    public GeradorDeEquipamentos(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    private final Logger logger = LoggerFactory.getLogger(GeradorDeEquipamentos.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Criando os Equipamentos...");
        equipamentoService.addEquipamento(new Equipamento("esqueleto reforçado"));
        equipamentoService.addEquipamento(new Equipamento("braço mecânico"));
        equipamentoService.addEquipamento(new Equipamento("sentidos aguçados"));
        equipamentoService.addEquipamento(new Equipamento("pele adaptativa"));
        equipamentoService.addEquipamento(new Equipamento("raio laser"));
    }
}
