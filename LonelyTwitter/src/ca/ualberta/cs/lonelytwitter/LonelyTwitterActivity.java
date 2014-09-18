package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

import ca.ualberta.cs.lonelytwitter.data.FileDataManager;
import ca.ualberta.cs.lonelytwitter.data.iDataManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {
	
	private iDataManager manager;
	
	private EditText bodyText;
	
	private ArrayList<abstractTweet> tweets;
	
	private ArrayAdapter<abstractTweet> tweetsViewAdapter;
	
	private ListView oldTweetsList;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		// can now create a selector that creates the relevant data manager
		manager = new FileDataManager();
		
		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		tweets = manager.loadTweets();
		tweetsViewAdapter = new ArrayAdapter<abstractTweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(tweetsViewAdapter);
	}
	
	public void save(View v) {
		
		String text = bodyText.getText().toString();
		
		//can now select which kind of tweet wants to be created
		
		if (text.contains("*")) {
			StarredTweet sTweet = new StarredTweet(new Date(), text);
			tweets.add(sTweet);
		} else {
			Tweet tweet = new Tweet(new Date(), text);
			tweets.add(tweet);
		}	
		
		tweetsViewAdapter.notifyDataSetChanged();
		
		bodyText.setText("");
		manager.saveTweets(tweets);
	}
	
	public void clear(View v) {
		
		tweets.clear();
		tweetsViewAdapter.notifyDataSetChanged();
		manager.saveTweets(tweets);
	}
}