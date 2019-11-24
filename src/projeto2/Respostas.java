package projeto2;

import java.io.Serializable;

public class Respostas implements Serializable {

    private String nome;
    private String resposta;
    public Questoes q;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

}
