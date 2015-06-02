package br.eti.victorsoares.aula04.Model;

import java.util.Calendar;
import java.util.List;

/**
 * Created by vsoares on 27/05/15.
 */
public class Emprestimo {

    private long id;
    private Calendar dataEmprestimo;
    private Calendar dataDevolucao;
    private Calendar dataPrevistaDevolucao;
    private Pessoa emprestou;
    private Pessoa pegouEmprestado;
    private ListaItens listaItens;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Calendar dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Calendar getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(Calendar dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public Pessoa getEmprestou() {
        return emprestou;
    }

    public void setEmprestou(Pessoa emprestou) {
        this.emprestou = emprestou;
    }

    public Pessoa getPegouEmprestado() {
        return pegouEmprestado;
    }

    public void setPegouEmprestado(Pessoa pegouEmprestado) {
        this.pegouEmprestado = pegouEmprestado;
    }

    public ListaItens getListaDeitens() {
        return listaItens;
    }

    public void setListaDeitens(ListaItens listaDeitens) {
        this.listaItens = listaDeitens;
    }
}
