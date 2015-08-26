package com.mine;

import java.util.Scanner;

public class SolutionTemplate {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int lineNumber=0;
        int arraySize = 0;
        int inputSize = 0;

        while (input.hasNext()) {
            String arraySizeAndInputSizeString = input.nextLine();
            String[] arraySizeAndInputSizeArray = arraySizeAndInputSizeString.split(" ");
            arraySize = Integer.parseInt(arraySizeAndInputSizeArray[0]);
            inputSize = Integer.parseInt(arraySizeAndInputSizeArray[1]);


            System.out.println("Array size is " + arraySize);
            System.out.println("Input size is " + inputSize);

            break;
        }

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

        while (input.hasNext()  && lineNumber<=inputSize){
            String problem = input.nextLine();
            String[] problemArray = problem.split(" ");
            int problemType = Integer.parseInt(problemArray[0]);
            int startIndex = Integer.parseInt(problemArray[1])-1;
            int lastIndex = Integer.parseInt(problemArray[2])-1;

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

            if (problemType == 1){

                int curentRangeStart = startIndex; //2
                int currentRangeEnd = startIndex;  //2
                int productofRange = 1;

                while (curentRangeStart<= lastIndex) {
                    while (currentRangeEnd <= lastIndex) {
                        int tempRangeStart = curentRangeStart;
                        int tempRangeEnd = currentRangeEnd;
                        while (tempRangeStart <= tempRangeEnd) {

                            productofRange = productofRange * inputArray[tempRangeStart] ;
                            tempRangeStart++;
                        }
                        if (minValue > productofRange){
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

                minValue =0;
                maxIndex = 0;
                minIndex = 0;
            }else if (problemType == 2){
                inputArray[startIndex] = lastIndex;
            }
        }
    }
}