import java.util.Random;

public class PassowordGenerator {
    public static final String UPPERCASE_CHARACTERS = "QWERTYUIOPASDFGHJKLÇZXCVBNM";
    public static final String LOWERCASE_CHARACTERS = "qwertyuiopasdfghjklçzxcvbnm";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS = "!@#$%¨¨&*()_-=+´`~^{}[];:/?.,|'";

    private final Random random;

    public PassowordGenerator(){random = new Random();}

    public String generatePassoword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialSymbols){
        StringBuilder passowordBuilder = new StringBuilder();


        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

          for (int i = 0; i < length; i++){
              int randomIndex = random.nextInt(validCharacters.length());


              char randomChar = validCharacters.charAt(randomIndex);

              passowordBuilder.append(randomChar);
          }
           return passowordBuilder.toString();
    }
}
