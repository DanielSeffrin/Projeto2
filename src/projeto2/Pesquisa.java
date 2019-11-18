package projeto2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Pesquisa implements Serializable {

    public static ArrayList<Questoes> pesquisa = new ArrayList<>();
    public static ArrayList<Respostas> lista = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int qtdEnt;

    public static void menu() {
        Scanner leitorTeclado = new Scanner(System.in);
        String opcao;
        System.out.println("==============================");
        System.out.println("MENU");
        System.out.println("1 - Cadastrar Perguntas");
        System.out.println("2 - Alterar Perguntas");
        System.out.println("3 - Apagar Perguntas");
        System.out.println("4 - Listar Peguntas");
        System.out.println("5 - Iniciar Pesquisa");
        System.out.println("/*6 - Percentual das Respostas*/");
        System.out.println("sair - Sair do Sistema");
        System.out.println("==============================");
        System.out.print("Digite a opção: ");
        //
        opcao = leitorTeclado.nextLine();
        //
        while (1 == 1) {
            switch (opcao) {
                case "sair":
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
                    percRespostas();
                    break;
                default:
                    System.out.print("Digite uma opção válida: ");
                    break;
            }
            opcao = leitorTeclado.nextLine();
        }
    }

    public static void main(String[] args) {
        perguntasIniciais();
        Pesquisa p = new Pesquisa();
        menu();
    }

    public static void cadastrarPerguntas() {
        Questoes q = new Questoes();
        System.out.println("");
        System.out.println("Cadastramento de Perguntas");
        System.out.println("");
        System.out.print("Digite o número da questão: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < pesquisa.size(); z++) {
            if (pesquisa.get(z).getNumero() == n) {
                System.out.println("Número já utilizado!");
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
        //
        Pesquisa.pesquisa.add(q);
        //
        System.out.println("Cadastrado com sucesso!");
        System.out.println("");
        //
        menu();
    }

    public static void alterarPerguntas() {
        Questoes q = new Questoes();
        System.out.println("");
        System.out.println("Alterar Perguntas");
        System.out.println("");
        System.out.print("Digite o número da questão para alterar: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < pesquisa.size(); z++) {
            if (pesquisa.get(z).getNumero() == num) {
                System.out.print("Digite a nova descrição: ");
                String novadesc = scanner.nextLine();
                pesquisa.get(z).setDescricao(novadesc);
                System.out.println("Alterado com sucesso!");
                System.out.println("");
                menu();
            }
        }
        System.out.println("Questão inválida");
        System.out.println("");
        //
        menu();
    }

    public static void apagarPerguntas() {
        System.out.println("");
        System.out.println("Apagar Perguntas");
        System.out.println("");
        System.out.print("Digite o número da questão para apagar: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int z = 0; z < pesquisa.size(); z++) {
            if (pesquisa.get(z).getNumero() == num) {
                pesquisa.remove(z);
                System.out.println("Apagado com sucesso!");
                System.out.println("");
                menu();
            }
        }
        System.out.println("Questão inválida!");
        System.out.println("");
        //
        menu();
    }

    public static void listarPerguntas() {
        System.out.println("");
        System.out.println("Listagem das Perguntas");
        System.out.println("");
        for (int i = 0; i < pesquisa.size(); i++) {
            System.out.println("Questão número: " + Pesquisa.pesquisa.get(i).getNumero());
            System.out.println("Descrição: " + Pesquisa.pesquisa.get(i).getDescricao());
            System.out.println("A: " + Pesquisa.pesquisa.get(i).getAltA());
            System.out.println("B: " + Pesquisa.pesquisa.get(i).getAltB());
            System.out.println("C: " + Pesquisa.pesquisa.get(i).getAltC());
            System.out.println("D: " + Pesquisa.pesquisa.get(i).getAltD());
            System.out.println("E: " + Pesquisa.pesquisa.get(i).getAltE());
            System.out.println("");
        }
        menu();
    }

    public static void lerResposta() {
        Respostas r = new Respostas();
        System.out.print("Digite a resposta: ");
        String resp = scanner.nextLine();
        while (!resp.equals("a") && !resp.equals("b") && !resp.equals("c") && (!resp.equals("d")) && !resp.equals("e")) {
            System.out.print("Resposta inválida, digite novamente: ");
            resp = scanner.nextLine();
        }
        r.setResposta(resp);
        Pesquisa.lista.add(r);
        System.out.println("");
    }

    public static void iniciarPesquisa() {
        System.out.println("");
        System.out.print("Digite o número de entrevistados: ");
        qtdEnt = scanner.nextInt();
        scanner.nextLine();
        while (qtdEnt <= 0) {
            System.out.print("Quantidade inválida, digite novamente: ");
            qtdEnt = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("");
        System.out.println("Pesquisa");
        System.out.println("");
        //
        for (int x = 0; x < qtdEnt; x++) {
            Respostas r = new Respostas();
            System.out.print("Digite o nome do Entrevistado: ");
            String nome = scanner.nextLine();
            r.setNome(nome);
            Pesquisa.lista.add(r);
            System.out.println("");
            System.out.println("Entrevistado " + r.getNome());
            System.out.println("");
            for (int i = 0; i < pesquisa.size(); i++) {
                System.out.println("Questão número: " + Pesquisa.pesquisa.get(i).getNumero());
                System.out.println("Descrição: " + Pesquisa.pesquisa.get(i).getDescricao());
                System.out.println("A: " + Pesquisa.pesquisa.get(i).getAltA());
                System.out.println("B: " + Pesquisa.pesquisa.get(i).getAltB());
                System.out.println("C: " + Pesquisa.pesquisa.get(i).getAltC());
                System.out.println("D: " + Pesquisa.pesquisa.get(i).getAltD());
                System.out.println("E: " + Pesquisa.pesquisa.get(i).getAltE());
                System.out.println("");
                lerResposta();
            }
        }
        menu();
    }

    public static void percRespostas() {
        System.out.println("Percentual das Respostas");
        //
        menu();
    }

    public static void perguntasIniciais() {
        Questoes q = new Questoes();
        q.setNumero(1);
        q.setDescricao("Q1");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(2);
        q.setDescricao("Q2");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(3);
        q.setDescricao("Q3");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(4);
        q.setDescricao("Q4");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(5);
        q.setDescricao("Q5");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(6);
        q.setDescricao("Q6");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(7);
        q.setDescricao("Q7");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(8);
        q.setDescricao("Q8");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(9);
        q.setDescricao("Q9");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
        //
        q = new Questoes();
        q.setNumero(10);
        q.setDescricao("Q10");
        q.setAltA("Péssimo");
        q.setAltB("Ruim");
        q.setAltC("Regular");
        q.setAltD("Bom");
        q.setAltE("Ótimo");
        Pesquisa.pesquisa.add(q);
    }

}