package pooja.com;

import java.util.*;

public class CamblyProgEx {
    public void findWordsNumbers(String s) {
        HashMap<String, Integer> hm = new HashMap<>();

        //splitting the string into array of words
        String[] strArray = s.split("[ .;,]+");

        //finding the number of words using hashMap
        for (String words : strArray) {
            String word = words.toLowerCase();
            // System.out.println(word);

            if (!hm.containsKey(word)) {
                //System.out.println(" Not present in the hashMap");
                hm.put(word, 1);
            } else {
                // System.out.println(" present in the hashMap");
                int wordCount = hm.get(word); // getting the present word count
                hm.put(word, wordCount + 1);  // incrementing the word count
            }
        }

        //printing the hashmap without sorting
        System.out.println("Before Sorting");
        Set<Map.Entry<String,Integer>> set = hm.entrySet();
        for(Map.Entry<String, Integer> mapping : set){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }

        //sorting the hashMap in descending order of the values
        //Comparator taking Map.Entry object
        Comparator<Map.Entry<String, Integer>> sortedValue = (o1, o2) -> o2.getValue().compareTo(o1.getValue());
         /*       new Comparator<>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };*/


        List<Map.Entry<String, Integer>> listOfValues = new ArrayList<>(set);
        Collections.sort(listOfValues, sortedValue);

        LinkedHashMap<String, Integer> sortedEntries = new LinkedHashMap<>(listOfValues.size());

        //copying entries from list to map
        for(Map.Entry<String, Integer> entry : listOfValues){
            sortedEntries.put(entry.getKey(), entry.getValue());
        }

        System.out.println("HashMap after sorting entries by values ");
        Set<Map.Entry<String, Integer>> entrySetSortedByValue = sortedEntries.entrySet();

        for(Map.Entry<String, Integer> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
        }

    }
}
