package com.mine;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by nidhish on 6/13/15.
 */

/*
5 5
2 22 10 12 2
1 2 4
1 2 5
1 1 5
2 2 3
1 2 4


Sample Output

10 3 3
2 5 5
2 1 1
3 2 2
Explanation

For the 1st query 1 2 4, these sub-intervals are possible:

[2,2] = 22
[2,3] = 22 * 10 = 220
[2,4] = 22 * 10 * 12 = 2640
[3,3] = 10
[3,4] = 10 * 12 = 120
[4,4] = 12


 */
public class CriticalMassProblem {

    public static void main(String[] args) throws FileNotFoundException {

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("/home/nidhish/otherprojects/funstuff/src/test/java/inputfile.txt"));

        Scanner input = new Scanner(inputStream);



//	    String arraySizeAndInputSizeString = input.nextLine();

        String inputLengthString = input.nextLine();

        int inputLength = findSingleInputLength(inputLengthString);

        for (int i = 0; i < inputLength; i++) {
            String[] numStudentsAndRequiredStudents = input.nextLine().split(" ");
            int numStudents = Integer.parseInt(numStudentsAndRequiredStudents[0]);
            int requiredStudents = Integer.parseInt(numStudentsAndRequiredStudents[1]);

            String[] arrivalTimeString = input.nextLine().split(" ");

            int criticalMass = 0;
            for (int j = 0; j < numStudents; j++) {
                int arrivalTime = Integer.parseInt(arrivalTimeString[j]);
                if (arrivalTime <= 0) {
                    criticalMass++;
                }
                if (criticalMass >= requiredStudents) {
                    System.out.println("NO");
                    break;
                }
            }
            if (criticalMass<requiredStudents) {
                System.out.println("YES");
            }
        }

    }

    private static int findSingleInputLength(String inputLengthString) {
        return Integer.parseInt(inputLengthString.trim());
    }

//            int allInputInt[] = fetchAllInput(inputLength, input);
//
//
//            int outputInt[] = processInput(allInputInt,inputLength);

//        readArraySizeAndInputSizeString(arraySizeAndInputSizeString);


//        readArrayAndDoSomething(input, lineNumber, arraySize, inputSize);


    private static int[] processInput(int[] allInputInt, int inputLength) {

//        Node previousNode = null;
//
//        for (int i = 0; i <inputLength; i++) {
//
//            Node node = new Node();
//
//            node.data = allInputInt[0];
//
//            previousNode = node;
//
//
//        }


        return allInputInt;
    }


    private static int[] fetchAllInput(int inputLength, Scanner input) {
        int[] allInput = new int[inputLength];

        for (int i = 0; i < inputLength; i++) {
            allInput[i] = Integer.parseInt(input.next());
            System.out.println(allInput[i]);
        }
        return allInput;
    }



    private static void readArrayAndDoSomething(Scanner input, int lineNumber, int arraySize, int inputSize) {
        int[] inputArray = new int[inputSize];

        while (input.hasNext()) {
            String array = input.nextLine();
            String inputStringArray[] = array.split(" ");

            for (int i = 0; i < arraySize; i++) {
                inputArray[i] = Integer.parseInt(inputStringArray[i]);
            }

            System.out.println("Input array is ");

            for (int i = 0; i < inputSize; i++) {
                System.out.print(inputArray[i] + ", ");
            }
            System.out.println("");
            break;
        }

        while (input.hasNext() && lineNumber <= inputSize) {
            String problem = input.nextLine();
            String[] problemArray = problem.split(" ");
            int problemType = Integer.parseInt(problemArray[0]);
            int startIndex = Integer.parseInt(problemArray[1]) - 1;
            int lastIndex = Integer.parseInt(problemArray[2]) - 1;

//            System.out.println("Problem type is " + problemType + " startIndex = " + startIndex + " lastIndex = " + lastIndex);
            lineNumber++;


            /*
            [2,2] = 22
            [2,3] = 22 * 10 = 220
	    [2,4] = 22 * 10 * 12 = 2640
	    [3,3] = 10
	    [3,4] = 10 * 12 = 120
            [4,4] = 12
             */
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            int maxIndex = 0;

            if (problemType == 1) {

                int curentRangeStart = startIndex; //2
                int currentRangeEnd = startIndex;  //2
                int productofRange = 1;

                while (curentRangeStart <= lastIndex) {
                    while (currentRangeEnd <= lastIndex) {
                        int tempRangeStart = curentRangeStart;
                        int tempRangeEnd = currentRangeEnd;
                        while (tempRangeStart <= tempRangeEnd) {

                            productofRange = productofRange * inputArray[tempRangeStart];
                            tempRangeStart++;
                        }
                        if (minValue > productofRange) {
                            minValue = productofRange;
                            minIndex = curentRangeStart;
                            maxIndex = currentRangeEnd;
                        }
                        productofRange = 1;
                        currentRangeEnd++;
                    }
                    curentRangeStart++;
                }

//                System.out.println(" Min value is " + minValue + " min index is " + minIndex +  " max index is " +  maxIndex);

                System.out.println(minValue + " " + minIndex + " " + maxIndex);

                minValue = 0;
                maxIndex = 0;
                minIndex = 0;
            } else if (problemType == 2) {
                inputArray[startIndex] = lastIndex;
            }
        }
    }

    private static void readArraySizeAndInputSizeString(String arraySizeAndInputSizeString) {
        String[] arraySizeAndInputSizeArray = arraySizeAndInputSizeString.split(" ");
        int arraySize = Integer.parseInt(arraySizeAndInputSizeArray[0]);
        int inputSize = Integer.parseInt(arraySizeAndInputSizeArray[1]);


        System.out.println("Array size is " + arraySize);
        System.out.println("Input size is " + inputSize);
    }
}
