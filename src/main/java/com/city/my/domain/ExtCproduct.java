package com.city.my.domain;

public class ExtCproduct {
	private String id;
	private String contractProductId;			//关联关系的表（外键），都成为普通字段
	private String factoryId;
	
	private String factoryName;//厂家名称
	private String ctype;//类型
	
	private String productNo;//货号
	private String productImage;//货物图片
	private String productDesc;//货物描述
	private Integer cnumber;//数量
	private String packingUnit;	//包装单位
	private Double price;//价格
	private Double amount;//总金额
	private String productRequest;//要求
	private Integer orderNo;//排序号
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContractProductId() {
		return contractProductId;
	}
	public void setContractProductId(String contractProductId) {
		this.contractProductId = contractProductId;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getProductRequest() {
		return productRequest;
	}
	public void setProductRequest(String productRequest) {
		this.productRequest = productRequest;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	
	
	
	
}
