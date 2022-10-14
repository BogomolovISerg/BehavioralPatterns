package ChainResponsibility;

public abstract class Account {
    protected Account successor;
    protected float balance;

    public void setNext(Account account){
        this.successor = account;
    }
    public void pay(float amountToPay) throws Exception {
        if (canPay(amountToPay)) {
            System.out.println("'Paid " + amountToPay + " using " + Account.class.getName());
        } else if (this.successor == null){
            System.out.println("Cannot pay using " + Account.class.getName() + " Proceeding ..");
            pay(amountToPay);
        } else {
            throw new Exception("None of the accounts have enough balance");
        }
    }

    public boolean canPay(float amount){
        return this.balance >= amount;
    }
}
