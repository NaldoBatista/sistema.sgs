package com.example.sgs.enumerate;

import com.example.sgs.enumerate.status.*;

import java.util.ArrayList;
import java.util.List;

public class StatusSolicitacaoEnum {
    private static final List<StatusSolicitacaoInterface> statusSolicitacaoList = new ArrayList<>();

    public static List<StatusSolicitacaoInterface> getStatusSolicitacaoList() {
        if (!statusSolicitacaoList.isEmpty()) {
            return statusSolicitacaoList;
        }

        statusSolicitacaoList.add(new Solicitado());
        statusSolicitacaoList.add(new Liberado());
        statusSolicitacaoList.add(new Aprovado());
        statusSolicitacaoList.add(new Rejeitado());
        statusSolicitacaoList.add(new Cancelado());

        return statusSolicitacaoList;
    }

    public static StatusSolicitacaoInterface getStatusById(int statusId) {
        for (StatusSolicitacaoInterface status : getStatusSolicitacaoList()) {
            if (status.getId() == statusId) {
                return status;
            }
        }

        throw new RuntimeException("Status de ID:" + statusId + " não encontrado.");
    }
}
