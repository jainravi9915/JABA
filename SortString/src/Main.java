import java.util.LinkedList;


public class Main {

    public static LinkedList<String> split(String text) {
        char[] myCharArr;
        myCharArr = text.toCharArray();
        LinkedList<String> ll = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < myCharArr.length; i++) {
            if (myCharArr[i] == ' ' || i == myCharArr.length - 1) {
                ll.addLast(text.substring(j, i));
                j = i + 1;
            }
        }
        return ll;
    }

    public static void main(String[] args) {
        String text = "te3kst e1to perv2i pro5st rando4m slo6va";
        LinkedList<String> ll;
        LinkedList<String> result = new LinkedList<>();
        char[] myCharArr;

        System.out.println(split(text));
        ll = split(text);
        for (int x = 0; x < ll.size(); x++){
            result.add(x," ");
        }
        for (int i = 0; i < ll.size(); i++) {
            myCharArr = ll.get(i).toCharArray();
            for (int j = 0; j < myCharArr.length; j++) {
                switch (myCharArr[j]) {
                    case '1':
                        result.remove(0);
                        result.add(0, ll.get(i));
                        break;
                    case '2':
                        result.remove(1);
                        result.add(1, ll.get(i));
                        break;
                    case '3':
                        result.remove(2);
                        result.add(2, ll.get(i));
                        break;
                    case '4':
                        result.remove(3);
                        result.add(3, ll.get(i));
                        break;
                    case '5':
                        result.remove(4);
                        result.add(4, ll.get(i));
                        break;
                    case '6':
                        result.remove(5);
                        result.add(5, ll.get(i));
                        break;
                    case '7':
                        result.remove(6);
                        result.add(6, ll.get(i));
                        break;
                    case '8':
                        result.remove(7);
                        result.add(7, ll.get(i));
                        break;
                    case '9':
                        result.remove(8);
                        result.add(8, ll.get(i));
                        break;
                }
            }
        }
        System.out.println(result);
    }
}
