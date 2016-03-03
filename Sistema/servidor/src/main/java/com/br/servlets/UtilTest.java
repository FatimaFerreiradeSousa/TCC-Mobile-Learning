package com.br.servlets;

import com.br.entidades.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import com.br.util.FotosServices;

/**
 *
 * @author Diego
 */
public class UtilTest {

    private static JSONObject jSONObject;
    private static JSONParser parser;

    public UtilTest() {
    }

    public static JSONObject getJSON(String json) {

        jSONObject = new JSONObject(json);
        return jSONObject;
    }

    public static String streamToString(InputStream is) throws IOException {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0) {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }

    public static JSONObject getJSONTurma(Turma turma) throws IOException {

        jSONObject = new JSONObject();
        jSONObject.put("nome", turma.getNome());
        jSONObject.put("categoria", turma.getCategoria());
        jSONObject.put("codigo", turma.getCodigo());
        jSONObject.put("dataInicio", turma.getDataInicio());
        jSONObject.put("dataTerminio", turma.getDataTerminio());
        Professor professor = new Professor();
        professor.setNome(turma.getProfessor().getNome());
        jSONObject.put("professor", professor);

        return jSONObject;
    }

    public static JSONObject getJSONObject(Aluno json) throws IOException {

        jSONObject = new JSONObject();
        jSONObject.put("nome", json.getSobrenome());
        jSONObject.put("sobrenome", json.getNome());
        jSONObject.put("login", json.getLogin());
        jSONObject.put("senha", json.getSenha());
        jSONObject.put("instituicao", json.getInstituicao());
        jSONObject.put("descricao", json.getDescricao());
        jSONObject.put("foto", FotosServices.converteArquivoEmStringBase64(json.getFoto()));
        jSONObject.put("email", json.getEmail());
        jSONObject.put("curso", json.getCurso());

        return jSONObject;
    }

}
