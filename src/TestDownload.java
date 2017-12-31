import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestDownload {
	static String targetBase = "http://zero.adultgogo.com/queen8/images/yuuko/";
	static String targetExt = ".jpg";

	public static void main(String[] args) {
		String SaveFolder = "/Users/ueda/Downloads/Queen8_優子";
		String urlname, filename;

		for (int ii = 1; ii <= 160; ii++) {
			if (ii <= 9) {
				filename = "0" + ii + targetExt;
				urlname = targetBase + filename;
				new Download(urlname, SaveFolder, filename);
				// }else if ( ii >=100){

			} else {
				filename = ii + targetExt;
				urlname = targetBase + filename;
				new Download(urlname, SaveFolder, filename);
			}
		}

		// // TODO 自動生成されたメソッド・スタブ
		// try {
		// System.out.println("target is " + target);
		// URL url= new URL(target);
		// HttpURLConnection urlcon =(HttpURLConnection) url.openConnection();
		// urlcon.setRequestMethod("GET");
		// urlcon.setInstanceFollowRedirects(true);
		// urlcon.setAllowUserInteraction(false);
		// urlcon.connect();
		// int responseCode = urlcon.getResponseCode();
		// if ( HttpURLConnection.HTTP_OK != responseCode ){
		// System.out.println("response code = "+responseCode);
		// }
		// DataInputStream dis = new DataInputStream ( urlcon.getInputStream());
		// String saveFilename =
		// "/Users/ueda/Downloads/2017-0109-0206-Queen8_優子/test.jpg";
		// DataOutputStream dos =new DataOutputStream ( new
		// BufferedOutputStream( new FileOutputStream( saveFilename)));
		// byte[] buff=new byte[4096];
		// int readByte =0;
		// while( -1 != ( readByte= dis.read(buff))){
		// dos.write(buff,0,readByte);
		// System.out.print("["+readByte+"]");
		// }
		// dos.flush();
		// dos.close();
		// dos=null;
		// dis.close();
		// dis=null;
		// } catch (IOException e) {
		// // TODO 自動生成された catch ブロック
		// e.printStackTrace();
		// }
		//
	}

}

class Download {
	public Download(String targetURL, String SaveFolderName, String Filename) {
		System.out.println("url is " + targetURL);
		// System.out.println("save folder name is " + SaveFolderName);
		// System.out.println("file name is " + Filename);
		String writeFileName = SaveFolderName + "/" + Filename;
		System.out.println(" wrhite fike name is " + writeFileName);
		File f = new File(SaveFolderName);
		if (!f.exists()) {
			f.mkdirs();
		}

		try {
			URL url = new URL(targetURL);
			HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
			urlcon.setRequestMethod("GET");
			urlcon.setRequestProperty("Referer", "http://zero.adultgogo.com/queen8/yuuko/");
			urlcon.setInstanceFollowRedirects(true);
			urlcon.setAllowUserInteraction(false);
			urlcon.connect();
			int responseCode = urlcon.getResponseCode();
			if (HttpURLConnection.HTTP_OK != responseCode) {
				System.out.println(" response code is " + responseCode);
				System.exit(-1);
			}
			DataInputStream dis = new DataInputStream(urlcon.getInputStream());
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(writeFileName)));
			byte[] buff = new byte[4096];
			int len = 0;
			while (-1 != (len = dis.read(buff))) {
				dos.write(buff, 0, len);
			}
			dos.flush();
			dos.close();
			dos = null;
			dis.close();
			dis = null;

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
