package practicas.practica01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Practica01JUnit6 {
	@Test
	@Order(0)
	public void test00() {// Clase Artista
		// Vamos a probar el primer constructor de Artista: Artista(String...)
		// Si no tiene, exactamente, 4 argumentos, se lanza una excepción
		try {
			new Artista("nombre", "ciudad", "año");
			fail("Debería haber lanzado una excepción por formato incorrecto");
		} catch (Exception e) {
			assertEquals("Formato: nombre, ciudad, año, imagenURL", e.getMessage());
		}

		// Ahora con datos completos
		ArrayList<Artista> artistas = new ArrayList<>();
		artistas.add(new Artista("Arde Bogotá", "España", "2017", "https://img.example.com/ardebogota.png"));

		artistas.add(new Artista("Sôber", "España", "1994", "https://img.example.com/sober.png"));

		ArrayList<String> valoresEsperados = new ArrayList<>(List.of("Arde Bogotá --> []", "Sôber --> []"));
		for (int i = 0; i < valoresEsperados.size(); i++) {
			assertEquals(valoresEsperados.get(i), artistas.get(i).toString());
		}

		assertEquals(2017, artistas.get(0).getAnyo());
		assertEquals(1994, artistas.get(1).getAnyo());

		assertEquals("https://img.example.com/ardebogota.png", artistas.get(0).getImagenURL());
		assertEquals("https://img.example.com/sober.png", artistas.get(1).getImagenURL());
		assertEquals("[]", artistas.get(0).getMiembrosToString());
		assertEquals("[]", artistas.get(1).getMiembrosToString());

		artistas.get(0).addMiembros("Juana Pérez", "   ", "Daniela Rodríguez", null, "Carlos Escobedo");
		assertEquals("[Juana Pérez, Daniela Rodríguez, Carlos Escobedo]", artistas.get(0).getMiembrosToString());
		artistas.get(1).addMiembros("", "", null, "Carlos Escobedo");
		assertEquals("[Carlos Escobedo]", artistas.get(1).getMiembrosToString()); // ¿Por qué no cambia?

		// Insertamos más miembros...
		artistas.get(0).addMiembros("Juana Pérez", "Carlos Escobedo", "Pepa Flores");
		assertEquals("[Juana Pérez, Daniela Rodríguez, Carlos Escobedo, Pepa Flores]",
				artistas.get(0).getMiembrosToString());
		artistas.get(1).addMiembros("", "", null, "Carlos Escobedo");
		assertEquals("[Carlos Escobedo]", artistas.get(1).getMiembrosToString()); // ¿Por qué no cambia?

		for (Artista artista : artistas) {
			artista.clear();
			assertEquals("[]", artista.getMiembrosToString());

		}
		artistas.clear();
		assertTrue(artistas.size() == 0);

		// Ahora vamos a probar el segundo constructor: Artista(String)
		Artista artista01 = new Artista("id01");

		assertEquals("id01", artista01.getNombre());
		assertNull(artista01.getCiudad());

		assertTrue(artista01.getAnyo() == -1);
		assertNull(artista01.getImagenURL());

		assertNull(artista01.getMiembrosToString());
		artista01.addMiembros("m01", "m02", "m03");
		assertNull(artista01.getMiembrosToString()); // No cambia nada

		assertEquals("id01 --> []", artista01.toString());

		// Y, por último, vamos con el método equals(). ¿Por qué lo necesitamos?
		// Esencial entender cómo funciona...
		Artista artista02 = new Artista("id01");
		Artista artista03 = new Artista("id01", "España", "2017", "url");

		// añadimos miembros a los artistas artista02 y artista03
		artista02.addMiembros("m01", "m02", "m03"); // Observa que esta línea no da error...¿por qué?
		artista03.addMiembros("m01", "m02", "m03", "m04", "m05");

		assertEquals("id01 --> []", artista02.toString());
		assertEquals("id01 --> [m01, m02, m03, m04, m05]", artista03.toString());

		assertFalse(artista01.equals(null));
		assertEquals(artista01, artista01); // Obvio. En este caso se cumple this == otro
		assertNotEquals(artista01, "id01"); // En este caso, otro no es de tipo Artista (es de tipo String)
		assertNotEquals(artista01, new Artista("Pepe el Calamar"));
		assertEquals(artista01, artista02);
		assertEquals(artista01, artista03); // ¿Esto está bien? Si no entiendes esto, pregunta...
		assertEquals(artista02, artista03);

		// Limpiamos las colecciones antes de que termine el test (elegancia y...¿fuga
		// de memoria? Investiga sobre este concepto
		artista01.clear();
		artista02.clear();
		artista03.clear();
		assertNull(artista01.getMiembrosToString());
		assertNull(artista02.getMiembrosToString());
		assertEquals("[]", artista03.getMiembrosToString());
	}

	@Test
	@Order(1)
	public void test01() { // Clase Cancion
		try {
			new Cancion("La Voz del Presidente", "205", "2021-02-14", "false");
			fail("Debería haber lanzado una excepción por formato incorrecto");

		} catch (Exception e) {
			assertEquals("Formato: título,duración en segundos, fecha de lanzamiento, contenido explícito, género",
					e.getMessage());
		}

		Cancion cancion01 = new Cancion("La Voz Del Presidente", "205", "2021-02-14", "false", "INDIE");
		Cancion cancion02 = new Cancion("Todo Lo Que No Dije", "165", "2022-06-18", "false", "INDIE");
		Cancion cancion03 = new Cancion("Con Altura", "201", "2019-03-28", "true", "URBAN");

		cancion01.addArtistas(new Artista("Viva Suecia", "España", "2014", "https://img.example.com/vivasuecia.png"));
		cancion02.addArtistas(new Artista("Los Punsetes", "España", "2004", "https://img.example.com/punsetes.png"));
		cancion03.addArtistas(new Artista("Rosalía", "España", "1993", "https://img.example.com/rosalia.png"),
				new Artista("Don Patricio", "España", "1993", "https://img.example.com/donpatricio.png"));
		cancion03.addArtistas(new Artista("Rosalía"), new Artista("Rosalía"));

		assertEquals("La Voz Del Presidente --> [Viva Suecia]", cancion01.toString());
		assertEquals("Todo Lo Que No Dije --> [Los Punsetes]", cancion02.toString());
		assertEquals("Con Altura --> [Rosalía, Don Patricio]", cancion03.toString());

		assertEquals(205, cancion01.getDuracion());
		assertEquals("18-06-2022", cancion02.getFechaLanzamiento());
		assertEquals("14-02-2021", cancion01.getFechaLanzamiento());
		assertEquals("28-03-2019", cancion03.getFechaLanzamiento());
		assertEquals(true, cancion03.getExplicit());
		assertEquals(false, cancion01.getExplicit());
		assertEquals("INDIE", cancion01.getGenero());
		assertEquals("La Voz Del Presidente", cancion01.getTitulo());
		assertEquals("Con Altura", cancion03.getTitulo());
		assertEquals("[Viva Suecia]", cancion01.getNombresArtistas().toString()); // ¿Por qué aparece el título entre
																					// corchetes?
		assertEquals("[Rosalía, Don Patricio]", cancion03.getNombresArtistas().toString());

		// Probamos el constructor Cancion(String)

		Cancion cancion04 = new Cancion("Con Altura");
		assertEquals("Con Altura --> []", cancion04.toString());
		assertEquals("Con Altura", cancion04.getTitulo());
		assertNull(cancion04.getGenero());
		assertNull(cancion04.getFechaLanzamiento());
		assertFalse(cancion04.getExplicit());
		assertNull(cancion04.getNombresArtistas());

		cancion04.addArtistas(new Artista("ART001"), new Artista("ART002"));

		assertEquals("Con Altura --> []", cancion04.toString()); // No cambia nada
		assertNull(cancion04.getNombresArtistas());

		assertEquals(false, cancion01.equals(null));
		assertEquals(cancion01, cancion01);
		assertNotEquals(cancion01, "id01"); // En este caso, otro no es de tipo Cancion (es de tipo String)
		assertEquals(false, cancion01.equals(cancion04));
		assertEquals(false, cancion02.equals(cancion04));
		assertEquals(cancion03, cancion04);
		assertEquals(cancion03, new Cancion("Con Altura"));
		assertEquals(false, cancion04.equals(new Cancion("con alturA")));

		cancion01.clear();
		cancion02.clear();
		cancion03.clear();
		cancion04.clear();

		assertEquals("[]", cancion01.getNombresArtistas().toString());
		assertEquals("[]", cancion02.getNombresArtistas().toString());
		assertEquals("[]", cancion03.getNombresArtistas().toString());
		assertNull(cancion04.getNombresArtistas());
	}

	@Test
	@Order(2)
	public void test02() { // Clase Album
		Artista artista01 = new Artista("Arde Bogotá", "España", "2017", "https://img.example.com/ardebogota.png");
		Artista artista02 = new Artista("Sôber", "España", "1994", "https://img.example.com/sober.png");
		Cancion cancion01 = new Cancion("La Voz", "205", "2021-02-14", "false", "INDIE");
		Cancion cancion02 = new Cancion("Todo", "165", "2022-06-18", "false", "INDIE");
		Cancion cancion03 = new Cancion("Con Altura", "201", "2019-03-28", "true", "URBAN");
		cancion01.addArtistas(artista01);
		cancion02.addArtistas(artista02);
		cancion03.addArtistas(artista01, artista02, artista01);

		assertEquals("La Voz --> [Arde Bogotá]", cancion01.toString());
		assertEquals("Todo --> [Sôber]", cancion02.toString());
		assertEquals("Con Altura --> [Arde Bogotá, Sôber]", cancion03.toString());

		try {
			new Album("La Niña", "2021", "ART003", "https://img.example.com/alb008.png");
			fail("Debería haber lanzado una excepción por formato incorrecto");

		} catch (Exception e) {
			assertEquals("Formato: título, año de lanzamiento, url imagen de la portada", e.getMessage());
		}
		Album album01 = new Album("La Niña", "2021", "https://img.example.com/alb008.png");
		Album album02 = new Album("El Sur", "2022", "https://img.example.com/alb026.png");

		album01.setArtista(artista02);
		album01.addCanciones(cancion01, cancion02);
		album02.addCanciones(cancion02, cancion03, cancion02, cancion02);

		assertEquals("La Niña", album01.getTitulo());
		assertEquals(artista02, album01.getArtista());
		assertEquals("2021", album01.getAnyoLanzamiento());
		assertEquals("https://img.example.com/alb008.png", album01.getCoverImagenURL());

		assertEquals("El Sur", album02.getTitulo());
		assertEquals(null, album02.getArtista());
		assertEquals("2022", album02.getAnyoLanzamiento());
		assertEquals("https://img.example.com/alb026.png", album02.getCoverImagenURL());

		assertEquals("La Niña <Sôber>: [La Voz --> [Arde Bogotá], Todo --> [Sôber]]", album01.toString());
		assertEquals("El Sur <sinArtista>: [Todo --> [Sôber], Con Altura --> [Arde Bogotá, Sôber]]",
				album02.toString());

		assertEquals("[La Voz, Todo]", album01.getCanciones().toString());
		assertEquals("[Todo, Con Altura]", album02.getCanciones().toString());

		Album album03 = new Album("El Sur");

		album03.addCanciones(cancion01, cancion02); // No tiene efecto...

		assertNull(album03.getCanciones());
		assertNull(album03.getArtista());
		assertNull(album03.getAnyoLanzamiento());
		assertNull(album03.getCoverImagenURL());
		assertEquals("El Sur", album03.getTitulo());

		assertNotEquals(album01, album02);
		assertNotEquals(album01, album03);
		assertEquals(album02, album03);

		// Observa cómo iteramos sobre los álbumes
		ArrayList<String> aux1 = new ArrayList<>();
		for (Cancion cancion : album01) {
			aux1.add(cancion.getTitulo());
		}
		assertEquals("[La Voz, Todo]", aux1.toString());

		ArrayList<String> aux2 = new ArrayList<>();
		for (Cancion cancion : album02) {
			aux2.add(cancion.getTitulo());
		}
		assertEquals("[Todo, Con Altura]", aux2.toString());

		ArrayList<String> aux3 = new ArrayList<>();
		for (Cancion cancion : album03) {
			aux3.add(cancion.getTitulo());
		}
		assertEquals("[]", aux3.toString());

		// Y ya, para terminar, método equals()
		assertFalse(album01.equals(null));
		assertTrue(album01.equals(album01));
		assertNotEquals(album01, "id01"); // En este caso, otro no es de tipo Album (es de tipo String)
		assertNotEquals(album01, album03);
		assertNotEquals(album01, album02);
		assertEquals(album02, album03);

		assertEquals("El Sur <sinArtista>: [Todo --> [Sôber], Con Altura --> [Arde Bogotá, Sôber]]",
				album02.toString());
		assertEquals("El Sur <sinArtista>: []", album03.toString()); // Son iguales ya que los títulos son exactamente
																		// iguales...

		aux1.clear();
		aux2.clear();
		aux3.clear();
		album01.clear();
		album02.clear();
		album03.clear();

		assertEquals("[]", album01.getCanciones().toString());
		assertEquals("[]", album02.getCanciones().toString());
		assertNull(album03.getCanciones());
	}

	@Test
	@Order(3)
	public void test03() { // Clase Biblioteca
		Biblioteca biblioteca = new Biblioteca();
		// Si no encuentra el archivo ---> se lanza excepción
		try {
			biblioteca.loadArtistas("artista.txt");
			fail("Debería haber lanzado una excepción por especificar nombre de archivo inexistente");
		} catch (Exception e) {
			assertEquals("Archivo no encontrado", e.getMessage());
		}

		try {
			biblioteca.loadCanciones("cancion.txt");
			fail("Debería haber lanzado una excepción por especificar nombre de archivo inexistente");
		} catch (Exception e) {
			assertEquals("Archivo no encontrado", e.getMessage());
		}

		try {
			biblioteca.loadAlbumes("album.txt");
			fail("Debería haber lanzado una excepción por especificar nombre de archivo inexistente");
		} catch (Exception e) {
			assertEquals("Archivo no encontrado", e.getMessage());
		}

		// Leyendo artistas
		biblioteca.loadArtistas("artistas.txt");
		assertEquals(100, biblioteca.getNumArtistas());
		biblioteca.loadArtistas("artistas.txt");
		assertEquals(100, biblioteca.getNumArtistas());

		// Leyendo canciones
		biblioteca.loadCanciones("canciones.txt");
		assertEquals(200, biblioteca.getNumCanciones());
		biblioteca.loadCanciones("canciones.txt");
		assertEquals(200, biblioteca.getNumCanciones());

		biblioteca.loadArtistas("artistas.txt");
		assertEquals(0, biblioteca.getNumCanciones()); // ¿Le ves sentido?
		biblioteca.loadCanciones("canciones.txt");
		assertEquals(200, biblioteca.getNumCanciones());

		// Leyendo álbumes
		biblioteca.loadAlbumes("albumes.txt");
		assertEquals(100, biblioteca.getNumAlbumes());
		biblioteca.loadAlbumes("albumes.txt");
		assertEquals(100, biblioteca.getNumAlbumes());

		biblioteca.loadArtistas("artistas.txt");
		assertEquals(0, biblioteca.getNumAlbumes());
 
		biblioteca.loadCanciones("canciones.txt");
		biblioteca.loadAlbumes("albumes.txt");
		assertEquals(100, biblioteca.getNumAlbumes());

		// algunas consultas

		// getAlbumesByTituloCancion()
		assertEquals(
				"[A3: Crónicas del Oeste (Arde Bogotá), Sombras del Asfalto (Arde Bogotá), Rock de Titanio (Sexy Zebras)]",
				biblioteca.getAlbumesByTituloCancion("Qué Vida Tan Dura").toString());
		assertEquals(
				"[Cicatrices de Medianoche (Rosalía), Motor de Fuego (Rosalía), Flamenco de Arena (María José Llergo)]",
				biblioteca.getAlbumesByTituloCancion("Pienso en tu mirá").toString());
		assertEquals(
				"[Costa del Horizonte (Quevedo), Judeline de Bruma (Judeline), Saiko de Cristal (Saiko & Quevedo), Urbano del Horizonte (Quevedo)]",
				biblioteca.getAlbumesByTituloCancion("No Me Odies").toString());

		// getGeneroByNombreArtista()
		assertEquals("[POP]", biblioteca.getGeneroByNombreArtista("Aitana").toString());
		assertEquals("[FLAMENCO, URBAN]", biblioteca.getGeneroByNombreArtista("Rosalía").toString());
		assertEquals("[JAZZ]", biblioteca.getGeneroByNombreArtista("María Yfeu").toString());

		// getDuracionByAlbum()
		assertNull(biblioteca.getDuracionByAlbum("rap de sombras")); // Este álbum no existe
		assertEquals(2268, biblioteca.getDuracionByAlbum("Rap de Sombras"));
		assertEquals(1035, biblioteca.getDuracionByAlbum("Sombras del Asfalto"));

		// getCancionesPropiasEnAlbumesAjenos()
		assertEquals("[Malamente (Flamenco de Arena), Pienso en tu mirá (Flamenco de Arena)]",
				biblioteca.getCancionesPropiasEnAlbumesAjenos("Rosalía").toString());
		assertEquals("[]", biblioteca.getCancionesPropiasEnAlbumesAjenos("Shinova").toString());
		assertEquals(
				"[La Canción Que No Existe (Cicatrices de Medianoche), La Última Vez Que Te Vi (Motor de Fuego), Antiaéreo (Rock de Titanio), Qué Vida Tan Dura (Rock de Titanio)]",
				biblioteca.getCancionesPropiasEnAlbumesAjenos("Arde Bogotá").toString());

		biblioteca.clear();
		assertEquals(0, biblioteca.getNumArtistas());
		assertEquals(0, biblioteca.getNumCanciones());
		assertEquals(0, biblioteca.getNumAlbumes());

		biblioteca.loadArtistas("artistas.txt");
		biblioteca.loadCanciones("canciones.txt");
		biblioteca.loadAlbumes("albumes.txt");
		biblioteca.clear();
	}
}