import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TMainQueen8 {
	public TMainQueen8(String urlname, String Title) {
		System.out.println("urlname=" + urlname);
		System.out.println("ActressName=" + Title);
		THtmlDownloader obj = new THtmlDownloader(urlname);
		synchronized (this) {
			obj.getHtml();
		}
		ArrayList<String> urllist = obj.getJpeg();
		for (int i = 0; i < urllist.size(); i++) {
			String target = urllist.get(i);
			// if (target.indexOf("jpg")>=0){
			System.out.println("=>" + target);
			// }
		}
		// Create Download Folder Path.
		final String FileSeparator = System.getProperty("file.separator");
		final String DownloadFolderBaseName = System.getProperty("user.home");
		String DownloadFolder = DownloadFolderBaseName + FileSeparator + "Downloads";
		File f = null;
		File fs = null;

		// System.out.println(DownloadFolderBaseName); ;
		// System.out.println( FileSeparator);
		System.out.println(DownloadFolder);

		Date date = new Date();
		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MMdd-HHmm-");
		DownloadFolder = DownloadFolder + FileSeparator + ss.format(date) + Title;
		String DownloadSubFolder = DownloadFolder + FileSeparator + "index";

		//
		System.out.println("DownloadFolder is " + DownloadFolder);
		f = new File(DownloadFolder);
		if (f.exists()) {
			System.out.println("folder is exists.");
			System.out.println("folder (" + DownloadFolder + ") is used. program terminated.");
			System.exit(-1);
		} else {
			System.out.println("folder is not found.");
			f.mkdir();
			System.out.println("folder (" + DownloadFolder + ") is created.");

		}
		System.out.println("Download Sub Folder is " + DownloadSubFolder);
		fs = new File(DownloadSubFolder);
		if (fs.exists()) {
			System.out.println("folder exist.");
			System.out.println("folder (" + DownloadSubFolder + ") is used. program terminated.");
			System.exit(-1);
		} else {
			System.out.println("folder is not foound.");
			fs.mkdir();
			System.out.println("folder (" + DownloadSubFolder + ") is created.");
		}
		for (int q = 0; q < urllist.size(); q++) {
			String line = urllist.get(q);
			System.out.println(" line is " + urlname + line);
			try {
				new DownloadJPEG(urlname + line, f, FileSeparator);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				// e.printStackTrace();
				System.out.println(" cannot file download. target is " + urlname + line + ".");
			}
		}

	}

}
