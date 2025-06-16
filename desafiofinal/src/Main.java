import desafio.consulta.cep.ConsultaCep;
import desafio.endereco.Endereco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaCep consulta = new ConsultaCep();

        while (true) {
            System.out.println("\n===== MENU BUSCADOR DE CEP =====");
            System.out.println("1 - Buscar CEP");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("2")) {
                System.out.println("Encerrando o programa. Até mais!");
                break;
            } else if (opcao.equals("1")) {
                System.out.print("Digite o CEP (somente números, ex: 01001000): ");
                String cep = scanner.nextLine();

                try {
                    Endereco endereco = consulta.buscaEndereco(cep);
                    System.out.println("\n📦 Resultado da busca:");
                    System.out.println("CEP: " + endereco.getCep());
                    System.out.println("Logradouro: " + endereco.getLogradouro());
                    System.out.println("Complemento: " + endereco.getComplemento());
                    System.out.println("Bairro: " + endereco.getBairro());
                    System.out.println("Cidade: " + endereco.getLocalidade());
                    System.out.println("Estado: " + endereco.getUf());
                } catch (RuntimeException e) {
                    System.out.println("❌ Erro: " + e.getMessage());
                }
            } else {
                System.out.println("❗ Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}


