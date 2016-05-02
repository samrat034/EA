package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue

	private int aID;
	private String name;
	private int rating;
	private String actorCharacter;

	Actor() {

	}

	public Actor(String name, int rating, String actorCharacter) {
		super();
		this.name = name;
		this.rating = rating;
		this.actorCharacter = actorCharacter;
	}

	public int getaID() {
		return aID;
	}

	public void setaID(int aID) {
		this.aID = aID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getActorCharacter() {
		return actorCharacter;
	}

	public void setActorCharacter(String actorCharacter) {
		this.actorCharacter = actorCharacter;
	}

}
