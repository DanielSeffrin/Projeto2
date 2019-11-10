package projeto2;

import java.io.Serializable;

public class Questoes implements Serializable{

    private int numero;
    private String descricao;
    private String altA;
    private String altB;
    private String altC;
    private String altD;
    private String altE;
    private String resposta;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        while (numero == 0) {
            System.out.println("Número já existe!");
        }
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        while (descricao.length() == 0) {
            System.out.println("Descrição não pode ser vazia!");
        }
        this.descricao = descricao;
    }

    public String getAltA() {
        return altA;
    }

    public void setAltA(String altA) {
        while (altA.length() == 0) {
            System.out.println("Alternativa não pode ser vazia!");
        }
        this.altA = altA;
    }

    public String getAltB() {
        return altB;
    }

    public void setAltB(String altB) {
        while (altB.length() == 0) {
            System.out.println("Alternativa não pode ser vazia!");
        }
        this.altB = altB;
    }

    public String getAltC() {
        return altC;
    }

    public void setAltC(String altC) {
        while (altC.length() == 0) {
            System.out.println("Alternativa não pode ser vazia!");
        }
        this.altC = altC;
    }

    public String getAltD() {
        return altD;
    }

    public void setAltD(String altD) {
        while (altD.length() == 0) {
            System.out.println("Alternativa não pode ser vazia!");
        }
        this.altD = altD;
    }

    public String getAltE() {
        return altE;
    }

    public void setAltE(String altE) {
        while (altE.length() == 0) {
            System.out.println("Alternativa não pode ser vazia!");
        }
        this.altE = altE;
    }    
    
    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
//        if (!resposta.equals("a") && !resposta.equals("b") && !resposta.equals("c") && (!resposta.equals("d")) && !resposta.equals("e")) {
//            System.out.println("Resposta inválida, digite novamente!");
//        }
        this.resposta = resposta;
    }


}
