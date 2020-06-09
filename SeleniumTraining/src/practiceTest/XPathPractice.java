package practiceTest;

public class XPathPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
}

/*

1. and operator
//input[@id='ctl00_mainContent_ddl_originStation1_CTXT' and @name='ctl00_mainContent_ddl_originStation1_CTXT']

2. text() function
//span[text()='Covid-19 Information']

3. contains()
//span[contains(text(),'Covid-19 Information')]

4. going to parent element to make unique
//div[@class='right1']//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']

5. Parent , descendant -all children under that node
//td[text()='Tanay Rode']//parent::tr//descendant::input[@name='id']
 
6. from parent node to all children nodes "a" tags under that "label" tags under that "input" tags
//td[text()='Tanay Rode']//a//label//input
 */


}