import java.util.ArrayList;

public class FMS {

    public static void main(String[] args) throws Exception {
        String str = "21 / 7";
        ArrayList<Character> symbolsArray = getSymbolsArray(str, new ArrayList<Character>());

        for (int i = 0; i < symbolsArray.size(); i++){
            StateMachine.getResult(symbolsArray.get(i));
        }
        System.out.println(StateMachine.result);
    }

    public static ArrayList<Character> getSymbolsArray(String str, ArrayList<Character> symbolsArray){
        for(int i = 0; i < str.length(); i++){
            symbolsArray.add(str.charAt(i));
        }
        return symbolsArray;
    }
}
