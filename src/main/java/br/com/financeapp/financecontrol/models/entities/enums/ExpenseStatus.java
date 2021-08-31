package br.com.financeapp.financecontrol.models.entities.enums;

public enum ExpenseStatus {

	OPEN(1), PAID(2), DUE(3);
	
	private int code;

	private ExpenseStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ExpenseStatus valueOf(int code) {
		for(ExpenseStatus status : ExpenseStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid ExpenseStatus code");
	}
}
