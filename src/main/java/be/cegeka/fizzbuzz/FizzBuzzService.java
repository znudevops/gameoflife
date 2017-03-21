package be.cegeka.fizzbuzz;

public class FizzBuzzService {

    public Integer[] fizzBuzz(int sequenceNumber) {

//        return IntStream
//            .range(1, sequenceNumber + 1)
//            .boxed()
//            .collect(Collectors.toList())
//            .toArray(new Integer[sequenceNumber]);

        Integer[] fizzBuzzSequence = new Integer[sequenceNumber];
        for(int i = 0; i < sequenceNumber; i++) {
            fizzBuzzSequence[i] = i+1;
        }
        return fizzBuzzSequence;
    }

}
