package Class;
public	class Coupon{
		float discountAmount;
		String wayTodiscount;
		public Coupon(float d, String wayTodiscount){
			this.discountAmount=d;
			this.wayTodiscount=wayTodiscount;
		}
		
		public int applyCoupon(int price) {
			if(this.wayTodiscount.equals("absolute")) {
				return (int) discountAmount;
			}else {
				return (int) (price*discountAmount); 
			}
		}
		
		public void setDicountAmount(int amount) {
			this.discountAmount=amount;
		}//쿠폰 적요 메서드 끝
	}