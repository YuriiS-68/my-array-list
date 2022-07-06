package technical_interview;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class Task {

    public String getStringWithoutDuplicate(String[] arrays){
        LinkedHashSet<String> unique = new LinkedHashSet<>(Arrays.asList(arrays));
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : unique){
            if (string != null){
                stringBuilder.append(string).append(" ");
            }
        }

        return stringBuilder.toString().trim();
    }
}
