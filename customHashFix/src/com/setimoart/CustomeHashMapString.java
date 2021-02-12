package com.setimoart;

class KeyNotFoundException extends Exception{
    public KeyNotFoundException(String message){
        super(message);
    }
}

public class CustomeHashMapString {

    private class Container{
        Container next;
        String key;
        String value;
    }

    private int arraySize = 5;//the size needs to be prime
    private Container[] hashTable = new Container[arraySize];
    private int totalItems = 0;

    void putValue(String key, String value){
        //first we need to find which index of hashtable is proper to add the value
        int hashValue = computeHashValue(key);
        int index=hashValue % hashTable.length; //is the formula to find the index of the hashtable
        Container current = hashTable[index];
        //1 - container is not null because I need to check if the value exists in there or not
        while(current != null){
            if (current.key.equals(key)){
                current.value = value;
                return;
            }
            current = current.next;
        }

        Container newNode = new Container();
        newNode.value = value;
        newNode.key = key;
        //insert the node at the beginning of the hashtable selected index
        newNode.next = hashTable[index];
        hashTable[index] = newNode;
        totalItems++;

        //to check the size of my hashtable
        if(totalItems > 2*(hashTable.length)){
            resizeHashTable();
        }
    }

    String getValue(String key) throws KeyNotFoundException {
        int hashValue = computeHashValue(key);
        int index=hashValue % hashTable.length;

        Container curr = hashTable[index];
        while(curr != null){
            if (curr.key.equals(key)){
                return curr.value;
            }
            curr = curr.next;
        }
        throw new KeyNotFoundException("The key not found");
    }

    boolean hasKey(String key){
        int hashValue = computeHashValue(key);
        int index=hashValue % hashTable.length;
        Container curr = hashTable[index];
        while(curr != null){
            if (curr.key.equals(key)){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    String[] getAllKeys(){
        int index =0;
        String[] result = new String[totalItems];
        for (int i=0; i< hashTable.length; i++){
            Container curr = hashTable[i];
            while(curr != null){
                result[index] = curr.key; //MY bad :(
                curr = curr.next;
                index++;
            }
        }
        return result;
    }

    void deleteByKey(String key) throws KeyNotFoundException {
        int hashValue = computeHashValue(key);
        int index=hashValue % hashTable.length;

        Container curr = hashTable[index];
        Container previous = null;
        while(curr != null){
            if (curr.key.equals(key)){
                break;
            }
            previous = curr;
            curr = curr.next;
        }

        // current is only null when I don't arrive to the upper loop
        // Or after the loop finishes I coun't find it
        if (curr == null){ //key not found at the end of navigation
            throw new KeyNotFoundException("The key is not there");
        }
        if (previous == null){ // remove the first item because the previous is null so I am the first node in the list
            hashTable[index] = curr.next;
        }else{
            previous.next = curr.next;
        }
        totalItems--;
    }

    void printDebug(){
        for (int i=0; i< hashTable.length ; i++){
            System.out.printf("Entry %d: \n", i);
            Container curr = hashTable[i];
            while (curr != null){
                System.out.printf(" - key %s, value %s \n", curr.key, curr.value);
                curr = curr.next;
            }
        }
    }

    @Override
    public String toString() {
//        String[] keysArray = getAllKeys();
//        Arrays.sort(keysArray);
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (int i=0; i< keysArray.length; i++){
//            try {
//                String key = keysArray[i];
//                String val = getValue(key);
//                sb.append(i == 0 ? "" : ",");
//                sb.append(key).append("-->").append(val);
//            }
//            catch (KeyNotFoundException e) {
//                System.out.println(e.getMessage());
//            }
//
//        }
//        sb.append("]");
//        return sb.toString();

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0; i< hashTable.length; i++){
            Container s = hashTable[i];
            while( s != null) {
                sb.append(i == 0 ? "" : ",");
                sb.append(s.key).append("-->").append(s.value);
                s = s.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private boolean isPrime(int number){
        for(int i=2; i<= number/2; i++){
            if (number % i == 0 ){
                return false;
            }
        }
        return true;
    }

    private int computeHashValue(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash <<= 1;  // same as: hash *= 2, adding xor may be better
            char c = key.charAt(i);
            //hash += c;
            hash = hash ^ c;
        }
//        return hash;
        return key.hashCode();
    }

    private void resizeHashTable(){

        arraySize = getNextPrime(arraySize);

        Container[] newHashTable = new Container[arraySize];

        for (int i=0; i< hashTable.length ; i++){
            Container curr = hashTable[i];
            while(curr != null) {
                if(newHashTable[computeHashValue(curr.key) % arraySize] != null) {
                    Container temp = new Container();
                    temp.key = curr.key;
                    temp.value = curr.value;
                    temp.next = newHashTable[computeHashValue(curr.key) % arraySize];
                    newHashTable[computeHashValue(curr.key) % arraySize] = temp;
                }else{

                    Container temp = new Container();
                    newHashTable[computeHashValue(curr.key) % arraySize] = temp;
                    temp.key = curr.key;
                    temp.value = curr.value;
                }

                curr = curr.next;
            }

        }

        hashTable = newHashTable;
        

//         the size needs to be a prime number
//        arraySize = getNextPrime(arraySize);
//        Container[] newHashTable = new Container[arraySize];
//        for (int i=0; i< hashTable.length ; i++){
//            newHashTable[i] = hashTable[i];
//        }
//        hashTable = newHashTable;
    }

    private int getNextPrime(int number){
        int num = number * 2;
        while(true){
            if (isPrime(num)){
                return num;
            }
            num++;
        }
    }

}
