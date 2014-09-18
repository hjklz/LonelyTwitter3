/**
 * 
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;


public class Tweet extends abstractTweet implements Serializable {

	public Tweet(Date tweetDate, String tweetBody) {
		super(tweetDate, tweetBody);
	}

	public String toString() {
		return tweetDate + ": " + tweetBody;
	}
}
