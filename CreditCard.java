import javax.management.RuntimeErrorException;

public class CreditCard {
	private int cardNumber;
	private double bank;
	public CreditCard(){}

	public CreditCard(int cardNumber, double bank){
		this.cardNumber = cardNumber;
		this.bank = bank;
	}

	public int getCardNumber(){
		return cardNumber;
	}
	public double getBank(){
		return bank;
	}

	public void withdrawMoney(double money){
		if((this.bank - money) < 0){
			throw new RuntimeException("You don't have enough money");
		}
		this.bank -= money;
		System.out.println("Money was withdrawn");
	}

}
