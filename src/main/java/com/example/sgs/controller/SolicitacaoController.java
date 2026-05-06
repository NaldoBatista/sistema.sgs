package com.example.sgs.controller;

import com.example.sgs.busines.CategoriaService;
import com.example.sgs.busines.SolicitacaoService;
import com.example.sgs.busines.SolicitanteService;
import com.example.sgs.model.Categoria;
import com.example.sgs.model.Solicitacao;
import com.example.sgs.model.Solicitante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SolicitacaoController {

    private SolicitacaoService solicitacaoService;
    private SolicitanteService solicitanteService;
    private CategoriaService categoriaService;

    public SolicitacaoController() throws SQLException {
        solicitacaoService = new SolicitacaoService();
        solicitanteService = new SolicitanteService();
        categoriaService = new CategoriaService();
    }

    @GetMapping("/")
    public String listarSolicitacoes(Model model) throws SQLException {
        List<Solicitacao> solicitacaoList = solicitacaoService.consultarSolicitacoes();
        model.addAttribute("solicitacaoList", solicitacaoList);

        return "solicitacao/listar";
    }

    @GetMapping("solicitacao/nova")
    public String novaSolicitacao(Model model) throws SQLException {
        List<Solicitante> solicitanteList = solicitanteService.consultarSolicitantes();
        List<Categoria> categoriaList = categoriaService.consultarCategorias();

        model.addAttribute("solicitanteList", solicitanteList);
        model.addAttribute("categoriaList", categoriaList);

        return "solicitacao/nova";
    }
}
