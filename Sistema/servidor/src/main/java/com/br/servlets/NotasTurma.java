package com.br.servlets;

import com.br.dao.Dao;
import com.br.entidades.Horario;
import com.br.entidades.Nota;
import com.br.entidades.Turma;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author Fatinha de Sousa
 */
@WebServlet(name = "NotasTurma", urlPatterns = {"/NotasTurma"})
public class NotasTurma extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Dao dao = new Dao();
        Turma turma = dao.buscarTurma("GEO-2016");

        List<Nota> notas = new ArrayList<>();

        for (Nota nota : turma.getNotas()) {

            Nota n = new Nota();
            n.setDataNota(nota.getDataNota());
            n.setDesenvolvimento(nota.getDesenvolvimento());
            n.setId(nota.getId());
            n.setIntroducao(nota.getIntroducao());
            n.setProfessor(n.getProfessor());
            n.setTitulo(nota.getTitulo());

            notas.add(n);
        }

        JSONArray jsonArray = new JSONArray(notas);

        OutputStream os = response.getOutputStream();
        os.write(jsonArray.toString().getBytes());

        os.flush();
        os.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
