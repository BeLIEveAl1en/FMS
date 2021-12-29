package fms1;

public class FMS {

    public static void main(String[] args) {
        String str = "-21 / -700 + -485";
        StateMachine stateMachine = new StateMachine();

        ValidationResult result = stateMachine.validate(str);
        if (result.isValid()){
            System.out.println("OK");
        }
        else {
            System.out.println("ERROR. Comment " + result);
        }
    }
}
