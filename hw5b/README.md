Homework 5-b: Readme.txt Maximal-consistent-cut

Introduction: The following Java program implements an algorithm to get the maximal consistent cut.

A cut k through an execution is an n vector of positive integers. K = <k0, k1, k2, ...kn>. A cut is consistent if for all i, j, the ki + 1st computation event of Pi in alpha does not happen before the kjth computation event of Pj. The kjth computation event of Pj does not depend on any action taken by another processor after the cut.

Algorithm approach: For each processor in the system find the most recent event with the use of vector clock v<= r. Where v is the vector clocks and r is the given cut. When a cut is given if the cut is a consistent cut then the algorithm will return back the given cut as any given consistent cut is the maximal cut. Given an inconsistent cut however we would have to calculate the maximal consistent cut.

We stored all the vector clock calculations from the three process model given into arrays. Each processor has its own store array. We start with a given cut. From this given cut we find the corresponding vector clock in each store array and compare the entire vector clock to the given cut. If the vector clock is less than or equal to the given cut we take that from the vector clock that processor's corresponding ith value and place it into the respectful index of maxCut array. If the comparison is not true i.e. vector is not less than or equal to the given cut we traverse back in the store array by 1 and repeat the comparison till we find a vector clock that satisfies the comparison. After exhausting all the three processes in the system we have our maximum consistent cut. 

Files included in Project: maxConsistentCut.java

Tester Cases: We chose to test multiple different given cuts both consistent and inconsistent. Our algorithm holds true for all cases.