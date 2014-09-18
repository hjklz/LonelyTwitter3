package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;


public class StarredTweet extends abstractTweet implements Serializable
{

	public StarredTweet (Date tweetDate, String tweetBody) {
		super(tweetDate, tweetBody);
	}
	
	public String toString() {
		return "\u2605 " + tweetBody + " \u2605";
	}
}
