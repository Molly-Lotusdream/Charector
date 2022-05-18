package application;

public class wordSelector {

    // load this from a file
    private String[] words = new String[] {
       "b","p","m","f","d","t","n","l",
       "g","k","h","j","q","x",
       "z","c","s","r", "zh","ch","sh",
       "y","w",
       "a","o","e","i","v",
     "ai","ei","ui","ao","ou","iu","ie","ve","er",
     "an","en","in","un","vn","ang","eng","ing","ong",
     "zhi","chi","shi","ri","zi","ci","si","yi","wu","yu",
     "ye","yue","yuan","yin","yun","ying"
    };

    // filter words that have been used
    public String getNextWord() {
        return words[(int)(Math.random() * words.length)];
    }
}
