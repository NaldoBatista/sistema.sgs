package com.example.sgs.controller;

import com.example.sgs.busines.CategoriaService;
import com.example.sgs.busines.SolicitacaoService;
import com.example.sgs.busines.SolicitanteService;
import com.example.sgs.filtro.SolicitacaoFiltros;
import com.example.sgs.model.Categoria;
import com.example.sgs.model.Solicitacao;
import com.example.sgs.model.Solicitante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SolicitacaoController {

    final private String MENSAGEM = "mensagem";

    private SolicitacaoService solicitacaoService;
    private SolicitanteService solicitanteService;
    private CategoriaService categoriaService;

    public SolicitacaoController() throws SQLException {
        solicitacaoService = new SolicitacaoService();
        solicitanteService = new SolicitanteService();
        categoriaService = new CategoriaService();
    }

    @GetMapping("solicitacao/listar")
    public String listarSolicitacoes(
            SolicitacaoFiltros solicitacaoFiltros
            , Model model
            , RedirectAttributes redirectAttributes
    ) {
        try {
            List<Solicitacao> solicitacaoList = solicitacaoService
                    .consultarSolicitacoesPorFiltros(solicitacaoFiltros);
            List<Solicitante> solicitanteList = solicitanteService.consultarSolicitantes();
            List<Categoria> categoriaList = categoriaService.consultarCategorias();

            model.addAttribute("solicitacaoFiltros", solicitacaoFiltros);
            model.addAttribute("solicitanteList", solicitanteList);
            model.addAttribute("categoriaList", categoriaList);
            model.addAttribute("solicitacaoList", solicitacaoList);
        } catch (SQLException e) {
            redirectAttributes.addFlashAttribute(MENSAGEM, e.getMessage());
        }

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

    @PostMapping("solicitacao/cadastrar")
    public String cadastraSolicitacao(Solicitacao solicitacao, RedirectAttributes redirectAttributes) {
        String mensagem = "Solicitação cadastrada como sucesso!";

        try {
            solicitacaoService.cadastrarSolicitacao(solicitacao);
        } catch (SQLException e) {
            mensagem = e.getMessage();
        }

        redirectAttributes.addFlashAttribute(MENSAGEM, mensagem);

        return "redirect:/solicitacao/listar";
    }

    @GetMapping("solicitacao/editar/{solicitacaoId}")
    public String editarSolicitacao(@PathVariable Integer solicitacaoId, Model model, RedirectAttributes redirectAttributes) {
        try {
            Solicitacao solicitacao = solicitacaoService.consultarSolicitacaoPorId(solicitacaoId);
            List<Solicitante> solicitanteList = solicitanteService.consultarSolicitantes();
            List<Categoria> categoriaList = categoriaService.consultarCategorias();

            model.addAttribute("solicitacao", solicitacao);
            model.addAttribute("solicitanteList", solicitanteList);
            model.addAttribute("categoriaList", categoriaList);
        } catch (SQLException e) {
            redirectAttributes.addFlashAttribute(MENSAGEM, e.getMessage());
            return "redirect:/solicitacao/listar";
        }

        return "solicitacao/editar";
    }

    @PostMapping("/solicitacao/atualizar")
    public String atualizarSolicitacao(Solicitacao solicitacao, RedirectAttributes redirectAttributes) {
        String mensagem = "Solicitação atualizada como sucesso!";

        try {
            solicitacaoService.atualizarSolicitacao(solicitacao);
        } catch (SQLException e) {
            mensagem = e.getMessage();
        }

        redirectAttributes.addFlashAttribute(MENSAGEM, mensagem);

        return "redirect:/solicitacao/listar";
    }

    @GetMapping("solicitacao/remover/{solicitacaoId}")
    public String removerSolicitacao(@PathVariable int solicitacaoId, RedirectAttributes redirectAttributes) {
        String mensagem = "Solicitação removida com sucesso!";

        try {
            solicitacaoService.removerSolicitacao(solicitacaoId);
        } catch (SQLException e) {
            mensagem = e.getMessage();
        }

        redirectAttributes.addFlashAttribute(MENSAGEM, mensagem);

        return "redirect:/solicitacao/listar";
    }
}
