package guru.springframework;

/**
 * Created by Jnwanya on
 * Fri, 16 Nov, 2018.
 */
public interface Expression {

    Money reduce(Bank bank, String toCurrency);

    Expression plus(Expression added);

    Expression times(int multiplier);
}
