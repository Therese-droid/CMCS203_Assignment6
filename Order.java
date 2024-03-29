class Order2 implements OrderInterface, Comparable<Order2> { 
	private int orderNo; 
	private int orderTime; 
	private DAY orderDay; 
	private Customer2 customer; 
	private ArrayList<Beverage> beverages; 
	 
	/** Constructors */ 
	public Order2(int ot, DAY od, Customer2 c) { 
	orderNo = genOrderNum(); 
	orderTime = ot; 
	orderDay = od; 
	customer = c; 
	beverages = new ArrayList<>(); 
	} 
	public int genOrderNum() { 
	Random rand = new Random(); 
	// [10_000, 90_000) 
	int randInt = rand.nextInt(90_000-10_000)+10_000; 
	return randInt; 
	} 
	public String toString() { 
	String s = "____________" 
	+orderDay.toString() +", " +orderTime 
	+"\n" +customer.toString() +" Order Num: " +orderNo; 
	 
	for (Beverage b : beverages) { 
	s += "\n" +b.toString(); 
	} 
	s += "\n Order Total: " +calcOrderTotal(); 
	 
	return s; 
	} 
	public boolean isWeekend() { 
	if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) { 
	return true; 
	} 
	return false; 
	} 
	public Beverage getBeverage(int itemNum) { 
	return beverages.get(itemNum); 
	} 
	public int compareTo1(Order2 o) { 
	if (orderNo == o.getOrderNo()) { 
	return 0; 
	} 
	else if (orderNo > o.getOrderNo()) { 
	return 1; 
	} 
	else { 
	return -1; 
	} 
	} 
	public double calcOrderTotal() { 
	double orderTotal = 0; 
	 
	for (Beverage b : beverages) { 
	orderTotal += b.calcPrice(); 
	} 
	 
	return orderTotal; 
	} 
	public int findNumOfBeveType(TYPE type) { 
	int count = 0; 
	 
	for (Beverage b : beverages) { 
	if (b.getType() == type) { 
	count++; 
	} 
	} 
	 
	return count; 
	} 
	public int getTotalItems() { 
	return beverages.size(); 
	} 
	 
	/** Add Beverages */ 
	public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) { 
	Coffee c = new Coffee(name, size, extraShot, extraSyrup); 
	beverages.add(c); 
	} 
	public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) { 
	Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder); 
	beverages.add(s); 
	} 
	public void addNewBeverage(String name, SIZE size) { 
	boolean isWeekend = false; 
	if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) { 
	isWeekend = true; 
	} 
	Alcohol a = new Alcohol(name, size, isWeekend); 
	beverages.add(a); 
	} 
	 
	/** Accessors */ 
	public int getOrderNo() { 
	return orderNo; 
	} 
	public int getOrderTime() { 
	return orderTime; 
	} 
	public DAY getOrderDay() { 
	return orderDay; 
	} 
	public Customer2 getCustomer() { 
	return new Customer2(customer); 
	} 
	public ArrayList<Beverage> getBeverages() { 
	return beverages; 
	} 
	 
	/** Mutators */ 
	public void setOrderNum(int on) { 
	orderNo = on; 
	} 
	public void setOrderTime(int ot) { 
	orderTime = ot; 
	} 
	public void setOrderDay(DAY od) { 
	orderDay = od; 
	} 
	public void setCustomer(Customer2 c) { 
	customer = c; 
	} 
	@Override 
	public int compareTo(Order2 arg0) { 
	// TODO Auto-generated method stub 
	return 0; 
	} 
	} 