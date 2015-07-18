package com.br.interfaces;

import com.br.entidades.Comentario;
import com.br.entidades.Topico;
import java.util.List;

/**
 *
 * @author Fatinha de Sousa
 */
public interface InterfaceDaoTopico {

    public boolean salvar(Topico topico);
    
    public boolean atualizar(Topico topico);
    
    public Topico consultar(String codigo);
    
    public boolean remover(Topico topico);
    
    public List<Comentario> comentariosTopico(int codigoTopico);
    
    public List<Topico> listarTestesGrupo(int codigoGrupo);
    
}