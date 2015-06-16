package br.eti.victorsoares.aula04.Model;

import java.util.Calendar;

/**
 * Created by samuel on 16/06/15.
 */
public class ItensEmprestadosParaMin {
    private long cod_item;
    private long cod_usuario;
    private long cod_amigo;
    private Calendar data_emprestimo;
    private Calendar data_devolucao;
    private String status_emprestimo;

    public long getCod_item() {
        return cod_item;
    }

    public void setCod_item(long cod_item) {
        this.cod_item = cod_item;
    }

    public long getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(long cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public long getCod_amigo() {
        return cod_amigo;
    }

    public void setCod_amigo(long cod_amigo) {
        this.cod_amigo = cod_amigo;
    }

    public Calendar getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Calendar data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public Calendar getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Calendar data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getStatus_emprestimo() {
        return status_emprestimo;
    }

    public void setStatus_emprestimo(String status_emprestimo) {
        this.status_emprestimo = status_emprestimo;
    }
}
