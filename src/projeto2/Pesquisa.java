package projeto2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Pesquisa implements Serializable {

    // ArrayList para armazenar as questões
    public ArrayList<Questoes> pesquisa = new ArrayList<>();
    // ArrayList para armazenar as respostas
    public ArrayList<Respostas> lista = new ArrayList<>();
    // Scanner para ler o que for digitado
    public Scanner scanner = new Scanner(System.in);
    // Variável para armazenar o número de entrevistados
    public int qtdEnt;
    // Seta o nome dos arquivos
    public String nomeArquivoQuestoes = "questoes.bin";
    public String nomeArquivoRespostas = "respostas.bin";

    public static void main(String[] args) {
        Pesquisa p = new Pesquisa();

        p.perguntasIniciais();

        File arquivo_questoes = new File(p.nomeArquivoQuestoes);
        File arquivo_respostas = new File(p.nomeArquivoRespostas);

        if (arquivo_questoes.exists()) {
            try {
                FileInputStream arq_questoes = new FileInputStream(p.nomeArquivoQuestoes);
                ObjectInputStream objetoEntradaR = new ObjectInputStream(arq_questoes);
                p.pesquisa = (ArrayList<Questoes>) objetoEntradaR.readObject();
                objetoEntradaR.close();
                arq_questoes.close();
                p.menu();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            p.menu();
        }

        if (arquivo_respostas.exists()) {
            try {
                FileInputStream arq_respostas = new FileInputStream(p.nomeArquivoRespostas);
                ObjectInputStream objetoEntradaQ = new ObjectInputStream(arq_respostas);
                p.lista = (ArrayList<Respostas>) objetoEntradaQ.readObject();
                objetoEntradaQ.close();
                arq_respostas.close();
                p.menu();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            p.menu();
        }

    }

    public void menu() {
        Scanner leitorTeclado = new Scanner(System.in);
        String opcao;
        System.out.println("==============================");
        System.out.println("MENU");
        System.out.println("1 - Cadastrar Perguntas");
        System.out.println("2 - Alterar Perguntas");
        System.out.println("3 - Apagar Perguntas");
        System.out.println("4 - Listar Peguntas");
        System.out.println("5 - Iniciar Pesquisa");
        System.out.println("6 - Histórico das Respostas");
        System.out.println("sair - Sair do Sistema");
        System.out.println("==============================");
        System.out.print("Digite a opção: ");
        opcao = leitorTeclado.nextLine();
        //
        while (1 == 1) {
            switch (opcao) {
                case "sair":
                    gravarArquivo();
                    System.exit(0);
                case "1":
                    cadastrarPerguntas();
                    break;
                case "2":
                    alterarPerguntas();
                    break;
                case "3":
                    apagarPerguntas();
                    break;
                case "4":
                    listarPerguntas();
                    break;
                case "5":
                    iniciarPesquisa();
                    break;
                case "6":
                    listarRespostas();
                    break;
                default:
                    System.out.print("Digite uma opção válida: ");
                    break;
            }
            opcao = leitorTeclado.nextLine();
        }
    }

    public void cadastrarPerguntas() {
        Questoes q = new Questoes();
        System.out.println("\nCadastrar Perguntas\n");
        System.out.print("Digite o número da questão: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < pesquisa.size(); z++) {
            if (pesquisa.get(z).getNumero() == n) {
                System.out.println("Número já utilizado!\n");
                menu();
            }
        }
        q.setNumero(n);
        System.out.print("Digite a descrição: ");
        String desc = scanner.nextLine();
        q.setDescricao(desc);
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        System.out.println("Cadastrado com sucesso!\n");
        menu();
    }

    public void alterarPerguntas() {
        Questoes q = new Questoes();
        System.out.println("\nAlterar Perguntas\n");
        System.out.print("Digite o número da questão para alterar: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < pesquisa.size(); z++) {
            if (pesquisa.get(z).getNumero() == num) {
                System.out.print("Digite a nova descrição: ");
                String novadesc = scanner.nextLine();
                pesquisa.get(z).setDescricao(novadesc);
                System.out.println("Alterado com sucesso!\n");
                menu();
            }
        }
        System.out.println("Questão inválida\n");
        menu();
    }

    public void apagarPerguntas() {
        System.out.println("\nApagar Perguntas\n");
        System.out.print("Digite o número da questão para apagar: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < pesquisa.size(); z++) {
            if (pesquisa.get(z).getNumero() == num) {
                pesquisa.remove(z);
                System.out.println("Apagado com sucesso!\n");
                menu();
            }
        }
        System.out.println("Questão inválida!\n");
        menu();
    }

    public void listarPerguntas() {
        System.out.println("\nListagem das Perguntas\n");
        for (int i = 0; i < pesquisa.size(); i++) {
            System.out.println("Questão número: " + pesquisa.get(i).getNumero());
            System.out.println("Descrição: " + pesquisa.get(i).getDescricao());
            System.out.println("A: " + pesquisa.get(i).getAltA());
            System.out.println("B: " + pesquisa.get(i).getAltB());
            System.out.println("C: " + pesquisa.get(i).getAltC());
            System.out.println("D: " + pesquisa.get(i).getAltD());
            System.out.println("E: " + pesquisa.get(i).getAltE());
            System.out.println("");
        }
        menu();
    }

    public void iniciarPesquisa() {
        System.out.print("\nDigite o número de entrevistados: ");
        qtdEnt = scanner.nextInt();
        scanner.nextLine();
        while (qtdEnt <= 0) {
            System.out.print("Quantidade inválida, digite novamente: ");
            qtdEnt = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("\nPesquisa\n");
        for (int x = 0; x < qtdEnt; x++) {
            System.out.print("Digite o nome do entrevistado: ");
            String nome = scanner.nextLine();
            for (int i = 0; i < pesquisa.size(); i++) {
                Respostas r = new Respostas();
                r.setNome(nome);
                r.q = pesquisa.get(i);
                System.out.println("\nEntrevistado " + r.getNome() + "\n");
                System.out.println("Questão número: " + pesquisa.get(i).getNumero());
                System.out.println("Descrição: " + pesquisa.get(i).getDescricao());
                System.out.println("A: " + pesquisa.get(i).getAltA());
                System.out.println("B: " + pesquisa.get(i).getAltB());
                System.out.println("C: " + pesquisa.get(i).getAltC());
                System.out.println("D: " + pesquisa.get(i).getAltD());
                System.out.println("E: " + pesquisa.get(i).getAltE());
                System.out.print("\nDigite a resposta: ");
                String resp = scanner.nextLine();
                while (!resp.equals("a") && !resp.equals("b") && !resp.equals("c") && (!resp.equals("d")) && !resp.equals("e")) {
                    System.out.print("\nResposta inválida, digite novamente: ");
                    resp = scanner.nextLine();
                }
                r.setResposta(resp);
                lista.add(r);
            }
        }
        menu();
    }

    public void listarRespostas() {
        System.out.println("\nLista das Respostas\n");
        for (int y = 0; y < lista.size(); y++) {
            System.out.println("");
            System.out.println("Entrevistado " + lista.get(y).getNome() + "\nResposta Questão " + lista.get(y).q.getNumero() + ": " + lista.get(y).getResposta());
        }
        menu();
    }

    public void perguntasIniciais() {
        Questoes q = new Questoes();
        q.setNumero(1);
        q.setDescricao("Como você avalia a instituição em que estuda de modo geral?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(2);
        q.setDescricao("Como você avalia a infraestrutura geral da instituição em que estuda?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(3);
        q.setDescricao("Como você avalia o curso que estuda?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(4);
        q.setDescricao("Como você avalia os conhecimentos teóricos do curso?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(5);
        q.setDescricao("Como você avalia os conhecimentos práticos da sua área de formação?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(6);
        q.setDescricao("Como você avalia a qualificação dos seus professores?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(7);
        q.setDescricao("Qual é o conceito que você atribui ao curso que estuda?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(8);
        q.setDescricao("Como você avalia o mercado de trabalho da sua área de formação?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(9);
        q.setDescricao("Como você avalia as ofertas profissionais da sua área de formação?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(10);
        q.setDescricao("Como você avalia a remuneração dos profissionais da sua área de formação?");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        pesquisa.add(q);
    }

    public void gravarArquivo() {
        Pesquisa p = new Pesquisa();
        try {
            FileOutputStream arquivoSaidaQuest = new FileOutputStream(p.nomeArquivoQuestoes);
            ObjectOutputStream objetoSaidaQ = new ObjectOutputStream(arquivoSaidaQuest);
            objetoSaidaQ.writeObject(pesquisa);
            objetoSaidaQ.close();
            arquivoSaidaQuest.close();
            //
            FileOutputStream arquivoSaidaResp = new FileOutputStream(p.nomeArquivoRespostas);
            ObjectOutputStream objetoSaidaR = new ObjectOutputStream(arquivoSaidaResp);
            objetoSaidaR.writeObject(lista);
            objetoSaidaR.close();
            arquivoSaidaResp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
