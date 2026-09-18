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
		 if (values.length != 3	) throw new RuntimeException("Formato: título, año de lanzamiento, url imagen de la portada");
		 this.titulo = values[0];
		 this.anyoLanzamiento = values[1];
		 this.coverImagenUrl = values[2];
		 this.canciones = new LinkedList<>();
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
		if (this.canciones == null) return null;
		ArrayList<String> result = new ArrayList<>();
		for (Cancion cancion: this.canciones) {
			result.add(cancion.getTitulo());
		}
		return result;
	}
	
	public void addCanciones(Cancion...canciones) {
		if (this.canciones == null) return;
		for (Cancion cancion: canciones) {
			if (this.canciones.contains(cancion)) continue;
			this.canciones.add(cancion);
		}
	}
	
	public void clear() {
		if (this.canciones == null) return;
		this.canciones.clear();
	}
	
	@Override
	public String toString() {
		String aux2 = this.artista == null ? "sinArtista" : this.artista.getNombre();
		String aux3 = this.canciones == null ? "[]" : this.canciones.toString();
		return this.titulo + " <" + aux2  +  ">: " + aux3;
	}

	@Override
	public boolean equals(Object otro) {
		if (otro == null) return false;
		if (this == otro) return true;
		if (!(otro instanceof Album)) return false;
		return this.titulo.equals(((Album)otro).titulo);
	}
	
	@Override
	public Iterator<Cancion> iterator() {
		if (this.canciones == null) return Collections.emptyIterator();
		return this.canciones.iterator();
	}
}