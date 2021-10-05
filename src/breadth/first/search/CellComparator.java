package breadth.first.search;

import java.util.Comparator;

public class CellComparator implements Comparator<Cell>{
	  
        // Overriding compare()method of Comparator for ascending order of cell
		@Override
		public int compare(Cell c1, Cell c2) {
			if(c1.value == c2.value) {
				return 0;
			}else {
				return c1.value < c2.value ? -1 : 1;
			}
		}
    
}
