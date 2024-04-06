package br.com.Musics.sistema.exception;

public class UsuarioNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	// Construtor vazio
	/*public PagamentoNotFoundException () {
	super ();
}*/
	
	// Construtor com uma mensagem
	/*public PagamentoNotFoundException (String mensagemCustomizada) {
	super (mensagemCustomizada);
}*/
	
	public UsuarioNotFoundException () {
		super();
	}
	
	
	public UsuarioNotFoundException (String mensagemCustomizada) {
		super (mensagemCustomizada);
	}
	
	
}
