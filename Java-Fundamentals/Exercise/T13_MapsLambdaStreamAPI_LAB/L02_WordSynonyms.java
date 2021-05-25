package T13_MapsLambdaStreamAPI_LAB;
import java.util.*;


public class L02_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < n ; i++) {
            String key = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (synonyms.containsKey(key)) {
               List<String> stringList = synonyms.get(key);

               stringList.add(synonym);
            } else {
                List<String> synonymList = new ArrayList<>();
                synonymList.add(synonym);

                synonyms.put(key,synonymList);
            }
        }
        for (Map.Entry<String,List<String>> entry : synonyms.entrySet()) {
            System.out.printf("%s - %s%n",entry.getKey(),
                    entry.getValue()
                    .toString()
                    .replaceAll("[\\]\\[]",""));
        }
    }
}
