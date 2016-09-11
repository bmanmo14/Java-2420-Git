package assignment04;

import org.junit.Test;

public class AnagramUtilTest {

	@Test
	public void testSort() {
		String a = "Kale";
		String b = "later";
		String c = "HELLO";
		String d = "Brandon";
		if(AnagramUtil.sort(a).compareTo("aekl") != 0){
			System.err.println("sort() failed.");
		}
		if(AnagramUtil.sort(b).compareTo("aelrt") != 0){
			System.err.println("sort() failed.");
		}
		if(AnagramUtil.sort(c).compareTo("ehllo") != 0){
			System.err.println("sort() failed.");
		}
		if(AnagramUtil.sort(d).compareTo("abdnnor") != 0){
			System.err.println("sort() failed.");
		}
	}
	
	@Test
	public void testLargestAnagramGroup(){
		String[] testArray = {"alerted", "grape", "related", "idiot", "treadle", "altered", "apple"};
		String[] isAnagram = AnagramUtil.getLargestAnagramGroup(testArray);
		// When getLargestAnagramGroup is called on the test array, isAnagram should contain
		// [alerted, related, treadle, altered].
		if(isAnagram[0] != "alerted"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		if(isAnagram[1] != "related"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		if(isAnagram[2] != "treadle"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		if(isAnagram[3] != "altered"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		
		String[] newTestArray = {"least", "hello", "setal", "how", "slate", "are", "stale", "you", "steal", "today", "stela", "taels", "horse", "tales", "violet", "teals", "tesla"};
		String[] newIsAnagram = AnagramUtil.getLargestAnagramGroup(newTestArray);
		// When getLargestAnagramGroup is called on the test array, newIsAnagram should contain
		// [least, setal, slate, stale, steal, stela, taels, tales, teals, tesla].
		if(newIsAnagram[0] != "least"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		if(newIsAnagram[2] != "slate"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		if(newIsAnagram[4] != "steal"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		if(newIsAnagram[6] != "taels"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		if(newIsAnagram[9] != "tesla"){
			System.err.println("getLargestAnagramGroup failed()");
		}
		
		// Now lets pass in an array with no Anagrams.
		// The function should return an empty array.
		String[] noAnagrams = {"Brandon", "Kale", "christmas", "birthday", "summer"};
		String[] shouldBeEmpty = AnagramUtil.getLargestAnagramGroup(noAnagrams);
		// The size of this array should be zero, because it is empty.
		if(shouldBeEmpty.length != 0){
			System.err.println("getLargestAnagramGroup() failed.");
		}
	}
	
	@Test
	public void testInsertionSort(){
		// Create a new array and sort it with the comparator in the AnagramUtil class.
		String[] testArray = {"alerted", "grape", "related", "Idiot", "treadle", "altered", "Apple"};
		AnagramUtil.insertionSort(testArray, AnagramUtil.myComparator());
		// The sorted array should look like this:
		// [Apple, Idiot, alerted, altered, grape, related, treadle]
		if(testArray[0].compareTo("Apple") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray[2].compareTo("alerted") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray[4].compareTo("grape") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray[6].compareTo("treadle") != 0){
			System.err.println("insertionSort() failed.");
		}
		// Create another. Just for good measure.
		String[] testArray2 = {"least", "Hello", "setal", "how", "slate", "are", "stale", "you", "Steal", "today", "stela", "Taels", "horse"};
		AnagramUtil.insertionSort(testArray2, AnagramUtil.myComparator());
		// If the function worked correctly, the array should look like this:
		// [Hello, Steal, Taels, are, horse, how, least, setal, slate, stale, stela, today, you]
		if(testArray2[0].compareTo("Hello") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray2[3].compareTo("are") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray2[5].compareTo("how") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray2[7].compareTo("setal") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray2[9].compareTo("stale") != 0){
			System.err.println("insertionSort() failed.");
		}
		if(testArray2[12].compareTo("you") != 0){
			System.err.println("insertionSort() failed.");
		}
	}
	
	@Test
	public void testLargestGroupFromFile(){
		String[] largestGroupAnagram = AnagramUtil.getLargestAnagramGroup("sample_word_list.txt");
		// If the function works correctly, the largestGroupAnagram array should contain:
		// [carets, Caters, caster, crates, Reacts, recast, traces]
		if(largestGroupAnagram[0].compareTo("carets") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		if(largestGroupAnagram[1].compareTo("Caters") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		if(largestGroupAnagram[4].compareTo("Reacts") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		if(largestGroupAnagram[6].compareTo("traces") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}

		String[] largestGroupAnagram2 = AnagramUtil.getLargestAnagramGroup("big_word_list.txt");
		// If the function works correctly, the largestGroupAnagram array should contain:
		// [alerts, alters, artels, Estral, laster, ratels, salter, slater, staler, stelar, Talers]
		if(largestGroupAnagram2[0].compareTo("alerts") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		if(largestGroupAnagram2[1].compareTo("alters") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		if(largestGroupAnagram2[6].compareTo("salter") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		if(largestGroupAnagram2[8].compareTo("staler") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		if(largestGroupAnagram2[10].compareTo("Talers") != 0) {
			System.err.println("getLargestAnagramGroup(file) failed");
		}
		// If the file that is passed in does not exist, the function should return an empty array.
		String[] largestGroupAnagram3 = AnagramUtil.getLargestAnagramGroup("does_not_exist.txt");
		if(largestGroupAnagram3.length != 0){
			System.err.println("getLargestAnagramGroup(file) failed");
		}
	}
	
	@Test
	public void testIsAnagram(){
		// Create a couple of strings that are anagrams to test the anagram function.
		String a = "palest";
		String b = "palets";
		String c = "pastel";
		String d = "petals";
		String e = "plates";
		String f = "pleats";
		
		// Compare the two strings. If they are not anagrams, the function will print an error.
		if(!AnagramUtil.areAnagrams(a, b)){
			System.err.println("areAnagrams() failed.");
		}
		if(!AnagramUtil.areAnagrams(b, c)){
			System.err.println("areAnagrams() failed.");
		}
		if(!AnagramUtil.areAnagrams(c, d)){
			System.err.println("areAnagrams() failed.");
		}
		if(!AnagramUtil.areAnagrams(e, f)){
			System.err.println("areAnagrams() failed.");
		}
		
		// Now we make two strings that are not equal, if the function says they are anagrams, the function is broken.
		String g = "Iloveyousomuch";
		String h = "Ihateyousomuch";
		String i = "Whattimeisit";
		String j = "Whatdayisit";
		if(AnagramUtil.areAnagrams(g, h)){
			System.err.println("areAnagrams() failed.");
		}
		if(AnagramUtil.areAnagrams(i, j)){
			System.err.println("areAnagrams() failed.");
		}
		
	}
}
