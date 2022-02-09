package fmsTest;

import com.artem.math.validator.StateMachine;
import com.artem.math.validator.ValidationResult;
import org.junit.Assert;
import org.junit.Test;

public class FMSTest {

    public void shouldPass(String str){
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertTrue(result.getComment(), result.isValid());
    }

    public void shouldFail(String str){
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);

        Assert.assertFalse(result.getComment(), result.isValid());
    }

    @Test
    public void shouldPassWithWhitespace(){
        shouldPass("21 / 700 + 485");
    }

    @Test
    public void shouldPassWithoutWhitespace(){
        shouldPass("21/700+485");
    }

    @Test
    public void shouldPassWithOperator(){
        shouldPass("-21 / -700 + -485");
    }

    @Test
    public void shouldPassWithOperatorAndWithoutWhitespace(){
        shouldPass("-21/-700+-485");
    }

    @Test
    public void shouldFailWithLetter(){
        shouldFail("21h / 700 + j485");
    }

    @Test
    public void shouldFailWithUnexpectedEOF(){
        shouldFail("21 / 700 + ");
    }

    @Test
    public void shouldFailWithDoubleOperator(){
        shouldFail("21 / 700 +- 485");
    }
}
