package project.TadeM.product.model;

import lombok.Data;

@Data
public class ServiceResult {

	boolean result;
	String message; //false시 메세지

	public ServiceResult() {
	}

	public ServiceResult(boolean result, String message) {

		this.result = result;
		this.message = message;

	}

	public ServiceResult(boolean result) {

		this.result = result;
	}
}
