import java.io.Serializable;

public class Aeroporto implements Serializable {

	private static final long serialVersionUID = 6748342554146454296L;

	private String codigo;
	private String nome;
	private Geo loc;
	private String codpais;


	public Aeroporto(String codigo, String nome, Geo loc, String codpais) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
		this.codpais = codpais;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Geo getLocal() {
		return loc;
	}

	public String getCodpais() {
		return codpais;
	}

	
}
