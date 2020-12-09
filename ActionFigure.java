
/**
 * This method creates a new ActionFigure Object
 *
 * @author Dwayne Whyte
 * @version Oct 26, 2020
 */
public class ActionFigure implements Comparable
{
    /** Initializes name of Action Figure **/
    private String name = " ";
    /** Initializes cost of Action Figure**/
    private double retailvalue = 0;
    /** Initializes identification number of Action Figure **/
    private int id = 0;

    /**
     * Constructor for ActionFigure Object
     * @param - id,name,retailvalue
     */
    public ActionFigure(int id, String name,double retailvalue)
    {
        setId(id);
        setName(name);
        setRetailvalue(retailvalue);
    }  
    
    /**
     * This method gets the name of ActionFigure
     * @return - name
     */
    public String getName()
    {
        return name;
    } 
    
    /**
     * This method sets the Identification Number of ActionFigure
     * @param - id
    */
    public void setId(int id)
    { 
        this.id = id;
    }
    
     /**
     * This method sets the name of ActionFigure
     * @param - name
     */
    public void setName(String name)
    { 
    this.name = name;
    }
    
    /**
     * This method sets the RetailValue of ActionFigure
     * @param - retailvalue
     */
    public void setRetailvalue(double retailvalue)
    { 
        this.retailvalue = retailvalue;
    }
    
     /**
     * This method gets the RetailValue of ActionFigure
     * @return - retailvalue
     */
    public double getRetailValue()
    { 
      return retailvalue;  
    }
    
    /**
     * This method gets the Identification number of ActionFigure
     * @return - id
     */
    public int getId()
    { 
      return id;
    }
    
    /** This method overrides the toString() method of Object*/
    public String toString() 
    {
        String output = String.format("%-6d%-15s%.2f\n",id,name,retailvalue);
        return output;
    } 
    
    /** This method overrides the Comparable Interface compareTo() method*/
    @Override
    public int compareTo(Object other) 
    { 
    int compareid = ((ActionFigure) other).getId();
    return this.id-compareid;
    }
}
