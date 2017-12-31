import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class TQueen8Download {

	public TQueen8Download(String urlstring, String saveFolderName, String FileSeparator) {
		// TODO 自動生成されたコンストラクター・スタブ
		final Logger logger = Logger.getLogger("TQueen8Download");
		// folder setup.
		File f = new File(saveFolderName);
		if (!f.exists()) {
			boolean ret = f.mkdir();
			if (ret == false) {
				logger.info("File :" + saveFolderName);
				logger.info("folder can not created.");
				System.exit(-1);
			}
		}
		//
		URL url = null;
		HttpURLConnection urlcon = null;
		ArrayList<String> list = null;

		try {
			list = getLinksFromBaseHTML(urlstring, logger);

		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			try {
				logger.info(list.get(i));
				url = new URL(list.get(i));

			} catch (MalformedURLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	private ArrayList<String> getLinksFromBaseHTML(String urlstring, final Logger logger)
			throws MalformedURLException, IOException, ProtocolException {
		ArrayList<String> list = new ArrayList<String>();
		URL url;
		HttpURLConnection urlcon;
		url = new URL(urlstring);
		urlcon = (HttpURLConnection) url.openConnection();
		BufferedReader br = null;
		urlcon.setRequestMethod("GET");
		urlcon.setInstanceFollowRedirects(true);
		urlcon.connect();

		Map<String, java.util.List<String>> headers = urlcon.getHeaderFields();
		Iterator it = headers.keySet().iterator();
		logger.info("Response header:");
		while (it.hasNext()) {
			String key = (String) it.next();
			logger.info(" " + key + " " + headers.get(key));

		}
		logger.info("Response Code : " + urlcon.getResponseCode());
		logger.info("Response Message : " + urlcon.getResponseMessage());

		logger.info("◼ページから女優ごとのページを抽出する︎");
		br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
		while (true) {
			String line = br.readLine();
			if (null == line)
				break;
			if (line.indexOf("<img") >= 0 || line.indexOf("<IMG") >= 0) {
				String elems[] = line.split("\"");
				for (int i = 0; i < elems.length; i++) {
					if (elems[i].indexOf("http://") >= 0) {
						try {
							logger.info("elems[" + i + "]" + elems[i]);
							list.add(elems[i]);
						} catch (NullPointerException e) {
							logger.info("i=" + i);
							logger.info("line=" + line);
						}
					}
				}
			}
		}
		br.close();
		urlcon.disconnect();
		urlcon = null;
		url = null;
		return list;
	}

}
