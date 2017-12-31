import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class TMain extends TConst {

	static String _testURL =
			// "http://sumomo-ch.com/blog-entry-5717.html";
			// "http://sumomo-ch.com/blog-entry-5723.html";
			// "http://sumomo-ch.com/blog-entry-5607.html";
			// "http://sumomo-ch.com/blog-entry-5388.html";
			// "http://sumomo-ch.com/blog-entry-4574.html#more";
			// "http://sumomo-ch.com/blog-entry-4024.html#more";
			// "http://sumomo-ch.com/blog-entry-3208.html#more";
			// "http://sumomo-ch.com/blog-entry-2067.html#more";
			// "http://sumomo-ch.com/blog-entry-3964.html#more";
			// "http://sumomo-ch.com/blog-entry-3216.html#more";
			// "http://sumomo-ch.com/blog-entry-5017.html#more";
			// "http://sumomo-ch.com/blog-entry-5640.html#more";
			// "http://sumomo-ch.com/blog-entry-5579.html#more"
			// "http://sumomo-ch.com/blog-entry-4028.html"
			// "http://sumomo-ch.com/blog-entry-5724.html"
			// "http://sumomo-ch.com/blog-entry-1355.html#more"
			// "http://sumomo-ch.com/blog-entry-1404.html#more"
			// "http://sumomo-ch.com/blog-entry-1753.html#more"
			"http://sumomo-ch.com/blog-entry-3023.html#more"

	;

	static String _actressName =
			// "高橋しょう子";
			// "鳳かなめ";
			// "麻倉憂";
			// "初川みなみ（汗と潮吹きと唾液まみれのAV画像）";
			// "初川みなみ（初川みなみロ○っ子な美少女画像）";
			// "初川みなみ（初川みなみ お嬢様すぎる現役女子大生AVデビュー）";
			// "瑠川リナ 引退 ５年間ありがとう！";
			// "吉沢明歩 ゴージャス色白エロボディ画像";
			// "市川まさみ 色白の妖艶なヌード画像 200枚";
			// "オールヌード画像 全裸の清さ 200枚";
			// "三上悠亜 S1専属デビュー 画像100枚";
			// "香澄はるか 清楚な美少女がSODよりAVデビュー"
			// "松本ななえ 長身美脚グラドルがAVデビュー"
			// "加藤リナの引退が惜しまれるヌード画像 50枚"
			// "加藤リナ ちっぱい水着画像 70枚"
			// "加藤リナのメガネお姉さんなエロ画像 37枚"
			"加藤リナ やっぱり美しいヌード画像 110枚"

	;

	static String[][] downloadKey = {
			// { "上原瑞穂
			// 女教師が性処理ペットに","http://sumomo-ch.com/blog-entry-4644.html#more" },
			// { "上原瑞穂
			// 働く痴女お姉さんAV","http://sumomo-ch.com/blog-entry-4108.html#more"},
			// { "上原瑞穂 ラグジュアリーなハメ撮りセックス画像",
			// "http://sumomo-ch.com/blog-entry-4101.html#more"},
			// {"上原瑞穂 人生初・トランス状態 激イキ絶頂セックス",
			// "http://sumomo-ch.com/blog-entry-3989.html#more"},
			// {"上原瑞穂
			// 濃厚なご奉仕セックスのAV画像","http://sumomo-ch.com/blog-entry-3895.html#more"},
			// {"上原瑞穂が童貞３人を筆おろしするAV画像","http://sumomo-ch.com/blog-entry-3809.html#more"},
			// {"上原瑞穂
			// 性感フルコースの風俗タワー","http://sumomo-ch.com/blog-entry-3588.html#more"},
			// {"上原瑞穂
			// レジェンドが新作AVで再デビュー","http://sumomo-ch.com/blog-entry-3380.html#more"},
			// {"上原瑞穂 ２年ぶりに美人AV女優が復活",
			// "http://sumomo-ch.com/blog-entry-3181.html#more"}
			// {"初美沙希 ムッチリ無垢なボディのセックス画像
			// 80枚","http://sumomo-ch.com/blog-entry-1860.html#more"},
			// {"初美沙希
			// ほの白く柔らかなヌード画像","http://sumomo-ch.com/blog-entry-4322.html#more"},
			// {"アイアンクリムゾン 初美沙希が２穴挿入の中出しファック",
			// "http://sumomo-ch.com/blog-entry-4220.html#more"},
			// {"初美沙希 シットリ色白なセックス画像",
			// "http://sumomo-ch.com/blog-entry-3223.html#more"},
			// {"初美沙希 柔らかセックスエロ画像 140枚",
			// "http://sumomo-ch.com/blog-entry-2919.html#more"},
			// {"初美沙希 トロけるセックス画像 120枚",
			// "http://sumomo-ch.com/blog-entry-2587.html#more"},
			// {"初美沙希 アナルセックスも解禁エロ画像 50枚",
			// "http://sumomo-ch.com/blog-entry-2239.html#more"},
			// {"あやみ旬果の美巨乳の淫乱さが滲み出る画像。30枚","http://sumomo-ch.com/blog-entry-895.html#more"},
			// {"あやみ旬果のムッチリ美巨乳ボディ画像63枚","http://sumomo-ch.com/blog-entry-1238.html#more"},
			// {"あやみ旬果 ローション競泳水着画像 40枚",
			// "http://sumomo-ch.com/blog-entry-1107.html#more" },
			// {"あやみ旬果のムッチリボディ画像30枚",
			// "http://sumomo-ch.com/blog-entry-1306.html#more"},
			// {"あやみ旬果の新作AVは「NEW WATER POLE」画像23枚",
			// "http://sumomo-ch.com/blog-entry-1308.html#more"},
			// {"あやみ旬果
			// 日焼けあとがエロすぎる野外セックス画像","http://sumomo-ch.com/blog-entry-2755.html#more"},
			// {"あやみ旬果＆柚月あい
			// MGS初イベント「MGSシアター祭」の画像","http://sumomo-ch.com/blog-entry-2936.html#more"},
			// {"あやみ旬果
			// エロ可愛いＤカップ美巨乳画像","http://sumomo-ch.com/blog-entry-3222.html#more"},
			// {"あやみ旬果 プルプルの美巨乳ヌード画像",
			// "http://sumomo-ch.com/blog-entry-3757.html#more"},
			// {"あやみ旬果
			// 48時間耐久の連続逝かせAV","http://sumomo-ch.com/blog-entry-4104.html#more"},
			// {"あやみ旬果 41人の男とノーカット２時間のセックス",
			// "http://sumomo-ch.com/blog-entry-4283.html#more"},
			// {"http://sumomo-ch.com/blog-entry-4283.html#more",
			// "http://sumomo-ch.com/blog-entry-5494.html#more"},
			// {"緒川りお 美少女のムッチリヌード画像
			// 170枚","http://sumomo-ch.com/blog-entry-4800.html#more"},
			// {"緒川りお ムッチリエロいヌード画像 140枚",
			// "http://sumomo-ch.com/blog-entry-2761.html#more"},
			// {"緒川りお
			// プルッと美少女のエロ画像46枚","http://sumomo-ch.com/blog-entry-2169.html#more"},
			// {"緒川りお シットリ美少女のエロ画像
			// 48枚","http://sumomo-ch.com/blog-entry-1960.html#more"},
			// {"緒川りお 逝くと感涙なセックス開発中の心と体。
			// 画像63枚","http://sumomo-ch.com/blog-entry-1263.html#more"},
			// {"大橋未久の美しいヌード画像
			// 160枚","http://sumomo-ch.com/blog-entry-2639.html#more"},
			// {"きみの歩美
			// 美しい色白エロボディ画像","http://sumomo-ch.com/blog-entry-3404.html#more"},
			// {"きみの歩美 プルリンエロボディ画像
			// 100枚","http://sumomo-ch.com/blog-entry-2441.html#more"},
			// {
			// "きみの歩美 笑顔と瞳が素敵なヌード画像58枚"
			// ,"http://sumomo-ch.com/blog-entry-1301.html#more"
			// },
			// {"なつめ愛莉
			// ロリボディのセックス画像","http://sumomo-ch.com/blog-entry-3975.html#more"},
			// {"咲田ありな ロリっ可愛いエロ画像
			// 100枚","http://sumomo-ch.com/blog-entry-2482.html#more"},
			// {"咲田ありな恋人同士のセックス画像
			// 65枚","http://sumomo-ch.com/blog-entry-1443.html#more"},
			// {"咲田ありな AV女優デビュー
			// お目々クリクリ画像25枚","http://sumomo-ch.com/blog-entry-940.html#more"},
			// {"さとう遥希 引退しても永遠のムチエロ画像
			// 180枚","http://sumomo-ch.com/blog-entry-3594.html#more"},
			// {"さとう遥希 ムチムチエロボディ画像
			// 150枚","http://sumomo-ch.com/blog-entry-3018.html#more"},
			// {"さとう遥希ムッチリヌード画像56枚","http://sumomo-ch.com/blog-entry-1580.html#more"}
			// {"小森愛 カムバック熟女AV女優画像
			// 110枚","http://sumomo-ch.com/blog-entry-2487.html#more"},
			// {"成瀬心美 プニプニキュートここみん画像
			// 180枚","http://sumomo-ch.com/blog-entry-2744.html#more"},
			// {"成瀬心美 ピンクなプル肌のエロ画像
			// 75枚","http://sumomo-ch.com/blog-entry-2276.html#more"},
			// {"成瀬心美 ポップンキュートなエロ画像
			// 40枚","http://sumomo-ch.com/blog-entry-2179.html#more"},
			// {"成瀬心美のプルプルなエロ画像34枚","http://sumomo-ch.com/blog-entry-1703.html#more"},
			// {"成瀬心美
			// ここみんのプリプリな魅力","http://sumomo-ch.com/blog-entry-78.html#more"},
			// {"ここみんが妹だったらいいなぁ。成瀬心美の自分撮り画像まとめ","http://sumomo-ch.com/blog-entry-77.html#more"
			// { "Queen8_優子", "http://zero.adultgogo.com/queen8/yuuko/" }
			// {"星咲伶美 アイドル”仮面女子”からAVデビュー", "星咲伶美 アイドル”仮面女子”からAVデビュー"},
			// {"タイトスカート画像 セクシーお姉さん 150枚",
			// "http://sumomo-ch.com/blog-entry-5748.html"},
			// {"西宮このみ
			// ご奉仕のはずが絶叫アクメの敏感エロメイド","http://sumomo-ch.com/blog-entry-5719.html"},
			// {"大原すず 処女喪失から30回も本気逝きするAVデビュー",
			// "http://sumomo-ch.com/blog-entry-5745.html"},
			// {"園田みおん 生中出しセックス解禁", "http://sumomo-ch.com/blog-entry-5742.html"}
			// { "稲川なつめ（辻村成美）の妖艶な人妻画像",
			// "http://sumomo-ch.com/blog-entry-1223.html" }
			{ "彩乃なな エロキュートなヌード画像 260枚", "http://sumomo-ch.com/blog-entry-5784.html" }

	};

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final Logger logger = Logger.getLogger("simpleLogger");
		setupLoggerConfiguration(logger);

		boolean flgQueen8 = false;
		boolean flgSumomo = false;
		boolean flgTest = true;

		logger.info("simple log");
		final String FileSeparator = System.getProperty("file.separator");
		final String DownloadFolderBaseName = System.getProperty("user.home");
//		String DownloadFolder = DownloadFolderBaseName + FileSeparator + "Downloads";
		String DownloadFolder = DownloadFolderBaseName + FileSeparator + "oneDrive";

		if (flgQueen8) {
			// Create Download Folder Path.

			String[] urlname = { "http://ymkikaku.com/Queen8/01/index.html", "http://ymkikaku.com/Queen8/02/index.html",
					"http://ymkikaku.com/Queen8/03/index.html", "http://ymkikaku.com/Queen8/04/index.html",
					"http://ymkikaku.com/Queen8/05/index.html"

			};
			for (int i = 0; i < urlname.length; i++) {
				new TQueen8Download(urlname[i], DownloadFolder, FileSeparator);
			}

		} else if (flgSumomo) {

			// new TMain(_testURL, _actressName);
			for (int i = 0; i < downloadKey.length; i++) {
				if (downloadKey[i][1].indexOf("sumomo-ch") >= 0) {
					new TMain(downloadKey[i][1], downloadKey[i][0]);
				} else if (downloadKey[i][1].indexOf("queen8") >= 0) {
					new TMainQueen8(downloadKey[i][1], downloadKey[i][0]);

				}
			}
		} else if (flgTest) {
			downloadQueen8ActressTest(logger, FileSeparator, DownloadFolder);

		}

	}

	private static void downloadQueen8ActressTest(final Logger logger, final String FileSeparator,
			String DownloadFolder) {
		String base = "http://www11.kinghost.com/asian/cute82/JGG/0086kl/";
		String ext = ".jpg";
		File f = new File(DownloadFolder + FileSeparator + "森原リコ");
		if (!f.exists()) {
			boolean ret = f.mkdir();
			if (false == ret) {
				logger.info("folderが作成できませんでした。");
				System.exit(-1);
			}
		}
		for (int i = 1; i <= 80; i++) {
			String strNumber;
			if (i <= 9) {
				strNumber = "0" + i;
			} else {
				strNumber = "" + i;
			}
			try {
				DownloadQueen8PicBeta2(base + strNumber + ext, strNumber + ext, f.getPath(), FileSeparator);
				//	jsoup

				
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
	}

	private static void DownloadQueen8PicBeta2(String string, String string2, String path, String fileSeparator) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		Map<String,String> map = new HashMap<String,String>();
		for (int indexID=1 ; indexID<=5; indexID++){
			Document document = (Document) Jsoup.connect("http://ymkikaku.com/Queen8/0" + indexID + "/index.html").get();
			
		}
	}

	private static void DownloadQueen8PicBeta(String urlName, String filename, String saveFolder, String FileSeparator)
			throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("urlname=" + urlName);
		System.out.println("filename=" + filename);
		System.out.println("saveFolder=" + saveFolder);

		URL url = new URL(urlName);
		HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
		urlcon.setRequestMethod("GET");
		;
		urlcon.setAllowUserInteraction(false);
		urlcon.setInstanceFollowRedirects(false);
		urlcon.connect();

		int httpStatusCode = urlcon.getResponseCode();
		if (HttpURLConnection.HTTP_OK != httpStatusCode) {
			System.exit(-1);
		}
		
		DataInputStream dis = new DataInputStream(urlcon.getInputStream());
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(saveFolder + FileSeparator + filename)));
		byte [] buff = new byte[1024*1024];
		int len = 0;
		while( -1 != ( len= dis.read(buff))){
			dos.write(buff,0,len);
		}
		dos.flush();
		dos.close();
		dis.close();
		dos=null;
		dis=null;

	}

	private static void setupLoggerConfiguration(final Logger logger) {
		InputStream isStream = TMain.class.getClassLoader().getResourceAsStream(LOGGING_PROPERTIES);
		if (null == isStream) {
			System.out.println("cannot open configuration file.");
			System.exit(-1);
		} else {
			try {
				LogManager.getLogManager().readConfiguration(isStream);
				logger.config("ログ設定：Logmanagerを設定しました。");

			} catch (SecurityException | IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} finally {
				try {
					if (null != isStream)
						isStream.close();

				} catch (IOException e) {
					logger.warning("ログ設定：フィールドクローズ時に例外がは亜聖しました。");
				}
			}
		}
	}

	public TMain(String urlname, String actressName) {
		final Logger logger = Logger.getLogger("simpleLogger");

		logger.fine("urlname = " + urlname);

		THtmlDownloader obj = new THtmlDownloader(urlname);
		synchronized (this) {
			obj.getHtml();
		}

		// obj.dump();
		ArrayList<String> urllist = obj.getHttp();

		logger.fine("check array code");
		logger.fine("urllist dump.");
		for (int i = 0; i < urllist.size(); i++) {
			logger.fine(urllist.get(i));
		}

		PullJpegFileFromHttpList o2 = null;
		o2 = new PullJpegFileFromHttpList(urllist);

		//
		ArrayList<String> jlist = new ArrayList<String>();
		jlist = o2.selectJpeg();

		logger.fine("check code");
		;
		for (int i2 = 0; i2 < jlist.size(); i2++) {
			logger.fine("->" + jlist.get(i2));

		}

		// Download
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
		DownloadFolder = DownloadFolder + FileSeparator + ss.format(date) + actressName;
		String DownloadSubFolder = DownloadFolder + FileSeparator + "index";
		logger.info("◼folder setup︎ start.");
		f = new File(DownloadFolder);
		if (f.exists()) {
			logger.warning("folder is exists. system exit");
			logger.warning("folder (" + DownloadFolder + ") is used. program terminated.");
			System.out.println("program terminated.");
			System.exit(-1);
		} else {
			logger.info("folder is not found.");
			boolean ret = f.mkdir();
			if (true == ret) {
				logger.info("folder (" + DownloadFolder + ") is created.");
			} else {
				logger.info("folder (" + DownloadFolder + ") is cannot created.");
			}
		}
		ProcessBuilder builder = new ProcessBuilder("/usr/sbin/open",
				" -a /System/Library/CoreServices/Finder.app " + DownloadFolder);
		try {
			Process process = builder.start();
			InputStream pin = process.getErrorStream();

		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		fs = new File(DownloadSubFolder);
		if (fs.exists()) {
			logger.warning("folder exists.");
			logger.warning("folder (" + DownloadSubFolder + ") is used. program terminated.");
			System.exit(-1);
		} else {
			System.out.println("folder is not foound.");
			fs.mkdir();
			System.out.println("folder (" + DownloadSubFolder + ") is created.");
		}
		logger.info("◼︎HTML download start.");
		for (int i = 0; i < jlist.size(); i++) {
			try {
				if (jlist.get(i).indexOf("s.jpg") >= 0) {
					new DownloadJPEG(jlist.get(i), fs, FileSeparator);
				} else {
					new DownloadJPEG(jlist.get(i), f, FileSeparator);
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				// e.printStackTrace();
				System.out.println("cannot downnload. skip download file.");
				System.out.println("jlist.get(" + i + ")= " + jlist.get(i));
				System.out.println("fs=" + fs.getName());
				System.out.println("f  =" + f.getName());

			}

		}
		System.out.println("program terminated.");
	}
}
