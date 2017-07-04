package br.pucrs.algo2.grafo;

import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int nodo;
		Grafo g=null;
		try {
			g = new Grafo("gr_2205.txt");
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
		
		public void carregaDados() throws IOException {
			Path path2 = Paths.get("airports.dat");
			try (BufferedReader br = Files.newBufferedReader(path2, Charset.forName("UTF-8"))) {
				String linha = br.readLine();
				System.out.println("Cabeï¿½alho: " + linha);
				while ((linha = br.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";"); // separador
																		// ï¿½ ;
					String codigo, nome, pais;
					Double g1, g2;
					codigo = sc.next();
					g1 = Double.parseDouble(sc.next());
					g2 = Double.parseDouble(sc.next());
					nome = sc.next();
					pais = sc.next();
					Geo loc = new Geo(g1, g2);
					GerenciadorPaises gerPa = new GerenciadorPaises();
					Pais p = gerPa.buscarCodigo(pais);
					Aeroporto nova = new Aeroporto(codigo, nome, loc, pais);
					aeroportos.add(nova);

				//	System.out.println(codigo + "," + nome + "," + g1 + "," + g2 + ",PAï¿½S==" + p);
				}
			}
			System.out.println("Total aeroportos: " + aeroportos.size());
		}
		
		public void carregaDados2() throws IOException {
			Path path2 = Paths.get("airlines.dat");
			try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {
				String linha = br.readLine();
				System.out.println("Cabeçalho: " + linha);
				while ((linha = br.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";"); // separador
																		// é ;
					String codigo, nome;
					codigo = sc.next();
					nome = sc.next();
					CiaAerea nova = new CiaAerea(codigo, nome);
					empresas.add(nova);
					// System.out.println(codigo " - " nome);
					
				}
			}
			System.out.println("Total empresas: " + empresas.size());
		}
		
		public void carregaDados3() throws IOException {
			Path path2 = Paths.get("countries.dat");
			try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {
				String linha = br.readLine();
				System.out.println("Cabeï¿½alho: " + linha);
				while ((linha = br.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";"); // separador
																		// ï¿½ ;
					String codigo, nome;
					codigo = sc.next();
					nome = sc.next();

					Pais nova = new Pais(codigo, nome);
					paises.add(nova);
				}
			}
			System.out.println("Total paï¿½ses: " + paises.size());
		}
		
		public void carregaDados4() throws IOException {
			Path path2 = Paths.get("routes.dat");
			try (BufferedReader br = Files.newBufferedReader(path2, Charset.defaultCharset())) {
				String linha = br.readLine();
				System.out.println("Cabeçalho: " + linha);
				linha = br.readLine();
				System.out.println("Cabeçalho: " + linha);
				while ((linha = br.readLine()) != null) {
					Scanner sc = new Scanner(linha).useDelimiter(";"); // separador
																		// é ;
					String aeronave, aeroporto_or, aeroporto_dest, n1, n2, cia;
					cia = sc.next();
					aeroporto_or = sc.next();
					aeroporto_dest = sc.next();
					n1 = sc.next();
					n2 = sc.next();
					aeronave = sc.next();
	/*
					GerenciadorAeronaves gerAvioes2 = new GerenciadorAeronaves();
					Aeronave a1 = gerAvioes2.buscarCodigo(aeronave);
					GerenciadorAeroportos gerAerop = new GerenciadorAeroportos();
					Aeroporto ap1 = gerAerop.buscarCodigo(aeroporto_or);
					Aeroporto ap2 = gerAerop.buscarCodigo(aeroporto_dest);

					GerenciadorCias gerCias2 = new GerenciadorCias();
					CiaAerea c1 = gerCias2.buscarCodigo(cia);
					*/
					GerenciadorAeronaves gerAvioes = new GerenciadorAeronaves();
					Aeronave a1 = gerAvioes.buscarCodigo(aeronave);
					Rota nova = new Rota(cia, aeroporto_or, aeroporto_dest, a1);
					rotas.add(nova);
					// System.out.println(aeronave+","+ aeroporto_or+","
					// +aeroporto_dest+"," +n1+"," +n2+","+ cia);
				}
			}
			// System.out.println("Total rotas: " + rotas.size());
		}
		
	}

}
