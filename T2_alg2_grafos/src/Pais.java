import java.io.Serializable;

public class Pais implements Serializable {

	private static final long serialVersionUID = 7968808410731767025L;
	
	private String codigo;
	private String nome;

	public Pais(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

}
