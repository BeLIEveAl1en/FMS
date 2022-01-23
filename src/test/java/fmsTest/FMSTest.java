package fmsTest;

import com.artem.math.validator.StateMachine;
import com.artem.math.validator.ValidationResult;
import org.junit.Assert;
import org.junit.Test;

public class FMSTest {

    @Test
    public void shouldPassWithWhitespace(){
        String str = "21 / 700 + 485";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertTrue(result.getComment(), result.isValid());

    }

    @Test
    public void shouldPassWithoutWhitespace(){
        String str = "21/700+485";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertTrue(result.getComment(), result.isValid());
    }

    @Test
    public void shouldPassWithOperator(){
        String str = "-21 / -700 + -485";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertTrue(result.getComment(), result.isValid());
    }

    @Test
    public void shouldPassWithOperatorAndWithoutWhitespace(){
        String str = "-21/-700+-485";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertTrue(result.getComment(), result.isValid());
    }

    @Test
    public void shouldFailWithLetter(){
        String str = "21h / 700 + j485";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertFalse(result.getComment(), result.isValid());
    }

    @Test
    public void shouldFailWithUnexpectedEOF(){
        String str = "21 / 700 + ";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertFalse(result.getComment(), result.isValid());
    }

    @Test
    public void shouldFailWithDoubleOperator(){
        String str = "21 / 700 +- 485";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertFalse(result.getComment(), result.isValid());
    }
}
