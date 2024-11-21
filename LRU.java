package TP1;

import java.util.ArrayList;

public class LRU {
    public int nbFrame;
    public int nbElemInFrame = 0;
    public ArrayList<String> frames = new ArrayList<>();

    public LRU(int n){
        nbFrame = n;
    }

    public int execute(String[] listOfPage){
        int pagesMisses = 0;
        for (String page : listOfPage){
            if (frames.contains(page)){
                frames.remove(page);
                frames.add(page);
                System.out.print(page + " remonté : ");
            }else if(nbElemInFrame<nbFrame){
                pagesMisses++;
                frames.add(page);
                nbElemInFrame++;
            }else{
                pagesMisses++;
                frames.remove(frames.get(0));
                frames.add(page);
            }
            System.out.println(frames);
        }
        return pagesMisses;
    }
    
    public static void main(String[] args) {
		LRU lru = new LRU(4);
        String[] workload = {"A", "B", "C", "A", "D", "E", "A", "B", "C", "D", "E"};
        int pagesMisses = lru.execute(workload);
        System.out.println(pagesMisses);
	}
}
