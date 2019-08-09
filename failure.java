import java.util.*;

class Solution {

    class Fail{
      int stage;
      double rate;
      Fail(int stage, double rate){
        this.stage = stage;
        this.rate = rate;
      }
    }
    Comparator<Fail> comp = new Comparator<Fail>{
      public int compare(Fail a, Fail b){
        if(a.rate < b.rate )
          return 1;
        else if (a.rate > b.rate)
          return -1;
        else{
          if (a.stage > b.stage)
            return 1;
          else if (a.stage < b.stage)
            return -1
          else
            return 0;
        }
      }
    };
    public int[] solution(int N, int[] stages) {
        List<Fail> fails = new ArrayList<Fail>();
        int total_usr = stages.length;
        int[] usrs = new int[N + 1];

        for(int s : stages){
          usrs[s-1]++;
        }
        for(int i=0; i< N; ++i){
          if(usrs[i] == 0){
            fails.add(new Fail(i+1,0));
          }
          else{
            fails.add(new Fail(i+1,(double)usrs[i] / total_usr));
            total_usr -= usrs[i];
          }
        }
        Collections.sort(fails,comp);
        for (int i =0; i < N; ++i){
          answer[i] - fails.get(i).stage;
        }
        int[] answer = new int[N];
        return answer;
    }
}
