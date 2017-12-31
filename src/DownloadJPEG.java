import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadJPEG {
	public DownloadJPEG(String urlname, File DownloadFolder, String FileSeparator) throws Exception {
		URL url;
		try {
			// ネットに接続
			url = new URL(urlname);
			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("GET");
			urlcon.setAllowUserInteraction(false);
			urlcon.setInstanceFollowRedirects(false);
			urlcon.connect();
			// status code check
			int httpStatusCode = urlcon.getResponseCode();
			if (HttpURLConnection.HTTP_OK != httpStatusCode) {
				throw new Exception();
			}
			// バイナリデータのダウンロード
			DataInputStream dataInStream = new DataInputStream(urlcon.getInputStream());
			String saveName = DownloadFolder.getPath() + FileSeparator;
			String urlnames[] = urlname.split("/");
			saveName = saveName + urlnames[urlnames.length - 1];
			// System.out.println( "saveName="+saveName);
			DataOutputStream dataOutStream = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(saveName)));
			byte[] b = new byte[4096];
			int readByte = 0;
			while (-1 != (readByte = dataInStream.read(b))) {
				dataOutStream.write(b, 0, readByte);
			}
			// 後始末
			dataOutStream.flush();
			dataInStream.close();
			dataOutStream.close();

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
