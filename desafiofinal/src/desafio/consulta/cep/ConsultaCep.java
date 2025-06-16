package desafio.consulta.cep;
import com.google.gson.Gson;
import desafio.endereco.Endereco;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep) {
        String cepLimpo = cep.replaceAll("[^0-9]", ""); // limpa o CEP, deixando só números

        if (cepLimpo.length() != 8) {
            throw new IllegalArgumentException("CEP inválido: deve conter 8 números.");
        }

        URI endereco = URI.create("https://viacep.com.br/ws/" + cepLimpo + "/json/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String body = response.body();

            System.out.println("Resposta da API: " + body); // para debug, pode remover depois

            if (body == null || body.isEmpty()) {
                throw new RuntimeException("Resposta vazia da API.");
            }

            // Se a API retornar erro, por exemplo: {"erro": true}
            if (body.contains("\"erro\": true")) {
                throw new RuntimeException("CEP não encontrado.");
            }

            // Evitar tentar desserializar se a resposta não for um JSON objeto
            if (!body.trim().startsWith("{")) {
                throw new RuntimeException("Resposta inesperada da API: não é um objeto JSON.");
            }

            // Desserializa o JSON para o objeto Endereco
            Endereco enderecoObj = new Gson().fromJson(body, Endereco.class);

            // Salva o objeto Endereco em arquivo JSON
            salvarEnderecoEmArquivo(enderecoObj, "endereço.json");

            return enderecoObj;

        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O ao consultar o CEP: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // resetar o status da thread
            throw new RuntimeException("Consulta ao CEP foi interrompida.");
        } catch (RuntimeException e) {
            /* Para repassar exceções lançadas no próprio metodo */
            throw e;
        } catch (Exception e) {
            // Para pegar qualquer outro erro inesperado
            throw new RuntimeException("Erro inesperado: " + e.getMessage());
        }
    }

    // Metodopara salvar o objeto Endereco em arquivo JSON
    public void salvarEnderecoEmArquivo(Endereco endereco, String nomeArquivo) {
        Gson gson = new Gson();
        String json = gson.toJson(endereco);

        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(json);
            System.out.println("Arquivo JSON salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo JSON: " + e.getMessage());
        }
    }
}

