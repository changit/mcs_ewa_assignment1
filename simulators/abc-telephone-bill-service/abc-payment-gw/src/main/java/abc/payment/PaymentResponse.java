package abc.payment;

import java.io.Serializable;

public class PaymentResponse implements Serializable {
	
    private PaymentCode paymentCode;
	private String description;

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    public PaymentCode getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(PaymentCode paymentCode) {
        this.paymentCode = paymentCode;
    }

    @Override
    public String toString() {
        return "PaymentResponse{" +
                "paymentCode=" + paymentCode +
                ", description='" + description + '\'' +
                '}';
    }
}
