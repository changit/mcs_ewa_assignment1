package org.team5.portal.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gihan
 * Date: 12/30/12
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreditCardDetailsResponse implements Serializable {

    private static final long serialVersionUID = 9062931599080832127L;

    private CreditCardAccount creditCardAccount;
    private List<Transaction> cardTransactions = new ArrayList<Transaction>();

    public CreditCardAccount getCreditCardAccount() {
        return creditCardAccount;
    }

    public void setCreditCardAccount(CreditCardAccount creditCardAccount) {
        this.creditCardAccount = creditCardAccount;
    }

    public List<Transaction> getCardTransactions() {
        return cardTransactions;
    }

    public void setCardTransactions(List<Transaction> cardTransactions) {
        this.cardTransactions = cardTransactions;
    }
}
