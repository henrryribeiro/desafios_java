import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaCotacaoCripto {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite o nome da criptomoeda para a cotação (ex: bitcoin, ethereum, solana): ");
        var criptoNome = leitura.nextLine().toLowerCase().trim();

        String url = "https://api.coingecko.com/api/v3/simple/price?ids=" + criptoNome + "&vs_currencies=usd";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String resposta = response.body();

        if (resposta.contains("usd")) {
            System.out.println("Cotação atual do " + criptoNome + ": " + resposta);
        } else {
            System.out.println("Criptomoeda não encontrada. Verifique o nome e tente novamente.");
        }
    }
}
