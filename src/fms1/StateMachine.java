package fms1;

public class StateMachine {

    private char[] str = new char[0];
    private int position = 0;

    static State state = new State(0);

    public ValidationResult validate(String inputStr){
        str = inputStr.toCharArray();
        ValidationResult result;
        for (position = 0; position < str.length; position++){
            if (!validationSymbol())
                return ValidationResult.unexpectedSymbol(str[position], position);
        }
        if (state.getState() == 4){
            result = ValidationResult.valid();
        }
        else {
            result = ValidationResult.unexpectedEOF();
        }
        return result;
    }

    public boolean validationSymbol() {

        char symbol = str[position];
        switch (state.getState()){
            case 0 :
                if (symbol == '-' || Character.isDigit(symbol)){
                    state.setState(1);
                }
                else {
                    return false;
                }
                return true;

            case 1 :
                if (Character.isDigit(symbol)){
                    state.setState(1);
                }
                else if (choice(symbol)){
                    state.setState(3);
                }
                else if (Character.isWhitespace(symbol)){
                    state.setState(2);
                }
                else {
                    return false;
                }
                return true;

            case 2 :
                if (choice(symbol)){
                    state.setState(3);
                }
                else if (Character.isWhitespace(symbol)){
                    state.setState(2);
                }
                else {
                    return false;
                }
                return true;

            case 3 :
                if (symbol == '-'){
                    state.setState(4);
                }
                else if (Character.isDigit(symbol)){
                    state.setState(4);
                }
                else if (Character.isWhitespace(symbol)){
                    state.setState(3);
                }
                else{
                    return false;
                }
                return true;

            case 4 :
                if (Character.isWhitespace(symbol) || choice(symbol)){
                    state.setState(2);
                }
                else if (Character.isDigit(symbol)){
                    state.setState(4);
                }
                else {
                    return false;
                }
                return true;
        }
        return false;
    }

    public boolean choice(char symbol){
        switch (symbol){
            case '+' :
            case '/' :
            case '*' :
            case '-' :
                return true;

            default:
                return false;
        }
    }
}