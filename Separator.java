import java.util.ArrayList;

/**
 * Separate Question and Answer with sign
 */
class Separator {

    String[] findQuestion(String fileName) {

        ArrayList<String> v = search_for_sign(Reader.read(fileName), "#");
        String[] questions = new String[v.size()];
        for (int i = 0; i < questions.length; i++) questions[i] = v.get(i);

        return questions;
    }


    String[] findAnswer(String fileName) {

        ArrayList<String> v = search_for_sign(Reader.read(fileName), "^");
        String[] answer = new String[v.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = v.get(i);

        return answer;
    }


    public boolean canPair(String value) {

        ArrayList<Integer> v = getIndex_of_sign(value, "#");
        int indexes_size = v.size();
        boolean isPair = false;

        for (int i = 0; i < v.size(); i++) {
            indexes_size = indexes_size % 2;
            if (indexes_size == 0) {
                isPair = true;
                break;
            }
            System.out.println(indexes_size);
        }
        return isPair;
    }


    private ArrayList<String> search_for_sign(String value, String sign) {

        ArrayList<Integer> index_of_Q = getIndex_of_sign(value, sign);

        //TODO:Convert index to String value
        ArrayList<String> v = new ArrayList<String>();
        for (int i = 0; i < index_of_Q.size(); i++) {
            String q = value.substring(index_of_Q.get(i), index_of_Q.get(++i) - 1);
            v.add(q);
        }
        return v;
    }

    private ArrayList<Integer> getIndex_of_sign(String value, String sign) {

        //TODO: find index of sign
        String temp = "";
        int firstIndex = 0;
        ArrayList<Integer> index_of_Q = new ArrayList<Integer>();

        for (int i = 0; i <= value.length(); i++) {
            temp = value.substring(firstIndex, i);
            if (temp.contains(sign)) {
                index_of_Q.add(i);
                temp = "";
                firstIndex = i;
            }
        }
        return index_of_Q;
    }

}