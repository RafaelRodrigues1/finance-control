package br.com.financeapp.financecontrol.models.entities.enums;

public enum IncomeType {

	MONEY(1), TRANSFER(2);
	
	private int code;

	private IncomeType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static IncomeType valueOf(int code) {
		for(IncomeType type : IncomeType.values()) {
			if(type.getCode() == code) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid IncomeType code");
	}
}
