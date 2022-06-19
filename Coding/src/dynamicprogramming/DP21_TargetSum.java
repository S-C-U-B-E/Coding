package dynamicprogramming;


//THIS QUESTION IS DP18_PartitionsWithGivenDifference
//HERE WE NEED TO NOTICE THAT PLUS AND MINUS WILL CREATE TWO UNIQUE SUBSETS THAT WILL AGAIN FOLLOW THE BELOW

//1. Same as DP17 but with a modified target
//S1 - S2 = D and S1 + S2 = TotalSum
//TotalSum - S2 - S2 = D
//TotalSum - D = 2 x S2
//
//S2 = (TotalSum - D)/2 = target

//2. Add the base cases considering the array will have 0s. We will not stop the recursion when target becomes 0, rather we will 
//let it move towards index 0

public class DP21_TargetSum {

}
