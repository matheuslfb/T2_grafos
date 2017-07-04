import java.io.Serializable;

public class Rota implements Serializable {

	private static final long serialVersionUID = 7686714783256478043L;
	
	private CiaAerea cia;
	private Aeroporto origem;
	private Aeroporto destino;
	private Aeronave aeronave;
	private String ciaa, orig, dest;

	public Rota(CiaAerea cia, Aeroporto origem, Aeroporto destino, Aeronave aeronave) {
		this.cia = cia;
		this.origem = origem;
		this.destino = destino;
		this.aeronave = aeronave;
	}
	public Rota(String ciaa, String orig, String dest, Aeronave aero){
		this.ciaa = ciaa;
		this.orig = orig;
		this.dest = dest;
		this.aeronave = aero;
	}

	@Override
	public String toString() {
		return cia.getCodigo() + ": " + origem.getCodigo() + " -> " + destino.getCodigo() + " [" + aeronave.getCodigo()
				+ "]";
	}

	public CiaAerea getCia() {
		return cia;
	}

	public Aeroporto getDestino() {
		return destino;
	}

	public Aeroporto getOrigem() {
		return origem;
	}
	public Aeronave getAeronave() {
		return aeronave;
	}
	public String getCiaa() {
		return ciaa;
	}
	public String getOrig() {
		return orig;
	}
	public String getDest() {
		return dest;
	}
	
	
}
