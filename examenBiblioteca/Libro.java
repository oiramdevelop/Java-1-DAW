package examenBiblioteca;

public class Libro {

	/*************************************
	 * VARIABLES MIEMBRO
	 *************************************/
	public String titulo; // Nombre del libro (variable pública según el enunciado)
	private int identificador; // Identificador único del libro
	private String autor; // Nombre del autor
	private String genero; // Género del libro (novela, ciencia, historia, fantasía)
	private int numPaginas; // Número de páginas del libro
	private boolean prestado; // Indica si el libro está prestado o no

	/*************************************
	 * CONSTRUCTORES
	 *************************************/
	// Constructor vacío que inicializa valores aleatorios
	public Libro() {
		this.identificador = (int) (Math.random() * 1000);
		this.titulo = "";
		this.autor = "";
		this.genero = "";
		this.numPaginas = (int) (Math.random() * 500) + 50;
		this.prestado = false;
	}

	// Constructor con parámetros para inicializar un libro con datos específicos
	public Libro(int identificador, String titulo, String autor, String genero, int numPaginas) {
		this.identificador = identificador;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.numPaginas = numPaginas;
		this.prestado = false;
	}

	/*************************************
	 * METODOS
	 *************************************/
	// Método toString que muestra los detalles del libro en formato formateado
	@Override
	public String toString() {
		return "Libro:" + "\n************************************" + "\nTítulo: " + titulo + "\nIdentificador: "
				+ identificador + "\nAutor: " + autor + "\nGénero: " + genero + "\nNúmero de páginas: " + numPaginas
				+ "\nPrestado: " + (prestado ? "Sí" : "No") + "\n************************************";
	}

	/*************************************
	 * GETTERS AND SETTERS
	 *************************************/
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
}
