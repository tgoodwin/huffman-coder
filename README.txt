TO RUN: type the following into the console (after compiling)

java HuffmanTreeTest text.txt


BinaryHeap.java is Weiss's Binary Heap implementation. I have modified it to contain a getSize method.

HuffmanTree.java is a class where I implement a HuffmanTree.  This class creates a HuffmanTree from a text file passed in as an input.The class reads the file, determines the frequencies of each character,
 and uses those frequencies to construct a HuffmanTree. The class then uses
 the tree to generate Huffman codes for each character in the file. The class
 prints these codes in a table in the console. The class also contains encode
 and decode methods that translate between text characters and the Huffman codes
 based on the text file's Huffman tree.

 HuffmanTreeTest.java

This class creates a HuffmanTree object and creates a TreeShape object and a TreeComponent object to display the HuffmanTree graphically. This is where the GUI is built, with a panel displaying the Huffman tree, as well as buttons that call the HuffmanTree class's encode and decode methods.

TreeShape.java is the class that draws a Huffman Tree based on a HashMap from the HuffmanTree class that contains the characters in the tree and their respective Huffman codes. The class draws the tree by creating a set out of all the codes mapped in the HashMap. The class draws a series of lines based on the 0's and 1's in the code, where the x component of the line diminishes by a factor of 2 each time the line to a child is being drawn, and the y component remains constant. The class draws a set of lines for each code in the map, where the superposition of the lines results in a visual representation of the tree. Circles and text data representing the tree's characters are added to the leaf nodes in the tree. The Huffman code corresponding to each character is printed below each leaf node.

TreeComponent.java creates a TreeShape object and sets its size.

DecodeListener.java and EncodeListener.java are both classes that contain the workings behind the "Decode" and "Encode" buttons on the GUI created in HuffmanTreeTest.
They call the respective methods of the HuffmanTree class and transform user input data (which must correspond to the displayed tree, otherwise an error is displayed) between plain text and the Huffman codes generated for the input text file.

TO USE:

HuffmanTreeTest will take in a text file specified by the user and print out to the user a table of Huffman codes for their text, as well as display a GUI so the user can interact with their data and experience their content in a new way.

HuffmanTreeTest takes in a text file (.txt) in the command line.
For example, if your desired file is called text.txt (the example included in my submission), then the command to run the program will look like this:

java HuffmanTreeTest text.txt
