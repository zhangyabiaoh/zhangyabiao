package com.city.my.domain;

public class Contract {
	private String id;//编号
	

	private String cpnum;
	private String extnum;
	
	
	private String c_offer;//收购方
	private String contract_num;//合同号
	private java.util.Date sign_date;//签单日期
	private String cinput_by;//制单人
	private String checked_by;//审单人
	private String inspector;//验货员
	private Double amount;//总金额
	private Integer importance_num;//重要程度
	private String crequests;//要求
	private String customer;//客户名称
	private java.util.Date delivery_date;//交货日期
	private java.util.Date ship_date;//船期
	private String trade_clause;//贸易条款
	private String accountfor;//说明
	private String print_style;//打印版式
	private int pre_state;//归档前状态
	private int c_state;//当前状态
	private int output_state;//走货状态
	
	private String created_by;//创建人
	private String created_dept;//创建部门
	private java.util.Date created_date;//创建日期
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCpnum() {
		return cpnum;
	}
	public void setCpnum(String cpnum) {
		this.cpnum = cpnum;
	}
	public String getExtnum() {
		return extnum;
	}
	public void setExtnum(String extnum) {
		this.extnum = extnum;
	}
	
	public String getC_offer() {
		return c_offer;
	}
	public void setC_offer(String c_offer) {
		this.c_offer = c_offer;
	}
	public String getContract_num() {
		return contract_num;
	}
	public void setContract_num(String contract_num) {
		this.contract_num = contract_num;
	}
	public java.util.Date getSign_date() {
		return sign_date;
	}
	public void setSign_date(java.util.Date sign_date) {
		this.sign_date = sign_date;
	}
	public String getCinput_by() {
		return cinput_by;
	}
	public void setCinput_by(String cinput_by) {
		this.cinput_by = cinput_by;
	}
	public String getChecked_by() {
		return checked_by;
	}
	public void setChecked_by(String checked_by) {
		this.checked_by = checked_by;
	}
	public String getInspector() {
		return inspector;
	}
	public void setInspector(String inspector) {
		this.inspector = inspector;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getImportance_num() {
		return importance_num;
	}
	public void setImportance_num(Integer importance_num) {
		this.importance_num = importance_num;
	}
	public String getCrequests() {
		return crequests;
	}
	public void setCrequests(String crequests) {
		this.crequests = crequests;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public java.util.Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(java.util.Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public java.util.Date getShip_date() {
		return ship_date;
	}
	public void setShip_date(java.util.Date ship_date) {
		this.ship_date = ship_date;
	}
	public String getTrade_clause() {
		return trade_clause;
	}
	public void setTrade_clause(String trade_clause) {
		this.trade_clause = trade_clause;
	}
	public String getAccountfor() {
		return accountfor;
	}
	public void setAccountfor(String accountfor) {
		this.accountfor = accountfor;
	}
	public String getPrint_style() {
		return print_style;
	}
	public void setPrint_style(String print_style) {
		this.print_style = print_style;
	}
	public int getPre_state() {
		return pre_state;
	}
	public void setPre_state(int pre_state) {
		this.pre_state = pre_state;
	}
	public int getC_state() {
		return c_state;
	}
	public void setC_state(int c_state) {
		this.c_state = c_state;
	}
	public int getOutput_state() {
		return output_state;
	}
	public void setOutput_state(int output_state) {
		this.output_state = output_state;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreated_dept() {
		return created_dept;
	}
	public void setCreated_dept(String created_dept) {
		this.created_dept = created_dept;
	}
	public java.util.Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(java.util.Date created_date) {
		this.created_date = created_date;
	}
	
	
	

}
