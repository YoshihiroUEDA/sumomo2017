import java.lang.reflect.Array;
import java.util.ArrayList;

public class PullJpegFileFromHttpList {
	ArrayList<String> list = null;

	final String KEYWORD_HTTP = "http";
	final String KEYWORD_JPG = ".jpg";

	public PullJpegFileFromHttpList(ArrayList<String> _list) {
		list = _list;

	}

	public ArrayList<String> selectJpeg() {

		ArrayList<String> jpegList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).indexOf(KEYWORD_HTTP) >= 0 && list.get(i).indexOf(KEYWORD_JPG) >= 0) {
				String[] temp = list.get(i).split("\"");
				for (int k = 0; k < temp.length; k++) {
					if (temp[k].indexOf(KEYWORD_HTTP) == 0) {
						jpegList.add(temp[k]);

					}
				}

			}
		}
		System.out.println("item number : " + jpegList.size());
		return jpegList;

	}
}
