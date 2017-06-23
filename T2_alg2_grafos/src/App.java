

import java.io.IOException;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int nodo;
		Grafo g=null;
		try {
			g = new Grafo("gr3_3105.txt");
		} catch (IOException e) {
			System.out.println("Impossível ler grafo!");
		}
		System.out.println(g);
		
		System.out.println("Informe o nodo:\n");
		nodo = entrada.nextInt();
		System.out.println("Grau de saída nodo: " + g.grauDeSaida(nodo));
		System.out.println("Grau de entrada nodo: " + g.grauDeEntrada(nodo));
		System.out.println("Vertice mais proximo: " + g.getAdjacenteProximo(nodo));
		System.out.println("Arestas: " + g.getArestas());

//		
//		System.out.println("Maior(es) grau(s): "+g.maiorGrau());
//		
//		System.out.println("\nNúmero de arestas:");
//		System.out.println(g.contAresta());
//		
//		System.out.println("Percursos. Digite o nodo inicial: ");
//		int vertinicial = entrada.nextInt();
//		
//		System.out.println("\nPercurso por Amplitude: ");
//		System.out.println(g.percursoAmplitude(vertinicial));
//		
//		System.out.println("\nPercurso por Profundidade: ");
//		System.out.println(g.percursoProfundidade(vertinicial));

	}

}
