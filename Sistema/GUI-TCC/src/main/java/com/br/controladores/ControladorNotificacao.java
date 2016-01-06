package com.br.controladores;

import com.br.entidades.Notificacao;
import com.br.fachada.Fachada;
import com.br.sessao.PegarUsuarioSessao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Fatinha de Sousa
 */
@Named(value = "controladorNotificacao")
@SessionScoped
public class ControladorNotificacao implements Serializable {

    @EJB
    private Fachada fachada;

    public ControladorNotificacao() {
    }

    public String marcarComVisto(Notificacao notificacao) {
        fachada.marcarComLido(notificacao);

        return "page-inicial-aluno?faces-redirect=true";
    }

    /*Notificacoes aluno*/
    public List<Notificacao> notificacoesNaoLidasAluno() {
        return fachada.notificacoesNaoLidas(PegarUsuarioSessao.pegarAlunoSessao().getLogin());
    }

    public List<Notificacao> listarNotificacoesAluno() {
        return fachada.listarNotificacoes(PegarUsuarioSessao.pegarAlunoSessao().getLogin());
    }

    public List<Notificacao> registroAluno() {
        return fachada.atividadesAluno(PegarUsuarioSessao.pegarAlunoSessao().getLogin());
    }

    /*Notificações professor*/
    public List<Notificacao> notificacoesNaoLidasProfessor() {
        return fachada.notificacoesNaoLidasProfessor(PegarUsuarioSessao.pegarProfessorSessao().getLogin());
    }

    public List<Notificacao> listarNotificacoesProfessor() {
        return fachada.notificacoesProfessor(PegarUsuarioSessao.pegarProfessorSessao().getLogin());
    }

    public List<Notificacao> registroProfessor() {
        return fachada.atividadesProfessor(PegarUsuarioSessao.pegarProfessorSessao().getLogin());
    }
}