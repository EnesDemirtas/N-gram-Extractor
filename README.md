# What is N-gram Extractor
N-gram Extractor is a program that detects recurring words' frequency and prints them to a output file.

## How to use N-gram Extractor?
Firstly, *n* letter refers to desired word frequency. 
For instance, if you type 1 as n value, the words will be separated one by one. If you type 2 as n value, the words will be grouped from beginning to end with 2 words for each group. There is no limitation about n value. Then, you should have a text file which contains your input text. 

### Example
Suppose that our input.txt file contains a text below:
```sh
During the summer of 1968, representatives from the initial four sites met several times to discuss the HOST software and initial experiments on the network.
```

* ```javac NgramExtractor.java```

After compiled Java file, we can send the parameters by order **input_file output_file frequency_value_n**

* ```java NgramExtractor input.txt output.txt 2```

As a result, our output file's content is: 

```sh
Total number of tokens: 23

ngram,count,frequency
sites met,1,4.3478260869565215
the network,1,4.3478260869565215
from the,1,4.3478260869565215
to discuss,1,4.3478260869565215
and initial,1,4.3478260869565215
representatives from,1,4.3478260869565215
the initial,1,4.3478260869565215
host software,1,4.3478260869565215
the host,1,4.3478260869565215
the summer,1,4.3478260869565215
during the,1,4.3478260869565215
met several,1,4.3478260869565215
times to,1,4.3478260869565215
experiments on,1,4.3478260869565215
initial experiments,1,4.3478260869565215
four sites,1,4.3478260869565215
software and,1,4.3478260869565215
several times,1,4.3478260869565215
discuss the,1,4.3478260869565215
on the,1,4.3478260869565215
summer of,1,4.3478260869565215
of representatives,1,4.3478260869565215
initial four,1,4.3478260869565215


```
