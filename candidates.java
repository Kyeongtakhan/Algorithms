import java.util.*;

class Solution {
    Comparator<Integer> comp = new Comparator<Integer>() {
        int countBits(int n){
            int ret = 0;
            while(n != 0){
                if ((n & 1) != 0){
                    ++ret;
                }
                n = n >> 1;
            }
            return ret;
        }
        public int compare(Integer a, Integer b){
            int x = countBits(a);
            int y = countBits(b);
            if (x > y)
                return 1;
            else if (x < y)
                return -1;
            else
                return 0;
        }
    };
    boolean check (String[][] relation, int rs, int cs, int subset){
        for(int a =0; a < rs -1; ++a){
            for(int b = a + 1; b < rs; ++b){
                boolean isSame = true;
                for(int k = 0; k < cs; ++k){
                    if((subset & 1 << k) == 0) continue;
                    if(relation[a][k].equals(relation[b][k]) == false){
                        isSame = false;
                        break;
                    }
                }
                if (isSame){
                    return false;
                }
            }
        }
        return true;
    }
    public int solution(String[][] relation) {
        int answer = 0;
        int rowsize = relation.length;
        int colsize = relation[0].length;

        List<Integer> candidates = new LinkedList<Integer>();

        for (int i = 1; i < 1 << colsize; i++){
            if(check(relation,rowsize,colsize,i) == true){
                candidates.add(i);
            }
        }

        Collections.sort(candidates, comp);
        while(candidates.size() != 0){
            int n = candidates.remove(0);
            ++answer;

            for(Iterator<Integer> itr = candidates.iterator(); itr.hasNext();){
                int c = itr.next();
                if((n &c) == n)
                    itr.remove();
            }
        }
        System.out.println("answer :: " + answer);
        return answer;
    }
}
