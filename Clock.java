package TP1;

import java.util.ArrayList;

public class Clock {
    public int nbFrame;
    public int nbElemInFrame = 0;
    public ArrayList<String> frames = new ArrayList<>();
    public ArrayList<Integer> flag = new ArrayList<>();
    public int handPoint = 0;

    public Clock(int n){
        nbFrame = n;
    }

    public int execute(String[] listOfPage){
        int pagesMisses = 0;
        for (String page : listOfPage){
            if (frames.contains(page)){
                flag.set(frames.indexOf(page), 1);
            }else if(nbElemInFrame<nbFrame){
                pagesMisses++;
                frames.add(page);
                flag.add(1);
                nbElemInFrame++;
            }else{
                pagesMisses++;
                while (true){
                    int index = handPoint%nbFrame;
                    if (flag.get(index) == 0){
                        frames.set(index, page);
                        flag.set(index,1);
                        break;
                    }
                    flag.set(index,0);
                    handPoint++;
                }
            }
            show(page, handPoint%nbFrame);
        }
        return pagesMisses;
    }
    

    public void show(String s, int hp){
        System.out.print(s + " : ");
        for (int i = 0 ; i<frames.size() - 1 ; i++){
            System.out.print(frames.get(i) + "[" + flag.get(i) + "]  ,  ");
        }
        System.out.println(frames.get(frames.size() - 1) + "[" + flag.get(frames.size() - 1) + "]\thandPoint="+hp);
    }

    public static void main(String[] args) {
		Clock lru = new Clock(3);
        String[] workload = {"2", "3", "2", "1", "5", "2", "4", "5", "3", "2",
    "4", "5", "3", "2", "4", "5", "3", "2", "5", "2"};
        //String[] workload = {"A", "B", "C", "D", "B", "C", "D", "B", "E", "D"};
        int pagesMisses = lru.execute(workload);
        System.out.println(pagesMisses);
	}


}
