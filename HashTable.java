/**
@author Hridika Banik <a 
href="mailto:hridika.banik@ucalgary.ca">firstname.lastname@ucalgary.ca</a>
@version 1.4
@since 1.0
UCID: 30123716
Tutorial number: T05
TA Name: Roghayeh Heidari
*/
public class HashTable {
    private final int size;
    private String[] hasharray;
    private int records = 0;
    private double loadFactor; 
    private int[] readcount;
    private final String probefun;
    /*This code has been adapted from:
     *Reference: https://www.newthinktank.com/2013/03/java-hash-table/
     */
    public HashTable(int size, String probe){
        hasharray = new String[size];
        readcount = new int[size];
        if(!probe.toLowerCase().equals("l") && !probe.toLowerCase().equals("q")){
            throw new IllegalArgumentException("Error! Enter L or Q");
        }
        this.probefun = probe;
        this.size = size;
    }
    private int hashfunt(String str){
        char[] Char1 = str.toCharArray();
        int hashcount = 3;
        for(int m = 0; m < Char1.length; m++){
            hashcount = hashcount * 31 + (int) Char1[m];
        }
        hashcount = Math.abs(hashcount % this.size);       
        if(this.records > this.size){
            System.out.println("Error! Array too small, Try Again");
            throw new IndexOutOfBoundsException();
        }
        return hashcount;
    }
    public void add(String value){
        int index = hashfunt(value);
        int reccount = 1;
        if(this.probefun.equals("q")){
            if(this.hasharray[index] == null){
                this.hasharray[index] = value;
                this.readcount[this.records] = reccount;
                this.records++;
                return;}
            int i = 1;
            while(this.hasharray[index] != null){
                index = (index + i*i)%this.size;
                reccount = reccount +1;
                if(this.hasharray[index] == null ){
                    this.hasharray[index] = value;
                    this.readcount[this.records] = reccount;
                    this.records++;
                    return;}
                i++;}}
        if(this.probefun.equals("l")){
            if(this.hasharray[index] == null){
                this.hasharray[index] = value;
                this.readcount[this.records] = reccount;
                this.records++;
                return;}
            while(this.hasharray[index] != null){
                index= index + 1;
                if(index >= size){
                    index %= size;}
                reccount= reccount + 1;
                if(this.hasharray[index] == null){
                    this.hasharray[index] = value;
                    this.readcount[this.records] = reccount;
                    this.records++;
                    return;
                }
            }
        }
    }
    public double LoadFactor(){
        double d =  ((double)this.records/(double)this.size);
        this.loadFactor = d;
        return this.loadFactor * 100;}
    public int GetRecords(){
        return this.records;
    }
    public double HashEffeciency(){
        int totalReadcount = 0;
        for(int i = 0;i < readcount.length; i++){
            totalReadcount += this.readcount[i];
        }        
        double Record = ((double)totalReadcount/(double)this.records);
        double hashEff = this.loadFactor/Record;
        return hashEff * 100;
    }
    public int totalCount() {
        int totalReads = 0;
        for(int i = 0;i < readcount.length; i++){
            totalReads += this.readcount[i];
        }    
        return totalReads;
    }
    public double rRecord(){
        int totalReads = 0;
        for(int i = 0;i < readcount.length; i++){
            totalReads += this.readcount[i];}        
        return (double)totalReads/(double)this.records;
        
    }
    public int getSize(){
        return this.size;
    }
    public int longestChain(){
        bubbleSort(this.readcount);
        return this.readcount[this.size-1];
    }
    

    /*This code has been adapted from:
     *Reference:https://www.geeksforgeeks.org/bubble-sort/
     */
    private void bubbleSort(int arr[]){
		int numlen = arr.length;
		for (int j = 0; j < numlen-1; j++)
			for (int k = 0; k < numlen-j-1; k++)
				if (arr[k] > arr[k+1]){
                    int t = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = t;}
	}
}