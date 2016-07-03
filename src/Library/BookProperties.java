package Library;

/**
 * @author yusuf
 *Maybe change back to old.
 */
public enum BookProperties {

//	Invalid(null), Title("Title"), Author("Author"), Publisher("Publisher"), PubYear("PubYear"), ID("ID"),
//	GradeLevel("GradeLevel"), NumAvailable("NumAvailable");
	Invalid(-1), Title(00), Author(01), Publisher(02), PubYear(03), ID(04),
	GradeLevel(05), NumAvailable(06);
	
	private int bookProperty;

    private BookProperties(int bookProp) {
        this.bookProperty = bookProp;
    }

    public int getProperty() {
        return bookProperty;
    }
    
    public static BookProperties getProp(int num){
    	if(num == 0){
    		return Title;
    	} else if(num == 1){
    		return Author;
    	} else if(num == 2){
    		return Publisher;
    	} else if(num==3){
    		return PubYear;
    	} else if(num==4){
    		return ID;
    	} else if(num == 5){
    		return GradeLevel;
    	} else if(num == 6){
    		return NumAvailable;
    	} else {
    		return Invalid;
    	}
    }
}
