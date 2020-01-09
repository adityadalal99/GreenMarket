package mypkg;

import java.util.HashMap;

public class getWeight {
    public HashMap<String,Double> getWeight_function(HashMap<String,Double> hm)
    {
    	HashMap<String,Double> hm1=new HashMap<>();
    	hm1.clear();
    	GoToProfileDao gtpd=new GoToProfileDao();
    	float atomic_mass;
    	float molecular_mass=0f;
    	String element="";
    	String subscript="";
    	for(String name:hm.keySet())
    	{	
    	  //int i=0;
    	  for(int i=0;i<name.length();i++)
    	  {
    		  element=Character.toString(name.charAt(i));
    		  while((i+1)<name.length()&&(int)(name.charAt(i+1))>='a'&&(int)(name.charAt(i+1))<='z')
    		  {
    			  element=element+name.charAt(i+1);
    			  i++;
    		  }
    		  i++;
    		  if(i==name.length()-1||(int)(name.charAt(i))>='A'&&(int)(name.charAt(i))<='Z')
    		  {
    			  atomic_mass=gtpd.get_db_weight(element);//whatever is the atm;
    			  molecular_mass+=atomic_mass;
    		  }
    		  else
    		  {
    			  while(i<name.length()&&(int)(name.charAt(i))>='0'&&(int)(name.charAt(i))<='9')
    			  {
    				  subscript=subscript+name.charAt(i);
    				  i++;
    			  }
    			 float subscript_val=Float.parseFloat(subscript);
    			  atomic_mass=gtpd.get_db_weight(element);//whatever it is;
    					  molecular_mass+=(subscript_val*atomic_mass);
    		  }
    		  element="";
    		  subscript="";
    	  }
    	  hm1.put(name,(double)molecular_mass);
    	}
    	//hm1.clear();
    	return hm1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
