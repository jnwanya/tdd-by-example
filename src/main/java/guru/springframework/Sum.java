package guru.springframework;

/**
 * Created by Jnwanya on
 * Fri, 16 Nov, 2018.
 */
public class Sum implements Expression{
    Expression augmend;
    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String toCurrency) {
        int amt = augmend.reduce(bank, toCurrency).amount + addmend.reduce(bank, toCurrency).amount;
        return new Money(amt, toCurrency);
    }

    @Override
    public Expression plus(Expression added) {
        return new Sum(this, added);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}
