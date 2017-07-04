package br.pucrs.algo2.grafo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Grafo não dirigido com arestas valoradas.
 * 
 * Autor: alunos da turma 137 - Alg. e Est. Dados II - ES 
 * Data: 22/05/2017
 * 
 */
public class Grafo {

	private int ma[][];

	public Grafo(String nomeDoArquivo) throws IOException {
		int tamanho;
		String aresta[];
		String linha;
		try (BufferedReader bf = new BufferedReader(new FileReader(nomeDoArquivo))) {
			tamanho = Integer.parseInt(bf.readLine());
			ma = new int[tamanho][tamanho];

			while ((linha = bf.readLine()) != null) {
				aresta = linha.split(" ");
				addAresta(Integer.parseInt(aresta[0]), Integer.parseInt(aresta[1]), Integer.parseInt(aresta[2]));
			}
		}
	}

	public void addAresta(int origem, int destino, int peso) {
		ma[origem][destino] = peso;
		ma[destino][origem] = peso;
	}
	
	public int grau(int nodo){
		int cont = 0;
		for(int i =0; i < ma.length; i++){
			if(ma[nodo][i] == 1){
				cont++;				
			}
		}
		return cont;
	}
	
	public List<Integer> maiorGrau(){
		List<Integer> graus = new ArrayList<>();
		int maiorGrau = 0;
		for (int i = 0; i < ma.length; i++) {
			int grau = grau(i);
			if(grau > maiorGrau){
				graus = new ArrayList<>();
				maiorGrau = grau;
				graus.add(i);
			}else if (grau == maiorGrau){
				graus.add(i);
			}
		}		
		return graus;
	}
	
	//percorre abaixo da diagonal principal
	public int contAresta(){
		int i, j;
		int numAresta = 0;
		for (i=1; i<ma.length; i++) {
			for (j=0; j<=i; j++) {
				if (ma[i][j] == 1)
					numAresta++;
			}
			
		}
		return numAresta;
	}
	
	public ArrayList<Integer> percursoAmplitude(int nodoInicial) {
		ArrayList<Integer> listaAmplitude = new ArrayList<>();
		ArrayList<Integer> fila = new ArrayList<>();
		
		fila.add(nodoInicial);
		listaAmplitude.add(nodoInicial);
		while(!fila.isEmpty()){
			int nodo = fila.remove(0);		
			for (int i = 0; i < ma.length; i++) {
				if(ma[nodo][i] == 1){
					if(!listaAmplitude.contains(i)){
						fila.add(i);
						listaAmplitude.add(i);
					}
				}
			}
		}
		return listaAmplitude;
	}
	
	public List<Integer> percursoProfundidade(int nodoInicial) {
		List<Integer> lista = new ArrayList<>();
		percursoProfundidade(nodoInicial, lista);
		return lista;
	}

	private void percursoProfundidade(int nodo, List<Integer> percurso) {
		percurso.add(nodo);
		for (int i = 0; i < ma.length; i++) {
			if (ma[nodo][i] != 0) {
				if (!percurso.contains(i)) { // Evita ciclos!
					percursoProfundidade(i, percurso);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < ma.length; i++) {
			for (int j = 0; j < ma.length; j++) {
				s += String.format("%d ", ma[i][j]);
			}
			s += '\n';
		}
		return s;
	}

}
