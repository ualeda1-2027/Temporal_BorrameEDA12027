package practicas.practica01;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	private final ArrayList<Artista> artistas = new ArrayList<>(); //¿Por qué no hacemos esto en la clase Artista o Cancion?
	private final ArrayList<Cancion> canciones = new ArrayList<>();
	private final ArrayList<Album> albumes = new ArrayList<>();

	public void loadArtistas(String fileName) {
		
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");
		
		this.artistas.clear();
		this.canciones.clear();
		this.albumes.clear();
		
		Scanner scan = new Scanner(input);

		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			if (line.isEmpty()) continue;
			if (line.startsWith("#")) continue;
			String[] items = line.split(",");
			if (items.length != 5) continue;
			Artista newArtista = new Artista(items[0], items[1], items[2], items[3]);			
			String[] aux = items[4].substring(1, items[4].length()-1).split(";");
			newArtista.addMiembros(aux);
			this.artistas.add(newArtista);
		}
		scan.close();
	}
	
	public int getNumArtistas() {
		return this.artistas.size();
	}
		
	public void loadCanciones(String fileName) {
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");
		
		this.canciones.clear();
		this.albumes.clear();
		
		Scanner scan = new Scanner(input);
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			if (line.isEmpty()) continue;
			if (line.startsWith("#")) continue;
			String[] items = line.split(",");
			if (items.length != 6) continue;
			Cancion newCancion = new Cancion(items[0], items[1], items[2], items[3], items[4]);			
			String[] aux = items[5].substring(1, items[5].length()-1).split(";");
			for (String nombreArtista: aux) {
				int pos = this.artistas.indexOf(new Artista(nombreArtista));
				if (pos == -1) continue;
				newCancion.addArtistas(this.artistas.get(pos));
			}
			if (newCancion.getNombresArtistas().isEmpty()) continue;
			this.canciones.add(newCancion);
		}
		scan.close();
	}
	
	public int getNumCanciones() {
		return this.canciones.size();
	}
	

	public void loadAlbumes(String fileName) {
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");		
		
		this.albumes.clear();
		
		Scanner scan = new Scanner(input);
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			if (line.isEmpty()) continue;
			if (line.startsWith("#")) continue;
			String[] items = line.split(",");
			if (items.length != 5) continue;
			Album newAlbum = new Album(items[0], items[1], items[3]);			
			
			int pos = this.artistas.indexOf(new Artista(items[2]));
			if (pos == -1) continue;
			newAlbum.setArtista(this.artistas.get(pos));
			String[] aux = items[4].substring(1, items[4].length()-1).split(";");
			for (String tituloCancion: aux) {
				pos = this.canciones.indexOf(new Cancion(tituloCancion));
				if (pos == -1) continue;
				newAlbum.addCanciones(this.canciones.get(pos));
			}
			if (newAlbum.getCanciones().isEmpty()) continue;
			this.albumes.add(newAlbum);
		}
		scan.close();	
	}
	
	public int getNumAlbumes() {
		return this.albumes.size();
	}

	public void clear() {
		this.albumes.clear();
		this.canciones.clear();
		this.artistas.clear();
	}
	
	//Algunas consultas
	
	public ArrayList<String> getAlbumesByTituloCancion(String titulo){
		ArrayList<String> result = new ArrayList<>();

		for(Album album: this.albumes) {
			for(Cancion cancion: album) {
				if (!cancion.equals(new Cancion(titulo))) continue;
				result.add(album.getTitulo() + " (" + album.getArtista().getNombre() + ")" );
				break;
			}
		}
		return result;
	}
	
	public ArrayList<String> getGeneroByNombreArtista(String nombre){
		ArrayList<String> result = new ArrayList<>();
		for (Cancion cancion: this.canciones) {
			if(!cancion.getNombresArtistas().contains(nombre)) continue;
			if (result.contains(cancion.getGenero())) continue;
			result.add(cancion.getGenero());
		}
		
		return result;
	}
	
	public Integer getDuracionByAlbum(String titulo){
		int pos = this.albumes.indexOf(new Album(titulo));
		if (pos == -1) return null;
		int suma = 0;
		for (Cancion cancion: this.albumes.get(pos)) {
			suma += cancion.getDuracion();
		}
		return suma;
	}
	
	public ArrayList<String> getCancionesPropiasEnAlbumesAjenos(String nombreArtista){
		ArrayList<String> result = new ArrayList<>();
		for (Album album: this.albumes) {
			if (album.getArtista().equals(new Artista(nombreArtista))) continue;
			for (Cancion cancion: album) {
				ArrayList<String> artistasCancion = cancion.getNombresArtistas();
				if (artistasCancion.size() > 1) continue;
				if (!artistasCancion.contains(nombreArtista)) continue;
				result.add(cancion.getTitulo() + " (" + album.getTitulo() + ")");
			}
		}
		return result;
	}
}