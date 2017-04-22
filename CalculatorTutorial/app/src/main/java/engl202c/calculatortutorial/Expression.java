package engl202c.calculatortutorial;

/**
 * Created by Varaladis on 4/10/2017.
 */

public class Expression {
    public int operand1, operand2;
    private int value;
    public String operator;

    public Expression() {
        operand1 = 0;
        operand2 = 0;
        value = 0;
        operator = "+";
    }

    public int getValue() {
        computeValue();
        return value;
    }
    private void computeValue() {
        value = 0;
        if (operator.equals("+"))
            value = operand1 + operand2;
        else if (operator.equals("-"))
            value = operand1 - operand2;
        else if (operator.equals("x"))
            value = operand1 * operand2;
        else if (operator.equals("/") && operand2 != 0)
            value = operand1 / operand2;
        else if (operator.equals("^"))
            value = (int) Math.pow(operand1, operand2);
        else if (operator.equals("%") && operand2 != 0)
            value = operand1 % operand2;
        else
            value = 0;
    }
}
