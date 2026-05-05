package com.example.sgs.controller;

import com.example.sgs.busines.SolicitacaoService;
import com.example.sgs.model.Solicitacao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SolicitacaoController {

    private SolicitacaoService solicitacaoService;

    public SolicitacaoController() throws SQLException {
        solicitacaoService = new SolicitacaoService();
    }

    @GetMapping("/")
    public String listarSolicitacoes(Model model) throws SQLException {
        List<Solicitacao> solicitacaoList = solicitacaoService.listarSolicitacoes();
        model.addAttribute("solicitacaoList", solicitacaoList);

        return "index";
    }
}
