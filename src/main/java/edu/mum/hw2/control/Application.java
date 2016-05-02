package edu.mum.hw2.control;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Actor;
import edu.mum.hw2.domain.Category;
import edu.mum.hw2.domain.Movie;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class Application {

	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {

		addMovies();
		printMoviesReport();
		emf.close();
	}

	private static void printMoviesReport() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		List<Movie> movie= em.createQuery("From Movie").getResultList();
		for (Movie movie2 : movie) {
			System.out.println(movie2.getName());
			for (Actor act : movie2.getActors()) {
				System.out.println(act.getName());
				
			}
		}

	}

	private static void addMovies() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			List<Actor> actors = new ArrayList<>();
			actors.add(new Actor("Hari", 7, "Hero"));
			// actors.add(new Actor("Kritana",9,"Heroin"));

			for(Actor a : actors) {
				em.persist(a);
			}
			
			// TODO your code
			Movie movie = new Movie();
			movie.setComment("Nice Movie");
			Path p = FileSystems.getDefault().getPath("S:\\EA", "aaa.jpg");
			 byte [] fileData = Files.readAllBytes(p);
			movie.setCover(fileData);
			movie.setName("Movie1");
			movie.setRating(9);
			movie.setCategory(Category.ACTION);

//			List<Actor> actors = new ArrayList<>();
//			actors.add(new Actor("Hari", 7, "Hero"));
			
			movie.setActors(actors);
			em.persist(movie);
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
