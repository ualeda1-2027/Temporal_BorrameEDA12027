package practicas.practica01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Album implements Iterable<Cancion> {
	private String titulo;
	private String anyoLanzamiento;
	private Artista artista;
	private String coverImagenUrl;
	private final LinkedList<Cancion> canciones;
	
	public Album(String...values) {
		 //5 líneas
		 //...
	}
	
	public Album(String titulo) {
		this.titulo = titulo;
		this.anyoLanzamiento = null;
		this.artista = null;
		this.coverImagenUrl = null;
		this.canciones = null;
	}
	
	public void setArtista (Artista artista) {
		this.artista = artista;
	}
		
	public String getTitulo() {
		return this.titulo;
	}
	
	public Artista getArtista() {
		return this.artista;
	}
	
	public String getAnyoLanzamiento() {
		return this.anyoLanzamiento;
	}
	
	public String getCoverImagenURL() {
		return this.coverImagenUrl;
	}
	
	public ArrayList<String> getCanciones() {
		//Devuelve null si la estructura no está inicializada
		//1 for()
		//...
		return result;
	}
	
	public void addCanciones(Cancion...canciones) {
		//1 for()
		//...
	}
	
	public void clear() {
		//2 líneas
		//...
	}
	
	@Override
	public String toString() {
		String aux2 = //...
		String aux3 = //...
		return this.titulo + " <" + aux2  +  ">: " + aux3;
	}

	@Override
	public boolean equals(Object otro) {
		//Clave: atributo titulo
		//4 líneas
		//...
	}
	
	@Override
	public Iterator<Cancion> iterator() {
		if (this.canciones == null) return Collections.emptyIterator(); //Esto es genial...¿por qué hace falta en este método?
		return //...
	}
}