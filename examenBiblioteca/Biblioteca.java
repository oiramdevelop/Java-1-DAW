package examenBiblioteca;

import java.util.ArrayList;

public class Biblioteca {

	/*************************************
	 * VARIABLES MIEMBRO
	 *************************************/
	public String nombreBiblioteca; // Nombre de la biblioteca (variable pública según el enunciado)
	private ArrayList<Libro> libros; // Lista de libros disponibles en la biblioteca
	private ArrayList<Usuario> usuarios; // Lista de usuarios registrados en la biblioteca

	/*************************************
	 * CONSTRUCTORES
	 *************************************/
	// Constructor vacío que inicializa listas vacías
	public Biblioteca() {
		this.nombreBiblioteca = "";
		this.libros = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}

	// Constructor con parámetros para inicializar la biblioteca con datos
	public Biblioteca(String nombreBiblioteca, ArrayList<Libro> libros, ArrayList<Usuario> usuarios) {
		this.nombreBiblioteca = nombreBiblioteca;
		this.libros = libros;
		this.usuarios = usuarios;
	}

	/*************************************
	 * METODOS
	 *************************************/
	// Método que devuelve el total de libros disponibles (no prestados)
	public int totalLibrosDisponibles() {
		int count = 0;
		for (int i = 0; i < libros.size(); i++) {
			if (!libros.get(i).isPrestado()) {
				count++;
			}
		}
		return count;
	}

	// Método que busca un libro por su título y lo devuelve si existe
	public Libro buscarLibro(String titulo) {
		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).titulo.equalsIgnoreCase(titulo)) {
				return libros.get(i);
			}
		}
		return null;
	}

	// Método para prestar un libro a un usuario si está disponible
	public boolean prestarLibro(int idUsuario, int idLibro) {
		Usuario usuario = null;
		Libro libro = null;

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getIdUsuario() == idUsuario) {
				usuario = usuarios.get(i);
				break;
			}
		}

		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).getIdentificador() == idLibro && !libros.get(i).isPrestado()) {
				libro = libros.get(i);
				break;
			}
		}

		if (usuario != null && libro != null) {
			return usuario.prestarLibro(libro);
		}
		return false;
	}

	// Método que muestra todos los usuarios que tienen libros prestados
	public void mostrarUsuariosConLibros() {
		for (int i = 0; i < usuarios.size(); i++) {
			if (!usuarios.get(i).getLibrosPrestados().isEmpty()) {
				System.out.println(usuarios.get(i));
			}
		}
	}

	/*************************************
	 * GETTERS AND SETTERS
	 *************************************/
	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
