package educative;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUniqueCharacter {
    public static int firstUniqueChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),s.charAt(i)+1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
        if(map.get(s.charAt(i))==1){
            return i;
        }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Example - 1
        String[] string1 = {
                //"fsmhbpiaifezteqntdbwkbytamzmphcbbtctjmafiwjmtfggyzelbsalardkypderngzklfsagstcfsclwppnikpidowkerdufdhhpaijvepvgbrcfbahgicgjxaagednjtnbjqzrsnrojcvmjcwubrgruouhhlptomqdcmxyiearohrymtpbtcndctmwgruzabyuexbshdmtwddrfmqeedqsxccwyzweuclihgdzsesbyovhbqutwnpwtbcuvjvwakpvexaogfwxkzdwjlakmilfrghqcgnpurzznkjpkfurkeqeifxdeuddzrdejrqdnqzszmogjbfsdbinsjcadhtepzzxxxmmpntimucxgvogezmetwbldedhsyhnicgpaoqntjawmpkasinctyudegqtyauxnahetulzrjdlztvrubzwjaittpltajxvvfronwhckcjaygyxtqsfutjjudtvdvqgcpfwuotiwqdpicnmimeosxufdfpwdjlahxjozvapguentkuqmdjorvybhhnrfyqdhzshlvlikuqvdsmyviilnucgjgttczxgudkxsojqnjhbhkgnawnekebfgtnqhmcwiieqxinceyahfiztt",
                "abbcc",
                "dajhfiuebdafsdhdgaj",
                "xyurtwxwtryua",
                "aeiouqwertyauieotweryqq",
                "awsjuhfajwfnkag"
        };

        for (int i = 0; i < string1.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tString = '" + string1[i] + "'");
            System.out.println("\tFinding a unique character...");
            System.out.println("\tIndex of the first unique character is: " + firstUniqueChar(string1[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
