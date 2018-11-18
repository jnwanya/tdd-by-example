package guru.springframework;

/**
 * Created by Jnwanya on
 * Thu, 15 Nov, 2018.
 */
public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() {
        return currency;
    }

    @Override
    public  Expression times(int multiplier){
        return new Money(amount * multiplier, this.currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {

        Money money = (Money)object;
        return money.amount == amount && this.currency == money.currency;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Money{");
        sb.append("amount=").append(amount);
        sb.append(", currency='").append(currency).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Expression plus(Expression added) {
        return new Sum(this, added);
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        return new Money(amount / bank.rate(currency, toCurrency), toCurrency);
    }
}
