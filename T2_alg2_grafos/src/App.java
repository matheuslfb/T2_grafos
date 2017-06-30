import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int nodo;
		Grafo g=null;
		try {
			g = new Grafo("routes.dat");
		} catch (IOException e) {
			System.out.println("Impossível ler grafo1.txt!");
		}
		System.out.println(g);
		
		System.out.println("Informe o nodo:\n");
		nodo = entrada.nextInt();
		System.out.println("Grau do nodo: " + g.grau(nodo));
		
		System.out.println("Maior(es) grau(s): "+g.maiorGrau());
		
		System.out.println("\nNúmero de arestas:");
		System.out.println(g.contAresta());
		
		System.out.println("Percursos. Digite o nodo inicial: ");
		int vertinicial = entrada.nextInt();
		
		System.out.println("\nPercurso por Amplitude: ");
		System.out.println(g.percursoAmplitude(vertinicial));
		
		System.out.println("\nPercurso por Profundidade: ");
		System.out.println(g.percursoProfundidade(vertinicial));

	}

}
