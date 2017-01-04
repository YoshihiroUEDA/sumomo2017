import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class THtmlDownloader {
	URL url = null;
	HttpURLConnection urlcon = null;
	ArrayList<String> htmls = null;

	public THtmlDownloader(String urlname) {
		try {
			url = new URL(urlname);
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("cannot create url object.");
			System.out.println("system exit.");
			System.exit(-1);
		}

	}

	public void getHtml() {

		htmls = new ArrayList<String>();
		if (null == url) {
			System.out.println("url objects not initi.");
			;
			return;
		}
		try {
			urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("GET");
			urlcon.setInstanceFollowRedirects(false);
			urlcon.connect();

			Map<String, java.util.List<String>> headers = urlcon.getHeaderFields();
			Iterator it = headers.keySet().iterator();
			System.out.print("Response header:");
			;
			while (it.hasNext()) {
				String key = (String) it.next();
				System.out.println(" " + key + " " + headers.get(key));

			}
			System.out.println("Response Code : " + urlcon.getResponseCode());
			System.out.println("Response Message : " + urlcon.getResponseMessage());
			BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
			if (null == htmls ){
				System.out.println( " arraylist not initialized.");
				System.out.println( "system.exit ");;
				System.exit( -1);
			}
			while (true) {
				String line = br.readLine();
				if (null == line) {
					break;

				}
				htmls.add(line);

			}
			br.close();
			br = null;
			urlcon.disconnect();
			urlcon=null;
			
			System.out.println( "data line : " + htmls.size());
			

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("cannot create HttpURLConnection object.");
			System.out.println("system.exit");
			System.exit(-1);
		}

	}

	public void dump() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("dump() start...");
		if ( null == htmls ){
			System.out.println( "cannot initialized array object.");;
			System.out.println(" system exit.");;
			System.exit( -1);;
			
		}
		for ( int i =0 ; i < htmls.size(); i++){
			System.out.println( htmls.get(i));
		}
		
	}

	public ArrayList<String> getHttp() {
		// TODO 自動生成されたメソッド・スタブ
		final String KEYWORD_HTTP = "http";
		
		ArrayList<String> list = new ArrayList<String>();
		if ( null == htmls){return null;}
		
		for( int i = 0  ; i<htmls.size(); i++){
			String line = htmls.get(i);
			if (line.indexOf(KEYWORD_HTTP)>=0){
				String[] line2 = line.split(" ");
				for ( int j = 0 ; j<line2.length ; j++){
					if ( line2[j].indexOf(KEYWORD_HTTP)>=0 ){
						list.add(line2[j]);
						
					}
				}
			}
		}
		
		return list;
	}

}
