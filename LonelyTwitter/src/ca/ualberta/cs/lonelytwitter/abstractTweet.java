package ca.ualberta.cs.lonelytwitter;

import java.util.Date;


public abstract class abstractTweet
{
	protected Date tweetDate;
	protected String tweetBody;


	public abstractTweet(Date tweetDate, String tweetBody) {
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
	}

	public Date getTweetDate() {
		return tweetDate;
	}

	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	public abstract String toString();
}
