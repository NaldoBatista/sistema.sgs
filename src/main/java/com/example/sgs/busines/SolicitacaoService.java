package com.example.sgs.busines;

import com.example.sgs.enumerate.status.Solicitado;
import com.example.sgs.enumerate.status.StatusSolicitacaoInterface;
import com.example.sgs.filters.SolicitacaoFiltros;
import com.example.sgs.model.Solicitacao;
import com.example.sgs.repository.SolicitacaoDAO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoService {

    final private SolicitacaoDAO solicitacaoDAO;

    public SolicitacaoService() throws SQLException {
        this.solicitacaoDAO = new SolicitacaoDAO();
    }

    public List<Solicitacao> consultarSolicitacoesPorFiltros(SolicitacaoFiltros solicitacaoFiltros) throws SQLException {
        return solicitacaoDAO.findByFilters(solicitacaoFiltros);
    }

    public void cadastrarSolicitacao(Solicitacao solicitacao) throws SQLException {
        StatusSolicitacaoInterface statusInicial = new Solicitado();
        solicitacao.setStatusId(statusInicial.getId());
        solicitacaoDAO.save(solicitacao);
    }

    public Solicitacao consultarSolicitacaoPorId(int solicitacaoId) throws SQLException {
        return solicitacaoDAO.findById(solicitacaoId);
    }

    public void atualizarSolicitacao(Solicitacao solicitacao) throws SQLException {
        validarAlteracaoDeStatus(solicitacao);
        solicitacaoDAO.update(solicitacao);
    }

    public void removerSolicitacao(int solicitacaoId) throws SQLException {
        solicitacaoDAO.remove(solicitacaoId);
    }

    private void validarAlteracaoDeStatus(Solicitacao solicitacao) throws SQLException {
        StatusSolicitacaoInterface statusNovo = solicitacao.getStatus();
        StatusSolicitacaoInterface statusAnterior = solicitacaoDAO
                .findById(solicitacao.getId())
                .getStatus();

        if (statusNovo.getId() == statusAnterior.getId()) {
            return;
        }

        Integer novoStatusId = statusAnterior.transicionarPara(statusNovo).getId();
        solicitacao.setStatusId(novoStatusId);
    }

    public List<String> validarCamposSolicitacao(BindingResult bindingResult) {
        List<String> erroList = new ArrayList<>();

        if (!bindingResult.hasErrors()) {
            return erroList;
        }

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            erroList.add(fieldError.getDefaultMessage());
        }

        return erroList;
    }
}
