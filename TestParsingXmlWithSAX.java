package File;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.w3c.dom.NodeList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Use JAXP SAX Parser to display all persons: title, names...
 * 
 * @author Huseyin OZVEREN
 * 
 */
public class TestParsingXmlWithSAX {
	
	private String currentElement;
        private String currentLevel;
	private int peopleCount = 1;
        private int relationCount = 1;
	// Constructor
       String id1,id2,name ,phase,passward,Level,BosName,points;
       String personId;
       ArrayList <User> Data1 = new ArrayList <User>();
	public TestParsingXmlWithSAX() {
		try {
			// Create a SAX parser factory
			SAXParserFactory factory1 = SAXParserFactory.newInstance(); 
			SAXParserFactory factory2 = SAXParserFactory.newInstance();
			// Obtain a SAX parser
			SAXParser saxParser1 = factory1.newSAXParser();
	        	SAXParser saxParser2 = factory2.newSAXParser();

			// XML Stream
			InputStream xmlStream = TestParsingXmlWithSAX.class.getResourceAsStream("user.xml");
			InputStream xmlStreamRel = TestParsingXmlWithSAX.class.getResourceAsStream("level.xml");

                        
			// Parse the given XML document using the callback handler
			saxParser1.parse(xmlStream, new MySaxHandler()); 
			saxParser2.parse(xmlStreamRel, new MySaxHandler()); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Entry main method
	public static void main(String args[]) {

		new TestParsingXmlWithSAX();
                
        }
         
       
	/*
	 * Inner class for the Callback Handlers.
	 */
	class MySaxHandler extends DefaultHandler {
		
		// Callback to handle element start tag
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			currentElement = qName;
                        currentLevel = qName;
                        
                      if (currentElement.equals("person")) {
				System.out.println("Person " + peopleCount);
				peopleCount++;
				 personId = attributes.getValue("ID");
				System.out.println("\tID:\t" + personId);
                             Data1.add(new User(personId ,"","","","","",""));
                               
			}
                           
                        if (currentLevel.equals("friendly")){
                            System.out.println("The Same Level " + relationCount+ " Between");
                            relationCount++;
                        
                            
		}
                          
                      
                       
                   
          }

		// Callback to handle element end tag
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			currentElement = "";
                        currentLevel = "";
		}
		// Callback to handle the character text data inside an element
		@Override
		public void characters(char[] chars, int start, int length) throws SAXException {
       
               if (currentElement.equals("User_Name")) {
                        
                              for (int i=0;i<Data1.size();i++)
                              { name = new String(chars, start, length);
                               if (Data1.get(i).id == personId){
				Data1.get(i).User_Name = name;
                             	System.out.println("\tName:" +name);

                              break;}
                             }
			}
                 else if (currentElement.equals("passward")) {
                           
                             for (int i=0;i<Data1.size();i++)
                              {  passward=new String(chars, start, length);
                              if (Data1.get(i).id == personId){
                              Data1.get(i).passward = passward;
				System.out.println("\t Passward:" +passward );
                                break;
			} }}
                        
                        else if (currentElement.equals("phase")) {
                            for (int i=0;i<Data1.size();i++)
                              { phase = new String(chars, start, length);
                           if (Data1.get(i).id == personId){
                           Data1.get(i).phase = phase;
				System.out.println("\tphase:" + phase);
                                break;
			}}}
                        else if (currentElement.equals("Level")) {
                            for (int i=0;i<Data1.size();i++)
                              {     Level =new String(chars, start, length);
                            if (Data1.get(i).id == personId){
                            Data1.get(i).Level = Level;
				System.out.println("\tLevel:" +Level );
                                break;
			}}}
                          else if (currentElement.equals("BosName")) {
                               for (int i=0;i<Data1.size();i++)
                                    {BosName =new String(chars, start, length);
                            if (Data1.get(i).id == personId){
                            Data1.get(i).BosName = BosName;
                               
				System.out.println("\tBosName:" +BosName );
			
                              break;}}}
                         else if (currentElement.equals("points")) {
                               for (int i=0;i<Data1.size();i++)
                              {points =new String(chars, start, length);
                             if (Data1.get(i).id == personId){
                            Data1.get(i).points = points;
				System.out.println("\tpoints:" +points );
                                break;
			}}
                         }

                        else if (currentElement.equals("friend_id1") ) {
                             id1 =  new String(chars, start, length);
                            System.out.print("\tID1:" +id1);
                           for(int i=0;i<Data1.size();i++){
                                if((" "+Data1.get(i).id).equals(id1))
                                {
                             System.out.print("\tName:" +Data1.get(i).User_Name);
                              System.out.print("\tPassward:" +Data1.get(i).passward);
                             System.out.print("\t phase:" +Data1.get(i).phase);
                              System.out.print("\t Level:" +Data1.get(i).Level);
                               System.out.print("\t BosName:" +Data1.get(i).BosName);
                               System.out.print("\t points:" +Data1.get(i).points);
 
                                }
                            }
                            
                      
        		System.out.println();
                              
			}else if (currentElement.equals("friend_id2")) {
                             id2=  new String(chars, start, length);
                        System.out.print("\tID2:" +id2);
                        for(int i=0;i<Data1.size();i++){
                          if((" "+Data1.get(i).id).equals(id2)){
                             System.out.print("\tName:" +Data1.get(i).User_Name);
                              System.out.print("\tPassward:" +Data1.get(i).passward);
                             System.out.print("\t phase:" +Data1.get(i).phase);
                              System.out.print("\t Level:" +Data1.get(i).Level);
                               System.out.print("\t BosName:" +Data1.get(i).BosName);
                               System.out.print("\t points:" +Data1.get(i).points);

                                 }
                        
                        }System.out.println();}
                
             
 
          } 	
}
        
        public static void Method(){
        }
        
      
        } 