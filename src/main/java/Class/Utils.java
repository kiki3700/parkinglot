package Class;
import java.util.HashMap;


public class Utils {
	public static HashMap<String, String> parseData(String sqlResult){
		String[] strArr=sqlResult.split(",");
		HashMap<String,String> dataMap = new HashMap<String,String>();
		try {
		for(int i=0;i<strArr.length;i++) {
			dataMap.put(strArr[i].split("=")[0], strArr[i].split("=")[1]);
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			dataMap=null;
		}
		return dataMap;
	}
}
