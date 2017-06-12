import java.util.Comparator;
class distComparator implements Comparator<Site>{
  
    public int compare(Site a, Site b){
       return a.getDist() - b.getDist();
    }
  
}