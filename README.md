# 345_huffman
A program written in Java that will take text and encode it following a greedy Huffman
Encoding algorithm. 

## Test Instructions

### Huffman Tree Test 
This test file just compiles a Huffman Tree preloaded with the string "Huffman Test String" and was
used to initally test the HuffmanTree class. The test file prints out the encodings for each of the
characters in the test string. The test string could be changed out by editing the string under the
test variable.

### Compression Ratio Calculator:
This test file calculates the compression ratios of 2 .txt files and compares their compression ratios. 
Two files, "Lorem.txt" and "random.txt" have been provided. The compression ratio is equal to the uncompressed
size divided by the compressed size. This test will prompt the user for input through the console. When it 
asks for a file name that should be the file path such as 'Lorem.txt' followed by enter/return. The test will
run the encoding procedure and report which file was compressed more efficiently.

### Decompression Test
This test is used to confirm the lossless compression aspect of the the huffman encoding algorithm. This test asks the user for an input of a file ("Lorem.txt" or "random.txt") and followed by enter/return. The algorithm prints the compressed data representation, decompresses the endocing, and prints the decompressed text. The original text and the decompressed text are then comapred for loss of data. 
