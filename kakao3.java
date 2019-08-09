import java.util.HashMap;
import java.util.Map;

public class kakao3{
  public static void main(String[] args){
      LRUCache(3,new String[]{"Jeju","Pangyo","Seoul","NewYork","LA","Jeju","Pangyo","Seoul","NewYork","LA"});   //50
      LRUCache(3,new String[]{"Jeju","Pangyo","Seoul","Jeju","Pangyo","Seoul","Jeju","Pangyo","Seoul"});   //21
      LRUCache(2,new String[]{"Jeju","Pangyo","Seoul","NewYork","LA","SanFrancisco","Seoul","Rome","Paris","Jeju","NewYork","Rome"});
      LRUCache(5,new String[]{"Jeju","Pangyo","Seoul","NewYork","LA","SanFrancisco","Seoul","Rome","Paris","Jeju","NewYork","Rome"});
      LRUCache(2,new String[]{"Jeju","Pangyo","NewYork","newyork"});
      LRUCache(0,new String[]{"Jeju","Pangyo","Seoul","NewYork","LA"});
  }
  public static void LRUCache(int cacheSize, String[] cities){
    int runtime =0;
    Map<String,Integer> map = new HashMap<String,Integer>();
    for(int i = 0; i < cities.length; i++){
      String target = cities[i];
      if(map.containsKey(target.toUpperCase())){
        runtime++;
      }
      else{
        runtime+= 5;
        if(cacheSize > map.size()){
          map.put(target.toUpperCase(),map.size() + 1);
        }
        else{
          String delKey = "";
          for(String key : map.keySet()){
            if(map.get(key) == 1){
              delKey = key;
            }
            else{
              map.put(key,map.get(key) -1);
            }
          }
          map.remove(delKey);
          map.put(target.toUpperCase(),map.size() + 1);
        }
      }
    }
    System.out.println("runtime :: " + runtime );
  }
  /*
    This is my version. To deal with just string array. It will perform slower than using data structure such as HashMap
  */
  // public static void LRUCache(int cacheSize, String[] cities){
  //   if(cacheSize ==0){
  //     System.out.println("Totall time is " + (cities.length * 5));
  //     return;
  //   }
  //   int time = 0;
  //   int i;
  //   int j;
  //   int hit;
  //   String[] cache = new String[cacheSize];
  //   int len = cities.length;
  //   //First iteration to put the values into cache
  //   for(i = 0; i < cacheSize; ++i){
  //     cache[i] = cities[i];
  //     time+=5;
  //   }
  //
  //   for(i =cacheSize; i < len; ++i){
  //     hit = 0;
  //     String temp = cities[i];
  //     for(j = 0; j < cacheSize; ++j){
  //       // Hit cases
  //       if(cache[j].equals(temp)){
  //           hit =1;
  //           time+=1;
  //       }
  //     }
  //     if(hit == 0){time += 5;}
  //
  //     for(j = 0; j < cacheSize -1; ++j){
  //       cache[j] = cache[j+1];
  //     }
  //     cache[cacheSize -1] = temp;
  //   }
  //   System.out.println("Total run time is " + time);
  // }
}
