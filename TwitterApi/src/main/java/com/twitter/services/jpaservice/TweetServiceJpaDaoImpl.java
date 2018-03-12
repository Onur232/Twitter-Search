package com.twitter.services.jpaservice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;

import com.twitter.domain.Tweet;

import twitter4j.Status;

@Service
public class TweetServiceJpaDaoImpl {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public List<Tweet> saveOrUpdate(List<Status> sList) {
		List<Tweet> tweets=new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		for (Status status : sList) {
			Tweet tweet = new Tweet();
			tweet.setCreatedAt(status.getCreatedAt());
			tweet.setAccessLevel(status.getAccessLevel());
			tweet.setFavoriteCount(status.getFavoriteCount()); 
			tweet.setGeoLocation(status.getGeoLocation());
			tweet.setRetweetCount(status.getRetweetCount());
			tweet.setText(status.getText());
			tweets.add(tweet);
			em.merge(tweet);
		}
		em.getTransaction().commit();
		return tweets;
	}

}
