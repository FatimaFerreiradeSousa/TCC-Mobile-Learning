package com.br.controladores;

import com.br.datas.FormatData;
import com.br.entidades.Anotacao;
import com.br.entidades.Professor;
import com.br.fachada.Fachada;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fatinha
 */
@ManagedBean(name = "controladorListAnt")
@SessionScoped
public class ControladorListAnt implements Serializable {

    @EJB
    private Fachada fachada;
    private List<Anotacao> anotacoes;
    private ExternalContext context;
    private HttpSession session;

    private Anotacao ant1;
    private Anotacao ant2;
    private Anotacao ant3;
    private Anotacao ant4;

    public ControladorListAnt() {
        ant1 = new Anotacao();
        ant2 = new Anotacao();
        ant3 = new Anotacao();
        ant4 = new Anotacao();
        anotacoes = new ArrayList();
    }

    public Anotacao getAnt1() throws ParseException{
        lembretes();
        this.context = FacesContext.getCurrentInstance().getExternalContext();
        this.session = (HttpSession) context.getSession(false);
        this.anotacoes = (List<Anotacao>) this.session.getAttribute("anotacoes");
        return ant1 = this.anotacoes.get(0);
    }

    public void setAnt1(Anotacao ant1) {
        this.ant1 = ant1;
    }

    public Anotacao getAnt2() throws ParseException{
        lembretes();
        this.context = FacesContext.getCurrentInstance().getExternalContext();
        this.session = (HttpSession) context.getSession(false);
        this.anotacoes = (List<Anotacao>) this.session.getAttribute("anotacoes");
        return ant2 = this.anotacoes.get(1);
    }

    public void setAnt2(Anotacao ant2) {
        this.ant2 = ant2;
    }

    public Anotacao getAnt3() throws ParseException{
        lembretes();
        this.context = FacesContext.getCurrentInstance().getExternalContext();
        this.session = (HttpSession) context.getSession(false);
        this.anotacoes = (List<Anotacao>) this.session.getAttribute("anotacoes");
        return ant3 = this.anotacoes.get(2);
    }

    public void setAnt3(Anotacao ant3) {
        this.ant3 = ant3;
    }

    public Anotacao getAnt4() throws ParseException{
        lembretes();
        this.context = FacesContext.getCurrentInstance().getExternalContext();
        this.session = (HttpSession) context.getSession(false);
        this.anotacoes = (List<Anotacao>) this.session.getAttribute("anotacoes");
        return ant4 = this.anotacoes.get(3);
    }

    public void setAnt4(Anotacao ant4) {
        this.ant4 = ant4;
    }

    public List<Anotacao> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<Anotacao> anotacoes) {
        this.anotacoes = anotacoes;
    }
    
    public String lembretes() throws ParseException {
        this.context = FacesContext.getCurrentInstance().getExternalContext();
        this.session = (HttpSession) context.getSession(false);
        Professor professorLogado = (Professor) this.session.getAttribute("usuario");

        List<Anotacao> ant = fachada.listarAnotacao(professorLogado);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = dateFormat.parse("18/05/2015");
        this.anotacoes = FormatData.comparaData(data, ant);
        context.getSessionMap().put("anotacoes", this.anotacoes);
        return null;
    }

}
