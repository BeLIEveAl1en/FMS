
public class StateMachine {

    public char symbol;

    public static boolean result;

    static State state = new State(0);

    public static void getResult(char symbol) throws Exception {
        switch (state.getState()){
            case 0 :
                if (symbol == '-' || Character.isDigit(symbol)){
                    state.setState(1);
                }
                else {
                    throw new Exception();
                }
                break;

            case 1 :
                if(Character.isDigit(symbol)){
                    state.setState(1);
                }
                else if (Character.isWhitespace(symbol)){
                    state.setState(2);
                }
                else {
                    throw new Exception();
                }
                break;

            case 2 :
                if (Character.isWhitespace(symbol)){
                    state.setState(2);
                }
                else {
                    state.setState(3);
                }
                break;

            case 3 :
                choice(symbol);

            case 4 :
                if (Character.isWhitespace(symbol)){
                    state.setState(4);
                }
                else if (symbol == '-'){
                    state.setState(5);
                }
                else if (Character.isDigit(symbol)){
                    state.setState(6);
                }
                else {
                    throw new Exception();
                }
                break;

            case 5 :
                if(Character.isDigit(symbol)){
                    state.setState(6);
                }
                else {
                    throw new Exception();
                }
                break;

            case 6 :
                if(Character.isDigit(symbol)){
                    state.setState(6);
                }
                else if (Character.isWhitespace(symbol)){
                    state.setState(2);
                }
                else{
                    state.setState(7);
                }
                break;

            case 7 :
                result = true;
                break;
        }
    }

    public static void choice(char symbol) throws Exception {
        switch (symbol){
            case '+' :
            case '-' :
            case '*' :
            case '/' :
                state.setState(4);
                break;

            default :
                throw new Exception();
        }
    }
}
