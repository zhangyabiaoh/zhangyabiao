package com.city.my.domain;

public class ContractProduct {
	private String id;//CONTRACT_PRODUCT_ID
	//private Contract contract;		//�����ӵĹ�����ϵ��ɵ������
		private String contract_id;			//������ϵ�ı������������Ϊ��ͨ�ֶ�
		private String factory_id;//
		
		private String factory_name;//��������
		private String product_num;//����
		private String product_img;//����ͼƬ
		private String product_description;//��������
		private Integer product_number;//����
		private Integer output_number;//ʵ�ʳ�����
		private String load_rate;		//	//װ��
		private Integer boxs_num;				//����
		private String pack_unit;			//��װ��λ
		private Double product_price;//����
		private Double product_amount;//�ܽ��
		private Integer finished;//�Ƿ�������
		private String exts;//����
		private Integer orderno;//�����
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getContract_id() {
			return contract_id;
		}
		public void setContract_id(String contract_id) {
			this.contract_id = contract_id;
		}
		public String getFactory_id() {
			return factory_id;
		}
		public void setFactory_id(String factory_id) {
			this.factory_id = factory_id;
		}
		public String getFactory_name() {
			return factory_name;
		}
		public void setFactory_name(String factory_name) {
			this.factory_name = factory_name;
		}
		public String getProduct_num() {
			return product_num;
		}
		public void setProduct_num(String product_num) {
			this.product_num = product_num;
		}
		public String getProduct_img() {
			return product_img;
		}
		public void setProduct_img(String product_img) {
			this.product_img = product_img;
		}
		public String getProduct_description() {
			return product_description;
		}
		public void setProduct_description(String product_description) {
			this.product_description = product_description;
		}
		public Integer getProduct_number() {
			return product_number;
		}
		public void setProduct_number(Integer product_number) {
			this.product_number = product_number;
		}
		public Integer getOutput_number() {
			return output_number;
		}
		public void setOutput_number(Integer output_number) {
			this.output_number = output_number;
		}
		public String getLoad_rate() {
			return load_rate;
		}
		public void setLoad_rate(String load_rate) {
			this.load_rate = load_rate;
		}
		public Integer getBoxs_num() {
			return boxs_num;
		}
		public void setBoxs_num(Integer boxs_num) {
			this.boxs_num = boxs_num;
		}
		public String getPack_unit() {
			return pack_unit;
		}
		public void setPack_unit(String pack_unit) {
			this.pack_unit = pack_unit;
		}
		public Double getProduct_price() {
			return product_price;
		}
		public void setProduct_price(Double product_price) {
			this.product_price = product_price;
		}
		public Double getProduct_amount() {
			return product_amount;
		}
		public void setProduct_amount(Double product_amount) {
			this.product_amount = product_amount;
		}
		public Integer getFinished() {
			return finished;
		}
		public void setFinished(Integer finished) {
			this.finished = finished;
		}
		public String getExts() {
			return exts;
		}
		public void setExts(String exts) {
			this.exts = exts;
		}
		public Integer getOrderno() {
			return orderno;
		}
		public void setOrderno(Integer orderno) {
			this.orderno = orderno;
		}
		
	
}
