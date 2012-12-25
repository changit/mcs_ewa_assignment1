package org.team5.bank.core.server.service.model;

public class WSResult {
	private Status status = Status.SUCCESS;
	private String action;
	private ResultType resultType = ResultType.SINGLE;
	private String errorMsg;
	private String values;

	@Override
	public String toString() {

		return super.toString();
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public ResultType getResultType() {
		return resultType;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}

	public enum Status {
		SUCCESS, FAILED
	}
	
	public enum ResultType{
		SINGLE, MAP
	}
}
