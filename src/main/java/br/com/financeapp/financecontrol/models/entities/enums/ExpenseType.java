package br.com.financeapp.financecontrol.models.entities.enums;

public enum ExpenseType {

	FIXED(1), VARIABLE(2);
	
	private int code;

	private ExpenseType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ExpenseType valueOf(int code) {
		for(ExpenseType type : ExpenseType.values()) {
			if(type.getCode() == code) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid ExpenseType code");
	}
}
