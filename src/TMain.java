import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TMain {
	static String _testURL =
			// "http://sumomo-ch.com/blog-entry-5717.html";
//			"http://sumomo-ch.com/blog-entry-5723.html";
//			"http://sumomo-ch.com/blog-entry-5607.html";
//			"http://sumomo-ch.com/blog-entry-5388.html";
//			"http://sumomo-ch.com/blog-entry-4574.html#more";
//			"http://sumomo-ch.com/blog-entry-4024.html#more";
//			"http://sumomo-ch.com/blog-entry-3208.html#more";
//			"http://sumomo-ch.com/blog-entry-2067.html#more";
//	"http://sumomo-ch.com/blog-entry-3964.html#more";
//	"http://sumomo-ch.com/blog-entry-3216.html#more";
//			"http://sumomo-ch.com/blog-entry-5017.html#more";
//			"http://sumomo-ch.com/blog-entry-5640.html#more";
//			 "http://sumomo-ch.com/blog-entry-5579.html#more"
//			"http://sumomo-ch.com/blog-entry-4028.html"
//			"http://sumomo-ch.com/blog-entry-5724.html"
//			"http://sumomo-ch.com/blog-entry-1355.html#more"
//			"http://sumomo-ch.com/blog-entry-1404.html#more"
//			"http://sumomo-ch.com/blog-entry-1753.html#more"
			"http://sumomo-ch.com/blog-entry-3023.html#more"
			
			;

	static String _actressName =
			// "高橋しょう子";
//			"鳳かなめ";
//			"麻倉憂";
//			"初川みなみ（汗と潮吹きと唾液まみれのAV画像）";
//			"初川みなみ（初川みなみロ○っ子な美少女画像）";
//	"初川みなみ（初川みなみ お嬢様すぎる現役女子大生AVデビュー）";
//			"瑠川リナ 引退 ５年間ありがとう！";
//			"吉沢明歩 ゴージャス色白エロボディ画像";
//	"市川まさみ 色白の妖艶なヌード画像 200枚";
//	"オールヌード画像 全裸の清さ 200枚";
//			"三上悠亜 S1専属デビュー 画像100枚";
//			"香澄はるか 清楚な美少女がSODよりAVデビュー"
//			"松本ななえ 長身美脚グラドルがAVデビュー"
//			"加藤リナの引退が惜しまれるヌード画像 50枚"
//			"加藤リナ ちっぱい水着画像 70枚"
//			"加藤リナのメガネお姉さんなエロ画像 37枚"
			"加藤リナ やっぱり美しいヌード画像 110枚"
			
			;
	
	static String [][] downloadKey = {
//			{ "上原瑞穂 女教師が性処理ペットに","http://sumomo-ch.com/blog-entry-4644.html#more" },
//			{ "上原瑞穂 働く痴女お姉さんAV","http://sumomo-ch.com/blog-entry-4108.html#more"},
//			{ "上原瑞穂 ラグジュアリーなハメ撮りセックス画像", "http://sumomo-ch.com/blog-entry-4101.html#more"},
//			{"上原瑞穂 人生初・トランス状態 激イキ絶頂セックス", "http://sumomo-ch.com/blog-entry-3989.html#more"},
//			{"上原瑞穂 濃厚なご奉仕セックスのAV画像","http://sumomo-ch.com/blog-entry-3895.html#more"},
//			{"上原瑞穂が童貞３人を筆おろしするAV画像","http://sumomo-ch.com/blog-entry-3809.html#more"},
//			{"上原瑞穂 性感フルコースの風俗タワー","http://sumomo-ch.com/blog-entry-3588.html#more"},
//			{"上原瑞穂 レジェンドが新作AVで再デビュー","http://sumomo-ch.com/blog-entry-3380.html#more"},
//			{"上原瑞穂 ２年ぶりに美人AV女優が復活", "http://sumomo-ch.com/blog-entry-3181.html#more"}
//			{"初美沙希 ムッチリ無垢なボディのセックス画像 80枚","http://sumomo-ch.com/blog-entry-1860.html#more"},
//			{"初美沙希 ほの白く柔らかなヌード画像","http://sumomo-ch.com/blog-entry-4322.html#more"},
//			{"アイアンクリムゾン 初美沙希が２穴挿入の中出しファック", "http://sumomo-ch.com/blog-entry-4220.html#more"},
//			{"初美沙希 シットリ色白なセックス画像", "http://sumomo-ch.com/blog-entry-3223.html#more"},
//			{"初美沙希 柔らかセックスエロ画像 140枚", "http://sumomo-ch.com/blog-entry-2919.html#more"},
//			{"初美沙希 トロけるセックス画像 120枚", "http://sumomo-ch.com/blog-entry-2587.html#more"},
//			{"初美沙希 アナルセックスも解禁エロ画像 50枚", "http://sumomo-ch.com/blog-entry-2239.html#more"},
//			{"あやみ旬果の美巨乳の淫乱さが滲み出る画像。30枚","http://sumomo-ch.com/blog-entry-895.html#more"},
//			{"あやみ旬果のムッチリ美巨乳ボディ画像63枚","http://sumomo-ch.com/blog-entry-1238.html#more"},
//			{"あやみ旬果 ローション競泳水着画像 40枚", "http://sumomo-ch.com/blog-entry-1107.html#more"	},
//			{"あやみ旬果のムッチリボディ画像30枚", "http://sumomo-ch.com/blog-entry-1306.html#more"},
//			{"あやみ旬果の新作AVは「NEW WATER POLE」画像23枚", "http://sumomo-ch.com/blog-entry-1308.html#more"},
//			{"あやみ旬果 日焼けあとがエロすぎる野外セックス画像","http://sumomo-ch.com/blog-entry-2755.html#more"},
//			{"あやみ旬果＆柚月あい MGS初イベント「MGSシアター祭」の画像","http://sumomo-ch.com/blog-entry-2936.html#more"},
//			{"あやみ旬果 エロ可愛いＤカップ美巨乳画像","http://sumomo-ch.com/blog-entry-3222.html#more"},
//			{"あやみ旬果 プルプルの美巨乳ヌード画像", "http://sumomo-ch.com/blog-entry-3757.html#more"},
//			{"あやみ旬果 48時間耐久の連続逝かせAV","http://sumomo-ch.com/blog-entry-4104.html#more"},
//			{"あやみ旬果 41人の男とノーカット２時間のセックス", "http://sumomo-ch.com/blog-entry-4283.html#more"},
//			{"http://sumomo-ch.com/blog-entry-4283.html#more", "http://sumomo-ch.com/blog-entry-5494.html#more"},
//			{"緒川りお 美少女のムッチリヌード画像 170枚","http://sumomo-ch.com/blog-entry-4800.html#more"},
//			{"緒川りお ムッチリエロいヌード画像 140枚", "http://sumomo-ch.com/blog-entry-2761.html#more"},
//			{"緒川りお プルッと美少女のエロ画像46枚","http://sumomo-ch.com/blog-entry-2169.html#more"},
//			{"緒川りお シットリ美少女のエロ画像 48枚","http://sumomo-ch.com/blog-entry-1960.html#more"},
//			{"緒川りお 逝くと感涙なセックス開発中の心と体。 画像63枚","http://sumomo-ch.com/blog-entry-1263.html#more"},
//			{"大橋未久の美しいヌード画像 160枚","http://sumomo-ch.com/blog-entry-2639.html#more"},
//			{"きみの歩美 美しい色白エロボディ画像","http://sumomo-ch.com/blog-entry-3404.html#more"},
//			{"きみの歩美 プルリンエロボディ画像 100枚","http://sumomo-ch.com/blog-entry-2441.html#more"},
//			{
//				"きみの歩美 笑顔と瞳が素敵なヌード画像58枚"	,"http://sumomo-ch.com/blog-entry-1301.html#more"
//			},
//			{"なつめ愛莉 ロリボディのセックス画像","http://sumomo-ch.com/blog-entry-3975.html#more"},
//			{"咲田ありな ロリっ可愛いエロ画像 100枚","http://sumomo-ch.com/blog-entry-2482.html#more"},
//			{"咲田ありな恋人同士のセックス画像 65枚","http://sumomo-ch.com/blog-entry-1443.html#more"},
//			{"咲田ありな AV女優デビュー お目々クリクリ画像25枚","http://sumomo-ch.com/blog-entry-940.html#more"},
//			{"さとう遥希 引退しても永遠のムチエロ画像 180枚","http://sumomo-ch.com/blog-entry-3594.html#more"},
//			{"さとう遥希 ムチムチエロボディ画像 150枚","http://sumomo-ch.com/blog-entry-3018.html#more"},
//			{"さとう遥希ムッチリヌード画像56枚","http://sumomo-ch.com/blog-entry-1580.html#more"}
			{"小森愛 カムバック熟女AV女優画像 110枚","http://sumomo-ch.com/blog-entry-2487.html#more"},
			{"成瀬心美 プニプニキュートここみん画像 180枚","http://sumomo-ch.com/blog-entry-2744.html#more"},
			{"成瀬心美 ピンクなプル肌のエロ画像 75枚","http://sumomo-ch.com/blog-entry-2276.html#more"},
			{"成瀬心美 ポップンキュートなエロ画像 40枚","http://sumomo-ch.com/blog-entry-2179.html#more"},
			{"成瀬心美のプルプルなエロ画像34枚","http://sumomo-ch.com/blog-entry-1703.html#more"},
			{"成瀬心美 ここみんのプリプリな魅力","http://sumomo-ch.com/blog-entry-78.html#more"},
			{"ここみんが妹だったらいいなぁ。成瀬心美の自分撮り画像まとめ","http://sumomo-ch.com/blog-entry-77.html#more"}
	};

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		new TMain(_testURL, _actressName);
		for (int i = 0 ; i <downloadKey.length; i++){
			new TMain( downloadKey[i][1], downloadKey[i][0]);
		}
		
	}

	public TMain(String urlname , String actressName) {
		System.out.println("urlname = " + urlname);
		THtmlDownloader obj = new THtmlDownloader(urlname);
		synchronized (this) {
			obj.getHtml();
		}
		// obj.dump();
		ArrayList<String> urllist = obj.getHttp();
		// check array code.
		// System.out.println("urllist dump.");
		// for ( int i =0 ; i<urllist.size(); i++) {
		// System.out.println(urllist.get(i));
		// }
		PullJpegFileFromHttpList o2 = null;
		o2 = new PullJpegFileFromHttpList(urllist);

		//
		ArrayList<String> jlist = new ArrayList<String>();
		jlist = o2.selectJpeg();
		// System.out.println("check code");;
		// for( int i2 = 0 ; i2<jlist.size(); i2++){
		// System.out.println( "->" + jlist.get(i2));
		//
		// }

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
		for (int i = 0; i < jlist.size(); i++) {
			try {
				if (jlist.get(i).indexOf("s.jpg") >= 0) {
					new DownloadJPEG(jlist.get(i), fs, FileSeparator);
				} else {
					new DownloadJPEG(jlist.get(i), f, FileSeparator);
				}
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
				System.out.println("cannot downnload. skip download file.");
				System.out.println("jlist.get(" + i +")= " + jlist.get(i));
				System.out.println("fs="+fs.getName());
				System.out.println("f  =" + f.getName());
				
			}

		}
		System.out.println("program terminated.");
	}
}
