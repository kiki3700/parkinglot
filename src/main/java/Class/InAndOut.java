package Class;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class InAndOut {
	String carNum;
	LocalDateTime enterTime;
	LocalDateTime exitTime;
	String carSize;
	LocalDateTime beginOfTicket;
	LocalDateTime endOfTicket;



	//차 정보확인
	public static String checkCarInfo(String carNum) {
		return Database.selectQuery("car_informations", carNum);
	}
	
	///있으나 없으나 함수 같긴함
	//차정보 기입
	public static int InsertCarInfo(String carNum, String carSize) {	
		return Database.newCarInfo(carNum, carSize);
	}
	
	//입차정보기입
	public static int enter(String carNum, String carSize) {
		if(checkCarInfo(carNum).isEmpty())
			InsertCarInfo(carNum, carSize);
		if(!checkEntranceOrder(carNum))
			return -1;
		if(carSize.equals("small")){
			if(ParkingSpace.small.getAvailableSpace()<=0)
				return -1;
			ParkingSpace.small.setAvailableSpace(-1);
		}else {
			if(ParkingSpace.big.getAvailableSpace()<=0)
				return -1;
			ParkingSpace.big.setAvailableSpace(-1);
		}
		int result =Database.insertEnterCar(LocalDateTime.now().format(Time.formatter), carNum);

		return result;
		}
	
	public static int enter(String carNum, String carSize, String dateTime) {
		if(checkCarInfo(carNum).isEmpty())
			InsertCarInfo(carNum, carSize);
		if(!checkEntranceOrder(carNum))
			return -1;
		if(carSize.equals("small")){
			if(ParkingSpace.small.getAvailableSpace()<=0)
				return -1;
			ParkingSpace.small.setAvailableSpace(-1);
		}else {
			if(ParkingSpace.big.getAvailableSpace()<=0)
				return -1;
			ParkingSpace.big.setAvailableSpace(-1);
		}
		int result =Database.insertEnterCar(LocalDateTime.now().format(Time.formatter), carNum);

		return result;
		}
	
	
	
	//차량 입출차 관련 검증
	public static boolean checkEntranceOrder(String carNum){
		String queryResult = Database.selectLastQuery("enter_logs", carNum);
		System.out.println(queryResult);
		if(!queryResult.isEmpty()) {
		HashMap<String, String> resultMap = Utils.parseData(queryResult);
		if(resultMap.get("exit_time").equals("null")) {
			return false;}
		}
		return true;
	}
	
	public static int exit(String carNum) {	
		String queryString = Database.selectQuery("car_informations", carNum);
		Map<String, String> queryMap = Utils.parseData(queryString);
		if(queryMap.get("car_size").equals("small")) {
			ParkingSpace.small.setAvailableSpace(1);
		}else {
			ParkingSpace.big.setAvailableSpace(1);
		}
		Database.updateExitcar(LocalDateTime.now().format(Time.formatter), carNum);
		
		return 1;
	}
}



