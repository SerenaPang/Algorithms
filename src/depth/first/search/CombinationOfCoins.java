package depth.first.search;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfCoins {
	  //target is the total sum that's required 
	  //coins是一串不同面值的币种
	  public List<List<Integer>> combinations(int target, int[] coins) {
	    //创建一个list放入所有的可能性（也是一个list）
	    //outer list包含所有可能性， innner list是一个可能性：多少个某个币种{3个, 2个, 0个, 4个} 对应币值cents{25, 10, 5, 1}
	    List<List<Integer>> result = new ArrayList<List<Integer>>(); 
	    List<Integer> possible = new ArrayList<>();
	    helper(target, coins, 0, possible, result);
	    return result;
	  }
	  //target:target sum，注意每次选择了一个币值和数量都会减少要凑的总数
	  //coins:所有不同的币种
	  //index:代表着一个币种（inedx是在coins的位置）index从0 开始到 coins.len - 1 结束
	  //possible:一种组合方式
	  //result: 将每一种组合方式加入这个result
	  private void helper(int target, int[] coins, int index, List<Integer> possible, List<List<Integer>> result){
	   
	    if (index == coins.length - 1) {//last coin type，表示之前的币种都完成了，在这个时候只用算还要多少个最后这个币种
	      if (target % coins[coins.length - 1] == 0) { //比如target等于99 - 95， 还差 4，最后一个币种是1，那么4%1
	        possible.add(target / coins[coins.length - 1]);//计算出个数并加入list
	        //possible.add(target);
	    	result.add(new ArrayList<Integer>(possible));
	        possible.remove(possible.size() - 1);
	      }
	      return;
	    }

	    //算每一种币种要多少个凑成总数target
	    //max：一个币种最多能要多少个，eg 如果target为99cents，那么25cents最多可以放4个
	    int max = target / coins[index];
	    for (int i = 0; i <= max; i++) {//<=因为最多可以放4个包含4个
	      possible.add(i);
	      //传入此币种使用后还要凑多少， 以及下一个币种是谁
	      helper(target - i * coins[index], coins, index + 1, possible, result);
	      possible.remove(possible.size() - 1);
	    }
	  }
	  
	  public static void print(List<List<Integer>> result) {
		  for(int i = 0; i < result.size(); i++) {
			  System.out.print(result.get(i).toString());
			  System.out.println();
		  }
		 
	  }
	  
	  public static void main(String[] args) {
		CombinationOfCoins combination = new CombinationOfCoins();
		int target = 99;
		int[] coins = {25, 10, 5, 1};
		List<List<Integer>> result = combination.combinations(target, coins);
		print(result);
		System.out.println(result.size());
	}

}
