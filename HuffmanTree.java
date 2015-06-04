/* HuffmanTree class by Timothy Goodwin
 * tlg2132
 * COMSW3134
 * 
 * This class creates a HuffmanTree from a text file passed in as an input.
 * The class reads the file, determines the frequencies of each character,
 * and uses those frequencies to construct a HuffmanTree. The class then uses
 * the tree to generate Huffman codes for each character in the file. The class
 * prints these codes in a table in the console. The class also contains encode
 * and decode methods that translate between text characters and the Huffman codes
 * based on the text file's Huffman tree. 
 * 
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

public class HuffmanTree {
	
	BinaryHeap<HuffNode> heap = new BinaryHeap<>();
	private HuffNode root;
	HashMap<Character, String> codeMap;
	
	public HuffmanTree(Scanner in) {
		
	}

	private static class HuffNode implements Comparable<HuffNode>{
		char key;
		int freq;
		HuffNode right;
		HuffNode left;
		
		HuffNode(Character c, int f){
			this(c, f, null, null);
		}
		
		HuffNode(char c, int f, HuffNode r, HuffNode l){
			key = c;
			freq = f;
			right = r;
			left = l;
		}
		public int compareTo(HuffNode b){
			if (this.freq > b.freq)
				return 1;
			else if (this.freq < b.freq)
				return -1;
			else
				return 0;
		}
		public boolean isLeaf(){
			if (this.left == null && this.right == null)
				return true;
			else
				return false;
		}
	}
	
	public void FrequencyCount(Scanner in) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		int lineCount = 0;
		while (in.hasNextLine()){
			char[] line = in.nextLine().toCharArray();
			for (char c : line){
				if (charMap.containsKey(c)){
					int frequency = charMap.get(c);
					charMap.remove(c);
					charMap.put(c, frequency + 1); //equivalent of adding 1 to frequency count
				}
				else
					charMap.put(c, 1);
			}
			lineCount++;
		}
		charMap.put('\n', lineCount); //in.nextLine() doesn't see new line characters
		//so I do it manually based on how many times in.nextLine is triggered.
		
		Set<Character> charSet = charMap.keySet();
		Collection<Integer> freqSet = charMap.values();
		
		Iterator<Character> charIterator = charSet.iterator();
		Iterator<Integer> freqIterator = freqSet.iterator();
		if (charSet.size() > 0) {
			for (int i = 0; i < charSet.size(); i++){
				int current = freqIterator.next();
				char currentLetter = charIterator.next();
				HuffNode x = new HuffNode(currentLetter, current);
				heap.insert(x);

	        }
			for (;;){
				if (heap.size() < 2)
					break;
				HuffNode right = heap.deleteMin();
				HuffNode left = heap.deleteMin();
				int sum = left.freq + right.freq;
				HuffNode thing = new HuffNode('t', sum, right, left);
				heap.insert(thing);
				
			}
			root = heap.deleteMin(); //last element in queue is root
		}
		else
			System.out.println("No characters found in file.");
			return;
	}
		
	private void PrintTree(String c, HuffNode r){ //recursive print method
		if (r != null){
			if (r.isLeaf() == true){
				codeMap.put(r.key, c);
				if (r.key == ' ')
					System.out.println("sp" + ": " + c);
				else if (r.key == '\t')
					System.out.println("ht" + ": " + c);
				else if (r.key == '\n')
					System.out.println("nl" + ": " + c);
				else
					System.out.println(r.key + ": " + c);
			}
			else {
				PrintTree(c + "0", r.left);
				PrintTree(c + "1", r.right);
			}
		}
	}
	public int PrintTree(Scanner in){
		FrequencyCount(in);
		String code = "";
		codeMap = new HashMap<Character, String>();
		System.out.println("Huffman codes: " + '\n');
		System.out.println("--------------");
		PrintTree(code, root);
		System.out.println("--------------");
		return codeMap.size();
	}
	public HashMap<Character, String> getMap(){
		return codeMap;
	}
	
	public String encoder(String t){
		String toCode = "";
		char[] str = t.toCharArray();
		if (t != null){
			for (int i = 0; i < str.length; i++){
				if (codeMap.containsKey(str[i]) == false){
					toCode = "text uncodeable.";
				}
				else 
					toCode += codeMap.get(str[i]);
			}
		}
		return toCode;
	}
	public String decoder(String c){ //decodes huffman codes
		
		String message = "";
		HuffNode n = root;
		for (int i = 0; i < c.length(); i++){
			if (c.charAt(i) == '1'){
				n = n.right;
			}
			if (c.charAt(i) == '0')
				n = n.left;
			if (n.isLeaf()){
				message += Character.toString(n.key); //add to decoded string
				n = root;
			}
		}
		return message;
		
	}
}
