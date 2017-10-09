import java.util.Arrays;

public class maxConsistentCut {

    public static void main(String[] args) {
    	calcMaxCC();
    }

    public static int[] calcMaxCC()
    {
    	//vector clocks stored into store array for processors: p0, p1, p2
        int store0[][]={{1,0,0},{2,0,0},{3,0,0},{4,4,5},{5,4,5}};
        int store1[][]={{1,1,0},{1,2,3},{1,3,3},{2,4,5}};
        int store2[][]={{0,0,1},{0,0,2},{0,0,3},{2,0,4},{2,0,5},{2,3,6}, {2,3,7}};
        
        int maxCut[]={0,0,1};      
        int givenCut[]={0,0,0};
        
        //check if givenCut is valid
        int p0 = givenCut[0] - 1;
        int p1 = givenCut[1] - 1;
        int p2 = givenCut[2] - 1;
        
        
        //comparing the given cut to the maximum cut. 
        
        for(int i = p0; i< store0.length && i >= 0;)
        {
          if (store0[i][0] <= givenCut[0] && store0[i][1] <= givenCut[1]  && store0[i][2] <= givenCut[2])
          {maxCut[0] = store0[i][0];
           break;}
          else
          {i--;}
        }
        
        for(int i = p1; i< store1.length && i >= 0;)
        {
          if (store1[i][0] <= givenCut[0] && store1[i][1] <= givenCut[1]  && store1[i][2] <= givenCut[2])
          {maxCut[1] = store1[i][1];
           break;}
          else
          {i--;}
        }
        
        for(int i = p2; i< store2.length && i >= 0;)
        {
          if (store2[i][0] <= givenCut[0] && store2[i][1] <= givenCut[1]  && store2[i][2] <= givenCut[2])
          {maxCut[2] = store2[i][2];
           break;}
          else
          {i--;}
        }
        
        System.out.println("Given Cut: " + Arrays.toString(givenCut));      
        System.out.println("Max Consisent Cut is: " + Arrays.toString(maxCut));
        return maxCut;
}
}
