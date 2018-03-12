package com.twitter.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twitter.domain.Tweet;
import com.twitter.service.TweetSearchService;

import twitter4j.Status;

@Controller
public class TweetController {
	
	private TweetSearchService tweetService;

	@Autowired
	public void setTweetService(TweetSearchService tweetService) {
		this.tweetService = tweetService;
	}
	
	
	@RequestMapping(value= "/searchTwitter" ,method=RequestMethod.GET)
	public String search(@RequestParam("queryString") String queryString, Model model,RedirectAttributes redirectAttributes) {
		List<Status> status = tweetService.searchByString(queryString);
		List<Tweet> tweets = tweetService.saveOrUpdate(status);
		for (Tweet tweet : tweets) {
			System.out.println("tweetler :" + tweet.getText());
		}
		redirectAttributes.addFlashAttribute("tweets", tweets);
		
		return "redirect:/showtweets";
	}
	
	@RequestMapping("/showtweets")
	public String showTweets() {
		return "showtweets";
	}
	
}
