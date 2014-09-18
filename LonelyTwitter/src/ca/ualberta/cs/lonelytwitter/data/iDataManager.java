package ca.ualberta.cs.lonelytwitter.data;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.lonelytwitter.abstractTweet;


public interface iDataManager
{
	public ArrayList<abstractTweet> loadTweets();
	public void saveTweets(List<abstractTweet> lts);
}
