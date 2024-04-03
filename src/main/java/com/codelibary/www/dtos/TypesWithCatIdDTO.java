package com.codelibary.www.dtos;

public class TypesWithCatIdDTO {

	 private long tId;
	    private String typeName;
	    private byte[] typeImage;
	    private long catId;
	    private String businessId;
		public long gettId() {
			return tId;
		}
		public void settId(long tId) {
			this.tId = tId;
		}
		public String getTypeName() {
			return typeName;
		}
		public void setTypeName(String typeName) {
			this.typeName = typeName;
		}
		public byte[] getTypeImage() {
			return typeImage;
		}
		public void setTypeImage(byte[] typeImage) {
			this.typeImage = typeImage;
		}
		public long getCatId() {
			return catId;
		}
		public void setCatId(long catId) {
			this.catId = catId;
		}
		public String getBusinessId() {
			return businessId;
		}
		public void setBusinessId(String businessId) {
			this.businessId = businessId;
		}
		public TypesWithCatIdDTO(long tId, String typeName, byte[] typeImage, long catId, String businessId) {
			super();
			this.tId = tId;
			this.typeName = typeName;
			this.typeImage = typeImage;
			this.catId = catId;
			this.businessId = businessId;
		}
		public TypesWithCatIdDTO() {
			super();
			// TODO Auto-generated constructor stub
		}
  
              
}
